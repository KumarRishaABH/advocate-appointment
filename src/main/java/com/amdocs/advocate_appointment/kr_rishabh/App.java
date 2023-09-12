package com.amdocs.advocate_appointment.kr_rishabh;
import java.util.Scanner;

import com.amdocs.services.krrishabh.Appointment_Services;
import com.amdocs.services.krrishabh.Customer_Services;

/**
 * Hello world!
 *
 */
public class App 
{
	private static Scanner sc=new Scanner(System.in);
	  
    public static void main( String[] args )
    {
    	
    	try {
    	   while(true) {
    		System.out.println(".........................");
    		System.out.println("--Welcome to Online Advocate Appointment System--");
    		System.out.println("..........................");
    		System.out.println("Press 1 for Customer List");
    		System.out.println("Press 2 for Adovate List");
    		System.out.println("Press 3 for Appointment List");
    		System.out.println("Press 4 for Service List");
    		System.out.println("Press 5 to Exit");
    		System.out.println("Enter your choice: ");
    		int ch= Integer.parseInt(sc.nextLine());
    		switch(ch) {
    			case(1):
    				Customer_Services.customerList();
    			    break;
    			case(2):
    				Appointment_Services.appointmentList();
    			    break;
    			case(3):
    				//appointmentList();
    				break;
    			case(4):
    				//serviceList()
    				break;
    			case(5):
    				System.out.println("Thankyou!.....Exiting....");
    			    System.exit(0);
    			default:
    				System.out.println("Invalid input. Please enter a valid input.");
    		}
    	 }
        
     }
    	catch (NumberFormatException e) {
			System.out.println("Number Format : " + e.getMessage());
		} catch (Exception e) {

			System.out.println("Error : " + e.getMessage());
		}
    	
  }
    
     
    
}
