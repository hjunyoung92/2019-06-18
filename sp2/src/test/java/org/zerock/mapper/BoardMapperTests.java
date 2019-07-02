package org.zerock.mapper;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.PageMaker;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j

public class BoardMapperTests {
	@Autowired
	BoardMapper mapper;
	
	
	
	@Test
	public void testMap() {
		String type = "TCW";
		String keyword ="홍길동";
		
		if(type == null|| type.trim().length()==0) {
			
		}
		
		
		//T,C,W
		String[] arr= type.split("");
		
		log.info(Arrays.deepToString(arr));
		
		Map<String, String> map = new HashMap<>();
		for(String word:arr){
			map.put(word, keyword);
		}
		log.info(map);
	}

	
	@Test
	public void testSearch() {
		Map<String, String> map = new HashMap<>();
		map.put("T", "샘플");
		map.put("C", "샘플");
		
		mapper.search(map);
	}
	
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
	
	@Test
	public void testPaging() {
		Criteria cri = new Criteria();

		cri.setType("T");
		
		cri.setKeyword("한글");
		
		
		mapper.selectPage(cri).forEach(vo->log.info(vo));
	}
	
	@Test
	public void testPageMaker() {
		Criteria cri = new Criteria();
		cri.setPage(11);
		PageMaker pm = new PageMaker(cri, 120);
		log.info(pm);
		log.info(pm.getLink("/board/link", 3));
	}
	
}
