package com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.PictureDrawable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class VUtilBitmap {
    public static Bitmap cropCenterBitmap(Bitmap bitmap, int i, int i2) {
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width < i && height < i2) {
            return bitmap;
        }
        int i4 = width > i ? (width - i) / 2 : 0;
        int i5 = height > i2 ? (height - i2) / 2 : 0;
        if (i > width) {
            i = width;
        }
        if (i2 > height) {
            i2 = height;
        }
        return Bitmap.createBitmap(bitmap, i4, i5, i, i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bitmap resize(Bitmap bitmap, int i, boolean z) {
        int i2;
        if (!z) {
            return resizeBitmap(bitmap, i);
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width > height) {
            if (i > width) {
                i2 = (int) (height * (i / width));
            } else {
                i = width;
                i2 = height;
            }
        } else if (i > height) {
            int i4 = (int) (width * (i / height));
            i2 = i;
            i = i4;
        }
        return Bitmap.createScaledBitmap(bitmap, i, i2, true);
    }

    public static Bitmap resizeBitmap(Bitmap bitmap, int i) {
        int i2;
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width > height) {
            i2 = (int) (height * (i / width));
        } else {
            int i4 = (int) (width * (i / height));
            i2 = i;
            i = i4;
        }
        return Bitmap.createScaledBitmap(bitmap, i, i2, true);
    }

    public static Bitmap resizeSquare(Bitmap bitmap, int i) {
        if (bitmap == null) {
            return null;
        }
        return Bitmap.createScaledBitmap(bitmap, i, i, true);
    }

    public static Bitmap toBitmap(PictureDrawable pictureDrawable) {
        if (pictureDrawable.getIntrinsicWidth() <= 0 || pictureDrawable.getIntrinsicHeight() <= 0) {
            return null;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(pictureDrawable.getIntrinsicWidth(), pictureDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        new Canvas(bitmapCreateBitmap).drawPicture(pictureDrawable.getPicture());
        return bitmapCreateBitmap;
    }
}
