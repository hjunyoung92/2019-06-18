package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.zerock.domain.ReplyVO;

public interface ReplyMapper {
	
	@Insert("insert into tbl_reply(bno,reply,replyer) values(#{bno},#{reply},#{replyer})")
	public int insert(ReplyVO vo);
	
	@Select("select*from tbl_reply where bno = #{bno}"+ " order by rno asc")
	public List<ReplyVO> list(@Param("bno") Integer bno);
	
	@Select("select*from tbl_reply where rno = #{rno} order by rno asc")
	public ReplyVO select(@Param("rno")Integer rno);
	
	@Delete("delete from tbl_reply where rno =#{rno}")
	public int delete(@Param("rno")Integer rno);

	@Update("UPDATE tbl_reply SET reply=#{vo.reply}  WHERE rno=#{vo.rno}")
	public int modify(@Param("vo") ReplyVO vo);
	
}
