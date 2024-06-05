package org.big.service;

import org.big.dao.BoardDao;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class BoardUpdateService implements BoardService{
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		
		String num = req.getParameter("num");
		String title = req.getParameter("title");
		String author = req.getParameter("author");
		String content = req.getParameter("content");
		
		BoardDao dao = new BoardDao();
		
		dao.update(num, title, author, content);
	}
}
