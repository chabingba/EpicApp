package com.test.epicapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Data extends Activity implements OnClickListener {
	EditText etSend;
	TextView tvGot;
	Button bSA, bSAFR;
	Bundle b1;
	String s1, driver;
	Intent i1, i2;
	int f;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.get);

		init();
	}

	private void init() {
		etSend = (EditText) findViewById(R.id.etSend);
		tvGot = (TextView) findViewById(R.id.tvGot);
		bSA = (Button) findViewById(R.id.bSA);
		bSAFR = (Button) findViewById(R.id.bSAFR);
		bSA.setOnClickListener(this);
		bSAFR.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.bSA:
			driver = etSend.getText().toString();
			f = 1;
			Bundle car = new Bundle();
			car.putString("data", driver);
			car.putInt("flag", f);
			i1 = new Intent(Data.this, OpenedClass.class);
			i1.putExtras(car);
			startActivity(i1);
			break;
		case R.id.bSAFR:
			i2 = new Intent(Data.this, OpenedClass.class);
			driver = etSend.getText().toString();
			f = 2;
			Bundle flag = new Bundle();
			flag.putInt("flag", f);
			flag.putString("data", driver);
			i2.putExtras(flag);
			startActivityForResult(i2, 0);
			break;
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == RESULT_OK) {
			b1 = data.getExtras();
			s1 = b1.getString("answer");

			tvGot.setText(driver + " " + s1);
		}
	}
}
