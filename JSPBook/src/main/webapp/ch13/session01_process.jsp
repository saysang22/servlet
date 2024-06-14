<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
	
		String user_id = request.getParameter("id");
		String user_pw = request.getParameter("passwd");
		
		if(user_id.equals("admin") && user_pw.equals("1234")) {
			session.setAttribute("userID", user_id);
			session.setAttribute("userPW", user_pw);
			
		%>
			<script>
				alert("로그인이 성공했습니다.");
				location.href = "session02.jsp";
			</script>
		<%
			//response.sendRedirect("session02.jsp");
			//out.println("세션 설정이 성공했습니다.<br>");
			//out.print(user_id + "님 환영합니다.");
		} else {
			
		%>
			<script>
				alert("로그인이 실패 했습니다.");
				history.back();
			</script>
		<%
			//out.println("로그인이 실패했습니다.");
		}
	
	%>
</body>
</html>