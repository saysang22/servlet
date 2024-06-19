package org.big.prj.controller;

import java.util.List;

import org.big.prj.dto.BoardDTO;
import org.big.prj.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;



@Controller
public class RestBoardController {
	
	private Logger log=LoggerFactory.getLogger(this.getClass());

	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value = "/board", method = RequestMethod.GET)
	public ModelAndView openBoardList() throws Exception {
		log.info("========>openBoardList");
		ModelAndView mv=new ModelAndView("/board/boardList.html");
		List<BoardDTO> list=boardService.selectBoardList();
		mv.addObject("list", list);
		
		return mv;
	}
	
	@RequestMapping(value = "/board/write", method = RequestMethod.GET)
	public String openBoardWrite() throws Exception {
	
		return "/board/restBoardWrite";
	}
	
	@RequestMapping(value = "/board/write", method = RequestMethod.POST)
	public String insertBoard(BoardDTO board, MultipartHttpServletRequest multipartHttpServletRequest) throws Exception {
		boardService.insertBoard(board, multipartHttpServletRequest);
		
		return "redirect:/board";
	}
	
	@RequestMapping(value = "/board/{boardIdx}", method = RequestMethod.GET)
	public ModelAndView openBoardDetail(@PathVariable("boardIdx") int boardIdx) throws Exception {
		ModelAndView mv=new ModelAndView("/board/restBoardDetail");
		BoardDTO board=boardService.selectBoardDetail(boardIdx);
		mv.addObject("board", board);
		return mv;
	}
	
	@RequestMapping(value = "/board/{boardIdx}", method = RequestMethod.PUT)
	public String updateBoard(BoardDTO board) throws Exception {
		boardService.updateBoard(board);
		
		return "redirect:/board";
	}
	
	@RequestMapping(value = "/board/{boardIdx}", method = RequestMethod.DELETE)
	public String deleteBoard(@RequestParam("boardIdx") int boardIdx) throws Exception {
		boardService.deleteBoard(boardIdx);
		
		return "redirect:/board";
	}
}
