package com.yao.servlet.linkedservlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yao.dao.customerinfodao.CustomerInfoDao;
import com.yao.dao.customerlinkmandao.LinkManDao;
import com.yao.dao.pagedao.PageDao;
import com.yao.entity.CustomerLinkman;
import com.yao.util.PageUtil;

public class ShowLinkServlet extends HttpServlet{

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
			allsize=pd.getAll("customer_linkman");
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
		
		LinkManDao lmd=new LinkManDao();
		List<CustomerLinkman> list=null;
		if(req.getParameter("LinkmanInput")==null&&req.getParameter("queryType")==null){
			try {
				list=lmd.queryAllPage(pageutil);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(list!=null&&list.size()!=0)
				req.setAttribute("list", list);
			else
				req.setAttribute("list", null);
		}else{
			String input=req.getParameter("LinkmanInput");
			if(req.getParameter("keyWord")!=null)//如果有keyWord则设置keyWord为input
				input=req.getParameter("keyWord");
			int queryType=Integer.valueOf(req.getParameter("queryType"));
			req.setAttribute("q", "q"+queryType);
			try {
				switch (queryType) {
				case 1:
					pageutil.setAllsize(pd.getAll("customer_linkman where linkman_name like '%" + input + "%'"));
					list=lmd.queryByLinkManName(input,pageutil);
					break;
				case 2:
					//CustomerInfoDao cid = new CustomerInfoDao();
					//int customer_id = cid.queryIdByName(input);
					pageutil.setAllsize(pd.getAll("customer_linkman l,customer_info c where l.customer_id=c.customer_id and c.customer_name like '%"+input+"%'"));
					list=lmd.queryByCustomerName(input,pageutil);
					break;
				default:
					break;
				}
			} catch (SQLException e) {
				// TODO: handle exception
			}
			if(list!=null&&list.size()!=0)
				req.setAttribute("list", list);
			else
				req.setAttribute("list", null);
			req.setAttribute("keyWord", input+"&&queryType="+queryType);
		}
		req.setAttribute("page", pageutil);
		req.setAttribute("requestURL","LinkManQueryServlet");
		req.getRequestDispatcher("/view/linkman/linkman_list.jsp").forward(req, resp);
	}
	
}
