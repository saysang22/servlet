<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Locale" %>
<%
		Locale locale = request.getLocale();
		String displayLanguage = locale.getDisplayLanguage();
		String language = locale.getLanguage();
		String displayCountry = locale.getDisplayCountry();
		String contry = locale.getCountry();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		out.print("로케일 언어: " + displayLanguage );
		out.print("로케일 언어: " + language + "<br>");
		out.print("로케일 언어: " + displayCountry + "<br>");
		out.print("로케일 언어: " + contry + "<br>");
	
	%>
</body>
</html>