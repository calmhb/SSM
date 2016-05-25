<%@ page language="java" import="java.util.*,com.cl.easybuy.pojo.*"
	pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<HTML>
<HEAD>
<TITLE>message</TITLE>

<META http-equiv=Content-Type content="text/html; charset=utf-8">
</HEAD>
<BODY bgColor="#ffffff">
	<table width="100%" align="center" border="0" cellpadding="0"
		cellspacing="0" height="50">
		<tr>
			<td width="30%">&nbsp;</td>
			<td align="center"><font color="red" size="+1"><b>欢迎光临购物系统</b></font></td>
			<td width="30%" align="right" valign="bottom">&nbsp;</td>
		</tr>
		<tr>
			<td colspan="3" align="left">欢迎您,${user.username}</td>
		</tr>
	</table>
	<hr>
	<h2 align="center">订单已生成！您的订单号是：${oid }</h2>
	<center>
		<a href="list.cart">请返回</a>
	</center>
</BODY>
</HTML>