package com.rcm.rest.webservices.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class UserExistsException extends RuntimeException{
	public UserExistsException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
