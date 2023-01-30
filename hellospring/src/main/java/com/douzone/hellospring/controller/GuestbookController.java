package com.douzone.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 * @RequestMapping 클래스 단독 매핑
 * Spring mvc 4.x에서만 지원
 * @RequestMapping("/guestbook/*")
 * : 
 */
@Controller
@RequestMapping("/guestbook/*")
public class GuestbookController {
	
	@ResponseBody
	@RequestMapping
	public String list() {
		return "GuestbookController.list()";
	}
	
//	@ResponseBody
//	@RequestMapping
//	public String delete() {
//		return "GuestbookController.delete()";
//	}
}
