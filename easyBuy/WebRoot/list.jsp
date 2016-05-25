<%@ page language="java" import="java.util.*,com.cl.easybuy.pojo.*"
	pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
<HEAD>
<TITLE>index</TITLE>
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
			<td colspan="3" align="right"><a href="login.html">登录</a></td>
		</tr>
	</table>
	<hr>

	<H1 align="center">
		本系统的所有商品列表如下： <BR> <BR>
		<center>
			<TABLE width="600" border="1">
				<TR height="25">
					<td>图片</td>
					<TD>产品名称</TD>
					<TD>产品价格</TD>
					<TD>产品描述</TD>
					<TD>添加到购物车</TD>
				</TR>

				<%
					//获得转发的数据
					List<Product> pros = (List<Product>) request.getAttribute("pros");
					for (int i = 0; i < pros.size(); i++) {
						Product p = pros.get(i);
				%>
				<TR>
					<td><img src="images/<%=p.getPic()%>" /></td>
					<TD><%=p.getPname()%></TD>
					<TD><%=p.getPrice()%></TD>
					<TD><%=p.getInfo()%></TD>
					<TD><A href="buy.cart?pid=<%=p.getId()%>">添加到购物车</A></TD>
				</TR>

				<%
					}
				%>



			</TABLE>
		</center>



		<BR> <a href="cart.jsp">查看购物车</a>
	</H1>
</BODY>
</HTML>