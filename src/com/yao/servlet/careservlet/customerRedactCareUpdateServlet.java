package com.yao.servlet.careservlet;

import java.io.IOException;
import java.sql.SQLException;
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

public class customerRedactCareUpdateServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int careId=Integer.valueOf(req.getParameter("careId"));//得到ID
		CustomerCareDao cd=new CustomerCareDao();
		CustomerInfoDao cid=new CustomerInfoDao();
		UserDao ud=new UserDao();
		Care care=null;
		List<CustomerInfo> clist=null;
		List<UserInfo> ulist=null;
		try {
			care=cd.queryById(careId);
			clist=cid.queryall();
			ulist=ud.queryAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(care!=null)
			req.setAttribute("CustomerCare", care);
		if(clist!=null)
			req.setAttribute("allName", clist);
		if(ulist!=null)
			req.setAttribute("AllUserName", ulist);
		
		
		req.getRequestDispatcher("/view/customerCare/customerCare_update.jsp").forward(req, resp);
	}
	
}
