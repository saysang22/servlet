<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>유효성 검사</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
	
	%>
	
	아이디 : <%= id %>
	비밀번호 : <%= passwd %>
</body>
</html>