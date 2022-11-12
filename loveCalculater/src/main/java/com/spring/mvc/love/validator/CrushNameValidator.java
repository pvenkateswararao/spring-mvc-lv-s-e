package com.spring.mvc.love.validator;

import javax.validation.Validation;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.spring.mvc.love.entity.UserDetails;

public class CrushNameValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return UserDetails.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		String s = ((UserDetails)target).getCrushName();
		if(s==null || s.isEmpty()) {
			errors.rejectValue("crushName", "crushName.Empty", "CrushName custom Validator");
		}
		
	}

}
