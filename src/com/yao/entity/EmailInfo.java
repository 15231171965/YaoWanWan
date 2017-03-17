package com.yao.entity;

import java.sql.Timestamp;

public class EmailInfo {//电子邮件信息
	private int email_id;
	private int customer_id;
	private String customer_name;
	private int user_id;
	private String user_name;
	
	private String email_content;
	private Timestamp email_time;
	private String email_state;
	private String email_theme;
	private String is_used;
	public EmailInfo() {
		super();
	}
	
	public EmailInfo(int customer_id, int user_id, String email_content, Timestamp email_time, String email_theme) {
		super();
		this.customer_id = customer_id;
		this.user_id = user_id;
		this.email_content = email_content;
		this.email_time = email_time;
		this.email_theme = email_theme;
	}

	public EmailInfo(int email_id, int customer_id, int user_id, String email_content, Timestamp email_time,
			String email_state, String email_theme, String is_used) {
		super();
		this.email_id = email_id;
		this.customer_id = customer_id;
		this.user_id = user_id;
		this.email_content = email_content;
		this.email_time = email_time;
		this.email_state = email_state;
		this.email_theme = email_theme;
		this.is_used = is_used;
	}
	public int getEmail_id() {
		return email_id;
	}
	public void setEmail_id(int email_id) {
		this.email_id = email_id;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getEmail_content() {
		return email_content;
	}
	public void setEmail_content(String email_content) {
		this.email_content = email_content;
	}
	public Timestamp getEmail_time() {
		return email_time;
	}
	public void setEmail_time(Timestamp email_time) {
		this.email_time = email_time;
	}
	public String getEmail_state() {
		return email_state;
	}
	public void setEmail_state(String email_state) {
		this.email_state = email_state;
	}
	public String getEmail_theme() {
		return email_theme;
	}
	public void setEmail_theme(String email_theme) {
		this.email_theme = email_theme;
	}
	public String getIs_used() {
		return is_used;
	}
	public void setIs_used(String is_used) {
		this.is_used = is_used;
	}
	
}
