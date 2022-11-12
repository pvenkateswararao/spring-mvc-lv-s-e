package com.spring.mvc.love.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import com.spring.mvc.love.entity.FullName;

public class NameFormatter implements Formatter<FullName> {

	@Override
	public String print(FullName object, Locale locale) {
		String s = object.getFirstName()+" "+object.getLastName();
		return s;
	}

	@Override
	public FullName parse(String text, Locale locale) throws ParseException {
		System.out.println("parse function in NameFortmatter");
		String s[] = text.split(" ");
		FullName name= new FullName();
		name.setFirstName(s[0]);
		name.setLastName(s[1]);
		return name;
	}
}
