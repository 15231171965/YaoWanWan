package com.yao.entity;

import java.sql.Timestamp;

public class UserInfo {//员工信息
	private int user_id;
	private int department_id;
	private String department_name;
	private int role_id;
	private String role_name;
	private String user_name;
	private String user_sex;
	private String user_mobile;
	private int user_age;
	private String user_address;
	private String user_num;
	private String user_pw;
	private String user_tel;
	private String user_idnum;
	private String user_email;
	private Timestamp user_addtime;
	private String user_addman;
	private Timestamp user_changetime;
	private String user_changeman;
	private String user_intest;
	private String user_diploma;
	private String user_bankcard;
	private String user_nation;
	private String is_married;
	private String is_used;
	public UserInfo() {
		super();
	}
	
	public UserInfo(int department_id, int role_id, String user_name, String user_sex, String user_mobile, int user_age,
			String user_address, String user_num, String user_pw, String user_tel, String user_idnum, String user_email,
			Timestamp user_addtime, String user_addman, String user_intest, String user_diploma, String user_bankcard,
			String user_nation, String is_married) {
		super();
		this.department_id = department_id;
		this.role_id = role_id;
		this.user_name = user_name;
		this.user_sex = user_sex;
		this.user_mobile = user_mobile;
		this.user_age = user_age;
		this.user_address = user_address;
		this.user_num = user_num;
		this.user_pw = user_pw;
		this.user_tel = user_tel;
		this.user_idnum = user_idnum;
		this.user_email = user_email;
		this.user_addtime = user_addtime;
		this.user_addman = user_addman;
		this.user_intest = user_intest;
		this.user_diploma = user_diploma;
		this.user_bankcard = user_bankcard;
		this.user_nation = user_nation;
		this.is_married = is_married;
	}

	public UserInfo(int user_id, int department_id, String user_name, String user_sex, String user_mobile,
			int user_age, String user_address, String user_tel, String user_idnum, String user_email,
			Timestamp user_addtime, String user_addman, Timestamp user_changetime, String user_changeman,
			String user_intest, String user_diploma, String user_bankcard, String user_nation, String is_married) {
		super();
		this.user_id = user_id;
		this.department_id = department_id;
		this.user_name = user_name;
		this.user_sex = user_sex;
		this.user_mobile = user_mobile;
		this.user_age = user_age;
		this.user_address = user_address;
		this.user_tel = user_tel;
		this.user_idnum = user_idnum;
		this.user_email = user_email;
		this.user_addtime = user_addtime;
		this.user_addman = user_addman;
		this.user_changetime = user_changetime;
		this.user_changeman = user_changeman;
		this.user_intest = user_intest;
		this.user_diploma = user_diploma;
		this.user_bankcard = user_bankcard;
		this.user_nation = user_nation;
		this.is_married = is_married;
	}
	public UserInfo( int department_id, int role_id, String user_name, String user_sex, String user_mobile,
			int user_age, String user_address, String user_num, String user_pw, String user_tel, String user_idnum,
			String user_email, Timestamp user_addtime, String user_addman, Timestamp user_changetime,
			String user_changeman, String user_intest, String user_diploma, String user_bankcard, String user_nation,
			String is_married, String is_used) {
		super();
		this.department_id = department_id;
		this.role_id = role_id;
		this.user_name = user_name;
		this.user_sex = user_sex;
		this.user_mobile = user_mobile;
		this.user_age = user_age;
		this.user_address = user_address;
		this.user_num = user_num;
		this.user_pw = user_pw;
		this.user_tel = user_tel;
		this.user_idnum = user_idnum;
		this.user_email = user_email;
		this.user_addtime = user_addtime;
		this.user_addman = user_addman;
		this.user_changetime = user_changetime;
		this.user_changeman = user_changeman;
		this.user_intest = user_intest;
		this.user_diploma = user_diploma;
		this.user_bankcard = user_bankcard;
		this.user_nation = user_nation;
		this.is_married = is_married;
		this.is_used = is_used;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}
	public String getDepartment_name() {
		return department_name;
	}
	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_sex() {
		return user_sex;
	}
	public void setUser_sex(String user_sex) {
		this.user_sex = user_sex;
	}
	public String getUser_mobile() {
		return user_mobile;
	}
	public void setUser_mobile(String user_mobile) {
		this.user_mobile = user_mobile;
	}
	public int getUser_age() {
		return user_age;
	}
	public void setUser_age(int user_age) {
		this.user_age = user_age;
	}
	public String getUser_address() {
		return user_address;
	}
	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}
	public String getUser_num() {
		return user_num;
	}
	public void setUser_num(String user_num) {
		this.user_num = user_num;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}
	public String getUser_tel() {
		return user_tel;
	}
	public void setUser_tel(String user_tel) {
		this.user_tel = user_tel;
	}
	public String getUser_idnum() {
		return user_idnum;
	}
	public void setUser_idnum(String user_idnum) {
		this.user_idnum = user_idnum;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public Timestamp getUser_addtime() {
		return user_addtime;
	}
	public void setUser_addtime(Timestamp user_addtime) {
		this.user_addtime = user_addtime;
	}
	public String getUser_addman() {
		return user_addman;
	}
	public void setUser_addman(String user_addman) {
		this.user_addman = user_addman;
	}
	public Timestamp getUser_changetime() {
		return user_changetime;
	}
	public void setUser_changetime(Timestamp user_changetime) {
		this.user_changetime = user_changetime;
	}
	public String getUser_changeman() {
		return user_changeman;
	}
	public void setUser_changeman(String user_changeman) {
		this.user_changeman = user_changeman;
	}
	public String getUser_intest() {
		return user_intest;
	}
	public void setUser_intest(String user_intest) {
		this.user_intest = user_intest;
	}
	public String getUser_diploma() {
		return user_diploma;
	}
	public void setUser_diploma(String user_diploma) {
		this.user_diploma = user_diploma;
	}
	public String getUser_bankcard() {
		return user_bankcard;
	}
	public void setUser_bankcard(String user_bankcard) {
		this.user_bankcard = user_bankcard;
	}
	public String getUser_nation() {
		return user_nation;
	}
	public void setUser_nation(String user_nation) {
		this.user_nation = user_nation;
	}
	public String getIs_married() {
		return is_married;
	}
	public void setIs_married(String is_married) {
		this.is_married = is_married;
	}
	public String getIs_used() {
		return is_used;
	}
	public void setIs_used(String is_used) {
		this.is_used = is_used;
	}
	
}
