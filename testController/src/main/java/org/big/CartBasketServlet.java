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

@WebServlet("/cartBasket")
public class CartBasketServlet extends HttpServlet {

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
		pr.print("장바구니 리스트" + "<br>");

		HttpSession se = req.getSession(false);

		if (se != null) {
			ArrayList<String> list = (ArrayList<String>) se.getAttribute("product");
			pr.print("상품: " + list + "<br>");
		} else {
			pr.print("세션없음" + "<br>");
		}
		pr.print("<a href='product.html'>상품 선택페이지</a>" + "<br>");
		pr.print("<a href='cartDelete'>장바구니 비우기</a>" + "<br>");
		pr.print("</body></html>");

	}

}
