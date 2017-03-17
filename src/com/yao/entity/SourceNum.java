package com.yao.entity;

public class SourceNum {
	private int source_id;
	private String source_name;
	private int num;
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
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public SourceNum(int source_id, String source_name, int num) {
		super();
		this.source_id = source_id;
		this.source_name = source_name;
		this.num = num;
	}
	public SourceNum() {
		super();
	}
	@Override
	public String toString() {
		return "SourceNum [source_id=" + source_id + ", source_name=" + source_name + ", num=" + num + "]";
	}
	
}
