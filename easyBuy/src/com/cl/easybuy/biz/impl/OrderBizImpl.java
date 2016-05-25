package com.cl.easybuy.biz.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cl.easybuy.biz.OrderBiz;
import com.cl.easybuy.dao.OrderDao;
import com.cl.easybuy.dao.OrderItemDao;
import com.cl.easybuy.dao.impl.OrderDaoImpl;
import com.cl.easybuy.dao.impl.OrderItemDaoImpl;
import com.cl.easybuy.pojo.Cart;
import com.cl.easybuy.pojo.CartItem;
import com.cl.easybuy.pojo.Order;
import com.cl.easybuy.pojo.OrderItem;
import com.cl.easybuy.pojo.User;

/**
 * 生成订单
 * 
 * @author hb
 * 
 * @date 2015年9月10日 上午9:58:23
 */
public class OrderBizImpl implements OrderBiz {
	private OrderDao orderDao = new OrderDaoImpl();
	private OrderItemDao itemDao = new OrderItemDaoImpl();

	@Override
	public int addOrder(User u, Cart cart) {
		// 通过购物车获得订单对象order
		Order o = new Order();
		o.setDotime(new Date());
		o.setUid(u.getId());
		o.setAccount(cart.getAccount());

		List<CartItem> items = cart.getItems();
		int total = 0;
		for (int i = 0; i < items.size(); i++) {
			CartItem item = items.get(i);
			total += item.getNumb();
		}
		o.setTotal(total);

		// 保存order对象
		int oid = orderDao.addOrder(o);

		// 保存订单条目
		List<OrderItem> oitems = new ArrayList<OrderItem>();
		for (int i = 0; i < items.size(); i++) {
			CartItem item = items.get(i);

			OrderItem oi = new OrderItem();
			oi.setPid(item.getProduct().getId());
			oi.setNumb(item.getNumb());
			oi.setOid(oid);
			oi.setAccount(item.getProduct().getPrice() * item.getNumb());
			oitems.add(oi);
		}

		itemDao.addItems(oitems);

		return oid;
	}

}
