package com.cl.easybuy.biz;

import java.util.List;

import com.cl.easybuy.pojo.Product;

/**
 * ��Ʒ��ҵ���߼�
 * 
 * @author hb
 * 
 * @date 2015��9��8�� ����9:16:58
 */
public interface ProductBiz {
	/**
	 * ������е���Ʒ
	 * 
	 * @return
	 */
	public List<Product> getAll();

	/**
	 * ����id�����Ʒ
	 * 
	 * @param id
	 * @return
	 */
	public Product getProductById(int id);
}
