package com.yao.entity;

import java.sql.Timestamp;

public class Care {
	private 	int care_id;
	private int customer_id;
	private String customer_name;
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	private String care_theme;
	private String care_way;
	private Timestamp care_time;
	private String care_remark;
	private Timestamp care_nexttime;
	private String care_people;
	private String is_used;
	
	public Care(int customer_id, String care_theme, String care_way, String care_remark, Timestamp care_nexttime,
			String care_people) {
		super();
		this.customer_id = customer_id;
		this.care_theme = care_theme;
		this.care_way = care_way;
		this.care_remark = care_remark;
		this.care_nexttime = care_nexttime;
		this.care_people = care_people;
	}
	public Care(int customer_id, String care_theme, String care_way, String care_remark, Timestamp care_nexttime,
			String care_people ,int care_id) {
		super();
		this.customer_id = customer_id;
		this.care_theme = care_theme;
		this.care_way = care_way;
		this.care_remark = care_remark;
		this.care_nexttime = care_nexttime;
		this.care_people = care_people;
		this.care_id=care_id;
	}
	public int getCare_id() {
		return care_id;
	}
	public void setCare_id(int care_id) {
		this.care_id = care_id;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public String getCare_theme() {
		return care_theme;
	}
	public void setCare_theme(String care_theme) {
		this.care_theme = care_theme;
	}
	public String getCare_way() {
		return care_way;
	}
	public void setCare_way(String care_way) {
		this.care_way = care_way;
	}
	public Timestamp getCare_time() {
		return care_time;
	}
	public void setCare_time(Timestamp care_time) {
		this.care_time = care_time;
	}
	public String getCare_remark() {
		return care_remark;
	}
	public void setCare_remark(String care_remark) {
		this.care_remark = care_remark;
	}
	public Timestamp getCare_nexttime() {
		return care_nexttime;
	}
	public void setCare_nexttime(Timestamp care_nexttime) {
		this.care_nexttime = care_nexttime;
	}
	public String getCare_people() {
		return care_people;
	}
	public void setCare_people(String care_people) {
		this.care_people = care_people;
	}
	public String getIs_used() {
		return is_used;
	}
	public void setIs_used(String is_used) {
		this.is_used = is_used;
	}
	public Care(int care_id, int customer_id, String care_theme, String care_way, Timestamp care_time,
			String care_remark, Timestamp care_nexttime, String care_people, String is_used) {
		super();
		this.care_id = care_id;
		this.customer_id = customer_id;
		this.care_theme = care_theme;
		this.care_way = care_way;
		this.care_time = care_time;
		this.care_remark = care_remark;
		this.care_nexttime = care_nexttime;
		this.care_people = care_people;
		this.is_used = is_used;
	}
	public Care() {
		super();
	}
	
}
