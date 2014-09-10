package com.test.epicapp;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class TextActivity extends Activity implements View.OnClickListener {
	Button bRes, bClr, bMagic;
	ToggleButton tPass;
	EditText etCommands;
	TextView tView;
	String eText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.text);

		buttonSetView();

		bRes.setOnClickListener(this);
		bClr.setOnClickListener(this);
		bMagic.setOnClickListener(this);
		tPass.setOnClickListener(this);

	}

	private void buttonSetView() {
		// TODO Auto-generated method stub
		bRes = (Button) findViewById(R.id.bRes);
		bClr = (Button) findViewById(R.id.bClr);
		bMagic = (Button) findViewById(R.id.bMagic);
		tPass = (ToggleButton) findViewById(R.id.tPass);
		etCommands = (EditText) findViewById(R.id.etCommands);
		tView = (TextView) findViewById(R.id.tView);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.bClr:
			etCommands.setText(null);
			tView.setText(null);
			break;

		case R.id.bRes:
			eText = etCommands.getText().toString();
			tView.setText(eText);
			if (tPass.isChecked() == true) {
				tView.setInputType(InputType.TYPE_CLASS_TEXT
						| InputType.TYPE_TEXT_VARIATION_PASSWORD);
			} else {
				tView.setInputType(InputType.TYPE_CLASS_TEXT);
			}
			break;

		case R.id.bMagic:
			eText = etCommands.getText().toString();
			if (eText.contentEquals("left")) {
				tView.setGravity(Gravity.LEFT);
			} else if (eText.contentEquals("right")) {
				tView.setGravity(Gravity.RIGHT);
			} else if (eText.contentEquals("center")) {
				tView.setGravity(Gravity.CENTER);
			} else if (eText.contentEquals("blue")) {
				tView.setTextColor(Color.BLUE);
			} else {

				tView.setGravity(Gravity.CENTER);
			}
			break;
		case R.id.tPass:
			if (tPass.isChecked() == true) {
				etCommands.setInputType(InputType.TYPE_CLASS_TEXT
						| InputType.TYPE_TEXT_VARIATION_PASSWORD);
				tView.setInputType(InputType.TYPE_CLASS_TEXT
						| InputType.TYPE_TEXT_VARIATION_PASSWORD);
			} else {
				etCommands.setInputType(InputType.TYPE_CLASS_TEXT);
				tView.setInputType(InputType.TYPE_CLASS_TEXT);
			}
			break;
		}
	}

}
