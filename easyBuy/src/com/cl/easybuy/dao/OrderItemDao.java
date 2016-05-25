package com.cl.easybuy.dao;

import java.util.List;

import com.cl.easybuy.pojo.OrderItem;

/**
 * 操作订单详细表
 * 
 * @author calm
 * 
 */
public interface OrderItemDao {
	/**
	 * 将所有的订单详细信息添加到表中
	 * 
	 * @param items
	 */
	public void addItems(List<OrderItem> items);
}
