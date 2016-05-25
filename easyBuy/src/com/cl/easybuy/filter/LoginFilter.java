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
 * ���û��Ƿ��¼���й���
 * 
 * @author hb
 * 
 * @date 2015��9��10�� ����8:57:44
 */
public class LoginFilter implements Filter {
	private FilterConfig config;

	/**
	 * ���������ܵ�ʵ��
	 * 
	 * FilterChain:������
	 */
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		/**
		 * ��Session�л���û���Ϣ
		 */
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("user");
		if (u == null) {// ˵���û�û�е�¼
			// ��ת����¼ҳ��
			request.setAttribute("err_msg", "���ȵ�¼!");
			request.getRequestDispatcher("login.jsp")
					.forward(request, response);
		} else {
			// ��Ϊnull,˵���û��Ѿ���¼
			// �������������̼���
			chain.doFilter(request, response);
		}
	}

	/**
	 * ��������ʱ���г�ʼ������
	 * 
	 */

	public void init(FilterConfig config) throws ServletException {
		this.config = config;

	}

	/**
	 * ������Դ
	 */
	public void destroy() {

	}

}
