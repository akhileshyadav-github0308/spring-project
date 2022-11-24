package com.abm.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	
	@RequestMapping("/staticPage")
	public String staticPage(Map model) {
		return "redirect:/pages/index.htm";
	}
	
	@RequestMapping("/hello")
	public String sayHello(Map model) {
		model.put("msg", "Welcome to Spring MVC");
		return "hello.jsp";
	}
	
	@RequestMapping("/welcome")
	public String welcome(Map model) {
		model.put("msg", "Welcome to Spring MVC");
		return "/WEB-INF/welcome.jsp";
	}
	
	@RequestMapping("/hello2")
	public ModelAndView sayHello2(Map model) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("msg", "Welcome Again to Spring MVC");
		mv.setViewName("hello.jsp");
		return mv;
	}

}
