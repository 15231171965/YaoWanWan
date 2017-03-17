package com.yao.entity;

public class ConditionNum {
	private int condition_id;
	private String condition_name;
	private int num;
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
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public ConditionNum(int condition_id, String condition_name, int num) {
		super();
		this.condition_id = condition_id;
		this.condition_name = condition_name;
		this.num = num;
	}
	public ConditionNum(){}
	@Override
	public String toString() {
		return "ConditionNum [condition_id=" + condition_id + ", condition_name=" + condition_name + ", num=" + num
				+ "]";
	};
	
}
