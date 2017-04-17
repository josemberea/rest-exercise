package com.innocv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.innocv.entity.User;
import com.innocv.repository.UserRepository;

@RestController
@RequestMapping(value="/api/user")
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@RequestMapping(value = "/getall", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Iterable<User>> userGetAll() {
		Iterable<User> users = userRepository.findAll();
		return new ResponseEntity<Iterable<User>>(users, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<User> userGet(@PathVariable(name="id", required=true) Integer id) {
		User user = userRepository.findOne(id);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<User> userCreate(@RequestBody User user) {
		user = userRepository.save(user);
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<User> userUpdate(@RequestBody User user) {
		user = userRepository.save(user);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/remove/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void userRemove(@PathVariable(name="id", required=true) Integer id) {
		userRepository.delete(id);
	}
}
