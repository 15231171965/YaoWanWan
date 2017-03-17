package com.yao.servlet.sourceservlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yao.dao.customerinfodao.SourceDao;
import com.yao.entity.CustomerSource;

public class AddSourceServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(req.getParameter("sname")!=null){
			SourceDao sd=new SourceDao();
			String sname=req.getParameter("sname");
			CustomerSource cs=new CustomerSource();
			cs.setSource_name(sname);
			int i=0;
			try {
				i=sd.insert(cs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(i==1)
				req.setAttribute("signal","添加成功");
			else
				req.setAttribute("signal", "添加失败");
		}else{
			req.setAttribute("signal", "添加失败");
		}
		req.getRequestDispatcher("/view/CustomerSource/CustomerSource_save.jsp").forward(req, resp);
	}
	
}
