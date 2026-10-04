package com.samsung.android.sdk.pen.graphics;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0003J \u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\nH\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/graphics/SpenBitmapFactory;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "decodeFile", "Landroid/graphics/Bitmap;", "filepath", "requestWidth", "", "requestHeight", "calculateInSampleSize", "options", "Landroid/graphics/BitmapFactory$Options;", "reqWidth", "reqHeight", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenBitmapFactory {

    @NotNull
    public static final SpenBitmapFactory INSTANCE = new SpenBitmapFactory();

    @NotNull
    private static final String TAG = "SpenBitmapFactory";

    private SpenBitmapFactory() {
    }

    @JvmStatic
    private static final int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        int i = options.outHeight;
        int i2 = options.outWidth;
        int i4 = 1;
        if (i <= reqHeight && i2 <= reqWidth) {
            return 1;
        }
        int i5 = i / 2;
        int i6 = i2 / 2;
        while (i5 / i4 >= reqHeight && i6 / i4 >= reqWidth) {
            i4 *= 2;
        }
        return i4;
    }

    @JvmStatic
    private static final Bitmap decodeFile(String filepath, int requestWidth, int requestHeight) {
        StringBuilder sbM1173s = AbstractC0622a.m1173s(requestWidth, requestHeight, "decodeFile width = ", ", height = ", ", path = ");
        sbM1173s.append(filepath);
        Log.d(TAG, sbM1173s.toString());
        try {
            File file = new File(filepath);
            Log.d(TAG, "decodeFile isFile: " + file.isFile() + ", exist: " + file.exists());
        } catch (Exception e) {
            Log.e(TAG, "decodeFile exp: " + e);
            e.printStackTrace();
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        boolean z = (requestWidth == 0 || requestHeight == 0) ? false : true;
        if (z) {
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(filepath, options);
            options.inSampleSize = calculateInSampleSize(options, requestWidth, requestHeight);
        }
        Bitmap.Config config = Bitmap.Config.ARGB_8888;
        options.inPreferredConfig = config;
        options.inJustDecodeBounds = false;
        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(filepath, options);
        if (bitmapDecodeFile == null) {
            AbstractC2322a.m1609C("bitmap is null. path:", filepath, TAG);
            return null;
        }
        if (bitmapDecodeFile.getConfig() != config) {
            Bitmap bitmapCopy = bitmapDecodeFile.copy(config, false);
            bitmapDecodeFile.recycle();
            bitmapDecodeFile = bitmapCopy;
        }
        if (!z || (bitmapDecodeFile.getWidth() == requestWidth && bitmapDecodeFile.getHeight() == requestHeight)) {
            return bitmapDecodeFile;
        }
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapDecodeFile, requestWidth, requestHeight, true);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateScaledBitmap, "createScaledBitmap(...)");
        bitmapDecodeFile.recycle();
        return bitmapCreateScaledBitmap;
    }
}
