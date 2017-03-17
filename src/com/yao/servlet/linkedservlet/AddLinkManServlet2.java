package com.yao.servlet.linkedservlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yao.dao.customerinfodao.CustomerInfoDao;
import com.yao.dao.customerlinkmandao.LinkManDao;
import com.yao.entity.CustomerLinkman;

public class AddLinkManServlet2 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (req.getParameter("CustomerName") != null && req.getParameter("linkManAge") != null
				&& req.getParameter("linkManMobile") != null && req.getParameter("linkManName") != null
				&& req.getParameter("linkManJob") != null && req.getParameter("linkManRelation") != null
				&& req.getParameter("linkManSex") != null) {
			LinkManDao lmd=new LinkManDao();
			int CustomerId = Integer.valueOf(req.getParameter("CustomerName"));
			String linkManName = req.getParameter("linkManName");
			String linkManSex = req.getParameter("linkManSex");
			int linkManAge = Integer.valueOf(req.getParameter("linkManAge"));
			String linkManJob = req.getParameter("linkManJob");
			String linkManMobile = req.getParameter("linkManMobile");
			String linkManRelation = req.getParameter("linkManRelation");
			CustomerLinkman c=new CustomerLinkman(CustomerId,linkManName,linkManSex
							,linkManJob,linkManMobile,linkManAge,linkManRelation);
			int i=0;
			try {
				i=lmd.insert(c);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(i==1)
				req.setAttribute("signal", "添加成功");
			else
				req.setAttribute("signal", "添加失败");
		}else{
			req.setAttribute("signal", "添加失败");
		}
		req.getRequestDispatcher("/view/linkman/linkman_save.jsp").forward(req, resp);
	}

}
