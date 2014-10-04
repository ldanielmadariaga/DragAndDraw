package com.example.draganddraw;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class BoxDrawingView extends View {

	public static final String TAG = "BoxDrawingView";

	private Box currentBox;
	private ArrayList<Box> boxes = new ArrayList<Box>();
	private Paint boxPaint;
	private Paint backgroundPaint;

	public BoxDrawingView(Context context) {
		this(context, null);
	}

	public BoxDrawingView(Context context, AttributeSet attributeSet) {
		super(context, attributeSet);

		boxPaint = new Paint();
		boxPaint.setColor(0x22ff0000);

		backgroundPaint = new Paint();
		backgroundPaint.setColor(0xfff8efe0);

	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		PointF currentPointF = new PointF(event.getX(), event.getY());
		Log.i(TAG, "Received an event at x=" + currentPointF.x + ", y=" + currentPointF.y);

		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			Log.i(TAG, "ACTION_DOWN");
			currentBox = new Box(currentPointF);
			boxes.add(currentBox);
			break;

		case MotionEvent.ACTION_MOVE:
			Log.i(TAG, "ACTION_MOVE");
			if (currentBox != null) {
				currentBox.setCurrentPoint(currentPointF);
				invalidate();
			}
			break;

		case MotionEvent.ACTION_UP:
			Log.i(TAG, "ACTION_UP");
			currentBox = null;
			break;

		case MotionEvent.ACTION_CANCEL:
			Log.i(TAG, "ACTION_CANCEL");
			currentBox = null;
			break;
		}

		return true;
	}

	@Override
	protected void onDraw(Canvas canvas) {
		canvas.drawPaint(backgroundPaint);
		for (Box box : boxes) {
			float left = Math.min(box.getOriginPoint().x, box.getCurrentPoint().x);
			float right = Math.max(box.getOriginPoint().x, box.getCurrentPoint().x);
			float top = Math.min(box.getOriginPoint().y, box.getCurrentPoint().y);
			float bottom = Math.max(box.getOriginPoint().y, box.getCurrentPoint().y);

			canvas.drawRect(left, top, right, bottom, boxPaint);
		}
	}
}
