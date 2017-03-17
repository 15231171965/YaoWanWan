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

public class UserUpdateServlet2 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserDao ud=new UserDao();
		int id=Integer.valueOf(req.getParameter("userId"));//员工ID
		String userName=req.getParameter("userName");//员工名字
		int userAge=Integer.valueOf(req.getParameter("userAge"));//员工年龄
		String userSex=req.getParameter("userSex");//性别
		String userNation=req.getParameter("userNation");//民族
		String userDiploma=req.getParameter("userDiploma");//学历
		String isMarried=req.getParameter("isMarried");//婚否
		int departmentId=Integer.valueOf(req.getParameter("departmentId"));//部门ID
		String userTel=req.getParameter("userTel");//座机
		String userIntest=req.getParameter("userIntest");//爱好
		String userBankcard=req.getParameter("userBankcard");//银行卡
		String userMobile=req.getParameter("userMobile");//手机号
		String userIdnum=req.getParameter("userIdnum");//身份证
		String userAddman=req.getParameter("userAddman");//添加人
		String userChangeman=req.getParameter("userChangeman");//改变人
		String userEmail=req.getParameter("userEmail");//Email
		String userAddress=req.getParameter("userAddress");//地址
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Timestamp userAddtime=null;//add时间
		Timestamp userChangeTime=null;//修改时间
		try {
			userAddtime=new Timestamp(sdf.parse(req.getParameter("userAddtime")).getTime());
			userChangeTime=new Timestamp(sdf.parse(req.getParameter("userChangeTime")).getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		UserInfo u=new UserInfo(id,departmentId,userName,userSex,userMobile,userAge,userAddress
				,userTel,userIdnum,userEmail,userAddtime,userAddman,userChangeTime,userChangeman,userIntest
				,userDiploma,userBankcard,userNation,isMarried);
		int i=0;
		try {
			i=ud.update(u);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(i==1)
			req.setAttribute("info", "修改成功");
		else
			req.setAttribute("info", "修改失败");
		req.getRequestDispatcher("/view/user/user_save.jsp").forward(req, resp);;
	}
}
