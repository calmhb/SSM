package com.hb.mybatis.biz.impl;

import java.util.ArrayList;
import java.util.List;

import com.hb.mybatis.biz.OrderBiz;
import com.hb.mybatis.dao.OrderItemMapper;
import com.hb.mybatis.dao.OrderMapper;
import com.hb.mybatis.entity.Car;
import com.hb.mybatis.entity.CarItem;
import com.hb.mybatis.entity.Order;
import com.hb.mybatis.entity.OrderItem;
import com.hb.mybatis.entity.User;
import com.hb.mybatis.exception.DaoException;

public class OrderBizImpl implements OrderBiz {
	private OrderMapper orderMapper;
	private OrderItemMapper orderItemMapper;

	@Override
	public int addOrder(Car car, User u) throws RuntimeException {

		/****************************************
		 * 1.通过购物车获得订单信息
		 ****************************************/

		Order o = new Order();
		o.setAccount(car.getAccount());
		o.setUser(u);
		// 调用OrderDao将order保存到数据库中

		orderMapper.insertOrder(o);

		/********************************************
		 * 2.通过购物车获得订单条目的信息
		 ********************************************/
		List<CarItem> carItems = car.getItems();
		List<OrderItem> orderItems = new ArrayList<OrderItem>();
		for (int i = 0; i < carItems.size(); i++) {
			CarItem carItem = carItems.get(i);
			OrderItem item = new OrderItem();
			item.setOrder(o);// 对应的订单编号
			item.setProduct(carItem.getPro());
			item.setQty(carItem.getQty());
			orderItems.add(item);
		}

		orderItemMapper.addItem(orderItems);

		return o.getId();
	}

	@Override
	public List<OrderItem> findItemsByOid(int oid) throws RuntimeException {
	 
		return orderItemMapper.findItemsByOid(oid);
	}

	public OrderMapper getOrderMapper() {
		return orderMapper;
	}

	public void setOrderMapper(OrderMapper orderMapper) {
		this.orderMapper = orderMapper;
	}

	public OrderItemMapper getOrderItemMapper() {
		return orderItemMapper;
	}

	public void setOrderItemMapper(OrderItemMapper orderItemMapper) {
		this.orderItemMapper = orderItemMapper;
	}

}
