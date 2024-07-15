package com.cpt.payments.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cpt.payments.dto.PaymentRequestDTO;
import com.cpt.payments.dto.PaymentResponseDTO;
import com.cpt.payments.pojo.PaymentRequest;
import com.cpt.payments.pojo.PaymentResponse;
import com.cpt.payments.service.PaymentService;

@RestController
@RequestMapping("/v1/payments")
public class PaymentController {

	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	PaymentService service;
	
	@PostMapping
    public ResponseEntity<PaymentResponse> initPayment(
    		@RequestBody PaymentRequest paymentRequest) {
		
		System.out.println("initPayment() invoked|| paymentRequest:" + paymentRequest);
		
		System.out.println("modelMapper:" + modelMapper);
		
		PaymentRequestDTO reqDTO = modelMapper.map(
				paymentRequest, PaymentRequestDTO.class);
		
		PaymentResponseDTO resDTO = service.validateAndInitiate(reqDTO);
		
		PaymentResponse paymentResponse = modelMapper.map(
				resDTO, PaymentResponse.class);
		
		System.out.println("Returning response:" + paymentResponse);
		
		
        return new ResponseEntity<PaymentResponse>(
        		paymentResponse, HttpStatus.CREATED);
    }
}
