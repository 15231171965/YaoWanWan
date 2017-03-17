package com.yao.servlet.careservlet;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yao.dao.caredao.CustomerCareDao;
import com.yao.dao.customerinfodao.CustomerInfoDao;
import com.yao.dao.userdao.UserDao;
import com.yao.entity.Care;
import com.yao.entity.CustomerInfo;
import com.yao.entity.UserInfo;

public class CustomerCareAddServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserDao ud=new UserDao();
		CustomerInfoDao cid=new CustomerInfoDao();
		List<UserInfo> ulist=new ArrayList<UserInfo>();
		List<CustomerInfo> clist=new ArrayList<CustomerInfo>();
		try {
			ulist=ud.queryAll();
			clist=cid.queryall();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.setAttribute("ulist", ulist);
		req.setAttribute("clist", clist);
		
		req.getRequestDispatcher("/view/customerCare/customerCare_add.jsp").forward(req, resp);
	}
	
}
