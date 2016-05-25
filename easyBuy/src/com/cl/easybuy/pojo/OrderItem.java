package com.cl.easybuy.pojo;

/**
 * 订单条目
 * 
 * @author calm
 * 
 */
public class OrderItem {
	private int id;
	private int numb;/* 商品数量 */
	private double account;
	private int oid;/* 订单编号 */
	private int pid;/* 商品编号 */

	public OrderItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderItem(int id, int numb, double account, int oid, int pid) {
		super();
		this.id = id;
		this.numb = numb;
		this.account = account;
		this.oid = oid;
		this.pid = pid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumb() {
		return numb;
	}

	public void setNumb(int numb) {
		this.numb = numb;
	}

	public double getAccount() {
		return account;
	}

	public void setAccount(double account) {
		this.account = account;
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

}
