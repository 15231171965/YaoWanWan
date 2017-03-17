<%@ page language="java"  pageEncoding="UTF-8"%>

<td>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td class="STYLE4">
				&nbsp;&nbsp;共有 ${page.allsize} 条记录，当前第 ${page.currentpage}/${page.lastPage}页
			</td>
			<td colspan="4" class="STYLE4" >
				<a href="javascript:dooperate('first','${requestURL}','${page.currentpage}','${page.lastPage}','${keyWord }')">首页</a>&nbsp;&nbsp;
				<a href="javascript:dooperate('next','${requestURL}','${page.currentpage}','${page.lastPage}','${keyWord}')">下页</a>&nbsp;&nbsp;
				<a href="javascript:dooperate('pre','${requestURL}','${page.currentpage}','${page.lastPage}','${keyWord}')">上页</a>&nbsp;&nbsp;
				<a href="javascript:dooperate('last','${requestURL}','${page.currentpage}','${page.lastPage}','${keyWord}')">末页</a>&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				跳转到第<input size="2" id="gopage" >页&nbsp;<input type="button" value="Go" 
				onclick="dooperate('go','${requestURL}','${page.currentpage}','${page.lastPage}','${keyWord}')">
			</td>  
		</tr>
	</table>
</td>
