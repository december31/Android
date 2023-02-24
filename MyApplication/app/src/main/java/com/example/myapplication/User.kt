package com.example.myapplication

import com.google.gson.annotations.SerializedName

data class User(
	@SerializedName("id")
	val id: Long,
	@SerializedName("thumbnail")
	val name: String,
	@SerializedName("url")
	val imageUrl: String,
	@SerializedName("emulator_url")
	val emulatorImageUrl: String
) {
}