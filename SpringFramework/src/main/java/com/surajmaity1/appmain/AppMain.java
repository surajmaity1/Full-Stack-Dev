package com.surajmaity1.appmain;

import com.surajmaity1.beans.DebitCardPayment;
import com.surajmaity1.beans.MasterCardPayment;
import com.surajmaity1.beans.PaymentProcessing;

public class AppMain {

	public static void main(String[] args) {
		/*
		 * Note: this is very important
		 * 
		 * creating target class and dependent class object and injecting dependent object into target class
		 * This is the approach of universal requirement
		 */
		
		/*
		 * IOC --> PRINCIPLE --> RESPONSIBLE 
		 * --> MANAGE AND COLLABORATE DEPENDENCIES AMONG OBJECTS IN THE APPLICATION
		 */
		
		/*
		 * What is dependency injection -
		 * Injecting dependent object into target object 
		 */
		
		
		
		// Constructor Injection
		/*
		 *  Constructor Injection - injecting dependent object into target object
		 *  using target class Constructor
		 */
		PaymentProcessing paymentProcessing = new PaymentProcessing(new DebitCardPayment());

		// Setter Injection
		/*
		 *  Setter Injection - injecting dependent object into target object
		 *  using target class sete
		 */
		paymentProcessing.setPaymentCard(new MasterCardPayment());
		
		boolean isTransactionSuccess = paymentProcessing.makePayment("CreditCard", 100.00);
		
		if (isTransactionSuccess) {
			System.out.println("Transaction Successfull");
		} else {
			System.out.println("Transaction Successfull");
		}
	}

}
