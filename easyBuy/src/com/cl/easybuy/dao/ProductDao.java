package com.cl.easybuy.dao;

import java.util.List;

import com.cl.easybuy.pojo.Product;

/**
 * ���������Ʒ��Ĺ���
 * 
 * @author calm
 * 
 */
public interface ProductDao {
	/**
	 * ��ѯ���е���Ʒ��Ϣ
	 * 
	 * @return
	 */
	public List<Product> findAll();

	/**
	 * ������Ʒ�ı�Ż�ö�Ӧ����Ʒ
	 * 
	 * @param id
	 * @return
	 */
	public Product findProductById(int id);
}
