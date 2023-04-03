package com.bankapp.driver;

import java.util.*;

import com.bankapp.model.*;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		    Scanner input = new Scanner(System.in);
		    
			//default customer
			UserAccount defaultCustomer = new UserAccount("A123", "pass123", 20000 );
			
			
			//Create User
			System.out.println("Enter your account No.: ");
			String accountNo = input.nextLine();
			
			System.out.println("Set your password: ");
			String password = input.nextLine();
			
			System.out.println("Enter your intial balance: ");
			double balance = input.nextDouble();
			
			
			input.nextLine();
			
			UserAccount customer1 = new UserAccount(accountNo, password, balance);
			
			
			System.out.println("User Created Successfully!");
			System.out.println("Your Account No. is: " + customer1.getAccountNo()+
					"\nYour Intial balance is: Rs."+customer1.getBalance());
			
			System.out.println("***************************************************");
			
			//login
			
			System.out.println("Enter your Account No.:");
			String acc = input.nextLine();
			
			
			System.out.println("Enter your Password:");
			String pass = input.nextLine();
			
			
			
			if(accountNo.equals(acc) && password.equals(pass)){
				
				UserLogin validate = new UserLogin();
				
				validate.login(customer1, defaultCustomer);
				
			}else {
				System.out.println("Login Failed!");
			}
			
	        input.close();
 
	}

}
