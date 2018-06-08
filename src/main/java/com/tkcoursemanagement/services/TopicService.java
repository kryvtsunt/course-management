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
import com.tkcoursemanagement.models.Topic;
import com.tkcoursemanagement.repositories.CourseRepository;
import com.tkcoursemanagement.repositories.LessonRepository;
import com.tkcoursemanagement.repositories.ModuleRepository;
import com.tkcoursemanagement.repositories.TopicRepository;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class TopicService {
	@Autowired
	TopicRepository topicRepository;
	@Autowired
	LessonRepository lessonRepository;
	@Autowired
	CourseRepository courseRepository;

	@GetMapping("/api/course/{courseId}/module/{moduleId}/lesson/{lessonId}/topic")
	public List<Topic> findAllTopics(@PathVariable("courseId") int courseId, @PathVariable("moduleId") int moduleId,
			@PathVariable("lessonId") int lessonId) {
		Optional<Lesson> data = lessonRepository.findById(lessonId);
		if (data.isPresent()) {
			Lesson lesson = data.get();
			return lesson.getTopics();
		}
		return null;
	}

	@PostMapping("/api/course/{courseId}/module/{moduleId}/lesson/{lessonId}/topic")
	public Topic createTopic(@PathVariable("courseId") int courseId, @PathVariable("moduleId") int moduleId,
			@PathVariable("lessonId") int lessonId, @RequestBody Topic newTopic) {
		Optional<Lesson> data = lessonRepository.findById(lessonId);
		if (data.isPresent()) {
			Optional<Course> dat = courseRepository.findById(courseId);
			if (dat.isPresent()) {
				Course course = dat.get();
				Date date = new Date(System.currentTimeMillis());
				course.setModified(date);
			}
			Lesson lesson = data.get();
			newTopic.setLesson(lesson);
			return topicRepository.save(newTopic);
		}
		return null;
	}

	@DeleteMapping("/api/course/{courseId}/module/{moduleId}/lesson/{lessonId}/topic/{topicId}")
	public void deleteTopic(@PathVariable("courseId") int courseId, @PathVariable("moduleId") int moduleId,
			@PathVariable("lessonId") int lessonId, @PathVariable("topicId") int topicId) {
		Optional<Topic> data = topicRepository.findById(topicId);
		if (data.isPresent()) {
			Optional<Course> dat = courseRepository.findById(courseId);
			if (dat.isPresent()) {
				Course course = dat.get();
				Date date = new Date(System.currentTimeMillis());
				course.setModified(date);
			}
			topicRepository.deleteById(topicId);
		}
	}
}
