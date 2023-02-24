package com.example.myapplication

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface UserApi {
	@GET("/photos")
	fun getAllImage(): Call<List<User>>;

	companion object {
		var retrofit = Retrofit.Builder()
			.baseUrl("http://10.0.2.2:8080/")
			.addConverterFactory(GsonConverterFactory.create())
			.build()

		fun getInstance(): UserApi {
			return retrofit.create(UserApi::class.java)
		}
	}
}