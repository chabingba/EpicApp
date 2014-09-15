package com.test.epicapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;

public class LoadScreen extends Activity {

	MediaPlayer cBells;
	SharedPreferences getPrefs;
	Boolean sound;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lscreen);

		getPrefs = PreferenceManager
				.getDefaultSharedPreferences(getBaseContext());

		sound = getPrefs.getBoolean("CheckBox", true);

		cBells = MediaPlayer.create(LoadScreen.this, R.raw.carol_of_bells);

		if (sound == true) {
			cBells.start();
		}

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
