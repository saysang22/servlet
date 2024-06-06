<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "org.apache.commons.fileupload.*" %>
<%@ page import = "java.io.*" %>
<%@ page import = "java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String path = "d:/upload";
	
		DiskFileUpload up = new DiskFileUpload();
		
		up.setSizeMax(1000000);
		up.setSizeThreshold(4096);
		up.setRepositoryPath(path);
		
		List items = up.parseRequest(request);
		Iterator pa = items.iterator();
		
		while(pa.hasNext()) {
			FileItem item = (FileItem) pa.next();
			
			if(item.isFormField()) {
				String name = item.getFieldName();
				String value = item.getString("utf-8");
				
				out.print(name + " = " + value + "<br>");
			} else {
				String fileFieldName = item.getFieldName();
				String fileName = item.getName();
				String contentType = item.getContentType();
				
				fileName = fileName.substring(fileName.lastIndexOf("/") + 1);
				long fileSize = item.getSize();
				
				File file = new File(path + "/" + fileName);
				item.write(file);
				
				out.print("-----------------------------------<br>");
				out.print("요청 파라미터 이름 : " + fileFieldName + "<br>");
				out.print("저장 파일 이름 : " + fileName + "<br>");
				out.print("파일 콘텐츠 유형 : " + contentType + "<br>");
				out.print("파일 크기 : " + fileSize);
			}
		}
	
	%>
</body>
</html>