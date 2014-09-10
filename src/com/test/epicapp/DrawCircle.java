package com.test.epicapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;

public class DrawCircle extends View {

	public DrawCircle(Context context) {
		super(context);
		// TODO Auto-generated constructor stub		
	}

	@Override
	public void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		RectF c = new RectF();
		Rect dst = new Rect();
		c.set(0, 0, 50, 50);
		c.round(dst);
		Paint blue = new Paint();

		blue.setColor(Color.BLUE);
		blue.setStyle(Paint.Style.FILL);

		canvas.drawArc(c, 0, 360, true, blue);
	}

}
