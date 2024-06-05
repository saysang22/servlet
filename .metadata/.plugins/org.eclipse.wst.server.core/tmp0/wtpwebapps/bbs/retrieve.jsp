<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 자세히 보기</title>
<style>

	ul {
		list-style: none;
	}
	
	.wrap {
		width: 500px;
		margin: 0 auto;
	}
	
	.ulWrap {
		display: flex;
	}
	
	input, textarea {
		width: 300px;
	}
	
	.subBtn {
		width: 80px;
	}
</style>
</head>
<body>
	<div class="wrap">
		<h1>글 자세히 보기</h1>
		<form action="update.do" method="post">
			<input type="hidden" name="num" value="${retrieve.num}">
			<div class="ulWrap">
				<ul>
					<li>글 번호: </li>
					<li>조회수: </li>
					<li>제목: </li>
					<li>작성자: </li>
					<li>내용: </li>
				</ul>
				<ul>
					<li>${retrieve.num}</li>
					<li>${retrieve.readcnt}</li>
					<li><input type="text" name="title" value="${retrieve.title}"></li>
					<li><input type="text" name="author" value="${retrieve.author}"></li>
					<li>
						<textarea rows="10" cols="20" name="content">${retrieve.content}</textarea>
					</li>
				</ul>
			</div>
			<input type="submit" value="수정" class="subBtn">
			<input type="reset" value="초기화" class="subBtn">
		</form>
		<a href="list.do">목록으로</a>
		<a href="delete.do?num=${retrieve.num}">삭제하기</a>
		<a href="replyui.do?num=${retrieve.num}">답변달기</a>
	</div>
</body>
</html>