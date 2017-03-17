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
import com.yao.dao.userdao.UserDao;
import com.yao.entity.DepartmentInfo;
import com.yao.entity.UserInfo;
import com.yao.entity.UserRole;

public class UserUpdateServlet extends HttpServlet{

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
			DepartmentDao dd=new DepartmentDao();
			RoleDao rd=new RoleDao();
			int id=Integer.valueOf(req.getParameter("id"));
			List<UserInfo> list=null;
			List<DepartmentInfo> dlist=null;
			List<UserRole> rlist=null;
			try {
				list=ud.queryById(id);
				dlist=dd.queryAll();
				rlist=rd.queryAll();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(list!=null&&list.size()!=0&&dlist!=null&&dlist.size()!=0&&rlist!=null&&rlist.size()!=0){
				req.setAttribute("Iduser", list.get(0));
				req.setAttribute("departmentNameId", dlist);
				req.setAttribute("roleInfoNameId", rlist);
			}
			else{
				req.setAttribute("Iduser", null);
				req.setAttribute("departmentNameId", null);
				req.setAttribute("roleInfoNameId", null);
			}
			req.getRequestDispatcher("/view/user/user_update.jsp").forward(req, resp);
		}
	}
	
}
