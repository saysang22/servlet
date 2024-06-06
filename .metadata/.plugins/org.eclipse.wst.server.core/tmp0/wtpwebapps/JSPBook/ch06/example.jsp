<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Registration</title>

<style>

	table,
	td,
	tr {
		border : 1px solid #333;
	}

	
	table {
	
		border-collapse : collapse;
		width: 600px;
		margin: 10px auto 0;
	}
	
	td {
		padding: .5rem;
	}
	
	.btn {
		background : green;
		color : #fff;
		border: none;
		padding : .5rem 1.3rem;
		cursor : pointer
	}
	
	.top_wrap {
		width: 600px;
		margin: 30px auto 0;
	}
	
	.font_size {
		font-size : 2rem;
		font-weight : bold;
	}
	
	.gray {
		color: #555;
	}
	
	.green {
		color: green;
	}
	
	.small {
		font-size : .7rem;
	}
	
	.point {
		color : red;
	}
</style>
</head>
<body>
	<div class="top_wrap">
		<div class="top">
			<span class="gray font_size">Customer</span>
			<span class="green font_size">Registration</span>
		</div>
		<div class="bottom">
			<span class="small">환영합니다.</span>
		</div>
	</div>
	<form method="post" action="example_process.jsp" name="signup">
		<table>
			<tr>
				<td><label for="id"><span class="point">* </span>아이디</label></td>
				<td><input type="text" name="id" id="id" required autofocus/></td>
			</tr>
			<tr>
				<td><label for="pw"><span class="point">* </span>비밀번호</label></td>
				<td><input type="text" name="pw" id="pw" required /></td>
			</tr>
			<tr>
				<td rowspan="2">
				<label for="email"><span class="point">* </span>이메일</label></td>
				<td>
				<input type="text" name="email" id="email" required />
				@
				<select name="back_email">
					<option value="naver.com">naver.com</option>
					<option value="google.com">google.com</option>
					<option value="daum.net">daum.net</option>
				</select>
				</td>
			</tr>
			<tr>
				<td>
					<span>뉴스를 받으시겠습니까?</span>
					<input type="radio" name="ra" id="ra1" value="수신동의" checked/>
					<label for="ra1" >수신동의</label>
					<input type="radio" name="ra" id="ra2" value="동의안함"/>
					<label for="ra2">동의안함</label>
				</td>
			</tr>
			<tr>
				<td><span class="point">* </span>관심정보</td>
				<td>
					<input type="checkbox" name="ck" id="ck1" value="피부관리"/>
					<label for="ck1">피부관리</label>
					<input type="checkbox" name="ck" id="ck2" value="천연화장품"/>
					<label for="ck2">천연화장품</label>
					<input type="checkbox" name="ck" id="ck3" value="피부나이측정"/>
					<label for="ck3">피부나이측정</label>
				</td>
			</tr>
			<tr>
				<td><label for="memo"><span class="point">* </span>메모</label></td>
				<td><textarea rows="" cols="60" name="memo" placeholder="메모를 작성하세요." required ></textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" class="btn" value="확인"/></td>
			</tr>
		</table>
	</form>
</body>
</html>