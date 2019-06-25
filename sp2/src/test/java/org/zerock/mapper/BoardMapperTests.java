package org.zerock.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.mapper.BoardMapper;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j

public class BoardMapperTests {
	@Autowired
	BoardMapper mapper;
	
	@Test
	public void testInsert() {
		BoardVO vo= new BoardVO();
		vo.setTitle("목요일");
		vo.setContent("구텐탁");
		vo.setWriter("에 뵙겠습니다");
		mapper.insert(vo);
	}
	
	@Test
	public void testSelect() {
		BoardVO vo = mapper.select(66);
		log.info(vo);
		
	}
	
	@Test
	public void testSelectDESC() {
		List<BoardVO> list= null;
		list =	mapper.selectDESC();
		list.forEach(vo -> log.info(vo));
		/*log.info(list);*/

	}
	
	@Test
	public void testUpdate() {
		BoardVO vo = mapper.select(50);
		vo.setTitle("o");
		vo.setContent("mg");
		int count =mapper.update(vo);
		
		log.info("updated count:" + count);
	}
	
	@Test
	public void delete() {
		int count = mapper.delete(50);
		log.info("delete count:" + count);
	}
	
}
