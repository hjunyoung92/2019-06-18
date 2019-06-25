package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
@Log4j
@Service
@AllArgsConstructor
public class BoardServicelmpl implements BoardService {
	
	
	private BoardMapper mapper;
	
	

	@Override
	public void register(BoardVO vo) {
		
		log.info("vo:"+vo);
		mapper.insert(vo);
	}

	@Override
	public BoardVO get(Integer key) {
		
		return mapper.select(key);
	}

	@Override
	public int modify(BoardVO vo) {
		
		return mapper.update(vo);
	}

	@Override
	public int remove(Integer key) {

		return mapper.delete(key);
	}

	@Override
	public List<BoardVO> listAll() {
		// TODO Auto-generated method stub
		return mapper.selectAll();
	}

	@Override
	public List<BoardVO> getList(Criteria cri) {
		
		return mapper.selectPage(cri);
	}

}
