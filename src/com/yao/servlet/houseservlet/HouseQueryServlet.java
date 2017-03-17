package com.yao.servlet.houseservlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yao.dao.housedao.HouseDao;
import com.yao.dao.housetypedao.HouseTypeDao;
import com.yao.dao.pagedao.PageDao;
import com.yao.entity.HouseInfo;
import com.yao.util.PageUtil;

public class HouseQueryServlet extends HttpServlet{

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
			allsize=pd.getAll("house_info");
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
		
		HouseDao hd=new HouseDao();
		List<HouseInfo> list=null;
		if(req.getParameter("houseInput")==null&&req.getParameter("queryType")==null){
			try {
				list=hd.queryAllPage(pageutil);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(list!=null&&list.size()!=0)
				req.setAttribute("list", list);
			else
				req.setAttribute("list", list);
		}else{
			String input=req.getParameter("houseInput");
			if(req.getParameter("keyWord")!=null)//如果有keyWord则设置keyWord为input
				input=req.getParameter("keyWord");
			int queryType=Integer.valueOf(req.getParameter("queryType"));
			req.setAttribute("qid", "q"+queryType);
			try {
				switch (queryType) {
				case 1:
					//HouseTypeDao htd=new HouseTypeDao();
					//int type_id=htd.queryIdByName(input);
					pageutil.setAllsize(pd.getAll("house_info i,house_type t where i.type_id=t.type_id and t.type_name like '%"+input+"%'"));
					list=hd.queryByTypeName(input,pageutil);
					break;
				case 2:
					pageutil.setAllsize(pd.getAll("house_info where house_address like '%"+input+"%'"));
					list=hd.queryByAddress(input,pageutil);
					break;
				default:
					break;
				}
			} catch (SQLException e) {
				// TODO: handle exception
			}
			req.setAttribute("keyWord", input+"&&queryType="+queryType);
			req.setAttribute("list",list);
		}
		req.setAttribute("page", pageutil);
		req.setAttribute("requestURL","HouseQueryServlet");
		req.getRequestDispatcher("/view/house/house_list.jsp").forward(req, resp);
	}
	
}
