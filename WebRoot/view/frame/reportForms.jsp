<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.yao.entity.*"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>center</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	 <LINK href="<%=basePath%>resource/css/admin.css" type=text/css rel=stylesheet>
	<style type="text/css">
	#div1{
	
		width:100%;
		height:80%;
	
	}
#div2{
	
		width:100%;
		height:80%;
	
	}
	a{
	text-decoration: none;
	color: #033d61;
	font-size: 12px;
}

</style>

  </head>
  
  <body>
  <%List<TypeNum> tlist=(List<TypeNum>)request.getAttribute("tlist");
  //System.out.println(tlist==null);
  List<ConditionNum> clist=(List<ConditionNum>)request.getAttribute("clist");
  //System.out.println(clist==null);
  List<FenPeiNum> flist=(List<FenPeiNum>)request.getAttribute("flist");
  //System.out.println(flist==null);
  List<SourceNum> slist=(List<SourceNum>)request.getAttribute("slist");
  //System.out.println(slist==null);
  
  %>
    <form action="<%=basePath%>servlet/WorkQueryServlet" method="post"  >
	<table class=editTable cellSpacing=1 cellPadding=0 width="100%" align=center border=0>
		<tr class=editHeaderTr>
		<td class=editHeaderTd >  客户类型报表 
		<td class=editHeaderTd >  客户状态报表
  <tr>
    <td width="50%" bgcolor="#FFFDF0">
		<div align="center" id="div1">
		<table  class=editTable cellSpacing=1 cellPadding=0 width="100%" align=center border=0>
    			 <tr>
	 				 <td bgcolor="#FFFDF0"><div align="center">类型名称</div></td>
		 			 <td bgcolor="#FFFDF0"><div align="center">拥有人数</div></td>
   			 	</tr>	
   			 	<% 
						if(tlist!=null && tlist.size()>0){
								for(int i=0;i<tlist.size();i++){ 
									TypeNum t = tlist.get(i);
					%>
					<tr>
					<td colspan="1" bgcolor="#FFFFFF"><div align="center"><a  href="CustomerQueryServlet?currentPage=1&keyWord=<%=t.getType_name()%>&&queryType=4"> <%=t.getType_name()%> </a></div></td>
					<td colspan="1" bgcolor="#FFFFFF"><div align="center"><a  href="CustomerQueryServlet?currentPage=1&keyWord=<%=t.getType_name()%>&&queryType=4"><%=t.getType_num() %></a></div></td>
					</tr>  
					<%}}else{ %>
          						<tr>
										<td height="20" bgcolor="#FFFFFF" colspan="22"  align="center">
											<div align="center">
												<span class="STYLE1">所有类型都为空！</span>
											</div>
										</td>
									</tr>
          			<%} %> 			
   		 </table>
		</div>
	</td>
	
	
	
    <td bgcolor="#FFFDF0">
		<div align="center" id="div2">
			<table  class=editTable cellSpacing=1 cellPadding=0 width="100%" align=center border=0>
    			 <tr>
	 				 <td bgcolor="#FFFDF0"><div align="center">状态名称</div></td>
		 			 <td bgcolor="#FFFDF0"><div align="center">拥有人数</div></td>
   			 </tr>	
   			 
   			 <% 
						if(clist!=null && clist.size()>0){
								for(int i=0;i<clist.size();i++){ 
								ConditionNum c = clist.get(i);
					%>
    		<tr>
					<td colspan="1" bgcolor="#FFFFFF"><div align="center"><a  href="CustomerQueryServlet?currentPage=1&keyWord=<%=c.getCondition_name()%>&&queryType=2"><%=c.getCondition_name()%></a></div></td>
					<td colspan="1" bgcolor="#FFFFFF"><div align="center"><a  href="CustomerQueryServlet?currentPage=1&keyWord=<%=c.getCondition_name()%>&&queryType=2"><%=c.getNum()%></a></div></td>
   	 		</tr>
   	 		
   	 		<%}}else{ %>
          						<tr>
										<td height="20" bgcolor="#FFFFFF" colspan="22"  align="center">
											<div align="center">
												<span class="STYLE1">所有状态都为空！</span>
											</div>
										</td>
									</tr>
          			<%} %> 	
   		 </table>
		</div></td>
    </tr>
    
    
    <tr class=editHeaderTr>
		<td class=editHeaderTd >  客户来源报表
		<td class=editHeaderTd >  客户分配报表
  <tr>
    <td width="50%" bgcolor="#FFFDF0">
		<div align="center" id="div1">
		<table  class=editTable cellSpacing=1 cellPadding=0 width="100%" align=center border=0>
			
    			 <tr>
	 				 <td bgcolor="#FFFDF0"><div align="center">来源名称</div></td>
		 			 <td bgcolor="#FFFDF0"><div align="center">拥有人数</div></td>
   				 	</tr>	
   				 	
   				 	<% 
						if(slist!=null && slist.size()>0){
								for(int i=0;i<slist.size();i++){ 
								SourceNum s = slist.get(i);
					%>
					<tr>
					<td colspan="1" bgcolor="#FFFFFF"><div align="center"><a  href="CustomerQueryServlet?currentPage=1&keyWord=<%=s.getSource_name()%>&&queryType=3"><%=s.getSource_name()%></a></div></td>
					<td colspan="1" bgcolor="#FFFFFF"><div align="center"><a  href="CustomerQueryServlet?currentPage=1&keyWord=<%=s.getSource_name()%>&&queryType=3"><%=s.getNum()%></a></div></td>
					</tr>	
					<%}}else{ %>
          						<tr>
										<td height="20" bgcolor="#FFFFFF" colspan="22"  align="center">
											<div align="center">
												<span class="STYLE1">所有来源都为空！</span>
											</div>
										</td>
									</tr>
          			<%} %> 		
   		 </table>
		</div>
	</td>
	
	
	
    <td bgcolor="#FFFDF0">
		<div align="center" id="div2">
			<table  class=editTable cellSpacing=1 cellPadding=0 width="100%" align=center border=0>
    			 <tr>
	 				 <td bgcolor="#FFFDF0"><div align="center">分配状态</div></td>
		 			 <td bgcolor="#FFFDF0"><div align="center">拥有人数</div></td>
   			 </tr>
   	 		
   	 		<% 
								if(flist.size()!=0){
					%>
   	 		<tr>			
					<td colspan="1" bgcolor="#FFFFFF"><div align="center"><a  href="CustomerQueryNoAdmeasureServlet">未分配客户</a></div></td>
					<td colspan="1" bgcolor="#FFFFFF"><div align="center"><a  href=CustomerQueryNoAdmeasureServlet><%=flist.size()%></a></div></td>
   	 		</tr>	
   	 		<%}else{ %>
          						<tr>
										<td height="20" bgcolor="#FFFFFF" colspan="22"  align="center">
											<div align="center">
												<span class="STYLE1">所有客户都已分配！</span>
											</div>
										</td>
									</tr>
          			<%} %> 	
   		 </table>
		</div></td>
    </tr>
</table>
</form>
  </body>
</html>
