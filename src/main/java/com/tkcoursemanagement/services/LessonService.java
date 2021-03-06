package com.tkcoursemanagement.services;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tkcoursemanagement.models.Course;
import com.tkcoursemanagement.models.Lesson;
import com.tkcoursemanagement.models.Module;
import com.tkcoursemanagement.repositories.CourseRepository;
import com.tkcoursemanagement.repositories.LessonRepository;
import com.tkcoursemanagement.repositories.ModuleRepository;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class LessonService {
	@Autowired
	CourseRepository courseRepository;
	@Autowired
	ModuleRepository moduleRepository;
	@Autowired
	LessonRepository lessonRepository;

	@GetMapping("/api/course/{courseId}/module/{moduleId}/lesson")
	public List<Lesson> findAllLessonsForModule(@PathVariable("courseId") int courseId, @PathVariable("moduleId") int moduleId) {
		Optional<Module> data = moduleRepository.findById(moduleId);
		if (data.isPresent()) {
			Module module = data.get();
			return module.getLessons();
		}
		return null;
	}
	
	
	@GetMapping("/api/lesson")
	public List<Lesson> findAllLessons() {
		List<Lesson> data = (List<Lesson>) lessonRepository.findAll();
		return data;	
	}

	@PostMapping("/api/course/{courseId}/module/{moduleId}/lesson")
	public Lesson createLesson(@PathVariable("courseId") int courseId, @PathVariable("moduleId") int moduleId,
			@RequestBody Lesson newLesson) {
		Optional<Module> data = moduleRepository.findById(moduleId);
		if (data.isPresent()) {
			Optional<Course> dat = courseRepository.findById(courseId);
			if (dat.isPresent()) {
				Course course = dat.get();
				Date date = new Date(System.currentTimeMillis());
				course.setModified(date);
			}
			Module module = data.get();
			newLesson.setModule(module);
			return lessonRepository.save(newLesson);
		}
		return null;
	}
	
	@DeleteMapping("/api/course/{courseId}/module/{moduleId}/lesson/{lessonId}")
	public void deleteLesson(
			@PathVariable("courseId") int courseId,
			@PathVariable("moduleId") int moduleId,
			@PathVariable("lessonId") int lessonId) {
		Optional<Lesson> data = lessonRepository.findById(lessonId);
		if(data.isPresent()) {
			Optional<Course> dat = courseRepository.findById(courseId);
			if (dat.isPresent()) {
				Course course = dat.get();
				Date date = new Date(System.currentTimeMillis());
				course.setModified(date);
			}
			lessonRepository.deleteById(lessonId);
		}
	}
}
