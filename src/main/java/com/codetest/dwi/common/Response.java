package com.codetest.dwi.common;

import java.util.List;

public class Response {
	public static final String SUCCESS = "success";
	public static final String FAILED = "failed";
	
	private String status;
	private String message;
	private List<String> arrMessage;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getArrMessage() {
		return arrMessage;
	}

	public void setArrMessage(List<String> arrMessage) {
		this.arrMessage = arrMessage;
	}
}
