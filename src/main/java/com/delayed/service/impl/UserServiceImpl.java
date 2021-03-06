/**
 * 
 */
package com.delayed.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.delayed.common.Constant;
import com.delayed.dao.UserDao;
import com.delayed.model.RoleModel;
import com.delayed.model.UserModel;
import com.delayed.service.UserService;

public class UserServiceImpl implements UserService {

	@Inject
	private UserDao userDAO;

	@Override
	public UserModel login(String username, String password) {
		UserModel loginUser = userDAO.login(username, password);
		if(loginUser != null && loginUser.getRoleId() != null) {			
			RoleModel role = userDAO.getRoleById(loginUser.getRoleId());
			loginUser.setRole(role);
		}
		return loginUser;
	}

	@Override
	public UserModel findOneById(Integer id) {
		return userDAO.findOneById(id);
	}

	@Override
	public UserModel registration(String username, String password, String email) {
		UserModel userExist = userDAO.findOneByUsernameAndEmail(username, email);
		if(userExist != null) {
			return null;
		}
		Integer id = userDAO.registration(username, password, email);
		return userDAO.findOneById(id);
	}

	@Override
	public List<UserModel> getAllUser() {
		List<UserModel> users = userDAO.getAllUser();
		for (UserModel user : users) {
			if (user.getRoleId() != null) {
				RoleModel role = userDAO.getRoleById(user.getRoleId());
				user.setRole(role);
			}
		}
		return users;
	}

	@Override
	public String deleteUserById(Integer id, UserModel currentUser) {
		if (currentUser.getId().equals(id)) {
			return Constant.USER_CURRENT;
		}
		userDAO.deletUserById(id);
		return Constant.DELETE_SUCCESS;
	}

	@Override
	public void changeProfile(UserModel user) {
		userDAO.updateProfile(user);
	}

}
