package com.cl.easybuy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.cl.easybuy.dao.OrderItemDao;
import com.cl.easybuy.pojo.OrderItem;
import com.cl.easybuy.util.ConnectionUtils;

/**
 * ʵ�ֶ�����Ŀ
 * 
 * @author hb
 * 
 * @date 2015��9��7�� ����4:26:06
 */
public class OrderItemDaoImpl implements OrderItemDao {

	@Override
	public void addItems(List<OrderItem> items) {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			conn = ConnectionUtils.getConnection();
			final String sql = "insert into cl_order_item(id,numb,account,p_id,o_id) values(cl_order_item_seq.nextval,?,?,?,?)";
			// ʹ��������
			pstm = conn.prepareStatement(sql);
			for (int i = 0; i < items.size(); i++) {
				OrderItem item = items.get(i);
				pstm.setInt(1, item.getNumb());
				pstm.setDouble(2, item.getAccount());
				pstm.setInt(3, item.getPid());
				pstm.setInt(4, item.getOid());
				pstm.addBatch();// ��ӵ���������
				if (i % 100 == 0) {
					pstm.executeBatch();// ִ��������
					pstm.clearBatch();// ���������
				}
			}
			pstm.executeBatch();// ִ��ʣ�������
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			ConnectionUtils.close(conn, pstm, rs);
		}

	}

}
