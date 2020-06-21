package com.delayed.service;

import com.delayed.model.UserModel;

public interface UserService {
	UserModel login(String username, String password);
	
	UserModel findOneById(Integer id);
	
	UserModel registration(String username, String password, String email);
}
