package com.cl.easybuy.biz;

import com.cl.easybuy.pojo.Cart;
import com.cl.easybuy.pojo.User;

/**
 * ������ҵ���߼�
 * 
 * @author hb
 * 
 * @date 2015��9��10�� ����9:57:08
 */
public interface OrderBiz {
	public int addOrder(User u, Cart cart);
}
