<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<% if("yes".equals(request.getParameter("out")))
		session.invalidate();
%>
<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<style type="text/css" >
	
	#body{
	
		background: url("./resource/images/mainV.jpg") no-repeat;
		
	}
	#div{
		position: absolute;
		margin-top: 300px;
		margin-left: 660px;
		
	}
	table{
   	border-collapse:   separate;   border-spacing:   25px;   
  } 
	</style>

<script language="JavaScript" type="text/javascript" src="<%=basePath%>resource/js/FormValid.js"></script>

<script type="text/javascript">
	function exists(){
		if('${param.isExist}'=="no"){
			alert("用户不存在！");
		}
	}
</script>
  </head>
 
  <body onload="exists()" id="body" >
  <div id="div">
  
<form action="login" method="post" onsubmit="return validator(this)" style="text-align: center">
<table class="table">
	 <tr>
	 	<td><b>用户</b></td>
             <td> <input type="text" name="userNum"  valid="required|regexp" 
             regexp="^[A-Za-z0-9]+$" errmsg="用户名不能为空!|账号只能由字母和数字组成!"  
             style="width:150px; height:25px; background-color:#292929; border:solid 1px #7dbad7; font-size:20px; color:#6cd0ff">
   		 </td>
    </tr>
    <tr>
          <td><b>密码</b></td> 
          <td>
          <input type="password" name="userPw"   valid="required"  errmsg="密码不能为空!" 
          style="width:150px; height:25px; background-color:#292929; border:solid 1px #7dbad7; font-size:20px; color:#6cd0ff">
		  </td>
    </tr> 
     <tr> 
    	 <td colspan="2" style="text-align: center">
    	 	<input type="submit"  value="登陆" style="font-size: 20;margin-top: 30px"/>
    	 	
     		<input type="reset"  value="重置" style="font-size: 20 ;margin-left: 20px;margin-top: 30px"/>
     	</td>      
      </tr> 
</table>

</form>
</div>
  </body>
</html>
