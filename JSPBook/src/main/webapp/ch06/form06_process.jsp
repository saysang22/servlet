<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.io.*, java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Form</title>
</head>
<body>
	<table border=1>
		<tr>
			<th>요청 파라미터 이름</th>
			<th>요청 파라미터 값</th>
		</tr>
		<%
			Enumeration paraNames = request.getParameterNames();
			
			while(paraNames.hasMoreElements()) {
				String name = (String) paraNames.nextElement();
				out.print("<tr><td>" + name + "</td>\n");
				String paraValue = request.getParameter(name);
				out.println("<td>" + paraValue + "</td></tr>\n");
			}
		%>
	</table>
</body>
</html>