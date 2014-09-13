package com.test.epicapp;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Menu extends ListActivity {

	String classes[] = { "MainActivity", "TextActivity", "RandomShapeActivity",
			"Email", "Camera", "Data" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

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

}
