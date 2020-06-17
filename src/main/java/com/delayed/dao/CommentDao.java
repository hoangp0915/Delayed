/**
 * 
 */
package com.delayed.dao;

import java.util.List;

import com.delayed.model.CommentModel;

/**
 * @author hoang
 *
 */
public interface CommentDao {
	List<CommentModel> listCommentByPost(Integer postId);
	
	void insertComment(Integer userId, Integer postId, String comment);
}
