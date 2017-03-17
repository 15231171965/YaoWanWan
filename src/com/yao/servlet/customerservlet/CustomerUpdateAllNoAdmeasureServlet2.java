package com.yao.servlet.customerservlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yao.dao.customerinfodao.CustomerInfoDao;

public class CustomerUpdateAllNoAdmeasureServlet2 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CustomerInfoDao cdao=new CustomerInfoDao();
		String [] c=req.getParameterValues("customerId");
		int uid=Integer.parseInt(req.getParameter("customerForUser"));
		int num=0;//计数
		for(int i=0;i<c.length;i++){
			int j=Integer.parseInt(c[i]);
			try {
				num+=cdao.updateUnallocated(j, uid);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(num==c.length)
			req.setAttribute("info", "更新成功");
		else
			req.setAttribute("info", "更新失败");
		req.getRequestDispatcher("/view/customer/customer_admeasure_save.jsp").forward(req, resp);
	}
	
}
