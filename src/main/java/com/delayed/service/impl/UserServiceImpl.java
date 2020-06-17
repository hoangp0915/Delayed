/**
 * 
 */
package com.delayed.service.impl;

import javax.inject.Inject;

import com.delayed.dao.UserDao;
import com.delayed.model.UserModel;
import com.delayed.service.UserService;

/**
 * @author hoang
 *
 */
public class UserServiceImpl implements UserService{

	@Inject
	private UserDao userDAO;
	
	@Override
	public UserModel login(String username, String password) {
		return userDAO.login(username, password);
	}

	@Override
	public UserModel findOneById(Integer id) {
		return userDAO.findOneById(id);
	}

}
