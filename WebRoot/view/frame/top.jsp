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

		<title>top</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<script language=JavaScript>
		var timerID = null;
		var timerRunning = false;
		function stopclock (){
		if(timerRunning)
		clearTimeout(timerID);
		timerRunning = false;}
		function startclock () {
		stopclock();
		showtime();}
		function showtime () {
		var now = new Date();
		var months = now.getMonth()+1;
		var days = now.getDate();
		var hours = now.getHours();
		var minutes = now.getMinutes();
		var seconds = now.getSeconds()
		var timeValue =now.getFullYear()
		timeValue +="-"+months+"-"+days+" "
		timeValue += "" +((hours >= 12) ? "下午 " : "上午 " )
		timeValue += ((hours >12) ? hours -12 :hours)
		timeValue += ((minutes < 10) ? ":0" : ":") + minutes
		timeValue += ((seconds < 10) ? ":0" : ":") + seconds
		document.clock.thetime.value = timeValue;
		timerID = setTimeout("showtime()",1000);
		timerRunning = true;}


function exit(){

}
</SCRIPT>
		<style type="text/css">
		
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	overflow: hidden;
}

.STYLE1 {
	font-size: 12px;
	color: #FFFFFF;
}

a {
	text-decoration: none;
	color: white;
	font-size: 12px;
}

.STYLE2 {
	font-size: 9px
}

.STYLE3 {
	color: #033d61;
	font-size: 12px;
}
-->
</style>

	</head>


	<body onload=startclock()>
		 <form name=clock>
			<%
				UserInfo userInfo = (UserInfo) request.getSession().getAttribute("userInfo");
			%>
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td height="70"
						background="<%=basePath%>resource/images/main_07.gif">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td height="24">
									<table width="100%" border="0" cellspacing="0" cellpadding="0">
										<tr>
											<td width="270" height="24"
												background="<%=basePath%>resource/images/main_03.gif">
												&nbsp;
											</td>
											<td width="505"
												background="<%=basePath%>resource/images/main_04.gif">
												&nbsp;
											</td>
											<td>
												&nbsp;
											</td>
											<td width="21">
												<img src="<%=basePath%>resource/images/main_07.gif"
													width="21" height="24">
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td height="38">
									<table width="100%" border="0" cellspacing="0" cellpadding="0">
										<tr>
											<td width="270" height="38"
												background="<%=basePath%>resource/images/main_09.gif">
												&nbsp;
											</td>
											<td>
												<table width="100%" border="0" cellspacing="0"
													cellpadding="0">
													<tr>
														<td width="77%" height="25" valign="bottom">
															<table width="100%" border="0" cellspacing="0"
																cellpadding="0">
																<tr>
																	<td width="50" height="19">
																		<div align="center">
																			<a
																				href="WorkQueryServlet"
																				target="mainFrame"><img
																					src="<%=basePath%>resource/images/main_12.gif"
																					width="49" height="19">
																			</a>
																		</div>
																	</td>
																	<td width="50">
																		<div align="center">
																			<a href="<%=basePath%>login.jsp?out=yes" target="_parent"><img
																					src="<%=basePath%>resource/images/main_20.gif"
																					width="48" height="19">
																			</a>
																		</div>
																	</td>
																	<td width="26">
																		<div align="center">
																			<img src="<%=basePath%>resource/images/main_21.gif"
																				width="26" height="19">
																		</div>
																	</td>
																	<td width="100">
																		<div align="center">
																			<a
																				href="UserUpdateServlet?id=<%=userInfo.getUser_id()%>"
																				target="mainFrame"><img
																					src="<%=basePath%>resource/images/main_22.gif"
																					width="98" height="19">
																			</a>
																		</div>
																	</td>
																	<td>
																		&nbsp;
																	</td>
																</tr>
															</table>
														</td>
														<td width="220" valign="bottom" nowrap="nowrap">
															<div align="right">
																<span class="STYLE1"><span class="STYLE2">■</span>
																	今天是：<input disabled="disabled" name=thetime
																		style="font-size: 9pt; background-color: #333333; color: #FFFFFF; border: 0"
																		size=25> </span>
															</div>
														</td>
													</tr>
												</table>
											</td>
											<td width="21">
												<img src="<%=basePath%>resource/images/main_11.gif"
													width="21" height="38">
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td height="8" style="line-height: 8px;">
									<table width="100%" border="0" cellspacing="0" cellpadding="0">
										<tr>
											<td width="270"
												background="<%=basePath%>resource/images/main_29.gif"
												style="line-height: 8px;">
												&nbsp;
											</td>
											<td width="505"
												background="<%=basePath%>resource/images/main_30.gif"
												style="line-height: 8px;">
												&nbsp;
											</td>
											<td style="line-height: 8px;">
												&nbsp;
											</td>
											<td width="21" style="line-height: 8px;">
												<img src="<%=basePath%>resource/images/main_31.gif"
													width="21" height="8">
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td height="28"
						background="<%=basePath%>resource/images/main_36.gif">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td width="177" height="28"
									background="<%=basePath%>resource/images/main_32.gif">
									<table width="100%" border="0" cellspacing="0" cellpadding="0">
										<tr>
											<td width="20%" height="22">
												&nbsp;
											</td>
											<td width="59%" valign="bottom">
												<div align="center" class="STYLE1">
													当前用户：<%=userInfo.getUser_name()%></div>
											</td>
											<td width="21%">
												&nbsp;
											</td>
										</tr>
									</table>
								</td>
								<td>
									<table width="100%" border="0" cellspacing="0" cellpadding="0">
										<tr>
											<td width="65" height="28">
												<table width="100%" border="0" cellspacing="0"
													cellpadding="0">
													<tr>
														<td height="23" valign="bottom">
															<table width="58" border="0" align="center"
																cellpadding="0" cellspacing="0">
																<tr>
																	<td height="20" style="cursor: hand"
																		onMouseOver="this.style.backgroundImage='url(<%=basePath%>resource/images/bg.gif)';this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#a6d0e7'; "
																		onmouseout="this.style.backgroundImage='url()';this.style.borderStyle='none'">
																		<div align="center" class="STYLE3">
																			<a href="WorkQueryServlet"
																				target="mainFrame">工作台</a>
																		</div>
																	</td>
																</tr>
															</table>
														</td>
													</tr>
												</table>
											</td>
											<td width="3"    <%   if  (userInfo.getRole_id()  !=  1 ) {%> style=" display: none  "  <%}%>>
												<img src="<%=basePath%>resource/images/main_34.gif"
													width="3" height="28">
											</td>
											<td width="63"    <%   if  (userInfo.getRole_id()  !=  1 ) {%> style=" display: none  "  <%}%>>
												<table width="58" border="0" align="center" cellpadding="0"
													cellspacing="0">
													<tr      >
														<td height="20" style="cursor: hand"
															onMouseOver="this.style.backgroundImage='url(<%=basePath%>resource/images/bg.gif)';this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#a6d0e7'; "
															onmouseout="this.style.backgroundImage='url()';this.style.borderStyle='none'">
															<div align="center" class="STYLE3">
																<a href="ReportFormsQueryServlet"
																	target="mainFrame">报表</a>
															</div>
														</td>
													</tr>
												</table>
											</td>
											<td width="3">
												<img src="<%=basePath%>resource/images/main_34.gif"
													width="3" height="28">
											</td>
											<td width="63">
												<table width="58" border="0" align="center" cellpadding="0"
													cellspacing="0">
													<tr>
														<td height="20" style="cursor: hand"
															onMouseOver="this.style.backgroundImage='url(<%=basePath%>resource/images/bg.gif)';this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#a6d0e7'; "
															onmouseout="this.style.backgroundImage='url()';this.style.borderStyle='none'">
															<div align="center" class="STYLE3">
																<a
																	href="CustomerQueryServlet?userId=<%=userInfo.getUser_id()%>"
																	target="mainFrame">客户信息</a>
															</div>
														</td>
													</tr>
												</table>
											</td>
											<td width="3">
												<img src="<%=basePath%>resource/images/main_34.gif"
													width="3" height="28">
											</td>
											<td width="63">
												<table width="58" border="0" align="center" cellpadding="0"
													cellspacing="0">
													<tr>
														<td height="20" style="cursor: hand"
															onMouseOver="this.style.backgroundImage='url(<%=basePath%>resource/images/bg.gif)';this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#a6d0e7'; "
															onmouseout="this.style.backgroundImage='url()';this.style.borderStyle='none'">
															<div align="center" class="STYLE3">
																<a href="ShowAllEmployees"
																	target="mainFrame">员工信息</a>
															</div>
														</td>
													</tr>
												</table>
											</td>
											<td width="3">
												<img src="<%=basePath%>resource/images/main_34.gif"
													width="3" height="28">
											</td>
											<td width="63">
												<table width="58" border="0" align="center" cellpadding="0"
													cellspacing="0">
													<tr>
														<td height="20" style="cursor: hand"
															onMouseOver="this.style.backgroundImage='url(<%=basePath%>resource/images/bg.gif)';this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#a6d0e7'; "
															onmouseout="this.style.backgroundImage='url()';this.style.borderStyle='none'">
															<div align="center" class="STYLE3">
																<a href="NoticeQueryServlet"
																	target="mainFrame">公告信息</a>
															</div>
														</td>
													</tr>
												</table>
											</td>
											<td width="3">
												<img src="<%=basePath%>resource/images/main_34.gif"
													width="3" height="28">
											</td>
											<td width="63">
												<table width="58" border="0" align="center" cellpadding="0"
													cellspacing="0">
													<tr>
														<td height="20" style="cursor: hand"
															onMouseOver="this.style.backgroundImage='url(<%=basePath%>resource/images/bg.gif)';this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#a6d0e7'; "
															onmouseout="this.style.backgroundImage='url()';this.style.borderStyle='none'">
															<div align="center" class="STYLE3">
																<a href="EmailQueryServlet"
																	target="mainFrame">发件箱</a>
															</div>
														</td>
													</tr>
												</table>
											</td>
											<td width="3">
												<img src="<%=basePath%>resource/images/main_34.gif"
													width="3" height="28">
											</td>
											<td width="63">
												<table width="58" border="0" align="center" cellpadding="0"
													cellspacing="0">
													<tr>
														<td height="20" style="cursor: hand"
															onMouseOver="this.style.backgroundImage='url(<%=basePath%>resource/images/bg.gif)';this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#a6d0e7'; "
															onmouseout="this.style.backgroundImage='url()';this.style.borderStyle='none'">
															<div align="center" class="STYLE3">
																<a href="HouseQueryServlet?userId=<%=userInfo.getUser_id()%>"
																	target="mainFrame">房屋信息</a>
															</div>
														</td>
													</tr>
												</table>
											</td>
											<td width="3">
												<img src="<%=basePath%>resource/images/main_34.gif"
													width="3" height="28">
											</td>
											<td width="63">
												<table width="58" border="0" align="center" cellpadding="0"
													cellspacing="0">
													<tr>
														<td height="20" style="cursor: hand"
															onMouseOver="this.style.backgroundImage='url(<%=basePath%>resource/images/bg.gif)';this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#a6d0e7'; "
															onmouseout="this.style.backgroundImage='url()';this.style.borderStyle='none'">
															<div align="center" class="STYLE3">
																<a
																	href="writeEmailServlet"
																	target="mainFrame">发送邮件</a>
															</div>
														</td>
													</tr>
												</table>
											</td>
											
											
											<td>
												&nbsp;
											</td>
										</tr>
									</table>
								</td>
								<td width="21">
									<img src="<%=basePath%>resource/images/main_37.gif" width="21"
										height="28">
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
