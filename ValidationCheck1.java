package com.cpt.payments.service.impl.validators;

import org.springframework.stereotype.Service;

import com.cpt.payments.dto.PaymentRequestDTO;
import com.cpt.payments.service.Validator;

@Service
public class ValidationCheck1 implements Validator {

	@Override
	public boolean doValidate(PaymentRequestDTO request) {
		System.out.println("ValidationCheck1.doValidate invoked");
		
		return false;
	}

}
