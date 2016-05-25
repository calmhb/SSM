package com.cl.easybuy.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * 购物车
 * 
 * @author hb
 * 
 * @date 2015年9月8日 上午10:40:36
 */
public class Cart {
	/**
	 * 一个购物车中有多个购物车条目
	 */
	private List<CartItem> items = new ArrayList<CartItem>();
	private double account;// 总金额

	/**
	 * 购买一个商品
	 * 
	 * 将商品作为一个购物车的条目追加到购物车中
	 * 
	 * @param pro
	 * @return 如果商品存在返回false,如果不存在,添加返回true
	 */
	public boolean buy(Product pro) {
		for (int i = 0; i < items.size(); i++) {
			CartItem item = items.get(i);
			// 判断条目中是否已经包含该商品
			if (pro.getId() == item.getProduct().getId()) {
				return false;
			}

		}
		// 创建一个条目追加到集合中
		CartItem item = new CartItem();
		item.setProduct(pro);
		item.setNumb(1);
		items.add(item);
		return true;
	}

	/**
	 * 修改购物车中的数量
	 * 
	 * @param pid
	 * @param numb
	 */
	public void modify(int pid, int numb) {
		for (int i = 0; i < items.size(); i++) {
			CartItem item = items.get(i);
			if (item.getProduct().getId() == pid) {
				item.setNumb(numb);
			}
		}
	}

	/**
	 * 删除购物车中的商品
	 * 
	 * @param pid
	 */
	public void delete(int pid) {
		for (int i = items.size() - 1; i >= 0; i--) {
			CartItem item = items.get(i);
			if (item.getProduct().getId() == pid) {
				items.remove(i);
			}
		}
	}

	/**
	 * 清空购物车中的商品
	 */
	public void clear() {
		items.clear();
	}

	public List<CartItem> getItems() {
		return items;
	}

	/**
	 * 计算总金额
	 * 
	 * @return
	 */
	public double getAccount() {
		this.account = 0.0;
		for (int i = 0; i < items.size(); i++) {
			CartItem item = items.get(i);
			this.account += item.getProduct().getPrice() * item.getNumb();
		}

		return this.account;

	}
}
