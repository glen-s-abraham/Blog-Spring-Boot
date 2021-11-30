package com.glen.BlogPostSpringBoot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glen.BlogPostSpringBoot.models.User;
import com.glen.BlogPostSpringBoot.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;

	public List<User> getAllUsers() {
		
		return userRepository.findAll();
	}

	public User createUser(User user) {
		return userRepository.save(user);
	}

}
