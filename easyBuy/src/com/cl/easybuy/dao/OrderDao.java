package com.cl.easybuy.dao;

import com.cl.easybuy.pojo.Order;

/**
 * ������ʶ�����Ĺ���
 * 
 * @author calm
 * 
 */
public interface OrderDao {
	/**
	 * ��Ӷ���
	 * 
	 * @param order
	 * @return ���ص�ǰ�Ķ���������
	 */
	public int addOrder(Order order);
}
