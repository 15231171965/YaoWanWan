<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.yao.entity.*"%>
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

		<title>My JSP 'customerCondition_add.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<LINK href="<%=basePath%>resource/css/admin.css" type=text/css
			rel=stylesheet>
		<script type="text/javascript"
			src="<%=basePath%>resource/js/CheckForm.js">
		</script>
		<script type="text/javascript"
			src="<%=basePath%>resource/js/My97DatePicker/WdatePicker.js">
		</script>
		<script>
			function check(){
				if(${updateSignal=="ok"}){
					<%session.removeAttribute("updateSignal");%>
					alert("修改成功");
				}
				if(${updateSignal=="false"}){
					<%session.removeAttribute("updateSignal");%>
					alert("修改失败");
				}
			}
		</script>
	</head>

	<body onload="check()">
	<%HouseInfo houseInfo=(HouseInfo)request.getAttribute("houseInfo"); %>
	<%List<HouseType> tlist=(List<HouseType>)request.getAttribute("tlist"); %>
	<%List<UserInfo> ulist=(List<UserInfo>)request.getAttribute("ulist");%>
		<form action="HouseUpdateServlet2" method="post" name="form2" onsubmit="return checkForm('form2');">
			<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
				align=center border=0>
				<tr class=editHeaderTr>
					<td class=editHeaderTd colSpan=7>
						请输入房屋的详细信息
						<input type="hidden" name="houseId" value="<%=houseInfo.getHouse_id() %>">
					</td>
				</tr>
				<tr>
					<td width="15%" bgcolor="#FFFDF0">
						<div align="center">
							房屋类型：
						</div>
				  </td>
					<td colspan="3" bgcolor="#FFFFFF">
						<select name="houseType" style="width: 145px">
						<c:forEach items="${tlist}" var="t">
							<option value="${t.type_id}" 
							${houseInfo.type_id==t.type_id?"selected":""}>${t.type_name}</option>
						</c:forEach>
						</select>
						&nbsp;
					</td>
					<td width="17%" bgcolor="#FFFDF0">
						<div align="center">
							房屋地址：
						</div>
				  </td>
					<td width="38%" colspan="3" bgcolor="#FFFFFF">
						<input type="text" check_str="房屋地址"   maxlength="50"  style="width: 145px" value="<%=houseInfo.getHouse_address() %>" name="houseAddress">
						&nbsp;
				  </td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							房屋管理者：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<select name="userName" style="width: 145px">
						<c:forEach items="${ulist}" var="u">
							<option value="${u.user_id}" 
							${houseInfo.user_id==u.user_id?"selected":""}>${u.user_name}</option>
						</c:forEach>
						</select>
						&nbsp;
					</td>
					<td width="17%" bgcolor="#FFFDF0">
						<div align="center">
							房屋价格(每平米)：
						</div>
				  </td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text"  check_str="房屋价格"  style="width: 145px" check_type="float" value="<%=houseInfo.getHouse_price() %>" name="housePrice">
						&nbsp;
					</td>
				</tr>

				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							房屋环境：
						</div>
					</td>
					<td colspan="5" bgcolor="#FFFFFF">
						<textarea rows="10"   name="houseAmbient" style="width:100%; resize:none; " ><%=houseInfo.getHouse_ambient() %></textarea>
					</td>
				</tr>
			</table>
			<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
				align=center border=0>
				<tr bgcolor="#ECF3FD">
				<td width="36%"></td>
					<td width="17%"><input type="submit" name="submit"  value="提交"></td>
					<td width="4%"><input type="button" name="button"  onClick="history.back() "  value="返回"></td>
					<td width="43%"></td>
				</tr>
			</table>

		</form>
	</body>
</html>
