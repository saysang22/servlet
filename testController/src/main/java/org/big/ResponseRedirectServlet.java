package org.big;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/responseRedirect")
public class ResponseRedirectServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String userName = (String) req.getAttribute("username");
		String userAddr = (String) req.getAttribute("useraddress");

		PrintWriter pr = resp.getWriter();

		resp.setContentType("text/html; charset=utf-8");

		pr.print("<html><body>");
		pr.print("userName = " + userName + "<br>");
		pr.print("userAddr = " + userAddr + "<br>");
		pr.print("</body></html>");
	}

}
