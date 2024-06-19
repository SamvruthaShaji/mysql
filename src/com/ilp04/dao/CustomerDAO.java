package com.ilp04.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ilp04.entity.Customer;

public class CustomerDAO {
//get connection
	public Connection getConnection()
	{
		String connectionURL ="jdbc:mysql://localhost:3306/bank_db?useSSL=false";
		String userName ="root";
		String password ="experion@123";
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(connectionURL, userName,password);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return connection;
	}
	//close connection
	public Connection closeConnection(Connection connection) {
		try {
			connection.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return connection;
	}
	public ArrayList<Customer> getAllCustomers(Connection connection){
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		Statement statement;
		ResultSet resultSet;
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from customer");
			while(resultSet.next()) {
				int customerCode = resultSet.getInt(1);
				String customerFirstname =resultSet.getString(2);
				String customerLastname =resultSet.getString(3);
				String address =resultSet.getString(4);
				Long phoneNo =resultSet.getLong(5);
				Long aadhar =resultSet.getLong(6);
				Customer customer = new Customer(customerCode,customerFirstname,customerLastname,address,phoneNo,aadhar);
				customerList.add(customer);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return customerList;
	}
	 public int insertCustomer(Connection connection, Customer customer) {
	        int rowsAffected = 0;
	        PreparedStatement preparedStatement = null;
	        try {
	            preparedStatement = connection.prepareStatement("insert into customer values (?, ?, ?, ?, ?, ?)");
	            preparedStatement.setInt(1, customer.getCustomerCode());
	            preparedStatement.setString(2, customer.getCustomerFirstame());
	            preparedStatement.setString(3, customer.getCustomerLastname());
	            preparedStatement.setString(4, customer.getAddress());
	            preparedStatement.setLong(5, customer.getPhoneNo());
	            preparedStatement.setLong(6, customer.getAadhar());

	            rowsAffected = preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                if (preparedStatement != null) {
	                    preparedStatement.close();
	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        return rowsAffected;
	    }
	 public int updateCustomer(Connection connection, Customer customer) {
	        int rowsAffected = 0;
	        PreparedStatement preparedStatement = null;
	        try {
	            // Update statement without modifying customerCode
	            preparedStatement = connection.prepareStatement(
	                    "UPDATE customer SET customer_firstname=?, customer_name=?, address=?, phone_number=?, aadhar_no=? WHERE customer_code=?");
	            preparedStatement.setString(1, customer.getCustomerFirstame());
	            preparedStatement.setString(2, customer.getCustomerLastname());
	            preparedStatement.setString(3, customer.getAddress());
	            preparedStatement.setLong(4, customer.getPhoneNo());
	            preparedStatement.setLong(5, customer.getAadhar());
	            preparedStatement.setInt(6, customer.getCustomerCode());

	            rowsAffected = preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                if (preparedStatement != null) {
	                    preparedStatement.close();
	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        return rowsAffected;
	    }

}
