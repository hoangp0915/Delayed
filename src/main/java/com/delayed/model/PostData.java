/**
 * 
 */
package com.delayed.model;

/**
 * @author hoang
 *
 */
public class PostData extends BaseModel<Integer> {
	private String title;
	private String description;
	private String content;
	private String source;
	private String thumbnail;
	private CategoryModel category;
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * the title to set
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
	 * @param thumbnail the thumbnail to set
	 */
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	/**
	 * @return the category
	 */
	public CategoryModel getCategory() {
		return category;
	}
	/**
	 * the category to set
	 * @param category the category to set
	 */
	public void setCategory(CategoryModel category) {
		this.category = category;
	}
	
	
}
