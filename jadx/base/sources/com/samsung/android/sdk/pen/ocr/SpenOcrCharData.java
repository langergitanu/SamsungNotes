package com.samsung.android.sdk.pen.ocr;

import android.graphics.Point;
import android.util.Log;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SpenOcrCharData {
    private static final String TAG = "SpenOcrCharData";
    private float mAngle = 0.0f;
    private Point[] mRect;
    private String mText;

    public SpenOcrCharData() {
        clear();
    }

    public void clear() {
        this.mText = "";
    }

    public final float getAngle() {
        return this.mAngle;
    }

    public final Point[] getRect() {
        return this.mRect;
    }

    public final String getText() {
        return this.mText;
    }

    public Point[] getTextRect() {
        Log.w(TAG, "SpenOcrCharData.getTextRect() was deprecated. Use getRect() instead!");
        return this.mRect;
    }

    public boolean scale(float f) {
        for (Point point : this.mRect) {
            point.x = (int) (point.x * f);
            point.y = (int) (point.y * f);
        }
        return true;
    }

    public void setAngle(float f) {
        this.mAngle = f;
    }

    public void setRect(Point[] pointArr) {
        this.mRect = pointArr;
        Log.d(TAG, String.format("SpenOcrCharData::setRect [LT(%d, %d), RT(%d, %d), RB(%d, %d), LB(%d, %d)]", Integer.valueOf(pointArr[0].x), Integer.valueOf(this.mRect[0].y), Integer.valueOf(this.mRect[1].x), Integer.valueOf(this.mRect[1].y), Integer.valueOf(this.mRect[2].x), Integer.valueOf(this.mRect[2].y), Integer.valueOf(this.mRect[3].x), Integer.valueOf(this.mRect[3].y)));
    }

    public void setText(String str) {
        this.mText = str;
    }

    public void setRect(int[] iArr, int i) {
        if (i < 8) {
            Log.e(TAG, String.format(AbstractC0000a.m11h(i, "SpenOcrCharData::setRect rect(int array)'s length is "), new Object[0]));
            return;
        }
        Point[] pointArr = {new Point(iArr[0], iArr[1]), new Point(iArr[2], iArr[3]), new Point(iArr[4], iArr[5]), new Point(iArr[6], iArr[7])};
        this.mRect = pointArr;
        Log.d(TAG, String.format("SpenOcrWordData::setRect [LT(%d, %d), RT(%d, %d), RB(%d, %d), LB(%d, %d)]", Integer.valueOf(pointArr[0].x), Integer.valueOf(this.mRect[0].y), Integer.valueOf(this.mRect[1].x), Integer.valueOf(this.mRect[1].y), Integer.valueOf(this.mRect[2].x), Integer.valueOf(this.mRect[2].y), Integer.valueOf(this.mRect[3].x), Integer.valueOf(this.mRect[3].y)));
    }
}
