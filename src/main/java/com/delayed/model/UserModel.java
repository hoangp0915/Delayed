package com.delayed.model;

public class UserModel extends BaseModel<Integer> {
	private String username;
	private String fullName;
	private String password;
	private Integer roleId;
	private RoleModel role;
	private String email;

	/**
	 * 
	 */
	public UserModel() {
	}

	/**
	 * @param username
	 * @param fullName
	 * @param password
	 * @param roleId
	 * @param role
	 * @param email
	 */
	public UserModel(String username, String fullName, String password, Integer roleId, RoleModel role, String email) {
		this.username = username;
		this.fullName = fullName;
		this.password = password;
		this.roleId = roleId;
		this.role = role;
		this.email = email;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * the username to set
	 * 
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
	 * 
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
	 * 
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the roleId
	 */
	public Integer getRoleId() {
		return roleId;
	}

	/**
	 * the roleId to set
	 * 
	 * @param roleId the roleId to set
	 */
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	/**
	 * @return the role
	 */
	public RoleModel getRole() {
		return role;
	}

	/**
	 * the role to set
	 * 
	 * @param role the role to set
	 */
	public void setRole(RoleModel role) {
		this.role = role;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * the email to set
	 * 
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

}
