package com.product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.product.configuration.HelperClass;
import com.product.dto.Customer;
import com.product.dto.Product;

public class CustomerDao {
	HelperClass helperClass = new HelperClass();
	Connection connection = null;
	int i = 0;

	// insert
	public Customer saveCustomer(Customer customer) {
		connection = helperClass.getConnection();
		String sql = "INSERT INTO customer VALUES (?,?,?)";

		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setInt(1, customer.getId());
			prepareStatement.setString(2, customer.getName());
			prepareStatement.setString(3, customer.getEmail());

			prepareStatement.execute();

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
		return customer;
	}

	// get all data
	public void getAllCustomer() {
		connection = helperClass.getConnection();
		String sql = "SELECT *from customer";
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

	// update data
	public boolean updateCustomerById(int id) {
		connection = helperClass.getConnection();
		String sql = "UPDATE customer SET name='mno' WHERE ID=?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			i = preparedStatement.executeUpdate();
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
		if (id > 0) {
			return true;
		} else {
			return false;
		}
	}

	// to delete record
	public boolean deleteCustomerById(int id) {
		connection = helperClass.getConnection();
		String sql = "DELETE FROM customer WHERE id = ?";
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

	// get data using id

	public Customer selectCustomerById(Customer customer) {
		connection = helperClass.getConnection();
		String sql = "SELECT * FROM customer WHERE id=?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, customer.getId());
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
		return customer;
	}
}
