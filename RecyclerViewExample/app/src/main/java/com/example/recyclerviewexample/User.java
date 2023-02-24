package com.example.recyclerviewexample;

import androidx.annotation.DrawableRes;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class User implements Serializable {
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Integer getImageResId() {
		return imageResId;
	}

	public void setImageResId(Integer imageResId) {
		this.imageResId = imageResId;
	}

	@SerializedName("id")
	Long id;
	@SerializedName("name")
	String name;

	@SerializedName("phone_number")
	String phoneNumber;

	@SerializedName("image_resource_id")
	@DrawableRes
	Integer imageResId;

	public User(Long id, String name, String phoneNumber, Integer imageResId) {
		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.imageResId = imageResId;
	}

	public User() {}
}
