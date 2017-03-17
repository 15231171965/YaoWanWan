package com.yao.entity;

public class HouseInfo {//房子信息
	private int house_id;
	private int type_id;
	private String type_name;
	private int user_id;
	private String user_name;
	private String house_address;
	private int house_price;
	private String house_ambient;
	private String is_used;
	public HouseInfo() {
		super();
	}
	public HouseInfo(int type_id, int user_id, String house_address, int house_price, String house_ambient) {
		super();
		this.type_id = type_id;
		this.user_id = user_id;
		this.house_address = house_address;
		this.house_price = house_price;
		this.house_ambient = house_ambient;
	}
	public HouseInfo(int house_id, int type_id, int user_id, String house_address, int house_price,
			String house_ambient) {
		super();
		this.house_id = house_id;
		this.type_id = type_id;
		this.user_id = user_id;
		this.house_address = house_address;
		this.house_price = house_price;
		this.house_ambient = house_ambient;
	}
	public HouseInfo(int house_id, int type_id, int user_id, String house_address, int house_price,
			String house_ambient, String is_used) {
		super();
		this.house_id = house_id;
		this.type_id = type_id;
		this.user_id = user_id;
		this.house_address = house_address;
		this.house_price = house_price;
		this.house_ambient = house_ambient;
		this.is_used = is_used;
	}
	public int getHouse_id() {
		return house_id;
	}
	public void setHouse_id(int house_id) {
		this.house_id = house_id;
	}
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
	public String getHouse_address() {
		return house_address;
	}
	public void setHouse_address(String house_address) {
		this.house_address = house_address;
	}
	public int getHouse_price() {
		return house_price;
	}
	public void setHouse_price(int house_price) {
		this.house_price = house_price;
	}
	public String getHouse_ambient() {
		return house_ambient;
	}
	public void setHouse_ambient(String house_ambient) {
		this.house_ambient = house_ambient;
	}
	public String getIs_used() {
		return is_used;
	}
	public void setIs_used(String is_used) {
		this.is_used = is_used;
	}
	
}
