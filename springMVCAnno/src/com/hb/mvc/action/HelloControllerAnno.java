package com.hb.mvc.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/** ע�ⶨ��Controller */
@Controller
@RequestMapping("/day01")
public class HelloControllerAnno {
	@RequestMapping("/hello.do")
	public String execute() throws Exception {
		return "hello";
	}
}
