package com.cl.easybuy.biz;

import java.util.List;

import com.cl.easybuy.pojo.Product;

/**
 * 商品的业务逻辑
 * 
 * @author hb
 * 
 * @date 2015年9月8日 上午9:16:58
 */
public interface ProductBiz {
	/**
	 * 获得所有的商品
	 * 
	 * @return
	 */
	public List<Product> getAll();

	/**
	 * 根据id获得商品
	 * 
	 * @param id
	 * @return
	 */
	public Product getProductById(int id);
}
