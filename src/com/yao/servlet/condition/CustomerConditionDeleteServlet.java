package com.yao.servlet.condition;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yao.dao.customerinfodao.ConditionDao;

public class CustomerConditionDeleteServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(req.getParameter("conditionId")!=null){
			ConditionDao cd=new ConditionDao();
			int id=Integer.valueOf(req.getParameter("conditionId"));
			int i=0;
			try {
				i=cd.delete(id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(i==1)
				req.setAttribute("info", "删除成功");
			else
				req.setAttribute("info", "删除失败");
			req.getRequestDispatcher("/view/customerCondition/customerCondition_save.jsp").forward(req, resp);
		}else{
			req.setAttribute("info", "删除失败");
			req.getRequestDispatcher("/view/customerCondition/customerCondition_save.jsp").forward(req, resp);
		}
		
	}
	
}
