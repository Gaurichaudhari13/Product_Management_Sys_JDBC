package com.product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.product.configuration.HelperClass;
import com.product.dto.Product;

public class ProductDao {

	HelperClass helperClass = new HelperClass();
	Connection connection = null;
	int i = 0;

	// insert product

	public Product saveProduct(Product product) {
		connection = helperClass.getConnection();
		String sql = "INSERT INTO product VALUES(?,?,?)";

		// create statement
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setInt(1, product.getId());
			prepareStatement.setString(2, product.getName());
			prepareStatement.setString(3, product.getcompany());

			// execute

			prepareStatement.execute();

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return product;
	}

	// update
	public boolean UpdateProductById(int id, String name, String company) {
		connection = helperClass.getConnection();
		String sql = "UPDATE product SET name=?,company=? WHERE ID=?";

		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setString(1, name);
			prepareStatement.setString(2, company);
			prepareStatement.setInt(3, id);

			i = prepareStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (i > 0) {
			return true;

		} else {
			return false;
		}

	}

	// to delete record
	public boolean deleteProductById(int id) {
		connection = helperClass.getConnection();
		String sql = "DELETE FROM product WHERE id = ?";
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setInt(1, id);
			i = prepareStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally // if we get any error /exception in prepare then we need to close the connetion
					// thats why we use finally block
					// if we
		{
			try {
				// close connection
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (i > 0) {
			return true;
		} else {
			return false;
		}
	}

	// getAll
	public void getAllProduct() {
		connection = helperClass.getConnection();
		String sql = "SELECT *from product";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery(sql);
			while (resultSet.next()) {
				System.out.println(resultSet.getInt(1));
				System.out.println(resultSet.getString(2));
				System.out.println(resultSet.getString(3));
				System.out.println("==================");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	// get data using id

	public Product selectProductById(Product product) {
		connection = helperClass.getConnection();
		String sql = "SELECT * FROM product WHERE id=?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, product.getId());
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				System.out.println(resultSet.getInt(1));
				System.out.println(resultSet.getString(2));
				System.out.println(resultSet.getString(3));
				System.out.println("==================");

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return product;
	}
}