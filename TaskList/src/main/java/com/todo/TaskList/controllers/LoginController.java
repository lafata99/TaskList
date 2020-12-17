package com.todo.TaskList.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.todo.TaskList.Repository.UserRepository;
import com.todo.TaskList.model.User;
import com.todo.TaskList.service.UserServiceImpl;
import com.todo.TaskList.validation.DataValidation;

@Controller 
@SessionAttributes("loggedInUser")
public class LoginController {
	
	@Autowired
	private UserServiceImpl userService;
	
	
	private UserRepository userRepository;
	
	@Autowired
	private DataValidation dataValidation;

	
	
	
	public LoginController(UserServiceImpl userService, UserRepository userRepository, DataValidation dataValidation) {
		super();
		this.userService = userService;
		this.userRepository = userRepository;
		this.dataValidation = dataValidation;
	}

	@GetMapping("profile")
	public String profile(Model model) {
		model.addAttribute("msg", "Welcome Back");
		
		return "profile";
	}
	
	@PostMapping("profile")
	public String update(@ModelAttribute User user, @RequestParam long id, Model model) {
		
		
		User user1 = userRepository.findById(id).get();
		user1.setFirstName(user.getFirstName());
		user1.setLastName(user.getLastName());
		user1.setUsername(user.getUsername());
		user1.setEmail(user.getEmail());
		user1.setPassword(user.getPassword());
		userRepository.save(user1);
		model.addAttribute("loggedInUser", user1);
		return "profile";
	}
	
	@GetMapping("login")
	public String login(Model model) {
		model.addAttribute("msg", "Login");
		return "login";
	}
	
	@GetMapping("users")
	public String users(Model model) {
		model.addAttribute("msg", "All Users");
		model.addAttribute("alldb", userRepository.findAll());
		return "users";
	}
	
	@PostMapping("login")
	public String signin(@RequestParam String email, @RequestParam String password, Model model) {
		
		User user = userRepository.findByEmail(email);
		if(user != null && password.equals(user.getPassword())) {
			model.addAttribute("msg", "Welcome " + user.getFirstName() + " " + user.getLastName());
			model.addAttribute("loggedInUser", user);
		} else {
			model.addAttribute("error", "Invalid Credentials");
			return "login";
		}
		
		return "redirect:/tasks";
		
	}
	
	@GetMapping("logout")
	public String logout(Model model, WebRequest request, SessionStatus status, RedirectAttributes redirect) {
		
		status.setComplete();
		request.removeAttribute("loggedInUser", WebRequest.SCOPE_SESSION);
		redirect.addFlashAttribute("msg", "You have been signed out");
		return "redirect:/login";
	}
	
	@GetMapping("register")
	public String register(Model model) {
		model.addAttribute("msg", "Register");
		model.addAttribute("hidden", "");
		model.addAttribute("user", new User());
		model.addAttribute("action", "register");
		return "register";
	}
	
	
	@PostMapping("register")
	public String register(@ModelAttribute User user, Model model, BindingResult result, RedirectAttributes redirect) {
		
		try {
			dataValidation.validate(user, result);
			if (result.hasErrors()) {
				model.addAttribute("error", "Required* fields");
				model.addAttribute("hidden", "");
				model.addAttribute("action", "register");
				return "register";
			}
			
			user.setRole("USER");
			userRepository.save(user);
			redirect.addFlashAttribute("success", "User " + user.getFirstName() + " saved");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/profile";
	}
	
	@PostMapping("editrole")
	public String editRole(RedirectAttributes model, @RequestParam long id, @RequestParam String role) {
		User user = userRepository.findById(id).get();
		
		if(user != null) {
			user.setRole(role);
			userRepository.save(user);
			model.addFlashAttribute("success", "Role Updated");
		}
		
		return "redirect:/user";
		
	}
	
	@GetMapping("deleteuser")
	public String deleteUser(@RequestParam long id, RedirectAttributes redirect) {
		userRepository.deleteById(id);
		redirect.addFlashAttribute("success", "Delete Success");
		return "redirect:/users";
	}
	
	
	@ModelAttribute("user")
	User user() {
		return new User();
	}

}
