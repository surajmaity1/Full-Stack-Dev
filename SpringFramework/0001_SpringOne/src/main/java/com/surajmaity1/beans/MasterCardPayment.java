package com.surajmaity1.beans;

public class MasterCardPayment implements PaymentInterface {
	public boolean billPayment(Double billAmount) {
		System.out.println("Bill Payment Using MasterCard: " + billAmount);
		return true;
	}
}
