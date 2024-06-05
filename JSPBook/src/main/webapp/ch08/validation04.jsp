<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>유효성 검사</title>
</head>
<body>
	<form name="login" action="validation04_process.jsp" method="post">
		<div>
			아 이 디 : <input type="text" name="id"/>
		</div>
		<div>
			비밀번호 : <input type="password" name="passwd"/>
		</div>
		<input type="button" value="전송" onclick="ckFun()"/>
	</form>
	<script>
		function ckFun() {
			let form = document.login;
			
			if(form.id.value == "") {
				alert("아이디를 입력해주세요.");
				form.id.focus();
				return false;
			}
			
			for(let i = 0; i < form.id.value.length; i++) {
				let ch = form.id.value.charAt(i);
				
				if((ch < 'a' || ch > 'z') && (ch > 'A' || ch < 'z') && (ch > '0' || ch < '9')) {
					alert("아이디는 영문 소문자만 입력 가능합니다!");
					form.id.focus();
					return false;
				}
			}
			
			if(isNaN(form.passwd.value) || (form.passwd.value == "")) {
				alert("비밀번호는 숫자만 입력 가능합니다!");
				form.passwd.focus();
				return false;
			}
			
			form.submit();
		}
	</script>
</body>
</html>