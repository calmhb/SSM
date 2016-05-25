package com.cl.easybuy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.cl.easybuy.dao.OrderItemDao;
import com.cl.easybuy.pojo.OrderItem;
import com.cl.easybuy.util.ConnectionUtils;

/**
 * 实现订单条目
 * 
 * @author hb
 * 
 * @date 2015年9月7日 下午4:26:06
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
			// 使用批处理
			pstm = conn.prepareStatement(sql);
			for (int i = 0; i < items.size(); i++) {
				OrderItem item = items.get(i);
				pstm.setInt(1, item.getNumb());
				pstm.setDouble(2, item.getAccount());
				pstm.setInt(3, item.getPid());
				pstm.setInt(4, item.getOid());
				pstm.addBatch();// 添加到批处理中
				if (i % 100 == 0) {
					pstm.executeBatch();// 执行批处理
					pstm.clearBatch();// 清空批处理
				}
			}
			pstm.executeBatch();// 执行剩余的数据
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			ConnectionUtils.close(conn, pstm, rs);
		}

	}

}
