package com.yao.servlet.linkedservlet;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yao.dao.customerLinkRecordDao.CustomerLinkRecordDao;
import com.yao.entity.CustomerLinkrecord;

public class AddLinkRecordServlet2 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (req.getParameter("customerId") != null && req.getParameter("linkTime") != null && req.getParameter("linkNexttime") != null
				&& req.getParameter("linkType") != null && req.getParameter("whoLink") != null && req.getParameter("linkTheme") != null
				&& req.getParameter("linkRemark") != null) {
			CustomerLinkRecordDao clrd=new CustomerLinkRecordDao(); 
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			int id = Integer.valueOf(req.getParameter("customerId"));
			Timestamp linktime = null;
			Timestamp nextTime = null;
			try {
				linktime = new Timestamp(sdf.parse(req.getParameter("linkTime")).getTime());
				nextTime = new Timestamp(sdf.parse(req.getParameter("linkNexttime")).getTime());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String linkType = req.getParameter("linkType");
			String whoLink = req.getParameter("whoLink");
			String linkTheme = req.getParameter("linkTheme");
			String linkRemark=req.getParameter("linkRemark");
			CustomerLinkrecord cl=new CustomerLinkrecord(id,linktime,whoLink,linkType,linkTheme,nextTime,linkRemark);
			int i=0;
			try {
				i=clrd.insert(cl);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(i==1)
				req.setAttribute("signal", "添加成功");
			else
				req.setAttribute("signal", "添加失败");
		}else{
			req.setAttribute("signal", "添加失败");
		}
		req.getRequestDispatcher("/view/linkman/linkrecord_save.jsp").forward(req, resp);
	}

}
