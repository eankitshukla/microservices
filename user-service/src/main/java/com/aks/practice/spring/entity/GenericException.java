package com.aks.practice.spring.entity;

public class GenericException {
	
	
	private int exceptioncode;
	private String errorMessage;
	@Override
	public String toString() {
		return "GenericException [exceptioncode=" + exceptioncode + ", errorMessage=" + errorMessage + "]";
	}
	public GenericException(int exceptioncode, String errorMessage) {
		super();
		this.exceptioncode = exceptioncode;
		this.errorMessage = errorMessage;
	}
	public int getExceptioncode() {
		return exceptioncode;
	}
	public void setExceptioncode(int exceptioncode) {
		this.exceptioncode = exceptioncode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
