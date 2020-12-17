package com.todo.TaskList.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.todo.TaskList.Repository.TodoRepository;
import com.todo.TaskList.model.Task;
import com.todo.TaskList.model.User;

import org.springframework.beans.factory.annotation.Autowired;


@Controller
public class TodoController {
	
	private TodoRepository todoRepository;
	
	
	@Autowired
	public TodoController(TodoRepository todoRepository) {
		super();
		this.todoRepository = todoRepository;
	}
	
	@GetMapping("tasks")
	public String tasks(Model model) {
		model.addAttribute("msg", "All Tasks");
		model.addAttribute("tasks", todoRepository.findAll());
		return "tasks";
	}
	  
	
	@GetMapping("newtask")
		public String newtask(Model model) {
			model.addAttribute("msg", "New Task");
			model.addAttribute("hidden", "");
			model.addAttribute("task", new Task());
			model.addAttribute("action", "newtask");
			return "newtask";
		}
	
	@PostMapping("newtask")
	public String newtask(@ModelAttribute Task task, Model model, BindingResult result, RedirectAttributes redirect) {
		
		todoRepository.save(task);
		return "redirect:/tasks";
	}
	
	 @GetMapping("delete")
		public String delete(@RequestParam long id, RedirectAttributes redirect) {
			todoRepository.deleteById(id);
			redirect.addFlashAttribute("success", "Delete Success");
			return "redirect:/tasks";
		}
	 
	 @GetMapping("edit/{id}")
	 public String edit(@PathVariable(name="id") long id, Model model) {
		 System.out.println(id);
		 todoRepository.findById(id);
		 model.addAttribute("msg", "Edit");
		 model.addAttribute("task", todoRepository.findById(id));
		 model.addAttribute("hidden", "hidden");
		 model.addAttribute("action", "edit");
		 model.addAttribute("id", id);
		 return "redirect:/edit";
	 }
	
	@PostMapping("edit")
	public String edit(@ModelAttribute Task task, @RequestParam long id, Model model) {
		System.out.println(task);
		System.out.println(id);
		Task task1 = todoRepository.findById(task.getId()).get();
		 task1.setStatus(task.getStatus());
		 todoRepository.save(task1);
		 model.addAttribute("task", task1);
		return "redirect:/tasks";
	}
	
}
