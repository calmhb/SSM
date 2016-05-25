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
 * ��������
 * 
 * @author hb
 * 
 * @date 2015��9��10�� ����9:53:28
 */
public class OrderManagerServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"), uri.lastIndexOf('.'));
		// ��ù��ﳵ��Ϣ
		HttpSession session = request.getSession();
		// ��ù��ﳵ���û�����Ϣ
		Cart cart = (Cart) session.getAttribute("cart");
		User user = (User) session.getAttribute("user");

		if ("/add".equals(path)) {

			OrderBiz orderBiz = new OrderBizImpl();
			int oid = orderBiz.addOrder(user, cart);
			// ��������Ž���ת��
			request.setAttribute("oid", oid);
			request.getRequestDispatcher("message.jsp").forward(request,
					response);
		}
	}
}
