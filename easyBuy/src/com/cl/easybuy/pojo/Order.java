package com.cl.easybuy.pojo;

import java.util.Date;

/**
 * ¶©µ¥
 * 
 * @author calm
 * 
 */
public class Order {
	private int id;
	private int total;
	private double account;
	private Date dotime;
	private int uid;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public double getAccount() {
		return account;
	}

	public void setAccount(double account) {
		this.account = account;
	}

	public Date getDotime() {
		return dotime;
	}

	public void setDotime(Date dotime) {
		this.dotime = dotime;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public Order(int id, int total, double account, Date dotime, int uid) {
		super();
		this.id = id;
		this.total = total;
		this.account = account;
		this.dotime = dotime;
		this.uid = uid;
	}

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

}
