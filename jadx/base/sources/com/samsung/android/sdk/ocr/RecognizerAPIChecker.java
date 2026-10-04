package com.samsung.android.sdk.ocr;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class RecognizerAPIChecker {
    private static final String TAG = "RecognizerAPIChecker";

    private static boolean isInputBitmapNull(Bitmap bitmap) {
        if (bitmap != null) {
            return false;
        }
        Log.e(TAG, "Input bitmap is null");
        return true;
    }

    private static boolean isPointContainerNull(Point[] pointArr) {
        if (pointArr == null) {
            Log.e(TAG, "Result space for 4 corner points is null");
            return true;
        }
        if (pointArr.length == 4) {
            return false;
        }
        Log.e(TAG, "Result space for 4 corner points has not been prepared");
        return true;
    }

    private static boolean isResultContainerNull(OCRResult oCRResult) {
        if (oCRResult != null) {
            return false;
        }
        Log.e(TAG, "Input parameter for result container is null");
        return true;
    }

    public static boolean isValidParameter(Bitmap bitmap) {
        return !isInputBitmapNull(bitmap);
    }

    private static void preparePointContainer(Point[] pointArr) {
        for (int i = 0; i < pointArr.length; i++) {
            if (pointArr[i] == null) {
                pointArr[i] = new Point();
            }
        }
    }

    public static boolean isValidParameter(Bitmap bitmap, OCRResult oCRResult) {
        return (isInputBitmapNull(bitmap) || isResultContainerNull(oCRResult)) ? false : true;
    }

    public static boolean isValidParameter(Bitmap bitmap, Point[] pointArr) {
        if (isInputBitmapNull(bitmap) || isPointContainerNull(pointArr)) {
            return false;
        }
        preparePointContainer(pointArr);
        return true;
    }
}
