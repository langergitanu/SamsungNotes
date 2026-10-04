package com.samsung.android.support.senl.p148nt.composer.main.base.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class BitmapUtil {
    public static Bitmap createPaddedBitmap(Bitmap bitmap, int i, int i2, int i4) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth() + i2, bitmap.getHeight() + i4, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.drawColor(i);
        canvas.drawBitmap(bitmap, i2 / 2.0f, i4 / 2.0f, new Paint(2));
        return bitmapCreateBitmap;
    }
}
