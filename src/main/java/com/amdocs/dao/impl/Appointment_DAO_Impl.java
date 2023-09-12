package com.amdocs.dao.impl;

import com.amdocs.customer.entitity.Appointment;
import com.amdocs.customer.entitity.Customer;
import com.amdocs.customer.dao.AppointmentDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.amdocs.database.util.DBUtil;
public class Appointment_DAO_Impl implements AppointmentDAO {
	
	private static final String INSERT_APPOINTMENT = "insert into appointment(advocate_id,customer_id) values(?,?)";
	private static final String FIND_APPOINTMENT ="select appointment.* , customer.name as customerName , advocate.name as advocateName  from appointment INNER JOIN customer on appointment.customer_id =customer.customer_id INNER JOIN advocate on appointment.advocate_id = advocate.advocate_id where appointment_id=?";
	private static final String UPDATE_APPOINTMENT="update appointment set advocate_id=? where appointment_id=?";
	private static final String DELETE_APPOINTMENT="delete from appointment where appointment_id = ?";
	private static final String SELECT_ALL = "select appointment.* , customer.name as customerName , advocate.name as advocateName  from appointment INNER JOIN customer on appointment.customer_id =customer.customer_id INNER JOIN advocate on appointment.advocate_id = advocate.advocate_id";
	private  Connection connection=DBUtil.getConnection();
	
	public boolean add(Appointment appointment) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps= connection.prepareStatement(INSERT_APPOINTMENT);
			// set the value
			ps.setInt(1, appointment.getAdvocate_id());
			ps.setInt(2, appointment.getCustomer_id());
			
			//Execute Statement
			int executeUpdate = ps.executeUpdate();
			ps.close();
			if(executeUpdate>0)
			{
				System.out.println("Registraion Successful");
				return true;
				
			}
			 return false;
		}
			catch(SQLException e) {
			e.printStackTrace();
			}
		return false;
	

   }
	public Appointment getAppointmentByID(int id) throws SQLException {
		// TODO Auto-generated method stub
		Appointment appointment = new Appointment();
		PreparedStatement ps=connection.prepareStatement(FIND_APPOINTMENT);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		rs.next();
		appointment.setAppointment_id(rs.getInt("appointment_id"));
		appointment.setCustomer_id(rs.getInt("customer_id"));
		appointment.setAdvocate_id(rs.getInt("advocate_id"));
		
		rs.close();
		ps.close();
		System.out.println(appointment);
		return appointment;
	}
	public void modify(Appointment appointmentData) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps=connection.prepareStatement(UPDATE_APPOINTMENT);
			// Set The value
			ps.setInt(1, appointmentData.getAdvocate_id());
			ps.setInt(2, appointmentData.getAppointment_id());
//			System.out.println(customer);
			//Execute Statement
			int executeUpdate = ps.executeUpdate();
			ps.close();
			if(executeUpdate>0) {
			
			//	System.out.println(appointmentData);
				System.out.println("Details of the advocate updated successfully");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void delete(int id) {
		// TODO Auto-generated method stub
		try {
		PreparedStatement ps=connection.prepareStatement(DELETE_APPOINTMENT);
		// Set The value
		
//		System.out.println(customer);
		//Execute Statement
		ps.setInt(1, id);
		int executeUpdate = ps.executeUpdate();
		
		ps.close();
		if(executeUpdate>0) {
		
			System.out.println("Appointment Details deleted successfully");
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	}
	public void singleView(int id) {
		// TODO Auto-generated method stub
		try {
			Appointment appointment = new Appointment();
			PreparedStatement ps=connection.prepareStatement(FIND_APPOINTMENT);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			appointment.setAppointment_id(rs.getInt("appointment_id"));
			appointment.setAdvocate_id(rs.getInt("advocate_id"));
			appointment.setCustomer_id(rs.getInt("customer_id"));
			
			
			rs.close();
			ps.close();
			System.out.println("Following are the details of the appointment: ");
			System.out.println(appointment);
			
			}
			
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public List<Appointment> viewAll() {
		// TODO Auto-generated method stub
		List <Appointment> allAppointment=new ArrayList<Appointment>();
		
		try {
			PreparedStatement ps=connection.prepareStatement(SELECT_ALL);

			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Appointment appointment = new Appointment();
				
		    appointment.setAppointment_id(rs.getInt("appointment_id"));
			appointment.setAdvocate_id(rs.getInt("advocate_id"));
			appointment.setCustomer_id(rs.getInt("customer_id"));
			
			allAppointment.add(appointment);
			}
			rs.close();
			ps.close();
			
			}
			
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return allAppointment;
		
	}
}
