package com.yao.entity;

public class FenPeiNum {
	private int user_id;
	private String user_name;
	private int num;
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public FenPeiNum(int user_id, String user_name, int num) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.num = num;
	}
	public FenPeiNum() {
		super();
	}
	@Override
	public String toString() {
		return "FenPeiNum [user_id=" + user_id + ", user_name=" + user_name + ", num=" + num + "]";
	}
	
}
