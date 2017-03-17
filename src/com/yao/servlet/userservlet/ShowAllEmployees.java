package com.yao.servlet.userservlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yao.dao.pagedao.PageDao;
import com.yao.dao.userdao.DepartmentDao;
import com.yao.dao.userdao.RoleDao;
import com.yao.dao.userdao.UserDao;
import com.yao.entity.UserInfo;
import com.yao.util.PageUtil;

public class ShowAllEmployees extends HttpServlet{

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
			allsize=pd.getAll("user_info");
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
		
		UserDao ud=new UserDao();
		List<UserInfo> list=null;
		if(req.getParameter("input")==null&&req.getParameter("queryType")==null){
			try {
				list=ud.queryAllPage(pageutil);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(list!=null&&list.size()!=0)
				req.setAttribute("list", list);
			else
				req.setAttribute("list", null);
		}else {
			String input=req.getParameter("input");
			int queryType=Integer.valueOf(req.getParameter("queryType"));
			req.setAttribute("q", "q"+queryType);
			if(req.getParameter("keyWord")!=null&&req.getParameter("keyWord")!="")//如果有keyWord则设置keyWord为input
				input=req.getParameter("keyWord");
			System.out.println(queryType+"aaa");
			System.out.println(input+"bbb");
			try {
				switch (queryType) {
				case 1:
					pageutil.setAllsize(pd.getAll("user_info where user_name like '%"+input+"%'"));
					list=ud.queryByUserName(input,pageutil);
					break;
				case 2:
					DepartmentDao dd=new DepartmentDao();
					int department_id=dd.queryIdByName(input);
					pageutil.setAllsize(pd.getAll("user_info where department_id="+department_id));
					list=ud.queryByDepartmentName(input,pageutil);
					break;
				case 3:
					RoleDao rd=new RoleDao();
					int role_id=rd.queryIdByName(input);
					pageutil.setAllsize(pd.getAll("user_info where role_id="+role_id));
					list=ud.queryByRoleName(input,pageutil);
					break;
				case 4:
					pageutil.setAllsize(pd.getAll("user_info where user_diploma like '%"+input+"%'"));
					list=ud.queryByDiploma(input,pageutil);
					break;
				default:
					break;
				}
			} catch (SQLException e) {
				// TODO: handle exception
			}
			req.setAttribute("keyWord", input+"&&queryType="+queryType);
			req.setAttribute("list", list);
		}
		req.setAttribute("page", pageutil);
		req.setAttribute("requestURL","ShowAllEmployees");
		req.getRequestDispatcher("/view/user/user_list.jsp").forward(req, resp);
	}	
}
