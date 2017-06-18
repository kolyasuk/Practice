package iful.edu.practice.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import iful.edu.practice.model.User;
import iful.edu.practice.service.UserService;

@Component
public class UserValidator implements Validator {

	@Autowired
	private UserService userService;

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(User.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		User user = (User) target;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "NotEmpty.userForm.login");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty.userForm.name");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty.userForm.email");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty.userForm.password");

		if (user.getLogin().length() < 6 || user.getLogin().length() > 16) {
			errors.rejectValue("login", "Size.userForm.login");
		}

		if (user.getName().length() < 5 || user.getName().length() > 50) {
			errors.rejectValue("name", "Size.userForm.name");
		}

		if (user.getEmail().length() < 5 || user.getName().length() > 50) {
			errors.rejectValue("email", "Size.userForm.email");
		}
		if (user.getPassword().length() < 5) {
			errors.rejectValue("password", "Size.userForm.password");
		}

		/*
		 * if (userService.getUserByLogin(user.getLogin()) != null) {
		 * errors.rejectValue("login", "Duplicate.userForm.login"); }
		 */

		/*
		 * String login = user.getLogin(); if (login != null && login.length() >
		 * 0) { User otherUser = userService.getUserByLogin(login); if
		 * (otherUser != null) { errors.rejectValue("login",
		 * "Duplicate.userForm.login"); } }
		 */
	}
}