package com.cl.easybuy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.cl.easybuy.dao.OrderDao;
import com.cl.easybuy.pojo.Order;
import com.cl.easybuy.util.ConnectionUtils;

/**
 * ������ʵ��
 * 
 * @author hb
 * 
 * @date 2015��9��7�� ����4:18:47
 */
public class OrderDaoImpl implements OrderDao {

	@Override
	public int addOrder(Order order) {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		int oid = -1;
		try {
			conn = ConnectionUtils.getConnection();
			// ��װSQL���
			final String sql = "insert into cl_order(id,account,total,u_id) values(cl_order_seq.nextval,?,?,?)";
			// ͨ���ַ���������ȷ�����ֶ�
			pstm = conn.prepareStatement(sql, new String[] { "id" });
			pstm.setDouble(1, order.getAccount());
			pstm.setInt(2, order.getTotal());
			pstm.setInt(3, order.getUid());

			pstm.executeUpdate();// ִ��SQL���
			rs = pstm.getGeneratedKeys();
			if (rs.next()) {
				oid = rs.getInt(1);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			ConnectionUtils.close(conn, pstm, rs);
		}
		return oid;
	}

}
