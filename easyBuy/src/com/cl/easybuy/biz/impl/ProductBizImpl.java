package com.cl.easybuy.biz.impl;

import java.util.List;

import com.cl.easybuy.biz.ProductBiz;
import com.cl.easybuy.dao.ProductDao;
import com.cl.easybuy.dao.impl.ProductDaoImpl;
import com.cl.easybuy.pojo.Product;

public class ProductBizImpl implements ProductBiz {
	private ProductDao productDao = new ProductDaoImpl();

	@Override
	public List<Product> getAll() {
		List<Product> pros = null;
		try {

			pros = productDao.findAll();

		} catch (Exception e) {
			throw new RuntimeException("服务器异常!");
		}
		return pros;
	}

	@Override
	public Product getProductById(int id) {
		Product p = null;
		try {
			p = productDao.findProductById(id);
		} catch (Exception e) {
			throw new RuntimeException("服务器异常!");
		}
		return p;
	}

}
