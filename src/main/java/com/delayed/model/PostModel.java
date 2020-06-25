package com.delayed.model;

public class PostModel extends BaseModel<Integer> {
	private String title;
	private String description;
	private String content;
	private String source;
	private String thumbnail;
	private Integer categoryId;
	private Integer views;

	/**
	 * 
	 */
	public PostModel() {
	}

	/**
	 * @param title
	 * @param description
	 * @param content
	 * @param source
	 * @param thumbnail
	 * @param categoryId
	 * @param views
	 */
	public PostModel(String title, String description, String content, String source, String thumbnail,
			Integer categoryId, Integer views) {
		this.title = title;
		this.description = description;
		this.content = content;
		this.source = source;
		this.thumbnail = thumbnail;
		this.categoryId = categoryId;
		this.views = views;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * the title to set
	 * 
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * the description to set
	 * 
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * the content to set
	 * 
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the source
	 */
	public String getSource() {
		return source;
	}

	/**
	 * the source to set
	 * 
	 * @param source the source to set
	 */
	public void setSource(String source) {
		this.source = source;
	}

	/**
	 * @return the thumbnail
	 */
	public String getThumbnail() {
		return thumbnail;
	}

	/**
	 * the thumbnail to set
	 * 
	 * @param thumbnail the thumbnail to set
	 */
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	/**
	 * @return the categoryId
	 */
	public Integer getCategoryId() {
		return categoryId;
	}

	/**
	 * the categoryId to set
	 * 
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 * @return the views
	 */
	public Integer getViews() {
		return views;
	}

	/**
	 * the views to set
	 * 
	 * @param views the views to set
	 */
	public void setViews(Integer views) {
		this.views = views;
	}

}
