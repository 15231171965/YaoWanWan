package com.yao.servlet.customerservlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yao.dao.customerinfodao.CustomerInfoDao;

public class CustomerUpdateNoAdmeasureServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CustomerInfoDao cid=new CustomerInfoDao();
		int customerId=Integer.parseInt(req.getParameter("customerId"));//得到客户ID
		int userId=Integer.parseInt(req.getParameter("customerForUser"));
		int i=10;
		try {
			i = cid.updateUnallocated(customerId, userId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(i==1)
			req.setAttribute("info", "更新成功");
		if(i==0)
			req.setAttribute("info", "更新失败");
		req.getRequestDispatcher("/view/customer/customer_admeasure_save.jsp").forward(req, resp);
		
	}
}
