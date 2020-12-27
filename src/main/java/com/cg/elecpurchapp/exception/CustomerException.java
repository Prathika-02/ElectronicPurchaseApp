package com.cg.elecpurchapp.exception;


public class CustomerException extends RuntimeException {

	public CustomerException() {
		super();
	}
	
	public CustomerException(String errMsg) {
		super(errMsg);
	}
}


