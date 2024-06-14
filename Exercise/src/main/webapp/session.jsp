<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session</title>
</head>
<body>
	<form method="post" action="session_process.jsp" name="login">
		<p>아이디 : <input type="text" name="id">
		<p>비밀번호 : <input type="password" name="passwd"><br>
		<input type="submit" value= "전송">
	</form>
</body>
</html>