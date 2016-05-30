package com.hb.mvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/** �Զ��������� */
public class SomeInterceptor implements HandlerInterceptor {
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object obj, Exception e)
			throws Exception {
		System.out.println(".....��������֮�����.....");

	}
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object obj, ModelAndView model)
			throws Exception {
		System.out.println("---������ִ����֮�����---");

	}
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object obj) throws Exception {
		System.out.println("---������ִ��ǰ����---");
		return true;
	}

}
