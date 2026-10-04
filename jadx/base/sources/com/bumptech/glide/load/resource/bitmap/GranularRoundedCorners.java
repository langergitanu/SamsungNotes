package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Util;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class GranularRoundedCorners extends BitmapTransformation {

    /* JADX INFO: renamed from: ID */
    private static final String f1991ID = "com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners";
    private static final byte[] ID_BYTES = f1991ID.getBytes(Key.CHARSET);
    private final float bottomLeft;
    private final float bottomRight;
    private final float topLeft;
    private final float topRight;

    public GranularRoundedCorners(float f, float f4, float f5, float f6) {
        this.topLeft = f;
        this.topRight = f4;
        this.bottomRight = f5;
        this.bottomLeft = f6;
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (obj instanceof GranularRoundedCorners) {
            GranularRoundedCorners granularRoundedCorners = (GranularRoundedCorners) obj;
            if (this.topLeft == granularRoundedCorners.topLeft && this.topRight == granularRoundedCorners.topRight && this.bottomRight == granularRoundedCorners.bottomRight && this.bottomLeft == granularRoundedCorners.bottomLeft) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return Util.hashCode(this.bottomLeft, Util.hashCode(this.bottomRight, Util.hashCode(this.topRight, Util.hashCode(-2013597734, Util.hashCode(this.topLeft)))));
    }

    @Override // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    public Bitmap transform(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i, int i2) {
        return TransformationUtils.roundedCorners(bitmapPool, bitmap, this.topLeft, this.topRight, this.bottomRight, this.bottomLeft);
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update(ID_BYTES);
        messageDigest.update(ByteBuffer.allocate(16).putFloat(this.topLeft).putFloat(this.topRight).putFloat(this.bottomRight).putFloat(this.bottomLeft).array());
    }
}
