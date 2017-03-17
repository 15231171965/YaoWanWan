package com.yao.servlet.customerservlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yao.dao.customerinfodao.ConditionDao;
import com.yao.dao.customerinfodao.SourceDao;
import com.yao.dao.customerinfodao.TypeDao;
import com.yao.entity.CustomerCondition;
import com.yao.entity.CustomerSource;
import com.yao.entity.CustomerType;

public class CustomerAddServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SourceDao sd=new SourceDao();//客户来源
		ConditionDao cd=new ConditionDao();//客户状态
		TypeDao td=new TypeDao();
		List<CustomerSource> slist=null;
		List<CustomerCondition> clist=null;
		List<CustomerType> tlist=null;
		try {
			slist=sd.queryall();
			clist=cd.queryall();
			tlist=td.queryall();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.setAttribute("slist", slist);
		req.setAttribute("clist", clist);
		req.setAttribute("tlist", tlist);
		req.getRequestDispatcher("/view/customer/customer_add.jsp").forward(req, resp);
	}
	
}
