<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>유효성 검사</title>
</head>
<body>
	<h3>로그인</h3>
	<form name="login" method="post" action="#">
		<div>아이디 : <input type="text" name="id"/></div>
		<div>비밀번호 : <input type="password" name="passwd"/></div>
		<input type="button" value="로그인" onclick="ckForm()"/>
	</form>
	
	<script>
		function ckForm() {
			
			let id = login.id.value
			let pw = login.passwd.value
			
			alert( id + "\n" + pw);
		}
	</script>
</body>
</html>