package com.test.epicapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Email extends Activity implements View.OnClickListener {

	Button send;
	EditText email, information, name, stk, other, text;
	String sEmail, sInformation, sName, sStk, sOther, sText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.scroll_view);

		initALl();

		send.setOnClickListener(this);
	}

	private void initALl() {
		// TODO Auto-generated method stub
		send = (Button) findViewById(R.id.bSend);
		email = (EditText) findViewById(R.id.eTEmail);
		information = (EditText) findViewById(R.id.eTInfo);
		name = (EditText) findViewById(R.id.eTName);
		stk = (EditText) findViewById(R.id.eTStk);
		other = (EditText) findViewById(R.id.eTOther);
		text = (EditText) findViewById(R.id.eTText);
	}

	@Override
	public void onClick(View v) {

		convertText();
		String eAddress[] = { sEmail };
		String message = "Hi " + sName + ", the " + sInformation
				+ " I know you want " + sStk + " and " + sOther
				+ " by request: \"" + sText + "\"";

		Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
		emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, eAddress);
		emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,
				"Test E-mail");
		emailIntent.setType("plain/text");
		emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, message);

		switch (v.getId()) {
		case R.id.bSend:
			startActivity(emailIntent);
			break;
		}
	}

	public void convertText() {

		sEmail = email.getText().toString();
		sInformation = information.getText().toString();
		sName = name.getText().toString();
		sStk = stk.getText().toString();
		sOther = other.getText().toString();
		sText = text.getText().toString();
	}
}
