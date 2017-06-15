package iful.edu.practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import iful.edu.practice.model.Item;
import iful.edu.practice.service.ItemService;

@Controller
@RequestMapping(value = "/item")
public class ItemController {

	@Autowired
	private ItemService itemService;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addItemPage() {
		ModelAndView modelAndView = new ModelAndView("add-item-form");
		modelAndView.addObject("item", new Item());
		return modelAndView;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView addingItem(@ModelAttribute Item item) {

		ModelAndView modelAndView = new ModelAndView("home");
		itemService.addItem(item);

		String message = "Item was successfully added.";
		modelAndView.addObject("message", message);

		return modelAndView;
	}

	@RequestMapping(value = "/list")
	public ModelAndView listOfItems() {
		ModelAndView modelAndView = new ModelAndView("list-of-items");

		List<Item> items = itemService.getItems();
		modelAndView.addObject("items", items);

		return modelAndView;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editItemPage(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("edit-item-form");
		Item item = itemService.getItem(id);
		modelAndView.addObject("item", item);
		return modelAndView;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public ModelAndView edditingItem(@ModelAttribute Item item, @PathVariable Integer id) {

		ModelAndView modelAndView = new ModelAndView("home");

		itemService.updateItem(item);

		String message = "Item was successfully edited.";
		modelAndView.addObject("message", message);

		return modelAndView;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteItem(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("home");
		itemService.deleteItem(id);
		String message = "Item was successfully deleted.";
		modelAndView.addObject("message", message);
		return modelAndView;
	}

}