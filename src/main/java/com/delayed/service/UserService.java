package com.delayed.service;

import com.delayed.model.UserModel;

public interface UserService {
	UserModel login(String username, String password);
}
