package com.douzone.guestbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.douzone.guestbook.repository.GuestbookRepository;
import com.douzone.guestbook.vo.GuestbookVo;

@Controller
public class GuestbookController {
	@Autowired
	private GuestbookRepository guestbookRepository;
	
	@RequestMapping("/")
	public String index(Model model) {
		List<GuestbookVo> list = guestbookRepository.findAll();
		model.addAttribute("list", list);
		return "/WEB-INF/views/index.jsp";
	}
	
	@RequestMapping("/add")
	public String add(GuestbookVo vo) {
		guestbookRepository.insert(vo);
		return "redirect:/";
	}
	
	@RequestMapping(value ="/delete/{no}", method = RequestMethod.GET)
	public String delete(@PathVariable(value="no")int no, Model model) {
		model.addAttribute("no", no);
		return "/WEB-INF/views/deleteform.jsp";
	
	}
//	/delete?no=${vo.no}
//	@RequestMapping(value ="/delete", method = RequestMethod.GET)
//	public String delete(@RequestParam(value="no")int no, Model model) {
//		model.addAttribute("no", no);
//		return "/WEB-INF/views/deleteform.jsp";
//	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(GuestbookVo vo) {
		String pwd = guestbookRepository.findPasswordByno(vo.getNo());
		if(vo.getPassword().equals(pwd)) {
			guestbookRepository.deleteByNoAndPassword(vo.getNo(), pwd);
		}
		return "redirect:/";
	}
}
