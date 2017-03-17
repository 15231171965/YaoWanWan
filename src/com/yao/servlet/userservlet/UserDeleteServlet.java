package com.yao.servlet.userservlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yao.dao.userdao.UserDao;
import com.yao.entity.UserInfo;

public class UserDeleteServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(req.getParameter("id")!=null){
			UserDao ud=new UserDao();
			int id=Integer.valueOf(req.getParameter("id"));
			UserInfo user=null;
			try {
				user=ud.queryById(id).get(0);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			int rid=user.getRole_id();
			int i=0;
			if(rid!=3){
				try {
					i=ud.deleteUser(id);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(i==1)
					req.setAttribute("info", "删除成功");
				else
					req.setAttribute("info", "删除失败");
			}else{
				req.setAttribute("info", "删除失败");
			}
		}else{
			req.setAttribute("info", "删除失败");
		}
		req.getRequestDispatcher("/view/user/user_save.jsp").forward(req, resp);
	}
	
}
