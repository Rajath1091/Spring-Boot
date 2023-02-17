package com.ty.spring_school_app.exception;

public class IdNotFoundException extends Exception {

	private String message = "Id not found";

	@Override
	public String getMessage() {
		return message;
	}

	public IdNotFoundException(String message) {
		super();
		this.message = message;
	}

	public IdNotFoundException() {
		super();
	}

}
