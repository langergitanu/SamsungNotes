package com.samsung.android.sdk.pen.ocr;

import android.graphics.Point;
import android.util.Log;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.ArrayList;
import java.util.Iterator;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SpenOcrBlockData {
    private static final String TAG = "SpenOcrBlockData";
    private ArrayList<SpenOcrLineData> mLineDataList;
    private long mUID = 0;
    private Point[] mRect = new Point[4];

    public SpenOcrBlockData() {
        this.mLineDataList = null;
        this.mLineDataList = new ArrayList<>();
    }

    public void add(SpenOcrLineData spenOcrLineData) {
        this.mLineDataList.add(spenOcrLineData);
    }

    public void clear() {
        this.mLineDataList.clear();
    }

    public ArrayList<SpenOcrLineData> getLineDataList() {
        return this.mLineDataList;
    }

    public final Point[] getRect() {
        return this.mRect;
    }

    public String getRectInfo() {
        StringBuilder sb = new StringBuilder();
        for (Point point : this.mRect) {
            if (point != null) {
                sb.append("(");
                sb.append(point.x);
                sb.append(SQLKeyword.COMMA);
                sb.append(point.y);
                sb.append(") ");
            }
        }
        return sb.toString();
    }

    public String getText() {
        StringBuilder sb = new StringBuilder();
        Iterator<SpenOcrLineData> it = this.mLineDataList.iterator();
        while (it.hasNext()) {
            sb.append(it.next().getText());
            sb.append("\n");
        }
        return new String(sb).trim();
    }

    public final long getUID() {
        return this.mUID;
    }

    public boolean scale(float f) {
        for (Point point : this.mRect) {
            point.x = (int) (point.x * f);
            point.y = (int) (point.y * f);
        }
        Iterator<SpenOcrLineData> it = this.mLineDataList.iterator();
        while (it.hasNext()) {
            if (!it.next().scale(f)) {
                return false;
            }
        }
        return true;
    }

    public void setLineDataList(ArrayList<SpenOcrLineData> arrayList) {
        this.mLineDataList.addAll(arrayList);
    }

    public void setRect(Point[] pointArr) {
        this.mRect = pointArr;
        Log.d(TAG, String.format("SpenOcrTextBlock::setRect [LT(%d, %d), RT(%d, %d), RB(%d, %d), LB(%d, %d)]: %s", Integer.valueOf(pointArr[0].x), Integer.valueOf(this.mRect[0].y), Integer.valueOf(this.mRect[1].x), Integer.valueOf(this.mRect[1].y), Integer.valueOf(this.mRect[2].x), Integer.valueOf(this.mRect[2].y), Integer.valueOf(this.mRect[3].x), Integer.valueOf(this.mRect[3].y)));
    }

    public void setUID(long j) {
        this.mUID = j;
    }

    public void setRect(int[] iArr, int i) {
        if (i < 8) {
            Log.e(TAG, String.format(AbstractC0000a.m11h(i, "SpenOcrTextBlock::setRect rect(int array)'s length is "), new Object[0]));
            return;
        }
        StringBuilder sbM778t = AbstractC0541b.m778t(i, "SpenOcrTextBlock::setRect len : ", ", length : ");
        sbM778t.append(iArr.length);
        Log.d(TAG, sbM778t.toString());
        Point[] pointArr = {new Point(iArr[0], iArr[1]), new Point(iArr[2], iArr[3]), new Point(iArr[4], iArr[5]), new Point(iArr[6], iArr[7])};
        this.mRect = pointArr;
        Log.d(TAG, String.format("SpenOcrTextBlock::setRect [LT(%d, %d), RT(%d, %d), RB(%d, %d), LB(%d, %d)]", Integer.valueOf(pointArr[0].x), Integer.valueOf(this.mRect[0].y), Integer.valueOf(this.mRect[1].x), Integer.valueOf(this.mRect[1].y), Integer.valueOf(this.mRect[2].x), Integer.valueOf(this.mRect[2].y), Integer.valueOf(this.mRect[3].x), Integer.valueOf(this.mRect[3].y)));
    }
}
