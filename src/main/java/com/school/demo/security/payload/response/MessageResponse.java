/*
 * Copyright (c) 3/15/20, 10:36 PM. Mehdi 2/21/20, 1:49 PM
 */

package com.school.demo.security.payload.response;

public class MessageResponse {
	private String message;

	public MessageResponse(String message) {
	    this.message = message;
	  }

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
