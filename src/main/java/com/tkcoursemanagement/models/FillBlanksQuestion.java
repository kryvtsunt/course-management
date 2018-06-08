package com.tkcoursemanagement.models;

import java.util.List;

import javax.persistence.Entity;

@Entity
public class FillBlanksQuestion extends Question {

	private String blank;

	public String getBlank() {
		return blank;
	}

	public void setBlank(String blank) {
		this.blank = blank;
	}
	
}
