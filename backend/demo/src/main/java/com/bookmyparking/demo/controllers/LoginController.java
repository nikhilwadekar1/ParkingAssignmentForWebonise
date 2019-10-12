package com.bookmyparking.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookmyparking.demo.models.LoginModel;
import com.bookmyparking.demo.models.Message;
import com.bookmyparking.demo.services.LoginService;

//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "*")
@RestController
public class LoginController {
	@Autowired
	LoginService loginService;
	
	@RequestMapping("/login")
	public Message login(@RequestBody LoginModel loginModel) {
		System.out.println(loginModel.getUserName());
		return this.loginService.login(loginModel);
	}
}
