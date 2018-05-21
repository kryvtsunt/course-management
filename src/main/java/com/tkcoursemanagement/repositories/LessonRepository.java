package com.tkcoursemanagement.repositories;

import org.springframework.data.repository.CrudRepository;

import com.tkcoursemanagement.models.Lesson;


public interface LessonRepository
extends CrudRepository<Lesson, Integer>{}

