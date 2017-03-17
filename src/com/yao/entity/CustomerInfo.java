package com.yao.entity;

import java.sql.Timestamp;

public class CustomerInfo {//客户信息
	private int customer_id;
	private int condition_id;
	private int source_id;
	private int user_id;
	private int type_id;
	private String condition_name;//状态名
	private String source_name;//来源名
	private String user_name;//所属员工名
	private String type_name;//类型名
	private String customer_name;
	private String customer_sex;
	private String customer_mobile;
	private String customer_qq;
	private String customer_address;
	private String customer_email;
	private String customer_remark;
	private String customer_job;
	private String customer_blog;
	private String customer_tel;
	private String customer_msn;
	private Timestamp birth_day;
	private Timestamp customer_addtime;
	private String customer_addman;
	private Timestamp customer_changetime;
	private String change_man;
	private String customer_company;
	private String is_used;
	
	public String getCondition_name() {
		return condition_name;
	}
	public void setCondition_name(String condition_name) {
		this.condition_name = condition_name;
	}
	public String getSource_name() {
		return source_name;
	}
	public void setSource_name(String source_name) {
		this.source_name = source_name;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getType_name() {
		return type_name;
	}
	public void setType_name(String type_name) {
		this.type_name = type_name;
	}
	public CustomerInfo(){}
	
	public CustomerInfo(int customer_id, int condition_id, int source_id, int user_id, int type_id,
			String customer_name, String customer_sex, String customer_mobile, String customer_qq,
			String customer_address, String customer_email, String customer_remark, String customer_job,
			String customer_blog, String customer_tel, String customer_msn, 
			Timestamp customer_addtime, String customer_addman, Timestamp customer_changetime, String change_man,
			String customer_company, String is_used) {
		super();
		this.customer_id = customer_id;
		this.condition_id = condition_id;
		this.source_id = source_id;
		this.user_id = user_id;
		this.type_id = type_id;
		this.customer_name = customer_name;
		this.customer_sex = customer_sex;
		this.customer_mobile = customer_mobile;
		this.customer_qq = customer_qq;
		this.customer_address = customer_address;
		this.customer_email = customer_email;
		this.customer_remark = customer_remark;
		this.customer_job = customer_job;
		this.customer_blog = customer_blog;
		this.customer_tel = customer_tel;
		this.customer_msn = customer_msn;
		this.customer_addtime = customer_addtime;
		this.customer_addman = customer_addman;
		this.customer_changetime = customer_changetime;
		this.change_man = change_man;
		this.customer_company = customer_company;
		this.is_used = is_used;
	}
	public CustomerInfo( int condition_id, int source_id, int type_id,
			String customer_name, String customer_sex, String customer_mobile, String customer_qq,
			String customer_address, String customer_email, String customer_remark, String customer_job,
			String customer_blog, String customer_tel, String customer_msn, 
			String customer_addman, String change_man,String customer_company
			,Timestamp birthday,Timestamp addtime ,Timestamp updatetime) {
		super();
		this.condition_id = condition_id;
		this.source_id = source_id;
		this.type_id = type_id;
		this.customer_name = customer_name;
		this.customer_sex = customer_sex;
		this.customer_mobile = customer_mobile;
		this.customer_qq = customer_qq;
		this.customer_address = customer_address;
		this.customer_email = customer_email;
		this.customer_remark = customer_remark;
		this.customer_job = customer_job;
		this.customer_blog = customer_blog;
		this.customer_tel = customer_tel;
		this.customer_msn = customer_msn;
		this.customer_addman = customer_addman;
		this.change_man = change_man;
		this.customer_company = customer_company;
		this.birth_day=birthday;
		this.customer_addtime=addtime;
		this.customer_changetime=updatetime;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public int getCondition_id() {
		return condition_id;
	}
	public void setCondition_id(int condition_id) {
		this.condition_id = condition_id;
	}
	public int getSource_id() {
		return source_id;
	}
	public void setSource_id(int source_id) {
		this.source_id = source_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getType_id() {
		return type_id;
	}
	public void setType_id(int type_id) {
		this.type_id = type_id;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getCustomer_sex() {
		return customer_sex;
	}
	public void setCustomer_sex(String customer_sex) {
		this.customer_sex = customer_sex;
	}
	public String getCustomer_mobile() {
		return customer_mobile;
	}
	public void setCustomer_mobile(String customer_mobile) {
		this.customer_mobile = customer_mobile;
	}
	public String getCustomer_qq() {
		return customer_qq;
	}
	public void setCustomer_qq(String customer_qq) {
		this.customer_qq = customer_qq;
	}
	public String getCustomer_address() {
		return customer_address;
	}
	public void setCustomer_address(String customer_address) {
		this.customer_address = customer_address;
	}
	public String getCustomer_email() {
		return customer_email;
	}
	public void setCustomer_email(String customer_email) {
		this.customer_email = customer_email;
	}
	public String getCustomer_remark() {
		return customer_remark;
	}
	public void setCustomer_remark(String customer_remark) {
		this.customer_remark = customer_remark;
	}
	public String getCustomer_job() {
		return customer_job;
	}
	public void setCustomer_job(String customer_job) {
		this.customer_job = customer_job;
	}
	public String getCustomer_blog() {
		return customer_blog;
	}
	public void setCustomer_blog(String customer_blog) {
		this.customer_blog = customer_blog;
	}
	public String getCustomer_tel() {
		return customer_tel;
	}
	public void setCustomer_tel(String customer_tel) {
		this.customer_tel = customer_tel;
	}
	public String getCustomer_msn() {
		return customer_msn;
	}
	public void setCustomer_msn(String customer_msn) {
		this.customer_msn = customer_msn;
	}
	public Timestamp getBirth_day() {
		return birth_day;
	}
	public void setBirth_day(Timestamp birth_day) {
		this.birth_day = birth_day;
	}
	public Timestamp getCustomer_addtime() {
		return customer_addtime;
	}
	public void setCustomer_addtime(Timestamp customer_addtime) {
		this.customer_addtime = customer_addtime;
	}
	public String getCustomer_addman() {
		return customer_addman;
	}
	public void setCustomer_addman(String customer_addman) {
		this.customer_addman = customer_addman;
	}
	public Timestamp getCustomer_changetime() {
		return customer_changetime;
	}
	public void setCustomer_changetime(Timestamp customer_changetime) {
		this.customer_changetime = customer_changetime;
	}
	public String getChange_man() {
		return change_man;
	}
	public void setChange_man(String change_man) {
		this.change_man = change_man;
	}
	public String getCustomer_company() {
		return customer_company;
	}
	public void setCustomer_company(String customer_company) {
		this.customer_company = customer_company;
	}
	public String getIs_used() {
		return is_used;
	}
	public void setIs_used(String is_used) {
		this.is_used = is_used;
	}
	
}
