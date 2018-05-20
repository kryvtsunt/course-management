package com.tkcoursemanagement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tkcoursemanagement.models.Course;
import com.tkcoursemanagement.repositories.CourseRepository;

@RestController
public class CourseService {
	@Autowired
	CourseRepository courseRepository;	
	
	@GetMapping("/api/course")
	public Iterable<Course> findAllCourses() {
		return courseRepository.findAll(); 
	}
}

