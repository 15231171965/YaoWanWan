package com.yao.servlet.emailservlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yao.dao.customerinfodao.CustomerInfoDao;
import com.yao.dao.emailDao.EmailDao;
import com.yao.dao.pagedao.PageDao;
import com.yao.entity.EmailInfo;
import com.yao.entity.UserInfo;
import com.yao.util.PageUtil;

public class EmailQueryServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserInfo userinfo = (UserInfo) req.getSession().getAttribute("userInfo");
		EmailDao ed = new EmailDao();
		int userId = userinfo.getUser_id();
		List<EmailInfo> list = new ArrayList<EmailInfo>();
		
		PageDao pd=new PageDao();//创建pageDao用来查allsize
		int allsize=0;//设置初始allsize
		try {
			allsize=pd.getAll("email_info where user_id="+userId+" and email_state='1'");
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

		if (req.getParameter("emailInput") == null && req.getParameter("queryType") == null) {
			try {
				System.out.println(1);
				list = ed.queryAllByFa(userId,pageutil);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			String emailInput = req.getParameter("emailInput");
			if(req.getParameter("keyWord")!=null)//如果有keyWord则设置keyWord为input
				emailInput=req.getParameter("keyWord");
			int queryType = Integer.valueOf(req.getParameter("queryType"));
			req.setAttribute("qid", "q"+queryType);
			try {
				switch (queryType) {
				case 1:
					CustomerInfoDao cd=new CustomerInfoDao();
					int cid=cd.queryIdByName(emailInput);
					pageutil.setAllsize(pd.getAll("email_info where user_id="+userId+" and email_state='1' and customer_id="+cid));
					list = ed.queryByShouJianRen(userId, emailInput,pageutil);
					break;
				case 3:
					pageutil.setAllsize(pd.getAll("email_info where user_id="+userId+" and email_state='1' and email_content='"+emailInput+"'"));
					list = ed.queryByNeiRong(userId, emailInput);
					break;
				case 4:
					pageutil.setAllsize(pd.getAll("email_info where user_id="+userId+" and email_state='1' and email_theme='"+emailInput+"'"));
					list = ed.queryByTheme(userId, emailInput);
					break;
				default:
					break;
				}
			} catch (SQLException e) {
				// TODO: handle exception
			}
			req.setAttribute("keyWord", emailInput+"&&queryType="+queryType);
		}
		if (list!=null&&list.size() > 0)
			req.setAttribute("EmailInfos", list);
		else
			req.setAttribute("EmailInfos", null);
		req.setAttribute("page", pageutil);
		req.setAttribute("requestURL","EmailQueryServlet");
		req.getRequestDispatcher("/view/email/email_outbox.jsp").forward(req, resp);

	}

}
