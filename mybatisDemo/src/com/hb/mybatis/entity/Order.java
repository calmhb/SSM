/**
 * 
 */
package com.hb.mybatis.entity;

import java.util.Date;

/**
 * 
 * @author hb
 *
 * @date 2016年5月18日 下午3:33:07
 */
public class Order {
	//提供getter和setter方法
	private int id;
	private double account;
	private Date dotime;
	/* 关系属性 */
	private User user;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the account
	 */
	public double getAccount() {
		return account;
	}

	/**
	 * @param account
	 *            the account to set
	 */
	public void setAccount(double account) {
		this.account = account;
	}

	/**
	 * @return the dotime
	 */
	public Date getDotime() {
		return dotime;
	}

	/**
	 * @param dotime
	 *            the dotime to set
	 */
	public void setDotime(Date dotime) {
		this.dotime = dotime;
	}

}
