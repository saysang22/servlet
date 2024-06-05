package org.big;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("*.do")
public class FrontController extends HttpServlet{
	public FrontController() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String requestURI = req.getRequestURI(); // 전체 URI
		String contextPath = req.getContextPath(); // 프로젝트 이름 경로
		String command = requestURI.substring(contextPath.length());
		PrintWriter pr = resp.getWriter();
		
		resp.setContentType("text/html; charset=utf-8");
		
		pr.print("<html><body>");
		pr.print("URI= " + requestURI + "<br>");
		pr.print("PATH= " + contextPath + "<br>");
		pr.print("command= " + command + "<br>");
		
		if(command.equals("/insert.do")) {
			pr.print("insert 요청입니다.");
		} else if(command.equals("/delete.do")){
			pr.print("delete 요청입니다.");
		} else if(command.equals("/update.do")){
			pr.print("update 요청입니다.");
		} else {
			pr.print("select 요청입니다.");
		}
		
		pr.print("</body></html>");
	}
}
