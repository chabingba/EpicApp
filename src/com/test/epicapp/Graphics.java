package com.test.epicapp;

import android.app.Activity;
import android.os.Bundle;

public class Graphics extends Activity {

	DrawShape ourView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		ourView = new DrawShape(this);
		setContentView(ourView);
	}

	@Override
	protected void onPause() {
		super.onPause();
	}

}
