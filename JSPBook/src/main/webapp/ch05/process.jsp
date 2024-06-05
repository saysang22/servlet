<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Request 내장객체</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8"); //한글깨짐 방짐
	
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
	%>
	<div>
	<span>
		아이디:
	</span>
	<span>
		<%= id %>
	</span>
	</div>
	<div>
		<span>
			비밀번호:
		</span>
		<span>
			<%= pw %>
		</span>
	</div>
</body>
</html>