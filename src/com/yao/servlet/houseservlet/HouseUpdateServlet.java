package com.yao.servlet.houseservlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yao.dao.housedao.HouseDao;
import com.yao.dao.housetypedao.HouseTypeDao;
import com.yao.dao.userdao.UserDao;
import com.yao.entity.HouseInfo;
import com.yao.entity.HouseType;
import com.yao.entity.UserInfo;

public class HouseUpdateServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(req.getParameter("houseId")!=null){
			HouseDao hid=new HouseDao();
			HouseTypeDao htd=new HouseTypeDao();
			UserDao ud=new UserDao();
			int id=Integer.valueOf(req.getParameter("houseId"));
			HouseInfo houseInfo=null;
			List<HouseType> tlist=null;
			List<UserInfo> ulist=null; 
			try {
				houseInfo=hid.queryById(id).get(0);
				tlist=htd.queryAll();
				ulist=ud.queryAll();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			req.setAttribute("houseInfo", houseInfo);
			req.setAttribute("tlist", tlist);
			req.setAttribute("ulist", ulist);
			req.getRequestDispatcher("/view/house/house_update.jsp").forward(req, resp);
		}
	}
	
}
