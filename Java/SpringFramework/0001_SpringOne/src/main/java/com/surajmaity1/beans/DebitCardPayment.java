package com.surajmaity1.beans;

public class DebitCardPayment implements PaymentInterface {
	public boolean billPayment(Double billAmount) {
		System.out.println("Bill Payment Using DebitCard: " + billAmount);
		return true;
	}

}
