package com.todo.TaskList.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.todo.TaskList.Repository.TodoRepository;
import com.todo.TaskList.model.Task;

public class TodoServiceImpl implements TodoService{
	
	private TodoRepository todoRepository;
	
	
	@Autowired
	public TodoServiceImpl(TodoRepository todoRepository) {
		super();
		this.todoRepository = todoRepository;
	}

	@Override
	public void delete(Long id) {
		todoRepository.deleteById(id);
	}

	@Override
	public List<Task> findAll() {
		// TODO Auto-generated method stub
		return todoRepository.findAll();
	}

	@Override
	public void save(Task task) {
		// TODO Auto-generated method stub
		todoRepository.save(task);
	}

}
