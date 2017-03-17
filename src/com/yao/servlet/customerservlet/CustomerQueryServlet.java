package com.yao.servlet.customerservlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yao.dao.customerinfodao.ConditionDao;
import com.yao.dao.customerinfodao.CustomerInfoDao;
import com.yao.dao.customerinfodao.SourceDao;
import com.yao.dao.customerinfodao.TypeDao;
import com.yao.dao.pagedao.PageDao;
import com.yao.dao.userdao.UserDao;
import com.yao.entity.CustomerInfo;
import com.yao.util.PageUtil;

public class CustomerQueryServlet extends HttpServlet{

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
			allsize=pd.getAll("customer_info");
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
		List<CustomerInfo> list=new ArrayList<CustomerInfo>();
		if(req.getParameter("queryType")!=null&&req.getParameter("Input")!=null||req.getParameter("keyWord")!=null&&req.getParameter("keyWord")!=""){
			int i=0;
			String s="";
			i=Integer.valueOf(req.getParameter("queryType"));
			s=req.getParameter("Input");
			if(req.getParameter("keyWord")!=null)//如果有keyWord则设置keyWord为input
				s=req.getParameter("keyWord");
			try {
				switch (i) {
				case 1:
					pageutil.setAllsize(pd.getAll("customer_info where customer_name like '%"+s+"%'"));
					list=cid.queryByNamePage(s, pageutil);
					break;
				case 2:
					ConditionDao cd=new ConditionDao();
					int conditionid=cd.queryIdByName(s);
					pageutil.setAllsize(pd.getAll("customer_info where condition_id="+conditionid));
					list=cid.queryByStatus(s,pageutil);
					break;
				case 3:
					SourceDao sd=new SourceDao();
					int source_id=sd.queryIdByName(s);
					pageutil.setAllsize(pd.getAll("customer_info where source_id="+source_id));
					list=cid.queryBySource(s,pageutil);
					break;
				case 4:
					TypeDao td=new TypeDao();
					int type_id=td.queryIdByName(s);
					pageutil.setAllsize(pd.getAll("customer_info where type_id="+type_id));
					list=cid.queryByType(s,pageutil);
					break;
				case 5:
					pageutil.setAllsize(pd.getAll("customer_info c ,user_info u where c.user_id=u.user_id and u.user_name like '%"+s+"%'"));
					list=cid.queryByUser(s,pageutil);
					break;
				case 6:
					pageutil.setAllsize(pd.getAll("customer_info where customer_company like '%"+s+"%'"));
					list=cid.queryByCompany(s,pageutil);
					break;
				default:
					break;
				}
			} catch (SQLException e) {
				// TODO: handle exception
			}
			req.setAttribute("keyWord", s+"&&queryType="+i);
			req.setAttribute("c", "c"+i);
		}else{
			try {
				list=cid.queryallPage(pageutil);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		req.setAttribute("page", pageutil);
		req.setAttribute("requestURL","CustomerQueryServlet");
		req.setAttribute("list", list);
		req.getRequestDispatcher("/view/customer/customer_list.jsp").forward(req, resp);
	}
	
}
