package org.big;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/emp")
public class empServlet extends HttpServlet{
	public empServlet() {
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
		
		PrintWriter pr = resp.getWriter();
		
		pr.print("<html><body>");
		EmpDao dao = new EmpDao();
		ArrayList<EmpDto> list = dao.select();
		
		pr.print("<table>");
		pr.print("<tr>");
		for(EmpDto dto : list) {
			int empno = dto.getEmpno();
			String ename = dto.getEname();
			String job = dto.getJob();
			String mgr = dto.getMgr();
			String hiredate = dto.getHiredate();
			String sal = dto.getSal();
			String comm = dto.getComm();
			String deptno = dto.getDeptno();
			
			pr.print(empno + "\t" + ename+ "\t" + job+ "\t" + mgr+ "\t" + hiredate+ "\t" + sal+ "\t" + comm+ "\t" + deptno + "<br>");
		}
		pr.print("</tr>");
		pr.print("</table>");
		pr.print("</body></html>");
		
	}
}