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
 * �����û�����
 * 
 * @author hb
 * 
 * @date 2015��9��8�� ����9:03:12
 */
public class UserManagerServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		/* ������������ */
		request.setCharacterEncoding("utf-8");
		// ͨ��request�������û��ύ������
		// �����form���ж�Ӧ��input��name����һ��
		String username = request.getParameter("name");
		String pwd = request.getParameter("password");

		System.out.println(username + "  " + pwd);
		// ����ҵ��㴦��ҵ���߼�
		UserBiz userBiz = new UserBizImpl();
		// ���Session
		HttpSession session = request.getSession();
		try {
			User u = userBiz.login(username, pwd);
			System.out.println("��¼�ɹ�");
			/**
			 * ��¼�ɹ�ʹ��Session��¼�û���״̬
			 */
			session.setAttribute("user", u);
			// ��ת��list.jsp
			// �ض���
			response.sendRedirect("list.cart");
		} catch (Exception e) {
			// ��������Ϣת����ҳ��
			request.setAttribute("err_msg", e.getMessage());
			request.getRequestDispatcher("login.jsp")
					.forward(request, response);
		}

	}
}
