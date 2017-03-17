package com.yao.servlet.workqueryservlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yao.dao.caredao.CustomerCareDao;
import com.yao.dao.customerLinkRecordDao.CustomerLinkRecordDao;
import com.yao.dao.customerinfodao.CustomerInfoDao;
import com.yao.dao.noticeinfodao.NoticeInfoDao;
import com.yao.entity.*;

public class WorkQueryServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int care = 1;
		int link = 1;
		int birthday = 1;
		if (req.getParameter("care") != null)
			care = Integer.valueOf(req.getParameter("care"));
		if (req.getParameter("link") != null)
			link = Integer.valueOf(req.getParameter("link"));
		if (req.getParameter("birthday") != null)
			birthday = Integer.valueOf(req.getParameter("birthday"));
		req.setAttribute("cid", "c" + care);
		req.setAttribute("lid", "l" + link);
		req.setAttribute("bid", "b" + birthday);// 实现跳转保留选项

		CustomerCareDao ccd = new CustomerCareDao();// 关怀
		CustomerLinkRecordDao clrd = new CustomerLinkRecordDao();// 联系
		NoticeInfoDao nid = new NoticeInfoDao();// 公告
		CustomerInfoDao cid = new CustomerInfoDao();// 生日
		List<Care> carelist = null;
		List<CustomerLinkrecord> linklist = null;
		List<NoticeInfo> noticelist = null;
		List<CustomerInfo> customerlist = null;
		try {
			carelist = ccd.remind(care);// 成功
			linklist = clrd.remind(link);// 成功
			noticelist = nid.queryall();
			customerlist = cid.remind(birthday);// 成功
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (carelist != null && carelist.size() != 0)
			req.setAttribute("carelist", carelist);
		if (linklist != null && linklist.size() != 0)
			req.setAttribute("linkrecorsList", linklist);
		if (noticelist != null && noticelist.size() != 0)
			req.setAttribute("noticeList", noticelist);
		if (customerlist != null && customerlist.size() != 0)
			req.setAttribute("customerList", customerlist);
		req.getRequestDispatcher("/view/frame/center.jsp").forward(req, resp);

	}

}
