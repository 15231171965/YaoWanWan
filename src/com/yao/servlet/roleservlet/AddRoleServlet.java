package com.yao.servlet.roleservlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yao.dao.userdao.RoleDao;

public class AddRoleServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(req.getParameter("roleName")!=null&&req.getParameter("rolePower")!=null){
			RoleDao rd=new RoleDao();
			String roleName=req.getParameter("roleName");
			String rolePower=req.getParameter("rolePower");
			int i=0;
			try {
				i=rd.insert(roleName, rolePower);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(i==1)
				req.setAttribute("info", "添加角色成功");
			else
				req.setAttribute("info", "添加角色失败");
		}else{
			req.setAttribute("info", "添加角色失败");
		}
		req.getRequestDispatcher("/view/addRole/role_save.jsp").forward(req, resp);
		
	}
	
}
