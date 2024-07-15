package com.cpt.payments.pojo;

public class PaymentRequest {

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
