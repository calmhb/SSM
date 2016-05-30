<%@page pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<html>
<title>上传图片</title>
<body>
	${errors }
	<form action="upload.do" method="post" enctype="multipart/form-data">
		<input type="file" name="file" /> <input type="submit" value="Submit" />
	</form>
	<hr />
	<form action="uploads.do" method="post" enctype="multipart/form-data">
		<input type="file" name="file" /><br /> <input type="file"
			name="file" /> <input type="submit" value="Submit" />
	</form>
</body>
</html>
