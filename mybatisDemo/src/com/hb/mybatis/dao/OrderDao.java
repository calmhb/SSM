/**
 * 
 */
package com.hb.mybatis.dao;

import java.util.List;

import com.hb.mybatis.entity.Order;

/**
 * 
 * @author hb
 *
 * @date 2016年5月18日 下午3:32:20
 */
public interface OrderDao {
	int insertOrder(Order order);
	Order selectUserByoid(int oid);
	List<Order> selectOrdersByuId(int uid);
}
