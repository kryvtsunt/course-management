package com.tkcoursemanagement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.tkcoursemanagement.models.Lesson;
import com.tkcoursemanagement.models.Module;
import com.tkcoursemanagement.repositories.CourseRepository;
import com.tkcoursemanagement.repositories.LessonRepository;
import com.tkcoursemanagement.repositories.ModuleRepository;

public class LessonService {
	@Autowired
	CourseRepository courseRepository;
	@Autowired
	ModuleRepository moduleRepository;
	@Autowired
	LessonRepository lessonRepository;
	
	@GetMapping("api/module/{moduleId}/lesson")
	public List<Lesson> findAllLessons(
			@PathVariable("moduleId") int moduleId) {
		Optional<Module> data = moduleRepository.findById(moduleId);
		if(data.isPresent()) {
			Module module = data.get();
			return module.getLessons();
		}
		return null;		
	}

	
	@PostMapping("/api/module/{moduleId}/lesson/{lessonId}")
	public Lesson createLesson(
			@PathVariable("moduleId") int moduleId,
			@RequestBody Lesson newLesson) {
		Optional<Module> data = moduleRepository.findById(moduleId);
		if(data.isPresent()) {
			Module module = data.get();
			newLesson.setModule(module);
			return lessonRepository.save(newLesson);
		}
		return null;
	}
}
