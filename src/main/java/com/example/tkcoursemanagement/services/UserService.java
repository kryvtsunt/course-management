package com.example.tkcoursemanagement.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tkcoursemanagement.models.User;
import com.example.tkcoursemanagement.repositories.UserRepository;

@RestController
public class UserService {
	@Autowired
	UserRepository repository; 
	
	@GetMapping("/api/user")
	public List<User> findAllUsers() {
		return (List<User>) repository.findAll();
	}
}
