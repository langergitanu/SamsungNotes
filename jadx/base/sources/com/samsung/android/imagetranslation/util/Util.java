package com.samsung.android.imagetranslation.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import androidx.compose.runtime.AbstractC1974b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.google.gson.Gson;
import com.samsung.android.imagetranslation.common.LTTLogger;
import com.samsung.android.imagetranslation.data.LttOcrResult;
import com.samsung.android.imagetranslation.geometry.SmallestSurroundingRectangle;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.remotefunction.RemoteConstant;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class Util {
    private static final String TAG = "Util";
    private static final List<String> rtlLanguages;

    static {
        ArrayList arrayList = new ArrayList(1);
        Object obj = new Object[]{"ar"}[0];
        rtlLanguages = new ArrayList(AbstractC2322a.m1630t(obj, arrayList, obj, arrayList));
    }

    public static byte[] convertBitmapToNV21(Bitmap bitmap) {
        byte[] bArr;
        String str = TAG;
        LTTLogger.m5458d(str, "convertBitmapToNV21: E" + bitmap.getConfig());
        if (bitmap.isRecycled()) {
            bArr = null;
        } else {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            LTTLogger.m5458d(str, "[convertBitmapToNV21] size: " + width + " x " + height);
            int i = width * height;
            int[] iArr = new int[i];
            bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
            bArr = new byte[(i * 3) / 2];
            encodeYUV420SP(bArr, iArr, width, height);
        }
        LTTLogger.m5458d(str, "convertBitmapToNV21: X");
        return bArr;
    }

    public static String convertToJson(LttOcrResult lttOcrResult) {
        return new Gson().toJson(lttOcrResult);
    }

    private static void encodeYUV420SP(byte[] bArr, int[] iArr, int i, int i2) {
        int i4 = i * i2;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < i2; i7++) {
            int i8 = 0;
            while (i8 < i) {
                int i9 = iArr[i6];
                int i10 = (16711680 & i9) >> 16;
                int i11 = (65280 & i9) >> 8;
                int i12 = 255;
                int i13 = i9 & 255;
                int iM1310c = (AbstractC1974b.m1310c(i13, 25, (i11 * 129) + (i10 * 66), 128) >> 8) + 16;
                int iM1310c2 = (AbstractC1974b.m1310c(i13, 112, (i10 * (-38)) - (i11 * 74), 128) >> 8) + 128;
                int i14 = (((((i10 * 112) - (i11 * 94)) - (i13 * 18)) + 128) >> 8) + 128;
                int i15 = i5 + 1;
                if (iM1310c < 0) {
                    iM1310c = 0;
                } else if (iM1310c > 255) {
                    iM1310c = 255;
                }
                bArr[i5] = (byte) iM1310c;
                if (i7 % 2 == 0 && i6 % 2 == 0) {
                    int i16 = i4 + 1;
                    if (i14 < 0) {
                        i14 = 0;
                    } else if (i14 > 255) {
                        i14 = 255;
                    }
                    bArr[i4] = (byte) i14;
                    i4 += 2;
                    if (iM1310c2 < 0) {
                        i12 = 0;
                    } else if (iM1310c2 <= 255) {
                        i12 = iM1310c2;
                    }
                    bArr[i16] = (byte) i12;
                }
                i6++;
                i8++;
                i5 = i15;
            }
        }
    }

    public static int[] getDeviceResolution(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
        int[] iArr = {displayMetrics.widthPixels, displayMetrics.heightPixels};
        LTTLogger.m5458d(TAG, "Device Width - " + iArr[0] + " Height - " + iArr[1]);
        return iArr;
    }

    public static float getDpToPxFactor(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    public static Point[] getExtendedPolyValues(Point[] pointArr, int i, int i2, int i4, boolean z) {
        int i5 = i2;
        Point[] pointArr2 = new Point[4];
        if (z) {
            if (i5 == 0) {
                i5 = 2;
            } else if (i5 == 2) {
                i5 = 0;
            }
        }
        int i6 = -1;
        if (i5 == 0) {
            double dSqrt = Math.sqrt(Math.pow(pointArr[0].y - pointArr[1].y, 2.0d) + Math.pow(pointArr[0].x - pointArr[1].x, 2.0d));
            double dSqrt2 = Math.sqrt(Math.pow(pointArr[2].y - pointArr[3].y, 2.0d) + Math.pow(pointArr[2].x - pointArr[3].x, 2.0d));
            if (i4 == 0 || i4 == 90) {
                i6 = 1;
            } else if (i4 != 180 && i4 != 270) {
                i6 = 0;
            }
            Point point = pointArr[0];
            pointArr2[0] = new Point(point.x, point.y);
            Point point2 = new Point();
            pointArr2[1] = point2;
            Point point3 = pointArr[1];
            int i7 = point3.x;
            Point point4 = pointArr[0];
            double d = i;
            point2.x = (int) (((((double) ((i7 - point4.x) * i6)) / dSqrt) * d) + ((double) i7));
            int i8 = point3.y;
            point2.y = (int) (((((double) ((i8 - point4.y) * i6)) / dSqrt) * d) + ((double) i8));
            Point point5 = new Point();
            pointArr2[2] = point5;
            Point point6 = pointArr[2];
            int i9 = point6.x;
            Point point7 = pointArr[3];
            point5.x = (int) (((((double) ((i9 - point7.x) * i6)) / dSqrt2) * d) + ((double) i9));
            int i10 = point6.y;
            point5.y = (int) (((((double) ((i10 - point7.y) * i6)) / dSqrt2) * d) + ((double) i10));
            Point point8 = pointArr[3];
            pointArr2[3] = new Point(point8.x, point8.y);
            return pointArr2;
        }
        if (i5 == 2) {
            double dSqrt3 = Math.sqrt(Math.pow(pointArr[0].y - pointArr[1].y, 2.0d) + Math.pow(pointArr[0].x - pointArr[1].x, 2.0d));
            double dSqrt4 = Math.sqrt(Math.pow(pointArr[2].y - pointArr[3].y, 2.0d) + Math.pow(pointArr[2].x - pointArr[3].x, 2.0d));
            if (i4 != 0 && i4 != 90) {
                i6 = (i4 == 180 || i4 == 270) ? 1 : 0;
            }
            Point point9 = pointArr[1];
            pointArr2[1] = new Point(point9.x, point9.y);
            Point point10 = pointArr[2];
            pointArr2[2] = new Point(point10.x, point10.y);
            Point point11 = new Point();
            pointArr2[0] = point11;
            Point point12 = pointArr[0];
            int i11 = point12.x;
            Point point13 = pointArr[1];
            double d2 = i;
            point11.x = (int) (((((double) ((point13.x - i11) * i6)) / dSqrt3) * d2) + ((double) i11));
            int i12 = point12.y;
            point11.y = (int) (((((double) ((point13.y - i12) * i6)) / dSqrt3) * d2) + ((double) i12));
            Point point14 = new Point();
            pointArr2[3] = point14;
            Point point15 = pointArr[3];
            int i13 = point15.x;
            Point point16 = pointArr[2];
            point14.x = (int) (((((double) ((point16.x - i13) * i6)) / dSqrt4) * d2) + ((double) i13));
            int i14 = point15.y;
            point14.y = (int) (((((double) ((point16.y - i14) * i6)) / dSqrt4) * d2) + ((double) i14));
            return pointArr2;
        }
        int i15 = i / 2;
        double dSqrt5 = Math.sqrt(Math.pow(pointArr[0].y - pointArr[1].y, 2.0d) + Math.pow(pointArr[0].x - pointArr[1].x, 2.0d));
        double dSqrt6 = Math.sqrt(Math.pow(pointArr[2].y - pointArr[3].y, 2.0d) + Math.pow(pointArr[2].x - pointArr[3].x, 2.0d));
        int i16 = (i4 == 0 || i4 == 90) ? 1 : (i4 == 180 || i4 == 270) ? -1 : 0;
        if (i4 != 0 && i4 != 90) {
            i6 = (i4 == 180 || i4 == 270) ? 1 : 0;
        }
        Point point17 = new Point();
        pointArr2[0] = point17;
        Point point18 = pointArr[0];
        int i17 = point18.x;
        Point point19 = pointArr[1];
        int i18 = i16;
        double d3 = i15;
        point17.x = (int) (((((double) ((point19.x - i17) * i6)) / dSqrt5) * d3) + ((double) i17));
        int i19 = point18.y;
        point17.y = (int) (((((double) ((point19.y - i19) * i6)) / dSqrt5) * d3) + ((double) i19));
        Point point20 = new Point();
        pointArr2[1] = point20;
        Point point21 = pointArr[1];
        int i20 = point21.x;
        Point point22 = pointArr[0];
        point20.x = (int) (((((double) ((i20 - point22.x) * i18)) / dSqrt5) * d3) + ((double) i20));
        int i21 = point21.y;
        point20.y = (int) (((((double) ((i21 - point22.y) * i18)) / dSqrt5) * d3) + ((double) i21));
        Point point23 = new Point();
        pointArr2[2] = point23;
        Point point24 = pointArr[2];
        int i22 = point24.x;
        Point point25 = pointArr[3];
        point23.x = (int) (((((double) ((i22 - point25.x) * i18)) / dSqrt6) * d3) + ((double) i22));
        int i23 = point24.y;
        point23.y = (int) (((((double) ((i23 - point25.y) * i18)) / dSqrt6) * d3) + ((double) i23));
        Point point26 = new Point();
        pointArr2[3] = point26;
        Point point27 = pointArr[3];
        int i24 = point27.x;
        Point point28 = pointArr[2];
        point26.x = (int) (((((double) ((point28.x - i24) * i6)) / dSqrt6) * d3) + ((double) i24));
        int i25 = point27.y;
        point26.y = (int) (((((double) ((point28.y - i25) * i6)) / dSqrt6) * d3) + ((double) i25));
        return pointArr2;
    }

    public static int getOrientation(Point[] pointArr) {
        ArrayList arrayList = new ArrayList();
        for (Point point : pointArr) {
            arrayList.add(new PointF(point.x, point.y));
        }
        Point[] pointArrSortPoint = SmallestSurroundingRectangle.sortPoint(arrayList);
        int i = 0;
        while (true) {
            if (i >= 4) {
                i = 0;
                break;
            }
            Point point2 = pointArrSortPoint[0];
            int i2 = point2.x;
            Point point3 = pointArr[i];
            if (i2 == point3.x && point2.y == point3.y) {
                break;
            }
            i++;
        }
        if (i == 0) {
            return 0;
        }
        if (i != 1) {
            return i != 2 ? 90 : 180;
        }
        return 270;
    }

    public static boolean isJarAndNativeVersionCompatible(String str, String str2) {
        if (str == null || str.isEmpty() || str2 == null) {
            return false;
        }
        return str.split(RemoteConstant.VERSION_DIVIDE)[0].equals(str2.split(RemoteConstant.VERSION_DIVIDE)[0]);
    }

    public static boolean isLineOnTopOrBottom(Point[] pointArr, Point[] pointArr2, Point[] pointArr3, Point[] pointArr4) {
        for (int i = 0; i < 4; i++) {
            Point point = pointArr3[i];
            int i2 = point.x;
            Point point2 = pointArr4[i];
            if (i2 != point2.x || point.y != point2.y) {
                return false;
            }
        }
        return isPolyValueIntersecting(pointArr, pointArr2);
    }

    public static boolean isPointInsidePolygon(Point point, Point[] pointArr) {
        int length = pointArr.length;
        double d = point.x;
        double d2 = point.y;
        boolean z = false;
        Point point2 = pointArr[0];
        int i = 1;
        while (i <= length) {
            Point point3 = pointArr[i % length];
            if (d2 > Math.min(point2.y, point3.y) && d2 <= Math.max(point2.y, point3.y) && d <= Math.max(point2.x, point3.x)) {
                int i2 = point2.y;
                int i4 = point3.x;
                int i5 = point2.x;
                double d3 = (((d2 - ((double) i2)) * ((double) (i4 - i5))) / ((double) (point3.y - i2))) + ((double) i5);
                if (i5 == i4 || d <= d3) {
                    z = !z;
                }
            }
            i++;
            point2 = point3;
        }
        return z;
    }

    private static boolean isPolyAntiClockwise(Point[] pointArr) {
        int length = pointArr.length;
        long j = 0;
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            Point point = pointArr[i2 % length];
            int i4 = point.x;
            Point point2 = pointArr[i];
            j += ((long) (i4 - point2.x)) * ((long) (point.y + point2.y));
            i = i2;
        }
        return j > 0;
    }

    public static boolean isPolyOutOfImageBound(Point[] pointArr, Point[] pointArr2, int i, int i2, int i4) {
        int i5 = (i2 * i4) / 100;
        int i6 = 100 - i4;
        int i7 = (i2 * i6) / 100;
        int i8 = (i4 * i) / 100;
        int i9 = (i * i6) / 100;
        for (int i10 = 0; i10 < 4; i10++) {
            Point point = pointArr[i10];
            Point point2 = pointArr2[i10];
            int i11 = point.x;
            int i12 = point2.x;
            if (i11 != i12 && (i12 < i8 || i12 > i9)) {
                return true;
            }
            int i13 = point.y;
            int i14 = point2.y;
            if (i13 != i14 && (i14 < i5 || i14 > i7)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isPolyValueIntersecting(Point[] pointArr, Point[] pointArr2) {
        for (Point point : pointArr) {
            if (isPointInsidePolygon(point, pointArr2)) {
                return true;
            }
        }
        for (Point point2 : pointArr2) {
            if (isPointInsidePolygon(point2, pointArr)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isRTLLanguage(Point[] pointArr) {
        return isPolyAntiClockwise(pointArr);
    }

    public static String removeMoreThanOneSpaceBetweenWords(String str) {
        return Pattern.compile("\\s+").matcher(str).replaceAll(" ");
    }

    public static boolean isRTLLanguage(String str) {
        return rtlLanguages.contains(str);
    }
}
