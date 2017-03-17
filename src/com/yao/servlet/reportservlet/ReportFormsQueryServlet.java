package com.yao.servlet.reportservlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yao.dao.baobiaodao.*;
import com.yao.entity.*;

public class ReportFormsQueryServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		TypeNumDao tnd=new TypeNumDao();
		ConditionNumDao cnd=new ConditionNumDao();
		FenPeiNumDao fpnd=new FenPeiNumDao();
		SourceNumDao snd=new SourceNumDao();
		List<TypeNum> tlist=null;
		List<ConditionNum> clist=null;
		List<FenPeiNum> flist=null;
		List<SourceNum> slist=null;
		try {
			tlist=tnd.queryAll();
			clist=cnd.queryAll();
			flist=fpnd.queryAll();
			slist=snd.queryAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(tlist!=null&&tlist.size()>0)
			req.setAttribute("tlist", tlist);
		if(clist!=null&&clist.size()>0)
			req.setAttribute("clist", clist);
		if(flist!=null&&flist.size()>0)
			req.setAttribute("flist", flist);
		if(slist!=null&&slist.size()>0)
			req.setAttribute("slist", slist);
		req.getRequestDispatcher("/view/frame/reportForms.jsp").forward(req, resp);
	}
	
}
