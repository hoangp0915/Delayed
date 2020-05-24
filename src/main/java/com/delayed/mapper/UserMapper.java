package com.delayed.mapper;

import java.sql.ResultSet;

import com.delayed.model.UserModel;

public class UserMapper implements RowMapper<UserModel> {

	@Override
	public UserModel mapRow(ResultSet rs) {
		try {
			UserModel user = new UserModel();
			user.setId(rs.getInt("id"));
			return null;
			
		} catch (Exception e) {
			return null;
		}
	}

}
