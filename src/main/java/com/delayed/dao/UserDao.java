package com.delayed.dao;

import com.delayed.model.UserModel;

public interface UserDao {
	UserModel login(String username, String password);
	
	UserModel findOneById(Integer id);
}
