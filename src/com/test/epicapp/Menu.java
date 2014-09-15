package com.test.epicapp;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Menu extends ListActivity {

	String classes[] = { "MainActivity", "TextActivity", "RandomShapeActivity",
			"Email", "Camera", "Data", "Graphics", "GraphicsSurface", "Slider"};
	Intent iPrefs;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setListAdapter(new ArrayAdapter<String>(Menu.this,
				android.R.layout.simple_list_item_1, classes));
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		String choice = classes[position];
		@SuppressWarnings("rawtypes")
		Class class1;
		try {
			class1 = Class.forName("com.test.epicapp." + choice);
			Intent intent1 = new Intent(Menu.this, class1);
			startActivity(intent1);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		// TODO Auto-generated method stub
		super.onCreateOptionsMenu(menu);
		MenuInflater menuInflater;
		menuInflater = getMenuInflater();
		menuInflater.inflate(R.menu.menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.aboutUs:
			Intent i;
			i = new Intent("com.test.epicapp.ABOUT");
			startActivity(i);
			break;
		case R.id.pref:
			iPrefs = new Intent("com.test.epicapp.PREFS");
			startActivity(iPrefs);
			break;
		case R.id.exit:
			finish();
			break;
		}
		return false;
	}

}
