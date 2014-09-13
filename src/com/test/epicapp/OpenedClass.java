package com.test.epicapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class OpenedClass extends Activity implements OnClickListener,
		OnCheckedChangeListener {
	TextView tvTest, tvWish;
	Button bReturn;
	RadioGroup rgAnswers;
	RadioButton checked;
	Bundle garage, backpack, flag;
	String driver1, sendData, a1;
	Intent i3;
	int gotf;
	SharedPreferences getData;
	String et, values;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.send);
		init();
		getData = PreferenceManager
				.getDefaultSharedPreferences(getBaseContext());
		et = getData.getString("Name", "I want:");
		values = getData.getString("List", "4");

		garage = getIntent().getExtras();
		gotf = garage.getInt("flag");
		if (gotf == 1) {
			driver1 = garage.getString("data");
			tvWish.setText(driver1);
		} else if (gotf == 2) {
			driver1 = garage.getString("data");
			tvWish.setText(driver1);
		}
		if (driver1.contentEquals("")) {
			if (values.contentEquals("1")) {
				tvWish.setText(et);
			}
		}
	}

	private void init() {
		tvTest = (TextView) findViewById(R.id.tvTest);
		tvWish = (TextView) findViewById(R.id.tvWish);
		bReturn = (Button) findViewById(R.id.bReturn);
		rgAnswers = (RadioGroup) findViewById(R.id.rgAnswers);
		bReturn.setOnClickListener(this);
		rgAnswers.setOnCheckedChangeListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.bReturn:
			i3 = new Intent();
			backpack = new Bundle();
			sendData = a1 + "." + "\n" + sendData;
			backpack.putString("answer", sendData);
			i3.putExtras(backpack);
			setResult(RESULT_OK, i3);
			finish();
			break;
		}

	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		switch (checkedId) {
		case R.id.rbCar:
			checked = (RadioButton) findViewById(R.id.rbCar);
			sendData = "Not only.";
			break;
		case R.id.rbSPhone:
			checked = (RadioButton) findViewById(R.id.rbSPhone);
			sendData = "Not only!";
			break;
		case R.id.rbBoth:
			checked = (RadioButton) findViewById(R.id.rbBoth);
			sendData = "Exactly!!!";
			break;
		}
		a1 = checked.getText().toString();
		tvTest.setText(sendData);
	}

}
