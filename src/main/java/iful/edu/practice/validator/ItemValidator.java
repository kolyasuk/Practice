package iful.edu.practice.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import iful.edu.practice.model.Item;

@Component
public class ItemValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz == Item.class;
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty.itemForm.name");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "photo", "NotEmpty.itemForm.photo");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "NotEmpty.itemForm.description");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "NotEmpty.itemForm.price");

	}

}