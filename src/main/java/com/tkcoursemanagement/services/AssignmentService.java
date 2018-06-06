package com.tkcoursemanagement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tkcoursemanagement.models.Assignment;
import com.tkcoursemanagement.models.Exam;
import com.tkcoursemanagement.models.Topic;
import com.tkcoursemanagement.models.Widget;
import com.tkcoursemanagement.repositories.AssignmentRepository;
import com.tkcoursemanagement.repositories.ExamRepository;
import com.tkcoursemanagement.repositories.TopicRepository;
import com.tkcoursemanagement.repositories.WidgetRepository;

@RestController
@CrossOrigin(origins = "*")
public class AssignmentService {
	
	@Autowired
	TopicRepository topicRepository;
	
	@Autowired
	WidgetRepository widgetRepository;
	
	@Autowired
	ExamRepository examRepository;
	
	@Autowired
	AssignmentRepository assignmentRepository;
	
	@GetMapping ("/api/assignment")
	public List<Exam> findAllExams() {
		return (List<Exam>) examRepository.findAll();	
	}
	
	
	@GetMapping("/api/topic/{topicId}/assignment")
	public List<Widget> findAllExamsForTopic(@PathVariable("topicId") int topicId) {
		Optional<Topic> data = topicRepository.findById(topicId);
		if (data.isPresent()) {
			Topic topic = data.get();
			return topic.getWidgets();
		}
		return null;
	}
	
	
	@PostMapping("/api/topic/{topicId}/assignment")
	public Assignment createAssignment(@PathVariable("topicId") int topicId, @RequestBody Assignment assignment) {
		Optional<Topic> data = topicRepository.findById(topicId);
		if (data.isPresent()) {
			Topic topic = data.get();
			assignment.setTopic(topic);
			return assignmentRepository.save(assignment);
		}
		else return null;
	}
	
//	@DeleteMapping("/api/exam/{examId}")
//	public void deleteExam(@PathVariable("examId") int examId) {
//		Optional<Exam> data = examRepository.findById(examId);
//		if (data.isPresent()) {
//			examRepository.deleteById(examId);
//		}
//	}
	
	
}

