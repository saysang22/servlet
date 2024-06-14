package org.big.prj.controller;

import java.util.List;

import org.big.prj.dto.BoardDTO;
import org.big.prj.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@RequestMapping("/board/openBoardList.do")
	public ModelAndView openBoardList() throws Exception {
		ModelAndView mv=new ModelAndView("/board/boardList"); //뷰 페이지를 받는다.
		List<BoardDTO> list=boardService.selectBoardList();
		mv.addObject("list", list);
		
		return mv;
	}
}
