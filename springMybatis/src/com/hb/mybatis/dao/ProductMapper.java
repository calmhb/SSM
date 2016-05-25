package com.hb.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hb.mybatis.entity.Product;
import com.hb.mybatis.exception.DaoException;

public interface ProductMapper {

	/** 插入商品   */
	void insertProduct(Product pro) throws DaoException;

	/** 进行分页查询 */
	List<Product> findByPage(@Param("begin") int begin,
			@Param("size") int length) throws DaoException;

	/** 返回总记录数 */
	int getTotal() throws DaoException;

	/** 查询所有的商品信息 */
	List<Product> findAll() throws DaoException;

	/**  根据商品编码查询商品 */
	Product findById(int pid) throws DaoException;

}
