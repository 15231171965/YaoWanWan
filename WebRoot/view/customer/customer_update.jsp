<%@ page language="java" import="java.util.*,com.yao.entity.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
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

		<title>修改客户信息</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<LINK href="<%=basePath%>resource/css/admin.css" type=text/css
			rel=stylesheet>
		<script type="text/javascript"
			src="<%=basePath%>resource/js/CheckForm.js"></script>
		<script type="text/javascript"
			src="<%=basePath%>resource/js/My97DatePicker/WdatePicker.js"></script>
		<script language="JavaScript" type="text/javascript" src="<%=basePath%>resource/js/FormValid.js"></script>
		<script>
			function check(){
				var flag="<%=session.getAttribute("updateSignal")%>";
				if(flag=="ok"){
					<%session.removeAttribute("updateSignal");%>
					alert("修改成功");
				}else if(flag=="false"){
					<%session.removeAttribute("updateSignal");%>
					alert("修改失败");
				}
			}
		</script>
	</head>

	<body onload="check()">
	<%
	List<UserInfo> ulist=(List<UserInfo>)request.getAttribute("ulist");
	List<CustomerInfo> list=(List<CustomerInfo>)request.getAttribute("customerId");
	List<CustomerSource> slist=(List<CustomerSource>)request.getAttribute("slist");
	List<CustomerCondition> clist=(List<CustomerCondition>)request.getAttribute("clist");
	List<CustomerType> tlist=(List<CustomerType>)request.getAttribute("tlist");
	CustomerInfo c=list.get(0);
	System.out.println(c.getCondition_id()+"jsp");
	/*System.out.println("ulist="+ulist.size());//测试
	System.out.println("list="+list.size());
	System.out.println("slist="+slist.size());
	System.out.println("clist="+clist.size());
	System.out.println("tlist="+tlist.size());*/
	%>
		<form action="CustomerUpdateServlet2"
			method="get" name="form2" onsubmit="return validator(this)" >
		

			<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
				align=center border=0>
				<tr class=editHeaderTr>
					<td class=editHeaderTd colSpan=7>
						请修改客户信息
						<input type="hidden" name="customerId"
							value="<%=c.getCustomer_id() %>" />
					</td>
				</tr>
				<tr>
					<td width="12%" bgcolor="#FFFDF0"><div align="center">负责员工：</div></td>
					<td colspan="3" bgcolor="#FFFFFF">					
						<select id="s1" name="customerForUser" style=" width: 145px">
							<%for(UserInfo u:ulist){ %>
								<option id="u+<%=u.getUser_id() %>" value="<%=u.getUser_id() %>"><%=u.getUser_name() %></option>
							<% }%>
						</select>
						<script>document.getElementById("u+<%=c.getUser_id() %>").selected="selected";</script>
					</td>
					<td width="12%" bgcolor="#FFFDF0">
						<div align="center">
							客户来源：
						</div>
					</td>
					<td width="37%" colspan="3" bgcolor="#FFFFFF">
						<select name="customerSource" style="width: 145px">
							<%for(CustomerSource s :slist){ %>
								<option id="s+<%=s.getSource_id() %>" value="<%=s.getSource_id() %>"><%=s.getSource_name() %></option>
							<%} %>
						</select>
						<script>document.getElementById("s+<%=c.getSource_id() %>").selected="selected";</script>
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							客户姓名：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text" style=" width: 145px" readonly="readonly" name="customerName"
							value="<%=c.getCustomer_name()%>">
					</td>
					<td bgcolor="#FFFDF0">
						<div align="center">
							客户状态：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<select name="customerCondition" style="width: 145px">
							<%for(CustomerCondition condition : clist){ %>
								<option id="c+<%=condition.getCondition_id() %>" value="<%=condition.getCondition_id() %>">
								<%=condition.getCondition_name() %>
								</option>
							<%} %>
						</select>
						<script>document.getElementById("c+<%=c.getCondition_id() %>").selected="selected";</script>
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							客户性别：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input id="man" type="radio" name="customerSex" value="男" ${customerInfo.customerSex=="男"?"checked='checked'":""}/>男&nbsp;&nbsp;&nbsp;&nbsp;
						<input id="wuman" type="radio" name="customerSex" value="女" ${customerInfo.customerSex=="女"?"checked='checked'":""}/>女
						<!-- 实现默认选择性别 -->
						<script type="text/javascript">
						var sex="<%=c.getCustomer_sex()%>";
						var sexs=document.getElementsByName("customerSex");
						for(i=0;i<sexs.length;i++){
							if(sexs[i].value==sex){
								sexs[i].checked="checked";
							}
						}
						</script>
						<br />
					</td>
					<td bgcolor="#FFFDF0">
						<div align="center">
							客户类型：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<select name="customerType" style="width: 145px">
						<%for(CustomerType ct:tlist){ %>
								<option id="t+<%=ct.getType_id() %>" value="<%=ct.getType_id()%>"><%=ct.getType_name() %></option>
								<%} %>
						</select>
						<script>document.getElementById("t+<%=c.getType_id() %>").selected="selected";</script>
					</td>
				</tr>

				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							出生日期：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text"style=" width: 145px"  disabled="disabled" name="customerBirthday"
							value="<%=c.getBirth_day()%>"
							readonly="readonly" id="customerBirthday">
							<!-- onclick="WdatePicker({el:customerBirthday,dateFmt:'yyyy-MM-dd HH:mm:ss '})" -->
						&nbsp;
					</td>
					<td bgcolor="#FFFDF0">
						<div align="center">
							客户手机：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text" style=" width: 145px"    valid="regexp"  regexp="^1[3|4|5|8][0-9]\d{8}$"   errmsg="请输入正确的手机号码!"   name="customerMobile"
							value="<%=c.getCustomer_mobile()%>">
						&nbsp;
					</td>
				</tr>

				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							客户QQ：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text" style=" width: 145px"   valid="isQQ"   errmsg="请输入正确的QQ号码!"  name="customerQQ"
							value="<%=c.getCustomer_qq()%>">
						&nbsp;
					</td>
					<td bgcolor="#FFFDF0">
						<div align="center">
							客户地址：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text" style=" width: 145px"  maxlength="50" name="customerAddress"
							value="<%=c.getCustomer_address()%>">
						&nbsp;
					</td>
				</tr>

				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							客户邮箱：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text" style=" width: 145px"  maxlength="50" name="customerEmail"  valid="required|isEmail"  errmsg="Email不能为空|Email格式不对!" value="<%=c.getCustomer_email()%>">
						&nbsp;
					</td>
					<td bgcolor="#FFFDF0">
						<div align="center">
							客户职位：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text" style=" width: 145px"  maxlength="50" name="customerJob"
							value="<%=c.getCustomer_job() %>">
						&nbsp;
					</td>
				</tr>

				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							客户微博：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text" style=" width: 145px" maxlength="50"  name="customerBlog"
							value="<%=c.getCustomer_blog()%>">
						&nbsp;
					</td>
					<td bgcolor="#FFFDF0">
						<div align="center">
							客户座机：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text" style=" width: 145px" valid="isPhone"   errmsg="请输入正确的座机号码!" name="customerTel"
							value="<%=c.getCustomer_tel()%>">
						&nbsp;
					</td>
				</tr>

				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							客户MSN：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text" style=" width: 145px" maxlength="50"  name="customerMsn"
							value="<%=c.getCustomer_msn()%>">
						&nbsp;
					</td>
					<td bgcolor="#FFFDF0">
						<div align="center">
							客户公司：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text" style=" width: 145px"  maxlength="50" name="customerCompany"
							value="<%=c.getCustomer_company()%>">
						&nbsp;
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							创建人：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text" style=" width: 145px" disabled="disabled" name="customerAddMan"
							value="<%=c.getCustomer_addman()%>">
						<input type="hidden"
							value="<%=new Date().getTime()%>"
							name="customerChangeTime">
						<input type="hidden" name="customerAddTime"
							value="<%=c.getCustomer_addtime().getTime() %>"
							readonly="readonly" id="customerAddTime">
					</td>
					<td bgcolor="#FFFDF0">
						<div align="center">
							修改人：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text" style=" width: 145px"  maxlength="50" name="customerChangeMan"
							value="<%=c.getChange_man() %>">
						&nbsp;
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							备注：
						</div>
					</td>
					<td colspan="6" bgcolor="#FFFFFF">
						<textarea rows="10" name="customerRemark"
							style="width: 100%; resize: none;"><%=c.getCustomer_remark() %></textarea>
					</td>
					
				</tr>
			</table>
			<table>
			<tr>
				<td><input style="display:none" name="conditionId" type="text" value="<%=c.getCondition_id()%>"></td>
				<td><input style="display:none" name="isUsedId" type="text" value="<%=c.getType_id()%>"></td>
				<td><input style="display:none" name="typeId" type="text" value="<%=c.getType_id()%>"></td>
				<td><input style="display:none" name="sourceId" type="text" value="<%=c.getSource_id()%>"></td>
				<td><input style="display:none" name="userId" type="text" value="<%=c.getUser_id()%>"></td>
			</tr>
			</table>
			<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
				align=center border=0>
				<tr bgcolor="#ECF3FD">
					<td width="36%"></td>
					<td width="17%"><input type="submit" name="submit"  value="提交"></td>
					<td width="4%"><input type="button" name="button"  onClick="history.back() "  value="返回"></td>
					<td width="43%"></td>
				</tr>
			</table>
		</form>
	</body>
</html>
