package com.eCertificate.entity;

/**
 * 
 * @author YangHaoyan
 *	用于封装user_tbl表的实体类
 */
public class User {
	// 编号
	private int id;
	// 账号
	private String account;
	// 密码
	private String password;
	// 用户名称
	private String name;
	// 性别
	private String gender;
	// 年龄
	private int age;
	// 地址
	private String address;
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	

}
