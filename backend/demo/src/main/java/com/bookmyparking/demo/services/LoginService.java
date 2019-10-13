package com.bookmyparking.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookmyparking.demo.entities.UserInfo;
import com.bookmyparking.demo.models.LoginModel;
import com.bookmyparking.demo.models.Message;
import com.bookmyparking.demo.models.UserModel;
import com.bookmyparking.demo.repositories.LoginRepository;

@Service
public class LoginService {
	@Autowired
	LoginRepository loginRepo;

	public UserModel login(LoginModel loginData) {
//		UserModel loggedInUser = new UserModel();
		UserInfo user = this.loginRepo.findByUserName(loginData.getUserName());
		if (user != null) {
			if (user.getPassword().equals(loginData.getPassword())) {
				return new UserModel(user, true);
			}else {
				user.setUserName("Invalid login credentials!");
				return new UserModel(user, false);
			}
		} else {
			UserInfo invalidUser = new UserInfo();
			invalidUser.setUserName("Invalid user name!");
			return new UserModel(invalidUser, false);
		}

	}
}
