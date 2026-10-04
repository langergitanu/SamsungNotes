package com.samsung.android.vexfwk.surface;

import android.hardware.HardwareBuffer;
import android.view.Surface;
import com.samsung.android.vexfwk.VexFwkJniLoader;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0016J.\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000bJ\u0006\u0010\u000f\u001a\u00020\u0010J\u001e\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/vexfwk/surface/VexFwkSurfaceWriterNative;", "Ljava/lang/AutoCloseable;", "()V", "nativeHandle", "", "close", "", "configure", "surface", "Landroid/view/Surface;", "width", "", "height", "format", "maxBufferCount", "dequeueImage", "Landroid/hardware/HardwareBuffer;", "enqueueImage", "hardwareBuffer", "timestampNs", "rotationDegree", "Companion", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class VexFwkSurfaceWriterNative implements AutoCloseable {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final boolean m_jniLoaded = VexFwkJniLoader.loadLibrary("common-jni.vexfwk.samsung");
    private final long nativeHandle = INSTANCE.createHandleNative();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J9\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fH\u0083 J\t\u0010\u0010\u001a\u00020\bH\u0083 J\u0011\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\bH\u0083 J)\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\fH\u0083 J\u0011\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0083 R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, m13886d2 = {"Lcom/samsung/android/vexfwk/surface/VexFwkSurfaceWriterNative$Companion;", "", "()V", "m_jniLoaded", "", "configureNative", "", "nativeHandle", "", "surface", "Landroid/view/Surface;", "width", "", "height", "format", "maxBufferCount", "createHandleNative", "dequeueBufferNative", "Landroid/hardware/HardwareBuffer;", "enqueueBufferNative", "hardwareBuffer", "timestampNs", "rotationDegree", "freeHandleNative", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void configureNative(long nativeHandle, Surface surface, int width, int height, int format, int maxBufferCount) {
            VexFwkSurfaceWriterNative.configureNative(nativeHandle, surface, width, height, format, maxBufferCount);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long createHandleNative() {
            return VexFwkSurfaceWriterNative.createHandleNative();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final HardwareBuffer dequeueBufferNative(long nativeHandle) {
            return VexFwkSurfaceWriterNative.dequeueBufferNative(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void enqueueBufferNative(long nativeHandle, HardwareBuffer hardwareBuffer, long timestampNs, int rotationDegree) {
            VexFwkSurfaceWriterNative.enqueueBufferNative(nativeHandle, hardwareBuffer, timestampNs, rotationDegree);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void freeHandleNative(long nativeHandle) {
            VexFwkSurfaceWriterNative.freeHandleNative(nativeHandle);
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void configureNative(long j, Surface surface, int i, int i2, int i4, int i5);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native long createHandleNative();

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native HardwareBuffer dequeueBufferNative(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void enqueueBufferNative(long j, HardwareBuffer hardwareBuffer, long j2, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void freeHandleNative(long j);

    @Override // java.lang.AutoCloseable
    public void close() {
        INSTANCE.freeHandleNative(this.nativeHandle);
    }

    public final void configure(@NotNull Surface surface, int width, int height, int format, int maxBufferCount) {
        Intrinsics.checkNotNullParameter(surface, "surface");
        INSTANCE.configureNative(this.nativeHandle, surface, width, height, format, maxBufferCount);
    }

    @NotNull
    public final HardwareBuffer dequeueImage() {
        return INSTANCE.dequeueBufferNative(this.nativeHandle);
    }

    public final void enqueueImage(@NotNull HardwareBuffer hardwareBuffer, long timestampNs, int rotationDegree) {
        Intrinsics.checkNotNullParameter(hardwareBuffer, "hardwareBuffer");
        INSTANCE.enqueueBufferNative(this.nativeHandle, hardwareBuffer, timestampNs, rotationDegree);
    }
}
