package org.big.service;

import java.util.ArrayList;

import org.big.dao.BoardDao;
import org.big.entity.BoardDto;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class BoardSearchService implements BoardService{
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
	
		String searchName = req.getParameter("searchName");
		String searchValue = req.getParameter("searchValue");
		
		BoardDao dao = new BoardDao();
		ArrayList<BoardDto> list = dao.search(searchName, searchValue);
		
		req.setAttribute("list", list);
	}
}
