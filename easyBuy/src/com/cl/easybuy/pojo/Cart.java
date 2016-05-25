package com.cl.easybuy.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * ���ﳵ
 * 
 * @author hb
 * 
 * @date 2015��9��8�� ����10:40:36
 */
public class Cart {
	/**
	 * һ�����ﳵ���ж�����ﳵ��Ŀ
	 */
	private List<CartItem> items = new ArrayList<CartItem>();
	private double account;// �ܽ��

	/**
	 * ����һ����Ʒ
	 * 
	 * ����Ʒ��Ϊһ�����ﳵ����Ŀ׷�ӵ����ﳵ��
	 * 
	 * @param pro
	 * @return �����Ʒ���ڷ���false,���������,��ӷ���true
	 */
	public boolean buy(Product pro) {
		for (int i = 0; i < items.size(); i++) {
			CartItem item = items.get(i);
			// �ж���Ŀ���Ƿ��Ѿ���������Ʒ
			if (pro.getId() == item.getProduct().getId()) {
				return false;
			}

		}
		// ����һ����Ŀ׷�ӵ�������
		CartItem item = new CartItem();
		item.setProduct(pro);
		item.setNumb(1);
		items.add(item);
		return true;
	}

	/**
	 * �޸Ĺ��ﳵ�е�����
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
	 * ɾ�����ﳵ�е���Ʒ
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
	 * ��չ��ﳵ�е���Ʒ
	 */
	public void clear() {
		items.clear();
	}

	public List<CartItem> getItems() {
		return items;
	}

	/**
	 * �����ܽ��
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
