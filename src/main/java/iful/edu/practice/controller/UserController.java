package iful.edu.practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import iful.edu.practice.model.User;
import iful.edu.practice.service.UserService;
import iful.edu.practice.validator.UserValidator;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private UserValidator userValidator;

	@Autowired
	private UserService userService;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(userValidator);
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addUserPage() {
		ModelAndView modelAndView = new ModelAndView("reg");
		modelAndView.addObject("user", new User());
		return modelAndView;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addingUser(@Validated @ModelAttribute User user, BindingResult result, Model model, final RedirectAttributes redirectAttributes) {
		userValidator.validate(user, result);
		if (result.hasErrors()) {
			return "reg";
		}
		userService.addUser(user);
		return "reg-success";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView listOfUsers() {
		ModelAndView modelAndView = new ModelAndView("list-of-users");

		List<User> users = userService.getUsers();
		modelAndView.addObject("users", users);

		return modelAndView;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editUserPage(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("edit-user-form");
		User user = userService.getUserById(id);
		modelAndView.addObject("user", user);
		return modelAndView;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public ModelAndView edditingUser(@ModelAttribute User user, @PathVariable Integer id) {

		ModelAndView modelAndView = new ModelAndView("home");

		userService.updateUser(user);

		String message = "User was successfully edited.";
		modelAndView.addObject("message", message);

		return modelAndView;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteUser(@PathVariable Integer id) {
		userService.deleteUser(id);
		ModelAndView modelAndView = new ModelAndView("home");
		String message = "User was successfully deleted.";
		modelAndView.addObject("message", message);
		return modelAndView;
	}

}