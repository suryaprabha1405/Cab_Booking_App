package com.example.exception;

public class CustomerNotFoundException extends Exception{
	public CustomerNotFoundException() {

	}

	public CustomerNotFoundException(String message) {
		super(message);
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
