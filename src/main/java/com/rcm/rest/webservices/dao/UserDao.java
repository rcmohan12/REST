package com.rcm.rest.webservices.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.rcm.rest.webservices.beans.User;

@Component // or @Repository
public class UserDao {
	private static List<User> _users = new ArrayList<User>();
	private static int _userCount = 1;
	
	static {
		_users.add(new User("Roopa", _userCount, new Date()));
		_userCount++;
		_users.add(new User("Shree", _userCount, new Date()));
		_userCount++;
		_users.add(new User("C", _userCount, new Date()));
		_userCount++;
		
	}
	
	public User getUser(int id) {
		for(User user : _users) {
			if(user.get_id() == id) {
				return user;
			}
		}
		return null;
	}
	
	public List<User> getAllUsers() {
		return _users;
	}
	
	public boolean addUser(User user) {
		boolean added = false;
		if(user.get_id() == null) {
			user.set_id(_userCount);
			_userCount++;
			added = true;
		} 
		_users.add(user);
		return added;
	}
	
	public boolean deleteUser(int id) {
		Iterator<User> it = _users.iterator();
		boolean deleted = false;
		while(it.hasNext()) {
			User u = it.next();
			if(u.get_id() == id) {
				it.remove();
				deleted = true;
			}
		}

		return deleted;
	}
	
}
