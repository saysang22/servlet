<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, java.io.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Form</title>
</head>
<body>
	<%
		Enumeration paraNames = request.getParameterNames();
	
		while(paraNames.hasMoreElements()) {
			
			String name = (String) paraNames.nextElement();
			String paramvalue = request.getParameter(name);
			
			out.print("<div>" + paramvalue + "</div>");
		}
	%>
</body>
</html>