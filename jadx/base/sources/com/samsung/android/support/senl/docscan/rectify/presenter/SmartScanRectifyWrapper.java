package com.samsung.android.support.senl.docscan.rectify.presenter;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PointF;
import android.os.Build;
import androidx.annotation.NonNull;
import camera.samsung.smartscan.SmartScanRectify;
import com.samsung.android.smartscan.SmartScanRectify;
import com.samsung.android.support.senl.docscan.common.Logger;
import com.samsung.android.support.senl.docscan.model.DocScanData;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\tJ\u0018\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\fJ'\u0010\u0010\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\f2\u000e\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012H\u0002¢\u0006\u0002\u0010\u0014J'\u0010\u0015\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\f2\u000e\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012H\u0002¢\u0006\u0002\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\fH\u0003J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0017H\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, m13886d2 = {"Lcom/samsung/android/support/senl/docscan/rectify/presenter/SmartScanRectifyWrapper;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "mIsInitialized", "", "initialize", "", "deInitialize", "execute", "Landroid/graphics/Bitmap;", "docScanData", "Lcom/samsung/android/support/senl/docscan/model/DocScanData;", "imageBitmap", "executeROSLess", "handledVertexes", "", "Landroid/graphics/PointF;", "(Landroid/graphics/Bitmap;[Landroid/graphics/PointF;)Landroid/graphics/Bitmap;", "executeSOSHigher", "convertBitmapToRgb", "", "bitmap", "convertRgbToPixel", "", "rgbData", "docscan_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SmartScanRectifyWrapper {

    @NotNull
    public static final SmartScanRectifyWrapper INSTANCE = new SmartScanRectifyWrapper();

    @NotNull
    private static final String TAG = "SmartScanRectifyWrapper";
    private static boolean mIsInitialized;

    private SmartScanRectifyWrapper() {
    }

    @NonNull
    private final byte[] convertBitmapToRgb(Bitmap bitmap) {
        Logger.m7148i(TAG, "convertBitmapToRgb# ");
        int height = bitmap.getHeight() * bitmap.getWidth();
        int[] iArr = new int[height];
        bitmap.getPixels(iArr, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
        byte[] bArr = new byte[height * 3];
        for (int i = 0; i < height; i++) {
            int i2 = i * 3;
            int i4 = iArr[i];
            bArr[i2] = (byte) ((16711680 & i4) >> 16);
            bArr[i2 + 1] = (byte) ((65280 & i4) >> 8);
            bArr[i2 + 2] = (byte) (i4 & 255);
        }
        return bArr;
    }

    @NonNull
    private final int[] convertRgbToPixel(byte[] rgbData) {
        int length = rgbData.length / 3;
        Logger.m7148i(TAG, "convertRgbToPixel# pixelCnt : " + length);
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 3;
            iArr[i] = Color.rgb(rgbData[i2] & 255, rgbData[i2 + 1] & 255, rgbData[i2 + 2] & 255);
        }
        return iArr;
    }

    private final Bitmap executeROSLess(Bitmap imageBitmap, PointF[] handledVertexes) {
        int iRectify;
        SmartScanRectify.SSImage sSImage = new SmartScanRectify.SSImage();
        SmartScanRectify.DetectResult detectResult = new SmartScanRectify.DetectResult();
        detectResult.coord = new float[handledVertexes.length * 2];
        int width = imageBitmap.getWidth();
        int height = imageBitmap.getHeight();
        Logger.m7148i(TAG, "executeROSLess# imageWidth: " + width + " imageHeight: " + height);
        if (width <= 0 || height <= 0) {
            Logger.m7150w(TAG, "executeROSLess# invalid width and height for rectify, return.");
            deInitialize();
            return null;
        }
        int i = 0;
        for (PointF pointF : handledVertexes) {
            if (pointF != null) {
                int i2 = i + 1;
                detectResult.coord[i] = Math.min((width - 1) / width, Math.max(0.0f, pointF.x));
                i += 2;
                detectResult.coord[i2] = Math.min((height - 1) / height, Math.max(0.0f, pointF.y));
            }
        }
        byte[] bArrConvertBitmapToRgb = convertBitmapToRgb(imageBitmap);
        try {
            float[] fArr = detectResult.coord;
            iRectify = SmartScanRectify.rectify(bArrConvertBitmapToRgb, width, height, 0, fArr, sSImage, fArr.length);
        } catch (Exception e) {
            Logger.m7146e(TAG, "executeROSLess# " + e.getMessage());
            iRectify = -1;
        }
        if (iRectify == 0) {
            deInitialize();
            byte[] ImageData = sSImage.ImageData;
            Intrinsics.checkNotNullExpressionValue(ImageData, "ImageData");
            return Bitmap.createBitmap(convertRgbToPixel(ImageData), sSImage.width, sSImage.height, Bitmap.Config.ARGB_8888);
        }
        Logger.m7150w(TAG, "executeROSLess# error occurred during rectify, return. result : " + iRectify);
        deInitialize();
        return null;
    }

    private final Bitmap executeSOSHigher(Bitmap imageBitmap, PointF[] handledVertexes) {
        int iExecute;
        SmartScanRectify.SSImage sSImage = new SmartScanRectify.SSImage();
        SmartScanRectify.DetectResult detectResult = new SmartScanRectify.DetectResult();
        detectResult.coord = new float[handledVertexes.length * 2];
        int width = imageBitmap.getWidth();
        int height = imageBitmap.getHeight();
        Logger.m7148i(TAG, "executeSOSHigher# imageWidth: " + width + " imageHeight: " + height);
        if (width <= 0 || height <= 0) {
            Logger.m7150w(TAG, "executeSOSHigher# invalid width and height for rectify, return.");
            deInitialize();
            return null;
        }
        int i = 0;
        for (PointF pointF : handledVertexes) {
            if (pointF != null) {
                int i2 = i + 1;
                detectResult.coord[i] = Math.min((width - 1) / width, Math.max(0.0f, pointF.x));
                i += 2;
                detectResult.coord[i2] = Math.min((height - 1) / height, Math.max(0.0f, pointF.y));
            }
        }
        byte[] bArrConvertBitmapToRgb = convertBitmapToRgb(imageBitmap);
        try {
            float[] fArr = detectResult.coord;
            iExecute = com.samsung.android.smartscan.SmartScanRectify.execute(bArrConvertBitmapToRgb, width, height, 0, fArr, sSImage, fArr.length);
        } catch (Exception e) {
            Logger.m7146e(TAG, "executeSOSHigher# " + e.getMessage());
            iExecute = -1;
        }
        if (iExecute == 0) {
            deInitialize();
            byte[] ImageData = sSImage.ImageData;
            Intrinsics.checkNotNullExpressionValue(ImageData, "ImageData");
            return Bitmap.createBitmap(convertRgbToPixel(ImageData), sSImage.width, sSImage.height, Bitmap.Config.ARGB_8888);
        }
        Logger.m7150w(TAG, "executeSOSHigher# error occurred during rectify, return. result : " + iExecute);
        deInitialize();
        return null;
    }

    public final void deInitialize() {
        if (mIsInitialized) {
            mIsInitialized = false;
            com.samsung.android.smartscan.SmartScanRectify.deinitialize();
        }
    }

    @Nullable
    public final Bitmap execute(@NotNull DocScanData docScanData, @NotNull Bitmap imageBitmap) {
        Intrinsics.checkNotNullParameter(docScanData, "docScanData");
        Intrinsics.checkNotNullParameter(imageBitmap, "imageBitmap");
        Logger.m7145d(TAG, "execute# ");
        PointF[] vertexList = docScanData.getVertexList();
        int length = vertexList.length;
        int i = length - 1;
        boolean z = true;
        int i2 = 0;
        while (i2 < i) {
            int i4 = i2 + 1;
            int i5 = i4;
            while (true) {
                if (i5 >= length) {
                    break;
                }
                if (Intrinsics.areEqual(vertexList[i2], vertexList[i5])) {
                    z = false;
                    break;
                }
                i5++;
            }
            if (!z) {
                Logger.m7146e(TAG, "execute# handledVertexes have at least a same point");
                deInitialize();
                return null;
            }
            i2 = i4;
        }
        return Build.VERSION.SDK_INT < 31 ? executeROSLess(imageBitmap, vertexList) : executeSOSHigher(imageBitmap, vertexList);
    }

    public final void initialize() {
        if (mIsInitialized) {
            return;
        }
        mIsInitialized = true;
        com.samsung.android.smartscan.SmartScanRectify.initialize();
    }
}
