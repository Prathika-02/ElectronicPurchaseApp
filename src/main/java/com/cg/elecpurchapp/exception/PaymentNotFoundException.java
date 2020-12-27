package com.cg.elecpurchapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND)
public class PaymentNotFoundException extends RuntimeException {

	public PaymentNotFoundException() {
		// TODO Auto-generated constructor stub
	}
}