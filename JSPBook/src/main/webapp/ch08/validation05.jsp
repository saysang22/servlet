<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>유효성 검사</title>
</head>
<body onload="document.member.id.focus()">
	<h3>회원 가입</h3>
	<form method="post" action="#" name="Member">
		<p>아이디 : <input type="text" name="id">
		<p>비밀번호 : <input type="password" name="passwd">
		<p>이름 : <input type="text" name="name">
		<p>연락처 : 
		<select name="phone1">
			<option value="010">010</option>
			<option value="011">011</option>
			<option value="016">016</option>
			<option value="017">017</option>
			<option value="019">019</option>
		</select>
		-
		<input type="text" maxlength="4" size="4" name="phone2">
		-
		<input type="text" maxlength="4" size="4" name="phone3">
		<p>이메일 : <input type="text" name="email">
		<p><input type="button" value="가입하기" onclick="ckfn()">
	</form>
	
	<script src="./validation05.js"></script>
</body>
</html>