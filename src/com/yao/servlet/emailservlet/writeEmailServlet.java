package com.yao.servlet.emailservlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yao.dao.customerinfodao.CustomerInfoDao;
import com.yao.dao.userdao.UserDao;
import com.yao.entity.CustomerInfo;
import com.yao.entity.UserInfo;

public class writeEmailServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CustomerInfoDao cd=new CustomerInfoDao();
		UserDao ud=new UserDao();
		List<CustomerInfo> clist=null;
		List<UserInfo> ulist=null;
		try {
			clist=cd.queryall();
			ulist=ud.queryAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.setAttribute("customerList", clist);
		req.getRequestDispatcher("/view/email/email_resend.jsp").forward(req, resp);
	}
	
}
