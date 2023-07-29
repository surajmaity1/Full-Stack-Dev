package com.surajmaity1.beans;

public class CreditCardPayment implements PaymentInterface {
	public boolean billPayment(Double billAmount) {
		System.out.println("Bill Payment Using CreditCard: " + billAmount);
		return true;
	}

}
