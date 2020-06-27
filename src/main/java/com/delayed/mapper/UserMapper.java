package com.delayed.mapper;

import java.sql.ResultSet;

import com.delayed.model.RoleModel;
import com.delayed.model.UserModel;

public class UserMapper implements RowMapper<UserModel> {

	@Override
	public UserModel mapRow(ResultSet rs) {
		try {
			UserModel user = new UserModel();
			user.setId(rs.getInt("id"));
			user.setUsername(rs.getString("username"));
			user.setFullName(rs.getString("fullname"));
			user.setPassword(rs.getString("password"));
			user.setEmail(rs.getString("email"));
			user.setCreated(rs.getTimestamp("created"));
			user.setCreatedBy(rs.getString("createdBy"));
			user.setCreated(rs.getTimestamp("updated"));
			user.setCreatedBy(rs.getString("updatedBy"));
			user.setRoleId(rs.getInt("role"));
			return user;
		} catch (Exception e) {
			return null;
		}
	}

}
