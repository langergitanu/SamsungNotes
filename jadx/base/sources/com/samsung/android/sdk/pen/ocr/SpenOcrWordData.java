package com.samsung.android.sdk.pen.ocr;

import android.graphics.Point;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SpenOcrWordData {
    private static final String TAG = "SpenOcrWordData";
    private ArrayList<SpenOcrCharData> mCharDataList;
    private Point[] mPoly;
    private Point[] mRect;
    private String mLegacyText = "";
    private final ArrayList<Point[]> mCharRects = new ArrayList<>();
    private float mAngle = 0.0f;

    public SpenOcrWordData() {
        this.mCharDataList = null;
        this.mCharDataList = new ArrayList<>();
        clear();
    }

    public void add(SpenOcrCharData spenOcrCharData) {
        this.mCharDataList.add(spenOcrCharData);
    }

    public void clear() {
        this.mCharDataList.clear();
        this.mLegacyText = "";
    }

    public final float getAngle() {
        return this.mAngle;
    }

    public ArrayList<SpenOcrCharData> getCharDataList() {
        return this.mCharDataList;
    }

    public ArrayList<Point[]> getCharRects() {
        return this.mCharRects;
    }

    public String getLegacyText() {
        return this.mLegacyText;
    }

    public final Point[] getPoly() {
        return this.mPoly;
    }

    public final Point[] getRect() {
        return this.mRect;
    }

    public final String getText() {
        StringBuilder sb = new StringBuilder();
        Iterator<SpenOcrCharData> it = this.mCharDataList.iterator();
        while (it.hasNext()) {
            sb.append(it.next().getText());
        }
        return sb.toString();
    }

    public Point[] getTextRect() {
        Log.w(TAG, "SpenOcrWordData.getTextRect() was deprecated. Use getRect() instead!");
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

    public void setCharDataList(ArrayList<SpenOcrCharData> arrayList) {
        this.mCharDataList.addAll(arrayList);
    }

    public void setCharRects(int[] iArr) {
        if (iArr == null || iArr.length % 8 != 0) {
            Log.e(TAG, "SpenOcrWordData::setCharRects array either null or has size not multiple of 8");
            return;
        }
        this.mCharRects.clear();
        for (int i = 0; i < iArr.length; i += 8) {
            this.mCharRects.add(new Point[]{new Point(iArr[i], iArr[i + 1]), new Point(iArr[i + 2], iArr[i + 3]), new Point(iArr[i + 4], iArr[i + 5]), new Point(iArr[i + 6], iArr[i + 7])});
        }
    }

    public void setPoly(int[] iArr, int i) {
        if (iArr == null || i <= 0) {
            Log.e(TAG, String.format(AbstractC0000a.m11h(i, "SpenOcrWordData::setPoly poly is null or zero-length : len = "), new Object[0]));
            return;
        }
        int i2 = i / 2;
        Point[] pointArr = new Point[i2];
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = i4 * 2;
            pointArr[i4] = new Point(iArr[i5], iArr[i5 + 1]);
        }
        this.mPoly = pointArr;
    }

    public void setRect(Point[] pointArr) {
        this.mRect = pointArr;
        Log.d(TAG, String.format("SpenOcrWordData::setRect [LT(%d, %d), RT(%d, %d), RB(%d, %d), LB(%d, %d)]", Integer.valueOf(pointArr[0].x), Integer.valueOf(this.mRect[0].y), Integer.valueOf(this.mRect[1].x), Integer.valueOf(this.mRect[1].y), Integer.valueOf(this.mRect[2].x), Integer.valueOf(this.mRect[2].y), Integer.valueOf(this.mRect[3].x), Integer.valueOf(this.mRect[3].y)));
    }

    public void setText(String str) {
        this.mLegacyText = str;
    }

    public void setRect(int[] iArr, int i) {
        if (i < 8) {
            Log.e(TAG, String.format(AbstractC0000a.m11h(i, "SpenOcrWordData::setRect rect(int array)'s length is "), new Object[0]));
            return;
        }
        Point[] pointArr = {new Point(iArr[0], iArr[1]), new Point(iArr[2], iArr[3]), new Point(iArr[4], iArr[5]), new Point(iArr[6], iArr[7])};
        this.mRect = pointArr;
        Log.d(TAG, String.format("SpenOcrWordData::setRect [LT(%d, %d), RT(%d, %d), RB(%d, %d), LB(%d, %d)]", Integer.valueOf(pointArr[0].x), Integer.valueOf(this.mRect[0].y), Integer.valueOf(this.mRect[1].x), Integer.valueOf(this.mRect[1].y), Integer.valueOf(this.mRect[2].x), Integer.valueOf(this.mRect[2].y), Integer.valueOf(this.mRect[3].x), Integer.valueOf(this.mRect[3].y)));
    }
}
