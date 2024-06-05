<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 성공</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
	
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");	
		String name = request.getParameter("name");	
		String tel01 = request.getParameter("tel01");
		String tel02 = request.getParameter("tel02");
		String tel03 = request.getParameter("tel03");
	%>
	<div>
		<span>아이디: </span>
		<span><%= id %></span>
	</div>
	<div>
		<span>비밀번호: </span>
		<span><%= pw %></span>
	</div>
	<div>
		<span>이름: </span>
		<span><%= name %></span>
	</div>
	<div>
		<span>연락처: </span>
		<span><%= tel01 %></span>
		-
		<span><%= tel02 %></span>
		-
		<span><%= tel03 %></span>
	</div>
	
</body>
</html>