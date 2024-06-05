package org.big;

import java.util.ArrayList;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EmpListCommand implements EmpCommand{
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		EmpDao dao = new EmpDao();
		
		ArrayList<EmpDto> list = dao.select();
		
		req.setAttribute("list", list);
		
	}
}
