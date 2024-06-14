<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ include file="dbconn.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	request.setCharacterEncoding("utf-8");

	String id = request.getParameter("id");
	String passwd = request.getParameter("passwd");

	ResultSet rs = null;
	PreparedStatement pstmt = null;

	try {
		String sql = "SELECT id, passwd FROM Member WHERE id = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		rs = pstmt.executeQuery();

		if (rs.next()) {
			String rId = rs.getString("id");
			String rPasswd = rs.getString("passwd");

			if (id.equals(rId) && passwd.equals(rPasswd)) {

		sql = "DELETE FROM Member WHERE id = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.executeUpdate();
		out.println("Member 테이블에서 데이터를 삭제했습니다.");
			} else {
		out.println("일치하는 비밀번호가 아닙니다.");
			}

		} else {
			out.println("Member 테이블에 일치하는 아이디가 없습니다.");
		}

	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		if (rs != null)
			rs.close();
		if (pstmt != null)
			pstmt.close();
		if (conn != null)
			conn.close();
	}

	response.sendRedirect("select02.jsp");
	%>
</body>
</html>