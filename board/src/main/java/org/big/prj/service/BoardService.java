package org.big.prj.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.big.prj.dto.BoardDTO;
import org.big.prj.dto.BoardFileDTO;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import jakarta.servlet.http.HttpSession;

public interface BoardService {

	List<BoardDTO> selectBoardList() throws Exception;
	
	void insertBoard(BoardDTO board, MultipartHttpServletRequest multipartHttpServletRequest) throws Exception;
	
	BoardDTO selectBoardDetail(int boardIdx) throws Exception;
	
	void updateBoard(BoardDTO board) throws Exception;
	
	void deleteBoard(int boardIdx) throws Exception;
	
	BoardFileDTO selectBoardFileInformation(int idx, int boardIdx) throws Exception;
}
