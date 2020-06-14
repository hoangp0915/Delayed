package com.delayed.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.delayed.model.FavoriteArticles;

public class FavoriteArticlesMapper implements RowMapper<FavoriteArticles> {

	@Override
	public FavoriteArticles mapRow(ResultSet rs) {
		try {
			FavoriteArticles fa = new FavoriteArticles();
			fa.setUserId(rs.getInt("user_id"));
			fa.setPostId(rs.getInt("post_id"));
			return fa;
		} catch (SQLException e) {
			return null;
		}	
	}

}
