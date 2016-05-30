package com.hb.mvc.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/** ×¢½â¶¨ÒåController */
@Controller
@RequestMapping("/day01")
public class HelloControllerAnno {
	@RequestMapping("/hello.do")
	public String execute() throws Exception {
		return "hello";
	}
}
