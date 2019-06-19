package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.BoardVO;

public interface BoardMapper {

	public void insert(BoardVO vo);
	
	public List<BoardVO> selectDESC();
	
	public BoardVO select(Integer bno);
	
	
}
