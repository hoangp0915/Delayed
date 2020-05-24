package com.delayed.model;

public class UserModel extends BaseModel<Integer> {
	private String username;
	private String fullName;
	private String password;
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * the username to set
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}
	/**
	 * the fullName to set
	 * @param fullName the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * the password to set
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
