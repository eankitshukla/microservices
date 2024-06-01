package com.aks.practice.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aks.practice.spring.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
}
