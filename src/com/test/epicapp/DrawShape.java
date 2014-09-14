package com.test.epicapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.View;

public class DrawShape extends View {
	Bitmap gBall;
	float cY;
	Rect middleRect;
	Paint color, textPaint;
	Typeface font;

	public DrawShape(Context context) {
		super(context);
		gBall = BitmapFactory.decodeResource(getResources(),
				R.drawable.awesome_ball);
		cY = 0;
		font = Typeface.createFromAsset(context.getAssets(), "Summertime.ttf");
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		canvas.drawColor(Color.WHITE);
		textPaint = new Paint();
		textPaint.setARGB(50, 60, 60, 160);
		textPaint.setTextAlign(Align.CENTER);
		textPaint.setTextSize(20);
		textPaint.setTypeface(font);
		canvas.drawText("Awesome font.", canvas.getWidth()/2, 75, textPaint);
		canvas.drawBitmap(gBall, (canvas.getWidth() / 2)-25, cY, null);
		if (cY < canvas.getHeight()) {
			cY += 10;
		} else {
			cY = 0;
		}
		middleRect = new Rect();
		middleRect.set(0, 200, canvas.getWidth(), 300);
		color = new Paint();
		color.setColor(Color.BLUE);
		canvas.drawRect(middleRect, color);

		invalidate();
	}

}
