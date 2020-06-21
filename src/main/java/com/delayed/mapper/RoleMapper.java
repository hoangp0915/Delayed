package com.delayed.mapper;

import java.sql.ResultSet;

import com.delayed.model.RoleModel;

public class RoleMapper implements RowMapper<RoleModel> {

	@Override
	public RoleModel mapRow(ResultSet rs) {
		try {
			RoleModel role = new RoleModel();
			role.setCode(rs.getString("code"));
			role.setName(rs.getString("name"));
			role.setId(rs.getInt("id"));
			return role;
		} catch (Exception e) {
			return null;
		}
	}

}
