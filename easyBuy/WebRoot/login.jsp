<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
<HEAD>
<title>登录页面</title>
<META http-equiv=Content-Type content="text/html; charset=utf-8">

</HEAD>
<BODY bgColor="#ffffff">
	<table width="100%" align="center" border="0" cellpadding="0"
		cellspacing="0" height="50">
		<tr>
			<td width="30%">&nbsp;</td>
			<td align="center"><font color="red" size="+1"><b>欢迎光临购物系统</b></font></td>
			<td width="30%" align="right" valign="bottom"><a
				href="register.html"><span style="text-decoration:none">还没有账号，马上注册</span></a></td>
		</tr>
	</table>
	<hr>
	<h2 align="center">
		<%
			String err_msg = (String) request.getAttribute("err_msg");
		%>
		用户登录 <br /> <font color="red"><%=err_msg == null ? " " : err_msg%></font>

		<form action="login" method="post">
			用户名：<input type="text" name="name"><br> 密&nbsp;&nbsp;码：
			<input type="password" name="password"><br> <input
				type="submit" value="登录">
		</form>
	</h2>
</BODY>
</HTML>