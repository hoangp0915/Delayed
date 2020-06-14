package com.delayed.model;

public class FavoriteArticles {
	private Integer userId;
	private Integer postId;

	public FavoriteArticles() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param userId
	 * @param postId
	 */
	public FavoriteArticles(Integer userId, Integer postId) {
		this.userId = userId;
		this.postId = postId;
	}

	/**
	 * @return the userId
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * the userId to set
	 * 
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
	 * 
	 * @param postId the postId to set
	 */
	public void setPostId(Integer postId) {
		this.postId = postId;
	}

}
