package com.bookmyparking.demo.models;

public class Message {
	private String message;
	private String className;
	
	public Message(String message, String className) {
		super();
		this.message = message;
		this.className = className;
	}
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	
	
}
