package com.hb.mvc.pojo;

import java.io.Serializable;

/** 实体类 */
public class User implements Serializable {
	private int id;//属性提供getter和setter方法
	private String name;
	private String pwd;
	private String phone;

	public User() {
	}

	public User(int id, String name, String pwd, String phone) {
		this.id = id;
		this.name = name;
		this.pwd = pwd;
		this.phone = phone;
	}

	public User(String name, String pwd, String phone) {
		super();
		this.name = name;
		this.pwd = pwd;
		this.phone = phone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public int hashCode() {
		return id;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (obj instanceof User) {
			User o = (User) obj;
			return this.id == o.id;
		}
		return true;
	}

	@Override
	public String toString() {
		return id + "," + name + "," + pwd + "," + phone;
	}
}
