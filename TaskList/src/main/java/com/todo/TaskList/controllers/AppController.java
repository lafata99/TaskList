package com.todo.TaskList.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.todo.TaskList.model.User;
import com.todo.TaskList.service.UserServiceImpl;
import com.todo.TaskList.utils.WebUtils;



public class AppController {

	@Autowired
	private UserServiceImpl userService;
	
	@Autowired
	WebUtils webUtils;
	
	@GetMapping("index")
	public String index(Model model){
		model.addAttribute("message", "Hello There");
		model.addAttribute("all", userService.findAll());
		return "index";
	}
	
	
	//Return about
	@GetMapping("about")
	public String about(Model model) {
		model.addAttribute("about", "This is the about page");
		return "about";
	}
	
	//Return services
	@GetMapping("services")
	public String services(Model model) {
		model.addAttribute("services", "These are our services");
		return "services";
	}
	
	
	@PostMapping("sendemail")
	public String sendEmail(Model model, @RequestParam String email, @RequestParam String name, @RequestParam String subject, @RequestParam String message) {
		webUtils.sendMail(email, message, subject + " " + name);
		model.addAttribute("message", "Email Sent!");
		return "services";
	}
	
	@GetMapping("name")
	public String name(@RequestParam String id, Model model) {
		index(model);
		model.addAttribute("myname", id);
		return "index";
	}
	
	@ModelAttribute("user")
	User user() {
		return new User();
	}
}
