package com.demoapp.spring.files.csv.message;

import java.util.List;

import com.demoapp.spring.files.csv.model.Tutorial;

public class ResponseMessage {

	private List<Tutorial> tutorials;
	private String message;

	ResponseMessage(List<Tutorial> tutorials, String message) {
		this.tutorials = tutorials;
		this.message = message;
	}

	public List<Tutorial> getTutorials() {
		return tutorials;
	}

	public void setTutorials(List<Tutorial> tutorials) {
		this.tutorials = tutorials;
	}

	public ResponseMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
