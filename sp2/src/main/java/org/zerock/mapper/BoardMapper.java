package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.zerock.domain.BoardVO;

public interface BoardMapper {

	public void insert(BoardVO vo);
	
	public List<BoardVO> selectDESC();
	
	public BoardVO select(Integer bno);
	
	public int update(BoardVO vo); //업데이트의 리턴값은 int다
	
	@Delete("delete from tbl_board where bno = #{bno}")
	public int delete(Integer bno); //pk로 
	
	@Select("select *from tbl_board where bno>0 order by bno desc")
	public List<BoardVO> selectAll();
	
}
