<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>유효성 검사</title>
<link rel="stylesheet" href="validationExample.css">
<script src="validationExample.js"></script>
</head>
<body onload="signUp.id.focus(); popup()">
	<form method="post" action="#" name="signUp">
		<fieldset>
			<legend>회원정보입력</legend>
			<div class="wrap">
				<ul class="firstUl">
					<li><label for="id">아이디</label></li>
					<li><label for="passwd">패스워드</label></li>
					<li><label for="passwdCk">패스워드 확인</label></li>
					<li><label for="name">이름</label></li>
					<li><label for="tel">휴대폰번호</label></li>
					<li><label for="email">이메일</label></li>
					<li><label for="birth">생일</label></li>
					<li><label for="home">홈페이지</label></li>
				</ul>
				<ul class="lastUl">
					<li><input type="text" name="id" id="id"></li>
					<li><input type="text" name="passwd" id="passwd"></li>
					<li><input type="text" name ="passwdCk" id="passwdCk"></li>
					<li><input type="text" name="name" id="name"></li>
					<li><input type="text" name="tel" id="tel"></li>
					<li><input type="text" name="email" id="email"></li>
					<li><input type="text" name="birth" id="birth"></li>
					<li><input type="text" name="home" id="home"></li>
				</ul>
				<div class="idCkWrap">
					<input type="button" value="중복검사">
				</div>
			</div>
			<div class="radioWrap">
				<ul>
					<li>
						<input type="radio" name="gender" id="man" >
						<label for="man" class="label">남성</label>
					</li>
					<li>
						<input type="radio" name="gender" id="woman">
						<label for="woman" class="label">여성</label>
					</li>
				</ul>
			</div>
		</fieldset>
		<div class="buttonWrap">
			<input type="button" value="제출" onclick="btnEv()">
			<input type="reset" value="초기화">
		</div>
	</form>
	

</body>
</html>