<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>유효성 검사</title>
</head>
<body onload="form.focus()">
	<form method="post" name="form" action="validation_process.jsp">
		<label>아이디</label>
		<input type="text" name="id" id="id">
		<label>비밀번호</label>
		<input type="text" name="passwd" id="passwd">
		<input type="button" value="전송" onclick="subFn()">
	</form>
<script>

	function subFn() {
		let id = document.querySelector("#id");
		let passwd = document.querySelector("#passwd");
		let msg = "아이디 or 비밀번호를 입력해주세요";
		if(id.value == "" || passwd.value == "") {
			alert(msg);
		}
		
		form.submit();
	}
</script>
</body>
</html>