package org.zerock.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.ReplyVO;
import org.zerock.service.ReplyService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/replies")
@AllArgsConstructor
@Log4j
//@CrossOrigin 이게뭐임?
public class ReplyController {

	private ReplyService service;
	
	@GetMapping("/{rno}")
	public ResponseEntity<ReplyVO> get(@PathVariable("rno") Integer rno){
		
		return new ResponseEntity<> (service.get(rno),HttpStatus.OK);
	}

	@GetMapping("/{bno}/{page}")
	public ResponseEntity<List<ReplyVO>> getList(
			@PathVariable(name="bno") Integer bno,
			@PathVariable(name="page") Integer page
			){
		return new ResponseEntity<> (service.getSimpleList(bno),HttpStatus.OK);
	}
	
	@PostMapping(value="/new", consumes="application/json",produces = MediaType.TEXT_PLAIN_VALUE) 
																		//나한태 들어오는 타압이 application/json이야
																		//생산하는(리턴은) 성공 or 실패의 스트링 뿐이얌~
	public ResponseEntity<String> create(@RequestBody ReplyVO vo){
		log.info(vo);
		
		service.register(vo);
		return new ResponseEntity<>("success",HttpStatus.OK); //ie에서 오류 안나게 ok로 테스트 해욤
		
	}

}
