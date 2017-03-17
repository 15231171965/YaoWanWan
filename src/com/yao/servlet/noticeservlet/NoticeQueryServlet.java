package com.yao.servlet.noticeservlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yao.dao.noticeinfodao.NoticeInfoDao;
import com.yao.dao.pagedao.PageDao;
import com.yao.entity.NoticeInfo;
import com.yao.util.PageUtil;

public class NoticeQueryServlet extends HttpServlet{

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
			allsize=pd.getAll("notice_info");
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
		
		NoticeInfoDao nid=new NoticeInfoDao();
		List<NoticeInfo> list=null;
		if(req.getParameter("noticeInput")==null&&req.getParameter("queryType")==null&&req.getParameter("keyWord")==null){
			try {
				list=nid.zhenQueryAllPage(pageutil);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(list!=null&&list.size()>0)
				req.setAttribute("list", list);
			else
				req.setAttribute("list", null);
		}else{
			String input=req.getParameter("noticeInput");
			if(req.getParameter("keyWord")!=null)//如果有keyWord则设置keyWord为input
				input=req.getParameter("keyWord");
			int queryType=Integer.valueOf(req.getParameter("queryType"));
			req.setAttribute("q", "q"+queryType);
			try {
				switch (queryType) {
				case 1:
					pageutil.setAllsize(pd.getAll("notice_info where notice_item like '%"+input+"%'"));
					list=nid.queryByTheme(input,pageutil);
					break;
				case 2:
					pageutil.setAllsize(pd.getAll("notice_info where notice_content like '%"+input+"%'"));
					list=nid.queryByContent(input,pageutil);
					break;
				default:
					break;
				}
			} catch (SQLException e) {
				// TODO: handle exception
			}
			if(list!=null&&list.size()>0)
				req.setAttribute("list", list);
			else
				req.setAttribute("list", null);
			req.setAttribute("keyWord", input+"&&queryType="+queryType);
		}
		req.setAttribute("page", pageutil);
		req.setAttribute("requestURL","NoticeQueryServlet");
		req.getRequestDispatcher("/view/notice/notice_list.jsp").forward(req, resp);
	}
	
}
