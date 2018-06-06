package com.tkcoursemanagement.repositories;

import org.springframework.data.repository.CrudRepository;
import com.tkcoursemanagement.models.Question;


public interface QuestionRepository extends CrudRepository<Question, Integer> {

}
