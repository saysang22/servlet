<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.Book" %>
<%@ page import="dao.BookRepository" %>

<%
	String id = request.getParameter("cartId");
	if(id == null || id.trim().equals("")) {
		response.sendRedirect("cart.jsp");
		
		return;
	}
	
	session.invalidate();
	response.sendRedirect("cart.jsp");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니 삭제</title>
</head>
<body>

</body>
</html>