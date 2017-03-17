package com.yao.servlet.loginservlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yao.dao.userdao.UserDao;
import com.yao.entity.UserInfo;

public class LoginServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserDao ud=new UserDao();
		String name=req.getParameter("userNum");
		String pwd=req.getParameter("userPw");
		List<UserInfo> list=null;
		try {
			list=ud.queryByNamePwd(name, pwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(list==null||list.size()==0){
			resp.sendRedirect("login.jsp");
		}else{
			HttpSession session=req.getSession();
			session.setAttribute("userInfo", list.get(0));
			req.getRequestDispatcher("/view/frame/main.jsp").forward(req, resp);
		}
		
	}
	
}
