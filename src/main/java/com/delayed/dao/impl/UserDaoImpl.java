package com.delayed.dao.impl;

import java.util.List;

import com.delayed.dao.UserDao;
import com.delayed.mapper.UserMapper;
import com.delayed.model.UserModel;

public class UserDaoImpl extends ConnectionImpl<UserModel> implements UserDao {

	@Override
	public UserModel login(String username, String password) {
		StringBuilder sql = new StringBuilder("SELECT * FROM user ");
		sql.append(" WHERE username = ? AND password = ?");
		List<UserModel> users = query(sql.toString(), new UserMapper(), username, password);
		return users.isEmpty() ? null : users.get(0);
	}

}
