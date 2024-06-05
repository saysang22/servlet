package org.big;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/cartSave")
public class CarSaveServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pr = resp.getWriter();

		String product = req.getParameter("product");
		
		resp.setContentType("text/html; charset=utf-8");
		
		HttpSession se = req.getSession();
		
		ArrayList<String> list = (ArrayList<String>) se.getAttribute("product");
		
		if(list == null) {
			list = new ArrayList<String>();
			list.add(product);
			se.setAttribute("product", list);
		} else {
			list.add(product);
		}
		
		pr.print("<html><body>");
		pr.print("product 추가" + "<br>");
		pr.print("<a href='cartBasket'>장바구니 보기</a>");
		pr.print("</body></html>");
		
	}
}
