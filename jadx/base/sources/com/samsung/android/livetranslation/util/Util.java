package com.samsung.android.livetranslation.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import androidx.compose.runtime.AbstractC1974b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.google.gson.Gson;
import com.samsung.android.imagetranslation.data.LttOcrResult;
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
        LTTLogger.m5581d(str, "convertBitmapToNV21: E" + bitmap.getConfig());
        if (bitmap.isRecycled()) {
            bArr = null;
        } else {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            LTTLogger.m5581d(str, "[convertBitmapToNV21] size: " + width + " x " + height);
            int i = width * height;
            int[] iArr = new int[i];
            bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
            bArr = new byte[(i * 3) / 2];
            encodeYUV420SP(bArr, iArr, width, height);
        }
        LTTLogger.m5583i(str, "convertBitmapToNV21: X");
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
        LTTLogger.m5581d(TAG, "Device Width - " + iArr[0] + " Height - " + iArr[1]);
        return iArr;
    }

    public static float getDpToPxFactor(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    public static long getTimeInMilliSecond() {
        return System.currentTimeMillis();
    }

    public static boolean isJarAndNativeVersionCompatible(String str, String str2) {
        if (str == null || str.isEmpty() || str2 == null) {
            return false;
        }
        return str.split(RemoteConstant.VERSION_DIVIDE)[0].equals(str2.split(RemoteConstant.VERSION_DIVIDE)[0]);
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

    public static boolean isRTLLanguage(String str) {
        return rtlLanguages.contains(str);
    }

    public static String removeMoreThanOneSpaceBetweenWords(String str) {
        return Pattern.compile("\\s+").matcher(str).replaceAll(" ");
    }
}
