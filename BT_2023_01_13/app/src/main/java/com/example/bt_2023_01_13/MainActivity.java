package com.example.bt_2023_01_13;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import com.example.bt_2023_01_13.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

	private ActivityMainBinding binding;
	private ArrayAdapter<String> listViewAdapter;
	ArrayList<CheckBox> checkBoxes;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		binding = ActivityMainBinding.inflate(getLayoutInflater());
		View view = binding.getRoot();
		setContentView(view);

		view.setOnClickListener(v -> {
			hideKeyboard();
		});

		initData();
		listener();
	}

	private void listener() {
		binding.button.setOnClickListener(v -> {
			StringBuilder hb = new StringBuilder();
			for (CheckBox checkBox : checkBoxes) {
				if (checkBox.isChecked()) {
					hb.append(checkBox.getText() + " / ");
				}
			}

			EditText name = findViewById(R.id.name);
			EditText phoneNumber = findViewById(R.id.phoneNumber);
			RadioGroup rg = findViewById(R.id.radio_group);
			RadioButton rd = rg.findViewById(rg.getCheckedRadioButtonId());

			listViewAdapter.add(
					name.getText().toString() + phoneNumber.getText().toString() + rd.getText().toString()
			);

			if(validateInput()) {
				listViewAdapter.add(
						binding.name.getText().toString() + " - " +
						binding.phoneNumber.getText().toString() + " - " +
						((RadioButton)binding.radioGroup.findViewById(binding.radioGroup.getCheckedRadioButtonId())).getText() + " - " +
						binding.spinner.getSelectedItem() + " - " +
						hb
				);
				resetInput();
			}
		});
	}

	private boolean validateInput() {
		boolean result1 = true;
		boolean result2 = true;
		if (binding.name.getText().toString().equals("")) {
			result1 = false;
			binding.name.setHint(R.string.missing_name_hint);
			binding.name.setHintTextColor(ContextCompat.getColor(this, R.color.red_50));
		}

		if (binding.phoneNumber.getText().toString().equals("")) {
			result2 = false;
			binding.phoneNumber.setHint(R.string.missing_phone_number_hint);
			binding.phoneNumber.setHintTextColor(ContextCompat.getColor(this, R.color.red_50));
		}

		return result1 && result2;
	}

	private void resetInput() {
		binding.name.setText("");
		binding.name.setHint(R.string.name);
		binding.name.setHintTextColor(ContextCompat.getColor(this, R.color.black_50));

		binding.phoneNumber.setText("");
		binding.phoneNumber.setHint(R.string.phone_number);
		binding.phoneNumber.setHintTextColor(ContextCompat.getColor(this, R.color.black_50));

		binding.male.setText(R.string.male);
		binding.female.setText(R.string.female);
		binding.button.setText(R.string.add);
	}

	private void initData() {
		resetInput();
		ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(
				this,
				R.array.home_town,
				android.R.layout.simple_spinner_item
		);
		arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		binding.spinner.setAdapter(arrayAdapter);

		listViewAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, R.id.text_view);
		binding.listView.setAdapter(listViewAdapter);

		String[] hobbies = getResources().getStringArray(R.array.hobby);
		checkBoxes = new ArrayList<>();

		LinearLayout checkBoxContainer = findViewById(R.id.checkbox_container);
		for (String hobby : hobbies) {
			CheckBox checkBox = new CheckBox(this);
			checkBox.setText(hobby);
			checkBoxes.add(
				checkBox
			);
			checkBoxContainer.addView(checkBox);
		}

	}

	private void hideKeyboard() {
		InputMethodManager imm = (InputMethodManager) getApplicationContext().getSystemService(Activity.INPUT_METHOD_SERVICE);
		imm.hideSoftInputFromWindow(binding.getRoot().getWindowToken(), 0);
	}

}