<%@ page language="java" import="java.util.*,com.yao.entity.*,com.oracle.util.*" pageEncoding="UTF-8"%>
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

	a{
	text-decoration: none;
	color: #033d61;
	font-size: 12px;
}

A:hover {
	COLOR: #f60; TEXT-DECORATION: underline
}


.STYLE3 {
	font-size: 12px;
	font-weight: bold;
}

.STYLE4 {
	color: #03515d;
	font-size: 12px;
}
-->
</style>
<script language="JavaScript" type="text/javascript" src="<%=basePath%>resource/js/jquery-1.11.3.js"></script>
		<script>
var  highlightcolor='#c1ebff';
//此处clickcolor只能用win系统颜色代码才能成功,如果用#xxxxxx的代码就不行,还没搞清楚为什么:(
var  clickcolor='#51b2f6';
function  changeto(){
source=event.srcElement;
if  (source.tagName=="TR"||source.tagName=="TABLE")
return;
while(source.tagName!="TD")
source=source.parentElement;
source=source.parentElement;
cs  =  source.children;
//alert(cs.length);
if  (cs[1].style.backgroundColor!=highlightcolor&&source.id!="nc"&&cs[1].style.backgroundColor!=clickcolor)
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor=highlightcolor;
}
}

function  changeback(){
if  (event.fromElement.contains(event.toElement)||source.contains(event.toElement)||source.id=="nc")
return
if  (event.toElement!=source&&cs[1].style.backgroundColor!=clickcolor)
//source.style.backgroundColor=originalcolor
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor="";
}
}

function  clickto(){
source=event.srcElement;
if  (source.tagName=="TR"||source.tagName=="TABLE")
return;
while(source.tagName!="TD")
source=source.parentElement;
source=source.parentElement;
cs  =  source.children;
//alert(cs.length);
if  (cs[1].style.backgroundColor!=clickcolor&&source.id!="nc")
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor=clickcolor;
}
else
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor="";
}
}
</script>
<script type="text/javascript">
	function add(){  
			window.location="NoticeAddServlet";
		}

</script>
<script type="text/javascript" src="<%=basePath%>resource/js/doPage.js"></script>
</head>

	<body>
	<%UserInfo  userInfo  =   (UserInfo)request.getSession().getAttribute("userInfo");
			 %>
	<form action="NoticeQueryServlet"  method="post">
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
											&nbsp;&nbsp;请输入查询内容：
											<input type="text" name="noticeInput" style="width: 290px" />
										</td>
										<td class="STYLE4">&nbsp;&nbsp;请选择查询方式：<select name="queryType" style="width: 100px">
      											<option id="q1" value="1">公告主题</option>
     				 							<option id="q2" value="2">公告内容</option>
   				 							</select>         
   				 							<script>document.getElementById("<%=request.getAttribute("q")%>").selected="selected"</script>   
   										</td>
										<td class="STYLE4">
											&nbsp;&nbsp;
											<input type="submit" value="查询" style="width: 50px" />
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
											bgcolor="#FFFFFF" style="width: 5%; height: 22px;">
											<div align="center">
												<span class="STYLE1">序号</span>
											</div>
										</td>
										<td background="<%=basePath%>resource/images/bg2.gif"
											bgcolor="#FFFFFF" style="width: 5%; height: 22px;">
											<div align="center">
												<span class="STYLE1">公告人</span>
											</div>
										</td>
										<td background="<%=basePath%>resource/images/bg2.gif"
											bgcolor="#FFFFFF" style="width: 12%; height: 22px;">
											<div align="center">
												<span class="STYLE1">公告主题</span>
											</div>
										</td>
										<td background="<%=basePath%>resource/images/bg2.gif"
											bgcolor="#FFFFFF" style="width:48%; height: 22px;">
											<div align="center">
												<span class="STYLE1">公告内容</span>
											</div>
										</td>
										<td background="<%=basePath%>resource/images/bg2.gif"
											bgcolor="#FFFFFF" style="width: 10%; height: 22px;">
											<div align="center">
												<span class="STYLE1">公告时间</span>
											</div>
										</td>
										<td background="<%=basePath%>resource/images/bg2.gif"
											bgcolor="#FFFFFF" style="width: 10%; height: 22px;">
											<div align="center">
												<span class="STYLE1">公告截止时间</span>
											</div>
										</td>
										<td    <%   if  (userInfo.getRole_id()  !=  1 ) {%> style=" display: none  "  <%}%>    width="10%"
											background="<%=basePath%>resource/images/bg2.gif"
											bgcolor="#FFFFFF" class="STYLE1"
											style="width: 10%; height: 22px;">
											<div align="center">
												基本操作
											</div>
										</td>
									</tr>
							<% List<NoticeInfo> list = (List<NoticeInfo>)request.getAttribute("list");
								/* Page doPage = (Page)session.getAttribute("page");
								int pageSize = doPage.getPageSize();
								int currentPage = doPage.getCurrentPage(); */
								if(list!=null && list.size()>0){
										for(int i=0;i<list.size();i++){ 
											NoticeInfo noticeInfo = list.get(i);
							%>

									<tr>
										<td height="20" bgcolor="#FFFFFF" style="width: 5%">
											<div align="center" class="STYLE1">
												<div align="center">
													<%=i+1/* i+1+pageSize*(currentPage-1) */ %>
												</div>
											</div>
										</td>
										<td height="20" bgcolor="#FFFFFF" style="width: 5%">
											<div align="center">
												<span class="STYLE1"><%=noticeInfo.getUser_name()%></span>
											</div>
										</td>
										<td height="20" bgcolor="#FFFFFF" style="width: 8%">
											<div align="center">
												<span class="STYLE1"><%=noticeInfo.getNotice_item() %></span>
											</div>
										</td>
										<td height="20" bgcolor="#FFFFFF" style="width: 40%">
											<div align="center">
												<span class="STYLE1"><%=noticeInfo.getNotice_content() %></span>
											</div>
										</td>
										<td height="20" bgcolor="#FFFFFF" style="width: 10%">
											<div align="center">
												<span class="STYLE1"><%=noticeInfo.getNotice_time() %></span>
											</div>
										</td>
										<td height="20" bgcolor="#FFFFFF" style="width: 10%">
											<div align="center">
												<span class="STYLE1"><%=noticeInfo.getNotice_endtime() %></span>
											</div>
										</td>
										<td   <%   if  (userInfo.getRole_id() !=  1 ) {%> style=" display: none  "  <%}%>  height="20" bgcolor="#FFFFFF" style="width: 10%">
											<div align="center">
												<span class="STYLE4"><img src="<%=basePath%>resource/images/del.gif"
														width="16" height="16" /><a
													href="NoticeDeleteServlet?noticeId=<%=noticeInfo.getNotice_id() %>">删除</a>
												</span>
											</div>
										</td>
									</tr>
									<% } }else{ %>
								<tr>
										<td height="20" bgcolor="#FFFFFF" colspan="7"  align="center">
											<div align="center">
												<span class="STYLE1">没有相关公告信息</span>
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
								<%@ include file="../page.jsp"%>
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
