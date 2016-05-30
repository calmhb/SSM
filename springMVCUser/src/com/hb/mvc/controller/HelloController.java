package com.hb.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/spring")
public class HelloController {

	@RequestMapping("/hello.do")
	public String execute() {
		System.out.println("***HelloController÷¥––***");
		return "success";
	}
}
