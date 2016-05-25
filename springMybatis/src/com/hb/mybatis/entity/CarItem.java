package com.hb.mybatis.entity;

/**
 * 描述购物车条目
 * 
 * @author hb
 *
 * @date 2016年4月1日 上午11:44:12
 */
public class CarItem {
	private Product pro;// 条目中的商品
	private int qty;// 商品的数量

	public CarItem() {
		super();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (obj instanceof CarItem) {
			CarItem other = (CarItem) obj;
			return other.equals(this.pro);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return this.pro.hashCode();
	}

	public CarItem(Product pro, int qty) {
		super();
		this.pro = pro;
		this.qty = qty;
	}

	public Product getPro() {
		return pro;
	}

	public void setPro(Product pro) {
		this.pro = pro;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

}
