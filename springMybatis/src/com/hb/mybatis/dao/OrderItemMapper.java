package com.hb.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hb.mybatis.entity.OrderItem;
import com.hb.mybatis.exception.DaoException;

public interface OrderItemMapper {
	/** 添加等待订单条目 */
	public void addItem(List<OrderItem> items) throws DaoException;

	/** 根据订单编号查询条目信息 */
	List<OrderItem> findItemsByOid(@Param("oid") int oid) throws DaoException;
}
