package com.bankapp.model;

import java.util.Scanner;

import com.bankapp.services.*;


public class UserLogin {

    Scanner scan = new Scanner(System.in);
    
    FacilityService obj = new FacilityService();
    
    static String confirm;
    
    static double amount;
    
    static boolean val;
    
    
    
    // Validate User
    
   
	public void login(UserAccount customer , UserAccount defaultCustomer) {
		
			System.out.println("Successfull Login!");
			System.out.println("Here is the list of services provided \n"
					+ "1. Check your Balance \n"
					+ "2. Make a deposit \n"
					+ "3. Withdraw amount \n"
					+ "4. Transfer amount to an default user");
			System.out.print("Enter your choice: ");
			
			int option = scan.nextInt();
			
			
			switch(option) {
			
			case 1: System.out.println("You have selected option 1: Check your Balance. \n");
			        	
			        	obj.checkBalance(customer);
			      
			        break;
			        
			case 2: System.out.println("You have selected option 2: Make a deposit. \n");
	                	
	                	System.out.print("Enter the amount you would like to deposit: ");
	                	amount = scan.nextDouble();
	        	
	        	        val = obj.deposit(customer, amount);
	        	        if(val) {
	        	        	System.out.println("You have successfully deposited Rs."+amount);
	        	        	System.out.println("Your updated balance is Rs"+customer.getBalance());
	        	        }
	        	
	                
	                break;
	                
			case 3: System.out.println("You have selected option 3: Withdraw amount. \n");
            	
            	        System.out.print("Enter the amount you would like to withdraw: ");
            	        amount = scan.nextDouble();
    	
    	                val = obj.withdraw(customer, amount);
    	                
    	                if(val) {
    	                	System.out.println("You have successfully withdrawn Rs."+amount);
    	                	System.out.println("Your updated balance is Rs."+customer.getBalance());
    	                }
    	
                    break;
                    
			case 4:System.out.println("You have selected option 4: Transfer amount to default user. \n");
                	   
            	       System.out.print("Enter the amount you would like to transfer: ");
            	       amount = scan.nextDouble();
            	       
            	       System.out.println("You need to verfiy first before we proceed");
            	       
            	       int otp = obj.generateOTP();
            	       
            	       System.out.println("Your OTP is " + otp);
            	       
            	       System.out.println(" ");
            	       
            	       System.out.print("Please enter the otp: ");
            	       
            	       customer.setOtp(scan.nextInt());
    	
    	               val = obj.transfer(customer, defaultCustomer, amount, otp);
    	               
    	               if(val) {
    	            	   
    	            	   System.out.println("Transaction Successfull!");
    	            	   System.out.println("Your updated balance is Rs."+customer.getBalance());
    	            	   
    	               };
    	
                   
                   break;
                   
		    default: System.out.println("You have selected an incorrect option.");
			        
			}
		
	};
	

}
