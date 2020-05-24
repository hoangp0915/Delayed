package com.delayed.model;

import java.sql.Timestamp;

public class BaseModel<T> {
	private T id;
	private Timestamp created;
	private Timestamp updated;
	private String createdBy;
	private String updatedBy;
	private Integer page;
	private Integer size; //max item in page
	private Integer totalPage;
	private Integer totalItem;
	private String sortName;
	private String sortBy;
	/**
	 * @return the id
	 */
	public T getId() {
		return id;
	}
	/**
	 * the id to set
	 * @param id the id to set
	 */
	public void setId(T id) {
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
	 * @return the updated
	 */
	public Timestamp getUpdated() {
		return updated;
	}
	/**
	 * the updated to set
	 * @param updated the updated to set
	 */
	public void setUpdated(Timestamp updated) {
		this.updated = updated;
	}
	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}
	/**
	 * the createdBy to set
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	/**
	 * @return the updatedBy
	 */
	public String getUpdatedBy() {
		return updatedBy;
	}
	/**
	 * the updatedBy to set
	 * @param updatedBy the updatedBy to set
	 */
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	/**
	 * @return the page
	 */
	public Integer getPage() {
		return page;
	}
	/**
	 * the page to set
	 * @param page the page to set
	 */
	public void setPage(Integer page) {
		this.page = page;
	}
	/**
	 * @return the size
	 */
	public Integer getSize() {
		return size;
	}
	/**
	 * the size to set
	 * @param size the size to set
	 */
	public void setSize(Integer size) {
		this.size = size;
	}
	/**
	 * @return the totalPage
	 */
	public Integer getTotalPage() {
		return totalPage;
	}
	/**
	 * the totalPage to set
	 * @param totalPage the totalPage to set
	 */
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	/**
	 * @return the totalItem
	 */
	public Integer getTotalItem() {
		return totalItem;
	}
	/**
	 * the totalItem to set
	 * @param totalItem the totalItem to set
	 */
	public void setTotalItem(Integer totalItem) {
		this.totalItem = totalItem;
	}
	/**
	 * @return the sortName
	 */
	public String getSortName() {
		return sortName;
	}
	/**
	 * the sortName to set
	 * @param sortName the sortName to set
	 */
	public void setSortName(String sortName) {
		this.sortName = sortName;
	}
	/**
	 * @return the sortBy
	 */
	public String getSortBy() {
		return sortBy;
	}
	/**
	 * the sortBy to set
	 * @param sortBy the sortBy to set
	 */
	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}
	
}
