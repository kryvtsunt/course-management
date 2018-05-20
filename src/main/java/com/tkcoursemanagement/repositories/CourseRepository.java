package com.tkcoursemanagement.repositories;

import org.springframework.data.repository.CrudRepository;
import com.tkcoursemanagement.models.Course;

public interface CourseRepository
extends CrudRepository<Course, Integer> { }
