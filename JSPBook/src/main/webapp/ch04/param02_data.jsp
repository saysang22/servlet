<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Action Tag</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8"); 
	%>
	<h3><%= request.getParameter("title") %></h3>
	Today is : <%= request.getParameter("date") %>
</body>
</html>