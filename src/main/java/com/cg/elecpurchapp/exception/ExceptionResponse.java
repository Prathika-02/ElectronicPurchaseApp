package com.cg.elecpurchapp.exception;

public class ExceptionResponse {

	private String identifier;

	public ExceptionResponse(String identifier) {
		super();
		this.identifier = identifier;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	

}

