package com.yao.servlet.linkedservlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yao.dao.customerlinkmandao.LinkManDao;
import com.yao.entity.CustomerLinkman;

public class LinkManUpdateServlet2 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (req.getParameter("linkManId") != null && req.getParameter("CustomerId") != null
				&& req.getParameter("linkManMobile") != null && req.getParameter("linkManName") != null
				&& req.getParameter("linkManAge") != null && req.getParameter("linkManRelation") != null
				&& req.getParameter("LinkManSex") != null && req.getParameter("linkManJob") != null) {
			int linkManId = Integer.valueOf(req.getParameter("linkManId"));
			int CustomerId = Integer.valueOf(req.getParameter("CustomerId"));
			String linkManName = req.getParameter("linkManName");
			String LinkManSex = req.getParameter("LinkManSex");
			int linkManAge = Integer.valueOf(req.getParameter("linkManAge"));
			String linkManJob = req.getParameter("linkManJob");
			String linkManMobile = req.getParameter("linkManMobile");
			String linkManRelation = req.getParameter("linkManRelation");
			CustomerLinkman cl=new CustomerLinkman(linkManId,CustomerId,linkManName,LinkManSex
					,linkManJob,linkManMobile,linkManAge,linkManRelation);
			LinkManDao lmd=new LinkManDao();
			int i=0;
			try {
				i=lmd.update(cl);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(i==1)
				req.setAttribute("signal", "修改成功");
			else
				req.setAttribute("signal", "修改失败");
		}else{
			req.setAttribute("signal", "修改失败");
		}
		req.getRequestDispatcher("/view/linkman/linkman_save.jsp").forward(req, resp);
	}

}
