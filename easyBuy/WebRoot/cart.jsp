<%@ page language="java" import="java.util.*,com.cl.easybuy.pojo.*"
	pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
<HEAD>
<TITLE>我的购物车</TITLE>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<script type="text/javascript">
//定义一个js函数发送请求
   function modifyNum(pid){
	 //获得用户输入的值
	var text= document.getElementById("num"+pid);
	var numb=text.value;
	//通过location向服务器发送请求
	location.href='modify.cart?pid='+pid+'&numb='+numb;
 }
</script>
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
	<H1 align="center">购物车</H1>
	<%
		Cart cart = (Cart) session.getAttribute("cart");
		List<CartItem> items = null;
		if (cart != null) {
			items = cart.getItems();
		}

		if (cart == null || items.isEmpty()) {
	%>
	<h1>
		您还没有选择任何商品,请<a href="list.cart">继续购物</a>
	</h1>
	<%
		} else {
	%>
	<FORM name="cartForm" action="order.jsp" method="post">
		<table cellspacing="0" cellpadding="0" width="80%" align="center"
			border="1">
			<tr align="center">
				<td width="7%">编号</td>
				<td width="20%" height="30">商品名称</td>
				<td width="12%" height="30">单价</td>
				<td width="20%" height="30">数量</td>
				<td width="15%" height="30">合计</td>
				<td width="26%" height="30">&nbsp;</td>
			</tr>

			<%
				for (int i = 0; i < items.size(); i++) {
						CartItem item = items.get(i);
			%>

			<tr align="center">
				<td height="30"><%=i + 1%></td>
				<td height="30"><%=item.getProduct().getPname()%></td>
				<td height="30"><%=item.getProduct().getPrice()%></td>
				<td height="30"><%=item.getNumb()%></td>
				<td height="30"><%=item.getNumb() * item.getProduct().getPrice()%></td>
				<td height="30"><input id="num<%=item.getProduct().getId()%>"
					type="text" name="num" size="6" /> <a href="javascript:;"
					onclick="modifyNum(<%=item.getProduct().getId()%>);">修改数量</a> <a
					href="del.cart?pid=<%=item.getProduct().getId()%>">删除</a></td>
			</tr>
			<%
				}
			%>

			<tr>
				<td colspan="6" height="30">您的购物车中所有商品总金额：<%=cart.getAccount()%></td>
			</tr>
		</table>
		<BR> <BR>
		<TABLE cellSpacing="0" cellPadding="0" width="600" align="center"
			border="0">
			<TR align="center">
				<TD width="26%"><INPUT
					onClick="javascript:location.href='clear.cart'" type="button"
					value="清空购物车" name="submit"></TD>
				<TD width="12%"><INPUT type="submit" value="结&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;账" name="submit"></TD>
				<TD width="20%"><INPUT
					onClick="javascript:location.href='list.cart'" type="button"
					value="继续购物"></TD>
			</TR>
		</TABLE>
		<%
			}
		%>