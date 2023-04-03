package com.bankapp.services;

import com.bankapp.model.*;

public abstract class BankFacilities {
	
	public abstract void checkBalance(UserAccount accountDetails);
	
	public abstract Boolean deposit(UserAccount accountDetails, double amount);
	
	public abstract Boolean withdraw(UserAccount accountDetails, double amount);
	
	public abstract Boolean transfer(UserAccount senderDetails, UserAccount receiverDetails, double amount, int otp);
	
	public abstract int generateOTP();
		
}
