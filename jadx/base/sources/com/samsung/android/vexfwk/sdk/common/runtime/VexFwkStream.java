package com.samsung.android.vexfwk.sdk.common.runtime;

import android.view.Surface;
import com.samsung.android.vexfwk.VexFwkJniLoader;
import com.samsung.android.vexfwk.session.VexFwkStreamInoutDirection;
import com.samsung.android.vexfwk.session.VexFwkStreamType;
import com.samsung.android.vexfwk.session.VexFwkStreamUsage;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 12\u00020\u0001:\u00011B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010/\u001a\u000200H\u0016R$\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR$\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR$\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00108F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R$\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0003\u001a\u00020\u001a8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR(\u0010!\u001a\u0004\u0018\u00010 2\b\u0010\u0003\u001a\u0004\u0018\u00010 8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R$\u0010'\u001a\u00020&2\u0006\u0010\u0003\u001a\u00020&8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R$\u0010,\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b-\u0010\u0007\"\u0004\b.\u0010\t¨\u00062"}, m13886d2 = {"Lcom/samsung/android/vexfwk/sdk/common/runtime/VexFwkStream;", "Ljava/lang/AutoCloseable;", "()V", "value", "", "format", "getFormat", "()I", "setFormat", "(I)V", "height", "getHeight", "setHeight", "id", "getId", "setId", "Lcom/samsung/android/vexfwk/session/VexFwkStreamInoutDirection;", "inoutDirection", "getInoutDirection", "()Lcom/samsung/android/vexfwk/session/VexFwkStreamInoutDirection;", "setInoutDirection", "(Lcom/samsung/android/vexfwk/session/VexFwkStreamInoutDirection;)V", "nativeHandle", "", "getNativeHandle", "()J", "Lcom/samsung/android/vexfwk/session/VexFwkStreamType;", "streamType", "getStreamType", "()Lcom/samsung/android/vexfwk/session/VexFwkStreamType;", "setStreamType", "(Lcom/samsung/android/vexfwk/session/VexFwkStreamType;)V", "Landroid/view/Surface;", "surface", "getSurface", "()Landroid/view/Surface;", "setSurface", "(Landroid/view/Surface;)V", "Lcom/samsung/android/vexfwk/session/VexFwkStreamUsage;", "usage", "getUsage", "()Lcom/samsung/android/vexfwk/session/VexFwkStreamUsage;", "setUsage", "(Lcom/samsung/android/vexfwk/session/VexFwkStreamUsage;)V", "width", "getWidth", "setWidth", "close", "", "Companion", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nVexFwkStream.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VexFwkStream.kt\ncom/samsung/android/vexfwk/sdk/common/runtime/VexFwkStream\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,106:1\n1#2:107\n*E\n"})
public final class VexFwkStream implements AutoCloseable {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final long nativeHandle = INSTANCE.createNative();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004H\u0083 J\u0011\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0083 J\u0011\u0010\b\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u0004H\u0083 J\u0011\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u0004H\u0083 J\u0011\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u0004H\u0083 J\u0011\u0010\f\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u0004H\u0083 J\u0011\u0010\r\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u0004H\u0083 J\u0011\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u0004H\u0083 J\u0011\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u0004H\u0083 J\u0011\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u0004H\u0083 J\u0019\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\tH\u0083 J\u0019\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\tH\u0083 J\u0019\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\tH\u0083 J\u0019\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\tH\u0083 J\u0019\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\tH\u0083 J\u0019\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u000fH\u0083 J\u0019\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\tH\u0083 J\u0019\u0010 \u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\tH\u0083 ¨\u0006\""}, m13886d2 = {"Lcom/samsung/android/vexfwk/sdk/common/runtime/VexFwkStream$Companion;", "", "()V", "createNative", "", "deleteNative", "", "streamHandle", "getFormatNative", "", "getHeightNative", "getIdNative", "getInoutDirectionNative", "getStreamTypeNative", "getSurfaceNative", "Landroid/view/Surface;", "getUsageNative", "getWidthNative", "setFormatNative", "format", "setHeightNative", "height", "setIdNative", "id", "setInoutDirectionNative", "inoutDirection", "setStreamTypeNative", "streamType", "setSurfaceNative", "surface", "setUsageNative", "usage", "setWidthNative", "width", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long createNative() {
            return VexFwkStream.createNative();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void deleteNative(long streamHandle) {
            VexFwkStream.deleteNative(streamHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int getFormatNative(long streamHandle) {
            return VexFwkStream.getFormatNative(streamHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int getHeightNative(long streamHandle) {
            return VexFwkStream.getHeightNative(streamHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int getIdNative(long streamHandle) {
            return VexFwkStream.getIdNative(streamHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int getInoutDirectionNative(long streamHandle) {
            return VexFwkStream.getInoutDirectionNative(streamHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int getStreamTypeNative(long streamHandle) {
            return VexFwkStream.getStreamTypeNative(streamHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final Surface getSurfaceNative(long streamHandle) {
            return VexFwkStream.getSurfaceNative(streamHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int getUsageNative(long streamHandle) {
            return VexFwkStream.getUsageNative(streamHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int getWidthNative(long streamHandle) {
            return VexFwkStream.getWidthNative(streamHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void setFormatNative(long streamHandle, int format) {
            VexFwkStream.setFormatNative(streamHandle, format);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void setHeightNative(long streamHandle, int height) {
            VexFwkStream.setHeightNative(streamHandle, height);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void setIdNative(long streamHandle, int id) {
            VexFwkStream.setIdNative(streamHandle, id);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void setInoutDirectionNative(long streamHandle, int inoutDirection) {
            VexFwkStream.setInoutDirectionNative(streamHandle, inoutDirection);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void setStreamTypeNative(long streamHandle, int streamType) {
            VexFwkStream.setStreamTypeNative(streamHandle, streamType);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void setSurfaceNative(long streamHandle, Surface surface) {
            VexFwkStream.setSurfaceNative(streamHandle, surface);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void setUsageNative(long streamHandle, int usage) {
            VexFwkStream.setUsageNative(streamHandle, usage);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void setWidthNative(long streamHandle, int width) {
            VexFwkStream.setWidthNative(streamHandle, width);
        }

        private Companion() {
        }
    }

    static {
        VexFwkJniLoader.loadLibrary("sdk-v2-jni.vexfwk.samsung");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native long createNative();

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void deleteNative(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int getFormatNative(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int getHeightNative(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int getIdNative(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int getInoutDirectionNative(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int getStreamTypeNative(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native Surface getSurfaceNative(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int getUsageNative(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int getWidthNative(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void setFormatNative(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void setHeightNative(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void setIdNative(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void setInoutDirectionNative(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void setStreamTypeNative(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void setSurfaceNative(long j, Surface surface);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void setUsageNative(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void setWidthNative(long j, int i);

    @Override // java.lang.AutoCloseable
    public void close() {
        INSTANCE.deleteNative(this.nativeHandle);
    }

    public final int getFormat() {
        return INSTANCE.getFormatNative(this.nativeHandle);
    }

    public final int getHeight() {
        return INSTANCE.getHeightNative(this.nativeHandle);
    }

    public final int getId() {
        return INSTANCE.getIdNative(this.nativeHandle);
    }

    @NotNull
    public final VexFwkStreamInoutDirection getInoutDirection() {
        return VexFwkStreamInoutDirection.INSTANCE.from(INSTANCE.getInoutDirectionNative(this.nativeHandle));
    }

    public final long getNativeHandle() {
        return this.nativeHandle;
    }

    @NotNull
    public final VexFwkStreamType getStreamType() {
        return VexFwkStreamType.INSTANCE.from(INSTANCE.getStreamTypeNative(this.nativeHandle));
    }

    @Nullable
    public final Surface getSurface() {
        return INSTANCE.getSurfaceNative(this.nativeHandle);
    }

    @NotNull
    public final VexFwkStreamUsage getUsage() {
        return VexFwkStreamUsage.INSTANCE.from(INSTANCE.getUsageNative(this.nativeHandle));
    }

    public final int getWidth() {
        return INSTANCE.getWidthNative(this.nativeHandle);
    }

    public final void setFormat(int i) {
        INSTANCE.setFormatNative(this.nativeHandle, i);
    }

    public final void setHeight(int i) {
        INSTANCE.setHeightNative(this.nativeHandle, i);
    }

    public final void setId(int i) {
        INSTANCE.setIdNative(this.nativeHandle, i);
    }

    public final void setInoutDirection(@NotNull VexFwkStreamInoutDirection value) {
        Intrinsics.checkNotNullParameter(value, "value");
        INSTANCE.setInoutDirectionNative(this.nativeHandle, value.getValue());
    }

    public final void setStreamType(@NotNull VexFwkStreamType value) {
        Intrinsics.checkNotNullParameter(value, "value");
        INSTANCE.setStreamTypeNative(this.nativeHandle, value.getValue());
    }

    public final void setSurface(@Nullable Surface surface) {
        if (surface != null) {
            INSTANCE.setSurfaceNative(this.nativeHandle, surface);
        }
    }

    public final void setUsage(@NotNull VexFwkStreamUsage value) {
        Intrinsics.checkNotNullParameter(value, "value");
        INSTANCE.setUsageNative(this.nativeHandle, value.getValue());
    }

    public final void setWidth(int i) {
        INSTANCE.setWidthNative(this.nativeHandle, i);
    }
}
