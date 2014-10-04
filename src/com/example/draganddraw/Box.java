package com.example.draganddraw;

import android.graphics.PointF;

public class Box {

	private PointF originPoint;
	private PointF currentPoint;

	public Box(PointF originPoint) {
		this.originPoint = this.currentPoint = originPoint;
	}

	public PointF getCurrentPoint() {
		return currentPoint;
	}

	public void setCurrentPoint(PointF currentPoint) {
		this.currentPoint = currentPoint;
	}

	public PointF getOriginPoint() {
		return originPoint;
	}

}
