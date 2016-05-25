package com.hb.mybatis.entity;

/**
 * 订单条目
 * 
 * @author hb
 *
 * @date 2016年4月21日 上午11:33:51
 */
public class OrderItem {
	private int id;
	private int qty;
    /*关系属性*/
	private Order order;
	private Product product;

	public OrderItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderItem(Product product, Order order, int qty) {
		super();
		this.product = product;
		this.order = order;
		this.qty = qty;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

}
