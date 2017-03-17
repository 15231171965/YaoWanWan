package com.yao.servlet.houseservlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yao.dao.housedao.HouseDao;
import com.yao.entity.HouseInfo;

public class HouseAddServlet2 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (req.getParameter("houseType") != null && req.getParameter("houseAddress") != null
				&& req.getParameter("userName") != null && req.getParameter("housePrice") != null
				&& req.getParameter("houseAmbient") != null) {
			HouseDao hd=new HouseDao();
			int houseType = Integer.valueOf(req.getParameter("houseType"));
			String houseAddress = req.getParameter("houseAddress");
			int userid = Integer.valueOf(req.getParameter("userName"));
			int housePrice = Integer.valueOf(req.getParameter("housePrice"));
			String houseAmbient = req.getParameter("houseAmbient");
			HouseInfo h=new HouseInfo(houseType,userid,houseAddress,housePrice,houseAmbient);
			int i=0;
			try {
				i=hd.insert(h);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(i==1)
				req.setAttribute("signal", "添加成功");
			else
				req.setAttribute("signal", "添加失败");
			req.getRequestDispatcher("/view/house/house_save.jsp").forward(req, resp);
		}
	}

}
