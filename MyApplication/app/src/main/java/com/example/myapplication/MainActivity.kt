package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {

	lateinit var users: MutableList<User>
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		val result = UserApi.getInstance().getAllImage()
		result.enqueue(object : Callback, retrofit2.Callback<List<User>> {
			override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
				Log.e(this.javaClass.simpleName, response.body().toString())
				users = response.body() as MutableList<User>



			}

			override fun onFailure(call: Call<List<User>>, t: Throwable) {
				Log.e(this.javaClass.simpleName, t.message.toString())
			}

		})
	}
}