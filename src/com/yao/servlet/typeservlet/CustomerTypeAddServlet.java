package com.yao.servlet.typeservlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yao.dao.customerinfodao.TypeDao;

public class CustomerTypeAddServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(req.getParameter("typeName")!=null){
			TypeDao td=new TypeDao();
			String typeName=req.getParameter("typeName");
			int i=0;
			try {
				i=td.insert(typeName);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(i==1)
				req.setAttribute("signal", "添加成功");
			else
				req.setAttribute("signal", "添加失败");
			req.getRequestDispatcher("/view/customerType/customerType_save.jsp").forward(req, resp);
		}else{
			resp.sendRedirect("/view/customerType/customerType_add.jsp");
		}
	}
}
