package com.example.bt_2023_01_13;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.*;
import org.jetbrains.annotations.NotNull;
import org.w3c.dom.Text;

import java.sql.Array;
import java.util.List;

public class MainActivity extends AppCompatActivity {
	TextView name;
	TextView phoneNumber;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		findViewById(android.R.id.content).setOnClickListener(view -> {
			InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
			imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
		});

		name = (findViewById(R.id.name));
		name.setHint(R.string.name);
		name.setOnFocusChangeListener((view, b) -> ((EditText)view).setHintTextColor(getColor(R.color.gray)));

		phoneNumber = findViewById(R.id.phone_number);
		phoneNumber.setHint(R.string.phone_number);
		phoneNumber.setOnFocusChangeListener((view, b) -> ((EditText)view).setHintTextColor(getColor(R.color.gray)));


		((TextView)findViewById(R.id.male)).setText(R.string.male);
		((TextView)findViewById(R.id.female)).setText(R.string.female);

		RadioGroup radioGroup = findViewById(R.id.gender_choosing_container);

		Spinner spinner = findViewById(R.id.home_town_spinner);
		spinner.setPrompt(getString(R.string.default_spinner_item));
		// Create an ArrayAdapter using the string array and a default spinner layout
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
				R.array.home_town_array, android.R.layout.simple_spinner_item);
		// Specify the layout to use when the list of choices appears
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		spinner.setAdapter(adapter);

//		ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(
//				getApplicationContext(), android.R.layout.simple_list_item_1);

		CustomArrayAdapter arrayAdapter = new CustomArrayAdapter(
				getApplicationContext(), R.layout.list_item_layout);

		ListView listView = findViewById(R.id.user_list);
		listView.setAdapter(arrayAdapter);
		findViewById(R.id.btn_add).setOnClickListener(view -> {
			if (!checkInput()) return;
			RadioButton gender = radioGroup.findViewById(radioGroup.getCheckedRadioButtonId());
			arrayAdapter.add(name.getText() + " - " +
					phoneNumber.getText() + " - " +
					gender.getText() + " - " +
					spinner.getSelectedItem()
			);
			resetEditText();
		});
	}

	@SuppressLint("ResourceType")
	private void resetEditText() {
		if (name != null) {
			name.setText("");
			name.setHint(getResources().getString(R.string.name));
			name.setHintTextColor(getColor(R.color.gray));
		}
		if (phoneNumber != null) {
			phoneNumber.setText("");
			phoneNumber.setHint(getResources().getString(R.string.phone_number));
			phoneNumber.setHintTextColor(getColor(R.color.gray));
		}
	}

	private boolean checkInput() {
		boolean result1 = false;
		boolean result2 = false;
		if (name != null) {
			result1 = name.getText().toString().equals("");
			name.setHint("Điền tên đã bạn êi");
			name.setHintTextColor(getColor(R.color.red_50));
		}
		if (phoneNumber != null) {
			result1 = phoneNumber.getText().toString().equals("");
			phoneNumber.setHint("Điền số điện thoại đê bạn êi");
			phoneNumber.setHintTextColor(getColor(R.color.red_50));
		}
		return !result1 && !result2;
	}

	static class CustomArrayAdapter extends ArrayAdapter<String> {

		public CustomArrayAdapter(@NonNull @NotNull Context context, int resource) {
			super(context, resource);
		}

		@SuppressLint("ViewHolder")
		@Override
		public View getView(int i, View view, ViewGroup viewGroup) {

			View currentView = view;
			if (currentView == null) {
				currentView = LayoutInflater.from(this.getContext()).inflate(R.layout.list_item_layout, null);
			}

			((TextView)currentView.findViewById(R.id.text_view)).setText(getItem(i));

			return currentView;
		}
	}

}