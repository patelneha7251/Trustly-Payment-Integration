package com.cpt.payments.service;

import com.cpt.payments.dto.PaymentRequestDTO;

public interface Validator {
	
	public boolean doValidate(PaymentRequestDTO request);

}
