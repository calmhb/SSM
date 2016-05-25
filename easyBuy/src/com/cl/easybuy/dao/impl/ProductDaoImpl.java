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
 * 商品表的实现
 * 
 * @author hb
 * 
 * @date 2015年9月7日 下午3:49:30
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
			 * 必须使用while,结果集中有多条记录
			 */
			while (rs.next()) {
				Product p = new Product();
				p.setId(rs.getInt("id"));
				p.setPname(rs.getString("pname"));
				p.setPic(rs.getString("pic"));
				p.setPrice(rs.getDouble("price"));
				p.setNumb(rs.getInt("numb"));
				p.setInfo(rs.getString("info"));
				// 将商品追加到集合当中
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

			// 绑定数据
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			/**
			 * 根据主键获得数据只会有一条记录
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
