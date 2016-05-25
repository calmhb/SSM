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
 * 处理购物车业务逻辑
 * 
 * @author hb
 * 
 * @date 2015年9月8日 上午9:21:05
 */
public class CartManagerServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 处理中文乱码问题
		request.setCharacterEncoding("utf-8");
		// 响应的中文问题
		response.setContentType("text/html;charset=utf-8");

		String uri = request.getRequestURI();
		System.out.println("uri=" + uri);
		String path = uri.substring(uri.lastIndexOf("/"), uri.lastIndexOf("."));
		System.out.println(path);
		// 通过业务层获得所有的商品
		ProductBiz pBiz = new ProductBizImpl();
		// 获得Session对象
		HttpSession session = request.getSession();
		if ("/list".equals(path)) {
			try {
				List<Product> pros = pBiz.getAll();
				System.out.println(pros.size());
				// 使用转发将数据发送到list.jsp页面中
				// 为reqeust对象中封装数据
				request.setAttribute("pros", pros);
				request.getRequestDispatcher("list.jsp").forward(request,
						response);

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} else if ("/buy".equals(path)) {
			// 获得商品的id值
			int pid = Integer.parseInt(request.getParameter("pid"));
			// 根据商品的id从数据库中获得商品
			Product p = pBiz.getProductById(pid);
			// 先从Session中获得购物车对象
			Cart cart = (Cart) session.getAttribute("cart");
			if (cart == null) {
				// 实例化Cart对象
				cart = new Cart();
			}
			// 将商品添加到购物车中
			cart.buy(p);
			session.setAttribute("cart", cart);
			// 重定向到list.jsp页面
			response.sendRedirect("list.cart");
		} else if ("/del".equals(path)) {
			// 获得商品的id值
			int pid = Integer.parseInt(request.getParameter("pid"));
			// 先从Session中获得购物车对象
			Cart cart = (Cart) session.getAttribute("cart");
			cart.delete(pid);
			// 重定向到cart.jsp页面
			response.sendRedirect("cart.jsp");
		} else if ("/clear".equals(path)) {
			// 先从Session中获得购物车对象
			Cart cart = (Cart) session.getAttribute("cart");
			cart.clear();
			// 重定向到cart.jsp页面
			response.sendRedirect("cart.jsp");
		} else if ("/modify".equals(path)) {
			// 获得商品的id值
			int pid = Integer.parseInt(request.getParameter("pid"));
			int numb = Integer.parseInt(request.getParameter("numb"));
			// 先从Session中获得购物车对象
			Cart cart = (Cart) session.getAttribute("cart");
			cart.modify(pid, numb);
			// 重定向到cart.jsp页面
			response.sendRedirect("cart.jsp");
		}
	}
}
