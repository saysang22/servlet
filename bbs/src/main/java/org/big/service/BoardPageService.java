package org.big.service;

import org.big.dao.BoardDao;
import org.big.entity.PageTo;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class BoardPageService implements BoardService{
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
	
		int curPage = 1;
		
		if(req.getParameter("curPage") != null) {
			curPage = Integer.parseInt(req.getParameter("curPage"));
		}
		
		BoardDao dao = new BoardDao();
		PageTo to = dao.page(curPage);
		
		req.setAttribute("list", to.getList());
		req.setAttribute("page", to);
	}
}
