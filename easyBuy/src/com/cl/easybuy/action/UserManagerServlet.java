package com.cl.easybuy.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cl.easybuy.biz.UserBiz;
import com.cl.easybuy.biz.impl.UserBizImpl;
import com.cl.easybuy.pojo.User;

/**
 * 处理用户功能
 * 
 * @author hb
 * 
 * @date 2015年9月8日 上午9:03:12
 */
public class UserManagerServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		/* 处理中文乱码 */
		request.setCharacterEncoding("utf-8");
		// 通过request对象获得用户提交的数据
		// 必须和form表单中对应的input的name属性一致
		String username = request.getParameter("name");
		String pwd = request.getParameter("password");

		System.out.println(username + "  " + pwd);
		// 调用业务层处理业务逻辑
		UserBiz userBiz = new UserBizImpl();
		// 获得Session
		HttpSession session = request.getSession();
		try {
			User u = userBiz.login(username, pwd);
			System.out.println("登录成功");
			/**
			 * 登录成功使用Session记录用户的状态
			 */
			session.setAttribute("user", u);
			// 跳转到list.jsp
			// 重定向
			response.sendRedirect("list.cart");
		} catch (Exception e) {
			// 将错误信息转发到页面
			request.setAttribute("err_msg", e.getMessage());
			request.getRequestDispatcher("login.jsp")
					.forward(request, response);
		}

	}
}
