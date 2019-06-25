package org.zerock.service;

import java.util.List;

import org.zerock.domain.Criteria;

public interface GenericService<VO, K> { //뭔지 모르지만 일단 따라와라. VO와 K타입은 나중에 결정할거다

	public void register(VO vo) ;
	
	public VO get(K key);
	
	public int modify(VO vo);
	
	public int remove(K key);
	
	public List<VO> getList(Criteria cri);
	
}
