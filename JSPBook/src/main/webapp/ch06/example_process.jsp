<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Registration</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
	
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String email = request.getParameter("email");
		String backEmail = request.getParameter("back_email");
		String ra = request.getParameter("ra");
		String[] ck = request.getParameterValues("ck");
		String memo  = request.getParameter("memo");
	%>
	<div>
		아이디: <%= id %>
	</div>
	<div>
		비밀번호: <%= pw %>
	</div>
	<div>
		이메일: <%= email %> @ <%= backEmail %>
	</div>
	<div>
		수신정보: <%= ra %> 
	</div>
	<div>
		관심정보: <%
				if(ck != null) {
					for(int i = 0; i < ck.length; i++) {
						out.println(" " + ck[i]);
					}
				}
		
		%>
	</div>
	<div>
		메모: <%= memo %>
	</div>

</body>
</html>