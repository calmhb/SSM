/**
 * 
 */
package com.hb.mybatis.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.hb.mybatis.dao.OrderDao;
import com.hb.mybatis.dao.impl.OrderDaoImpl;
import com.hb.mybatis.entity.Order;
import com.hb.mybatis.entity.User;

/**
 * 
 * @author hb
 *
 * @date 2016年5月18日 下午4:06:55
 */
public class OrderDaoTest {
	OrderDao orderMapper = new OrderDaoImpl();

	@Ignore
	@Test
	public void addOrder() {
		User u = new User();
		u.setId(1001);

		Order o = new Order();
		o.setUser(u);
		o.setAccount(2500);

		OrderDao orderMapper = new OrderDaoImpl();
		int id = orderMapper.insertOrder(o);
		System.out.println(id);
	}

	@Test
	public void queryOrders() {
		List<Order> orders = orderMapper.selectOrdersByuId(1001);
		for (Order o : orders) {
			System.out.println(o.getId() + "\t" + o.getDotime());
		}
	}

	@Ignore
	@Test
	public void queryUserByoid() {
		int oid = 102;

		Order order = orderMapper.selectUserByoid(oid);

		System.out.println(order.getUser().getId());
	}
}
