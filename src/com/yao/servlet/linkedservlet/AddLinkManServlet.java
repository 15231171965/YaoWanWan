package com.yao.servlet.linkedservlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yao.dao.customerinfodao.CustomerInfoDao;
import com.yao.entity.CustomerInfo;

public class AddLinkManServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CustomerInfoDao cid=new CustomerInfoDao();
		List<CustomerInfo> list=null;
		try {
			list=cid.queryall();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(list!=null&&list.size()!=0)
			req.setAttribute("customerList", list);
		else
			req.setAttribute("customerList", null);
		req.getRequestDispatcher("/view/linkman/linkman_add.jsp").forward(req, resp);
	}
	
}
