<%@ page language="java" import="java.util.*,com.yao.entity.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'linkrecord_list.jsp' starting page</title>
    
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
.STYLE1 {font-size: 12px}
.STYLE3 {font-size: 12px; font-weight: bold; }
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
<script type="text/javascript">
function add() {
	location.href="AddLinkRecord";
	//alert("gsa");
}
</script>

<script type="text/javascript" src="<%=basePath%>resource/js/jquery-1.11.3.js"></script>
<script type="text/javascript" src="<%=basePath%>resource/js/doPage.js"></script>
  </head>
  
  <body>
  
 <form action="showLinkRecord" method="post">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	  <tr>
    <td height="30" background="<%=basePath%>resource/images/tab_05.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="12" height="30"><img src="<%=basePath%>resource/images/tab_03.gif" width="12" height="30" /></td>
                <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td class="STYLE4" align="center">&nbsp;&nbsp;请输入查询内容：<input type="text" name="whoLinkInput" style="width: 290px"/></td>
            <td class="STYLE4">&nbsp;&nbsp;请选择查询方式：<select name="queryType" style="width: 100px">
      					<option id="c1" value="1" >联系客户</option>
     				 	<option id="c2" value="2" >联系主题</option>
     				 	<option id="c3" value="3" >联系类型</option>
   				 </select>
   				 <script>document.getElementById("<%=request.getAttribute("c")%>").selected="selected"</script>            
   				</td>
            <td class="STYLE4">&nbsp;&nbsp;<input  type="submit" value="查询" style="width:50px"/></td>  
            <td class="STYLE4">&nbsp;&nbsp;<input  type="button" value="添加" onclick="add()" style="width:50px"/></td>          
          </tr>
        </table></td>
        <td width="16"><img src="<%=basePath%>resource/images/tab_07.gif" width="16" height="30" /></td>
      </tr>
    </table></td>
  </tr>


    <tr>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="8" background="<%=basePath%>resource/images/tab_12.gif">&nbsp;</td>
        <td><table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="b5d6e6" onmouseover="changeto()"  onmouseout="changeback()">
          <tr>
            <td width="4%" height="22" background="<%=basePath%>resource/images/bg2.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">序号</span></div></td>
            <td width="7%" height="22" background="<%=basePath%>resource/images/bg2.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">客户姓名</span></div></td>
            <td width="10%" background="<%=basePath%>resource/images/bg2.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">联系时间</span></div></td>

		<td width="10%" height="22" background="<%=basePath%>resource/images/bg2.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">下次联系时间</span></div></td>
            <td width="7%" height="22" background="<%=basePath%>resource/images/bg2.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">联系类型</span></div></td>

		<td width="10%" height="22" background="<%=basePath%>resource/images/bg2.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">是谁联系的</span></div></td>
		<td width="20%" height="22" background="<%=basePath%>resource/images/bg2.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">联系主题</span></div></td>

	<td width="20%" height="22" background="<%=basePath%>resource/images/bg2.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">联系备注</span></div></td>
            <c:if test="${userInfo.role_id==1}">
            <td     width="15%" height="22" background="<%=basePath%>resource/images/bg2.gif" bgcolor="#FFFFFF" class="STYLE1"><div align="center">基本操作</div></td>
         </c:if>
          </tr>
          <%if(request.getAttribute("list")!=null){ %>
          	<%List<CustomerLinkrecord> list=(List<CustomerLinkrecord>)request.getAttribute("list"); %>
          	<%for(int i=0;i<list.size();i++){ %>
			<tr>
			<td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1"><%=i+1 %></span></div></td>
				 <td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1"><%=list.get(i).getCustomer_name() %></span></div></td>
				<td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1"><%=list.get(i).getLink_time() %></span></div></td>
				<td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1"><%=list.get(i).getLink_nexttime() %></span></div></td>
				<td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1"><%=list.get(i).getLink_type() %></span></div></td>
				<td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1"><%=list.get(i).getWho_link() %></span></div></td>
				<td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1"><%=list.get(i).getLink_theme() %></span></div></td>
				<td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1"><%=list.get(i).getLink_remark() %></span></div></td> 
				 <c:if test="${userInfo.role_id==1}">
				 <td  height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE4"><img src="<%=basePath%>resource/images/del.gif" width="16" height="16" /><a href="deletelinkrecord?recordId=<%=list.get(i).getRecord_id()%>">删除</a></span></div></td>
				</c:if>
			</tr>
			<% }%>
		<%}else{ %>
			<tr>
				<td height="20" bgcolor="#FFFFFF" colspan="4"  align="center">
					<div align="center">
						<span class="STYLE1">没有客户状态相关信息</span>
					</div>
				</td>
			</tr>
		<%} %>
		<tr>
			<!-- <td height="20" bgcolor="#FFFFFF" colspan="9" align="center"><span class="STYLE1">没有数据！</span></td> -->
		</tr>
	
         
        </table></td>
        <td width="9" background="<%=basePath%>resource/images/tab_15.gif">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="35" background="<%=basePath%>resource/images/tab_19.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="12" height="35"><img src="<%=basePath%>resource/images/tab_18.gif" width="12" height="35" /></td>
        <td><%-- <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td class="STYLE4">&nbsp;&nbsp;共有  条记录，当前第 1/1 页</td>
            <td><table border="0" align="right" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="40"><img src="<%=basePath%>resource/images/first.gif" width="37" height="15" /></td>
                  <td width="45"><img src="<%=basePath%>resource/images/back.gif" width="43" height="15" /></td>
                  <td width="45"><img src="<%=basePath%>resource/images/next.gif" width="43" height="15" /></td>
                  <td width="40"><img src="<%=basePath%>resource/images/last.gif" width="37" height="15" /></td>
                  <td width="100"><div align="center"><span class="STYLE1">转到第
                    <input name="textfield" type="text" size="4" style="height:12px; width:20px; border:1px solid #999999;" /> 
                    页 </span></div></td>
                  <td width="40"><img src="<%=basePath%>resource/images/go.gif" width="37" height="15" /></td>
                </tr>
            </table></td>
          </tr>
        </table> --%>
        <%@ include file="../page.jsp"%></td>
        <td width="16"><img src="<%=basePath%>resource/images/tab_20.gif" width="16" height="35" /></td>
      </tr>
    </table></td>
  </tr>
</table>
</form>
</body>
</html>
