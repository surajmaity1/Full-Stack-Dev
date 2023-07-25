package com.surajmaity1.appmain;

import com.surajmaity1.beans.PaymentProcessing;

public class AppMain {

	public static void main(String[] args) {
		PaymentProcessing paymentProcessing = new PaymentProcessing();
		boolean isTransactionSuccess = paymentProcessing.makePayment("CreditCard", 100.00);
		
		if (isTransactionSuccess) {
			System.out.println("Transaction Successfull");
		} else {
			System.out.println("Transaction Successfull");
		}
	}

}
