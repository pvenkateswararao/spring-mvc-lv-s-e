package com.spring.mvc.love.global;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalFunctions {

	@ExceptionHandler(value = Exception.class)
	public String anyExceptionHandler() {
		return "errorPage";
	}
	
	//can also use @InitBinder and @ModelAttribute for controllerAdvice for global scope
}
