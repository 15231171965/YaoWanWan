<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


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
			

	</head>

	<body>
		<form action=" <%=basePath%>servlet/UserUpdateServlet" method="get" name="form2"  >
			
			<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
				align=center border=0>
				<tr class=editHeaderTr>
					<td class=editHeaderTd colSpan=7>
						用户的详细信息
						<input type="hidden" name="id" value=""readonly="readonly">
					</td>
				</tr>

				<tr>
					<td bgcolor="#FFFDF0"><div align="center">姓名：${EmployeeInfo.user_name}</div></td>
					<td colspan="3" bgcolor="#FFFFFF" align="center"></td>
					<td bgcolor="#FFFDF0"><div align="center">年龄：${EmployeeInfo.user_age}</div></td>
					<td colspan="3" bgcolor="#FFFFFF" align="center"></td>
				</tr>

				<tr>
					<td bgcolor="#FFFDF0" style="height: 21px"><div align="center">性别：${EmployeeInfo.user_sex}</div></td>
					<td colspan="3" bgcolor="#FFFFFF" style="height: 21px" align="center"></td>
					<td bgcolor="#FFFDF0"><div align="center">民族：${EmployeeInfo.user_nation}</div></td>
					<td colspan="3" bgcolor="#FFFFFF" align="center"></td>
				</tr>

				<tr>
					<td bgcolor="#FFFDF0"><div align="center">学历：${EmployeeInfo.user_diploma}</div></td>
					<td colspan="3" bgcolor="#FFFFFF" align="center"> </td>
					<td bgcolor="#FFFDF0"><div align="center">婚姻：${EmployeeInfo.is_married}</div></td>
					<td colspan="3" bgcolor="#FFFFFF" align="center"></td>
				</tr>

				<tr>
					<td bgcolor="#FFFDF0"><div align="center">部门：${EmployeeInfo.department_name}</div></td>
					<td colspan="3" bgcolor="#FFFFFF" align="center"></td>
					<td bgcolor="#FFFDF0"><div align="center">角色：${EmployeeInfo.role_name}</div></td>
					<td colspan="3" bgcolor="#FFFFFF" align="center"></td>
	
				<tr>
					<td bgcolor="#FFFDF0"><div align="center">座机：${EmployeeInfo.user_tel}</div></td>
					<td colspan="3" bgcolor="#FFFFFF" align="center"></td>
					<td bgcolor="#FFFDF0"><div align="center">爱好：${EmployeeInfo.user_intest}</div></td>
					<td colspan="3" bgcolor="#FFFFFF" align="center"></td>
				</tr>
			
				<tr>
					<td bgcolor="#FFFDF0"><div align="center">工资卡号：${EmployeeInfo.user_bankcard}</div></td>
					<td colspan="3" bgcolor="#FFFFFF" align="center"></td>
					<td bgcolor="#FFFDF0"><div align="center">手机：${EmployeeInfo.user_mobile}</div></td>
					<td colspan="3" bgcolor="#FFFFFF" align="center"></td>

				</tr>

				<tr>
					<td bgcolor="#FFFDF0"><div align="center">身份证：${EmployeeInfo.user_idnum}</div></td>
					<td colspan="3" bgcolor="#FFFFFF" align="center"></td>
					<td bgcolor="#FFFDF0"><div align="center">添加时间：${EmployeeInfo.user_addtime}</div></td>
					<td colspan="3" bgcolor="#FFFFFF" align="center"></td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0"><div align="center">添加人：${EmployeeInfo.user_addman}</div></td>
					<td colspan="3" bgcolor="#FFFFFF" align="center"></td>
					<td bgcolor="#FFFDF0"><div align="center">修改人：${EmployeeInfo.user_changeman}</div></td>
					<td colspan="3" bgcolor="#FFFFFF" align="center"></td>
				</tr>

				<tr>

					<td bgcolor="#FFFDF0"><div align="center">E_mail：${EmployeeInfo.user_email}</div></td>
					<td colspan="3" bgcolor="#FFFFFF" align="center"></td>
					<td bgcolor="#FFFDF0"><div align="center">修改时间：${EmployeeInfo.user_changetime}</div></td>
					<td colspan="3" bgcolor="#FFFFFF" align="center"></td>
				</tr>
				
				<tr>
					<td bgcolor="#FFFDF0"><div align="center">地址：${EmployeeInfo.user_address}</div></td>
					<td colspan="5" bgcolor="#FFFFFF" align="center"></td>
				</tr>

			</table>
			<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
				align=center border=0>
				<tr bgcolor="#ECF3FD">
					<td width="36%"></td>
					
					<td width="4%"><input type="button" name="button"  onClick="history.back() "  value="返回"></td>
					<td width="43%"></td>
				</tr>
			</table>

		</form>

	</body>
</html>
