package com.amdocs.customer.dao;
import java.sql.SQLException;
import java.util.List;

import com.amdocs.customer.entitity.Appointment;
import com.amdocs.customer.entitity.Customer;


public interface AppointmentDAO {

	boolean add(Appointment appointment);
	public void modify(Appointment appointment);
	Appointment getAppointmentByID(int id) throws SQLException;
	public void delete(int appointmentID);
	public void singleView(int appointmentID);
	public List<Appointment> viewAll();
}
