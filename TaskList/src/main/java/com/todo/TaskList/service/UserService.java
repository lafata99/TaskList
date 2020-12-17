package com.todo.TaskList.service;

import java.util.List;
import java.util.Optional;

import com.todo.TaskList.model.User;


public interface UserService {
	Optional<User> findById(Long id);
	
	Optional<User> findEmail(String email);
	
	Optional<User> login (String email, String password);
	
	List<User> findByLastName(String lname);
	
	List<User> findByName(String name);
	
	List<User> findAll();
	
	void delete(Long id);
	
	void updateUser(User user, Long id);
	
	void updateRole(String role, Long id);
	
	void resetPassword(String password, Long id);
	
	void save(User user);
}
