package com.todo.TaskList.service;

import java.util.List;

import com.todo.TaskList.model.Task;

public interface TodoService {
	void delete(Long id);
	
	List<Task> findAll();
	
	void save(Task Task);
}
