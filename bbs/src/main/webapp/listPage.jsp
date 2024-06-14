<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>목록 보기</title>
<style>
.wrap {
	width: 500px;
	margin: 0 auto;
}

table {
	border-collapse: collapse;
}

td, tr {
	padding: .2rem 1rem;
}

.btn {
	text-decoration: none;
	background: #999;
	color: #fff;
	margin: .7rem 0;
	display: inline-block;
	padding: .5rem;
	border-radius: .3rem;
}
</style>
</head>
<body>
	<div class="wrap">
		<h1>게시판 목록보기</h1>
		<table border="1">
			<tr>
				<td colspan="5">
					<form method="get" action="search.do">
						<select name="searchName" size="1">
							<option value="author">작성자</option>
							<option value="title">글제목</option>
						</select> <input type="text" name="searchValue" placeholder="검색어를 입력하세요.">
						<input type="submit" value="찿기">
					</form>
				</td>
			</tr>
			<tr>
				<td>글 번호</td>
				<td>제목</td>
				<td>작성자</td>
				<td>내용</td>
				<td>작성일</td>
			</tr>
			<c:forEach items="${list}" var="dto" step="1">
				<tr>
					<td>${dto.num}</td>
					<td><c:forEach begin="1" end="${dto.repindent}">
							<%="&nbsp;&nbsp;"%>
						</c:forEach> <a href="retrieve.do?num=${dto.num}">${dto.title}</a></td>

					<td>${dto.author}</td>
					<td>${dto.writeday}</td>
					<td>${dto.readcnt}</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="5">
					<jsp:include page="page.jsp" flush="true"></jsp:include>
				</td>
			</tr>
		</table>
		<a href="writeui.do" class="btn">글쓰기</a>
	</div>
</body>
</html>