package com.chitresh.laa.payload.response;

public class QueryResponse {
	private String message;
	
	public QueryResponse(String message) {
	    this.message = message;
	  }

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
