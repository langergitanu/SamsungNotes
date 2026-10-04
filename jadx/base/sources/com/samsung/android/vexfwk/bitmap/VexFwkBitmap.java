package com.samsung.android.vexfwk.bitmap;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.hardware.HardwareBuffer;
import android.util.Size;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.microsoft.identity.common.java.WarningType;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.vexfwk.VexFwkJniLoader;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/vexfwk/bitmap/VexFwkBitmap;", "", "()V", "Companion", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class VexFwkBitmap {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final boolean m_jniLoaded = VexFwkJniLoader.loadLibrary("common-jni.vexfwk.samsung");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u000f\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J0\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0006H\u0007J \u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J8\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\fH\u0007J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u001bH\u0007J \u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J8\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\fH\u0007J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u001b2\u0006\u0010\u0013\u001a\u00020\u0006H\u0007J(\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u001b2\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\fH\u0007J@\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u001b2\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\fH\u0007J9\u0010!\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020\fH\u0083 J9\u0010#\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020\fH\u0083 JI\u0010$\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0083 JA\u0010%\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u001b2\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\fH\u0083 J \u0010&\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\f2\u0006\u0010)\u001a\u00020\fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, m13886d2 = {"Lcom/samsung/android/vexfwk/bitmap/VexFwkBitmap$Companion;", "", "()V", "m_jniLoaded", "", "convertToBitmap", "Landroid/graphics/Bitmap;", "srcArray", "", "size", "Landroid/util/Size;", "srcStride", "", "srcBytePerPixel", "format", "Landroid/graphics/Bitmap$Config;", "copyBitmap", "", "srcBitmap", "dstBitmap", "roi", "Landroid/graphics/Rect;", "left", "top", "right", "bottom", "dstArray", "", "srcRoi", "srcRoiLeft", "srcRoiTop", "srcRoiRight", "srcRoiBottom", "copyBitmapToBitmapNative", "srcRopTop", "copyBitmapToIntArrayNative", "copyByteArrayToBitmapNative", "copyIntArrayToBitmapNative2", "resizeBitmap", "bitmap", "maxWidth", "maxHeight", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nVexFwkBitmap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VexFwkBitmap.kt\ncom/samsung/android/vexfwk/bitmap/VexFwkBitmap$Companion\n+ 2 Bitmap.kt\nandroidx/core/graphics/BitmapKt\n*L\n1#1,229:1\n77#2:230\n*S KotlinDebug\n*F\n+ 1 VexFwkBitmap.kt\ncom/samsung/android/vexfwk/bitmap/VexFwkBitmap$Companion\n*L\n182#1:230\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        private final void copyBitmapToBitmapNative(Bitmap srcBitmap, Bitmap dstBitmap, int srcRoiLeft, int srcRopTop, int srcRoiRight, int srcRoiBottom) {
            VexFwkBitmap.copyBitmapToBitmapNative(srcBitmap, dstBitmap, srcRoiLeft, srcRopTop, srcRoiRight, srcRoiBottom);
        }

        @JvmStatic
        private final void copyBitmapToIntArrayNative(Bitmap srcBitmap, int[] dstArray, int srcRoiLeft, int srcRopTop, int srcRoiRight, int srcRoiBottom) {
            VexFwkBitmap.copyBitmapToIntArrayNative(srcBitmap, dstArray, srcRoiLeft, srcRopTop, srcRoiRight, srcRoiBottom);
        }

        @JvmStatic
        private final void copyByteArrayToBitmapNative(byte[] srcArray, Bitmap dstBitmap, int srcRoiLeft, int srcRopTop, int srcRoiRight, int srcRoiBottom, int srcStride, int srcBytePerPixel) {
            VexFwkBitmap.copyByteArrayToBitmapNative(srcArray, dstBitmap, srcRoiLeft, srcRopTop, srcRoiRight, srcRoiBottom, srcStride, srcBytePerPixel);
        }

        @JvmStatic
        private final void copyIntArrayToBitmapNative2(int[] srcArray, Bitmap dstBitmap, int srcRoiLeft, int srcRopTop, int srcRoiRight, int srcRoiBottom, int srcStride) {
            VexFwkBitmap.copyIntArrayToBitmapNative2(srcArray, dstBitmap, srcRoiLeft, srcRopTop, srcRoiRight, srcRoiBottom, srcStride);
        }

        @JvmStatic
        @NotNull
        public final Bitmap convertToBitmap(@NotNull byte[] srcArray, @NotNull Size size, int srcStride, int srcBytePerPixel, @NotNull Bitmap.Config format) {
            Intrinsics.checkNotNullParameter(srcArray, "srcArray");
            Intrinsics.checkNotNullParameter(size, "size");
            Intrinsics.checkNotNullParameter(format, "format");
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(size.getWidth(), size.getHeight(), format);
            Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
            VexFwkBitmap.INSTANCE.copyByteArrayToBitmapNative(srcArray, bitmapCreateBitmap, 0, 0, size.getWidth(), size.getHeight(), srcStride, srcBytePerPixel);
            return bitmapCreateBitmap;
        }

        @JvmStatic
        public final void copyBitmap(@NotNull Bitmap srcBitmap, @NotNull Bitmap dstBitmap) {
            Intrinsics.checkNotNullParameter(srcBitmap, "srcBitmap");
            Intrinsics.checkNotNullParameter(dstBitmap, "dstBitmap");
            copyBitmap(srcBitmap, dstBitmap, 0, 0, srcBitmap.getWidth(), srcBitmap.getHeight());
        }

        @JvmStatic
        @NotNull
        public final Bitmap resizeBitmap(@NotNull Bitmap bitmap, int maxWidth, int maxHeight) {
            Intrinsics.checkNotNullParameter(bitmap, "bitmap");
            if ((maxHeight <= 0) || (maxWidth <= 0)) {
                Bitmap.Config config = bitmap.getConfig();
                if (config == null) {
                    throw new IllegalArgumentException("bitmap.config is null");
                }
                Bitmap bitmapCopy = bitmap.copy(config, true);
                Intrinsics.checkNotNullExpressionValue(bitmapCopy, "copy(...)");
                return bitmapCopy;
            }
            double width = ((double) bitmap.getWidth()) / ((double) bitmap.getHeight());
            double d = maxWidth;
            double d2 = maxHeight;
            double d3 = d / d2;
            if (d3 > width) {
                maxWidth = MathKt.roundToInt(d2 * width);
            } else if (d3 < width) {
                maxHeight = MathKt.roundToInt(d / width);
            }
            Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, maxWidth, maxHeight, true);
            Intrinsics.checkNotNullExpressionValue(bitmapCreateScaledBitmap, "createScaledBitmap(this, width, height, filter)");
            return bitmapCreateScaledBitmap;
        }

        private Companion() {
        }

        @JvmStatic
        public final void copyBitmap(@NotNull Bitmap srcBitmap, @NotNull Bitmap dstBitmap, @NotNull Rect roi) {
            Intrinsics.checkNotNullParameter(srcBitmap, "srcBitmap");
            Intrinsics.checkNotNullParameter(dstBitmap, "dstBitmap");
            Intrinsics.checkNotNullParameter(roi, "roi");
            copyBitmap(srcBitmap, dstBitmap, roi.left, roi.top, roi.right, roi.bottom);
        }

        @JvmStatic
        public final void copyBitmap(@NotNull Bitmap srcBitmap, @NotNull Bitmap dstBitmap, int left, int top, int right, int bottom) {
            Intrinsics.checkNotNullParameter(srcBitmap, "srcBitmap");
            Intrinsics.checkNotNullParameter(dstBitmap, "dstBitmap");
            if ((left < 0) || (top < 0)) {
                throw new IllegalArgumentException(AbstractC0622a.m1164j(left, top, "roiLeft(", ") or roiTop(", ") are less than 0"));
            }
            if (!((right > srcBitmap.getWidth()) | (bottom > srcBitmap.getHeight()))) {
                int i = right - left;
                int i2 = bottom - top;
                if (!((i2 > dstBitmap.getHeight()) | (i > dstBitmap.getWidth()))) {
                    copyBitmapToBitmapNative(srcBitmap, dstBitmap, left, top, right, bottom);
                    return;
                }
                throw new IllegalArgumentException(AbstractC2322a.m1625o(AbstractC0622a.m1173s(i, i2, "roiWidth(", ") or roiHeight(", ") are out of dstBitmap("), dstBitmap.getWidth(), dstBitmap.getHeight(), "x", ")"));
            }
            throw new IllegalArgumentException(AbstractC2322a.m1625o(AbstractC0622a.m1173s(right, bottom, "roiRight(", ") or roiBottom(", ") are out of srcBitmap("), srcBitmap.getWidth(), srcBitmap.getHeight(), "x", ")"));
        }

        @JvmStatic
        public final void copyBitmap(@NotNull Bitmap srcBitmap, @NotNull int[] dstArray) {
            Intrinsics.checkNotNullParameter(srcBitmap, "srcBitmap");
            Intrinsics.checkNotNullParameter(dstArray, "dstArray");
            copyBitmap(srcBitmap, dstArray, 0, 0, srcBitmap.getWidth(), srcBitmap.getHeight());
        }

        @JvmStatic
        public final void copyBitmap(@NotNull int[] srcArray, @NotNull Bitmap dstBitmap) {
            Intrinsics.checkNotNullParameter(srcArray, "srcArray");
            Intrinsics.checkNotNullParameter(dstBitmap, "dstBitmap");
            if (dstBitmap.getHeight() * dstBitmap.getWidth() == srcArray.length) {
                copyBitmap(srcArray, dstBitmap, 0, 0, dstBitmap.getWidth(), dstBitmap.getHeight(), dstBitmap.getWidth());
                return;
            }
            int length = srcArray.length;
            int width = dstBitmap.getWidth();
            throw new IllegalArgumentException(AbstractC2322a.m1625o(AbstractC0622a.m1173s(length, width, "srcArray.size(", ") and dstBitmap.size(", "x"), dstBitmap.getHeight(), dstBitmap.getHeight() * dstBitmap.getWidth(), MarketingConstants.REFERRER_DELIMITER_U003D, ") should be same."));
        }

        @JvmStatic
        public final void copyBitmap(@NotNull Bitmap srcBitmap, @NotNull int[] dstArray, @NotNull Rect roi) {
            Intrinsics.checkNotNullParameter(srcBitmap, "srcBitmap");
            Intrinsics.checkNotNullParameter(dstArray, "dstArray");
            Intrinsics.checkNotNullParameter(roi, "roi");
            copyBitmap(srcBitmap, dstArray, roi.left, roi.top, roi.right, roi.bottom);
        }

        @JvmStatic
        @SuppressLint({WarningType.NewApi})
        public final void copyBitmap(@NotNull Bitmap srcBitmap, @NotNull int[] dstArray, int left, int top, int right, int bottom) {
            Intrinsics.checkNotNullParameter(srcBitmap, "srcBitmap");
            Intrinsics.checkNotNullParameter(dstArray, "dstArray");
            if (srcBitmap.getConfig() == Bitmap.Config.HARDWARE) {
                HardwareBuffer hardwareBuffer = srcBitmap.getHardwareBuffer();
                try {
                    if (hardwareBuffer.getFormat() == 1) {
                        Unit unit = Unit.INSTANCE;
                        AutoCloseableKt.closeFinally(hardwareBuffer, null);
                    } else {
                        throw new IllegalArgumentException("srcBitmap.hardwareBuffer must have RGBA_8888");
                    }
                } finally {
                }
            } else if (srcBitmap.getConfig() != Bitmap.Config.ARGB_8888) {
                throw new IllegalArgumentException("srcBitmap.config must be ARGB_8888");
            }
            copyBitmapToIntArrayNative(srcBitmap, dstArray, left, top, right, bottom);
        }

        @JvmStatic
        public final void copyBitmap(@NotNull int[] srcArray, @NotNull Bitmap dstBitmap, @NotNull Rect srcRoi, int srcStride) {
            Intrinsics.checkNotNullParameter(srcArray, "srcArray");
            Intrinsics.checkNotNullParameter(dstBitmap, "dstBitmap");
            Intrinsics.checkNotNullParameter(srcRoi, "srcRoi");
            copyBitmap(srcArray, dstBitmap, srcRoi.left, srcRoi.top, srcRoi.right, srcRoi.bottom, srcStride);
        }

        @JvmStatic
        public final void copyBitmap(@NotNull int[] srcArray, @NotNull Bitmap dstBitmap, int srcRoiLeft, int srcRoiTop, int srcRoiRight, int srcRoiBottom, int srcStride) {
            Intrinsics.checkNotNullParameter(srcArray, "srcArray");
            Intrinsics.checkNotNullParameter(dstBitmap, "dstBitmap");
            copyIntArrayToBitmapNative2(srcArray, dstBitmap, srcRoiLeft, srcRoiTop, srcRoiRight, srcRoiBottom, srcStride);
        }
    }

    @JvmStatic
    @NotNull
    public static final Bitmap convertToBitmap(@NotNull byte[] bArr, @NotNull Size size, int i, int i2, @NotNull Bitmap.Config config) {
        return INSTANCE.convertToBitmap(bArr, size, i, i2, config);
    }

    @JvmStatic
    public static final void copyBitmap(@NotNull Bitmap bitmap, @NotNull Bitmap bitmap2) {
        INSTANCE.copyBitmap(bitmap, bitmap2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void copyBitmapToBitmapNative(Bitmap bitmap, Bitmap bitmap2, int i, int i2, int i4, int i5);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void copyBitmapToIntArrayNative(Bitmap bitmap, int[] iArr, int i, int i2, int i4, int i5);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void copyByteArrayToBitmapNative(byte[] bArr, Bitmap bitmap, int i, int i2, int i4, int i5, int i6, int i7);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void copyIntArrayToBitmapNative2(int[] iArr, Bitmap bitmap, int i, int i2, int i4, int i5, int i6);

    @JvmStatic
    @NotNull
    public static final Bitmap resizeBitmap(@NotNull Bitmap bitmap, int i, int i2) {
        return INSTANCE.resizeBitmap(bitmap, i, i2);
    }

    @JvmStatic
    public static final void copyBitmap(@NotNull Bitmap bitmap, @NotNull Bitmap bitmap2, int i, int i2, int i4, int i5) {
        INSTANCE.copyBitmap(bitmap, bitmap2, i, i2, i4, i5);
    }

    @JvmStatic
    public static final void copyBitmap(@NotNull Bitmap bitmap, @NotNull Bitmap bitmap2, @NotNull Rect rect) {
        INSTANCE.copyBitmap(bitmap, bitmap2, rect);
    }

    @JvmStatic
    public static final void copyBitmap(@NotNull Bitmap bitmap, @NotNull int[] iArr) {
        INSTANCE.copyBitmap(bitmap, iArr);
    }

    @JvmStatic
    @SuppressLint({WarningType.NewApi})
    public static final void copyBitmap(@NotNull Bitmap bitmap, @NotNull int[] iArr, int i, int i2, int i4, int i5) {
        INSTANCE.copyBitmap(bitmap, iArr, i, i2, i4, i5);
    }

    @JvmStatic
    public static final void copyBitmap(@NotNull Bitmap bitmap, @NotNull int[] iArr, @NotNull Rect rect) {
        INSTANCE.copyBitmap(bitmap, iArr, rect);
    }

    @JvmStatic
    public static final void copyBitmap(@NotNull int[] iArr, @NotNull Bitmap bitmap) {
        INSTANCE.copyBitmap(iArr, bitmap);
    }

    @JvmStatic
    public static final void copyBitmap(@NotNull int[] iArr, @NotNull Bitmap bitmap, int i, int i2, int i4, int i5, int i6) {
        INSTANCE.copyBitmap(iArr, bitmap, i, i2, i4, i5, i6);
    }

    @JvmStatic
    public static final void copyBitmap(@NotNull int[] iArr, @NotNull Bitmap bitmap, @NotNull Rect rect, int i) {
        INSTANCE.copyBitmap(iArr, bitmap, rect, i);
    }
}
