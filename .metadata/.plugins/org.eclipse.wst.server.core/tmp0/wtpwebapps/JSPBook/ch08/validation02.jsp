<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>유효성 검사</title>
</head>
<body onload="document.login.id.focus()">
	<form name="login" action="validation02_process.jsp" method="post">
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
			
			let id = login.id;
			let pw = login.passwd;
			
			if (id.value == "") {
				
				alert("아이디를 입력해주세요.");
				id.focus();
				return false;
				
			} else if(pw.value == "") {
				
				alert("비밀번호를 입력해주세요.");
				pw.focus();
				return false;
			}
			
			form.submit();
		}
		
	
	</script>
</body>
</html>