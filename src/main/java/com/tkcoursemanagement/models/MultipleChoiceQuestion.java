package com.tkcoursemanagement.models;

import java.util.List;

import javax.persistence.Entity;

@Entity
public class MultipleChoiceQuestion extends Question {
	private List<String> options;
	private int correctOption;

	public int getCorrectOption() {
		return correctOption;
	}
	public void setCorrectOption(int correctOption) {
		this.correctOption = correctOption;
	}
	public List<String> getOptions() {
		return options;
	}
	public void setOptions(List<String> options) {
		this.options = options;
	}
	
	
	
	
}