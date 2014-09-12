package com.test.epicapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	int cnt;
	Button bAdd, bSub;
	TextView disp;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cnt=0;
        bAdd = (Button) findViewById(R.id.bAdd);
        bSub = (Button) findViewById(R.id.bSub);
        disp = (TextView) findViewById(R.id.disp);
        
        bAdd.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				cnt++;
				disp.setText(""+cnt);
			}
		});
        
        bSub.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				cnt--;
				disp.setText(""+cnt);
			}
		});
    }
}
