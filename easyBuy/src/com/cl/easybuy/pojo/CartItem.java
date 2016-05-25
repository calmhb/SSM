package com.cl.easybuy.pojo;

/**
 * 购物车的条目
 * 
 * @author hb
 * 
 * @date 2015年9月8日 上午10:39:26
 */
public class CartItem {
	private Product product;// 商品
	private int numb;// 数量

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
