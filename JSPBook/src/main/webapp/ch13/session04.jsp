<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session</title>
</head>
<body>
	<h4>---- 세션을 삭제하기 전 ----</h4>
	<%
		String user_id = (String) session.getAttribute("userID");
		String user_pw = (String) session.getAttribute("userPW");
		
		out.println("설정된 세션의 속성 값 [1] : " + user_id + "<br>");
		out.println("설정된 세션의 속성 값 [2] : " + user_pw + "<br>");
		
		session.removeAttribute("userID");
		session.removeAttribute("userPW");
		
	%>
	<h4>---- 세션을 삭제한 후 ----</h4>
	<%
		 user_id = (String) session.getAttribute("userID");
		 user_pw = (String) session.getAttribute("userPW");
		
		out.println("설정된 세션의 속성 값 [1] : " + user_id + "<br>");
		out.println("설정된 세션의 속성 값 [2] : " + user_pw + "<br>");
	%>
</body>
</html>