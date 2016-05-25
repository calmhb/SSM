package com.hb.mybatis.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hb.mybatis.biz.OrderBiz;
import com.hb.mybatis.biz.ProductBiz;
import com.hb.mybatis.biz.UserBiz;
import com.hb.mybatis.dao.OrderItemMapper;
import com.hb.mybatis.entity.Car;
import com.hb.mybatis.entity.Order;
import com.hb.mybatis.entity.OrderItem;
import com.hb.mybatis.entity.Product;
import com.hb.mybatis.entity.User;
import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 测试
 * 
 * @author hb
 *
 * @date 2016年5月23日 上午10:04:49
 */

 
public class SpringTest {
	@Ignore
	@Test
	public void testSpringDS() throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		// System.out.println(ac);
		// DriverManagerDataSource ds = (DriverManagerDataSource) ac
		// .getBean("dataSource");
		// System.out.println(ds);
		ComboPooledDataSource pool = (ComboPooledDataSource) ac
				.getBean("dsPool");
		System.out.println(pool.getConnection());
	}

	@Ignore
	@Test
	public void testMapper() {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		System.out.println(ac);
		// System.out.println(Arrays.toString(ac.getBeanDefinitionNames()));
		// DriverManagerDataSource ds = (DriverManagerDataSource) ac
		// .getBean("dataSource");
		// System.out.println(ds);
		// ComboPooledDataSource pool = (ComboPooledDataSource) ac
		// .getBean("dsPool");
		// System.out.println(pool);
		UserBiz userBiz = ac.getBean("userBiz", UserBiz.class);
		// int count = userBiz.countUser();

		User u = new User();
		u.setName("tom");
		u.setPwd("250");
		userBiz.addUser(u);
	}

	@Ignore
	@Test
	public void testProductMapper() {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"applicationContext.xml");

		ProductBiz proBiz = ac.getBean("productBiz", ProductBiz.class);
		// List<Product> lists = proBiz.getProductByPage(1, 2);
		// System.out.println(lists);
		// for (Product p : lists) {
		// System.out.println(p.getName());
		// }
		Product pro = proBiz.getProductById(2);
		System.out.println(pro.getName());
	}

	@Test
	public void testItemBiz() {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		OrderBiz orderBiz = ac.getBean("orderBiz", OrderBiz.class);
		List<OrderItem> items = orderBiz.findItemsByOid(113);
		System.out.println("xxxx");
		for (OrderItem it : items) {
			System.out.println(it.getOrder().getId());
			System.out.println(it.getProduct().getName());
			System.out.println(it.getQty());
		}
	}

	@Ignore
	@Test
	public void testBizDao() {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"applicationContext.xml");

		// 1.准备商品信息
		Product p1 = new Product(1, "iphone6s", 6000);
		Product p2 = new Product(2, "Mate8", 4000);
		Product p3 = new Product(3, "锤子", 3600);

		// 2.装备购物车数据
		Car car = new Car();

		car.add(p2);
		car.add(p3);

		car.modify(2, 3);

		User u = new User();
		u.setId(1016);

		OrderBiz orderBiz = ac.getBean("orderBiz", OrderBiz.class);
		int oid = orderBiz.addOrder(car, u);
		System.out.println("oid===" + oid);
	}

	@Ignore
	@Test
	public void testItemDao() {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		OrderItemMapper mapper = ac.getBean("orderItemMapper",
				OrderItemMapper.class);
		List<OrderItem> lists = new ArrayList<OrderItem>();

		Product p1 = new Product();
		p1.setId(1);

		Product p2 = new Product();
		p2.setId(2);

		Order o1 = new Order();
		o1.setId(101);

		Order o2 = new Order();
		o2.setId(102);

		OrderItem oi1 = new OrderItem(p1, o1, 23);
		OrderItem oi2 = new OrderItem(p1, o2, 3);
		OrderItem oi3 = new OrderItem(p2, o1, 32);
		lists.add(oi1);
		lists.add(oi2);
		lists.add(oi3);

		mapper.addItem(lists);
		for (OrderItem oi : lists) {
			System.out.println(oi.getId());
		}
	}

}
