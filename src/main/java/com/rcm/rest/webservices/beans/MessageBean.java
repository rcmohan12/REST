package com.rcm.rest.webservices.beans;

public class MessageBean {
	
	private String _message;

	public MessageBean() {
		
	}
	
	public MessageBean(String message) {
		_message = message;
	}
	
	public String get_message() {
		return _message;
	}

	public void set_message(String _message) {
		this._message = _message;
	}

}
