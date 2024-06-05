package org.big.service;

import org.big.dao.BoardDao;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class BoardDeleteService implements BoardService{
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		
		String num = req.getParameter("num");
		
		BoardDao dao = new BoardDao();
		
		dao.delete(num);
		
	}
}
