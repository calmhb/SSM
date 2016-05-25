package com.cl.easybuy.dao;

import java.util.List;

import com.cl.easybuy.pojo.Product;

/**
 * 定义访问商品表的规则
 * 
 * @author calm
 * 
 */
public interface ProductDao {
	/**
	 * 查询所有的商品信息
	 * 
	 * @return
	 */
	public List<Product> findAll();

	/**
	 * 根据商品的编号获得对应的商品
	 * 
	 * @param id
	 * @return
	 */
	public Product findProductById(int id);
}
