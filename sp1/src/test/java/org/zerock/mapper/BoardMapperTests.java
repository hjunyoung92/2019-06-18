package org.zerock.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;

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
		vo.setTitle("한글");
		vo.setContent("됩니ㄷ");
		vo.setWriter("갓세종");
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
	
}
