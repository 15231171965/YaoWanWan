package com.yao.servlet.noticeservlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yao.dao.noticeinfodao.NoticeInfoDao;

public class NoticeDeleteServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(req.getParameter("noticeId")!=null){
			int id=Integer.valueOf(req.getParameter("noticeId"));
			NoticeInfoDao nid=new NoticeInfoDao();
			int i=0;
			try {
				i=nid.delete(id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(i==1)
				req.setAttribute("info", "删除成功");
			else
				req.setAttribute("info", "删除失败");
		}else{
			req.setAttribute("info", "删除失败");
		}
		req.getRequestDispatcher("/view/notice/notice_save.jsp").forward(req, resp);
	}
	
}
