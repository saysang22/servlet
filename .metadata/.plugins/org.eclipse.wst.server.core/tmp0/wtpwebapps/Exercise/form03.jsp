<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>form</title>
</head>
<body>
	<form method="get" action="form03_process.jsp">
		<label>오렌지</label>
		<input type="checkbox" name="name" value="오렌지" />
		<label>사과</label>
		<input type="checkbox" name="name" value="사과"/>
		<label>바나나</label>
		<input type="checkbox" name="name" value="바나나"/>
		<input type="submit" value="전송"/>
	</form>
</body>
</html>