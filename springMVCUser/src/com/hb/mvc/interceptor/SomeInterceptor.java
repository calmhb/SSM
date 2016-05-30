package com.hb.mvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/** 自定义拦截器 */
public class SomeInterceptor implements HandlerInterceptor {
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object obj, Exception e)
			throws Exception {
		System.out.println(".....请求处理完之后调用.....");

	}
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object obj, ModelAndView model)
			throws Exception {
		System.out.println("---处理器执行完之后调用---");

	}
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object obj) throws Exception {
		System.out.println("---处理器执行前调用---");
		return true;
	}

}
