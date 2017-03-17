package com.yao.servlet.careservlet;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yao.dao.caredao.CustomerCareDao;
import com.yao.entity.Care;

public class CustomerCareAddServlet2 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(req.getParameter("careTheme")!=null&&req.getParameter("customerId")!=null&&req.getParameter("careNexttime")!=null
				&&req.getParameter("careWay")!=null&&req.getParameter("carePeople")!=null&&req.getParameter("careRemark")!=null){
			CustomerCareDao cd=new CustomerCareDao();
			int customerId=Integer.valueOf(req.getParameter("customerId"));
			String theme=req.getParameter("careTheme");
			String careWay=req.getParameter("careWay");
			//String nextTime=req.getParameter("careNexttime");
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Timestamp nextTime=null;
			try {
				nextTime = new Timestamp(Long.valueOf(sdf.parse(req.getParameter("careNexttime")).getTime()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String remark=req.getParameter("careRemark");
			String carePeople=req.getParameter("carePeople");
			Care c=new Care(customerId,theme,careWay,remark,nextTime,carePeople);
			int i=10;
			try {
				i = cd.insertCare(c);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(i==1)
				req.setAttribute("info", "添加成功");
			if(i==0)
				req.setAttribute("info", "添加失败");
//			System.out.println("id="+customerId);
//			System.out.println("theme="+theme);
//			System.out.println("careWay="+careWay);
//			System.out.println("nextTime="+nextTime);
//			System.out.println("remark="+remark);
//			System.out.println("carePeople="+carePeople);
		}
		req.getRequestDispatcher("/view/customerCare/customerCare_admeasure_save.jsp").forward(req, resp);
	}
	
}
