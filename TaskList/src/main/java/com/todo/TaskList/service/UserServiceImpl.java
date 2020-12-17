package com.todo.TaskList.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.TaskList.Repository.UserRepository;
import com.todo.TaskList.model.User;


@Service
public class UserServiceImpl implements UserService {
	
	
	private UserRepository userRepository;
	
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public Optional<User> findEmail(String email) {
		// TODO Auto-generated method stub
		return userRepository.findEmail(email);
	}

	@Override
	public List<User> findByLastName(String lname) {
		// TODO Auto-generated method stub
		return userRepository.findByLastName(lname);
	}

	@Override
	public Optional<User> findById(Long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id);
	}

	@Override
	public Optional<User> login(String email, String password) {
		// TODO Auto-generated method stub
		return userRepository.login(email, password);
	}

	@Override
	public List<User> findByName(String name) {
		// TODO Auto-generated method stub
		return userRepository.findByName(name);
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		userRepository.deleteById(id);
		
	}

	@Override
	public void updateUser(User user, Long id) {
		// TODO Auto-generated method stub
		userRepository.findById(id).ifPresent(a->{
			a.setFirstName(user.getFirstName());
			a.setLastName(user.getLastName());
			}
		);
	}

	@Override
	public void updateRole(String role, Long id) {
		// TODO Auto-generated method stub
		userRepository.findById(id).ifPresent(a->{
			a.setRole(role);
		});
	}

	@Override
	public void resetPassword(String password, Long id) {
		userRepository.findById(id).ifPresent(a->{
			a.setPassword(password);
		});
		
	}

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		userRepository.save(user);
	}
}
