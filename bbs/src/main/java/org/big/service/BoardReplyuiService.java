package org.big.service;

import org.big.dao.BoardDao;
import org.big.entity.BoardDto;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class BoardReplyuiService implements BoardService {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
	
		String num = req.getParameter("num");
		
		BoardDao dao = new BoardDao();
		BoardDto data = dao.replyUi(num);
		
		req.setAttribute("replyui", data);
	}
	

}
