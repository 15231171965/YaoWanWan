package com.yao.entity;

public class UserRole {//员工角色
	private int role_id;
	private String role_name;
	private String role_power;
	private String is_used;
	public UserRole() {
		super();
	}
	public UserRole(int role_id, String role_name, String role_power, String is_used) {
		super();
		this.role_id = role_id;
		this.role_name = role_name;
		this.role_power = role_power;
		this.is_used = is_used;
	}
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	public String getRole_power() {
		return role_power;
	}
	public void setRole_power(String role_power) {
		this.role_power = role_power;
	}
	public String getIs_used() {
		return is_used;
	}
	public void setIs_used(String is_used) {
		this.is_used = is_used;
	}
	
}
