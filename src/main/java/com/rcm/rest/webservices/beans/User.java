package com.rcm.rest.webservices.beans;

import java.util.Date;

public class User {
	
	private String _name;
	private Integer _id;
	private Date _dob;
	
	public User() {
		
	}
	
	public User(String _name, Integer _id, Date _dob) {
		super();
		this._name = _name;
		this._id = _id;
		this._dob = _dob;
	}
	
	public String get_name() {
		return _name;
	}
	public void set_name(String _name) {
		this._name = _name;
	}
	public Integer get_id() {
		return _id;
	}
	public void set_id(Integer _id) {
		this._id = _id;
	}
	public Date get_dob() {
		return _dob;
	}
	public void set_dob(Date _dob) {
		this._dob = _dob;
	}

	@Override
	public String toString() {
		return "User [_name=" + _name + ", _id=" + _id + ", _dob=" + _dob + "]";
	}

}
