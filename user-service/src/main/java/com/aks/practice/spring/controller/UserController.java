package com.aks.practice.spring.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.aks.practice.spring.UserException;
import com.aks.practice.spring.entity.User;
import com.aks.practice.spring.service.IUserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class UserController {

	IUserService userservice;
	public UserController(IUserService userservice) {
		this.userservice=userservice;		
	}
	@GetMapping("/users")
	public  List<User> getAllUsers(){
		return  userservice.getAllUsers();
	}
	@GetMapping("/users/{id}")
	public  User getUser(@PathVariable Integer id){
		return  userservice.getUser(id);
	}
	
	@PostMapping("/users")
	public ResponseEntity<User>  createUser(@RequestBody User user) {
		WebMvcLinkBuilder link= WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllUsers());
		User savedUser= userservice.saveUser(user);
		//EntityModel<User> entityModal = EntityModel.of(savedUser);
		//return  entityModal..add(link.withRel("all-users"));
		return ResponseEntity.created(
	    		ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
	    		.buildAndExpand(savedUser.getId()).toUri()).build();
		 
	}
	
	@DeleteMapping("/users")
	public void deleteUser(@RequestBody Integer id) {
			userservice.deleteUser(id);	
		}
	
	@PutMapping("/users")
	public EntityModel<User>  updateUser(@RequestBody User user) {
		WebMvcLinkBuilder link= WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllUsers());
		User savedUser= userservice.updateUser(user);
		EntityModel<User> entityModal = EntityModel.of(savedUser);
		return entityModal.add(link.withRel("all-users"));
	}
	
}
