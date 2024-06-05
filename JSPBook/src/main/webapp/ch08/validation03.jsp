<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>유효성 검사</title>
</head>
<body>
	<form name="login" action="validation03_process.jsp" method="post">
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
			
			if(form.id.value.length < 4 || form.id.value > 12) {
				
				alert("아이디는 4~12자 이내로 입력 가능합니다!");
				form.id.focus();
				return false;
	
			}
			
			if(form.passwd.value.length < 4) {
				
				alert("비밀번호는 4자 이상으로 입력해야 합니다!");
				form.passwd.focus();
				return false;
			}
			
			form.submit();
			
			
		}
	</script>
</body>
</html>