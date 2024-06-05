<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
<style>

	ul {
		list-style: none;
		
	}

	.wrap {
		width: 500px;
		margin: 0 auto;
	}
	
	.inputWrap {
		display: flex;
	}
</style>
</head>
<body>
	<div class="wrap">
		<h1>게시판 글쓰기 화면</h1>
		<form action="write.do" method="post">
			<div class="inputWrap">
				<ul>
					<li><label>제목</label></li>
					<li><label>작성자</label></li>
					<li><label>내용</label></li>
				</ul>
				<ul>
					<li><input type="text" name="title"></li>
					<li><input type="text" name="author"></li>
					<li><input type="text" name="content"></li>
				</ul>
			</div>
			<input type="submit" value="저장">
		</form>
		<a href="list.do" class="btn">목록보기</a>
	</div>
</body>
</html>