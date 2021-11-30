package com.glen.BlogPostSpringBoot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glen.BlogPostSpringBoot.models.User;
import com.glen.BlogPostSpringBoot.services.UserService;

@RestController
@RequestMapping("/api/user/")
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping
	public List<User> getUsers(){
		return userService.getAllUsers();
	}
	
	@PostMapping
	public User createNewUser(@RequestBody User user) {
		return userService.createUser(user);
	}
}
