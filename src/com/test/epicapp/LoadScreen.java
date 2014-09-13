package com.test.epicapp;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

public class LoadScreen extends Activity {
	
	MediaPlayer cBells;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lscreen);
		
		cBells = MediaPlayer.create(LoadScreen.this, R.raw.carol_of_bells);
		cBells.start();
		
		Thread timer = new Thread() {
			public void run() {
				try {
					sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					Intent startMain = new Intent("com.test.epicapp.MENU");
					startActivity(startMain);
				}
			}
		};
		timer.start();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		cBells.release();
		finish();
	}

}
