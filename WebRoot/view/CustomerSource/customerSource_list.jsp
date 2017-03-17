<%@ page language="java" import="java.util.*,com.yao.entity.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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

		<title>My JSP 'customerCondition_list.jsp' starting page</title>

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

	a{
	text-decoration: none;
	color: #033d61;
	font-size: 12px;
}
A:hover {
	COLOR: #f60; TEXT-DECORATION: underline
}

-->
</style>
<script type="text/javascript" src="<%=basePath%>resource/js/jquery-1.11.3.js"></script>
	<script type="text/javascript">
	function search() {
		var sname=$("#sname").val();
		location.href="source?sname="+sname;
	}
	function add() {
		location.href="view/CustomerSource/addSource.jsp";
	}
	</script>
	
	<script type="text/javascript" src="<%=basePath%>resource/js/doPage.js"></script>
</head>

	<body>
	
	
	<form action=""  method="post">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td height="30" background="<%=basePath%>resource/images/tab_05.gif">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="12" height="30">
								<img src="<%=basePath%>resource/images/tab_03.gif" width="12"
									height="30" />
							</td>
							<td>
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td class="STYLE4" align="center">
											&nbsp;&nbsp;请输入客户来源名称：
											<input type="text" id="sname" name="SourceName" style="width: 290px" />
										</td>
										<td class="STYLE4">
											&nbsp;&nbsp;
											<input type="button" value="查询" style="width: 50px" onclick="search()" />
										</td>
										<td class="STYLE4">
											&nbsp;&nbsp;
											<input type="button" value="添加" onclick="add()" style="width: 50px" />
										</td>
									</tr>
								</table>
							</td>
							<td width="16">
								<img src="<%=basePath%>resource/images/tab_07.gif" width="16"
									height="30" />
							</td>
						</tr>
					</table>
				</td>
			</tr>


			<tr>
				<td>
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="8"
								background="<%=basePath%>resource/images/tab_12.gif">
								&nbsp;
							</td>
							<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="1"
									bgcolor="b5d6e6" onmouseover="changeto()"
									onmouseout="changeback()">
									<tr>
										<td width="5%"
											background="<%=basePath%>resource/images/bg2.gif"
											bgcolor="#FFFFFF" style="width: 3%; height: 22px;">
											<div align="center">
												<span class="STYLE1">序号</span>
											</div>
										</td>
										<td background="<%=basePath%>resource/images/bg2.gif"
											bgcolor="#FFFFFF" style="width: 85%; height: 22px;">
											<div align="center">
												<span class="STYLE1">客户来源</span>
											</div>
										</td>
										
										<td  
											background="<%=basePath%>resource/images/bg2.gif"
											bgcolor="#FFFFFF" class="STYLE1"
											style="width: 10%; height: 22px;">
											<div align="center">
												基本操作
											</div>
										</td>
										
									</tr>
				<%List<CustomerSource> list=(List<CustomerSource>)request.getAttribute("list"); %>
				<%if(list!=null&&list.size()!=0){ %>
					<%for(int i=0;i<list.size();i++){ %>
									<tr>
										<td height="20" bgcolor="#FFFFFF" style="width: 3%">
											<div align="center" class="STYLE1">
												<div align="center">
													<span class="STYLE1"><%=i+1 %></span>
												</div>
											</div>
										</td>
										<td height="20" bgcolor="#FFFFFF" style="width: 4%">
											<div align="center">
												<span class="STYLE1"><%=list.get(i).getSource_name() %></span>
											</div>
										</td>
										<td  height="20" bgcolor="#FFFFFF" style="width: 9%">
											<div align="center">
												<span class="STYLE4"><img src="<%=basePath%>resource/images/del.gif"
														width="16" height="16" /><a
													href="delete?id=<%=list.get(i).getSource_id() %>">删除</a>
												</span>
											</div>
										</td>
										
									</tr>
								<%} %>
							<%}else{ %>
									<tr>
										<td height="20" bgcolor="#FFFFFF" colspan="4"  align="center">
											<div align="center">
												<span class="STYLE1">没有客户来源相关信息</span>
											</div>
										</td>
									</tr>
							<%} %>
								</table>
								
							</td>	
							<td width="8"
								background="<%=basePath%>resource/images/tab_15.gif">
								&nbsp;
							</td>
						</tr>
					</table>
				</td>
			</tr>
			
			<tr>
				<td height="35" background="<%=basePath%>resource/images/tab_19.gif">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="12" height="35">
								<img src="<%=basePath%>resource/images/tab_18.gif" width="12"
									height="35" />
							</td>
							<td>
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td class="STYLE4">
											<%-- &nbsp;&nbsp;共有${page.totalRow} 条记录，当前第 ${page.currentPage}/1 页 --%>
										</td>
										<td>
											<%-- <table border="0" align="right" cellpadding="0"
												cellspacing="0">
												<tr>
													<td width="40">
														<img src="<%=basePath%>resource/images/first.gif"
															width="37" height="15" />
															<a href="">首页</a>
															
													</td>
													<td width="45">
														<img src="<%=basePath%>resource/images/back.gif"
															width="43" height="15" />
															<a href="">下一页</a>
													</td>
													<td width="45">
														<img src="<%=basePath%>resource/images/next.gif"
															width="43" height="15" />
															<a href="">上一页</a>
													</td>
													<td width="40">
														<img src="<%=basePath%>resource/images/last.gif"
															width="37" height="15" />
															<a href="">尾页</a>
													</td>
													<td width="100">
														<div align="center">
															<span class="STYLE1">转到第 <input name="textfield"
																	type="text" size="4" maxlength="3"
																	style="height: 17px; width: 25px; maxborder: 1px solid #999999;" />
																页 </span>
														</div>
													</td>
													<td width="40">
														<img src="<%=basePath%>resource/images/go.gif" width="37"
															height="15" />
															<a href="">转</a>
													</td>
												</tr>
											</table> --%>
											<%@ include file="../page.jsp"%>
											
											
										</td>
									</tr>
								</table>
								
							</td>
							<td width="16">
								<img src="<%=basePath%>resource/images/tab_20.gif" width="16"
									height="35" />
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		</form>
	</body>
</html>
