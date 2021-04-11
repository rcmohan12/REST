package com.rcm.rest.webservices.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.rcm.rest.webservices.beans.MessageBean;

@RestController
public class MainController {
	
	
	@GetMapping(path= "/hello" )
	public String getMessage() {
		return "hello";
	}
	
	@GetMapping(path= "/hello-bean" )
	public MessageBean getMessageBean() {
		return new MessageBean("hello from object");
	}

	@GetMapping(path= "/hello-bean/{message}" )
	public MessageBean getMessageBeanPathVariable(@PathVariable String message) {
		return new MessageBean(String.format("hello from object %s", message));
	}
	
}
