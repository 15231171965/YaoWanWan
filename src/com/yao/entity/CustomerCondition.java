package com.yao.entity;

public class CustomerCondition {//客户条件
	private int condition_id;
	private String condition_name;
	private String condition_explain;
	private String is_used;
	public int getCondition_id() {
		return condition_id;
	}
	public void setCondition_id(int condition_id) {
		this.condition_id = condition_id;
	}
	public String getCondition_name() {
		return condition_name;
	}
	public void setCondition_name(String condition_name) {
		this.condition_name = condition_name;
	}
	public String getCondition_explain() {
		return condition_explain;
	}
	public void setCondition_explain(String condition_explain) {
		this.condition_explain = condition_explain;
	}
	public String getIs_used() {
		return is_used;
	}
	public void setIs_used(String is_used) {
		this.is_used = is_used;
	}
	public CustomerCondition(int condition_id, String condition_name, String condition_explain, String is_used) {
		super();
		this.condition_id = condition_id;
		this.condition_name = condition_name;
		this.condition_explain = condition_explain;
		this.is_used = is_used;
	}
	public CustomerCondition( String condition_name, String condition_explain) {
		super();
		this.condition_name = condition_name;
		this.condition_explain = condition_explain;
	}
	public CustomerCondition(){}
}
