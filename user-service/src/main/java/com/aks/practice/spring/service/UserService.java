package com.aks.practice.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.aks.practice.spring.UserException;
import com.aks.practice.spring.entity.User;
import com.aks.practice.spring.repository.UserRepository;

@Service	
public class UserService implements IUserService {

	UserRepository userRepository;
	public UserService(UserRepository userRepository) {
		this.userRepository= userRepository;	
	}
	@Override
	public List<User> getAllUsers() {

		return userRepository.findAll();
	}
	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}
	
	@Override
	public void deleteUser(Integer id) {
		userRepository.deleteById(id);
	}
	@Override
	public User updateUser(User user) {
		return userRepository.save(user);
	}
	@Override
	public User getUser(Integer id) {
 Optional<User> user=   userRepository.findById(id);
	//user.ifPresent(data->System.out.println(data));
	if (user.isEmpty()) {
		throw new UserException(403, "Bad Request! User does not exist. ");
	}
	else {
		return user.get();
		}
	}
	
}
