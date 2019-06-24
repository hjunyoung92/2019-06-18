package org.zerock.service;

public interface GenericService<VO, K> { //뭔지 모르지만 일단 따라와라. VO와 K타입은 나중에 결정할거다

	public void register(VO vo) ;
	public VO get(K key);
	
	public int modify(VO vo);
	
	public int remove(K key);
	
}
