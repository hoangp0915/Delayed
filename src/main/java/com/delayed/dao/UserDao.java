package com.delayed.dao;

import java.util.List;

import com.delayed.model.RoleModel;
import com.delayed.model.UserModel;

public interface UserDao {
	UserModel login(String username, String password);
	
	UserModel findOneById(Integer id);
	
	UserModel findOneByUsernameAndEmail(String username, String email);
	
	Integer registration(String username, String password, String email);
	
	List<UserModel> getAllUser();
	
	RoleModel getRoleById(Integer id);
	
	void deletUserById(Integer id);
	
	void updateProfile(UserModel user);
}
