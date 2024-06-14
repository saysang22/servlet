<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ include file="dbconn.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Database SQL</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
	
		String id = request.getParameter("id");
		String pw = request.getParameter("passwd");
		String name = request.getParameter("name");
		
		Statement stmt = null;
		
		try {
			
			String sql = "INSERT INTO Member(id, passwd, name) VALUES('"+ id + "','" + pw + "','" + name + "')";
			stmt = conn.createStatement();
			stmt.execute(sql);
			out.println("Member 테이블 삽입이 성공했습니다.");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(stmt != null) stmt.close();
			if(conn != null) conn.close();
		}
		
		response.sendRedirect("select01.jsp");
	
	%>
</body>
</html>