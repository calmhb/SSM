package com.cl.easybuy.pojo;

/**
 * 商品
 * 
 * @author calm
 * 
 */
public class Product {
	private int id;
	private String pname;
	private double price;
	private int numb;
	private String pic;
	private String info;// 商品的描述

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(int id, String pname, double price, int numb, String pic,
			String info) {
		super();
		this.id = id;
		this.pname = pname;
		this.price = price;
		this.numb = numb;
		this.pic = pic;
		this.info = info;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getNumb() {
		return numb;
	}

	public void setNumb(int numb) {
		this.numb = numb;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

}
