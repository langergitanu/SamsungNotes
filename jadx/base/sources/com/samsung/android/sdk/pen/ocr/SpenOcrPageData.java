package com.samsung.android.sdk.pen.ocr;

import android.graphics.Point;
import android.util.Log;
import com.google.android.material.color.utilities.C4662f;
import com.samsung.android.sdk.ocr.OCRResultUtils;
import com.samsung.android.support.senl.p148nt.model.markdown.generator.model.MarkdownDocument;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import p092W3.C0332a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SpenOcrPageData {
    private static final String TAG = "SpenOcrPageData";
    private ArrayList<SpenOcrBlockData> mTextBlockList;

    public SpenOcrPageData() {
        this.mTextBlockList = null;
        this.mTextBlockList = new ArrayList<>();
    }

    private static boolean isPointInPolygon(Point point, Point[] pointArr) {
        int length = pointArr.length;
        int i = length - 1;
        boolean z = false;
        for (int i2 = 0; i2 < length; i2++) {
            Point point2 = pointArr[i2];
            int i4 = point2.y;
            int i5 = point.y;
            boolean z2 = i4 > i5;
            Point point3 = pointArr[i];
            int i6 = point3.y;
            if (z2 != (i6 > i5)) {
                int i7 = point.x;
                int i8 = point3.x;
                int i9 = point2.x;
                if (i7 < (((i5 - i4) * (i8 - i9)) / (i6 - i4)) + i9) {
                    z = !z;
                }
            }
            i = i2;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Point lambda$findNearestTextBlock$0(SpenOcrBlockData spenOcrBlockData) {
        return OCRResultUtils.getCenterPoint(spenOcrBlockData.getRect());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$findNearestTextBlock$1(Point point, Point point2) {
        return Double.valueOf(Math.pow(point2.y - point.y, 2.0d) + Math.pow(point2.x - point.x, 2.0d));
    }

    public void add(SpenOcrBlockData spenOcrBlockData) {
        this.mTextBlockList.add(spenOcrBlockData);
    }

    public void clear() {
        this.mTextBlockList.clear();
    }

    public int findNearestTextBlock(Point point) {
        if (getTextBlockList().size() <= 0) {
            Log.w(TAG, "There is no detected text block");
            return -1;
        }
        Log.d(TAG, "pivotPoint : " + point.toString());
        List list = (List) getTextBlockList().stream().map(new C4662f(14)).map(new C0332a(point, 4)).collect(Collectors.toList());
        return list.indexOf(Collections.min(list));
    }

    public String getText() {
        StringBuilder sb = new StringBuilder();
        Iterator<SpenOcrBlockData> it = this.mTextBlockList.iterator();
        while (it.hasNext()) {
            sb.append(it.next().getText());
            sb.append(MarkdownDocument.NEW_LINE);
        }
        return new String(sb).trim();
    }

    public ArrayList<SpenOcrBlockData> getTextBlockList() {
        return this.mTextBlockList;
    }

    public boolean scale(float f) {
        Iterator<SpenOcrBlockData> it = this.mTextBlockList.iterator();
        while (it.hasNext()) {
            if (!it.next().scale(f)) {
                return false;
            }
        }
        return true;
    }

    public void setTextBlockList(ArrayList<SpenOcrBlockData> arrayList) {
        this.mTextBlockList.addAll(arrayList);
    }
}
