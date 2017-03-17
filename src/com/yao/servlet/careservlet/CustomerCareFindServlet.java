package com.yao.servlet.careservlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yao.dao.caredao.CustomerCareDao;
import com.yao.dao.customerinfodao.CustomerInfoDao;
import com.yao.dao.pagedao.PageDao;
import com.yao.entity.Care;
import com.yao.util.PageUtil;

public class CustomerCareFindServlet extends HttpServlet{

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
			allsize=pd.getAll("customer_care");
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
		CustomerCareDao cd=new CustomerCareDao();
		List<Care> list=new ArrayList<Care>();
		if(req.getParameter("customerInput")!=null&&req.getParameter("queryType")!=null||req.getParameter("keyWord")!=null&&req.getParameter("keyWord")!=""){
			String input="";									//因为超链接，所有如果没有queryType只有keyWord也可以进来
			int i=1;
			input=req.getParameter("customerInput");
			if(req.getParameter("queryType")!=null)
				i=Integer.parseInt(req.getParameter("queryType"));// 得到查询的方式

			if(req.getParameter("keyWord")!=null)//如果有keyWord则设置keyWord为input
				input=req.getParameter("keyWord");
			try {
				switch (i) {//每一项都要重新设置allsize
				case 1:
					pageutil.setAllsize(pd.getAll("customer_care a,customer_info b where a.customer_id=b.customer_id and b.customer_name like '%"+input+"%'"));
					list=cd.queryByCustomerName(input,pageutil);
					break;
				case 2:
					pageutil.setAllsize(pd.getAll("customer_care where care_theme like '%"+input+"%'"));
					list=cd.queryByTheme(input,pageutil);
					break;
				case 3:
					pageutil.setAllsize(pd.getAll("customer_care where care_way like '%"+input+"%'"));
					list=cd.queryByCareWay(input,pageutil);
				default:
					break;
				}
			} catch (SQLException e) {
				// TODO: handle exception
			}
			//如果input不是空，说明用户进行了条件查询，keyWord保存条件
			req.setAttribute("keyWord", input+"&&queryType="+i);
			req.setAttribute("c", "c"+i);
		}else{
			try {
				list=cd.queryall(pageutil);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		req.setAttribute("page", pageutil);
		req.setAttribute("requestURL","CustomerCareFindServlet");
		req.setAttribute("list", list);
		req.getRequestDispatcher("/view/customerCare/customerCare_list.jsp").forward(req, resp);
	}
	
}
