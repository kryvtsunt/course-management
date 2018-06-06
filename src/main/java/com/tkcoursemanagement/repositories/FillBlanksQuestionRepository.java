package com.tkcoursemanagement.repositories;

import org.springframework.data.repository.CrudRepository;

import com.tkcoursemanagement.models.FillBlanksQuestion;
import com.tkcoursemanagement.models.MultipleChoiceQuestion;

public interface FillBlanksQuestionRepository 
extends CrudRepository<FillBlanksQuestion, Integer> {
	
}