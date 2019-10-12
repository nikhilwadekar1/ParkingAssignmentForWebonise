package com.bookmyparking.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.bookmyparking.demo.entities.UserInfo;

public interface LoginRepository extends CrudRepository<UserInfo, Integer> {
	public UserInfo findByUserName(String userName);
}
