package com.test.epicapp;

import android.app.Activity;
import android.os.Bundle;

public class RandomShapeActivity extends Activity {
	
	DrawCircle v;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		v = new DrawCircle(RandomShapeActivity.this);
		setContentView(v);
	}

}
