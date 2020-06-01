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
//			try {
//				RoleModel role = new RoleModel();
//				role.setCode(rs.getString("code"));
//				role.setName(rs.getString("name"));
//				user.setRole(role);
//			} catch (Exception e) {
//				System.out.print(e.getMessage());
//			}
			return user;

		} catch (Exception e) {
			return null;
		}
	}

}
