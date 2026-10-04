package com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.template.editor.image;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.samsung.android.support.senl.p145cm.base.common.util.BaseImageUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CTLogger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class InitialImageCreator {
    public static final String TAG = CTLogger.createTag("InitialImageCreator");
    private String mPath;

    public InitialImageCreator(String str) {
        this.mPath = str;
    }

    private static float getRatio(Bitmap bitmap, int i) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width <= i && height <= i) {
            return 1.0f;
        }
        float f = i;
        return Math.max(width / f, height / f);
    }

    private Bitmap getScaledBitmap(Bitmap bitmap) {
        float ratio = getRatio(bitmap, BaseImageUtils.getMaxTextureSize());
        return Bitmap.createScaledBitmap(bitmap, (int) (bitmap.getWidth() / ratio), (int) (bitmap.getHeight() / ratio), false);
    }

    public Bitmap create() {
        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(this.mPath);
        if (bitmapDecodeFile != null) {
            return getScaledBitmap(bitmapDecodeFile);
        }
        Logger.m11000e(TAG, "create(), Bitmap is corrupted.");
        return null;
    }
}
