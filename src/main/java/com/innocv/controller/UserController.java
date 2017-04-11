package com.innocv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.innocv.entity.User;
import com.innocv.repository.UserRepository;

@RestController
@RequestMapping(value="/api/user")
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@RequestMapping(value = "/getall", method = RequestMethod.GET)
	public String userGetAll() {
		List<User> users = userRepository.findAll();
		System.out.println(users.size());
		return "getall";
	}
	
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public String userGetAll(@PathVariable(name="id", required=true) Integer id) {
		return "get " + id;
	}
}
