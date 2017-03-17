package com.yao.servlet.linkedservlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yao.dao.customerlinkmandao.LinkManDao;

public class DeleteLinkManServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(req.getParameter("linkManId")!=null){
			int id=Integer.valueOf(req.getParameter("linkManId"));
			LinkManDao lmd=new LinkManDao();
			int i=0;
			try {
				i=lmd.delete(id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(i==1)
				req.setAttribute("signal", "删除成功");
			else
				req.setAttribute("signal", "删除失败");
		}else{
			req.setAttribute("signal", "删除失败");
		}
		req.getRequestDispatcher("/view/linkman/linkman_save.jsp").forward(req, resp);
	}
	
}
