package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class CommonController {
	@RequestMapping("/accessError")
	public void accessError() {
		log.info("access error page call ");
	}
	
	@GetMapping("/customLogin")
	public void customLogin() {
		log.info("custom login page");
	}
	
	@GetMapping("/customLogout")
	public void customLogout() {
		log.info("custom logout");
	}
}
