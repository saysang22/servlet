package org.big.prj.controller;

import java.io.File;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.big.prj.dto.BoardDTO;
import org.big.prj.dto.BoardFileDTO;
import org.big.prj.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;



@Slf4j
@Controller
public class BoardController {
	

	@Autowired
	private BoardService boardService;
	
	
	@RequestMapping("/board/test.do")
	public String test() {
		return "/test";
	}
	
	
	@RequestMapping("/board/openBoardList.do")
	public ModelAndView openBoardList() throws Exception {
		log.info("========>openBoardList");
		ModelAndView mv=new ModelAndView("thymeleaf/board/boardList.html");
		List<BoardDTO> list=boardService.selectBoardList();
		mv.addObject("list", list);
		
		return mv;
	}
	
	@RequestMapping("/board/openBoardWrite.do")
	public String openBoardWrite() throws Exception {
	
		return "thymeleaf/board/boardWrite";
	}
	
	@RequestMapping("/board/insertBoard.do")
	public String insertBoard(BoardDTO board, MultipartHttpServletRequest multipartHttpServletRequest) throws Exception {
		boardService.insertBoard(board, multipartHttpServletRequest);
		
		return "redirect:/board/openBoardList.do";
	}
	
	@RequestMapping("/board/openBoardDetail.do")
	public ModelAndView openBoardDetail(@RequestParam("boardIdx") int boardIdx) throws Exception {
		ModelAndView mv=new ModelAndView("thymeleaf/board/boardDetail");
		BoardDTO board=boardService.selectBoardDetail(boardIdx);
		mv.addObject("board", board);
		return mv;
	}
	
	@RequestMapping("/board/downloadBoardFile.do")
	public void downloadBoardFile(@RequestParam("idx") int idx, @RequestParam("boardIdx") int boardIdx, HttpServletResponse response){
	    try {
	    	BoardFileDTO boardFile = boardService.selectBoardFileInformation(idx, boardIdx);

	        if (ObjectUtils.isEmpty(boardFile) == false) {
	            String fileName = boardFile.getOriginalFileName();

	            byte[] files = FileUtils.readFileToByteArray(new File(boardFile.getStoredFilePath()));

	            response.setContentType("application/octet-stream");
	            response.setContentLength(files.length);
	            response.setHeader("Content-Disposition", "attachment; fileName=\"" + URLEncoder.encode(fileName, "UTF-8") + "\";");
	            response.getOutputStream().write(files);
	            response.getOutputStream().flush();
	            response.getOutputStream().close();
	        }     
	    } catch (Exception e){
	        log.error(e.getMessage());
	        e.getStackTrace();
	    }
	}
	
//	@RequestMapping("/board/downloadBoardFile.do")
//	public void downloadBoardFile(
//	    @RequestParam("idx") int idx,
//	    @RequestParam("boardIdx") int boardIdx,
//	    HttpServletResponse response) throws Exception {
//	    BoardFileDTO boardFile = boardService.selectBoardFileInformation(idx, boardIdx);
//	    if (!ObjectUtils.isEmpty(boardFile)) {
//	        String fileName = boardFile.getOriginalFileName();
//
//	        byte[] files = FileUtils.readFileToByteArray(
//	            new File(boardFile.getStoredFilePath()));
//
//	        response.setContentType("application/octet-stream");
//	        response.setContentLength(files.length);
//	        response.setHeader(
//	            "Content-Disposition",
//	            "attachment; fileName=\"" +
//	                URLEncoder.encode(fileName, "UTF-8") +
//	                "\";");
//	        response.setHeader(
//	            "Content-Transfer-Encoding", 
//	            "binary");
//	        response.getOutputStream().write(files);
//	        response.getOutputStream().flush();
//	        response.getOutputStream().close();
//	    }
//	}
	
}
