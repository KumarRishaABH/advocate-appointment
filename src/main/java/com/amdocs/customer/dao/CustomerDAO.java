package com.amdocs.customer.dao;
//import java.sql.SQLException;

import java.sql.SQLException;
import java.util.List;

import com.amdocs.customer.entitity.Customer;

public interface CustomerDAO {
	boolean add(Customer customer);
	public void modify(Customer customer);
	Customer getCustomerByID(int id) throws SQLException;
	public void delete(int customerID);
	public void singleView(int customerID);
	public List<Customer> viewAll();

}
