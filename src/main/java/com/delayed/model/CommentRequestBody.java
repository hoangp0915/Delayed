package com.delayed.model;

public class CommentRequestBody {
	private String comment;

	public CommentRequestBody() {
	}

	/**
	 * @param comment
	 */
	public CommentRequestBody(String comment) {
		this.comment = comment;
	}

	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * the comment to set
	 * 
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

}
