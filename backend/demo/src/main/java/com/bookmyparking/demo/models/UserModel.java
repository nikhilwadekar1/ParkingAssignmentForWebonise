package com.bookmyparking.demo.models;

import com.bookmyparking.demo.entities.UserInfo;

public class UserModel {
	private int userId;

	private String city;

	private String contactNo;

	private String email;

	private String password;

	private String userName;

	private float walletBalance;
	
	private boolean isLoggedIn;

	public UserModel(int userId, String city, String contactNo, String email, String password, String userName,
			float walletBalance, boolean isLoggedIn) {
		this.userId = userId;
		this.city = city;
		this.contactNo = contactNo;
		this.email = email;
		this.password = password;
		this.userName = userName;
		this.walletBalance = walletBalance;
		this.isLoggedIn = isLoggedIn;
	}
	
	public UserModel() {
	}
	
	public UserModel(UserInfo userinfo, boolean isLoggedIn) {
		this.userId = userinfo.getUserId();
		this.city = userinfo.getCity();
		this.contactNo = userinfo.getContactNo();
		this.email = userinfo.getEmail();
		this.password = userinfo.getPassword();
		this.userName = userinfo.getUserName();
		this.walletBalance = userinfo.getWalletBalance();
		this.isLoggedIn = isLoggedIn;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public float getWalletBalance() {
		return walletBalance;
	}

	public void setWalletBalance(float walletBalance) {
		this.walletBalance = walletBalance;
	}

	public boolean isLoggedIn() {
		return isLoggedIn;
	}

	public void setLoggedIn(boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}
	

}
