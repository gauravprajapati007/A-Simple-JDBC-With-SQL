package com.pro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Controller {
	public Connection getCon() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/baigan", "root", "root");
		return connection;

	}

	public int Insert(Product product) throws ClassNotFoundException, SQLException {
		Connection connection = getCon();

		PreparedStatement preparedStatement = connection.prepareStatement("insert into product values(?,?,?,?)");
		preparedStatement.setInt(1, product.getId());
		preparedStatement.setString(2, product.getName());
		preparedStatement.setString(3, product.getDescription());
		preparedStatement.setInt(4, product.getPrice());
		int count = preparedStatement.executeUpdate();
		return count;
	}

	public int update(int id, String name) throws ClassNotFoundException, SQLException {
		Connection connection = getCon();
		PreparedStatement preparedStatement = connection.prepareStatement("update product set name=? where id=?");
		preparedStatement.setString(1, name);
		preparedStatement.setInt(2, id);
		int count = preparedStatement.executeUpdate();
		return count;
	}
	
	public int deleteByID(int id) throws ClassNotFoundException, SQLException {
		Connection connection = getCon();
		PreparedStatement preparedStatement = connection.prepareStatement("delete from product where id=?");
		preparedStatement.setInt(1, id);
		int count = preparedStatement.executeUpdate();
		return count;
	}
	
	public Product fetchByID(int id) throws ClassNotFoundException, SQLException {
		Connection connection = getCon();
		PreparedStatement preparedStatement = connection.prepareStatement("select * from product where id=?");
		preparedStatement.setInt(1, id);
		ResultSet rs= preparedStatement.executeQuery();
		Product product=new Product();
		if(rs.next()) {
			product.setId(rs.getInt(1));
			product.setName(rs.getString(2));
			product.setDescription(rs.getString(3));
			product.setPrice(rs.getInt(4));
		}
		return product;
	}

}
