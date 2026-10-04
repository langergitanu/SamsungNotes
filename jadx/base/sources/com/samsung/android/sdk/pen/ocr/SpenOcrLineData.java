package com.samsung.android.sdk.pen.ocr;

import android.graphics.Point;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SpenOcrLineData {
    private static final String TAG = "SpenOcrLineData";
    private Point[] mRect;
    private ArrayList<SpenOcrWordData> mWordDataList;
    private float mAngle = 0.0f;
    private long mUID = 0;

    public SpenOcrLineData() {
        this.mWordDataList = null;
        this.mWordDataList = new ArrayList<>();
    }

    public void add(SpenOcrWordData spenOcrWordData) {
        this.mWordDataList.add(spenOcrWordData);
    }

    public void clear() {
        this.mWordDataList.clear();
    }

    public final float getAngle() {
        return this.mAngle;
    }

    public final Point[] getRect() {
        return this.mRect;
    }

    public final String getText() {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < this.mWordDataList.size()) {
            sb.append(this.mWordDataList.get(i).getText());
            i++;
            if (i < this.mWordDataList.size()) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public final long getUID() {
        return this.mUID;
    }

    public ArrayList<SpenOcrWordData> getWordDataList() {
        return this.mWordDataList;
    }

    public boolean scale(float f) {
        for (Point point : this.mRect) {
            point.x = (int) (point.x * f);
            point.y = (int) (point.y * f);
        }
        Iterator<SpenOcrWordData> it = this.mWordDataList.iterator();
        while (it.hasNext()) {
            if (!it.next().scale(f)) {
                return false;
            }
        }
        return true;
    }

    public void setAngle(float f) {
        this.mAngle = f;
    }

    public void setRect(Point[] pointArr) {
        this.mRect = pointArr;
        Log.d(TAG, String.format("SpenOcrLineData::setRect [LT(%d, %d), RT(%d, %d), RB(%d, %d), LB(%d, %d)]", Integer.valueOf(pointArr[0].x), Integer.valueOf(this.mRect[0].y), Integer.valueOf(this.mRect[1].x), Integer.valueOf(this.mRect[1].y), Integer.valueOf(this.mRect[2].x), Integer.valueOf(this.mRect[2].y), Integer.valueOf(this.mRect[3].x), Integer.valueOf(this.mRect[3].y)));
    }

    public void setUID(long j) {
        this.mUID = j;
    }

    public void setWordDataList(ArrayList<SpenOcrWordData> arrayList) {
        this.mWordDataList.addAll(arrayList);
    }

    public void setRect(int[] iArr, int i) {
        if (i < 8) {
            Log.e(TAG, String.format(AbstractC0000a.m11h(i, "SpenOcrLineData::setRect rect(int array)'s length is "), new Object[0]));
            return;
        }
        Point[] pointArr = {new Point(iArr[0], iArr[1]), new Point(iArr[2], iArr[3]), new Point(iArr[4], iArr[5]), new Point(iArr[6], iArr[7])};
        this.mRect = pointArr;
        Log.d(TAG, String.format("SpenOcrLineData::setRect [LT(%d, %d), RT(%d, %d), RB(%d, %d), LB(%d, %d)]", Integer.valueOf(pointArr[0].x), Integer.valueOf(this.mRect[0].y), Integer.valueOf(this.mRect[1].x), Integer.valueOf(this.mRect[1].y), Integer.valueOf(this.mRect[2].x), Integer.valueOf(this.mRect[2].y), Integer.valueOf(this.mRect[3].x), Integer.valueOf(this.mRect[3].y)));
    }
}
