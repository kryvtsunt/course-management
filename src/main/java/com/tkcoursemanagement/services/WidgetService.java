package com.tkcoursemanagement.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tkcoursemanagement.models.Lesson;
import com.tkcoursemanagement.models.Topic;
import com.tkcoursemanagement.models.Widget;
import com.tkcoursemanagement.repositories.TopicRepository;
import com.tkcoursemanagement.repositories.WidgetRepository;

@RestController
@CrossOrigin(origins = "*")
public class WidgetService {
	
	@Autowired
	TopicRepository topicRepository;
	
	@Autowired
	WidgetRepository widgetRepository;
	
	@GetMapping ("/api/widget")
	public List<Widget> findAllWidgets() {
		return (List<Widget>) widgetRepository.findAll();	
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
			}
//			topic.setWidgets(widgets);
			return (List<Widget>) widgetRepository.saveAll(widgets);
		}
		return null;
		
	}
}
