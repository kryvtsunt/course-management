package com.tkcoursemanagement.repositories;

import org.springframework.data.repository.CrudRepository;

import com.tkcoursemanagement.models.Module;


public interface ModuleRepository
extends CrudRepository<Module, Integer>{}
