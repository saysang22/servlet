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

@WebServlet("/cartDelete")
public class CartDeleteServlet extends HttpServlet {
	
	public CartDeleteServlet() {
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
		PrintWriter pr = resp.getWriter();
		resp.setContentType("text/html; charset=utf-8");

		pr.print("<html><body>");
		pr.print("장바구니 비웠음" + "<br>");

		HttpSession se = req.getSession(false);

		if (se != null) {
			se.invalidate();
		} else {
			pr.print("세션없음" + "<br>");
		}
		pr.print("<a href='product.html'>상품 선택페이지</a>" + "<br>");
		pr.print("</body></html>");

	}

}