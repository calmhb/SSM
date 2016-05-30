<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>My JSP 'login.jsp' starting page</title>

<meta http-equiv="content-type" content="text/html;charset=utf-8">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<h1>用户登录</h1>
	${msg }
	<form action="login.do" method="post">
		用户名:<input type="text" name="username" /><br /> 密码:<input
			type="text" name="pwd"><br /> <input type="submit"
			value="登录" />
	</form>

	<br>
</body>
</html>
