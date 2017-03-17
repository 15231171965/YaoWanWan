package com.yao.servlet.sourceservlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yao.dao.customerinfodao.SourceDao;

public class DeleteSourceServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(req.getParameter("id")!=null){
			SourceDao sd=new SourceDao();
			int id=Integer.valueOf(req.getParameter("id"));
			int i=0;
			try {
				i=sd.delete(id);
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
		req.getRequestDispatcher("/view/CustomerSource/CustomerSource_save.jsp").forward(req, resp);
	}
	
}
