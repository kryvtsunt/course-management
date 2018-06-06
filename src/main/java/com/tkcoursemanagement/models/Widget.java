package com.tkcoursemanagement.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class Widget {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int id;
	private String name;		// name of the widget
	private int widgetOrder;	// order inside one topic
	private String text;    	// text of the widget content
	private String widgetType;  //Type of the widget - TODO: change to inheritance
	private int size;			// font size
	private String href;		// for link
	private int width;			// width of the picture
	private String src;			// for img
	private String listType;	// type of the list
	
	@ManyToOne
	@JsonIgnore
	private Topic topic;

	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getWidgetType() {
		return widgetType;
	}
	public void setWidgetType(String widgetType) {
		this.widgetType = widgetType;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}

	public String getListType() {
		return listType;
	}
	public void setListType(String listType) {
		this.listType = listType;
	}
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	public int getWidgetOrder() {
		return widgetOrder;
	}
	public void setWidgetOrder(int widgetOrder) {
		this.widgetOrder = widgetOrder;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	
	

	
	
	
	
	
}
