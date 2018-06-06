package com.tkcoursemanagement.repositories;

import org.springframework.data.repository.CrudRepository;

import com.tkcoursemanagement.models.TrueFalseQuestion;

public interface TrueFalseQuestionRepository
	extends CrudRepository<TrueFalseQuestion, Integer> {
	
}