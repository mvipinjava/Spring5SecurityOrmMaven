package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.model.User;
import com.app.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService service;
	
	
	//1. Show User Register page
	@RequestMapping("/reg")
	public String showReg(ModelMap map) {
		//Form Backing Object
		map.addAttribute("user", new User());
		return "UserRegister";
	}
	
	
	//2. On submit - User Save 
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveUser(
			@ModelAttribute User user,
			ModelMap map) 
	{
		//call service layer to save
		Integer id=service.saveUser(user);
		map.addAttribute("message", "User '"+id+"' saved");
		//clean Form Backing Object
		map.addAttribute("user", new User());
		return "UserRegister";
	}
	
	
}