package com.delayed.mapper;

import java.sql.ResultSet;

import javax.inject.Inject;

import com.delayed.dao.PostDao;
import com.delayed.dao.UserDao;
import com.delayed.model.CommentModel;
import com.delayed.model.PostModel;
import com.delayed.model.UserModel;
import com.delayed.service.PostService;
import com.delayed.service.UserService;

public class CommentMapper implements RowMapper<CommentModel> {

	@Inject
	private PostDao postDao;
	
	@Inject
	private UserDao userDao;
	
	@Override
	public CommentModel mapRow(ResultSet rs) {
		try {
			CommentModel cm = new CommentModel();
			cm.setId(rs.getInt("id"));
			cm.setCreated(rs.getTimestamp("created"));
			cm.setComment(rs.getString("comment"));
			cm.setPostId(rs.getInt("post_id"));
			cm.setUserId(rs.getInt("user_id"));
			return cm;
		} catch (Exception e) {
			return null;
		}
	}


}
