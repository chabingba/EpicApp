package com.test.epicapp;

import java.util.Random;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class RandomShapeActivity extends Activity implements OnTouchListener {

	DrawCircle v;
	Rect r;
	Paint blue;
	Random f, choice, radius, k, multip;
	int iF, iChoice, iMultip;
	float fF, fRadius;
	Bitmap bmp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		v = new DrawCircle(RandomShapeActivity.this);
		v.setOnTouchListener(this);
		setContentView(v);

	}

	public class DrawCircle extends View {

		public DrawCircle(Context context) {
			super(context);

		}

		@Override
		public void onDraw(Canvas canvas) {
			super.onDraw(canvas);
			canvas.drawColor(Color.BLACK);
			r = new Rect();
			blue = new Paint();
			blue.setARGB(255, iF, iF, iF);
			r.set(iF, iF, iF * iMultip, iF * iMultip);
			bmp = BitmapFactory.decodeResource(getResources(),
					R.drawable.awesome_ball);

			switch (iChoice) {
			case 0:
				canvas.drawCircle(fF, fF, fRadius, blue);
				break;
			case 1:
				canvas.drawRect(r, blue);
				break;
			case 2:
				canvas.drawBitmap(bmp, fF, fF, blue);
				break;
			}
			invalidate();
		}

	}

	@Override
	public boolean onTouch(View v1, MotionEvent event) {

		f = new Random();
		choice = new Random();
		radius = new Random();
		k = new Random();
		multip = new Random();

		iF = f.nextInt(255);
		fF = k.nextFloat() * 255;
		iChoice = choice.nextInt(3);
		fRadius = radius.nextFloat() * 100;
		iMultip = multip.nextInt(20);
		return false;
	}

}
