<%@ page language="java" import="java.util.*,com.yao.entity.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>客户关怀查询</title>
    
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
<script language="JavaScript" type="text/javascript" src="<%=basePath%>resource/js/jquery-1.11.3.js"></script>
<script>
var  highlightcolor='#c1ebff';
var  clickcolor='#51b2f6';
function  changeto(){
source=event.srcElement;
if  (source.tagName=="TR"||source.tagName=="TABLE")
return;
while(source.tagName!="TD")
source=source.parentElement;
source=source.parentElement;
cs  =  source.children;
if  (cs[1].style.backgroundColor!=highlightcolor&&source.id!="nc"&&cs[1].style.backgroundColor!=clickcolor)
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor=highlightcolor;
}
}

function  changeback(){
if  (event.fromElement.contains(event.toElement)||source.contains(event.toElement)||source.id=="nc")
return
if  (event.toElement!=source&&cs[1].style.backgroundColor!=clickcolor)
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
			window.location="CustomerCareAddServlet";
		}
	function deleteCheck(){
		var falg="<%=request.getAttribute("careDelete")%>";
		if(flag=="ok"){
			alert("删除成功")
		}
		if(flag=="false"){
			alert("删除失败")
		}
	}
</script>
<script type="text/javascript" src="<%=basePath%>resource/js/doPage.js"></script>
  </head>
  
  <body>
  
  <%-- <%
						UserInfo  userInfo  =   (UserInfo)request.getSession().getAttribute("userInfo2");
			 %> --%>
  <form  action="CustomerCareFindServlet" method="post">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="30" background="<%=basePath%>resource/images/tab_05.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="12" height="30"><img src="<%=basePath%>resource/images/tab_03.gif" width="12" height="30" /></td>
                <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td class="STYLE4" align="center">&nbsp;&nbsp;请输入查询内容：<input type="text" name="customerInput" style="width: 290px"/></td>
            <td class="STYLE4">&nbsp;&nbsp;请选择查询方式：<select name="queryType" style="width: 100px">
      					<option id="c1" value="1" >关怀客户</option>
     				 	<option id="c2" value="2" >关怀主题</option>
     				 	<option id="c3" value="3" >关怀方式</option>
   				 </select>
   				 <script>document.getElementById("<%=request.getAttribute("c")%>").selected="selected";</script>
   				</td>
            <td class="STYLE4">&nbsp;&nbsp;<input  type="submit" value="查询" style="width:50px"/></td>           
          <td class="STYLE4">&nbsp;&nbsp;<input  type="button"  onclick="add()" value="添加"  style="width:50px"/></td>           
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
            <td width="2%" height="22" background="<%=basePath%>resource/images/bg2.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">序号</span></div></td>
            <td width="3%" height="22" background="<%=basePath%>resource/images/bg2.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">客户</span></div></td>
            <td width="4%" height="22" background="<%=basePath%>resource/images/bg2.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">关怀主题</span></div></td>
            <td width="4%" height="22" background="<%=basePath%>resource/images/bg2.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">关怀方式</span></div></td>
				
	    <td width="5%" height="22" background="<%=basePath%>resource/images/bg2.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">关怀时间</span></div></td>
	    <td width="5%" height="22" background="<%=basePath%>resource/images/bg2.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">下次关怀时间</span></div></td>
	    
		<td width="10%" height="22" background="<%=basePath%>resource/images/bg2.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">备注</span></div></td>
 	<td width="3%" height="22" background="<%=basePath%>resource/images/bg2.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">关怀人</span></div></td>
           
	   		<td width="4%" height="22" background="<%=basePath%>resource/images/bg2.gif" bgcolor="#FFFFFF" class="STYLE1"><div align="center">基本操作</div></td>

</tr>
			<%List<Care> list=(List<Care>)request.getAttribute("list"); %>
			<%if(list.size()!=0&&list!=null){ %>
                    <%for(int i=0;i<list.size();i++){ %>
 		<tr>
            <td height="20" bgcolor="#FFFFFF"><div align="center" class="STYLE1">
              <div align="center"><%=i+1 %></div>
            </div></td>
            <td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1"><%=list.get(i).getCustomer_name() %></span></div></td>
            <td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1"><%=list.get(i).getCare_theme() %></span></div></td>
   	    <td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1"><%=list.get(i).getCare_way() %></span></div></td>
            <td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1"><%=list.get(i).getCare_time() %></span></div></td>
            <td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1"><%=list.get(i).getCare_nexttime() %></span></div></td>
		<td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1"><%=list.get(i).getCare_remark() %></span></div></td>
		 <td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1"><%=list.get(i).getCare_people() %></span></div></td>
             <td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE4"><img src="<%=basePath%>resource/images/edt.gif" width="16" height="16" />
             <a href="customerRedactCareUpdateServlet?careId=<%=list.get(i).getCare_id()%>">编辑</a>&nbsp; &nbsp;<img src="<%=basePath%>resource/images/del.gif" width="16" height="16" />
             <a href="customerDeleteCareDeleteServlet?careId=<%=list.get(i).getCare_id()%>">删除</a></span></div></td>
      	</tr>
      		<%} %>		
      <%}else{ %>
							<tr>
								<td height="20" bgcolor="#FFFFFF" colspan="21"  align="center">
									<div align="center">
										<span class="STYLE1">没有员工相关信息</span>
									</div>
								</td>
							</tr>
                   <%} %>
        </table></td>
        <td width="8" background="<%=basePath%>resource/images/tab_15.gif">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="35" background="<%=basePath%>resource/images/tab_19.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="12" height="35"><img src="<%=basePath%>resource/images/tab_18.gif" width="12" height="35" /></td>
        <td>
        	<%@ include file="../page.jsp"%>
        	
        </td>
        <td width="16"><img src="<%=basePath%>resource/images/tab_20.gif" width="16" height="35" /></td>
      </tr>
    </table></td>
  </tr>
</table>
</form>
  </body>
 
</html>
