package com.spring.mvc.love.custom.Annotations;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.spring.mvc.love.controller.NameNotBlankValidator;

@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = {NameNotBlankValidator.class})
public @interface NameNotBlank {

	String message() default "* required field";
	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
}
