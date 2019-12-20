package com.zlx.domain;

import java.io.Serializable;

public class Customer implements Serializable{
	private String account;
	private String password;
	private String cname;
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}

	@Override
	public String toString() {
		return "Customer{" +
				"account='" + account + '\'' +
				", password='" + password + '\'' +
				", cname='" + cname + '\'' +
				'}';
	}
}
