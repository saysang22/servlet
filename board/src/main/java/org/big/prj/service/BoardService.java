package org.big.prj.service;

import java.util.List;

import org.big.prj.dto.BoardDTO;

public interface BoardService {

	List<BoardDTO> selectBoardList() throws Exception;
}
