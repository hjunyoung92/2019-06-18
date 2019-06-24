package org.zerock.controller;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.SampleDTO;
import org.zerock.domain.SampleDTOList;
import org.zerock.domain.TodoDTO;

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
	
	@GetMapping ("/ex07")
	public String ex07(RedirectAttributes rttr) {
		log.info("ex07----------");
		rttr.addFlashAttribute("result", "SUCCESS"); //add 플래쉬죠? url에 들어가는게 아니라서 한번만 전달하는 param을 쓸때 씁니다
		return "redirect:/sample/ex08"; /*redirect는 두번 호출된다!*/
	}
	
	@GetMapping ("/ex08")
	public void ex08() {
		log.info("ex08----------");
	}
	
	
	
	@GetMapping //날짜로 자동전환하는 
	public void ex05(TodoDTO todo) {
		log.info(todo);
	}
	
	@GetMapping("/ex06")
	public String ex06(SampleDTO dto ,@ModelAttribute("page") int page, Model model) {
		log.info("ex06-----------------------------------");
		log.info(dto);
		log.info(page);
		model.addAttribute("result", "SUCCESS");
		return "/sample/ex06";
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
