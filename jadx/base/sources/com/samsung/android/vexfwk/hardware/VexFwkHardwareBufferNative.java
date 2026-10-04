package com.samsung.android.vexfwk.hardware;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.hardware.HardwareBuffer;
import android.util.Log;
import androidx.annotation.RequiresApi;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.vexfwk.VexFwkJniLoader;
import com.samsung.android.vexfwk.bitmap.VexFwkBitmap;
import com.samsung.android.vexfwk.log.VexFwkLog;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/vexfwk/hardware/VexFwkHardwareBufferNative;", "", "()V", "Companion", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class VexFwkHardwareBufferNative {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final boolean m_jniLoaded = VexFwkJniLoader.loadLibrary("common-jni.vexfwk.samsung");
    private static final String TAG = "VexFwkHardwareBufferNative";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u0007H\u0007J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0011\u0010\u0012\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u000bH\u0083 J)\u0010\u0013\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017H\u0083 J\u0018\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0007J\u0019\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0083 J\u0018\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0007J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0007J\u0019\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\rH\u0083 J(\u0010!\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017H\u0007J)\u0010\"\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017H\u0083 J\u0018\u0010#\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0019\u0010$\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000bH\u0083 J\u0019\u0010%\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020\tH\u0083 J\u0018\u0010'\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\rH\u0007J\u0019\u0010(\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020\rH\u0083 J(\u0010*\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017H\u0007R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, m13886d2 = {"Lcom/samsung/android/vexfwk/hardware/VexFwkHardwareBufferNative$Companion;", "", "()V", SearchConstants.TargetContents.TAG, "", "kotlin.jvm.PlatformType", "m_jniLoaded", "", "convertToArgbIntArray", "", "srcBuffer", "Landroid/hardware/HardwareBuffer;", "convertToBitmap", "Landroid/graphics/Bitmap;", "src", "toMutable", "convertToByteBuffer", "Ljava/nio/ByteBuffer;", "convertToByteBufferNative", "copyByteBufferToHardwareBufferNative", "", "dstBuffer", "width", "", "height", "copyFromArgbIntArray", "copyFromArgbIntArrayNative", "copyFromBitmap", "dst", "copyFromBitmapByFitInto", "Landroid/graphics/Rect;", "copyFromBitmapNative", "srcBitmap", "copyFromByteBuffer", "copyHardwareBufferToByteBufferNative", "copyHardwareBufferToHardwareBuffer", "copyHardwareBufferToHardwareBufferNative", "copyToArgbIntArrayNative", "dstArray", "copyToBitmap", "copyToBitmapNative", "dstBitmap", "copyToByteBuffer", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ Bitmap convertToBitmap$default(Companion companion, HardwareBuffer hardwareBuffer, boolean z, int i, Object obj) {
            if ((i & 2) != 0) {
                z = true;
            }
            return companion.convertToBitmap(hardwareBuffer, z);
        }

        @JvmStatic
        private final ByteBuffer convertToByteBufferNative(HardwareBuffer srcBuffer) {
            return VexFwkHardwareBufferNative.convertToByteBufferNative(srcBuffer);
        }

        @JvmStatic
        private final void copyByteBufferToHardwareBufferNative(ByteBuffer srcBuffer, HardwareBuffer dstBuffer, int width, int height) {
            VexFwkHardwareBufferNative.copyByteBufferToHardwareBufferNative(srcBuffer, dstBuffer, width, height);
        }

        @JvmStatic
        private final void copyFromArgbIntArrayNative(HardwareBuffer dstBuffer, int[] srcBuffer) {
            VexFwkHardwareBufferNative.copyFromArgbIntArrayNative(dstBuffer, srcBuffer);
        }

        @JvmStatic
        private final void copyFromBitmapNative(HardwareBuffer dstBuffer, Bitmap srcBitmap) {
            VexFwkHardwareBufferNative.copyFromBitmapNative(dstBuffer, srcBitmap);
        }

        @JvmStatic
        private final void copyHardwareBufferToByteBufferNative(HardwareBuffer srcBuffer, ByteBuffer dstBuffer, int width, int height) {
            VexFwkHardwareBufferNative.copyHardwareBufferToByteBufferNative(srcBuffer, dstBuffer, width, height);
        }

        @JvmStatic
        private final void copyHardwareBufferToHardwareBufferNative(HardwareBuffer dstBuffer, HardwareBuffer srcBuffer) {
            VexFwkHardwareBufferNative.copyHardwareBufferToHardwareBufferNative(dstBuffer, srcBuffer);
        }

        @JvmStatic
        private final void copyToArgbIntArrayNative(HardwareBuffer srcBuffer, int[] dstArray) {
            VexFwkHardwareBufferNative.copyToArgbIntArrayNative(srcBuffer, dstArray);
        }

        @JvmStatic
        private final void copyToBitmapNative(HardwareBuffer srcBuffer, Bitmap dstBitmap) {
            VexFwkHardwareBufferNative.copyToBitmapNative(srcBuffer, dstBitmap);
        }

        @JvmStatic
        @NotNull
        public final int[] convertToArgbIntArray(@NotNull HardwareBuffer srcBuffer) {
            Intrinsics.checkNotNullParameter(srcBuffer, "srcBuffer");
            int[] iArr = new int[srcBuffer.getHeight() * srcBuffer.getWidth()];
            VexFwkHardwareBufferNative.INSTANCE.copyToArgbIntArrayNative(srcBuffer, iArr);
            return iArr;
        }

        @JvmStatic
        @RequiresApi(29)
        @NotNull
        public final Bitmap convertToBitmap(@NotNull HardwareBuffer src, boolean toMutable) {
            Bitmap bitmapCreateBitmap;
            Intrinsics.checkNotNullParameter(src, "src");
            AbstractC6670b.m4759t("convertToBitmap!! toMutable ", VexFwkHardwareBufferNative.TAG, toMutable);
            try {
                bitmapCreateBitmap = Bitmap.wrapHardwareBuffer(src, null);
                Intrinsics.checkNotNull(bitmapCreateBitmap);
            } catch (Exception e) {
                Log.d(VexFwkHardwareBufferNative.TAG, "WrapHardwareBuffer failed: " + e.getMessage() + " Create Bitmap instead.");
                bitmapCreateBitmap = Bitmap.createBitmap(src.getWidth(), src.getHeight(), Bitmap.Config.ARGB_8888);
                Companion companion = VexFwkHardwareBufferNative.INSTANCE;
                Intrinsics.checkNotNull(bitmapCreateBitmap);
                companion.copyToBitmap(src, bitmapCreateBitmap);
            }
            Intrinsics.checkNotNull(bitmapCreateBitmap);
            if (!toMutable || bitmapCreateBitmap.isMutable()) {
                return bitmapCreateBitmap;
            }
            Bitmap bitmapCopy = bitmapCreateBitmap.copy(Bitmap.Config.ARGB_8888, true);
            Intrinsics.checkNotNullExpressionValue(bitmapCopy, "copy(...)");
            return bitmapCopy;
        }

        @JvmStatic
        @NotNull
        public final ByteBuffer convertToByteBuffer(@NotNull HardwareBuffer srcBuffer) {
            Intrinsics.checkNotNullParameter(srcBuffer, "srcBuffer");
            return convertToByteBufferNative(srcBuffer);
        }

        @JvmStatic
        public final void copyFromArgbIntArray(@NotNull HardwareBuffer dstBuffer, @NotNull int[] srcBuffer) {
            Intrinsics.checkNotNullParameter(dstBuffer, "dstBuffer");
            Intrinsics.checkNotNullParameter(srcBuffer, "srcBuffer");
            if (dstBuffer.getFormat() != 1) {
                throw new IllegalArgumentException("dstHwBuffer should be RGBA_8888 format.");
            }
            copyFromArgbIntArrayNative(dstBuffer, srcBuffer);
        }

        @JvmStatic
        public final void copyFromBitmap(@NotNull HardwareBuffer dst, @NotNull Bitmap src) {
            Intrinsics.checkNotNullParameter(dst, "dst");
            Intrinsics.checkNotNullParameter(src, "src");
            copyFromBitmapNative(dst, src);
        }

        @JvmStatic
        @NotNull
        public final Rect copyFromBitmapByFitInto(@NotNull HardwareBuffer dst, @NotNull Bitmap src) {
            Bitmap bitmapResizeBitmap;
            Intrinsics.checkNotNullParameter(dst, "dst");
            Intrinsics.checkNotNullParameter(src, "src");
            if (src.getWidth() > dst.getWidth() || src.getHeight() > dst.getHeight()) {
                VexFwkLog.INSTANCE.m12816d(VexFwkHardwareBufferNative.TAG, "Resize srcBitmap to fit into dstHardwareBuffer");
                bitmapResizeBitmap = VexFwkBitmap.INSTANCE.resizeBitmap(src, dst.getWidth(), dst.getHeight());
            } else {
                bitmapResizeBitmap = src;
            }
            copyFromBitmap(dst, bitmapResizeBitmap);
            Rect rect = new Rect(0, 0, bitmapResizeBitmap.getWidth(), bitmapResizeBitmap.getHeight());
            if (!Intrinsics.areEqual(bitmapResizeBitmap, src)) {
                bitmapResizeBitmap.recycle();
            }
            return rect;
        }

        @JvmStatic
        public final void copyFromByteBuffer(@NotNull HardwareBuffer dstBuffer, @NotNull ByteBuffer srcBuffer, int width, int height) {
            Intrinsics.checkNotNullParameter(dstBuffer, "dstBuffer");
            Intrinsics.checkNotNullParameter(srcBuffer, "srcBuffer");
            if (!srcBuffer.isDirect()) {
                throw new IllegalArgumentException("srcBuffer should be direct buffer");
            }
            copyByteBufferToHardwareBufferNative(srcBuffer, dstBuffer, width, height);
        }

        @JvmStatic
        public final void copyHardwareBufferToHardwareBuffer(@NotNull HardwareBuffer dstBuffer, @NotNull HardwareBuffer srcBuffer) {
            Intrinsics.checkNotNullParameter(dstBuffer, "dstBuffer");
            Intrinsics.checkNotNullParameter(srcBuffer, "srcBuffer");
            copyHardwareBufferToHardwareBufferNative(dstBuffer, srcBuffer);
        }

        @JvmStatic
        public final void copyToBitmap(@NotNull HardwareBuffer src, @NotNull Bitmap dst) {
            Intrinsics.checkNotNullParameter(src, "src");
            Intrinsics.checkNotNullParameter(dst, "dst");
            copyToBitmapNative(src, dst);
        }

        @JvmStatic
        public final void copyToByteBuffer(@NotNull HardwareBuffer srcBuffer, @NotNull ByteBuffer dstBuffer, int width, int height) {
            Intrinsics.checkNotNullParameter(srcBuffer, "srcBuffer");
            Intrinsics.checkNotNullParameter(dstBuffer, "dstBuffer");
            if (!dstBuffer.isDirect()) {
                throw new IllegalArgumentException("dstBuffer should be direct buffer");
            }
            copyHardwareBufferToByteBufferNative(srcBuffer, dstBuffer, width, height);
        }

        private Companion() {
        }
    }

    @JvmStatic
    @NotNull
    public static final int[] convertToArgbIntArray(@NotNull HardwareBuffer hardwareBuffer) {
        return INSTANCE.convertToArgbIntArray(hardwareBuffer);
    }

    @JvmStatic
    @RequiresApi(29)
    @NotNull
    public static final Bitmap convertToBitmap(@NotNull HardwareBuffer hardwareBuffer, boolean z) {
        return INSTANCE.convertToBitmap(hardwareBuffer, z);
    }

    @JvmStatic
    @NotNull
    public static final ByteBuffer convertToByteBuffer(@NotNull HardwareBuffer hardwareBuffer) {
        return INSTANCE.convertToByteBuffer(hardwareBuffer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native ByteBuffer convertToByteBufferNative(HardwareBuffer hardwareBuffer);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void copyByteBufferToHardwareBufferNative(ByteBuffer byteBuffer, HardwareBuffer hardwareBuffer, int i, int i2);

    @JvmStatic
    public static final void copyFromArgbIntArray(@NotNull HardwareBuffer hardwareBuffer, @NotNull int[] iArr) {
        INSTANCE.copyFromArgbIntArray(hardwareBuffer, iArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void copyFromArgbIntArrayNative(HardwareBuffer hardwareBuffer, int[] iArr);

    @JvmStatic
    public static final void copyFromBitmap(@NotNull HardwareBuffer hardwareBuffer, @NotNull Bitmap bitmap) {
        INSTANCE.copyFromBitmap(hardwareBuffer, bitmap);
    }

    @JvmStatic
    @NotNull
    public static final Rect copyFromBitmapByFitInto(@NotNull HardwareBuffer hardwareBuffer, @NotNull Bitmap bitmap) {
        return INSTANCE.copyFromBitmapByFitInto(hardwareBuffer, bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void copyFromBitmapNative(HardwareBuffer hardwareBuffer, Bitmap bitmap);

    @JvmStatic
    public static final void copyFromByteBuffer(@NotNull HardwareBuffer hardwareBuffer, @NotNull ByteBuffer byteBuffer, int i, int i2) {
        INSTANCE.copyFromByteBuffer(hardwareBuffer, byteBuffer, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void copyHardwareBufferToByteBufferNative(HardwareBuffer hardwareBuffer, ByteBuffer byteBuffer, int i, int i2);

    @JvmStatic
    public static final void copyHardwareBufferToHardwareBuffer(@NotNull HardwareBuffer hardwareBuffer, @NotNull HardwareBuffer hardwareBuffer2) {
        INSTANCE.copyHardwareBufferToHardwareBuffer(hardwareBuffer, hardwareBuffer2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void copyHardwareBufferToHardwareBufferNative(HardwareBuffer hardwareBuffer, HardwareBuffer hardwareBuffer2);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void copyToArgbIntArrayNative(HardwareBuffer hardwareBuffer, int[] iArr);

    @JvmStatic
    public static final void copyToBitmap(@NotNull HardwareBuffer hardwareBuffer, @NotNull Bitmap bitmap) {
        INSTANCE.copyToBitmap(hardwareBuffer, bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void copyToBitmapNative(HardwareBuffer hardwareBuffer, Bitmap bitmap);

    @JvmStatic
    public static final void copyToByteBuffer(@NotNull HardwareBuffer hardwareBuffer, @NotNull ByteBuffer byteBuffer, int i, int i2) {
        INSTANCE.copyToByteBuffer(hardwareBuffer, byteBuffer, i, i2);
    }
}
