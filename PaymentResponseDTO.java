package com.cpt.payments.dto;

public class PaymentResponseDTO {
	
	private String redirectUrl;
	
	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}
	
	public String getRedirectUrl() {
		return redirectUrl;
	}

	@Override
	public String toString() {
		return "PaymentResponse [redirectUrl=" + redirectUrl + "]";
	}
}
