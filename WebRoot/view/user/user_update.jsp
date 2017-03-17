<%@ page language="java" import="java.util.*,com.yao.entity.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>修改员工信息</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<LINK href="<%=basePath%>resource/css/admin.css" type=text/css
	rel=stylesheet>
<script type="text/javascript"
	src="<%=basePath%>resource/js/CheckForm.js"></script>
<script type="text/javascript"
	src="<%=basePath%>resource/js/My97DatePicker/WdatePicker.js"></script>
<script language="JavaScript" type="text/javascript"
	src="<%=basePath%>resource/js/FormValid.js"></script>

</head>

<body>
<%UserInfo userInfo =(UserInfo)session.getAttribute("userInfo"); %>
	<form action="UserUpdateServlet2" method="post"
		name="form2" onsubmit="return validator(this)">
		<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
			align=center border=0>
			<tr class=editHeaderTr>
				<td class=editHeaderTd colSpan=7>请修改用户的详细信息 <input
					type="hidden" name="userId" value="${Iduser.user_id}"
					readonly="readonly">
				</td>
			</tr>

			<tr>
				<td bgcolor="#FFFDF0">
					<div align="center">姓名：</div>
				</td>
				<td colspan="3" bgcolor="#FFFFFF"><input type="text" 
					style="width: 145px" name="userName" 
					value="${Iduser.user_name}" readonly="readonly"> &nbsp;</td>
				<td bgcolor="#FFFDF0">
					<div align="center">年龄：</div>
				</td>
				<td colspan="3" bgcolor="#FFFFFF"><input type="text"
					style="width: 145px" name="userAge" maxlength="2"
					valid="required|isNumber" errmsg="员工年龄不能为空!|请输入正确的年龄!"
					value="${Iduser.user_age}"> &nbsp;</td>
			</tr>

			<tr>
				<td bgcolor="#FFFDF0" style="height: 21px">
					<div align="center">性别：</div>
				</td>
				<td colspan="3" bgcolor="#FFFFFF" style="height: 21px"><input
					type="radio" name="userSex" value="男"
					${fn:contains(Iduser.user_sex,"男")?"checked":"" }/>男
					<input type="radio" name="userSex" value="女"
				    ${fn:contains(Iduser.user_sex,"女")?"checked":"" } />女 <br />
				</td>
				<td bgcolor="#FFFDF0">
					<div align="center">民族：</div>
				</td>
				<td colspan="3" bgcolor="#FFFFFF"><input type="text"
					style="width: 145px" name="userNation"
					value="${Iduser.user_nation }"> &nbsp;</td>
			</tr>

			<tr>
				<td bgcolor="#FFFDF0">
					<div align="center">学历：</div>
				</td>
				<td colspan="3" bgcolor="#FFFFFF"><select name="userDiploma"
					style="width: 145px">
						<option value="初中"
							${Iduser.user_diploma=="初中"?"selected":""}>初中</option>
						<option value="高中"
							${Iduser.user_diploma=="高中"?"selected":""}>高中</option>
						<option value="本科"
							${Iduser.user_diploma=="本科"?"selected":""}>本科</option>
						<option value="博士"
							${Iduser.user_diploma=="博士"?"selected":""}>博士</option>
						<option value="硕士"
							${Iduser.user_diploma=="硕士"?"selected":""}>硕士</option>
				</select> &nbsp;</td>
				<td bgcolor="#FFFDF0">
					<div align="center">婚姻：</div>
				</td>
				<td colspan="3" bgcolor="#FFFFFF"><select name="isMarried"
					style="width: 145px">
						<option value="已婚"
							${Iduser.is_married=="已婚"?"selected":""}>已婚</option>
						<option value="未婚"
							${Iduser.is_married=="未婚"?"selected":""}>未婚</option>
						<option value="离婚"
							${Iduser.is_married=="离婚"?"selected":""}>离婚</option>
				</select> &nbsp;</td>
			</tr>


			<tr>
				<td bgcolor="#FFFDF0">
					<div align="center">部门：</div>
				</td>
				<td colspan="3" bgcolor="#FFFFFF">
				<select name="departmentId"
					style="width: 145px">
						<c:forEach items="${departmentNameId}" var="dnid">
							<option value="${dnid.department_id}"
								${Iduser.department_id==dnid.department_id?"selected":""}>${dnid.department_name}</option>
						</c:forEach>
				</select> &nbsp;</td>
				<td bgcolor="#FFFDF0">
					<div align="center">角色：</div>
				</td>

				<td colspan="3" bgcolor="#FFFFFF">
				
				<select id="roleId" name="roleId" disabled="disabled" style="width: 145px">
                         <c:forEach items="${roleInfoNameId}" var="role">
                       
                         <%-- <input type="hidden" name="roleId" value="${userInfo.role_id}"  >${userInfo.role_name} --%>
                         
						<option value="${role.role_id}"
							${role.role_id==Iduser.role_id?"selected":""}>${role.role_name}</option>
						</c:forEach>
				</select>
				<script>var role=<%=userInfo.getRole_id()%>;
				if(role==1){		//实现管理员可改权限
					document.getElementById("roleId").disabled="";
				}	
				</script></td> &nbsp;
				
			<tr>
				<td bgcolor="#FFFDF0">
					<div align="center">座机：</div>
				</td>
				<td colspan="3" bgcolor="#FFFFFF"><input type="text"
					style="width: 145px" valid="isPhone" errmsg="请输入正确的座机号码!"
					name="userTel" value="${Iduser.user_tel }"></td>
				<td bgcolor="#FFFDF0">
					<div align="center">爱好：</div>
				</td>
				<td colspan="3" bgcolor="#FFFFFF"><input type="text"
					style="width: 145px" maxlength="50" name="userIntest"
					value="${Iduser.user_intest }"> &nbsp;</td>
			</tr>



			<tr>
				<td bgcolor="#FFFDF0">
					<div align="center">工资卡号：</div>
				</td>
				<td colspan="3" bgcolor="#FFFFFF"><input type="text"
					style="width: 145px" valid="isNumber" errmsg="请输入正确的工资卡号!"
					maxlength="20" name="userBankcard"
					value="${Iduser.user_bankcard}"> &nbsp;</td>
				<td bgcolor="#FFFDF0">
					<div align="center">手机：</div>
				</td>
				<td colspan="3" bgcolor="#FFFFFF"><input type="text"
					style="width: 145px" valid="regexp" regexp="^1[3|4|5|8][0-9]\d{8}$"
					errmsg="请输入正确的手机号码!" name="userMobile"
					value="${Iduser.user_mobile}"> &nbsp;</td>

			</tr>

			<tr>
				<td bgcolor="#FFFDF0">
					<div align="center">身份证：</div>
				</td>
				<td colspan="3" bgcolor="#FFFFFF"><input type="text"
					style="width: 145px" valid="isIdCard" errmsg="请输入正确的身份证号码!"
					name="userIdnum" value="${Iduser.user_idnum}">
					&nbsp;</td>
				<td bgcolor="#FFFDF0">
					<div align="center">添加时间：</div>
				</td>
				<td colspan="3" bgcolor="#FFFFFF"><input type="hidden"
					style="width: 145px" name="userAddtime"
					value="${Iduser.user_addtime}">${Iduser.user_addtime}</td>
			</tr>
			<tr>
				<td bgcolor="#FFFDF0">
					<div align="center">添加人：</div>
				</td>
				<td colspan="3" bgcolor="#FFFFFF"><input type="hidden"
					style="width: 145px" maxlength="10" name="userAddman"
					 value="${Iduser.user_addman}">${Iduser.user_addman}
					&nbsp;</td>
				<td bgcolor="#FFFDF0">
					<div align="center">修改人：</div> <input type="hidden"
					value="<%=new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
					.format(new Date())%>"
					name="userChangeTime">

				</td>
				<td colspan="3" bgcolor="#FFFFFF"><input type="text"
					name="userChangeman" style="width: 145px" maxlength="20"
					value="${Iduser.user_changeman}"> &nbsp;</td>
			</tr>

			<tr>

				<td bgcolor="#FFFDF0">
					<div align="center">E_mail：</div>
				</td>
				<td colspan="3" bgcolor="#FFFFFF"><input type="text"
					style="width: 145px" maxlength="50" name="userEmail"
					value="${Iduser.user_email}"> &nbsp;</td>
				<td bgcolor="#FFFDF0">
					<div align="center">地址：</div>
				</td>
				<td colspan="3" bgcolor="#FFFFFF"><input type="text"
					style="width: 145px" maxlength="50" name="userAddress"
					value="${Iduser.user_address}"> &nbsp;</td>
			</tr>

		</table>
		<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
			align=center border=0>
			<tr bgcolor="#ECF3FD">
				<td width="36%"></td>
				<td width="17%"><input type="submit" name="submit" value="提交"></td>
				<td width="4%"><input type="button" name="button"
					onClick="history.back() " value="返回"></td>
				<td width="43%"></td>
			</tr>
		</table>

	</form>

</body>
</html>
