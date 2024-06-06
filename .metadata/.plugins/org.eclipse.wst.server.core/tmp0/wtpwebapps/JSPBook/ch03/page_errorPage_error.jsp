<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage ="true" import="java.io.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Directives Tag</title>
<style>
	h1 {
		text-align : center;
	}

</style>
</head>
<body>
	<h1>에러가 발생 했습니다.</h1>
	<%
		exception.printStackTrace(new PrintWriter(out));
	%>
</body>
</html>