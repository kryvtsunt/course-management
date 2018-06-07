package com.tkcoursemanagement.services;

import java.util.ArrayList;
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
import com.tkcoursemanagement.models.EssayQuestion;
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
	public List<Widget> findAllAssignmentsForTopic(@PathVariable("topicId") int topicId) {
		Optional<Topic> data = topicRepository.findById(topicId);
		if (data.isPresent()) {
			Topic topic = data.get();
			List<Widget> widgets = topic.getWidgets();
			List<Widget> assignments = new ArrayList<Widget>();
			for (Widget w : widgets) {
				if ((w != null) && (w.getWidgetType() != null) && (w.getWidgetType().equals("Assignment"))) {
					assignments.add(w);
				}
			}
			return assignments;
		}
		return null;
	}
	
	@PostMapping("/api/topic/{topicId}/assignment")
	public Assignment createAssignment(@PathVariable("topicId") int topicId, @RequestBody Assignment assignment) {
		Optional<Topic> data = topicRepository.findById(topicId);
		if (data.isPresent()) {
			Topic topic = data.get();
			assignment.setTopic(topic);
			assignment.setWidgetType("Assignment");
			return assignmentRepository.save(assignment);
		}
		else return null;
	}
	
	@DeleteMapping("/api/assignment/{assignmentId}")
	public void deleteAssignment(@PathVariable("assignmentId") int assignmentId) {
		Optional<Assignment> data = assignmentRepository.findById(assignmentId);
		if (data.isPresent()) {
			assignmentRepository.deleteById(assignmentId);
		}
	}
	
	@PutMapping("/api/assignment/{assignmentId}")
	public Assignment updateAssignment(@PathVariable("assignmentId") int assignmentId, @RequestBody Assignment q) {
		Optional<Assignment> optionalAssignment = assignmentRepository.findById(assignmentId);
		if(optionalAssignment.isPresent()) {
			Assignment a = optionalAssignment.get();
			a.setTitle(q.getTitle());		
			a.setDescription(q.getDescription());
			return assignmentRepository.save(a);
		}
		else return null;
	}
	
	@GetMapping("/api/assignment/{assignmentId}")
	public Assignment findAssignmentnById(@PathVariable("assignmentId") int assignmentId) {
		Optional<Assignment> optional = assignmentRepository.findById(assignmentId);
		if(optional.isPresent()) {
			return optional.get();
		}
		else return null;
	}
	
	
}

