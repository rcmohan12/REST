package com.rcm.rest.webservices.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest req) {
	
		ExceptionResponse res = new ExceptionResponse(new Date(), ex.getMessage(), req.getDescription(false));
		return new ResponseEntity(res, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFoundExceptions(UserNotFoundException ex, WebRequest req) {
	
		ExceptionResponse res = new ExceptionResponse(new Date(), ex.getMessage(), req.getDescription(false));
		return new ResponseEntity(res, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(UserExistsException.class)
	public final ResponseEntity<Object> handleUserExistsExceptions(UserExistsException ex, WebRequest req) {
	
		ExceptionResponse res = new ExceptionResponse(new Date(), ex.getMessage(), req.getDescription(false));
		return new ResponseEntity(res, HttpStatus.FORBIDDEN);
	}

}
