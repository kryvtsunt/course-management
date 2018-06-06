package com.tkcoursemanagement.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.tkcoursemanagement.models.Exam;

public interface ExamRepository
extends CrudRepository<Exam, Integer>{
	
}