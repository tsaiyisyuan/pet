package com.tw.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.tw.vo.PetBean;
import javax.naming.*;

@Service
public class PetDao implements PetInterface {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private Connection conn;

	@Override
	public List<PetBean> queryAll() {
		String qryStmt = "SELECT * FROM Pet_Products";
		List<com.tw.vo.PetBean> pbs = new ArrayList<>();
		try {
			PreparedStatement stmt = conn.prepareStatement(qryStmt);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				com.tw.vo.PetBean pb = new com.tw.vo.PetBean();
				pb.setProductId(rs.getInt("productId"));
				pb.setProductName(rs.getString("productName"));
				pb.setQuantity(rs.getInt("quantity"));
				pb.setCost(rs.getInt("cost"));
				pb.setPrice(rs.getInt("price"));
				pbs.add(pb);
			}
		} catch (Exception e) {
			logger.error("", e);
		}
		return pbs;
	}

	@Override
	public void queryDB(PetBean PB) throws SQLException {
		String qryStmt = "select * from Pet_Products where productId=?";
		PreparedStatement stmt = conn.prepareStatement(qryStmt);
		stmt.setInt(1, PB.getProductId());
		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
			PB.setProductId(rs.getInt("productId"));
			PB.setProductName(rs.getString("productName"));
			PB.setQuantity(rs.getInt("quantity"));
			PB.setCost(rs.getInt("cost"));
			PB.setPrice(rs.getInt("price"));
		}
		stmt.close();
	}

	public List<PetBean> queryAllName(String productName) {
		String qryStmt = "select * from Pet_Products where productName LIKE ?";
		List<com.tw.vo.PetBean> pbs = new ArrayList<>();
		try {
			PreparedStatement stmt = conn.prepareStatement(qryStmt);
			stmt.setString(1, "%" + productName + "%");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				com.tw.vo.PetBean pb = new com.tw.vo.PetBean();
				pb.setProductId(rs.getInt("productId"));
				pb.setProductName(rs.getString("productName"));
				pb.setQuantity(rs.getInt("quantity"));
				pb.setCost(rs.getInt("cost"));
				pb.setPrice(rs.getInt("price"));
				pbs.add(pb);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return pbs;
	}

	public void queryDBId(PetBean PB) throws SQLException {
		String qryStmt = "select * from Pet_Products where productId=?";
		PreparedStatement stmt = conn.prepareStatement(qryStmt);
		stmt.setInt(1, PB.getProductId());
		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
			PB.setProductId(rs.getInt("productId"));
			PB.setProductName(rs.getString("productName"));
			PB.setQuantity(rs.getInt("quantity"));
			PB.setCost(rs.getInt("cost"));
			PB.setPrice(rs.getInt("price"));
		}
		stmt.close();
	}

	@Override
	public void insert(PetBean PB)  {
		try {
			conn.setAutoCommit(false);
			String insertStmt = "insert into Pet_Products (productName,quantity,cost,price) values(?,?,?,?)";
			PreparedStatement stmt = conn.prepareStatement(insertStmt);
			stmt.setString(1, PB.getProductName());
			stmt.setInt(2, PB.getQuantity());
			stmt.setInt(3, PB.getCost());
			stmt.setInt(4, PB.getPrice());
			stmt.execute();
			stmt.close();
			conn.commit();
		} catch (SQLException e) {
			if(conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}

			e.printStackTrace();
		}
		
		
	}

	@Override
	public void update(PetBean PB) throws SQLException {
		String qryStmt = "update Pet_Products set productName=?,quantity=?,cost=?,price=? where productId=?";
		PreparedStatement stmt = conn.prepareStatement(qryStmt);
		stmt.setString(1, PB.getProductName());
		stmt.setInt(2, PB.getQuantity());
		stmt.setInt(3, PB.getCost());
		stmt.setInt(4, PB.getPrice());
		stmt.setInt(5, PB.getProductId());
		stmt.execute();
		stmt.close();
	}

	@Override
	public void delete(int productId) throws SQLException {
		String qryStmt = "delete from Pet_Products where productId =?";
		PreparedStatement stmt = conn.prepareStatement(qryStmt);
		stmt.setInt(1, productId);
		stmt.execute();
		stmt.close();
	}

	@Override
	public void createConn() {
//		try {
//			Context context = new InitialContext();
//			 DataSource ds = (DataSource)context.lookup("java:/comp/env/jdbc/Pet");
//			conn=ds.getConnection();
//			
//		}catch(Exception e){
//			System.out.println(e);
//		}
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String connUrl = "jdbc:sqlserver://localhost:1433;databaseName=Pet";
			conn = DriverManager.getConnection(connUrl, "sa", "P@ssw0rd");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void closeConn() throws SQLException {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
