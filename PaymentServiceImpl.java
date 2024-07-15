package com.cpt.payments.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.cpt.payments.constants.ValidationRules;
import com.cpt.payments.dto.PaymentRequestDTO;
import com.cpt.payments.dto.PaymentResponseDTO;
import com.cpt.payments.service.PaymentService;
import com.cpt.payments.service.Validator;

@Service
public class PaymentServiceImpl implements PaymentService {

	
	@Value("${payment.validators}")
	private String validatorRules;
	
	@Autowired
	private ApplicationContext appContext;
	
	@Override
	public PaymentResponseDTO validateAndInitiate(PaymentRequestDTO request) {
		System.out.println("PaymentServiceImpl received request:" + request);
		
		System.out.println("validatorRules:" + validatorRules);
		
		
		String[] validationRuleArray = validatorRules.split(",");
		
		for(String ruleName : validationRuleArray) {
			System.out.println("ruleName:" + ruleName);
			
			ValidationRules validationEnum = ValidationRules.fromName(ruleName);
			
			// returns the spring bean validation rule Class.
			Validator validationBean = (Validator) appContext.getBean(validationEnum.getClazz());
			System.out.println("Got this bean from AppContext validationBean:" + validationBean);
			
			boolean isValid = validationBean.doValidate(request);
		}
		
		
		PaymentResponseDTO response = new PaymentResponseDTO();
		response.setRedirectUrl("https://www.google.com/");
		
		return response;
	}

}
