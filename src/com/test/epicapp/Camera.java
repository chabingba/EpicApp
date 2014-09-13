package com.test.epicapp;

import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Camera extends Activity implements View.OnClickListener {
	ImageView ivImage;
	ImageButton ibCapture;
	Button bSetBackground;
	Intent i, c;
	int cameraResult = 0;
	Bitmap bmp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.photo);

		init();
		InputStream is = getResources().openRawResource(R.drawable.logo);
		bmp = BitmapFactory.decodeStream(is);
		
	}

	private void init() {
		ivImage = (ImageView) findViewById(R.id.ivImage);
		ibCapture = (ImageButton) findViewById(R.id.ibCapture);
		bSetBackground = (Button) findViewById(R.id.bSetBackground);

		bSetBackground.setOnClickListener(this);
		ibCapture.setOnClickListener(this);

	}

	@SuppressWarnings("deprecation")
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.ibCapture:
			i = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
			startActivityForResult(i, cameraResult);
			break;
		case R.id.bSetBackground:
			try {
				getApplicationContext().setWallpaper(bmp);
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == RESULT_OK) {
			Bundle extras = data.getExtras();
			bmp = (Bitmap) extras.get("data");
			ivImage.setImageBitmap(bmp);
		}
	}

}
