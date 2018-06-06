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
public class WidgetService {
	
	@Autowired
	TopicRepository topicRepository;
	
	@Autowired
	WidgetRepository widgetRepository;
	
	@Autowired
	ExamRepository examRepository;
	
	@Autowired
	AssignmentRepository assignmentRepository;
	
	
	@GetMapping ("/api/widget")
	public List<Widget> findAllWidgets() {
		return (List<Widget>) widgetRepository.findAll();	
	}
	
	@GetMapping ("/api/widget/{widgetId}")
	public Widget findWidget(@PathVariable("widgetId") int widgetId) {
		Optional<Widget> data = widgetRepository.findById(widgetId);	
		if (data.isPresent()){
			Widget widget = data.get();
			return widget;
		}
		return null;
	}
	
	@GetMapping("/api/topic/{topicId}/widget")
	public List<Widget> findAllWidgetsForTopic(@PathVariable("topicId") int topicId) {
		Optional<Topic> data = topicRepository.findById(topicId);
		if (data.isPresent()) {
			Topic topic = data.get();
			return topic.getWidgets();
		}
		return null;
	}
	
	
	@PostMapping("/api/widget")
	public List<Widget> saveWidgets(@RequestBody List<Widget> widgets) {
		widgetRepository.deleteAll();
		return (List<Widget>) widgetRepository.saveAll(widgets);
		
	}
	
	@PostMapping("/api/topic/{topicId}/widget")
	public List<Widget> saveWidgetsForTopic(@RequestBody List<Widget> widgets, @PathVariable("topicId") int topicId) {
		Optional<Topic> data = topicRepository.findById(topicId);
		if (data.isPresent()) {
			Topic topic = data.get();
			List<Widget> oldWidgets = topic.getWidgets();
			for (Widget w : oldWidgets) {
				widgetRepository.delete(w);
			}
			for (Widget w : widgets) {
				w.setTopic(topic);
//				if (w.getWidgetType().equals("Exam")) {
//					Exam e = (Exam) w;
//					examRepository.save(e);
//				} else if (w.getWidgetType().equals("Assignment")) {
//					Assignment a = (Assignment) w;
//					assignmentRepository.save(a);
//				}
//				else {
//				System.out.println(w.getWidgetType());
				widgetRepository.save(w);
//				}
			}
			return widgets;
		}
		return null;
		
	}
	@PutMapping("/api/widget/{widgetId}")
	public Widget updateWidget(@RequestBody Widget widget, @PathVariable("widgetId") int widgetId) {
		Optional<Widget> data = widgetRepository.findById(widgetId);
		if (data.isPresent()) {
			widgetRepository.deleteById(widgetId);
			return widgetRepository.save(widget);
		}
		return null;
	}
	

	
	@DeleteMapping("/api/widget/{widgetId}")
	public void deleteWidget(@PathVariable("widgetId") int widgetId) {
		Optional<Widget> data = widgetRepository.findById(widgetId);
		if (data.isPresent()) {
			widgetRepository.deleteById(widgetId);
		}
	}
	
//	@PostMapping("/api/topic/{topicId}/widget")
//	public Widget createWidget(@PathVariable("topicId") int topicId, @RequestBody Widget widget) {
//		Optional<Topic> data = topicRepository.findById(topicId);
//		if (data.isPresent()) {
//			Topic topic = data.get();
//			widget.setTopic(topic);
//			return widgetRepository.save(widget);
//		}
//		else return null;
//	}
	
	
}
