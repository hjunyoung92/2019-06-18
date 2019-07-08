package org.zerock.mapper;

import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.ReplyVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyMapperTests {
	
	
	@Autowired
	private ReplyMapper mapper;
	
	private int[] bnoArr = {8189,8191};
	@Test
	public void testInsert() {
		IntStream.rangeClosed(1,10).forEach(i->{
			ReplyVO vo = new ReplyVO();
			vo.setBno(bnoArr[i%2]);
			vo.setReply("췤"+i);
			vo.setReplyer("췤"+i);
			mapper.insert(vo);
		});
	}
	
	@Test
	public void testList() {
		mapper.list(8189).forEach(vo->
		log.info(vo));
	}
	
	@Test
	public void testModify() {
		ReplyVO vo = new ReplyVO();
		vo.setRno(266);
		vo.setReply("번창하세요");
		
		mapper.modify(vo);
		
	}
}
