package com.formation.mvc.exception;
//personnaliser l'exception
public class AdherentException extends RuntimeException {

	
	private static final long serialVersionUID = 4841781257712427727L;
	
	public AdherentException(String message) {
		super(message);
	}

}
