package com.rcm.rest.webservices.exception;

import java.util.Date;

public class ExceptionResponse {
	
	private Date _date;
	private String _message;
	private String _details;
	
	public ExceptionResponse(Date _date, String _message, String _details) {
		super();
		this._date = _date;
		this._message = _message;
		this._details = _details;
	}

	public Date get_date() {
		return _date;
	}

	public String get_message() {
		return _message;
	}

	public String get_details() {
		return _details;
	}
	
}
