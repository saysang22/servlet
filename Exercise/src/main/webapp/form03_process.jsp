<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CheckBox</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
	
		String[] name = request.getParameterValues("name");
		
		out.print("<h1>선택한 과일</h1>");
		if(name != null) {
			for(int i = 0; i < name.length; i++) {
				
				out.print(name[i] + ", ");
			}
		}
	%>
</body>
</html>