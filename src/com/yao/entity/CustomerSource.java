package com.yao.entity;

public class CustomerSource {//客户源
	private int source_id;
	private String source_name;
	private String is_used;
	public CustomerSource(int source_id, String source_name, String is_used) {
		super();
		this.source_id = source_id;
		this.source_name = source_name;
		this.is_used = is_used;
	}
	public CustomerSource() {
		super();
	}
	public int getSource_id() {
		return source_id;
	}
	public void setSource_id(int source_id) {
		this.source_id = source_id;
	}
	public String getSource_name() {
		return source_name;
	}
	public void setSource_name(String source_name) {
		this.source_name = source_name;
	}
	public String getIs_used() {
		return is_used;
	}
	public void setIs_used(String is_used) {
		this.is_used = is_used;
	}
	
}
