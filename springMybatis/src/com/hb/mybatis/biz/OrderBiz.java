package com.hb.mybatis.biz;

import java.util.List;

import com.hb.mybatis.entity.Car;
import com.hb.mybatis.entity.OrderItem;
import com.hb.mybatis.entity.User;

/**
 * 订单的业务层
 * 
 * @author hb
 *
 * @date 2016年5月23日 下午5:14:21
 */
public interface OrderBiz {
	/**
	 * 通过购物车处理订单业务
	 * 
	 * @param car
	 * @param 用户编号
	 * 
	 * @return 订单编号
	 */
	public int addOrder(Car car, User u) throws RuntimeException;

	List<OrderItem> findItemsByOid(int oid) throws RuntimeException;

}
