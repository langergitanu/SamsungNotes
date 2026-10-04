package com.samsung.android.imagetranslation.util;

import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.Size;
import androidx.collection.AbstractC0622a;
import com.samsung.android.imagetranslation.common.LTTLogger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SceneTextUtil {
    private static final float ENLARGEMENT_RATIO = 1.0f;
    private static final int FONT_WEIGHT = 500;
    private static final String TAG = "SceneTextUtil";

    public static void addLangToMap(ArrayList<String> arrayList, LinkedHashMap<String, Integer> linkedHashMap) {
        for (String str : arrayList) {
            if (!"".equals(str)) {
                Integer num = linkedHashMap.get(str);
                linkedHashMap.put(str, Integer.valueOf(num != null ? 1 + num.intValue() : 1));
            }
        }
    }

    public static Matrix generateRotationMatrix(int i, int i2, float f, int i4) {
        float[] fArr;
        float[] fArr2;
        float[] fArr3;
        float[] fArr4;
        String str = TAG;
        StringBuilder sbM1173s = AbstractC0622a.m1173s(i, i2, "generateRotationMatrix IN  : Width=", " Height=", " ResizeRatio=");
        sbM1173s.append(f);
        sbM1173s.append(" Orientation=");
        sbM1173s.append(i4);
        LTTLogger.m5458d(str, sbM1173s.toString());
        float f4 = i;
        int i5 = (int) ((f4 * 1.0f) / f);
        float f5 = i2;
        int i6 = (int) ((1.0f * f5) / f);
        StringBuilder sbM1173s2 = AbstractC0622a.m1173s(i5, i6, "generateRotationMatrix OUT : Width=", " Height=", " ResizeRatio=");
        sbM1173s2.append(f);
        sbM1173s2.append(" Orientation=");
        sbM1173s2.append(i4);
        LTTLogger.m5458d(str, sbM1173s2.toString());
        if (i4 == 0) {
            fArr = new float[]{0.0f, 0.0f, f4, 0.0f, f4, f5, 0.0f, f5};
            float f6 = i5;
            float f7 = i6;
            fArr2 = new float[]{0.0f, 0.0f, f6, 0.0f, f6, f7, 0.0f, f7};
        } else if (i4 == 90) {
            fArr = new float[]{f4, 0.0f, f4, f5, 0.0f, f5, 0.0f, 0.0f};
            float f8 = i6;
            float f9 = i5;
            fArr2 = new float[]{0.0f, 0.0f, f8, 0.0f, f8, f9, 0.0f, f9};
        } else if (i4 == 180) {
            fArr = new float[]{f4, f5, 0.0f, f5, 0.0f, 0.0f, f4, 0.0f};
            float f10 = i5;
            float f11 = i6;
            fArr2 = new float[]{0.0f, 0.0f, f10, 0.0f, f10, f11, 0.0f, f11};
        } else {
            if (i4 != 270) {
                fArr4 = null;
                fArr3 = null;
                Matrix matrix = new Matrix();
                matrix.setPolyToPoly(fArr4, 0, fArr3, 0, 4);
                return matrix;
            }
            fArr = new float[]{0.0f, f5, 0.0f, 0.0f, f4, 0.0f, f4, f5};
            float f12 = i6;
            float f13 = i5;
            fArr2 = new float[]{0.0f, 0.0f, f12, 0.0f, f12, f13, 0.0f, f13};
        }
        fArr3 = fArr2;
        fArr4 = fArr;
        Matrix matrix2 = new Matrix();
        matrix2.setPolyToPoly(fArr4, 0, fArr3, 0, 4);
        return matrix2;
    }

    public static Point getCeneterPoint(Point[] pointArr) {
        int i = 0;
        int i2 = 0;
        for (Point point : pointArr) {
            i += point.x;
            i2 += point.y;
        }
        return new Point(i / 4, i2 / 4);
    }

    public static int getLongestLine(ArrayList<String> arrayList, Paint paint) {
        int textWidth;
        int i = 0;
        int i2 = 0;
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            if (arrayList.get(i4).length() >= ((double) arrayList.get(i).length()) * 0.8d && (textWidth = getTextWidth(arrayList.get(i4), paint)) > i2) {
                i = i4;
                i2 = textWidth;
            }
        }
        return i;
    }

    public static int getMaxTextSize(ArrayList<String> arrayList, Paint paint) {
        Iterator<String> it = arrayList.iterator();
        int iMax = 0;
        while (it.hasNext()) {
            iMax = Math.max(iMax, getTextHeight(it.next(), paint));
        }
        return iMax;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00b0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Size getOptimalLineMaskSize(Point[] pointArr, String str, int i) {
        int i2;
        float f;
        float f4;
        int i4;
        int[] iArr = new int[4];
        int[] iArr2 = new int[4];
        int[] iArr3 = {0, 1, 2, 3, 0};
        int i5 = 0;
        while (i5 < 4) {
            int i6 = i5 + 1;
            iArr[i5] = Math.abs(pointArr[iArr3[i5]].x - pointArr[iArr3[i6]].x) + 1;
            iArr2[i5] = Math.abs(pointArr[iArr3[i5]].y - pointArr[iArr3[i6]].y) + 1;
            i5 = i6;
        }
        float[] fArr = new float[4];
        float f5 = 1.0E20f;
        int i7 = 0;
        for (int i8 = 0; i8 < 4; i8++) {
            int i9 = iArr[i8];
            int i10 = iArr2[i8];
            float fSqrt = (float) Math.sqrt((i10 * i10) + (i9 * i9));
            fArr[i8] = fSqrt;
            if (fSqrt < f5) {
                i7 = i8;
                f5 = fSqrt;
            }
        }
        if (str.length() > 2) {
            i2 = (int) (((fArr[(i7 + 1) % 4] + fArr[(i7 + 3) % 4]) * 1.0f) / 2.0f);
            f = fArr[i7];
            f4 = fArr[(i7 + 2) % 4];
        } else if (i == 0 || i == 180) {
            i2 = (int) (((fArr[0] + fArr[2]) * 1.0f) / 2.0f);
            f = fArr[1];
            f4 = fArr[3];
        } else {
            if (i != 90 && i != 270) {
                i2 = -1;
                i4 = -1;
                if (i2 >= i4) {
                    int i11 = i2;
                    i2 = i4;
                    i4 = i11;
                }
                return new Size(i4, i2);
            }
            i2 = (int) (((fArr[1] + fArr[3]) * 1.0f) / 2.0f);
            f = fArr[0];
            f4 = fArr[2];
        }
        i4 = (int) (((f + f4) * 1.0f) / 2.0f);
        if (i2 >= i4) {
        }
        return new Size(i4, i2);
    }

    public static Paint getTextAlignedPaint(int i) {
        Paint paint = new Paint();
        if (i == 0) {
            paint.setTextAlign(Paint.Align.LEFT);
        } else if (i == 1) {
            paint.setTextAlign(Paint.Align.CENTER);
        } else if (i != 2) {
            LTTLogger.m5459e(TAG, "Align mode is not correct");
        } else {
            paint.setTextAlign(Paint.Align.RIGHT);
        }
        paint.setColor(-1);
        paint.setAntiAlias(true);
        Typeface typeface = Typeface.DEFAULT;
        paint.setTypeface(Typeface.create(Typeface.DEFAULT, 500, false));
        return paint;
    }

    public static int getTextBottom(String str, Paint paint) {
        Rect rect = new Rect();
        paint.getTextBounds(str, 0, str.length(), rect);
        return rect.bottom;
    }

    public static int getTextHeight(String str, Paint paint) {
        Rect rect = new Rect();
        paint.getTextBounds(str, 0, str.length(), rect);
        return rect.height();
    }

    public static int getTextWidth(String str, Paint paint) {
        Rect rect = new Rect();
        paint.getTextBounds(str, 0, str.length(), rect);
        return rect.width();
    }

    public static Point[] getTrsTextMaskPoly(int i, int i2, int i4, int i5) {
        Point[] pointArr = new Point[4];
        for (int i6 = 0; i6 < 4; i6++) {
            pointArr[i6] = new Point();
        }
        if (i == 0) {
            Point point = pointArr[0];
            point.x = 0;
            point.y = i2;
            Point point2 = pointArr[1];
            int i7 = i4 - 1;
            point2.x = i7;
            point2.y = i2;
            Point point3 = pointArr[2];
            point3.x = i7;
            int i8 = (i2 + i5) - 1;
            point3.y = i8;
            Point point4 = pointArr[3];
            point4.x = 0;
            point4.y = i8;
            return pointArr;
        }
        if (i == 90) {
            Point point5 = pointArr[0];
            int i9 = i4 - 1;
            point5.x = i9;
            point5.y = i2;
            Point point6 = pointArr[1];
            point6.x = i9;
            int i10 = (i5 + i2) - 1;
            point6.y = i10;
            Point point7 = pointArr[2];
            point7.x = 0;
            point7.y = i10;
            Point point8 = pointArr[3];
            point8.x = 0;
            point8.y = i2;
            return pointArr;
        }
        if (i == 180) {
            Point point9 = pointArr[0];
            int i11 = i4 - 1;
            point9.x = i11;
            int i12 = (i5 + i2) - 1;
            point9.y = i12;
            Point point10 = pointArr[1];
            point10.x = 0;
            point10.y = i12;
            Point point11 = pointArr[2];
            point11.x = 0;
            point11.y = i2;
            Point point12 = pointArr[3];
            point12.x = i11;
            point12.y = i2;
            return pointArr;
        }
        if (i != 270) {
            LTTLogger.m5459e(TAG, "Device orientation is not correct");
            return pointArr;
        }
        Point point13 = pointArr[0];
        point13.x = 0;
        int i13 = (i5 + i2) - 1;
        point13.y = i13;
        Point point14 = pointArr[1];
        point14.x = 0;
        point14.y = i2;
        Point point15 = pointArr[2];
        int i14 = i4 - 1;
        point15.x = i14;
        point15.y = i2;
        Point point16 = pointArr[3];
        point16.x = i14;
        point16.y = i13;
        return pointArr;
    }

    private static Point[] reArrangePoly(Point[] pointArr, int i) {
        if (i == 0) {
            return pointArr;
        }
        int i2 = i != 90 ? i != 180 ? i != 270 ? 0 : 1 : 2 : -1;
        List listAsList = Arrays.asList(pointArr);
        Collections.rotate(listAsList, i2);
        return (Point[]) listAsList.toArray(new Point[listAsList.size()]);
    }

    public static Point[] rotatePoly(Point[] pointArr, String str, Matrix matrix, int i) {
        float[] fArr = new float[pointArr.length * 2];
        float[] fArr2 = new float[pointArr.length * 2];
        for (int i2 = 0; i2 < pointArr.length; i2++) {
            int i4 = i2 * 2;
            Point point = pointArr[i2];
            fArr[i4] = point.x;
            fArr[i4 + 1] = point.y;
        }
        matrix.mapPoints(fArr2, fArr);
        int length = pointArr.length;
        Point[] pointArr2 = new Point[length];
        for (int i5 = 0; i5 < length; i5++) {
            int i6 = i5 * 2;
            pointArr2[i5] = new Point((int) fArr2[i6], (int) fArr2[i6 + 1]);
        }
        return reArrangePoly(pointArr2, i);
    }

    public static int getLongestLine(String[] strArr, Paint paint) {
        int textWidth;
        int i = 0;
        int i2 = 0;
        for (int i4 = 0; i4 < strArr.length; i4++) {
            if (strArr[i4].length() >= ((double) strArr[i].length()) * 0.8d && (textWidth = getTextWidth(strArr[i4], paint)) > i2) {
                i = i4;
                i2 = textWidth;
            }
        }
        return i;
    }
}
