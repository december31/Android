package com.example.recyclerviewexample;

import android.content.Intent;
import android.view.LayoutInflater;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.databinding.DataBindingUtil;
import com.example.recyclerviewexample.databinding.ActivityMainBinding;
import com.google.gson.Gson;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

	ActivityMainBinding binding;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		binding = DataBindingUtil.inflate(
				LayoutInflater.from(this), R.layout.activity_main, null, false);
		setContentView(binding.getRoot());

		ArrayList<User> users = new ArrayList<>(Arrays.asList(
				new User(1L, "Nguyen Duc A", "012345678", R.drawable.iu),
				new User(2L, "Nguyen Duc B", "022345678", R.drawable.ic_launcher_foreground),
				new User(3L, "Nguyen Duc C", "032345678", R.drawable.ic_launcher_foreground),
				new User(4L, "Nguyen Duc D", "042345678", R.drawable.ic_launcher_foreground),
				new User(5L, "Nguyen Duc E", "052345678", R.drawable.ic_launcher_foreground),
				new User(6L, "Nguyen Duc F", "062345678", R.drawable.ic_launcher_foreground),
				new User(7L, "Nguyen Duc G", "072345678", R.drawable.ic_launcher_foreground)
		));

		UserAdapter adapter = new UserAdapter(users, this);
		binding.rv.setAdapter(adapter);

	}

	void onItemClick(User user) {
		Intent intent = new Intent(this, DetailsActivity.class);
		intent.putExtra("user", new Gson().toJson(user));
		startActivityForResult(intent, 0);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
	}
}