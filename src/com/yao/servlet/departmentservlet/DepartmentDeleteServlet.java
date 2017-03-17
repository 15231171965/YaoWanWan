package com.yao.servlet.departmentservlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yao.dao.userdao.DepartmentDao;

public class DepartmentDeleteServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(req.getParameter("departmentId")!=null){
			DepartmentDao dd=new DepartmentDao();
			int departmentId=Integer.valueOf(req.getParameter("departmentId"));
			int i=0;
			try {
				i=dd.delete(departmentId);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(i==1)
				req.setAttribute("info", "删除成功");
			else
				req.setAttribute("info", "删除失败");
		}else{
			req.setAttribute("info", "删除失败");
		}
		req.getRequestDispatcher("/view/department/department_save.jsp").forward(req, resp);
	}
	
}
