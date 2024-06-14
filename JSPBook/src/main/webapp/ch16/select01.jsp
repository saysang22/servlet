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
	<table width="300" border="1">
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
		</tr>
		<%
			ResultSet rs = null;
			Statement stmt = null;
			
			try {
				String sql = "SELECT * FROM Member order by id desc";
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				
				while(rs.next()) {
					String id = rs.getString("id");
					String passwd = rs.getString("passwd");
					String name = rs.getString("name");
					
				%>
				<tr>
					<td><%= id %></td>
					<td><%= passwd %></td>
					<td><%= name %></td>
				</tr>
				<% 
				
				}
				
				
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			}
		%>
	</table>
	<a href="insert01.jsp">가입하기</a>
	<a href="update01.jsp">수정하기</a>
	<a href="delete01.jsp">삭제하기</a>
</body>
</html>