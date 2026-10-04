package com.samsung.android.imagetranslation.util;

import android.graphics.Point;
import androidx.compose.runtime.AbstractC1974b;
import androidx.glance.AbstractC2821a;
import com.samsung.android.imagetranslation.common.LTTLogger;
import com.samsung.android.imagetranslation.jni.SceneText;
import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class TextAlignment {
    public static final int ALIGN_CENTER = 1;
    public static final int ALIGN_LEFT = 0;
    public static final int ALIGN_RIGHT = 2;
    private static final String TAG = "TextAlignment";

    private static boolean[] detectOutliers(SceneText sceneText) {
        boolean z;
        boolean z2;
        int i;
        char c;
        boolean z3 = false;
        Point[] poly = sceneText.getComponents().get(0).getPoly();
        char c2 = 1;
        boolean z4 = Math.abs(poly[0].y - poly[1].y) >= Math.abs(poly[0].x - poly[1].x);
        int size = sceneText.getComponents().size();
        boolean[] zArr = new boolean[size];
        Arrays.fill(zArr, true);
        int i2 = 0;
        boolean z5 = z4;
        while (i2 < size) {
            if (zArr[i2]) {
                int i4 = z3 ? 1 : 0;
                z5 = z5;
                while (i4 < size) {
                    if (i2 != i4) {
                        SceneText sceneText2 = sceneText.getComponents().get(i2);
                        SceneText sceneText3 = sceneText.getComponents().get(i4);
                        Point[] poly2 = sceneText2.getPoly();
                        Point[] poly3 = sceneText3.getPoly();
                        Point point = poly3[z3 ? 1 : 0];
                        double d = point.x;
                        double d2 = point.y;
                        Point point2 = poly3[c2];
                        int i5 = point2.x;
                        z2 = z3 ? 1 : 0;
                        i = size;
                        double d3 = point2.y;
                        Point point3 = poly3[2];
                        c = c2;
                        z = z5;
                        double d4 = point3.x;
                        double d5 = point3.y;
                        Point point4 = poly3[3];
                        int[] rotatedRectangleCenter = getRotatedRectangleCenter(d, d2, i5, d3, d4, d5, point4.x, point4.y);
                        int i6 = rotatedRectangleCenter[z2 ? 1 : 0];
                        int i7 = rotatedRectangleCenter[c];
                        if (z) {
                            int iMin = Math.min(poly2[c].x, poly2[2].x);
                            int iMax = Math.max(poly2[c].x, poly2[2].x);
                            if (i6 >= iMin && i6 <= iMax) {
                                zArr[i2] = z2;
                                zArr[i4] = z2;
                            }
                        } else {
                            int iMin2 = Math.min(poly2[c].y, poly2[2].y);
                            int iMax2 = Math.max(poly2[c].y, poly2[2].y);
                            if (i7 >= iMin2 && i7 <= iMax2) {
                                zArr[i2] = z2;
                                zArr[i4] = z2;
                            }
                        }
                    } else {
                        z = z5;
                        z2 = z3 ? 1 : 0;
                        i = size;
                        c = c2;
                    }
                    i4++;
                    z3 = z2;
                    size = i;
                    c2 = c;
                    z5 = z;
                }
            }
            boolean z6 = z5;
            int i8 = size;
            char c4 = c2;
            i2++;
            z3 = z3 ? 1 : 0;
            size = i8;
            c2 = c4;
            z5 = z6;
        }
        return zArr;
    }

    public static double[] generateLineEquation(double d, double d2, double d3, double d4) {
        if (d == d3) {
            return new double[]{1.0d, 0.0d, -d};
        }
        double d5 = (d4 - d2) / (d3 - d);
        return new double[]{-d5, 1.0d, -((-(d * d5)) + d2)};
    }

    public static int getAlignmentOfBlock(SceneText sceneText) {
        int iMax;
        int i;
        int i2;
        int i4;
        boolean[] zArrDetectOutliers = detectOutliers(sceneText);
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        int i5 = 1;
        for (int i6 = 1; i6 <= sceneText.getComponents().size(); i6++) {
            int i7 = i6 - 1;
            if (zArrDetectOutliers[i7]) {
                copyOnWriteArrayList.add(sceneText.getComponents().get(i7));
            }
        }
        LTTLogger.m5458d(TAG, "detectOutliers: Lines to consider - " + copyOnWriteArrayList.size() + " out of " + sceneText.getComponents().size());
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 1;
        while (i12 <= copyOnWriteArrayList.size()) {
            if (i12 == i5) {
                i = i8;
                i2 = i5;
                i4 = i12;
            } else {
                Point[] poly = ((SceneText) copyOnWriteArrayList.get(i12 - 2)).getPoly();
                int i13 = i12 - 1;
                Point[] poly2 = ((SceneText) copyOnWriteArrayList.get(i13)).getPoly();
                Point point = poly2[i8];
                double d = point.x;
                double d2 = point.y;
                Point point2 = poly2[3];
                i = i8;
                i2 = i5;
                i4 = i12;
                double[] dArrGenerateLineEquation = generateLineEquation(d, d2, point2.x, point2.y);
                Point point3 = poly2[i2];
                double d3 = point3.x;
                double d4 = point3.y;
                Point point4 = poly2[2];
                double[] dArrGenerateLineEquation2 = generateLineEquation(d3, d4, point4.x, point4.y);
                double d5 = dArrGenerateLineEquation[i];
                double d6 = dArrGenerateLineEquation[i2];
                double d7 = dArrGenerateLineEquation[2];
                Point point5 = poly[i];
                float perpendicularDistanceOfPointFromLine = (float) getPerpendicularDistanceOfPointFromLine(d5, d6, d7, point5.x, point5.y);
                double d8 = dArrGenerateLineEquation2[i];
                double d9 = dArrGenerateLineEquation2[i2];
                double d10 = dArrGenerateLineEquation2[2];
                Point point6 = poly[i2];
                float perpendicularDistanceOfPointFromLine2 = (float) getPerpendicularDistanceOfPointFromLine(d8, d9, d10, point6.x, point6.y);
                float fAbs = Math.abs(perpendicularDistanceOfPointFromLine - perpendicularDistanceOfPointFromLine2);
                int width = (int) (((double) sceneText.getWidth()) * 0.03d);
                String str = TAG;
                LTTLogger.m5460h(str, "MIN_VARIATION" + width);
                LTTLogger.m5460h(str, "Text : " + ((SceneText) copyOnWriteArrayList.get(i13)).getValue());
                LTTLogger.m5460h(str, "LeftVariation - " + perpendicularDistanceOfPointFromLine + " RightVariation - " + perpendicularDistanceOfPointFromLine2 + " CenterVariation - " + fAbs);
                float f = (float) width;
                if (perpendicularDistanceOfPointFromLine > f || perpendicularDistanceOfPointFromLine2 > f) {
                    if (perpendicularDistanceOfPointFromLine < perpendicularDistanceOfPointFromLine2 && perpendicularDistanceOfPointFromLine < fAbs) {
                        i9++;
                    } else if (perpendicularDistanceOfPointFromLine2 >= perpendicularDistanceOfPointFromLine || perpendicularDistanceOfPointFromLine2 >= fAbs) {
                        i11++;
                    } else {
                        i10++;
                    }
                }
            }
            i12 = i4 + 1;
            i8 = i;
            i5 = i2;
        }
        int i14 = i8;
        int i15 = i5;
        if (i9 + i10 + i11 < ((int) Math.ceil(((double) sceneText.getComponents().size()) * 0.3d)) || (iMax = Math.max(i9, Math.max(i10, i11))) == i9) {
            return i14;
        }
        if (iMax == i10) {
            return 2;
        }
        return i15;
    }

    public static double getPerpendicularDistanceOfPointFromLine(double d, double d2, double d3, double d4, double d5) {
        return Math.abs(AbstractC1974b.m1307D(d2, d5, d4 * d, d3)) / Math.sqrt((d2 * d2) + (d * d));
    }

    private static int[] getRotatedRectangleCenter(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8) {
        double d9 = (((d + d3) + d5) + d7) / 4.0d;
        double d10 = (((d2 + d4) + d6) + d8) / 4.0d;
        double dAtan2 = Math.atan2(d4 - d2, d3 - d);
        return new int[]{(int) ((Math.cos(dAtan2) * d9) - (Math.sin(dAtan2) * d10)), (int) AbstractC2821a.m2210a(dAtan2, d10, Math.sin(dAtan2) * d9)};
    }
}
