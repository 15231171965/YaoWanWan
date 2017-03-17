package com.yao.servlet.careservlet;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Timer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yao.dao.caredao.CustomerCareDao;
import com.yao.entity.Care;

public class customerRedactCareUpdateServlet2 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (req.getParameter("careTheme") != null && req.getParameter("customerId") != null
				&& req.getParameter("careNexttime") != null && req.getParameter("careWay") != null
				&& req.getParameter("carePeople") != null && req.getParameter("careRemark") != null
				&& req.getParameter("careId") != null) {
			CustomerCareDao cd=new CustomerCareDao();
			int careId = Integer.valueOf(req.getParameter("careId"));
			String careTheme = req.getParameter("careTheme");
			int customerId = Integer.valueOf(req.getParameter("customerId"));
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Timestamp careNexttime=null;
			try {
				careNexttime = new Timestamp(Long.valueOf(sdf.parse(req.getParameter("careNexttime")).getTime()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String carePeople = req.getParameter("carePeople");
			String careWay = req.getParameter("careWay");
			String careRemark = req.getParameter("careRemark");
			Care care=new Care(customerId,careTheme, careWay, careRemark, careNexttime,
					carePeople ,careId);
			int i=10;
			try {
				i = cd.updateCare(care);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("i="+i);
			HttpSession session=req.getSession();
			if(i==1){
				session.setAttribute("careupdate", "ok");
			}else{
				session.setAttribute("careupdate", "false");
			}
			req.getRequestDispatcher("customerRedactCareUpdateServlet?careId="+careId).forward(req, resp);
		}
	}

}
