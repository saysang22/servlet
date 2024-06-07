<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메시지 처리</title>
</head>
<body>
	<% String language = request.getParameter("language"); %>
	<fmt:setLocale value="<%= language %>" />
	<fmt:setBundle basename="ch09.com.test.message" />
	이름 : <fmt:message key="name" /><br>
	메시지 : <fmt:message key="hello" /><br>
	
</body>
</html>