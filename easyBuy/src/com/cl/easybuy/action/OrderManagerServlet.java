package com.cl.easybuy.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cl.easybuy.biz.OrderBiz;
import com.cl.easybuy.biz.impl.OrderBizImpl;
import com.cl.easybuy.pojo.Cart;
import com.cl.easybuy.pojo.User;

/**
 * 订单管理
 * 
 * @author hb
 * 
 * @date 2015年9月10日 上午9:53:28
 */
public class OrderManagerServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"), uri.lastIndexOf('.'));
		// 获得购物车信息
		HttpSession session = request.getSession();
		// 获得购物车和用户的信息
		Cart cart = (Cart) session.getAttribute("cart");
		User user = (User) session.getAttribute("user");

		if ("/add".equals(path)) {

			OrderBiz orderBiz = new OrderBizImpl();
			int oid = orderBiz.addOrder(user, cart);
			// 将订单编号进行转发
			request.setAttribute("oid", oid);
			request.getRequestDispatcher("message.jsp").forward(request,
					response);
		}
	}
}
