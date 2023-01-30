package com.douzone.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 * @RequestMapping 클래스 + 메소드 매핑 
 */

@Controller
@RequestMapping("/user")
public class UserController {
	
	//value는 URL 
	@RequestMapping( value ="/join", method=RequestMethod.GET)
	public String join() {
		return "/WEB-INF/views/join.jsp";
	}
	
//	@RequestMapping( value ="/join", method=RequestMethod.POST)
//	public String join(String name) {
//		System.out.println(name);
//		return "redirect:/";
//	}
	
	@RequestMapping( value ="/join", method=RequestMethod.POST)
	public String join(UserVo userVo) {
		System.out.println(userVo);
		return "redirect:/";
	}
	
	@ResponseBody
	@RequestMapping("/update")					//기본값 꼭 있어야함 , 디폴트값 (String값)설정
	public String update(@RequestParam(value="n") String name) {
		/*
		 * 만일 n이라는 이름의 URL 파라미터가 없을 경우
		 * 	400 Bad Request 에러 발생
		 */
		return "UserController.update("+name+")";
	}
	
	@ResponseBody
	@RequestMapping("/update2")					//기본값 꼭 있어야함 , 디폴트값 (String값)설정
	public String update2(@RequestParam(value="n", required = true, defaultValue = "") String name) {
		return "UserController.update("+name+")";
	}
	
	@ResponseBody
	@RequestMapping("/list")					//기본값 꼭 있어야함 , 디폴트값 (String값)설정
	public String list(@RequestParam(value="p", required = true, defaultValue = "1") int pageNo) {
		return "UserController.list("+pageNo+")";
	}
}
