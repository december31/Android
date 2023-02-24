package com.example.recyclerviewexample;

import android.view.LayoutInflater;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.databinding.DataBindingUtil;
import com.example.recyclerviewexample.databinding.ActivityDetailsBinding;
import com.example.recyclerviewexample.databinding.ActivityMainBinding;
import com.google.gson.Gson;

public class DetailsActivity extends AppCompatActivity {

	ActivityDetailsBinding binding;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		binding = DataBindingUtil.inflate(
				LayoutInflater.from(this), R.layout.activity_details, null, false
		);
		setContentView(binding.getRoot());


		User user = new Gson().fromJson(getIntent().getStringExtra("user"), User.class);

		binding.setData(user);
		binding.save.setOnClickListener(v -> {
			this.endActivity();
		});
	}

	void endActivity() {
		finish();
	}
}