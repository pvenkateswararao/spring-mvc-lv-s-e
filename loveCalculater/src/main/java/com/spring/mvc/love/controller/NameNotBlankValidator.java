package com.spring.mvc.love.controller;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.spring.mvc.love.custom.Annotations.NameNotBlank;

public class NameNotBlankValidator implements ConstraintValidator<NameNotBlank, String>{

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		if(value==null || value.isEmpty()) {
			return false;
		}
		return true;
	}

}
