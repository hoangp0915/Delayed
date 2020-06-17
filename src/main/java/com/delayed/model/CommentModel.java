package com.delayed.model;

import java.sql.Timestamp;

public class CommentModel {
	private Integer id;
	private Timestamp created;
	private Integer userId;
	private Integer postId;
	private String comment;
	private PostModel post;
	private UserModel user;

	public CommentModel() {
	}

	/**
	 * @param id
	 * @param created
	 * @param userId
	 * @param postId
	 * @param comment
	 * @param post
	 * @param user
	 */
	public CommentModel(Integer id, Timestamp created, Integer userId, Integer postId, String comment, PostModel post,
			UserModel user) {
		this.id = id;
		this.created = created;
		this.userId = userId;
		this.postId = postId;
		this.comment = comment;
		this.post = post;
		this.user = user;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * the id to set
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the created
	 */
	public Timestamp getCreated() {
		return created;
	}

	/**
	 * the created to set
	 * @param created the created to set
	 */
	public void setCreated(Timestamp created) {
		this.created = created;
	}

	/**
	 * @return the userId
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * the userId to set
	 * @param userId the userId to set
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * @return the postId
	 */
	public Integer getPostId() {
		return postId;
	}

	/**
	 * the postId to set
	 * @param postId the postId to set
	 */
	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * the comment to set
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * @return the post
	 */
	public PostModel getPost() {
		return post;
	}

	/**
	 * the post to set
	 * @param post the post to set
	 */
	public void setPost(PostModel post) {
		this.post = post;
	}

	/**
	 * @return the user
	 */
	public UserModel getUser() {
		return user;
	}

	/**
	 * the user to set
	 * @param user the user to set
	 */
	public void setUser(UserModel user) {
		this.user = user;
	}
	
	
}
