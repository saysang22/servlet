<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Form_Process</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
	
		String name = request.getParameter("name");
		String addr = request.getParameter("addr");
		String email = request.getParameter("email");
	%>
	<%= "<div>아이디: " + name + "</div>"%>
	<%= "<div>주소: " + addr + "</div>" %>
	<%= "<div>이메일: " + email + "</div>" %>
</body>
</html>