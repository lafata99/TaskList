package com.todo.TaskList.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.todo.TaskList.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	@Query("FROM User WHERE lname=?1")
	List<User> findByLastName(String lname);
	
	@Query("FROM User WHERE lname=?1 or fname=?1")
	List<User> findByName(String name);
	
	@Query("FROM User WHERE email=?1")
	Optional<User> findEmail(String email);
	
	@Query("FROM User WHERE email=?1 AND password=?2")
	Optional<User> login(String email, String password);

	User findByEmail(String email);



	

}
