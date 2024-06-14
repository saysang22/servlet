<%@ page contentType="text/html; charset=utf-8"%>
<html>
<head>
<title>Cookie</title>
</head>
<body>
	<%  
	Cookie[] cookies = request.getCookies();
	
    if (request.getCookies() == null) {
        response.sendRedirect("cookie_out.jsp");
    }
    for (int i = 0; i < cookies.length; i++) {
    	if (cookies[i].getName().equals("userID")){
    		
   
	%>
	
		<h4><%= cookies[i].getValue() %>님 반갑습니다.</h4>
	<%
	i = cookies.length;}
    	}
	%>
	<a href="cookie_out.jsp">로그아웃</a>


</body>
</html>