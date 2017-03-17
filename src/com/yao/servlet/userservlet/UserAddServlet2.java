package com.yao.servlet.userservlet;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yao.dao.userdao.UserDao;
import com.yao.entity.UserInfo;

public class UserAddServlet2 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserDao ud=new UserDao();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		int departmentId=Integer.valueOf(req.getParameter("departmentId"));//部门ID
		int roleId=Integer.valueOf(req.getParameter("roleId"));//角色ID
		String userName=req.getParameter("userName");//员工名字
		String userSex=req.getParameter("userSex");//性别
		String userMobile=req.getParameter("userMobile");//手机号
		int userAge=Integer.valueOf(req.getParameter("userAge"));//年龄
		String userAddress=req.getParameter("userAddress");//地址
		String userNum=req.getParameter("userNum");//账户名
		String userPw=req.getParameter("userPw");//密码
		String userTel=req.getParameter("userTel");//座机
		String userIdnum=req.getParameter("userIdnum");//身份证
		String userEmail=req.getParameter("userEmail");//Email
		Timestamp userAddtime=null;//添加时间
		String userAddman=req.getParameter("userAddman");//添加人
		String userIntest=req.getParameter("userIntest");//爱好
		String userDiploma=req.getParameter("userDiploma");//学历
		String userBankcard=req.getParameter("userBankcard");//银行卡
		String userNation=req.getParameter("userNation");//民族
		String isMarried=req.getParameter("isMarried");//婚否
		try {
			userAddtime=new Timestamp(sdf.parse(req.getParameter("userAddtime")).getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		UserInfo u=new UserInfo(departmentId,roleId,userName,userSex,userMobile,userAge,userAddress
				,userNum,userPw,userTel,userIdnum,userEmail,userAddtime,userAddman,userIntest,userDiploma
				,userBankcard,userNation,isMarried);
		int i=0;
		try {
			i=ud.insert(u);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(i==1)
			req.setAttribute("info", "添加成功");
		else
			req.setAttribute("info", "添加失败");
		req.getRequestDispatcher("/view/user/user_save.jsp").forward(req, resp);
	}
	
}
