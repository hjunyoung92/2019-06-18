package org.zerock.controller;

import java.security.Principal;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {

	@GetMapping("/all")
	public void doAll() {

	log.info("do all can access everybody");
	}

	@GetMapping("/member")
	public void doMember() {

	log.info("logined member");
	}
	
	@PreAuthorize("hasRole('ROLE_MEMBER')")
	@GetMapping("/manager")
	public void doManager() {

	log.info("manager, admin only?");
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/admin")
	public void doAdmin(Principal principal)  {
//		log.info(principal.username);
		log.info(principal);
		log.info("admin only");
	}
	
	
}
