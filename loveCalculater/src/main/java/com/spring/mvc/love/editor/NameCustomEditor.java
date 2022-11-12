package com.spring.mvc.love.editor;

import java.beans.PropertyEditorSupport;

public class NameCustomEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		String s = text.toUpperCase();
		setValue(s);
	}
}