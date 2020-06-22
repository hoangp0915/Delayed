package com.delayed.dao.impl;

import java.util.List;

import com.delayed.common.Constant;
import com.delayed.dao.UserDao;
import com.delayed.mapper.RoleMapper;
import com.delayed.mapper.UserMapper;
import com.delayed.model.RoleModel;
import com.delayed.model.UserModel;

public class UserDaoImpl extends ConnectionImpl<UserModel> implements UserDao {

	@Override
	public UserModel login(String username, String password) {
		StringBuilder sql = new StringBuilder("SELECT * FROM user ");
		sql.append(" WHERE username = ? AND password = ?");
		List<UserModel> users = query(sql.toString(), new UserMapper(), username, password);
		return users.isEmpty() ? null : users.get(0);
	}

	@Override
	public UserModel findOneById(Integer id) {
		String sql = "SELECT * FROM user WHERE id=?";
		List<UserModel> users = query(sql, new UserMapper(), id);
		return users.isEmpty() ? null : users.get(0);
	}

	@Override
	public Integer registration(String username, String password, String email) {
		StringBuilder sql = new StringBuilder("INSERT INTO user (username, password, email, role)");
		sql.append(" VALUES (?, ?, ?, ?)");
		return insert(sql.toString(), username, password, email, Constant.ROLE_MEMBER);
	}

	@Override
	public List<UserModel> getAllUser() {
		String sql = "SELECT * FROM user";
		return query(sql, new UserMapper());
	}

	@Override
	public RoleModel getRoleById(Integer id) {
		String sql = "SELECT * FROM role WHERE id=?";
		List<RoleModel> listRole = query(sql, new RoleMapper(), id);
		return listRole.isEmpty() ? null : listRole.get(0);
	}

	@Override
	public void deletUserById(Integer id) {
		String sql = "DELETE FROM user WHERE id=" + id;
		update(sql);
	}

	@Override
	public UserModel findOneByUsernameAndEmail(String username, String email) {
		String sql = "SELECT * FROM user WHERE username=? OR email=?";
		List<UserModel> users = query(sql, new UserMapper(), username, email);
		return users.isEmpty() ? null : users.get(0);
	}

}
