/**
 * 
 */
package com.delayed.mapper;

import java.sql.ResultSet;

import com.delayed.model.CategoryModel;

/**
 * @author hoang
 *
 */
public class CategoryMapper implements RowMapper<CategoryModel> {

	@Override
	public CategoryModel mapRow(ResultSet rs) {
		try {
			CategoryModel cat = new CategoryModel();
			cat.setId(rs.getInt("id"));
			cat.setName(rs.getString("name"));
			cat.setParent(rs.getInt("parent"));
			if (rs.getTimestamp("updated") != null) {
				cat.setUpdated(rs.getTimestamp("updated"));
			}
			if (rs.getString("updated_by") != null) {
				cat.setUpdatedBy(rs.getString("updated_by"));
			}
			return cat;
		} catch (Exception e) {
			return null;
		}
	}

}
