package com.hb.mybatis.biz.impl;

import java.util.List;

import com.hb.mybatis.biz.ProductBiz;
import com.hb.mybatis.dao.ProductMapper;
import com.hb.mybatis.entity.Product;

public class ProductBizImpl implements ProductBiz {

	private ProductMapper productMapper;

	@Override
	public List<Product> getAllProduct() {

		return productMapper.findAll();
	}

	public ProductMapper getProductMapper() {
		return productMapper;
	}

	public void setProductMapper(ProductMapper productMapper) {
		this.productMapper = productMapper;
	}

	@Override
	public List<Product> getProductByPage(int pageIndex, int pageSize) {
		int begin = (pageIndex - 1) * pageSize;
		return productMapper.findByPage(begin, pageSize);
	}

	@Override
	public Product getProductById(int pid) {

		return productMapper.findById(pid);
	}

}
