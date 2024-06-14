<%@ page contentType="text/html; charset=utf-8"%>
<html>
<head>
<title>Exception</title>
</head>
<body>
	<%
         try {
            int i = 1;
            i = i / 0;
            out.println("결과 : " + i);
         }
         catch (Exception e) {
            out.println("오류 발생 : " + e.getMessage());
         }
      %>

</body>
</html>
