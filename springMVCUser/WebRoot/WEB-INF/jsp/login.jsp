<%@ page pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<!DOCTYPE HTML>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url var="base" value="/"></c:url>
<html>
  <head>
    <title>Login Form</title>
    <link rel="stylesheet" type="text/css" href="${base}/css/styles.css">
  </head>
	<body>
		<h6>${message}</h6>
		<form method="get" action="${base}login/login-action1.do">
			<div>
				<h2>登录 login-action1.do</h2>
				<p><label>用户</label><input type="text" name="name"></p>
				<p><label>密码</label><input type="password" name="pwd"></p>
				<h3><input type="submit" value="登录"></h3>
			</div>
		</form>
		
		<form method="post" action="${base}login/login-action2.do">
			<div>
				<h2>登录 login-action2.do</h2>
				<p><label>用户</label><input type="text" name="name"></p>
				<p><label>密码</label><input type="password" name="pwd"></p>
				<h3><input type="submit" value="登录"></h3>
			</div>
		</form>
		
		<form method="post" action="${base}login/login-action3.do">
			<div>
				<h2>登录 login-action3.do</h2>
				<p><label>用户</label><input type="text" name="name"></p>
				<p><label>密码</label><input type="password" name="pwd"></p>
				<h3><input type="submit" value="登录"></h3>
			</div>
		</form>
		
		<form method="post" action="${base}login/login-action4.do">
			<div>
				<h2>登录 login-action4.do</h2>
				<p><label>用户</label><input type="text" name="name"></p>
				<p><label>密码</label><input type="password" name="pwd"></p>
				<h3><input type="submit" value="登录"></h3>
			</div>
		</form>
		
		<form method="post" action="${base}login/login-action5.do">
			<div>
				<h2>登录 login-action5.do</h2>
				<p><label>用户</label><input type="text" name="name"></p>
				<p><label>密码</label><input type="password" name="pwd"></p>
				<h3><input type="submit" value="登录"></h3>
			</div>
		</form>
		
		<form method="post" action="${base}login/login-action6.do">
			<div>
				<h2>登录 login-action6.do</h2>
				<p>${next}</p>
				<p><label>用户</label><input type="text" name="name" value="${name}"></p>
				<p><label>密码</label><input type="password" name="pwd"></p>
				<h3><input type="submit" value="登录"></h3>
			</div>
		</form>
		
	</body>
</html>