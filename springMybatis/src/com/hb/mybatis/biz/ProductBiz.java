package com.hb.mybatis.biz;

import java.util.List;

import com.hb.mybatis.entity.Product;

/**
 * 商品的业务层
 * 
 * @author hb
 *
 * @date 2016年5月23日 下午2:46:48
 */
public interface ProductBiz {
	List<Product> getAllProduct();

	List<Product> getProductByPage(int pageIndex, int pageSize);

	Product getProductById(int pid);
}
