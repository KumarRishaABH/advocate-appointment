package com.amdocs.services.krrishabh;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.amdocs.customer.dao.CustomerDAO;
import com.amdocs.customer.entitity.Appointment;
import com.amdocs.customer.entitity.Customer;
import com.amdocs.dao.impl.Appointment_DAO_Impl;
import com.amdocs.dao.impl.Customer_DAO_Impl;

public class Appointment_Services {
	private static Scanner sc = new Scanner(System.in);
	
	public static void appointmentList()
	{
		 while(true)
	   	 {
	   		 System.out.println("****Welcome to the Appointment List****");
	   		 System.out.println("Press 1 for book an appointment");
	   		 System.out.println("Press 2 to modify appointment");
	   		 System.out.println("Press 3 to delete appointment");
	   		 System.out.println("Press 4 to view an appointment");
	   		 System.out.println("Press 5 to view all customer details");
	   		 System.out.println("Press 0 to go back to main list");
	   		 System.out.println("Enter your choice: ");
	   		 int ch=sc.nextInt();
	   		 switch(ch) {
	   		     case(1):
	   		    	 bookAppointment();	
	   		     	 break;
	   		     case(2):
	   		    	 modifyAppointment();
	   		     	 break;
	   		     case(3):
	   		    	deleteAppointment();
	   		     	 break;
	   		     case(4):
	   		    	viewSingleAppointment();
	   		         break;
	   		     case(5):
	   		    	viewAllAppointment();
	   		         break;
	   		     case(0):
	   		    	 return;
	   		     default:
	   		    	 System.out.println("Invalid input.Please enter a valid input");
	   		          
	   		 }
	   		 
	   	 }
	}
	
	public static void bookAppointment()
	{
		Appointment appointment=new Appointment();
		sc.nextLine();
		System.out.println("Enter customer id: ");
		int c_id=Integer.parseInt(sc.nextLine());
		appointment.setCustomer_id(c_id);
		System.out.println("Enter advocate id: ");
		int a_id=Integer.parseInt(sc.nextLine());
		appointment.setAdvocate_id(a_id);
		Appointment_DAO_Impl appointmentDao = new Appointment_DAO_Impl();
		if(appointmentDao.add(appointment)) {
			System.out.println("Appointment booked successfully!!!");
		}else {
			System.out.println("Booking Unsuccessful!!");
		}
	}
	public static Appointment getbyId() {
    	Appointment appointment =new Appointment();
        System.out.println("Enter Appointment Id:");
        int appointmentID =sc.nextInt();
        sc.nextLine();
        
      //call dao with customer id
      Appointment_DAO_Impl dao=new Appointment_DAO_Impl();
      
     try {
		appointment = dao.getAppointmentByID(appointmentID);
		return appointment;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      //saVE object to customerData
	return appointment;
      
    }
    public static void modifyAppointment() {
    	
    	 Appointment_DAO_Impl dao = new Appointment_DAO_Impl();
    	 Appointment appointmentData = new Appointment();
    	 appointmentData = getbyId();
    	//while loop
    	while(true)
    	{
    		System.out.println("Press 1 to change advocate: ");
    		System.out.println("Press 2 for exit");
    		int ch=sc.nextInt();
    		sc.nextLine();
    		
    		switch (ch) {
			case 1:
				 System.out.println("Enter advocate id: ");
				 int id=Integer.parseInt(sc.nextLine());
//				 sc.nextLine();
		         appointmentData.setAdvocate_id(id);
		         dao.modify(appointmentData);
		         break;

			case 2:
				return;
			}
    	
    	}
    

    }
    public static void deleteAppointment() {
		// TODO Auto-generated method stub
    	Appointment_DAO_Impl dao = new Appointment_DAO_Impl();
   		System.out.println("Enter the appointment id for deleting appointment: ");
   		int id=sc.nextInt();
   		sc.nextLine();
   		dao.delete(id);
	}
    public static void viewSingleAppointment() {
		// TODO Auto-generated method stub
    	Appointment_DAO_Impl dao = new Appointment_DAO_Impl();
   		System.out.println("Enter the customer id to view customer details: ");
   		int id=sc.nextInt();
   		sc.nextLine();
   		dao.singleView(id);
	}
    public static void viewAllAppointment() {
		// TODO Auto-generated method stub
    	Appointment_DAO_Impl dao = new Appointment_DAO_Impl();
    	List<Appointment> allAppointments = dao.viewAll();
    	System.out.println("Following list contains all the customers: ");
    	for(Appointment appointment :allAppointments)
    	{
    		if(appointment!=null)
    		{
    			System.out.println(appointment.toString());
    		}
    	}
	}
}
