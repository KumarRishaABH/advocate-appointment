package com.amdocs.customer.entitity;

public class Appointment {
//appointment id, customer id , advocate id
	private int appointment_id;
	private int customer_id;
	private int advocate_id;
	public int getAppointment_id() {
		return appointment_id;
	}
	public void setAppointment_id(int appointment_id) {
		this.appointment_id = appointment_id;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public int getAdvocate_id() {
		return advocate_id;
	}
	public void setAdvocate_id(int advocate_id) {
		this.advocate_id = advocate_id;
	}
	@Override
	public String toString() {
		return "Appointment [appointment_id=" + appointment_id + ", customer_id=" + customer_id + ", advocate_id="
				+ advocate_id + "]";
	}

	
}
