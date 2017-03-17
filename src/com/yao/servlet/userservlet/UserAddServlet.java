package com.yao.servlet.userservlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yao.dao.userdao.DepartmentDao;
import com.yao.dao.userdao.RoleDao;
import com.yao.entity.DepartmentInfo;
import com.yao.entity.UserInfo;
import com.yao.entity.UserRole;

public class UserAddServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DepartmentDao dd=new DepartmentDao();
		RoleDao rd=new RoleDao();
		List<DepartmentInfo> dlist=null;
		List<UserRole> rlist=null;
		try {
			dlist=dd.queryAll();
			rlist=rd.queryAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(dlist!=null&&dlist.size()>0&&rlist!=null&&rlist.size()>0){
			req.setAttribute("DepartmentInfos", dlist);
			req.setAttribute("RoleInfos", rlist);
		}else{
			req.setAttribute("DepartmentInfos", null);
			req.setAttribute("RoleInfos", null);
		}
		req.getRequestDispatcher("/view/user/user_add.jsp").forward(req, resp);
	}
	
}
