package com.aks.practice.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class WelcomeController {
	
	@GetMapping("/hello/{data}")
	public String sayHello(@PathVariable(value = "data") String name ) {
		return "Hello " +name;	
	}

}
