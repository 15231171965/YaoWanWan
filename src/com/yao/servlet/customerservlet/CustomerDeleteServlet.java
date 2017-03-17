package com.yao.servlet.customerservlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yao.dao.customerinfodao.ConditionDao;
import com.yao.dao.customerinfodao.CustomerInfoDao;
import com.yao.entity.CustomerInfo;

public class CustomerDeleteServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id=Integer.valueOf(req.getParameter("customerId"));
		CustomerInfoDao cid=new CustomerInfoDao();
		int i=10;
		try {
			i = cid.delete(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpSession s=req.getSession();
		if(i==1){
			s.setAttribute("delSignal", "ok");
			resp.sendRedirect("CustomerQueryServlet");
		}else{
			s.setAttribute("delSignal", "false");
			resp.sendRedirect("CustomerQueryServlet");
		}
	}	
	
}