<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>

<html>
  <head>
    <base href="<%=basePath%>">
    <title>添加部门信息</title>
	<link rel="stylesheet" href="css/bootstrap.min.css">    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="<%=basePath%>resource/js/CheckForm.js"></script>
	
	

<script type="text/javascript"
			src="<%=basePath%>resource/js/CheckForm.js"></script>
		<script type="text/javascript"
			src="<%=basePath%>resource/js/My97DatePicker/WdatePicker.js">
		</script>
		<script>
			function test(){
				if(${info!=null})
					alert('${info}');
			}
		</script>		
	 </head>
  
  <body onload="test()">


<form class="form" action="AddDepartmentServlet" method="post" name="form2" onsubmit="return checkForm('form2');">
<table class="table table-striped table-hover">
<tr class="tr">
<td class="td">  请输入新部门的详细信息</td>
</tr>  
  <tr>
    <td width="19%" bgcolor="#FFFDF0"><div align="center">部门名称：</div></td>
    <td colspan="3" bgcolor="#FFFFFF"><input type="text"  style=" width: 100%"  maxlength="20"  name="departmentName" check_str="部门名称">
      </td>
    </tr>
  <tr>
    <td bgcolor="#FFFDF0"><div align="center">部门描述：</div></td>
    <td colspan="5" bgcolor="#FFFFFF"><textarea  rows="10" name="departmentDesc"   style="width:100%; resize:none; "s></textarea>
      &nbsp;</td>
    </tr>
  
</table>
<table class=editTable cellSpacing=1 cellPadding=0 width="100%" align=center border=0>
  <tr bgcolor="#ECF3FD">
    		<td width="25%"></td>
					<td width="17%"><input type="submit" name="submit"  value="添加"></td>
					<td width="17%"><input type="reset" name="reset"  value="重置"></td>
					<td width="4%"><input type="button" name="button"  onClick="history.back() "  value="返回"></td>
					<td width="43%"></td>
  </tr>
</table>

</form>
</body>
</html>
