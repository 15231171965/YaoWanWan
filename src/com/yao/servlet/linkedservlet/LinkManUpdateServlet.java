package com.yao.servlet.linkedservlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yao.dao.customerinfodao.CustomerInfoDao;
import com.yao.dao.customerlinkmandao.LinkManDao;
import com.yao.entity.CustomerInfo;
import com.yao.entity.CustomerLinkman;

public class LinkManUpdateServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(req.getParameter("linkManId")!=null){
			CustomerInfoDao cid=new CustomerInfoDao();
			List<CustomerInfo> list=null;//发送一个客户集合
			try {
				list=cid.queryall();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(list!=null&&list.size()!=0)
				req.setAttribute("customerList", list);
			else
				req.setAttribute("customerList", null);
			LinkManDao lmd=new LinkManDao();
			int id=Integer.valueOf(req.getParameter("linkManId"));
			CustomerLinkman c=null;
			try {
				c=lmd.queryById(id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(c!=null)
				req.setAttribute("linkman", c);
			else
				req.setAttribute("linkman", null);
		}else{
			req.setAttribute("linkman", null);
		}
		req.getRequestDispatcher("/view/linkman/linkman_update.jsp").forward(req, resp);
	}
	
}
