package com.example.bt_2023_01_13;

import java.io.Serializable;

public class User implements Serializable {
	private String name;
	private String phoneNumber;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public User(){}

	public User(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
	}


}
