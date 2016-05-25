package com.cl.easybuy.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cl.easybuy.pojo.User;

/**
 * 对用户是否登录进行过滤
 * 
 * @author hb
 * 
 * @date 2015年9月10日 上午8:57:44
 */
public class LoginFilter implements Filter {
	private FilterConfig config;

	/**
	 * 拦截器功能的实现
	 * 
	 * FilterChain:过滤链
	 */
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		/**
		 * 从Session中获得用户信息
		 */
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("user");
		if (u == null) {// 说明用户没有登录
			// 跳转到登录页面
			request.setAttribute("err_msg", "请先登录!");
			request.getRequestDispatcher("login.jsp")
					.forward(request, response);
		} else {
			// 不为null,说明用户已经登录
			// 按照正常的流程继续
			chain.doFilter(request, response);
		}
	}

	/**
	 * 创建对象时进行初始化功能
	 * 
	 */

	public void init(FilterConfig config) throws ServletException {
		this.config = config;

	}

	/**
	 * 销毁资源
	 */
	public void destroy() {

	}

}
