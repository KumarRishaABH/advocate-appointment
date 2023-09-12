package com.amdocs.dao.impl;

import java.lang.foreign.ValueLayout.OfAddress;
import java.security.PublicKey;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
//import java.util.List;
import java.util.List;

import com.amdocs.customer.dao.CustomerDAO;
import com.amdocs.customer.entitity.Customer;
import com.amdocs.database.util.DBUtil;
import com.mysql.cj.x.protobuf.MysqlxSession.AuthenticateContinue;



public class Customer_DAO_Impl implements CustomerDAO{
	
	/**
	 * Will Communicate to data base
	 */

		
		private static final String INSERT_CUSTOMER="insert into  customer(name, email, phone, address) values(?,?,?,?)";
        private static final String UPDATE_CUSTOMER="update customer set name=?, email=? ,phone=?,  address=? where customer_id=?";
        private static final String FIND_CUSTOMER="select * from customer where customer_id=?";
        private static final String DELETE_CUSTOMER="delete from customer where customer_id=?";
        private static final String SELECT_ALL="select * from customer";
        private  Connection connection=DBUtil.getConnection();
		
		public boolean add(Customer customer)   {
		
			try {
				PreparedStatement ps=connection.prepareStatement(INSERT_CUSTOMER);
				// Set The value
				ps.setString(1, customer.getName());
				ps.setString(2, customer.getEmail());
				ps.setString(3, customer.getPhone());
				ps.setString(4, customer.getAddress());
//				System.out.println(customer);
				//Execute Statement
				int executeUpdate = ps.executeUpdate();
				ps.close();
				if(executeUpdate>0) {
				
					return true;
				}
				return false;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
        public void modify(Customer customer) {
		try {
			PreparedStatement ps=connection.prepareStatement(UPDATE_CUSTOMER);
			// Set The value
			ps.setString(1, customer.getName());
			ps.setString(2, customer.getEmail());
			ps.setString(3, customer.getPhone());
			ps.setString(4, customer.getAddress());
			ps.setInt(5, customer.getCustomer_id());
//			System.out.println(customer);
			//Execute Statement
			int executeUpdate = ps.executeUpdate();
			ps.close();
			if(executeUpdate>0) {
			
				System.out.println(customer);
				System.out.println("Details of the customer updated successfully");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		public Customer getCustomerByID(int id) throws SQLException {
			// TODO Auto-generated method stub
			Customer customer = new Customer();
			PreparedStatement ps=connection.prepareStatement(FIND_CUSTOMER);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			customer.setCustomer_id(rs.getInt("customer_id"));
			customer.setEmail(rs.getString("email"));
			customer.setPhone(rs.getString("phone"));
			customer.setAddress(rs.getString("address"));
			rs.close();
			ps.close();
			System.out.println(customer);
			return customer;
		}
		public void delete(int  customerID) {
			try {
				PreparedStatement ps=connection.prepareStatement(DELETE_CUSTOMER);
				// Set The value
				
//				System.out.println(customer);
				//Execute Statement
				ps.setInt(1, customerID);
				int executeUpdate = ps.executeUpdate();
				
				ps.close();
				if(executeUpdate>0) {
				
					System.out.println("Customer Details deleted successfully");
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			
		}
		public void singleView(int id) {
			// TODO Auto-generated method stub
			try {
				Customer customer = new Customer();
				PreparedStatement ps=connection.prepareStatement(FIND_CUSTOMER);
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();
				rs.next();
				customer.setCustomer_id(rs.getInt("customer_id"));
				customer.setEmail(rs.getString("email"));
				customer.setPhone(rs.getString("phone"));
				customer.setAddress(rs.getString("address"));
				rs.close();
				ps.close();
				System.out.println("Following are the details of the customer: ");
				System.out.println(customer);
				
				}
				
			 catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		}
		public List<Customer> viewAll() {
			// TODO Auto-generated method stub
			List <Customer> allCustomers=new ArrayList<Customer>();
			
			try {
				PreparedStatement ps=connection.prepareStatement(SELECT_ALL);

				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					Customer customer = new Customer();

				customer.setCustomer_id(rs.getInt("customer_id"));
				customer.setEmail(rs.getString("email"));
				customer.setPhone(rs.getString("phone"));
				customer.setAddress(rs.getString("address"));
				allCustomers.add(customer);
				}
				rs.close();
				ps.close();
				
				}
				
			 catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return allCustomers;
		}
		
}

		

		

//		@Override
//		public boolean add(Customer customer) {
//			// TODO Auto-generated method stub
//			return false;
//		}

		

	

