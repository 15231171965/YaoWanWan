package com.yao.entity;

public class HouseType {//房子类型
	private int type_id;
	private String type_name;
	private String is_used;
	public HouseType() {
		super();
	}
	public HouseType(int type_id, String type_name, String is_used) {
		super();
		this.type_id = type_id;
		this.type_name = type_name;
		this.is_used = is_used;
	}
	public int getType_id() {
		return type_id;
	}
	public void setType_id(int type_id) {
		this.type_id = type_id;
	}
	public String getType_name() {
		return type_name;
	}
	public void setType_name(String type_name) {
		this.type_name = type_name;
	}
	public String getIs_used() {
		return is_used;
	}
	public void setIs_used(String is_used) {
		this.is_used = is_used;
	}
	
}
