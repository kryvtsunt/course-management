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

import com.tkcoursemanagement.repositories.CourseRepository;
import com.tkcoursemanagement.repositories.ModuleRepository;
import com.tkcoursemanagement.models.Course;
import com.tkcoursemanagement.models.Module;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class ModuleService {
	@Autowired
	CourseRepository courseRepository;
	@Autowired
	ModuleRepository moduleRepository;

	@GetMapping("/api/course/{courseId}/module")
	public List<Module> findAllModulesForCourse(@PathVariable("courseId") int courseId) {
		Optional<Course> data = courseRepository.findById(courseId);
		if (data.isPresent()) {
			Course course = data.get();
			return course.getModules();
		}
		return null;
	}

	@GetMapping("/api/module")
	public List<Module> findAllModules() {
		List<Module> data = (List<Module>) moduleRepository.findAll();
		return data;
	}

	@PostMapping("/api/course/{courseId}/module")
	public Module createModule(@PathVariable("courseId") int courseId, @RequestBody Module newModule) {
		Optional<Course> data = courseRepository.findById(courseId);
		if (data.isPresent()) {
			Optional<Course> dat = courseRepository.findById(courseId);
			if (dat.isPresent()) {
				Course course = dat.get();
				Date date = new Date(System.currentTimeMillis());
				course.setModified(date);
			}
			Course course = data.get();
			newModule.setCourse(course);
			return moduleRepository.save(newModule);
		}
		return null;
	}

	@DeleteMapping("/api/course/{courseId}/module/{moduleId}")
	public void deleteModule(@PathVariable("courseId") int courseId, @PathVariable("moduleId") int moduleId) {
		Optional<Module> data = moduleRepository.findById(moduleId);
		if (data.isPresent()) {
			Optional<Course> dat = courseRepository.findById(courseId);
			if (dat.isPresent()) {
				Course course = dat.get();
				Date date = new Date(System.currentTimeMillis());
				course.setModified(date);
			}
			moduleRepository.deleteById(moduleId);
		}
	}

	@GetMapping("/api/module/{moduleId}")
	public Module findModuleByID(@PathVariable("moduleId") int moduleId) {
		Optional<Module> data = moduleRepository.findById(moduleId);
		if (data.isPresent()) {
			return data.get();
		} else {
			return null;
		}
	}

}
