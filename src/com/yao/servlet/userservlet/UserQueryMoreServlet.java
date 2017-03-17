package com.yao.servlet.userservlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yao.dao.userdao.UserDao;
import com.yao.entity.UserInfo;

public class UserQueryMoreServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(req.getParameter("id")!=null){
			int id=Integer.valueOf(req.getParameter("id"));
			UserDao ud=new UserDao();
			List<UserInfo> list=null;
			try {
				list=ud.queryById(id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(list!=null&&list.size()!=0)
				req.setAttribute("userinfo", list.get(0));
			else
				req.setAttribute("userinfo", null);
			req.getRequestDispatcher("/view/user/user_more.jsp").forward(req, resp);
		}
	}
	
}
