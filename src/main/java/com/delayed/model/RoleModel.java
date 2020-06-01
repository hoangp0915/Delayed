package com.delayed.model;

public class RoleModel extends BaseModel<Integer> {
	private String code;
	private String name;
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * the code to set
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
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
	
	
}
