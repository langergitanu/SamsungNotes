package com.airbnb.lottie;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class LottieImageAsset {

    @Nullable
    private Bitmap bitmap;
    private final String dirName;
    private final String fileName;
    private final int height;

    /* JADX INFO: renamed from: id */
    private final String f1905id;
    private final int width;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public LottieImageAsset(int i, int i2, String str, String str2, String str3) {
        this.width = i;
        this.height = i2;
        this.f1905id = str;
        this.fileName = str2;
        this.dirName = str3;
    }

    public LottieImageAsset copyWithScale(float f) {
        LottieImageAsset lottieImageAsset = new LottieImageAsset((int) (this.width * f), (int) (this.height * f), this.f1905id, this.fileName, this.dirName);
        Bitmap bitmap = this.bitmap;
        if (bitmap != null) {
            lottieImageAsset.setBitmap(Bitmap.createScaledBitmap(bitmap, lottieImageAsset.width, lottieImageAsset.height, true));
        }
        return lottieImageAsset;
    }

    @Nullable
    public Bitmap getBitmap() {
        return this.bitmap;
    }

    public String getDirName() {
        return this.dirName;
    }

    public String getFileName() {
        return this.fileName;
    }

    public int getHeight() {
        return this.height;
    }

    public String getId() {
        return this.f1905id;
    }

    public int getWidth() {
        return this.width;
    }

    public boolean hasBitmap() {
        if (this.bitmap == null) {
            return this.fileName.startsWith("data:") && this.fileName.indexOf("base64,") > 0;
        }
        return true;
    }

    public void setBitmap(@Nullable Bitmap bitmap) {
        this.bitmap = bitmap;
    }
}
