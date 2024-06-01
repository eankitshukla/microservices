package com.aks.practice.spring;

public class UserException extends RuntimeException{
	Integer httpCode;
	String message;
	public Integer getHttpCode() {
		return httpCode;
	}
	public void setHttpCode(Integer httpCode) {
		this.httpCode = httpCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public UserException(int httpCode,String message) {
		super();
		this.httpCode=httpCode;
		this.message=message;
	} 
	
}
