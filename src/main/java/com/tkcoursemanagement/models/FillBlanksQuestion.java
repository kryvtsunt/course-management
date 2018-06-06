package com.tkcoursemanagement.models;

import java.util.List;

import javax.persistence.Entity;

@Entity
public class FillBlanksQuestion extends Question {

	private List<String> blankVariables;

	public List<String> getBlankVariables() {
		return blankVariables;
	}

	public void setBlankVariables(List<String> blankVariables) {
		this.blankVariables = blankVariables;
	}
	
}
