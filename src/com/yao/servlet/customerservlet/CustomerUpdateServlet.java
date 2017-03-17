package com.yao.servlet.customerservlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yao.dao.customerinfodao.ConditionDao;
import com.yao.dao.customerinfodao.CustomerInfoDao;
import com.yao.dao.customerinfodao.SourceDao;
import com.yao.dao.customerinfodao.TypeDao;
import com.yao.dao.userdao.UserDao;
import com.yao.entity.CustomerCondition;
import com.yao.entity.CustomerInfo;
import com.yao.entity.CustomerSource;
import com.yao.entity.CustomerType;
import com.yao.entity.UserInfo;

public class CustomerUpdateServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int a=0;
		if(req.getParameter("customerId")!=null);
			a=Integer.valueOf(req.getParameter("customerId"));
		CustomerInfoDao cid=new CustomerInfoDao();//客户信息
		UserDao ud=new UserDao();//员工
		SourceDao sd=new SourceDao();//客户来源
		ConditionDao cd=new ConditionDao();//客户状态
		TypeDao td=new TypeDao();
		List<CustomerInfo> list=null;
		List<UserInfo> ulist=null;
		List<CustomerSource> slist=null;
		List<CustomerCondition> clist=null;
		List<CustomerType> tlist=null;
		try {
			list=cid.queryById(a);
			ulist=ud.queryAll();
			slist=sd.queryall();
			clist=cd.queryall();
			tlist=td.queryall();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(list!=null&&list.size()!=0)
			req.setAttribute("customerId", list);
		if(ulist!=null&&ulist.size()!=0)
			req.setAttribute("ulist", ulist);
		if(slist!=null&&slist.size()!=0)
			req.setAttribute("slist", slist);
		if(clist!=null&&clist.size()!=0)
			req.setAttribute("clist", clist);
		if(tlist!=null&&tlist.size()!=0)
			req.setAttribute("tlist", tlist);
		req.getRequestDispatcher("/view/customer/customer_update.jsp").forward(req, resp);
	}
	
}
