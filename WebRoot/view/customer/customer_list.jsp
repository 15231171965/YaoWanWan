<%@ page language="java" import="java.util.*,com.yao.entity.*"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>显示客户信息</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}

.STYLE1 {
	font-size: 12px
}

.STYLE3 {
	font-size: 12px;
	font-weight: bold;
}

.STYLE4 {
	color: #03515d;
	font-size: 12px;
}

a {
	text-decoration: none;
	color: #033d61;
	font-size: 12px;
}

A:hover {
	COLOR: #f60;
	TEXT-DECORATION: underline
}
-->
</style>
<script type="text/javascript" src="<%=basePath%>resource/js/doPage.js"></script>
<script type="text/javascript"
	src="<%=basePath%>resource/js/jquery-1.11.3.js"></script>
<script>
	var highlightcolor = '#c1ebff';
	var clickcolor = '#51b2f6';
	function changeto() {
		source = event.srcElement;
		if (source.tagName == "TR" || source.tagName == "TABLE")
			return;
		while (source.tagName != "TD")
		source = source.parentElement;
		source = source.parentElement;
		cs = source.children;
		//alert(cs.length);
		if (cs[1].style.backgroundColor != highlightcolor && source.id != "nc" && cs[1].style.backgroundColor != clickcolor)
			for (var i = 0; i < cs.length; i++) {
				cs[i].style.backgroundColor = highlightcolor;
		}
	}

	function changeback() {
		if (event.fromElement.contains(event.toElement) || source.contains(event.toElement) || source.id == "nc")
			return
		if (event.toElement != source && cs[1].style.backgroundColor != clickcolor)
			//source.style.backgroundColor=originalcolor
			for (var i = 0; i < cs.length; i++) {
				cs[i].style.backgroundColor = "";
		}
	}

	function clickto() {
		source = event.srcElement;
		if (source.tagName == "TR" || source.tagName == "TABLE")
			return;
		while (source.tagName != "TD")
		source = source.parentElement;
		source = source.parentElement;
		cs = source.children;
		//alert(cs.length);
		if (cs[1].style.backgroundColor != clickcolor && source.id != "nc")
			for (var i = 0; i < cs.length; i++) {
				cs[i].style.backgroundColor = clickcolor;
		}
		else
			for (var i = 0; i < cs.length; i++) {
				cs[i].style.backgroundColor = "";
		}
	}
</script>
<script type="text/javascript">
	function add() {
		location.href = "CustomerAddServlet";
	}
</script>
<script type="text/javascript">
	function check(){
		if(${delSignal=="ok"}){
			<%session.removeAttribute("delSignal");%>
			alert("删除成功");
		}
		if(${delSignal=="false"}){
			<%session.removeAttribute("delSignal");%>
			alert("删除失败");
		}
		
	}
</script>
</head>

<body onload="check()">
	<form action="CustomerQueryServlet" method="post">

		<%--  <%
						UserInfo  userInfo  =   (UserInfo)request.getSession().getAttribute("userInfo2");
	%> --%>
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td height="30" background="<%=basePath%>resource/images/tab_05.gif"><table
						width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="12" height="30"><img
								src="<%=basePath%>resource/images/tab_03.gif" width="12"
								height="30" /></td>
							<td><table width="100%" border="0" cellspacing="0"
									cellpadding="0">
									<tr>
										<td class="STYLE4" align="center">&nbsp;&nbsp;请输入查询内容：
										<input type="text" name="Input"  style="width: 290px" /></td>
										<td class="STYLE4">&nbsp;&nbsp;请选择查询方式：<select
											name="queryType" style="width: 100px">
												<option id="c1" value="1">客户姓名</option>
												<option id="c2" value="2">客户状态</option>
												<option id="c3" value="3">客户来源</option>
												<option id="c4" value="4">客户类型</option>
												<option id="c5" value="5">所属员工</option>
												<option id="c6" value="6">客户公司</option>
										</select>
										<script>document.getElementById("<%=request.getAttribute("c")%>").selected="selected"</script>
										</td>
										<td class="STYLE4">&nbsp;&nbsp;<input type="submit"
											value="查询" style="width:50px" /></td>
										<td class="STYLE4">&nbsp;&nbsp;<input type="button"
											value="添加" onclick="add()" style="width:50px" /></td>
									</tr>
								</table></td>
							<td width="16"><img
								src="<%=basePath%>resource/images/tab_07.gif" width="16"
								height="30" /> <input type="hidden" name="userId" value="1" />
							</td>
						</tr>
					</table>
			<tr>
				<td><table width="100%" border="0" cellspacing="0"
						cellpadding="0">
						<tr>
							<td width="8"
								background="<%=basePath%>resource/images/tab_12.gif">&nbsp;</td>
							<td><table width="100%" border="0" cellpadding="0"
									cellspacing="1" bgcolor="b5d6e6" onmouseover="changeto()"
									onmouseout="changeback()">
									<tr>
										<td width="5%" height="22"
											background="<%=basePath%>resource/images/bg2.gif"
											bgcolor="#FFFFFF"><div align="center">
												<span class="STYLE1">姓名</span>
											</div></td>
										<td width="7%" height="22"
											background="<%=basePath%>resource/images/bg2.gif"
											bgcolor="#FFFFFF"><div align="center">
												<span class="STYLE1">状态</span>
											</div></td>
										<td width="7%" height="22"
											background="<%=basePath%>resource/images/bg2.gif"
											bgcolor="#FFFFFF"><div align="center">
												<span class="STYLE1">来源</span>
											</div></td>
										<td width="7%" height="22"
											background="<%=basePath%>resource/images/bg2.gif"
											bgcolor="#FFFFFF"><div align="center">
												<span class="STYLE1">所属员工</span>
											</div></td>
										<td width="7%" height="22"
											background="<%=basePath%>resource/images/bg2.gif"
											bgcolor="#FFFFFF"><div align="center">
												<span class="STYLE1">类型</span>
											</div></td>
										<td width="4%" height="22"
											background="<%=basePath%>resource/images/bg2.gif"
											bgcolor="#FFFFFF"><div align="center">
												<span class="STYLE1">性别</span>
											</div></td>
										<td width="5%" height="22"
											background="<%=basePath%>resource/images/bg2.gif"
											bgcolor="#FFFFFF"><div align="center">
												<span class="STYLE1">手机</span>
											</div></td>
										<td width="5%" height="22"
											background="<%=basePath%>resource/images/bg2.gif"
											bgcolor="#FFFFFF"><div align="center">
												<span class="STYLE1">QQ</span>
											</div></td>
										<td width="6%" height="22"
											background="<%=basePath%>resource/images/bg2.gif"
											bgcolor="#FFFFFF"><div align="center">
												<span class="STYLE1">邮箱</span>
											</div></td>
										<td width="6%" height="22"
											background="<%=basePath%>resource/images/bg2.gif"
											bgcolor="#FFFFFF"><div align="center">
												<span class="STYLE1">职位</span>
											</div></td>
										<td width="16%" height="22"
											background="<%=basePath%>resource/images/bg2.gif"
											bgcolor="#FFFFFF"><div align="center">
												<span class="STYLE1">公司</span>
											</div></td>
										<td width="10%" height="22"
											background="<%=basePath%>resource/images/bg2.gif"
											bgcolor="#FFFFFF"><div align="center">
												<span class="STYLE1">备注</span>
											</div></td>
										<td width="15%" height="22"
											background="<%=basePath%>resource/images/bg2.gif"
											bgcolor="#FFFFFF" class="STYLE1"><div align="center">基本操作</div></td>
									</tr>
									<%List<CustomerInfo> list=(List<CustomerInfo>)request.getAttribute("list");
									if(list.size()!=0&&list!=null){
										for(CustomerInfo c:list){
									%>
									<tr>
										<td height="20" bgcolor="#FFFFFF" style="width: 3%"><div
												align="center">
												<span class="STYLE1"><%=c.getCustomer_name() %> </span>
											</div></td>
										<td height="20" bgcolor="#FFFFFF" style="width: 3%"><div
												align="center">
												<span class="STYLE1"><%=c.getCondition_name() %></span>
											</div></td>
										<td height="20" bgcolor="#FFFFFF" style="width: 3%"><div
												align="center">
												<span class="STYLE1"><%=c.getSource_name() %></span>
											</div></td>
										<td height="20" bgcolor="#FFFFFF" style="width: 6%"><div
												align="center">
												<span class="STYLE1"><%=c.getUser_name() %></span>
											</div></td>
										<td height="20" bgcolor="#FFFFFF" style="width: 3%"><div
												align="center">
												<span class="STYLE1"><%=c.getType_name() %></span>
											</div></td>
										<td height="20" bgcolor="#FFFFFF" style="width: 3%"><div
												align="center">
												<span class="STYLE1"><%=c.getCustomer_sex()%></span>
											</div></td>
										<td height="20" bgcolor="#FFFFFF" style="width: 5%"><div
												align="center">
												<span class="STYLE1"><!-- <a
													href="servlet/FetionSendServlet1?id="></a> -->
													<%=c.getCustomer_mobile() %>
													</span>
											</div></td>
										<td height="20" bgcolor="#FFFFFF" style="width: 3%"><div
												align="center">
												<span class="STYLE1"><%=c.getCustomer_qq() %></span>
											</div></td>
										<td height="20" bgcolor="#FFFFFF" style="width: 5%"><div
												align="center">
												<span class="STYLE1"><%=c.getCustomer_email() %></span>
											</div></td>
										<td height="20" bgcolor="#FFFFFF" style="width: 3%"><div
												align="center">
												<span class="STYLE1"><%=c.getCustomer_job() %></span>
											</div></td>
										<td height="20" bgcolor="#FFFFFF" style="width: 3%"><div
												align="center">
												<span class="STYLE1"><%=c.getCustomer_company() %></span>
											</div></td>
										<td height="20" bgcolor="#FFFFFF" style="width: 8%"><div
												align="center">
												<span class="STYLE1"><%=c.getCustomer_remark() %></span>
											</div></td>
										<td height="20" bgcolor="#FFFFFF" style="width: 15%"><div
												align="center">
												<span class="STYLE4"><img
													src="<%=basePath%>resource/images/edt.gif" width="16"
													height="16" /> <a
													href="CustomerUpdateServlet?customerId=<%=c.getCustomer_id() %>">编辑</a>&nbsp;
													<img src="<%=basePath%>resource/images/edt.gif" width="16"
													height="16" /> <a
													href="CustomerQueryMoreServlet?customerId=<%=c.getCustomer_id()%>">详情</a>&nbsp;
													<img src="<%=basePath%>resource/images/del.gif" width="16"
													height="16" /> <a
													href="CustomerDeleteServlet?customerId=<%=c.getCustomer_id()%>">删除</a></span>
											</div></td>
									</tr>
									<%
											}
										}else{
									%>
									<tr>
										<td height="20" bgcolor="#FFFFFF" colspan="22" align="center">
											<div align="center">
												<span class="STYLE1">没有客户相关信息</span>
											</div>
										</td>
									</tr>
									<%
										}
									%>
								</table></td>
							<td width="8"
								background="<%=basePath%>resource/images/tab_15.gif">&nbsp;</td>
						</tr>
					</table></td>
			</tr>
			<tr>
				<td height="35" background="<%=basePath%>resource/images/tab_19.gif"><table
						width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="12" height="35"><img
								src="<%=basePath%>resource/images/tab_18.gif" width="12"
								height="35" /></td>
							<td><%@ include file="../page.jsp"%>
							</td>
							<td width="16"><img
								src="<%=basePath%>resource/images/tab_20.gif" width="16"
								height="35" /></td>
						</tr>
					</table></td>
			</tr>
		</table>
	</form>
</body>
</html>
