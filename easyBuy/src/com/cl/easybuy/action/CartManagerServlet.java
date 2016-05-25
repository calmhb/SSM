package com.cl.easybuy.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cl.easybuy.biz.ProductBiz;
import com.cl.easybuy.biz.impl.ProductBizImpl;
import com.cl.easybuy.pojo.Cart;
import com.cl.easybuy.pojo.Product;

/**
 * �����ﳵҵ���߼�
 * 
 * @author hb
 * 
 * @date 2015��9��8�� ����9:21:05
 */
public class CartManagerServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// ����������������
		request.setCharacterEncoding("utf-8");
		// ��Ӧ����������
		response.setContentType("text/html;charset=utf-8");

		String uri = request.getRequestURI();
		System.out.println("uri=" + uri);
		String path = uri.substring(uri.lastIndexOf("/"), uri.lastIndexOf("."));
		System.out.println(path);
		// ͨ��ҵ��������е���Ʒ
		ProductBiz pBiz = new ProductBizImpl();
		// ���Session����
		HttpSession session = request.getSession();
		if ("/list".equals(path)) {
			try {
				List<Product> pros = pBiz.getAll();
				System.out.println(pros.size());
				// ʹ��ת�������ݷ��͵�list.jspҳ����
				// Ϊreqeust�����з�װ����
				request.setAttribute("pros", pros);
				request.getRequestDispatcher("list.jsp").forward(request,
						response);

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} else if ("/buy".equals(path)) {
			// �����Ʒ��idֵ
			int pid = Integer.parseInt(request.getParameter("pid"));
			// ������Ʒ��id�����ݿ��л����Ʒ
			Product p = pBiz.getProductById(pid);
			// �ȴ�Session�л�ù��ﳵ����
			Cart cart = (Cart) session.getAttribute("cart");
			if (cart == null) {
				// ʵ����Cart����
				cart = new Cart();
			}
			// ����Ʒ��ӵ����ﳵ��
			cart.buy(p);
			session.setAttribute("cart", cart);
			// �ض���list.jspҳ��
			response.sendRedirect("list.cart");
		} else if ("/del".equals(path)) {
			// �����Ʒ��idֵ
			int pid = Integer.parseInt(request.getParameter("pid"));
			// �ȴ�Session�л�ù��ﳵ����
			Cart cart = (Cart) session.getAttribute("cart");
			cart.delete(pid);
			// �ض���cart.jspҳ��
			response.sendRedirect("cart.jsp");
		} else if ("/clear".equals(path)) {
			// �ȴ�Session�л�ù��ﳵ����
			Cart cart = (Cart) session.getAttribute("cart");
			cart.clear();
			// �ض���cart.jspҳ��
			response.sendRedirect("cart.jsp");
		} else if ("/modify".equals(path)) {
			// �����Ʒ��idֵ
			int pid = Integer.parseInt(request.getParameter("pid"));
			int numb = Integer.parseInt(request.getParameter("numb"));
			// �ȴ�Session�л�ù��ﳵ����
			Cart cart = (Cart) session.getAttribute("cart");
			cart.modify(pid, numb);
			// �ض���cart.jspҳ��
			response.sendRedirect("cart.jsp");
		}
	}
}
