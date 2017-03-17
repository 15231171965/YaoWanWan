package com.yao.servlet.linkedservlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yao.dao.customerLinkRecordDao.CustomerLinkRecordDao;
import com.yao.dao.customerinfodao.CustomerInfoDao;
import com.yao.dao.pagedao.PageDao;
import com.yao.entity.CustomerLinkrecord;
import com.yao.util.PageUtil;

public class ShowLinkRecordServlet extends HttpServlet {

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
			allsize=pd.getAll("customer_linkreord");
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
		
		CustomerLinkRecordDao clrd = new CustomerLinkRecordDao();
		List<CustomerLinkrecord> list = null;
		if (req.getParameter("whoLinkInput") == null&&req.getParameter("queryType")==null) {
			try {
				list = clrd.queryallPage(pageutil);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (list != null && list.size() != 0)
				req.setAttribute("list", list);
			else
				req.setAttribute("list", null);
		} else {
			String input = req.getParameter("whoLinkInput");
			int queryType = Integer.valueOf(req.getParameter("queryType"));
			req.setAttribute("c","c"+queryType);//设置跳转保留
			if(req.getParameter("keyWord")!=null)//如果有keyWord则设置keyWord为input
				input=req.getParameter("keyWord");
			try {
				switch (queryType) {
				case 1:
					//CustomerInfoDao cd=new CustomerInfoDao();
					//int id=cd.queryIdByName(input);
					pageutil.setAllsize(pd.getAll("customer_linkreord l,customer_info c where l.customer_id=c.customer_id and c.customer_name like '%"+input+"%'"));
					list = clrd.queryByCustomerName(input,pageutil);
					break;
				case 2:
					pageutil.setAllsize(pd.getAll("customer_linkreord where link_theme like '%"+input+"%'"));
					list=clrd.queryByTheme(input,pageutil);
					break;
				case 3:
					pageutil.setAllsize(pd.getAll("customer_linkreord where link_type like '%"+input+"%'"));
					list=clrd.queryByType(input,pageutil);
					break;
				default:
					break;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (list != null && list.size() != 0)
				req.setAttribute("list", list);
			else
				req.setAttribute("list", null);
			req.setAttribute("keyWord", input+"&&queryType="+queryType);
		}
		req.setAttribute("page", pageutil);
		req.setAttribute("requestURL","showLinkRecord");
		req.getRequestDispatcher("/view/linkman/linkrecord_list.jsp").forward(req, resp);
	}

}
