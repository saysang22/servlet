<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>정규 표현식</title>
</head>
<body onload="document.member.id.focus()">
	<h3>회원가입</h3>
	<form name="member" method="post" action="#">
		<div>
			아이디:
			<input type="text" name="id">
		</div>
		<div>
			비밀번호 : 
			<input type="password" name="passwd1">
		</div>
		<div>
			비밀번호 확인 : 
			<input type="password" name="passwd2">
		</div>
		<div>
			이름 : 
			<input type="text" name="name">
		</div>
		<div>
			생년월일 : 
			<input type="text" name="birth">
		</div>
		<div>
			연락처 : 
			<input type="text" name="tel">
		</div>
		<input type="button" value="회원가입" onclick="ckFun()">
		<input type="reset" value="가입취소">
	</form>
	
	<script src="./checkForm.js"></script>
</body>
</html>