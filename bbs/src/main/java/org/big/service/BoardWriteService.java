package org.big.service;

import org.big.dao.BoardDao;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class BoardWriteService implements BoardService{
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		
		String title = req.getParameter("title");
		String author = req.getParameter("author");
		String content = req.getParameter("content");
		
		BoardDao dao = new BoardDao();
		
		dao.write(title, author, content);
		
	}

}