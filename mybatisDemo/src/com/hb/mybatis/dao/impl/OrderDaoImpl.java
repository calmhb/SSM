/**
 * 
 */
package com.hb.mybatis.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.hb.mybatis.dao.OrderDao;
import com.hb.mybatis.dao.UserDao;
import com.hb.mybatis.entity.Order;
import com.hb.mybatis.entity.User;
import com.hb.mybatis.utils.SqlSessionUtils;

/**
 * 
 * @author hb
 *
 * @date 2016年5月18日 下午4:03:42
 */
public class OrderDaoImpl implements OrderDao {
 
	public int insertOrder(Order order) {
		SqlSession session = SqlSessionUtils.openSession();
		int id = -1;
		try {
			OrderDao orderDao = session.getMapper(OrderDao.class);
			orderDao.insertOrder(order);
			id = order.getId();
			session.commit();
		} catch (Exception e) {
			session.rollback();
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return id;
	}

  public Order selectUserByoid(int oid) {
		SqlSession session = SqlSessionUtils.openSession();
		int id = -1;
		Order order = null;

		try {
			OrderDao orderDao = session.getMapper(OrderDao.class);
			order = orderDao.selectUserByoid(oid);
			System.out.println(order);
		} finally {
			session.close();
		}

		return order;
	}
 
  public List<Order> selectOrdersByuId(int uid) {
		SqlSession session = SqlSessionUtils.openSession();
		int id = -1;
		List<Order> orders = null;

		try {
			OrderDao orderDao = session.getMapper(OrderDao.class);
			orders = orderDao.selectOrdersByuId(uid);

		} finally {
			session.close();
		}

		return orders;
	}

}
