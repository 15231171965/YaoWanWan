package com.yao.servlet.customerservlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yao.dao.customerinfodao.ConditionDao;
import com.yao.dao.customerinfodao.CustomerInfoDao;
import com.yao.entity.CustomerInfo;

public class CustomerQueryMoreServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id=Integer.valueOf(req.getParameter("customerId"));
		System.out.println(id);
		System.out.println("----------");
		CustomerInfoDao cd=new CustomerInfoDao();
		List<CustomerInfo> list = null;
		try {
			list = cd.queryById(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(list!=null&&list.size()!=0){
			req.setAttribute("CustomerInfo", list.get(0));
		}
		
		req.getRequestDispatcher("/view/customer/customer_more.jsp").forward(req, resp);
	}
	
}
