package com.tkcoursemanagement.repositories;

import org.springframework.data.repository.CrudRepository;

import com.tkcoursemanagement.models.EssayQuestion;
import com.tkcoursemanagement.models.MultipleChoiceQuestion;

public interface EssayQuestionRepository
extends CrudRepository<EssayQuestion, Integer> {
	
}