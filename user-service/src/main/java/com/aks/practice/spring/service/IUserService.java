package com.aks.practice.spring.service;

import java.util.List;
import java.util.Optional;

import com.aks.practice.spring.entity.User;

public interface IUserService {
	
	User getUser(Integer id);

	List<User> getAllUsers();

	User saveUser(User user);

	void deleteUser(Integer id);

	User  updateUser(User user);


}
