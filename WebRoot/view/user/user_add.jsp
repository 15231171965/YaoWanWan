<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.yao.entity.*"%>
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

		<title>添加员工信息</title>

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
<script language="JavaScript" type="text/javascript" src="<%=basePath%>resource/js/FormValid.js"></script>
	<script type="text/javascript">
		function check() {
			if(${addSignal=="ok"}){
				<% session.removeAttribute("addSignal");%>
				alert("添加成功");
			}
			if(${addSignal=="false"}){
				<% session.removeAttribute("addSignal");%>
				alert("添加失败");
			}
			
		}
	
	</script>
	
	</head>

	<body onload="check()">
		<form action="UserAddServlet2"  name="form1" onsubmit="return validator(this)"   method="post"
			name="form2" onsubmit="return checkForm('form2');">
			<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
				align=center border=0>
				<tr class=editHeaderTr>
					<td class=editHeaderTd colSpan=7>
						请输入新用户的详细信息
					</td>
				</tr>

				<tr>
					<td width="13%" bgcolor="#FFFDF0">
						<div align="center">
							姓名：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text" name="userName"  maxlength="10" style="width: 145px" valid="required"  errmsg="员工姓名不能为空!" >
						&nbsp;
					</td>
					<td width="13%" bgcolor="#FFFDF0">
						<div align="center">
							账号：
						</div>
					</td>
					<td width="41%" colspan="3" bgcolor="#FFFFFF">
						<input type="text" name="userNum"  maxlength="20" style="width: 145px" valid="required"  errmsg="账号不能为空!">
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							年龄：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text" name="userAge" style="width: 145px"  maxlength="2"  valid="required|isNumber"  errmsg="员工年龄不能为空!|请输入正确的年龄!">
						&nbsp;
					</td>

					<td bgcolor="#FFFDF0">
						<div align="center" >
							密码：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="password" name="userPw"  maxlength="20" style="width: 145px" valid="required"  errmsg="密码不能为空!">
						&nbsp;
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0" style="height: 21px">
						<div align="center">
							性别：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF" style="height: 21px">
						<select name="userSex" style="width: 145px">
							<option value="男">
								男
							</option>
							<option value="女">
								女
							</option>
						</select>
						&nbsp;
					</td>
					<td bgcolor="#FFFDF0">
						<div align="center">
							民族：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text" style="width: 145px"  maxlength="5" name="userNation">
						&nbsp;
					</td>
				</tr>

				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							学历：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<select name="userDiploma" style="width: 145px">
							<option value="初中">
								初中
							</option>
							<option value="高中">
								高中
							</option>
							<option value="本科">
								本科
							</option>
							<option value="博士">
								博士
							</option>
							<option value="硕士">
								硕士
							</option>
						</select>
					</td>
					<td bgcolor="#FFFDF0">
						<div align="center">
							婚姻：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<select name="isMarried" style="width: 145px">
							<option value="已婚">
								已婚
							</option>
							<option value="未婚">
								未婚
							</option>
							<option value="离异">
								离异
							</option>
						</select>
						&nbsp;
					</td>
				</tr>

				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							部门：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<select name="departmentId" style="width: 145px">
							<%
								List<DepartmentInfo> list = (List<DepartmentInfo>) request.getAttribute("DepartmentInfos");
								if (list != null && list.size() > 0) {
									for (DepartmentInfo de : list) {
							%>
							<option value="<%=de.getDepartment_id()%>"><%=de.getDepartment_name()%></option>
							<%
									}
								}
							%>
						</select>
						&nbsp;
					</td>

					<td bgcolor="#FFFDF0">
						<div align="center">
							角色：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<select name="roleId" style="width: 145px">
							<%
								List<UserRole> list2 = (List<UserRole>) request.getAttribute("RoleInfos");
								if (list2 != null && list2.size() > 0) {
									for (UserRole de : list2) {
							%>
							<option value="<%=de.getRole_id()%>"><%=de.getRole_name()%></option>
							<%
									}
								}
							%>
						</select>
						&nbsp;
					</td>
				</tr>


				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							座机：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text" style="width: 145px"    valid="isPhone"   errmsg="请输入正确的座机号码!"  name="userTel">
						&nbsp;
					</td>
					<td bgcolor="#FFFDF0">
						<div align="center">
							爱好：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text" style="width: 145px"  maxlength="50" name="userIntest">
						&nbsp;
					</td>
				</tr>

				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							工资卡号：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text" style="width: 145px"  valid="isNumber"   errmsg="请输入正确的工资卡号!"  maxlength="20"  name="userBankcard" >
						&nbsp;
					</td>
					<td bgcolor="#FFFDF0">
						<div align="center">
							手机：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text" style="width: 145px"  valid="regexp"  regexp="^1[3|4|5|8][0-9]\d{8}$"   errmsg="请输入正确的手机号码!"  name="userMobile">
						&nbsp;
					</td>

				</tr>

				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							身份证：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text" style="width: 145px"   valid="isIdCard"   errmsg="请输入正确的身份证号码!" name="userIdnum">
						<input type="hidden" value="<%=new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())%>" name="userAddtime">
					</td>
					<td bgcolor="#FFFDF0">
						<div align="center">
							地址：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text" name="userAddress"  maxlength="50" style="width: 145px">
					</td>
				</tr>

				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							添加人：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text" style="width: 145px"   maxlength="20"  name="userAddman" valid="required"  errmsg="添加人不能为空!" >
					</td>
					<td bgcolor="#FFFDF0">
						<div align="center">
							E_mail：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text" style="width: 145px"  valid="isEmail"  errmsg="Email格式不对!" name="userEmail">
						&nbsp;
					</td>
				</tr>

	
			</table>
			<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
				align=center border=0>
				<tr bgcolor="#ECF3FD">
					<td width="25%"></td>
					<td width="17%"><input type="submit" name="submit"  value="添加"></td>
					<td width="17%"><input type="reset" name="reset"  value="重置"></td>
					<td width="4%"><input type="button" name="button"  onClick="history.back() "  value="返回"></td>
					<td width="43%"></td>
				</tr>
			</table>

		</form>
	</body>
</html>
