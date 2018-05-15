package com.tkcoursemanagement.services;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mysql.fabric.Response;
import com.tkcoursemanagement.models.User;
import com.tkcoursemanagement.repositories.UserRepository;

@RestController
public class UserService {
	@Autowired
	UserRepository repository; 
	
	@DeleteMapping("/api/user/{userId}")
	public void deleteUser(@PathVariable("userId") int id) {
		repository.deleteById(id);
	}
	
	@PostMapping("/api/user")
	public User createUser(@RequestBody User user) {
		return repository.save(user);
	}
	
	@GetMapping("/api/user")
	public List<User> findAllUsers() {
		return (List<User>) repository.findAll();
	}
	
	@GetMapping("/api/user/{userId}")
	public User findUserById(@PathVariable("userId") int id) {
		Optional<User> data = repository.findById(id);
		if (data.isPresent()) { 
			return data.get();
		}
		else return null;
	}
	
	@PutMapping("/api/user/{userId}")
	public User updateUser(@PathVariable("userId") int id, @RequestBody User newUser, HttpServletResponse response) {
		Optional<User> data = repository.findById(id);
		if (data.isPresent()) { 
			User user = data.get();
			user.setFirstName(newUser.getFirstName());
			user.setLastName(newUser.getLastName());
			user.setPassword(newUser.getPassword());
			user.setRole(newUser.getRole());
			repository.save(user);
			return user;
		}
		else {
			response.setStatus(10);
			return null;
		}
	}
	@GetMapping("/api/session/set/{attr}/{value}")
	public String setSessionAttribute(
			@PathVariable("attr") String attr,
			@PathVariable("value") String value,
			HttpSession session) {
		session.setAttribute(attr, value);
		return attr + " = " + value;
	}
	
	@GetMapping("/api/session/get/{attr}")
	public String getSessionAttribute(
			@PathVariable ("attr") String attr,
			HttpSession session) {
		return (String) session.getAttribute(attr);
	}
	
	@GetMapping("/api/session/invalidate")
	public String invalidateSession( HttpSession session) {
		session.invalidate();
		return "session invalidated";
	}
	
	@PostMapping("/api/register")
	public User register(@RequestBody User user, HttpSession session) {
		session.setAttribute("currentUser", user);

		repository.save(user);
		return user;
	}
	
	@GetMapping("/api/profile")
	public User profile(HttpSession session) {
		if (session.isNew()) {
			return repository.findById(42).get();
		}
		else {
		User currentUser = (User) session.getAttribute("currentUser");
		return currentUser;
		}
	}
	
	@PostMapping("/api/login")
	public User login(@RequestBody User user, HttpSession session, HttpServletResponse response) {
		session.setAttribute("currentUser", user);
		List<User> users = (List<User>) repository.findUserByCredentials(user.getUsername(), user.getPassword());
		if (users.isEmpty()) { 
			response.setStatus(10);
			return null; 
			}
		else {return users.get(0); }
	}
	
	@PostMapping("/api/logout")
	public void logout(HttpSession session) {
		session.invalidate();
	}
}

