package com.surajmaity1.beans;

public class PaymentProcessing {
	
	// Field injection
	private PaymentInterface paymentInterface = null;
	
	// Constructor Injection
	public PaymentProcessing(PaymentInterface paymentInterface) {
		this.paymentInterface = paymentInterface;
	}

	// Setter Injection
	public void setPaymentCard(PaymentInterface paymentInterface) {
		this.paymentInterface = paymentInterface;
	}
	
	
	public boolean makePayment(String card, Double billAmount) {
		return paymentInterface.billPayment(billAmount);
	}
}
