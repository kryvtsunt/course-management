package com.tkcoursemanagement.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.tkcoursemanagement.models.User;

public interface UserRepository 
extends CrudRepository<User, Integer>{
	@Query("SELECT u FROM User u WHERE u.username=:username AND u.password=:password")
	Iterable<User> findUserByCredentials(
	@Param("username") String username,
	@Param("password") String password);
	
	@Query("SELECT u FROM User u WHERE u.email=:email")
	Iterable<User> findUserByEmail(
	@Param("email") String email);
	
	@Query("SELECT u FROM User u WHERE u.username=:username")
	Iterable<User> findUserByUsername(
	@Param("username") String username);
	
	
	@Query("SELECT u FROM User u WHERE u.resetToken=:resetToken")
	Iterable<User> findUserByResetToken(
	@Param("resetToken") String resetToken);
	
}
