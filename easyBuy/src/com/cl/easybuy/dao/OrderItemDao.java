package com.cl.easybuy.dao;

import java.util.List;

import com.cl.easybuy.pojo.OrderItem;

/**
 * ����������ϸ��
 * 
 * @author calm
 * 
 */
public interface OrderItemDao {
	/**
	 * �����еĶ�����ϸ��Ϣ��ӵ�����
	 * 
	 * @param items
	 */
	public void addItems(List<OrderItem> items);
}
