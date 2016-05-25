<%@ page language="java" import="java.util.*,com.cl.easybuy.pojo.*"
	pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
<HEAD>
<TITLE>我的订单</TITLE>
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
	<H1 align="center">你所购买的商品如下：</H1>
	<TABLE cellSpacing="0" cellPadding="0" width="75%" align="center"
		border="1">
		<TBODY>
			<TR align="center">
				<TD width="21%" height="30">商品名称</TD>
				<TD width="14%" height="30">单价</TD>
				<TD width="25%" height="30">数量</TD>
				<TD width="33%" height="30">合计</TD>
			</TR>
			<%
				Cart cart = (Cart) session.getAttribute("cart");
				List<CartItem> items = cart.getItems();
				for (int i = 0; i < items.size(); i++) {
					CartItem item = items.get(i);
			%>

			<TR align="center">
				<TD height="30"><%=item.getProduct().getPname()%></TD>
				<TD height="30"><%=item.getProduct().getPrice()%></TD>
				<TD height="30"><%=item.getNumb()%></TD>
				<TD height="30"><%=item.getProduct().getPrice() * item.getNumb()%></TD>
			</TR>
			<%
				}
			%>
			<TR>
				<TD colSpan="5" height="30">您的购物车中所有商品总金额：<%=cart.getAccount()%></TD>
			</TR>
		</TBODY>
	</TABLE>
	<P>
	<H1 align="center">用户联系方式如下：</H1>
	<P></P>
	<FORM name="form1" action="add.order" method="post">
		<TABLE cellSpacing="0" cellPadding="0" width="500" align="center"
			border="0">
			<TR>
				<TD width="117" height="23">姓名：</TD>
				<TD width="383">匹夫</TD>
			</TR>
			<TR>
				<TD height="24">地址：</TD>
				<TD><INPUT value="长沙理工" name="address"></TD>
			</TR>
			<TR>
				<TD height="24">邮政编码：</TD>
				<TD><INPUT value="410010" name="postCode"></TD>
			</TR>
			<TR>
				<TD height="23">E-mail：</TD>
				<TD><INPUT value="haoren@163.com" name="email"></TD>
			</TR>
			<TR>
				<TD height="23">联系电话：</TD>
				<TD><INPUT value="8233110" name="homePhone"></TD>
			</TR>
		</TABLE>
		<BR> <br>
		<center>
			<input type="submit" value="生成定单"> <input type="button"
				value="返回" onclick="javascript:location.href='list.html'">
		</center>
	</FORM>
</BODY>
</HTML>
