package com.cl.easybuy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cl.easybuy.dao.ProductDao;
import com.cl.easybuy.pojo.Product;
import com.cl.easybuy.util.ConnectionUtils;

/**
 * ��Ʒ���ʵ��
 * 
 * @author hb
 * 
 * @date 2015��9��7�� ����3:49:30
 */
public class ProductDaoImpl implements ProductDao {

	@Override
	public List<Product> findAll() {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<Product> pros = new ArrayList<Product>();
		try {
			conn = ConnectionUtils.getConnection();
			final String sql = "select id,pname,price,pic,numb,info from cl_product";
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			/**
			 * ����ʹ��while,��������ж�����¼
			 */
			while (rs.next()) {
				Product p = new Product();
				p.setId(rs.getInt("id"));
				p.setPname(rs.getString("pname"));
				p.setPic(rs.getString("pic"));
				p.setPrice(rs.getDouble("price"));
				p.setNumb(rs.getInt("numb"));
				p.setInfo(rs.getString("info"));
				// ����Ʒ׷�ӵ����ϵ���
				pros.add(p);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			ConnectionUtils.close(conn, pstm, rs);
		}
		return pros;
	}

	@Override
	public Product findProductById(int id) {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Product p = null;
		try {
			conn = ConnectionUtils.getConnection();
			final String sql = "select id,pname,price,pic,numb,info from cl_product where id=?";
			pstm = conn.prepareStatement(sql);

			// ������
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			/**
			 * ���������������ֻ����һ����¼
			 */
			if (rs.next()) {
				p = new Product();
				p.setId(rs.getInt("id"));
				p.setPname(rs.getString("pname"));
				p.setPic(rs.getString("pic"));
				p.setPrice(rs.getDouble("price"));
				p.setNumb(rs.getInt("numb"));
				p.setInfo(rs.getString("info"));
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			ConnectionUtils.close(conn, pstm, rs);
		}
		return p;

	}

}
