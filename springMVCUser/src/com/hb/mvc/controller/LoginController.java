package com.hb.mvc.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.hb.mvc.exception.NameOrPwdException;
import com.hb.mvc.exception.NullParamException;
import com.hb.mvc.pojo.User;
import com.hb.mvc.service.UserService;

/** 注解定义Controller */
@Controller
@SessionAttributes("user")
@RequestMapping("/login")
public class LoginController extends BaseController {
	@RequestMapping("/login.do")
	public String execute() throws Exception {
		return "login";// 映射到login.jsp页面
	}

	@Resource
	private UserService userService;// 无需提供getter和setter方法

	@RequestMapping("/login-action6.do")
	// SpringMVC 自动注入参数HttpServletRequest
	public String checkLogin6(@ModelAttribute("name") String name,
			@ModelAttribute("pwd") String pwd, ModelMap model,
			HttpServletRequest request) {
		System.out.println("---方法六---");
		System.out.println(name + ":" + pwd);
		try {
			User user = userService.login(name, pwd);
			// 登录成功将用户信息保存到session当中
			request.getSession().setAttribute("user", user);
			return "success";
		} catch (NameOrPwdException | NullParamException e) {
			model.addAttribute("message", e.getMessage());
			return "login";
		} catch (RuntimeException e) {// 从Dao层抛出的异常
			model.addAttribute("message", e.getMessage());
			return "error";// 映射到error.jsp页面
		}

	}

	private String[] msg = { "再来一次", "下次就对了", "没关系还有机会" };

	@ModelAttribute("next")
	public String getNext() {
		Random r = new Random();
		return msg[r.nextInt(msg.length)];
	}

	@RequestMapping("/login-action5.do")
	// SpringMVC 自动注入参数HttpServletRequest
	public String checkLogin5(String name, String pwd, ModelMap model,
			HttpServletRequest request) {
		System.out.println("---方法六---");
		System.out.println(name + ":" + pwd);
		try {
			User user = userService.login(name, pwd);
			// 登录成功将用户信息保存到session当中
			request.getSession().setAttribute("user", user);
			return "success";
		} catch (NameOrPwdException | NullParamException e) {

			e.printStackTrace();
			model.addAttribute("message", e.getMessage());
			return "login";
		} catch (RuntimeException e) {// 从Dao层抛出的异常
			model.addAttribute("message", e.getMessage());
			return "error";// 映射到error.jsp页面
		}

	}

	@RequestMapping("/login-action4.do")
	// SpringMVC 自动注入参数HttpServletRequest
	public ModelAndView checkLogin4(String name, String pwd,
			HttpServletRequest request) {
		System.out.println("---方法四---");
		// 封装数据的对象
		Map<String, Object> data = new HashMap<String, Object>();

		System.out.println(name + ":" + pwd);
		try {
			User user = userService.login(name, pwd);
			// 登录成功将用户信息保存到session当中
			request.getSession().setAttribute("user", user);
			return new ModelAndView("success", data);
		} catch (NameOrPwdException | NullParamException e) {

			e.printStackTrace();
			data.put("message", e.getMessage());
			return new ModelAndView("login", data);
		} catch (RuntimeException e) {// 从Dao层抛出的异常
			data.put("message", e.getMessage());
			return new ModelAndView("error", data);// 映射到error.jsp页面
		}

	}

	@RequestMapping("/login-action3.do")
	// SpringMVC 自动注入参数HttpServletRequest
	public String checkLogin3(User user, HttpServletRequest request) {
		System.out.println("---方法2---");
		// 优点:自动转换数据类型,缺点可能出现数据类型转换异常

		System.out.println(user.getName() + ":" + user.getPwd());

		try {
			user = userService.login(user.getName(), user.getPwd());
			// 登录成功将用户信息保存到session当中
			request.getSession().setAttribute("user", user);
			return "success";// 映射到success.jsp
		} catch (NameOrPwdException | NullParamException e) {

			e.printStackTrace();
			request.setAttribute("message", e.getMessage());
			return "login";// 重新映射到login.jsp页面
		} catch (RuntimeException e) {// 从Dao层抛出的异常
			request.setAttribute("message", e.getMessage());
			return "error";// 映射到error.jsp页面
		}

	}

	@RequestMapping("/login-action2.do")
	// SpringMVC 自动注入参数HttpServletRequest
	public String checkLogin2(String name,
			@RequestParam("pwd") String password, HttpServletRequest request) {
		System.out.println("---方法2---");
		// 优点:自动转换数据类型,缺点可能出现数据类型转换异常

		System.out.println(name + ":" + password);

		try {
			User user = userService.login(name, password);
			// 登录成功将用户信息保存到session当中
			request.getSession().setAttribute("user", user);
			return "success";// 映射到success.jsp
		} catch (NameOrPwdException | NullParamException e) {

			e.printStackTrace();
			request.setAttribute("message", e.getMessage());
			return "login";// 重新映射到login.jsp页面
		} catch (RuntimeException e) {// 从Dao层抛出的异常
			request.setAttribute("message", e.getMessage());
			return "error";// 映射到error.jsp页面
		}

	}

	@RequestMapping("/login-action1.do")
	// SpringMVC 自动注入参数HttpServletRequest
	public String checkLogin1(HttpServletRequest request) {
		/* 制造异常 */
		String str = null;
		str.length();

		System.out.println("---方法1---");
		// 优点:直接简洁,缺点需要手动处理数据类型转换
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		System.out.println(name + ":" + pwd);

		try {
			System.out
					.println(new String(name.getBytes("iso-8859-1"), "utf-8"));
			User user = userService.login(name, pwd);
			// 登录成功将用户信息保存到session当中
			request.getSession().setAttribute("user", user);
			return "success";// 映射到success.jsp
		} catch (NameOrPwdException | NullParamException e) {
			request.setAttribute("message", e.getMessage());
			return "redirect:login.do";// 重定向到login.do
		} catch (Exception e) {// 从Dao层抛出的异常
			request.setAttribute("message", e.getMessage());
			return "error";// 映射到error.jsp页面
		}

	}

}
