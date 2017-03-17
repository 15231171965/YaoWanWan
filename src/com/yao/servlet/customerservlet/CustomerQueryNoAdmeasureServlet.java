package com.yao.servlet.customerservlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yao.dao.customerinfodao.CustomerInfoDao;
import com.yao.dao.pagedao.PageDao;
import com.yao.entity.CustomerInfo;
import com.yao.util.PageUtil;

public class CustomerQueryNoAdmeasureServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PageDao pd=new PageDao();//创建pageDao用来查allsize
		int allsize=0;//设置初始allsize
		try {
			allsize=pd.getAll("customer_info where user_id is null");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int page=1;//初始化page
		if(req.getParameter("currentPage")==null)
			page=1;
		else
			page=Integer.valueOf(req.getParameter("currentPage"));
		
		PageUtil pageutil=new PageUtil();//创建page对象
		pageutil.setAllsize(allsize);//设置初始allsize
		pageutil.setCurrentpage(page);//设置当前页面
		
		CustomerInfoDao cid=new CustomerInfoDao();
		List<CustomerInfo> list=null;
		try {
			list=cid.queryAllUnallocated(pageutil);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//查所有未分配的客户
		if(list!=null&&list.size()!=0)
			req.setAttribute("list", list);
		else
			req.setAttribute("list", null);
		
		req.setAttribute("page", pageutil);
		req.setAttribute("requestURL","CustomerQueryNoAdmeasureServlet");
		req.getRequestDispatcher("/view/customer/customer_admeasure.jsp").forward(req, resp);
	}
	
}
