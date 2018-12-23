package com.zc.entity;

public class AdminParam {
	private String adminCode;
	private String pwd;
	public String getAdminCode() {
		return adminCode;
	}
	public void setAdminCode(String adminCode) {
		this.adminCode = adminCode;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	@Override
	public String toString() {
		return "AdminParam [adminCode=" + adminCode + ", pwd=" + pwd + "]";
	}
}
