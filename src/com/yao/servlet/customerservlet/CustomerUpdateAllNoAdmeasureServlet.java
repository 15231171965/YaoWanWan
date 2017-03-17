package com.yao.servlet.customerservlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yao.dao.customerinfodao.CustomerInfoDao;
import com.yao.dao.userdao.UserDao;
import com.yao.entity.CustomerInfo;
import com.yao.entity.UserInfo;

public class CustomerUpdateAllNoAdmeasureServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(req.getParameterValues("checkbox")==null){
			resp.sendRedirect("CustomerQueryNoAdmeasureServlet");
		}else{
			CustomerInfoDao cid=new CustomerInfoDao();
			UserDao ud=new UserDao();
			String[] c=req.getParameterValues("checkbox");
			List<CustomerInfo> list=new ArrayList<CustomerInfo>();
			List<UserInfo> userList=new ArrayList<UserInfo>();
			for (int i = 0; i < c.length; i++) {
				int j=Integer.parseInt(c[i]);//转换类型
				try {
					list.add(cid.queryById(j).get(0));//根据ID将查到的对象添加进去
					userList=ud.queryAll();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			req.setAttribute("userList", userList);
			req.setAttribute("customerInfolist", list);
			req.getRequestDispatcher("/view/customer/customer_allAdmeasure_update.jsp").forward(req, resp);
			
		}
	}
	
}
