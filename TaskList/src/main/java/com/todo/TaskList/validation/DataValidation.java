package com.todo.TaskList.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.todo.TaskList.Repository.UserRepository;
import com.todo.TaskList.model.User;


@Component
public class DataValidation implements Validator {

	@Autowired
	public UserRepository userRepository;

	String emailRegex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";


	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	public void validate(Object o, Errors errors) {
		User user = (User) o;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "NotEmpty");

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty");
		if (userRepository.findByEmail(user.getEmail()) !=null) {
			errors.rejectValue("email", "size.user.unique");
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
		if (user.getPassword().length() <=0  ||  user.getPassword().length() < 4) {
			errors.rejectValue("password", "size.user.password");
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "repeatpass", "NotEmpty");
		if (!user.getRepeatpass().equals(user.getPassword())) {
			errors.rejectValue("repeatpass", "match.user.repeatpass");
		}

		if (!user.getEmail().matches(emailRegex)) {
			errors.rejectValue("email", "size.user.email");
		}

		

	}

	public void validateUpdate(Object o, Errors errors) {
		User user = (User) o;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "NotEmpty");

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
		if (user.getPassword().length() <=0  ||  user.getPassword().length() < 4) {
			errors.rejectValue("password", "size.user.password");
		}

		

	}
}
