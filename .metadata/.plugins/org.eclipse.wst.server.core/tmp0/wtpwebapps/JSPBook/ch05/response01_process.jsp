<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Implicit Object</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
	
		String userid = request.getParameter("id");
		String userpw = request.getParameter("pw");
		
		if(userid.equals("관리자") && userpw.equals("1234")) {
			response.sendRedirect("response01_success.jsp");
		} else {
			response.sendRedirect("response01_failed.jsp");
		}
	
	%>
</body>
</html>