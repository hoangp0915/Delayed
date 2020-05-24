package com.delayed.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.delayed.model.PostModel;

public class PostMapper implements RowMapper<PostModel> {

	@Override
	public PostModel mapRow(ResultSet rs) {
		try {
			PostModel news = new PostModel();
			news.setId(rs.getInt("id"));
			news.setTitle(rs.getString("title"));
			news.setContent(rs.getString("content"));
			news.setDescription(rs.getString("description"));
			news.setThumbnail(rs.getString("thumbnail"));
			news.setCategoryId(rs.getInt("category_id"));
			news.setSource(rs.getString("source"));
			news.setCreated(rs.getTimestamp("created"));
			news.setCreatedBy(rs.getString("created_by"));
			if (rs.getTimestamp("updated") != null) {
				news.setUpdated(rs.getTimestamp("updated"));
			}
			if (rs.getString("updated_by") != null) {
				news.setUpdatedBy(rs.getString("updated_by"));
			}
			return news;
		} catch (SQLException e) {
			return null;
		}	
	}

}
