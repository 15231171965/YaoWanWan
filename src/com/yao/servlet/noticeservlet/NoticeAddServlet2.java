package com.yao.servlet.noticeservlet;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yao.dao.noticeinfodao.NoticeInfoDao;
import com.yao.entity.NoticeInfo;

public class NoticeAddServlet2 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(req.getParameter("customerForUser")!=null&&req.getParameter("noticeItem")!=null&&req.getParameter("noticeContent")!=null&&
				req.getParameter("noticeTime")!=null&&req.getParameter("noticeEndTime")!=null){
			NoticeInfoDao nid=new NoticeInfoDao();
			int uid=Integer.valueOf(req.getParameter("customerForUser"));
			String noticeItem=req.getParameter("noticeItem");
			String noticeContent=req.getParameter("noticeContent");
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Timestamp EndTime=null;
			Timestamp addTime=null;
			try {
				EndTime=new Timestamp(sdf.parse(req.getParameter("noticeEndTime")).getTime());
				addTime=new Timestamp(sdf.parse(req.getParameter("noticeTime")).getTime());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			NoticeInfo n=new NoticeInfo(uid,noticeItem,noticeContent,addTime,EndTime);
			int i=0;
			try {
				i=nid.insert(n);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(i==1)
				req.setAttribute("info", "添加成功");
			else
				req.setAttribute("info", "添加失败");
		}else{
			req.setAttribute("info", "添加失败");
		}
		req.getRequestDispatcher("/view/notice/notice_save.jsp").forward(req, resp);;
	}
	
}
