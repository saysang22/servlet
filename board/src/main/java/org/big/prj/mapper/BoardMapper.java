package org.big.prj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.big.prj.dto.BoardDTO;

@Mapper
public interface BoardMapper {

	List<BoardDTO> selectBoardList() throws Exception;
}
