package com.test.epicapp;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnTouchListener;

public class GraphicsSurface extends Activity implements OnTouchListener {

	DrawSurface ourSurfaceView;
	float x, y, sX, sY, fX, fY, dX, dY, animatedX, animatedY, scaledX, scaledY;
	Bitmap ball, plus;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ourSurfaceView = new DrawSurface(this);
		ourSurfaceView.setOnTouchListener(this);

		x = 0;
		y = 0;
		sX = 0;
		sY = 0;
		fX = 0;
		fY = 0;
		dX = 0;
		dY = 0;
		animatedX = 0;
		animatedY = 0;
		scaledX = 0;
		scaledY = 0;
		ball = BitmapFactory.decodeResource(getResources(),
				R.drawable.awesome_ball);
		plus = BitmapFactory.decodeResource(getResources(), R.drawable.plus);
		setContentView(ourSurfaceView);

	}

	@Override
	protected void onResume() {
		super.onResume();
		ourSurfaceView.resume();
	}

	@Override
	protected void onPause() {
		super.onPause();
		ourSurfaceView.pause();
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		x = event.getX();
		y = event.getY();
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:

			sX = event.getX();
			sY = event.getY();
			dX = 0;
			dY = 0;
			animatedX = 0;
			animatedY = 0;
			scaledX = 0;
			scaledY = 0;
			fX = 0;
			fY = 0;
			break;
		case MotionEvent.ACTION_UP:
			fX = event.getX();
			fY = event.getY();
			dX = fX - sX;
			dY = fY - sY;
			scaledX = dX / 30;
			scaledY = dY / 30;
			x = 0;
			y = 0;
			break;
		}
		return true;
	}

	public class DrawSurface extends SurfaceView implements Runnable {
		SurfaceHolder holder;
		Thread th = null;
		Boolean isRunning = false;
		Canvas canvas;

		public DrawSurface(Context context) {
			super(context);
			holder = getHolder();

		}

		public void pause() {
			isRunning = false;
			while (true) {
				try {
					th.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				break;
			}
			th = null;
		}

		public void resume() {
			isRunning = true;
			th = new Thread(this);
			th.start();
		}

		@Override
		public void run() {
			while (isRunning == true) {
				if (!holder.getSurface().isValid()) {
					continue;
				}
				canvas = holder.lockCanvas();
				canvas.drawRGB(2, 70, 200);
				if (x != 0 && y != 0) {
					canvas.drawBitmap(ball, x - ball.getWidth() / 2,
							y - ball.getHeight() / 2, null);
				}
				if (sX != 0 && sY != 0) {
					canvas.drawBitmap(plus, sX - plus.getWidth() / 2,
							sY - ball.getHeight() / 2, null);
				}
				if (fX != 0 && fY != 0) {
					canvas.drawBitmap(ball, fX - ball.getWidth() / 2
							- animatedX, fY - ball.getHeight() / 2 - animatedY,
							null);
					canvas.drawBitmap(plus, fX - plus.getWidth() / 2,
							fY - plus.getHeight() / 2, null);
				}
				animatedX = animatedX + scaledX;
				animatedY = animatedY + scaledY;
				holder.unlockCanvasAndPost(canvas);
			}
		}
	}
}
