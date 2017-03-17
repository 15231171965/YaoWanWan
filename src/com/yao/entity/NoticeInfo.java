package com.yao.entity;

import java.sql.Timestamp;

public class NoticeInfo {//公告信息
	private int notice_id;
	private int user_id;
	private String user_name;
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	private String notice_item;
	private String notice_content;
	private Timestamp notice_time;
	private Timestamp notice_endtime;
	private String is_used;
	
	public NoticeInfo(int user_id, String notice_item, String notice_content, Timestamp notice_time,
			Timestamp notice_endtime) {
		super();
		this.user_id = user_id;
		this.notice_item = notice_item;
		this.notice_content = notice_content;
		this.notice_time = notice_time;
		this.notice_endtime = notice_endtime;
	}
	public NoticeInfo(int notice_id, int user_id, String notice_item, String notice_content, Timestamp notice_time,
			Timestamp notice_endtime, String is_used) {
		super();
		this.notice_id = notice_id;
		this.user_id = user_id;
		this.notice_item = notice_item;
		this.notice_content = notice_content;
		this.notice_time = notice_time;
		this.notice_endtime = notice_endtime;
		this.is_used = is_used;
	}
	public NoticeInfo() {
		super();
	}
	public int getNotice_id() {
		return notice_id;
	}
	public void setNotice_id(int notice_id) {
		this.notice_id = notice_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getNotice_item() {
		return notice_item;
	}
	public void setNotice_item(String notice_item) {
		this.notice_item = notice_item;
	}
	public String getNotice_content() {
		return notice_content;
	}
	public void setNotice_content(String notice_content) {
		this.notice_content = notice_content;
	}
	public Timestamp getNotice_time() {
		return notice_time;
	}
	public void setNotice_time(Timestamp notice_time) {
		this.notice_time = notice_time;
	}
	public Timestamp getNotice_endtime() {
		return notice_endtime;
	}
	public void setNotice_endtime(Timestamp notice_endtime) {
		this.notice_endtime = notice_endtime;
	}
	public String getIs_used() {
		return is_used;
	}
	public void setIs_used(String is_used) {
		this.is_used = is_used;
	}
	
}
