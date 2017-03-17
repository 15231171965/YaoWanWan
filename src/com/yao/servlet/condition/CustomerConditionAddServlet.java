package com.yao.servlet.condition;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yao.dao.customerinfodao.ConditionDao;
import com.yao.entity.CustomerCondition;

public class CustomerConditionAddServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(req.getParameter("conditionName")!=null&&req.getParameter("conditionExplain")!=null){
			ConditionDao cd=new ConditionDao();
			String conditionName=req.getParameter("conditionName");
			String conditionExplain=req.getParameter("conditionExplain");
			CustomerCondition c=new CustomerCondition(conditionName,conditionExplain);
			int i=0;
			try {
				i=cd.insert(c);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(i==1)
				req.setAttribute("info", "添加成功");
			else
				req.setAttribute("info", "添加失败");
			req.getRequestDispatcher("/view/customerCondition/customerCondition_save.jsp").forward(req, resp);
		}else{
			req.setAttribute("info", "添加失败");
			req.getRequestDispatcher("/view/customerCondition/customerCondition_save.jsp").forward(req, resp);
		}
	}
	
}
