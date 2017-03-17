package com.yao.servlet.departmentservlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yao.dao.pagedao.PageDao;
import com.yao.dao.userdao.DepartmentDao;
import com.yao.entity.DepartmentInfo;
import com.yao.util.PageUtil;

public class DepartmentQueryServlet extends HttpServlet{

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
			allsize=pd.getAll("department_info");
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
		
		DepartmentDao dd=new DepartmentDao();
		List<DepartmentInfo> list=null;
		if(req.getParameter("departmentName")==null&&req.getParameter("queryType")==null&&req.getParameter("keyWord")==null){
			try {
				list=dd.queryAllPage(pageutil);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(list!=null&&list.size()!=0)
				req.setAttribute("list", list);
			else
				req.setAttribute("list", null);
		}else{
			String departmentName=req.getParameter("departmentName");
			if(req.getParameter("keyWord")!=null)//如果有keyWord则设置keyWord为input
				departmentName=req.getParameter("keyWord");
			try {
				pageutil.setAllsize(pd.getAll("department_info where department_name like '%"+departmentName+"%'"));
				list=dd.queryByName(departmentName,pageutil);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(list!=null&&list.size()!=0)
				req.setAttribute("list", list);
			else
				req.setAttribute("list", null);
			req.setAttribute("keyWord", departmentName+"&&queryType=");
		}
		req.setAttribute("page", pageutil);
		req.setAttribute("requestURL","DepartmentQueryServlet");
		req.getRequestDispatcher("/view/department/department_list.jsp").forward(req, resp);
	}
	
}
