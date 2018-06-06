package com.tkcoursemanagement.repositories;

import org.springframework.data.repository.CrudRepository;

import com.tkcoursemanagement.models.MultipleChoiceQuestion;
import com.tkcoursemanagement.models.TrueFalseQuestion;

public interface MultipleChoiceQuestionRepository
	extends CrudRepository<MultipleChoiceQuestion, Integer> {
	
}