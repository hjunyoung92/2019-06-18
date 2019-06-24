package org.zero.controller;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.zero.domain.SampleDTO;
import org.zero.domain.SampleDTOList;
import org.zero.domain.TodoDTO;

import lombok.extern.log4j.Log4j;

@Controller /*�̰��ϸ� ���Ͽ� S������*/
@RequestMapping("/sample/*")
@Log4j
public class SampleController {
	
//	@InitBinder
//	public void inintbinder(WebDataBinder binder) {
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd");
//		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(df,false));
//
//	}
	
	
	@GetMapping
	public void ex05(TodoDTO todo) {
		log.info(todo);
	}
	

	
	
	@GetMapping("/ex01")
	public void doA(SampleDTO dto) {
		log.info(dto);
	}
	
	@GetMapping("/ex02")
	public void ex02(@RequestParam("name")String name,
			@RequestParam("age") int age)/*밭는 파라미터랑 실제 파라미터랑 다를때 이렇게 하믄 되요 */{
		log.info(name);
		log.info(age);
	}
	
	@GetMapping("/ex03")
	public void ex03(@RequestParam("ids")String[] ids){
		log.info(Arrays.toString(ids));
		
	}
	
//	@GetMapping("/ex04")
	@RequestMapping(value = "/ex04", method = {RequestMethod.GET,RequestMethod.POST} )/*이렇게 하면 get이든 post든 둘다 되지롱*/
	public void ex04(SampleDTOList list){
		log.info(list);
		
	}
	
	
	
}
