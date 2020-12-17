package com.todo.TaskList.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todo.TaskList.model.Task;

public interface TodoRepository extends JpaRepository<Task, Long>{

}
