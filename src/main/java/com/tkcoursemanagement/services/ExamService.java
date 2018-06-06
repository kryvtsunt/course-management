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

import com.tkcoursemanagement.models.Exam;
import com.tkcoursemanagement.models.Topic;
import com.tkcoursemanagement.models.Widget;
import com.tkcoursemanagement.repositories.ExamRepository;
import com.tkcoursemanagement.repositories.TopicRepository;
import com.tkcoursemanagement.repositories.WidgetRepository;

@RestController
@CrossOrigin(origins = "*")
public class ExamService {
	
	@Autowired
	TopicRepository topicRepository;
	
	@Autowired
	WidgetRepository widgetRepository;
	
	@Autowired
	ExamRepository examRepository;
	
	@GetMapping ("/api/exam")
	public List<Exam> findAllExams() {
		return (List<Exam>) examRepository.findAll();	
	}
	
	@GetMapping ("/api/exam/{examId}")
	public Exam findExam(@PathVariable("examtId") int examId) {
		Optional<Exam> data = examRepository.findById(examId);	
		if (data.isPresent()){
			Exam exam = data.get();
			return exam;
		}
		return null;
	}
	
	@GetMapping("/api/topic/{topicId}/exam")
	public List<Widget> findAllExamsForTopic(@PathVariable("topicId") int topicId) {
		Optional<Topic> data = topicRepository.findById(topicId);
		if (data.isPresent()) {
			Topic topic = data.get();
//			return (List<Exam>) examRepository.findExamsForTopic(topicId);
			return topic.getWidgets();
		}
		return null;
	}
	
	
	@PostMapping("/api/topic/{topicId}/exam")
	public Exam createExam(@PathVariable("topicId") int topicId, @RequestBody Exam exam) {
		Optional<Topic> data = topicRepository.findById(topicId);
		if (data.isPresent()) {
			Topic topic = data.get();
			exam.setTopic(topic);
			exam.setWidgetType("Exam");
			return examRepository.save(exam);
		}
		else return null;
	}
	
	@DeleteMapping("/api/exam/{examId}")
	public void deleteExam(@PathVariable("examId") int examId) {
		Optional<Exam> data = examRepository.findById(examId);
		if (data.isPresent()) {
			examRepository.deleteById(examId);
		}
	}
	
	
}

