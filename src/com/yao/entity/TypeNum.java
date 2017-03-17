package com.yao.entity;

public class TypeNum {
	private int type_id;
	private String type_name;
	private int type_num;
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
	public int getType_num() {
		return type_num;
	}
	public void setType_num(int type_num) {
		this.type_num = type_num;
	}
	public String toString(){
		return "id:"+type_id+"   名字:"+type_name+"    个数："+type_num;
	}
}
