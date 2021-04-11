package com.rcm.rest.webservices.controller;

import java.net.URI;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rcm.rest.webservices.beans.User;
import com.rcm.rest.webservices.dao.UserDao;
import com.rcm.rest.webservices.exception.UserExistsException;
import com.rcm.rest.webservices.exception.UserNotFoundException;

@RestController
public class UserService {
	
	@Autowired
	private UserDao _uDAO;

	@GetMapping("/users/getAll")
	public List<User> getAllUsers() {
		List<User> users =  _uDAO.getAllUsers();
		if(users.size() == 0) {
			throw new UserNotFoundException("No users found");
		}
		return users;
	}
	
	@GetMapping("/users/{id}")
	public User getUser(@PathVariable int id) {
		User u = _uDAO.getUser(id);
		if(u == null) {
			throw new UserNotFoundException("Not found user :"+id);
		}
		
		return u;
	}
	
	@PostMapping("/users/create")
	public User createUser(@RequestBody User user) {
		if(_uDAO.addUser(user)) {
			
			System.out.println("new user : "+user);
		} else {
			throw new UserExistsException("User Already Exists");
		}
		
		return user;
	}
	
	@PostMapping("/users")
	public ResponseEntity<Object> createUserWithResponseStatus(@RequestBody User user) {
		_uDAO.addUser(user);
		System.out.println("new user : "+user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.get_id()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PostMapping("/users/delete")
	public ResponseEntity<Object> deleteUserById(@RequestBody User id) {
		if(!_uDAO.deleteUser(id.get_id())) {
			throw new UserNotFoundException("Not found user :"+id);
		} 
		
		return ResponseEntity.ok().build();
	}
	
}
