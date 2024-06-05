package org.big;

import java.util.ArrayList;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeptListCommand implements DeptCommand{
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		DeptDao dao = new DeptDao();
		
		ArrayList<DeptDto> list = dao.select();
		
		req.setAttribute("list", list);
		
	}
}
