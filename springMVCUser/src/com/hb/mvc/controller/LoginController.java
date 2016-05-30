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

/** ע�ⶨ��Controller */
@Controller
@SessionAttributes("user")
@RequestMapping("/login")
public class LoginController extends BaseController {
	@RequestMapping("/login.do")
	public String execute() throws Exception {
		return "login";// ӳ�䵽login.jspҳ��
	}

	@Resource
	private UserService userService;// �����ṩgetter��setter����

	@RequestMapping("/login-action6.do")
	// SpringMVC �Զ�ע�����HttpServletRequest
	public String checkLogin6(@ModelAttribute("name") String name,
			@ModelAttribute("password") String pwd, ModelMap model,
			HttpServletRequest request) {
		System.out.println("---������---");
		System.out.println(name + ":" + pwd);
		try {
			User user = userService.login(name, pwd);
			// ��¼�ɹ����û���Ϣ���浽session����
			request.getSession().setAttribute("user", user);
			return "success";
		} catch (NameOrPwdException | NullParamException e) {
			model.addAttribute("message", e.getMessage());
			return "login";
		} catch (RuntimeException e) {// ��Dao���׳����쳣
			model.addAttribute("message", e.getMessage());
			return "error";// ӳ�䵽error.jspҳ��
		}

	}

	private String[] msg = { "����һ��", "�´ξͶ���", "û��ϵ���л���" };

	@ModelAttribute("next")
	public String getNext() {
		Random r = new Random();
		return msg[r.nextInt(msg.length)];
	}

	@RequestMapping("/login-action5.do")
	// SpringMVC �Զ�ע�����HttpServletRequest
	public String checkLogin5(String name, String pwd, ModelMap model,
			HttpServletRequest request) {
		System.out.println("---������---");
		System.out.println(name + ":" + pwd);
		try {
			User user = userService.login(name, pwd);
			// ��¼�ɹ����û���Ϣ���浽session����
			request.getSession().setAttribute("user", user);
			return "success";
		} catch (NameOrPwdException | NullParamException e) {

			e.printStackTrace();
			model.addAttribute("message", e.getMessage());
			return "login";
		} catch (RuntimeException e) {// ��Dao���׳����쳣
			model.addAttribute("message", e.getMessage());
			return "error";// ӳ�䵽error.jspҳ��
		}

	}

	@RequestMapping("/login-action4.do")
	// SpringMVC �Զ�ע�����HttpServletRequest
	public ModelAndView checkLogin4(String name, String pwd,
			HttpServletRequest request) {
		System.out.println("---������---");
		// ��װ���ݵĶ���
		Map<String, Object> data = new HashMap<String, Object>();

		System.out.println(name + ":" + pwd);
		try {
			User user = userService.login(name, pwd);
			// ��¼�ɹ����û���Ϣ���浽session����
			request.getSession().setAttribute("user", user);
			return new ModelAndView("success", data);
		} catch (NameOrPwdException | NullParamException e) {

			e.printStackTrace();
			data.put("message", e.getMessage());
			return new ModelAndView("login", data);
		} catch (RuntimeException e) {// ��Dao���׳����쳣
			data.put("message", e.getMessage());
			return new ModelAndView("error", data);// ӳ�䵽error.jspҳ��
		}

	}

	@RequestMapping("/login-action3.do")
	// SpringMVC �Զ�ע�����HttpServletRequest
	public String checkLogin3(User user, HttpServletRequest request) {
		System.out.println("---����2---");
		// �ŵ�:�Զ�ת����������,ȱ����ܳ�����������ת���쳣

		System.out.println(user.getName() + ":" + user.getPwd());

		try {
			user = userService.login(user.getName(), user.getPwd());
			// ��¼�ɹ����û���Ϣ���浽session����
			request.getSession().setAttribute("user", user);
			return "success";// ӳ�䵽success.jsp
		} catch (NameOrPwdException | NullParamException e) {

			e.printStackTrace();
			request.setAttribute("message", e.getMessage());
			return "login";// ����ӳ�䵽login.jspҳ��
		} catch (RuntimeException e) {// ��Dao���׳����쳣
			request.setAttribute("message", e.getMessage());
			return "error";// ӳ�䵽error.jspҳ��
		}

	}

	@RequestMapping("/login-action2.do")
	// SpringMVC �Զ�ע�����HttpServletRequest
	public String checkLogin2(String name,
			@RequestParam("pwd") String password, HttpServletRequest request) {
		System.out.println("---����2---");
		// �ŵ�:�Զ�ת����������,ȱ����ܳ�����������ת���쳣

		System.out.println(name + ":" + password);

		try {
			User user = userService.login(name, password);
			// ��¼�ɹ����û���Ϣ���浽session����
			request.getSession().setAttribute("user", user);
			return "success";// ӳ�䵽success.jsp
		} catch (NameOrPwdException | NullParamException e) {

			e.printStackTrace();
			request.setAttribute("message", e.getMessage());
			return "login";// ����ӳ�䵽login.jspҳ��
		} catch (RuntimeException e) {// ��Dao���׳����쳣
			request.setAttribute("message", e.getMessage());
			return "error";// ӳ�䵽error.jspҳ��
		}

	}

	@RequestMapping("/login-action1.do")
	// SpringMVC �Զ�ע�����HttpServletRequest
	public String checkLogin1(HttpServletRequest request) {
		/* �����쳣 */
		String str = null;
		str.length();

		System.out.println("---����1---");
		// �ŵ�:ֱ�Ӽ��,ȱ����Ҫ�ֶ�������������ת��
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		System.out.println(name + ":" + pwd);

		try {
			System.out
					.println(new String(name.getBytes("iso-8859-1"), "utf-8"));
			User user = userService.login(name, pwd);
			// ��¼�ɹ����û���Ϣ���浽session����
			request.getSession().setAttribute("user", user);
			return "success";// ӳ�䵽success.jsp
		} catch (NameOrPwdException | NullParamException e) {
			request.setAttribute("message", e.getMessage());
			return "redirect:login.do";// �ض���login.do
		} catch (Exception e) {// ��Dao���׳����쳣
			request.setAttribute("message", e.getMessage());
			return "error";// ӳ�䵽error.jspҳ��
		}

	}

}
