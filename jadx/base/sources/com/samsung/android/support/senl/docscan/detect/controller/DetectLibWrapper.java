package com.samsung.android.support.senl.docscan.detect.controller;

import com.samsung.android.scs.p140ai.sdkcommon.image.ImageConst;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001%B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0007J\u001a\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0007J\b\u0010\u000e\u001a\u00020\u0007H\u0007J\t\u0010\u000f\u001a\u00020\u000bH\u0087 J\t\u0010\u0010\u001a\u00020\u0007H\u0087 J#\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0087 JN\u0010\u0017\u001a\u00020\u000b2\u0010\u0010\u0018\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0018\u00010\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u00132\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0087 ¢\u0006\u0002\u0010!J\u0013\u0010\"\u001a\u0004\u0018\u00010\u001a2\u0006\u0010#\u001a\u00020\u0013H\u0087 J\u0013\u0010$\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u001aH\u0087 R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, m13886d2 = {"Lcom/samsung/android/support/senl/docscan/detect/controller/DetectLibWrapper;", "", "<init>", "()V", "detectResultListener", "Lcom/samsung/android/support/senl/docscan/detect/controller/DetectLibWrapper$DetectResult;", "setDetectListener", "", "detectResult", "onSmartScanResult", "isDetected", "", "corners", "", "release", "createEngine", "destroyEngine", "tracking", "w", "", "h", "byteBuffer", "", "convertYuvToNV21", "src", "", "Ljava/nio/ByteBuffer;", "dst", "width", "height", "rowStrides", "", "pixelStrides", "([Ljava/nio/ByteBuffer;[BII[I[I)Z", "allocateDirectBuffer", ImageConst.ImageUpscaleConst.SHARED_MEM_CAPACITY, "releaseDirectBuffer", "DetectResult", "docscan_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class DetectLibWrapper {

    @NotNull
    public static final DetectLibWrapper INSTANCE = new DetectLibWrapper();

    @Nullable
    private static DetectResult detectResultListener;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0014\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/docscan/detect/controller/DetectLibWrapper$DetectResult;", "", "onSmartScanResult", "", "isDetected", "", "corners", "", "docscan_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface DetectResult {
        void onSmartScanResult(boolean isDetected, @Nullable float[] corners);
    }

    static {
        System.loadLibrary("detect");
    }

    private DetectLibWrapper() {
    }

    @JvmStatic
    @Nullable
    public static final native ByteBuffer allocateDirectBuffer(int capacity);

    @JvmStatic
    public static final native boolean convertYuvToNV21(@Nullable ByteBuffer[] src, @Nullable byte[] dst, int width, int height, @Nullable int[] rowStrides, @Nullable int[] pixelStrides);

    @JvmStatic
    public static final native boolean createEngine();

    @JvmStatic
    public static final native void destroyEngine();

    @JvmStatic
    public static final void onSmartScanResult(boolean isDetected, @Nullable float[] corners) {
        DetectResult detectResult = detectResultListener;
        if (detectResult != null) {
            Intrinsics.checkNotNull(detectResult);
            detectResult.onSmartScanResult(isDetected, corners);
        }
    }

    @JvmStatic
    public static final void release() {
        detectResultListener = null;
    }

    @JvmStatic
    public static final native void releaseDirectBuffer(@Nullable ByteBuffer byteBuffer);

    @JvmStatic
    public static final void setDetectListener(@Nullable DetectResult detectResult) {
        detectResultListener = detectResult;
    }

    @JvmStatic
    public static final native void tracking(int w, int h, @Nullable byte[] byteBuffer);
}
