package com.cl.easybuy.pojo;

/**
 * 封装用户信息
 * 
 * @author calm
 * 
 */
public class User {
	/**
	 * 属性:描述对象的特征
	 */
	private Integer id;// 编号
	private String username;// 用户名
	private String pwd;// 密码
	private int pro;// 权限

	/**
	 * 构造器
	 */
	public User() {
	}

	public User(Integer id, String username, String pwd, int pro) {
		super();
		this.id = id;
		this.username = username;
		this.pwd = pwd;
		this.pro = pro;
	}

	/**
	 * 为属性提供getter和setter方法
	 */
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public int getPro() {
		return pro;
	}

	public void setPro(int pro) {
		this.pro = pro;
	}

}
