/**
 * 
 */
package com.delayed.dao.impl;

import java.util.List;

import com.delayed.dao.CommentDao;
import com.delayed.mapper.CommentMapper;
import com.delayed.model.CommentModel;

/**
 * @author hoang
 *
 */
public class CommentDaoImpl extends ConnectionImpl<CommentModel> implements CommentDao  {

	@Override
	public List<CommentModel> listCommentByPost(Integer postId) {
		String sql = "select * from comments where post_id = ? ORDER BY created DESC";
		return query(sql, new CommentMapper(), postId);
	}

	@Override
	public void insertComment(Integer userId, Integer postId, String comment) {
		StringBuilder sql = new StringBuilder("INSERT INTO comments (user_id, post_id, comment)");
		sql.append(" VALUES(?, ?, ?)");
		insert(sql.toString(), userId, postId, comment);
	}

}
