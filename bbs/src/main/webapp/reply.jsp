<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>답변글 쓰기 화면</title>
</head>
<body>
	<div>
		<h1>답변글 쓰기 화면</h1>
		<form action="reply.do" method="post">
			<input type="text" name="num" value="${retrieve.num}">
			<input type="text" name="reproot" value="${replyui.num}">
			<input type="text" name="repstep" value="${replyui.repstep}">
			<input type="text" name="repindent" value="${replyui.repindent}">
			
			<div>원래글번호 : ${replyui.num} &nbsp;</div>
			<div>조회수 : ${replyui.readcnt}</div>
			<div>제목 : <input type="text" name="title" value="${replyui.title}"></div>
			<div>작성자 : <input type="text" name="author"></div>
			<div>내용 : <textarea rows="10" cols="30" name="content" >${replyui.content}</textarea></div>
			<input type="submit" value="답변달기">
		</form>
		<a href="list.do">목록보기</a>
	</div>
</body>
</html>