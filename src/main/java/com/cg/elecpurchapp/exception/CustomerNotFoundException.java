package com.cg.elecpurchapp.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

public class CustomerNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomerNotFoundException() {
		super();
	}
	public CustomerNotFoundException(String errMessage) {
		super(errMessage);
	}

}
