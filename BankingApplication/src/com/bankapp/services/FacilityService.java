package com.bankapp.services;

import com.bankapp.model.UserAccount;

public class FacilityService extends BankFacilities {

	@Override
	public void checkBalance(UserAccount accountDetails) {
		// TODO Auto-generated method stub
		if(accountDetails.getBalance() < 0) {
			System.out.println("Insufficient balance, please update");
		}else {
			System.out.println("Current Account balance is " + accountDetails.getBalance());
		}
		
	}

	@Override
	public Boolean deposit(UserAccount accountDetails, double amount) {
		// TODO Auto-generated method stub
		if(amount <= 0) {
			System.out.println("Please enter vaild amount. \n"
					+ "Your entered amount should be above 0");
			return false;
		}else {
			double currentBalance = accountDetails.getBalance();
			double updatedBalance = currentBalance + amount;
			accountDetails.setBalance(updatedBalance);
			return true;
		}
		
	}

	@Override
	public Boolean withdraw(UserAccount accountDetails, double amount) {
		// TODO Auto-generated method stub
		double currentBalance = accountDetails.getBalance();
		
		if(amount <= 0) {
			System.out.println("Please enter vaild amount. \n"
					+ "Your entered amount should be above 0");
			return false;
		}
		else if(amount > currentBalance) {
			System.out.println("Your account does not have sufficient Balance. \n"
					+ "Please enter amount less than Rs."+ currentBalance);
			return false;
		}else {
			double updatedBalance = currentBalance - amount;
			accountDetails.setBalance(updatedBalance);
			return true;
		}
		
	}

	@Override
	public Boolean transfer(UserAccount senderDetails, UserAccount receiverDetails, double amount, int otp) {
		// TODO Auto-generated method stub
		if(otp == senderDetails.getOtp()) {
			System.out.println("Varification was successfull");
			
			double senderBalance = senderDetails.getBalance();
			double updatedSenderBalance = senderBalance - amount;
			senderDetails.setBalance(updatedSenderBalance);
			
			double receiverBalance = receiverDetails.getBalance();
			double updatedReceiverBalance = receiverBalance + amount;
			receiverDetails.setBalance(updatedReceiverBalance);
			return true;
			
		}else {
			System.out.println("Varification failed \n"
					+ "Entered OTP is incorrect.");
			return false;
		}
	}

	@Override
	public int generateOTP() {
		// TODO Auto-generated method stub
		OtpGenerator newOtp = new OtpGenerator();
		return newOtp.otp;
		
	}
	
	
}
