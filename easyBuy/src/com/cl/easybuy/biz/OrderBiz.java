package com.cl.easybuy.biz;

import com.cl.easybuy.pojo.Cart;
import com.cl.easybuy.pojo.User;

/**
 * 订单的业务逻辑
 * 
 * @author hb
 * 
 * @date 2015年9月10日 上午9:57:08
 */
public interface OrderBiz {
	public int addOrder(User u, Cart cart);
}
