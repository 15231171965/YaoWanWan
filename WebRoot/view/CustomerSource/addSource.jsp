<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addSource.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<LINK href="<%=basePath%>resource/css/admin.css" type=text/css  rel=stylesheet>
	<script type="text/javascript" src="jquery-1.11.3.js"></script>
	<script type="text/javascript" src="<%=basePath%>resource/js/CheckForm.js"></script>
<script type="text/javascript">
function  check()
	{
		
		var sname=$("#sname").val();
		
		if(sname==""||sname==null)
			{
			alert("请输入名字");
			return false;
			}
			
	}

</script>
  </head>
  
  <body>
		<form action="add"  name="form3" onsubmit="return check()" method="post"    >
			<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
				align=center border=0>
				<tr class=editHeaderTr>
					<td class=editHeaderTd colSpan=7>
						请输入顾客来源的详细信息
					</td>
				</tr>
				<tr>
					<td width="19%" bgcolor="#FFFDF0">
						<div align="center">
							顾客来源名称：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text" id="sname" name="sname"   maxlength="20" check_str="顾客来源名称">
						&nbsp;
					</td>
				</tr>

			</table>
			<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
				align=center border=0>
				<tr bgcolor="#ECF3FD">
					<td width="10%"></td>
					<td width="10%"><input type="submit" name="submit"  value="提交"></td>
					<td width="5%"><input type="button" name="button"  onClick="history.go(-1) "  value="返回"></td>
					<td width="75%"></td>
				</tr>
			</table>

		</form>
	</body>
</html>
