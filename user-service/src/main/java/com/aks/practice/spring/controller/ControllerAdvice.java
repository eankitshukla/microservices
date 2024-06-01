package com.aks.practice.spring.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.aks.practice.spring.UserException;
import com.aks.practice.spring.entity.GenericException;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {
    Logger logger = LoggerFactory.getLogger(ControllerAdvice.class);

	@ExceptionHandler(UserException.class)
	private ResponseEntity<GenericException> handleException(UserException ex) {
		logger.error("UserException occured : {}",ex.getCause());
		return ResponseEntity.ok( new GenericException(ex.getHttpCode(), ex.getMessage()));
	}
	
	@ExceptionHandler(Exception.class)
	private ResponseEntity< GenericException> handleException(Exception ex) {
		logger.error("Exception occured {}",ex);
		return ResponseEntity.ok( new GenericException(404, "Resource not found"));
	}
	@ExceptionHandler(Throwable.class)
	private ResponseEntity< GenericException> handleException(Throwable ex) {
		logger.error("Exception occured {}",ex);
		return ResponseEntity.ok( new GenericException(404, "Error occured."));
	}

}
