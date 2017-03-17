package com.yao.servlet.customerservlet;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yao.dao.customerinfodao.CustomerInfoDao;
import com.yao.dao.userdao.UserDao;
import com.yao.entity.CustomerInfo;

public class CustomerAddServlet2 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CustomerInfoDao cid=new CustomerInfoDao();
		int sourceId=Integer.valueOf(req.getParameter("customerSource"));//来源
		int conditionid=Integer.valueOf(req.getParameter("customerCondition"));//客户状态
		int typeId=Integer.valueOf(req.getParameter("customerType"));//客户类型
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
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Timestamp birthday=null;//生日
		Timestamp addtime=new Timestamp(new Date().getTime());//增加时间
		Timestamp updatetime=new Timestamp(new Date().getTime());//修改时间
		try {
			birthday=new Timestamp(sdf.parse(req.getParameter("customerBirthday")).getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CustomerInfo customer=new CustomerInfo(conditionid,sourceId,typeId
				,customerName,sex,mobile,qq,address,email,remark,Job,blog,tel,msn
				,addman,changeman,company,birthday,addtime,updatetime);
		int i=10;
		try {
			i = cid.insert(customer);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(i==1){
			req.setAttribute("info", "添加成功");
			req.getRequestDispatcher("/view/customer/Customer_save.jsp").forward(req, resp);
		}else{
			req.setAttribute("info", "添加失败");
			req.getRequestDispatcher("/view/customer/Customer_save.jsp").forward(req, resp);
		}
	}
	
}
