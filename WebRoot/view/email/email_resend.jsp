<%@ page language="java" import="java.util.*,com.yao.entity.*" pageEncoding="utf-8" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>发送邮件</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<LINK href="<%=basePath%>resource/css/admin.css" type=text/css rel=stylesheet>
<script type="text/javascript"
			src="<%=basePath%>resource/js/CheckForm.js"></script>
		<script type="text/javascript"
			src="<%=basePath%>resource/js/My97DatePicker/WdatePicker.js"></script>
	<script language=JavaScript>
		
			function subForm(){
				
						//获取表单对象
						
						var f1 = document.getElementById("f1");
						f1.action = "EmailCaoGaoSevlet";
						f1.submit();
		
		}
				
</SCRIPT>
  </head>
  
  <body  onload=startclock()>
<form action="EmailAddServlet"   id="f1"   method="post" name="form2" onsubmit="return checkForm('form2');" >

<%-- <%    EmailInfo  emailInfo   =(EmailInfo)  request.getAttribute("emailInfo")  ;%> --%>

<table class=editTable cellSpacing=1 cellPadding=0 width="100%" align=center border=0>
<tr class=editHeaderTr>
<td class=editHeaderTd colSpan=7>  请输入邮件的详细信息
<%-- <input   type="hidden" name="emailId"   value="<%=emailInfo.getEmail_id() %>"  />  --%>
</td>
</tr>  
	 
	 
	 <tr>
		<td bgcolor="#FFFDF0"><div align="center">收件人：</div></td>
		<td colspan="3" bgcolor="#FFFFFF"><select name="addressee" style=" width: 580px">
		<%List <CustomerInfo> customerList =(List <CustomerInfo>) request.getAttribute("customerList"); %>
		<%for ( int i=0;i<customerList.size();i++){
											CustomerInfo customerInfo =customerList.get(i);
			%>		
			<option  value="<%=customerInfo.getCustomer_id() %>"   <%-- <%  if ( customerInfo.getCustomer_id()  == emailInfo.getCustomer_id()  )  {%> selected="selected" <%} %>  --%> ><%=customerInfo.getCustomer_name() %></option>
			<% }%>
		</select>&nbsp;</td>
    </tr>
<tr>
      <td bgcolor="#FFFDF0"><div align="center">主题：</div></td>
    <td colspan="3" bgcolor="#FFFFFF"><input type="text" style="width:580px"   value="<%-- <%=emailInfo.getEmail_theme() %> --%>"   check_str="主题" name="emailTheme">
     </td>
    </tr>
	 

  	<tr>
  		  	<td bgcolor="#FFFDF0"><div align="center">内容：</div></td>
    		<td colspan="3" bgcolor="#FFFFFF"><textarea  check_str="内容"  rows="20"      name="emailContent" style="width:578px; resize:none; height:300px;"><%-- <%=  emailInfo.getEmail_content() %> --%></textarea></td>
    </tr>
    <tr>
		<td bgcolor="#FFFDF0"><div align="center">发件人：</div></td>
		<td colspan="3" bgcolor="#FFFFFF">
			<%UserInfo userInfo = (UserInfo)request.getSession().getAttribute("userInfo"); %>								
			<input type="hidden" value="<%=userInfo.getUser_id() %>" name="addresser">&nbsp;&nbsp;<%=userInfo.getUser_name() %>
			
		</select>&nbsp;</td>
		<td>
			<input type="hidden"    value="<%=new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())%>"  name="emailTime" >
		</td>
    </tr>
</table>
<table class=editTable cellSpacing=1 cellPadding=0 width="100%" align=center border=0>
  <tr bgcolor="#ECF3FD">
    <td width="12%">&nbsp;</td>
    <td width="12%"><input type="submit" name="Submit" value="发送" <%-- <%  if ( userInfo.getUser_id()  != emailInfo.getUser_id()  )  {%> disabled="disabled" <%} %> --%> ></td><td width="12%">
    <input type="submit"  value="存草稿" onclick="subForm()" <%-- <%  if ( userInfo.getUser_id()  != emailInfo.getUser_id()  )  {%> disabled="disabled" <%} %> --%> ></td>
    <td width="40%"><input type="button" name="back" value="返回" onClick="history.back() "></td>
  </tr>
</table>

</form>
</body>
</html>
