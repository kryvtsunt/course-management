package com.example.tkcoursemanagement.repositories;

import org.springframework.data.repository.CrudRepository;
import com.example.tkcoursemanagement.models.User;

public interface UserRepository 
extends CrudRepository<User, Integer>{

}
