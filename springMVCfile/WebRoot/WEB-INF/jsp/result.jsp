<%@page pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head></head>
<body style="font-size: 30px; font-style: italic;">
	<c:if test="${fileUrl != null}">
		<a href="${fileUrl }">查看</a>
	</c:if>
	<hr />
	<ul>
		<c:forEach items="${fileUrls}" var="url">
			<li><a href="${url }">查看</a></li>
		</c:forEach>
	</ul>
</body>
</html>