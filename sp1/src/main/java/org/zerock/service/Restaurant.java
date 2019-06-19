package org.zerock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j;

@ToString
@Service
@Log4j
public class Restaurant {
	
	@Setter(onMethod_ = {@Autowired} ) // 이게 제일 무난한 방법이오
	private Chef chef;
	
	
	public void order() {
		log.info(chef.cook());
	}


}
