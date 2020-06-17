/**
 * 
 */
package com.delayed.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import com.delayed.dao.CommentDao;
import com.delayed.model.CommentModel;
import com.delayed.model.PostModel;
import com.delayed.model.UserModel;
import com.delayed.service.CommentService;
import com.delayed.service.PostService;
import com.delayed.service.UserService;

/**
 * @author hoang
 *
 */
public class CommentServiceImpl implements CommentService {

	@Inject
	private CommentDao commentDao;
	
	@Inject
	private PostService postService;
	
	@Inject
	private UserService userService;
	
	@Override
	public List<CommentModel> listCommentByPost(Integer postId) {
		List<CommentModel> comments = commentDao.listCommentByPost(postId);
		for(CommentModel comment: comments) {
			PostModel post = postService.findById(comment.getPostId());
			UserModel user = userService.findOneById(comment.getUserId());
			comment.setPost(post);
			comment.setUser(user);
		}
		return comments;
	}

	@Override
	public void insertComment(Integer userId, Integer postId, String comment) {
			commentDao.insertComment(userId, postId, comment);
	}

}
