package com.bookmyparking.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookmyparking.demo.entities.UserInfo;
import com.bookmyparking.demo.models.LoginModel;
import com.bookmyparking.demo.models.Message;
import com.bookmyparking.demo.repositories.LoginRepository;

@Service
public class LoginService {
	@Autowired
	LoginRepository loginRepo;
	
	public Message login(LoginModel loginData) {
		UserInfo user = this.loginRepo.findByUserName(loginData.getUserName());
		if(user != null) {
			if(user.getPassword().equals(loginData.getPassword())){
				return new Message("Login Successful!", "alert-success");
			}	
		}else {
			return new Message("Invalid user name!", "alert-danger");	
		}
		return new Message("Invalid login credentials!", "alert-danger");
	}
}
