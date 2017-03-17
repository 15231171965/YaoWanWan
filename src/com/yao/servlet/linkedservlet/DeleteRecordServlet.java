package com.yao.servlet.linkedservlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yao.dao.customerLinkRecordDao.CustomerLinkRecordDao;

public class DeleteRecordServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(req.getParameter("recordId")!=null){
			int id=Integer.valueOf(req.getParameter("recordId"));
			CustomerLinkRecordDao clrd=new CustomerLinkRecordDao();
			int i=0;
			try {
				i=clrd.delete(id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(i==1)
				req.setAttribute("signal", "删除成功");
			else
				req.setAttribute("signal", "删除失败");
		}else{
			req.setAttribute("signal", "删除失败");
		}
		req.getRequestDispatcher("/view/linkman/linkrecord_save.jsp").forward(req, resp);
	}
	
}
