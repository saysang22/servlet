package org.big;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deptDAOSelect")
public class DepDaoServlet extends HttpServlet {
	
	public DepDaoServlet() {
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
		
		resp.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		
		out.print("<html><body>");
		DeptDao dao = new DeptDao();
		ArrayList<DeptDto> list = dao.select();

		for(DeptDto dto : list) {
			
			int deptno = dto.getDeptno();
			String dname = dto.getDname();
			String loc = dto.getLoc();
			
			out.print(deptno + "\t" + dname + "\t" + loc + "<br>");
		}
		
		out.print("</body></html>");
	}
}
