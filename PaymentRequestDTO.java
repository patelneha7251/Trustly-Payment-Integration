package com.cpt.payments.dto;

public class PaymentRequestDTO {

	private int paymentid;
	
	public int getPaymentid() {
		return paymentid;
	}
	
	public void setPaymentid(int paymentid) {
		this.paymentid = paymentid;
	}

	@Override
	public String toString() {
		return "PaymentRequest [paymentid=" + paymentid + "]";
	}
}
