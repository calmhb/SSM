package com.cl.easybuy.pojo;

/**
 * ���ﳵ����Ŀ
 * 
 * @author hb
 * 
 * @date 2015��9��8�� ����10:39:26
 */
public class CartItem {
	private Product product;// ��Ʒ
	private int numb;// ����

	public CartItem() {
		super();
	}

	public CartItem(Product product, int numb) {
		super();
		this.product = product;
		this.numb = numb;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getNumb() {
		return numb;
	}

	public void setNumb(int numb) {
		this.numb = numb;
	}

}
