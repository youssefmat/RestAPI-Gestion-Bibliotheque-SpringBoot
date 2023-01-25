package com.formation.mvc.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.formation.mvc.responses.ErrorMessage;



@ControllerAdvice
public class ApplicationHandler {
	
	@ExceptionHandler(value= {AdherentException.class})
	public ResponseEntity<Object> handleAdherentException(AdherentException ex, WebRequest request){
		
		// personnaliser l'object de type exception 
		
		ErrorMessage errorMessage = new ErrorMessage(new Date(), ex.getMessage());
		
		return new ResponseEntity<>(errorMessage, new HttpHeaders() , HttpStatus.ALREADY_REPORTED );
		
	}
	
	// Manipuler l'nesemble d'exceptions
		// céer une manipulation des exception globale sur tout les exception executer dans mon application sauf exception UserException
		
		
		@ExceptionHandler(value= {Exception.class})
		public ResponseEntity<Object> handleOtherException(Exception ex, WebRequest request){
			
			// personnaliser l'object de type exception 
			
			ErrorMessage errorMessage = new ErrorMessage(new Date(), ex.getMessage());
			
			return new ResponseEntity<>(errorMessage, new HttpHeaders() , HttpStatus.ALREADY_REPORTED );
			
		}

}
