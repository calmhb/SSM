package com.cl.easybuy.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.cl.easybuy.dao.OrderDao;
import com.cl.easybuy.dao.OrderItemDao;
import com.cl.easybuy.dao.ProductDao;
import com.cl.easybuy.dao.UserDao;
import com.cl.easybuy.dao.impl.OrderDaoImpl;
import com.cl.easybuy.dao.impl.OrderItemDaoImpl;
import com.cl.easybuy.dao.impl.ProductDaoImpl;
import com.cl.easybuy.dao.impl.UserDaoImpl;
import com.cl.easybuy.pojo.Order;
import com.cl.easybuy.pojo.OrderItem;
import com.cl.easybuy.pojo.Product;
import com.cl.easybuy.pojo.User;

/**
 * Dao的测试类
 * 
 * @author hb
 * 
 * @date 2015年9月7日 下午2:55:02
 */
public class DaoTest {
	@Ignore
	@Test
	public void testAddUser() {
		// 1.提供一个实例化的对象
		User u = new User();
		u.setUsername("haoren");
		u.setPwd("123");
		u.setPro(0);// 表示普通用户

		UserDao uDao = new UserDaoImpl();
		uDao.addUser(u);

	}

	@Ignore
	@Test
	public void findUser() {

		UserDao uDao = new UserDaoImpl();
		User u = uDao.findUser("haoren", "123");
		System.out.println(u);

	}

	@Ignore
	@Test
	public void findAllProduct() {
		ProductDao pDao = new ProductDaoImpl();
		List<Product> pros = pDao.findAll();
		System.out.println(pros.size());

		Product p = pDao.findProductById(8001);
		System.out.println(p.getPname());
	}

	@Ignore
	@Test
	public void addOrder() {
		Order o = new Order();
		o.setAccount(999);
		o.setTotal(9);
		o.setUid(1001);

		OrderDao oDao = new OrderDaoImpl();
		int oid = oDao.addOrder(o);
		System.out.println(oid);
	}

	@Test
	public void addItems() {
		List<OrderItem> items = new ArrayList<OrderItem>();
		OrderItem i1 = new OrderItem();
		i1.setAccount(200);
		i1.setNumb(2);
		i1.setPid(8001);
		i1.setOid(1);

		OrderItem i2 = new OrderItem();
		i2.setAccount(100);
		i2.setNumb(1);
		i2.setPid(8004);
		i2.setOid(1);

		items.add(i1);
		items.add(i2);
		OrderItemDao oDao = new OrderItemDaoImpl();
		oDao.addItems(items);

	}
}
