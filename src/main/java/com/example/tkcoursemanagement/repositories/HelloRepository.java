package com.example.tkcoursemanagement.repositories;

import org.springframework.data.repository.CrudRepository;
import com.example.tkcoursemanagement.models.Hello;

public interface HelloRepository
extends CrudRepository<Hello, Integer> {}
