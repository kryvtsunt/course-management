package com.tkcoursemanagement.models;

import java.util.List;

import javax.persistence.Entity;

@Entity
public class FillBlanksQuestion extends Question {

	private String blankVariables;

	public String getBlankVariables() {
		return blankVariables;
	}

	public void setBlankVariables(String blankVariables) {
		this.blankVariables = blankVariables;
	}
	
}
