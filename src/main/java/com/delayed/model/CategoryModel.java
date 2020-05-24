/**
 * 
 */
package com.delayed.model;

/**
 * @author hoang
 *
 */
public class CategoryModel extends BaseModel<Integer> {
	private String name;
	private Integer parent;
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * the name to set
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the parent
	 */
	public Integer getParent() {
		return parent;
	}
	/**
	 * the parent to set
	 * @param parent the parent to set
	 */
	public void setParent(Integer parent) {
		this.parent = parent;
	}
	
}
