<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<style>
	.tel_size {
		width: 100px;
	}
	
	.wrap {
		display : flex;
	}
	
	.align {
		display : flex;
		flex-direction: column;
	}
</style>
</head>
<body>
	<h1>회원가입</h1>
	<form method="post" action="signup_ok.jsp" name="signup">
		<div class="wrap">
			<div class="left align">
				<label for="id">아이디: </label>
				<label for="pw">비밀번호: </label>
				<label for="name">이름: </label>
				<label for="tel">연락처: </label>
			</div>
			<div class="right align">
				<input type="text" name="id" id="id"/>
				<input type="password" name="pw" id="pw"/>
				<input type= "text" name="name" id="name"/>
				<div>
					<input type="text" name="tel01" class="tel_size" id="tel"/>
					-
					<input type="text" name="tel02" class="tel_size"/>
					-
					<input type="text" name="tel03" class="tel_size"/>
				</div>
			</div>
		</div>
		<div>
			<input type="submit" value="가입하기"/>
			<input type="reset" value="다시쓰기"/>
		</div>
	</form>
</body>
</html>