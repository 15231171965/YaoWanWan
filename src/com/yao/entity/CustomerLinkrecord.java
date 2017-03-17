package com.yao.entity;

import java.sql.Timestamp;

public class CustomerLinkrecord {//客户联系记录
	private int record_id;
	private int customer_id;
	private String customer_name;
	private Timestamp link_time;
	private String who_link;
	private String link_type;
	private String link_theme;
	private Timestamp link_nexttime;
	private String link_remark;
	private String is_used;
	
	public CustomerLinkrecord(int customer_id, Timestamp link_time, String who_link, String link_type,
			String link_theme, Timestamp link_nexttime, String link_remark) {
		super();
		this.customer_id = customer_id;
		this.link_time = link_time;
		this.who_link = who_link;
		this.link_type = link_type;
		this.link_theme = link_theme;
		this.link_nexttime = link_nexttime;
		this.link_remark = link_remark;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public int getRecord_id() {
		return record_id;
	}
	public void setRecord_id(int record_id) {
		this.record_id = record_id;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public Timestamp getLink_time() {
		return link_time;
	}
	public void setLink_time(Timestamp link_time) {
		this.link_time = link_time;
	}
	public String getWho_link() {
		return who_link;
	}
	public void setWho_link(String who_link) {
		this.who_link = who_link;
	}
	public String getLink_type() {
		return link_type;
	}
	public void setLink_type(String link_type) {
		this.link_type = link_type;
	}
	public String getLink_theme() {
		return link_theme;
	}
	public void setLink_theme(String link_theme) {
		this.link_theme = link_theme;
	}
	public Timestamp getLink_nexttime() {
		return link_nexttime;
	}
	public void setLink_nexttime(Timestamp link_nexttime) {
		this.link_nexttime = link_nexttime;
	}	
	public String getLink_remark() {
		return link_remark;
	}
	public void setLink_remark(String link_remark) {
		this.link_remark = link_remark;
	}
	public String getIs_used() {
		return is_used;
	}
	public void setIs_used(String is_used) {
		this.is_used = is_used;
	}
	public CustomerLinkrecord(int record_id, int customer_id, Timestamp link_time, String who_link, String link_type,
			String link_theme, Timestamp link_nexttime, String link_remark, String is_used) {
		super();
		this.record_id = record_id;
		this.customer_id = customer_id;
		this.link_time = link_time;
		this.who_link = who_link;
		this.link_type = link_type;
		this.link_theme = link_theme;
		this.link_nexttime = link_nexttime;
		this.link_remark = link_remark;
		this.is_used = is_used;
	}
	public CustomerLinkrecord() {
		super();
	}
	
}
