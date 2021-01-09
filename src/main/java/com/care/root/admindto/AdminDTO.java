package com.care.root.admindto;

public class AdminDTO {
	private String adminid;
	private String pwd;
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAdminid() {
		return adminid;
	}
	public void setAdminid(String adminid) {
		this.adminid = adminid;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
}
