package com.yao.servlet.customerservlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yao.dao.userdao.UserDao;
import com.yao.entity.UserInfo;

public class CustomerUpNoAdmeasureServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserDao ud=new UserDao();
		List<UserInfo> list=null;//得到所有员工
		try {
			list=ud.queryAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int customerid=Integer.valueOf(req.getParameter("customerId"));
		String customerName=req.getParameter("customerName");
		System.out.println(customerName+"---------");
		req.setAttribute("list", list);
		req.setAttribute("id", customerid);
		req.setAttribute("name", customerName);
		req.getRequestDispatcher("/view/customer/customer_admeasure_update.jsp").forward(req, resp);
	}
	
}
