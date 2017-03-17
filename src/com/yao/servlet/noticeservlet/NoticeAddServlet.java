package com.yao.servlet.noticeservlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yao.dao.userdao.UserDao;
import com.yao.entity.UserInfo;

public class NoticeAddServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserDao ud=new UserDao();
		List<UserInfo> list=null;
		try {
			list=ud.queryAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(list!=null&&list.size()!=0)
			req.setAttribute("userInfoList", list);
		else
			req.setAttribute("userInfoList", null);
		req.getRequestDispatcher("/view/notice/notice_add.jsp").forward(req, resp);
	}
	
}
