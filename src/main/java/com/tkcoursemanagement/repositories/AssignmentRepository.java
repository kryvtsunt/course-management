package com.tkcoursemanagement.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.tkcoursemanagement.models.Assignment;
import com.tkcoursemanagement.models.Exam;

public interface AssignmentRepository
extends CrudRepository<Assignment, Integer>{
	
}