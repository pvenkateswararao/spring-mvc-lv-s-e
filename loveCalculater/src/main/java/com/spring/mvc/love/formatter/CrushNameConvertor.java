package com.spring.mvc.love.formatter;

import org.springframework.core.convert.converter.Converter;

import com.spring.mvc.love.entity.UserDetails;

public class CrushNameConvertor implements Converter<String, UserDetails> {

	@Override
	public UserDetails convert(String source) {
		String s = source.toUpperCase();
		UserDetails us = new UserDetails();
		us.setCrushName(s);
		return us;
	}

}
