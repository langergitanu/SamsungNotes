package com.samsung.android.sdk.ocr;

import android.graphics.Bitmap;
import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class DataConverter {
    private static final String TAG = "DataConverter";
    private final int mMaxImageWidthOrHeight;
    private float mScale = 1.0f;

    public DataConverter(int i) {
        this.mMaxImageWidthOrHeight = i;
    }

    public boolean convertResultScale(OCRResult oCRResult) {
        float f = this.mScale;
        if (f != 1.0f) {
            return oCRResult.scale(1.0f / f);
        }
        return true;
    }

    public Bitmap resizeBitmap(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int iMax = Math.max(width, height);
        int i = this.mMaxImageWidthOrHeight;
        if (iMax <= i) {
            this.mScale = 1.0f;
            Log.i("DataConverter", String.format("Resizing: (%d, %d) => No need to resize", Integer.valueOf(width), Integer.valueOf(height)));
            return bitmap;
        }
        float f = i / iMax;
        this.mScale = f;
        int i2 = (int) (width * f);
        int i4 = (int) (height * f);
        Log.i("DataConverter", String.format("Resizing: (%d, %d) => (%d, %d) (scale=%.1f)", Integer.valueOf(width), Integer.valueOf(height), Integer.valueOf(i2), Integer.valueOf(i4), Float.valueOf(this.mScale)));
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, i2, i4, true);
        bitmap.recycle();
        return bitmapCreateScaledBitmap;
    }
}
