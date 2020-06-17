/**
 * 
 */
package com.delayed.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.delayed.model.CommentModel;

/**
 * @author hoang
 *
 */
public interface CommentService {
	List<CommentModel> listCommentByPost(Integer postId);
	
	void insertComment(Integer userId, Integer postId, String comment);
}
