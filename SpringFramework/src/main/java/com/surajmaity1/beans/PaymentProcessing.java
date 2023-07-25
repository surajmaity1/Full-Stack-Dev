package com.surajmaity1.beans;

public class PaymentProcessing {
	public boolean makePayment(String card, Double billAmount) {
		if ("CreditCard".equals(card)) {
			CreditCardPayment creditCardPayment = new CreditCardPayment();
			return creditCardPayment.billPayment(100.00);
		}
		else if ("DebitCard".equals(card)) {
			DebitCardPayment debitCardPayment = new DebitCardPayment();
			return debitCardPayment.billPayment(100.00);
		}
		else if ("MasterCard".equals(card)) {
			MasterCardPayment masterCardPayment = new MasterCardPayment();
			return masterCardPayment.billPayment(100.00);
		}
		else {
			return false;
		}
	}
}
