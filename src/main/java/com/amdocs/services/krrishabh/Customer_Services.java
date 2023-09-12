package com.amdocs.services.krrishabh;



import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.amdocs.customer.dao.CustomerDAO;
import com.amdocs.customer.entitity.Customer;
import com.amdocs.dao.impl.Customer_DAO_Impl;
    public class Customer_Services {
	private static Scanner sc=new Scanner(System.in);
//	 private Customer_DAO_Impl customerdao = new Customer_DAO_Impl();
	public static void customerList()
    {
   	 while(true)
   	 {
   		 System.out.println("****Welcome to the Customer List****");
   		 System.out.println("Press 1 for registration");
   		 System.out.println("Press 2 for modifying  details");
   		 System.out.println("Press 3 to delete customer");
   		 System.out.println("Press 4 to view customer details");
   		 System.out.println("Press 5 to view all customer details");
   		 System.out.println("Press 0 to go back to main list");
   		 System.out.println("Enter your choice: ");
   		 int ch=sc.nextInt();
   		 switch(ch) {
   		     case(1):
   		    	 registerCustomer();	
   		     	 break;
   		     case(2):
   		    	 modifyCustomer();
   		     	 break;
   		     case(3):
   		    	 deleteCustomer();
   		     	 break;
   		     case(4):
   		    	  viewSingleCustomer();
   		         break;
   		     case(5):
   		    	 viewAllCustomers();
   		         break;
   		     case(0):
   		    	 return;
   		     default:
   		    	 System.out.println("Invalid input.Please enter a valid input");
   		          
   		 }
   		 
   	 }
   	 
    }


	public static void registerCustomer()
	 {
		Customer customer=new Customer();
		
		sc.nextLine();
		System.out.println("Enter customer name: ");
		String customer_name=sc.nextLine();
		customer.setName(customer_name);
		System.out.println("Enter customer e-mail id: ");
		String customer_email=sc.nextLine();
		customer.setEmail(customer_email);
		System.out.println("Enter customer phone: ");
		String customer_ph=sc.nextLine();
		customer.setPhone(customer_ph);
		System.out.println("Enter customer address: ");
		String customer_address=sc.nextLine();
		customer.setAddress(customer_address);
		Customer_DAO_Impl customerdao = new Customer_DAO_Impl();
		if(customerdao.add(customer)) {
			System.out.println("Registered Sucessfull!!!");
		}else {
			System.out.println("Unsuccessfull Registeration!!");
		}
			
	 }
    public static Customer getbyId() {
    	Customer customer =new Customer();
        System.out.println("Enter Customer Id:");
        int customerID =sc.nextInt();
        sc.nextLine();
        
      //call dao with customer id
      Customer_DAO_Impl dao=new Customer_DAO_Impl();
      
     try {
		customer = dao.getCustomerByID(customerID);
		return customer;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      //saVE object to customerData
	return customer;
      
    }
    public static void modifyCustomer() {
    	
    	 CustomerDAO customedao = new Customer_DAO_Impl();
    	 Customer customerData = new Customer();
    	 customerData = getbyId();
    	//while loop
    	while(true)
    	{
    		System.out.println("Select from the below option you want to update..?");
    		System.out.println("Press 1 to update name");
    		System.out.println("Press 2 to update email");
    		System.out.println("Press 3 to update phone");
    		System.out.println("Press 4 to update address");
    		System.out.println("Press 5 to save");
    		System.out.println("Press 0 to exit");
    		System.out.println("Enter your choice: ");
     		int ch=Integer.parseInt(sc.nextLine());
     	    
    		switch (ch) {
    		case 0 : customedao.modify(customerData);
    		         break;
    		case 1 : System.out.println("Enter name: ");
    				 String name=sc.nextLine();
    		         customerData.setName(name);
    		         break;
    		case 2 : System.out.println("Enter email: ");
    		         String email=sc.nextLine();
	                 customerData.setName(email);
    		         break;
    		case 3: System.out.println("Enter phone: ");
    		        String phone=sc.nextLine();
	                customerData.setName(phone);
    		        break;
    		case 4: System.out.println("Enter address: ");
    		        String address=sc.nextLine();
	                customerData.setName(address);
    				break;
    		default:
  		    	 System.out.println("Invalid input.Please enter a valid input");
  		    	 
    			   
    		}
    		if(ch==0) break;
    	}
    	
    	}
    public static void deleteCustomer() {
    	// TODO Auto-generated method stub
    	Customer_DAO_Impl customedao = new Customer_DAO_Impl();
   		System.out.println("Enter the customer id for deleting customer: ");
   		int id=sc.nextInt();
   		sc.nextLine();
   		customedao.delete(id);
   		    	
    }
    public static void viewSingleCustomer() {
    	// TODO Auto-generated method stub
    	Customer_DAO_Impl customedao = new Customer_DAO_Impl();
   		System.out.println("Enter the customer id to view customer details: ");
   		int id=sc.nextInt();
   		sc.nextLine();
   		customedao.singleView(id);
    	
    }
    private static void viewAllCustomers() {
    	// TODO Auto-generated method stub
    	 
    	
    	Customer_DAO_Impl customerdao = new Customer_DAO_Impl();
    	List<Customer> allCustomers = customerdao.viewAll();
    	System.out.println("Following list contains all the customers: ");
    	for(Customer customer :allCustomers)
    	{
    		if(customer!=null)
    		{
    			System.out.println(customer.toString());
    		}
    	}
    	
    }
   /* public static void viewAllCustomers() {
    	// TODO Auto-generated method stub
    	Customer_DAO_Impl customedao = new Customer_DAO_Impl();
   		System.out.println("Enter the customer id to view customer details: ");
   		int id=Integer.parseInt(sc.nextLine()); 
   		customedao.singleView(id);
    	
    }*/
}
