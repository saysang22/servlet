<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드</title>
</head>
<body>
	<form method="post" action="fileupload01_process.jsp" enctype="multipart/form-data">
		<input type="file" name="name"/>
		<input type="submit" value="파일 올리기"/>
	</form>
</body>
</html>