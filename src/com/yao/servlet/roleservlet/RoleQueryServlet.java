package com.yao.servlet.roleservlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yao.dao.pagedao.PageDao;
import com.yao.dao.userdao.RoleDao;
import com.yao.entity.UserRole;
import com.yao.util.PageUtil;

public class RoleQueryServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PageDao pd=new PageDao();//创建pageDao用来查allsize
		int allsize=0;//设置初始allsize
		try {
			allsize=pd.getAll("user_role");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int page=1;//初始化page
		if(req.getParameter("currentPage")==null)
			page=1;
		else
			page=Integer.valueOf(req.getParameter("currentPage"));
		PageUtil pageutil=new PageUtil();//创建page对象
		pageutil.setAllsize(allsize);//设置初始allsize
		pageutil.setCurrentpage(page);//设置当前页面
		
		RoleDao rd=new RoleDao();
		List<UserRole> list=null;
		if(req.getParameter("roleName")==null&&req.getParameter("queryType")==null&&req.getParameter("keyWord")==null){
			try {
				list=rd.queryAllPage(pageutil);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(list!=null&&list.size()!=0)
				req.setAttribute("list", list);
			else
				req.setAttribute("list", null);
		}else{
			String roleName=req.getParameter("roleName");
			if(req.getParameter("keyWord")!=null)//如果有keyWord则设置keyWord为input
				roleName=req.getParameter("keyWord");
			try {
				pageutil.setAllsize(pd.getAll("user_role where role_name like '%"+roleName+"%'"));
				list=rd.queryByName(roleName,pageutil);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(list!=null&&list.size()!=0)
				req.setAttribute("list", list);
			else
				req.setAttribute("list", null);
			req.setAttribute("keyWord", roleName+"&&queryType=");
		}
		req.setAttribute("page", pageutil);
		req.setAttribute("requestURL","RoleQueryServlet");
		req.getRequestDispatcher("/view/addRole/role_list.jsp").forward(req, resp);
	}
	
}
