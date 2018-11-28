package com.muditasoft.thymeleaftutorial.validations;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.muditasoft.thymeleaftutorial.models.User;

public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return User.class.equals(arg0);
	}

	@Override
	public void validate(Object user, Errors e) {
		User userModel = (User) user;
		if(!userModel.getPassword().equals(userModel.getRepeatPassword())) {
			e.rejectValue("repeatPassword", "PasswordsDontMatch");
		}
	}

}
