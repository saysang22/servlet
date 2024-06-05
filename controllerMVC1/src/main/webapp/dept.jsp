<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="jakarta.servlet.http.HttpServletRequest"
	import="jakarta.servlet.http.HttpServletResponse"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dept</title>
</head>
<body>
	<h1>Dept</h1>
	<table border="1">
		<tr>
			<td colspan="3">DEPT 테이블</td>
		</tr>
		<tr>
			<td>부서번호</td>
			<td>부서이름</td>
			<td>지역</td>
		</tr>
		<c:forEach items="${list1}" var="dto1" step="1">
			<tr>
				<td>${dto1.deptno}</td>
				<td>${dto1.dname}</td>
				<td>${dto1.loc}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>