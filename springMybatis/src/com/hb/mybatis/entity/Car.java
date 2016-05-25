package com.hb.mybatis.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述购物系统中的购物车
 * 
 * @author hb
 *
 * @date 2016年4月1日 上午11:45:41
 */
public class Car {
	// 描述购物车中的购物条目
	private List<CarItem> items;
	private double account;// 购物车总金额

	public Car() {
		super();
		items = new ArrayList<CarItem>();
	}

	/**
	 * 向购物车中添加商品
	 * 
	 * 商品只能添加一次，默认数量为1
	 * 
	 * 如果商品已经存在，返回false
	 * 
	 * @param pro
	 *            需要添加的商品
	 * @return 该商品是否已经添加
	 */
	public boolean add(Product pro) {
		// 1.判断商品是否已经存在
		/* if(items.contains(item)){ //自己实现 } */
		// 遍历整个购物车条目
		for (int i = 0, size = items.size(); i < size; i++) {
			// Product p=items.get(i).getPro();
			CarItem carItem = items.get(i);
			Product p = carItem.getPro();
			// 通过商品的唯一编码比价
			if (pro.getId() == p.getId()) {
				return false;
			}
		}
		// 1.通过商品实例化购物车条目
		CarItem item = new CarItem(pro, 1);
		// 说明商品不存在
		items.add(item);
		return true;
	}

	/**
	 * 移除购物车中指定的商品
	 * 
	 * @param Id
	 *            商品的唯一编号
	 */
	public void delete(int Id) {
		// 遍历整个购物车条目
		for (int i = 0, size = items.size(); i < size; i++) {
			// Product p=items.get(i).getPro();
			CarItem carItem = items.get(i);
			Product p = carItem.getPro();
			// 通过商品的唯一编码比价
			if (Id == p.getId()) {
				items.remove(i);
			}
		}

	}

	/**
	 * 修改商品的数量
	 * 
	 * @param Id
	 *            商品的唯一编号
	 * @param qty
	 *            需要修改的数量
	 */
	public void modify(int Id, int qty) {
		// 遍历整个购物车条目
		for (int i = 0, size = items.size(); i < size; i++) {
			CarItem carItem = items.get(i);
			Product p = carItem.getPro();
			// 通过商品的唯一编码比较
			if (Id == p.getId()) {
				carItem.setQty(qty);
			}
		}
	}

	/**
	 * 清空购物车中所有的商品
	 */
	public void clear() {
		items.clear();
	}

	/**
	 * 获得商品的总金额
	 * 
	 * 有Bug
	 * 
	 * @return
	 */
	public double getAccount() {
		// 遍历整个购物车条目
		for (int i = 0, size = items.size(); i < size; i++) {

			CarItem carItem = items.get(i);
			Product p = carItem.getPro();
			account += carItem.getQty() * p.getPrice();
		}
		return account;
	}

	public List<CarItem> getItems() {
		return items;
	}

}
