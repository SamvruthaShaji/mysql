package com.ilp04.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.ilp04.dao.CustomerDAO;
import com.ilp04.entity.Customer;

public class CustomerServiceImpl implements CustomerService {

	@Override
	public ArrayList<Customer> getAllCustomers() {
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		CustomerDAO customerDAO  = new CustomerDAO();
		Connection connection = customerDAO.getConnection();
		customerList = customerDAO.getAllCustomers(connection);
		return customerList;
	}

	@Override
	public int insertIntoCustomer(Customer customer) {
		  CustomerDAO customerDAO = new CustomerDAO();
	        Connection connection = customerDAO.getConnection();
	        int rowsAffected = customerDAO.insertCustomer(connection, customer);
	        customerDAO.closeConnection(connection);
	        return rowsAffected;
	}

	@Override
	public int updateCustomer(Customer customer) {
	
		        CustomerDAO customerDAO = new CustomerDAO();
		        Connection connection = customerDAO.getConnection();
		        int rowsAffected = customerDAO.updateCustomer(connection, customer);
		        customerDAO.closeConnection(connection);
		        return rowsAffected;
	}

}
