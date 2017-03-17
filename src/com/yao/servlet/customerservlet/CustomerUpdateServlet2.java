package com.yao.servlet.customerservlet;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yao.dao.customerinfodao.ConditionDao;
import com.yao.dao.customerinfodao.CustomerInfoDao;
import com.yao.dao.customerinfodao.SourceDao;
import com.yao.dao.customerinfodao.TypeDao;
import com.yao.dao.userdao.UserDao;
import com.yao.entity.CustomerInfo;

public class CustomerUpdateServlet2 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(req.getParameter("customerId"));//客户ID
		//Timestamp birthday=Timestamp.valueOf(req.getParameter("customerBirthday"));//生日
		Timestamp changetime=new Timestamp(Long.parseLong(req.getParameter("customerChangeTime")));//改变时间
		Timestamp addtime=new Timestamp(Long.parseLong(req.getParameter("customerAddTime")));//添加时间
		String isused=req.getParameter("userId");//是否使用
		String customerName=req.getParameter("customerName");//客户姓名
		String sex=req.getParameter("customerSex");//性别
		String mobile=req.getParameter("customerMobile");//手机
		String qq=req.getParameter("customerQQ");//QQ
		String address=req.getParameter("customerAddress");//地址
		String email=req.getParameter("customerEmail");//邮件
		String Job=req.getParameter("customerJob");//职业
		String blog=req.getParameter("customerBlog");//微博
		String tel=req.getParameter("customerTel");//座机
		String msn=req.getParameter("customerMsn");//MSN
		String company=req.getParameter("customerCompany");//公司
		String addman=req.getParameter("customerAddMan");//添加人
		String changeman=req.getParameter("customerChangeMan");//改变人
		String remark=req.getParameter("customerRemark");//备注
		int userId=Integer.valueOf(req.getParameter("customerForUser"));//负责员工
		int sourceId=Integer.valueOf(req.getParameter("customerSource"));//来源
		int conditionid=Integer.valueOf(req.getParameter("customerCondition"));//客户状态
		int typeId=Integer.valueOf(req.getParameter("customerType"));//客户类型
		CustomerInfo customer=new CustomerInfo(id,conditionid,sourceId,userId,typeId
				,customerName,sex,mobile,qq,address,email,remark,Job,blog,tel,msn
				,addtime,addman,changetime,changeman,company,isused);
		CustomerInfoDao cid=new CustomerInfoDao();
		int i=10;
		try {
			i = cid.update(customer);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpSession session=req.getSession();
		if(i==1){
			session.setAttribute("updateSignal", "ok");
			req.getRequestDispatcher("CustomerUpdateServlet?customerId="+id).forward(req, resp);
		}else{
			session.setAttribute("updateSignal", "false");
			req.getRequestDispatcher("CustomerUpdateServlet?customerId="+id).forward(req, resp);
		}
	}
	
}
