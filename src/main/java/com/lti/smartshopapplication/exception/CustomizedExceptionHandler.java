package com.lti.smartshopapplication.exception;

import java.util.Date;

import org.jboss.logging.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
@RestController
public class CustomizedExceptionHandler extends ResponseEntityExceptionHandler{
	
	

	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(
			Exception ex, WebRequest request) throws Exception {
		ExceptionResponse exceptionResponse=new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity(exceptionResponse,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	  
	@ExceptionHandler(ResourceNotFoundException.class)
	public final ResponseEntity<Object> resourceNotFoundException(
			ResourceNotFoundException ex, WebRequest request) throws Exception {
		
		
		ExceptionResponse exceptionResponse=new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
		exceptionResponse.setMessage("Product Not Found");
		return new ResponseEntity(exceptionResponse,HttpStatus.NOT_FOUND);
	}

		
}
