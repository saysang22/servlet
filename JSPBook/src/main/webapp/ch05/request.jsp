<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Request 내장객체</title>
</head>
<body>
	<h3>로그인</h3>
	<form name="login" method="post" action="process.jsp">
	<div>
		<span>아이디:</span>
		<input type="text" name="id"/>
	</div>
	<div>
		<span>비밀번호: </span>
		<input type="password" name="pw"/>
	</div>
	<div>
		<input type="submit" value="로그인"/>
		<input type="reset" value="취소"/>
	</div>
	</form>
</body>
</html>