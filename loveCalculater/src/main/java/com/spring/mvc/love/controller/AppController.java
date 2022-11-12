package com.spring.mvc.love.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.spring.mvc.love.DAO.StudentDAO;
import com.spring.mvc.love.DAO.StudentDAOimpl;
import com.spring.mvc.love.entity.EmailDetails;
import com.spring.mvc.love.entity.UserDetails;

@Controller
@SessionAttributes({"userDetails"})
public class AppController{

	@Autowired
	StudentDAO std;
	
	@RequestMapping("/home")
	public String home(Model model) throws IOException{
		System.out.println("In home Controller");
		model.addAttribute("userDetails", new UserDetails());
		try {
			//std.insert();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		if(false)
			throw new IOException("check global error");
		
		
		return "inputForm";
	}
	
	@RequestMapping("/calculate-love")
	public String calculate(@Valid UserDetails userDetails, BindingResult results, Model model) {
		//to display error
		model.addAttribute(BindingResult.MODEL_KEY_PREFIX+"userDetails", results);
		if(results.hasErrors()) {
			for(ObjectError e : results.getAllErrors()) {
				System.out.println("Error : "+e.getDefaultMessage());
			}
			return "inputForm";
		}
		//model.addAttribute("userDetails",userDetails);
		model.addAttribute("results","friends");
		return "showResults";
	}
	
	
	/*
	//Path Variable method
	@RequestMapping("/send-mail-input/{pathVar}")
	public String sendMailForm(@Valid @ModelAttribute("emailDetails") EmailDetails emailDetails, @PathVariable("pathVar") String uName, BindingResult results, Model model) {	
		System.out.println("Path var - "+uName);
		model.addAttribute("uName",uName);
		return "emailInput";
	}
	*/
	
	@RequestMapping("/send-mail-input")
	public String sendMailForm(@Valid @ModelAttribute("emailDetails") EmailDetails emailDetails, BindingResult results, Model model) {	
		return "emailInput";
	}
	
	@RequestMapping("/send-mail")
	public String sendMail(@Valid @ModelAttribute("emailDetails") EmailDetails emailDetails, BindingResult results, Model model) {
		return "sendMail";
	}
	
	@InitBinder
	public void init(WebDataBinder dataBinder) {
		//NameCustomEditor ed = new NameCustomEditor();
		//dataBinder.registerCustomEditor(String.class, "userName", ed);
		
		
		
		//CrushNameValidator cv = new CrushNameValidator();
		//dataBinder.setValidator(cv);
	}
	
}
