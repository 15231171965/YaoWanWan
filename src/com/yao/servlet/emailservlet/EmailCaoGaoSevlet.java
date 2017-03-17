package com.yao.servlet.emailservlet;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yao.dao.emailDao.EmailDao;
import com.yao.entity.EmailInfo;

public class EmailCaoGaoSevlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EmailDao ed=new EmailDao();
		int customerId=Integer.valueOf(req.getParameter("addressee"));//收件人
		String emailTheme=req.getParameter("emailTheme");//主题
		String emailContent=req.getParameter("emailContent");//邮件内容
		int userId=Integer.valueOf(req.getParameter("addresser"));//发件人
		Timestamp emailTime=new Timestamp(new Date().getTime());
		EmailInfo e=new EmailInfo(customerId,userId,emailContent,emailTime,emailTheme);
		int i=0;
		try {
			i=ed.caogao(e);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(i==1)
			req.setAttribute("info", "添加草稿成功");
		else
			req.setAttribute("info", "添加草稿失败");
		req.getRequestDispatcher("/view/email/email_save_no_send.jsp").forward(req, resp);
	}
	
}
