package com.tokyoboyband.dto;

public class UserDTO extends AbstractDTO<UserDTO> {
	private Long id;
	private String username;
	private String password;
	private String fullname;
	private int status;
	private Long role_id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Long getRoleid() {
		return role_id;
	}
	public void setRoleid(Long roleid) {
		this.role_id = roleid;
	}
	
}
