<%@ page contentType="text/html; charset=utf-8"%>
<%@ page errorPage="exception_error.jsp"%>
<html>
<head>
<title>Exception</title>
</head>
<body>
	<%
	String user = request.getParameter("id");
	String pwd = request.getParameter("password");
	
	if(user == null || "".equals(user) || pwd == null || "".equals(pwd)){
		throw new ServletException("요청 파라미터 값이 없습니다");
	}	
%>
Welcome to <%=user %>
</body>
</html>



