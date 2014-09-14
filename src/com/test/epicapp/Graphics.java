package com.test.epicapp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;

public class Graphics extends Activity {

	DrawShape ourView;
	PowerManager pManager;
	WakeLock wLock;
	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		pManager = (PowerManager) getSystemService(Context.POWER_SERVICE);
		pManager.newWakeLock(PowerManager.FULL_WAKE_LOCK, "WakeLock");
		super.onCreate(savedInstanceState);
		wLock.acquire();
		ourView = new DrawShape(this);
		setContentView(ourView);
	}
	@Override
	protected void onPause() {
		super.onPause();
		wLock.release();
	}

}
