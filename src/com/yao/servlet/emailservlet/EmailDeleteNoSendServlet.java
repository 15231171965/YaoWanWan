package com.yao.servlet.emailservlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yao.dao.emailDao.EmailDao;

public class EmailDeleteNoSendServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(req.getParameter("emailId")!=null){
			EmailDao ed=new EmailDao();
			int eid=Integer.valueOf(req.getParameter("emailId"));
			int i=0;
			try {
				i=ed.delete(eid);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(i==1)
				req.setAttribute("info", "删除成功");
			else
				req.setAttribute("info", "删除失败");
		}
		req.getRequestDispatcher("/view/email/email_save_no_send.jsp").forward(req, resp);
	}
	
}
