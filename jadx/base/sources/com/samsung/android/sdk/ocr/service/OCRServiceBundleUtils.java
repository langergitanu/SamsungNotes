package com.samsung.android.sdk.ocr.service;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import com.samsung.android.sdk.ocr.DataConverter;
import com.samsung.android.sdk.ocr.OCRResult;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class OCRServiceBundleUtils {
    public static Bundle getBitmapBundle(int i, String str, String str2, Bitmap bitmap) {
        Bundle defaultBundle = getDefaultBundle(i, str, str2);
        defaultBundle.putParcelable("bmp", bitmap);
        return defaultBundle;
    }

    public static Bundle getBundleForHasTextSpecialCase(int i, String str, String str2, Bitmap bitmap, boolean z) {
        Bundle defaultBundle = getDefaultBundle(i, str, str2);
        defaultBundle.putParcelable("bmp", bitmap);
        defaultBundle.putBoolean(OCRServiceConstant.KEY_PARAM_CHECK_PRINTED_FIRST, z);
        return defaultBundle;
    }

    public static Bundle getDefaultBundle(int i, String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putInt("type", i);
        bundle.putString("language", str);
        bundle.putString("uuid", str2);
        return bundle;
    }

    public static Bundle getResizedBitmapBundle(int i, String str, String str2, Bitmap bitmap, int i2) {
        return getBitmapBundle(i, str, str2, new DataConverter(i2).resizeBitmap(bitmap));
    }

    public static boolean getResultFromBundle(Bundle bundle, OCRResult oCRResult) {
        bundle.setClassLoader(OCRResult.class.getClassLoader());
        if (bundle.getInt("resultCode") != 1) {
            return false;
        }
        OCRResult oCRResult2 = (OCRResult) bundle.getParcelable(OCRServiceConstant.KEY_RESULT_OCRRESULT);
        if (oCRResult2 != null) {
            oCRResult.clear();
            oCRResult.getProcessInfo().setHasText(oCRResult2.getProcessInfo().hasText());
            oCRResult.getProcessInfo().setEngineVersion(oCRResult2.getProcessInfo().getEngineVersion(true), true);
            oCRResult.getProcessInfo().setEngineVersion(oCRResult2.getProcessInfo().getEngineVersion(false), false);
            Iterator<OCRResult.BlockData> it = oCRResult2.getBlockDataList().iterator();
            while (it.hasNext()) {
                oCRResult.add(it.next());
            }
        }
        return true;
    }

    public static void putForceToSelectBundle(Bundle bundle, boolean z) {
        bundle.putBoolean(OCRServiceConstant.KEY_PARAM_FORCE_TO_SELECT, z);
    }

    public static void putInputPointInBundle(Bundle bundle, Point point) {
        bundle.putParcelable(OCRServiceConstant.KEY_PARAM_INPUT_POINT, point);
    }

    public static boolean getResultFromBundle(Bundle bundle, Point[] pointArr) {
        bundle.setClassLoader(OCRResult.class.getClassLoader());
        if (bundle.getInt("resultCode") != 1) {
            return false;
        }
        int[] intArray = bundle.getIntArray(OCRServiceConstant.KEY_RESULT_CORNERPOINT);
        Point point = pointArr[0];
        point.x = intArray[0];
        point.y = intArray[1];
        Point point2 = pointArr[1];
        point2.x = intArray[2];
        point2.y = intArray[3];
        Point point3 = pointArr[2];
        point3.x = intArray[4];
        point3.y = intArray[5];
        Point point4 = pointArr[3];
        point4.x = intArray[6];
        point4.y = intArray[7];
        return true;
    }
}
