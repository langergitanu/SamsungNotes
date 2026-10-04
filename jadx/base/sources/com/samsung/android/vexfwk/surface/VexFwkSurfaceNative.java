package com.samsung.android.vexfwk.surface;

import android.view.Surface;
import com.samsung.android.vexfwk.VexFwkJniLoader;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nJ\b\u0010\r\u001a\u00020\bH\u0004J&\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0006J\u0006\u0010\u0012\u001a\u00020\bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, m13886d2 = {"Lcom/samsung/android/vexfwk/surface/VexFwkSurfaceNative;", "", "surface", "Landroid/view/Surface;", "(Landroid/view/Surface;)V", "nativeHandle", "", "configureSurface", "", "width", "", "height", "rotationDegree", "finalize", "queueBufferWithCopy", "buffer", "Ljava/nio/ByteBuffer;", "timestampNs", "releaseSurface", "Companion", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class VexFwkSurfaceNative {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final boolean m_jniLoaded = VexFwkJniLoader.loadLibrary("common-jni.vexfwk.samsung");
    private final long nativeHandle;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J)\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0083 J\u0011\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0083 J\u0011\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0083 J1\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\bH\u0083 J\u0011\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0083 R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/vexfwk/surface/VexFwkSurfaceNative$Companion;", "", "()V", "m_jniLoaded", "", "configureSurfaceNative", "", "nativeHandle", "", "width", "", "height", "rotationDegree", "createHandleNative", "surface", "Landroid/view/Surface;", "freeHandleNative", "queueBufferWithCopyNative", "buffer", "Ljava/nio/ByteBuffer;", "timestampNs", "releaseSurfaceNative", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void configureSurfaceNative(long nativeHandle, int width, int height, int rotationDegree) {
            VexFwkSurfaceNative.configureSurfaceNative(nativeHandle, width, height, rotationDegree);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long createHandleNative(Surface surface) {
            return VexFwkSurfaceNative.createHandleNative(surface);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void freeHandleNative(long nativeHandle) {
            VexFwkSurfaceNative.freeHandleNative(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void queueBufferWithCopyNative(long nativeHandle, ByteBuffer buffer, int width, int height, long timestampNs) {
            VexFwkSurfaceNative.queueBufferWithCopyNative(nativeHandle, buffer, width, height, timestampNs);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void releaseSurfaceNative(long nativeHandle) {
            VexFwkSurfaceNative.releaseSurfaceNative(nativeHandle);
        }

        private Companion() {
        }
    }

    public VexFwkSurfaceNative(@NotNull Surface surface) {
        Intrinsics.checkNotNullParameter(surface, "surface");
        this.nativeHandle = INSTANCE.createHandleNative(surface);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void configureSurfaceNative(long j, int i, int i2, int i4);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native long createHandleNative(Surface surface);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void freeHandleNative(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void queueBufferWithCopyNative(long j, ByteBuffer byteBuffer, int i, int i2, long j2);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void releaseSurfaceNative(long j);

    public final void configureSurface(int width, int height, int rotationDegree) {
        INSTANCE.configureSurfaceNative(this.nativeHandle, width, height, rotationDegree);
    }

    public final void finalize() {
        INSTANCE.freeHandleNative(this.nativeHandle);
    }

    public final void queueBufferWithCopy(@NotNull ByteBuffer buffer, int width, int height, long timestampNs) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        INSTANCE.queueBufferWithCopyNative(this.nativeHandle, buffer, width, height, timestampNs);
    }

    public final void releaseSurface() {
        INSTANCE.releaseSurfaceNative(this.nativeHandle);
    }
}
