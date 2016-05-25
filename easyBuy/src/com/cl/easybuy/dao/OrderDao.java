package com.cl.easybuy.dao;

import com.cl.easybuy.pojo.Order;

/**
 * 定义访问订单表的规则
 * 
 * @author calm
 * 
 */
public interface OrderDao {
	/**
	 * 添加订单
	 * 
	 * @param order
	 * @return 返回当前的订单的主键
	 */
	public int addOrder(Order order);
}
