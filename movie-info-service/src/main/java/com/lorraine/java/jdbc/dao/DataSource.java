package com.lorraine.java.jdbc.dao;

import java.sql.Connection;

abstract public class DataSource {
	private String driver;
	private String url;
	private String userName;
	private String password;
	public DataSource() {
	
	}
	public DataSource(String driver, String url, String user, String password) {
		super();
		this.driver = driver;
		this.url = url;
		this.userName = user;
		this.password = password;
	}
	
	public abstract Connection getConnection();
	
	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String user) {
		this.userName = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


}
