package com.samsung.android.livetranslation.util;

import android.graphics.Point;
import android.graphics.PointF;
import com.samsung.android.livetranslation.geometry.SmallestSurroundingRectangle;
import com.samsung.android.sdk.ocr.OCRResult;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class OCRResultUtils {
    private static final boolean DEBUGLOG_ENABLE = false;
    private static final String TAG = "OCRResultUtils";
    protected static final int THRESHOLD_HEIGHT = 200;
    protected static final int THRESHOLD_HEIGHT_SMALL = 170;
    protected static final int THRESHOLD_WIDTH = 30;
    protected static final int THRESHOLD_WIDTH_MAX = 5;

    public static Point[] calculateRotatedOrderedRect(ArrayList<OCRResult.LineData> arrayList) {
        if (arrayList.size() == 1) {
            return arrayList.get(0).getRect();
        }
        Point[] pointArrCalculateRotatedRect = calculateRotatedRect(arrayList);
        if (isDebugLTTLoggerEnable()) {
            LTTLogger.m5582e(TAG, "calculateRotatedOrderedRect : E " + arrayList.size());
            int length = pointArrCalculateRotatedRect.length;
            for (int i = 0; i < length; i++) {
                LTTLogger.m5582e(TAG, "calculateRotatedOrderedRect result : " + pointArrCalculateRotatedRect[i]);
            }
        }
        double[] dArr = new double[4];
        for (OCRResult.LineData lineData : arrayList) {
            for (int i2 = 0; i2 < 4; i2++) {
                dArr[i2] = getDistance(pointArrCalculateRotatedRect[i2], lineData.getRect()[0]) + dArr[i2];
            }
        }
        if (isDebugLTTLoggerEnable()) {
            for (int i4 = 0; i4 < 4; i4++) {
                LTTLogger.m5582e(TAG, "calculateRotatedOrderedRect distance : " + dArr[i4]);
            }
        }
        double d = dArr[0];
        int i5 = 0;
        for (int i6 = 1; i6 < 4; i6++) {
            double d2 = dArr[i6];
            if (d2 < d) {
                i5 = i6;
                d = d2;
            }
        }
        Point[] pointArr = new Point[4];
        for (int i7 = 0; i7 < 4; i7++) {
            pointArr[i7] = pointArrCalculateRotatedRect[(i7 + i5) % 4];
        }
        if (isDebugLTTLoggerEnable()) {
            for (int i8 = 0; i8 < 4; i8++) {
                LTTLogger.m5581d(TAG, "calculateRotatedOrderedRect finalResultPoints : " + pointArr[i8]);
            }
        }
        return pointArr;
    }

    public static Point[] calculateRotatedRect(ArrayList<OCRResult.LineData> arrayList) {
        if (arrayList.size() == 1) {
            return arrayList.get(0).getRect();
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<OCRResult.LineData> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.addAll(Arrays.asList((PointF[]) Arrays.stream(it.next().getRect()).map(new C7170a(1)).toArray(new C7180k())));
        }
        return SmallestSurroundingRectangle.computePolys(arrayList2);
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x0318 A[LOOP:2: B:19:0x00b1->B:63:0x0318, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void convertOCRResult(OCRResult oCRResult) {
        ArrayList<OCRResult.BlockData> arrayList;
        Iterator<OCRResult.BlockData> it;
        int i;
        String str;
        int i2;
        int i4;
        String str2;
        int i5;
        int i6;
        int i7;
        LTTLogger.m5583i(TAG, "convertOCRResult E");
        ArrayList<OCRResult.BlockData> blockDataList = oCRResult.getBlockDataList();
        if (blockDataList == null || blockDataList.isEmpty()) {
            return;
        }
        int size = blockDataList.size();
        ArrayList<OCRResult.BlockData> arrayList2 = new ArrayList<>();
        Iterator<OCRResult.BlockData> it2 = blockDataList.iterator();
        while (it2.hasNext()) {
            OCRResult.BlockData next = it2.next();
            String str3 = "]: ";
            if (isDebugLTTLoggerEnable()) {
                LTTLogger.m5582e(TAG, "block a[" + next.getAngle() + "]w[" + getWidthDistance(next.getRect()) + "]h[" + getHeightDistance(next.getRect()) + "]: " + next.getText());
                for (Point point : next.getRect()) {
                    LTTLogger.m5582e(TAG, "o blockPoint : " + point);
                }
            }
            int widthDistance = getWidthDistance(next.getRect());
            int i8 = (widthDistance * 30) / 100;
            int i9 = (widthDistance * 5) / 100;
            ArrayList<OCRResult.LineData> lineDataList = next.getLineDataList();
            if (lineDataList == null) {
                return;
            }
            int size2 = lineDataList.size();
            int i10 = 0;
            while (true) {
                ArrayList<OCRResult.LineData> arrayList3 = new ArrayList<>();
                arrayList = blockDataList;
                arrayList3.add(lineDataList.get(i10));
                it = it2;
                String str4 = "] : ";
                int i11 = widthDistance;
                if (isDebugLTTLoggerEnable()) {
                    i = size;
                    StringBuilder sb = new StringBuilder("block.lines a[");
                    str = str3;
                    sb.append(lineDataList.get(i10).getAngle());
                    sb.append("]w[");
                    sb.append(getWidthDistance(lineDataList.get(i10).getRect()));
                    sb.append("]h[");
                    sb.append(getHeightDistance(lineDataList.get(i10).getRect()));
                    sb.append("] : ");
                    sb.append(lineDataList.get(i10).getText());
                    LTTLogger.m5582e(TAG, sb.toString());
                    Point[] rect = lineDataList.get(i10).getRect();
                    int i12 = 0;
                    for (int length = rect.length; i12 < length; length = length) {
                        int i13 = i12;
                        LTTLogger.m5582e(TAG, "linePoint : " + rect[i13]);
                        i12 = i13 + 1;
                    }
                } else {
                    i = size;
                    str = str3;
                }
                int i14 = i10 + 1;
                int i15 = i14;
                while (true) {
                    if (i14 >= size2) {
                        i2 = i15;
                        i4 = size2;
                        break;
                    }
                    int widthDistance2 = getWidthDistance(lineDataList.get(i14).getRect());
                    int i16 = i14 - 1;
                    int widthDistance3 = getWidthDistance(lineDataList.get(i16).getRect());
                    i2 = i15;
                    int heightDistance = getHeightDistance(lineDataList.get(i14).getRect());
                    int heightDistance2 = getHeightDistance(lineDataList.get(i16).getRect());
                    i4 = size2;
                    int iMax = Math.max(heightDistance, heightDistance2);
                    int iMin = Math.min(heightDistance, heightDistance2);
                    int i17 = i11 - widthDistance3;
                    if ((i17 > i9 && i11 - widthDistance2 > i8) || i17 > i8 || (i6 = (iMax * 100) / iMin) > 200 || (iMax < 100 && i6 > 170)) {
                        break;
                    }
                    arrayList3.add(lineDataList.get(i14));
                    int i18 = i2 + 1;
                    if (isDebugLTTLoggerEnable()) {
                        LTTLogger.m5582e(TAG, "block.lines a[" + lineDataList.get(i14).getAngle() + "] w[" + getWidthDistance(lineDataList.get(i14).getRect()) + "]h[" + getHeightDistance(lineDataList.get(i14).getRect()) + str4 + lineDataList.get(i14).getText());
                        Point[] rect2 = lineDataList.get(i14).getRect();
                        int length2 = rect2.length;
                        i7 = i18;
                        int i19 = 0;
                        while (i19 < length2) {
                            int i20 = i19;
                            LTTLogger.m5582e(TAG, "linePoint : " + rect2[i20]);
                            i19 = i20 + 1;
                            str4 = str4;
                        }
                    } else {
                        i7 = i18;
                    }
                    i14++;
                    i15 = i7;
                    size2 = i4;
                    str4 = str4;
                }
                if (next.getLineDataList().size() == arrayList3.size()) {
                    arrayList2.add(next);
                } else {
                    OCRResult.BlockData blockData = new OCRResult.BlockData();
                    blockData.setRect(calculateRotatedOrderedRect(arrayList3));
                    blockData.setAngle(next.getAngle());
                    blockData.setLineDataList(arrayList3);
                    arrayList2.add(blockData);
                    if (isDebugLTTLoggerEnable()) {
                        StringBuilder sb2 = new StringBuilder("newBlock a[");
                        sb2.append(blockData.getAngle());
                        sb2.append(" / ");
                        sb2.append(getOrientationWithPoly(blockData.getRect()));
                        sb2.append("]w[");
                        sb2.append(getWidthDistance(blockData.getRect()));
                        sb2.append("]h[");
                        sb2.append(getHeightDistance(blockData.getRect()));
                        str2 = str;
                        sb2.append(str2);
                        sb2.append(blockData.getText());
                        LTTLogger.m5582e(TAG, sb2.toString());
                        for (Point point2 : blockData.getRect()) {
                            LTTLogger.m5582e(TAG, "newBlock : " + point2);
                        }
                    }
                    i5 = i4;
                    i10 = i2;
                    if (i10 < i5) {
                        break;
                    }
                    size2 = i5;
                    str3 = str2;
                    size = i;
                    blockDataList = arrayList;
                    it2 = it;
                    widthDistance = i11;
                }
                str2 = str;
                i5 = i4;
                i10 = i2;
                if (i10 < i5) {
                }
            }
            size = i;
            blockDataList = arrayList;
            it2 = it;
        }
        blockDataList.clear();
        oCRResult.setBlockDataList(arrayList2);
        LTTLogger.m5583i(TAG, "convertOCRResult : X [" + size + "=>" + oCRResult.getBlockDataList().size() + "]");
    }

    public static double getDistance(Point point, Point point2) {
        return Math.sqrt(Math.pow(point2.y - point.y, 2.0d) + Math.pow(point2.x - point.x, 2.0d));
    }

    public static int getHeightDistance(Point[] pointArr) {
        if (pointArr.length == 0) {
            return 0;
        }
        return (int) Math.max(getDistance(pointArr[0], pointArr[3]), getDistance(pointArr[1], pointArr[2]));
    }

    private static double getOrientationWithPoly(Point[] pointArr) {
        if (pointArr.length != 4) {
            return 0.0d;
        }
        Point point = pointArr[0];
        Point point2 = pointArr[1];
        Point point3 = new Point();
        int i = point2.x - point.x;
        point3.x = i;
        point3.y = point2.y - point.y;
        double degrees = Math.toDegrees(Math.acos(((double) point3.x) / Math.sqrt(Math.pow(point3.y, 2.0d) + Math.pow(i, 2.0d))));
        if (point3.y < 0) {
            degrees = 360.0d - degrees;
        }
        return 360.0d - degrees;
    }

    public static int getWidthDistance(Point[] pointArr) {
        if (pointArr.length == 0) {
            return 0;
        }
        return (int) Math.max(getDistance(pointArr[0], pointArr[1]), getDistance(pointArr[2], pointArr[3]));
    }

    public static boolean isDebugLTTLoggerEnable() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ PointF lambda$calculateRotatedRect$0(Point point) {
        return new PointF(point.x, point.y);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ PointF[] lambda$calculateRotatedRect$1(int i) {
        return new PointF[i];
    }
}
