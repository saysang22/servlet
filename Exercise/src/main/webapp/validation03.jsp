<%@ page contentType="text/html; charset=utf-8"%>
<html>
<head>
<title>Validation</title>
</head>
<script>
    function checkPasswd() {
    	let passwd = document.querySelector("#passwdConfirm");
    	let regPasswd = /^[a-zA-Z0-9!@#$%^&*]$/;
    	let msg = "영문-숫자-특수기호 8자리 이상으로 구성하여야 합니다.";
    	if(passwd.value.match(regPasswd)) {
    		alert(msg);
    		return false;
    	}
    	
    	if(passwd.value.length < 8) {
    		alert(msg);
    	}
    }
</script>

<body>
	<form name="form" action="validation_process.jsp" method="post">
		<p>아이디 : <input type="text" id="id" name="id">
		<p>비밀번호 : <input type="password" id="passwd" name="passwd">
		<p>비밀번호 확인 : <input type="password" id="passwdConfirm"> 
		<p><input type="button" value="전송" onclick="checkPasswd()">
	</form>
</body>
<html>