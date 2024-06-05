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
	
	. left {
	
	}
	
	.align {
		display : flex;
		flex-direction: column;
	}
</style>
</head>
<body>
	<h1>회원가입</h1>
	<form method="post" action="form04_process.jsp" name="signup">
		<div class="wrap">
			<div class="left align">
				<label for="id">아이디: </label>
				<label for="pw">비밀번호: </label>
				<label for="name">이름: </label>
				<label for="tel">연락처: </label>
				<label for="sex">성별: </label>
				<span>취미: </span>
			</div>
			<div class="right align">
				<input type="text" name="id" id="id" autofocus required/>
				<input type="password" name="passwd" id="pw" required/>
				<input type= "text" name="name" id="name" placeholder="이름을 입력하세요" required/>
				<div>
					<select name="phone1">
						<option value="010">010</option>
						<option value="011">011</option>
						<option value="016">016</option>
						<option value="017">017</option>
						<option value="019">019</option>
					</select>
					-
					<input type="text" name="phone2" class="tel_size" maxlength=4 size="4"/>
					-
					<input type="text" name="phone3" class="tel_size" maxlength=4 size="4"/>
				</div>
				<div>
					<input type="radio" name="sex" checked value="남성"/>남성
					<input type="radio" name="sex"  value="여성"/>여성
				</div>
				<div>
					<label for="book">독서</label>
					<input type="checkbox" name="hobby" id="book" value="독서" checked/>
					<label for="hel">운동</label>
					<input type="checkbox" name="hobby" id="hel" value="운동"/>
					<label for="movie">영화</label>
					<input type="checkbox" name="hobby" id="movie" value="영화"/>
				</div>
			</div>
		</div>
		<div>
			<textarea rows="3" cols="30" name="comment" placeholder="가입 인사를 입력해주세요." wrap="soft"></textarea>
		</div>
		<div>
			<input type="submit" value="가입하기"/>
			<input type="reset" value="다시쓰기"/>
		</div>
	</form>
</body>
</html>