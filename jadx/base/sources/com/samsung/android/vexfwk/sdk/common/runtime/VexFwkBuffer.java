package com.samsung.android.vexfwk.sdk.common.runtime;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.hardware.HardwareBuffer;
import android.media.Image;
import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.AbstractC1974b;
import com.google.firebase.messaging.Constants;
import com.microsoft.identity.common.java.WarningType;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.vexfwk.VexFwkJniLoader;
import kotlin.Metadata;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.properties.Delegates;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 \u00182\u00020\u0001:\u0002\u0017\u0018B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00048F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u0005R\u0011\u0010\u0011\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0019"}, m13886d2 = {"Lcom/samsung/android/vexfwk/sdk/common/runtime/VexFwkBuffer;", "Ljava/lang/AutoCloseable;", "()V", "nativeHandle", "", "(J)V", "hardwareBuffer", "Landroid/hardware/HardwareBuffer;", "getHardwareBuffer", "()Landroid/hardware/HardwareBuffer;", "hardwareBufferCached", "<set-?>", "getNativeHandle", "()J", "setNativeHandle", "nativeHandle$delegate", "Lkotlin/properties/ReadWriteProperty;", "streamId", "", "getStreamId", "()I", "close", "", "BitmapBuffer", "Companion", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nVexFwkBuffer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VexFwkBuffer.kt\ncom/samsung/android/vexfwk/sdk/common/runtime/VexFwkBuffer\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,108:1\n1#2:109\n*E\n"})
public class VexFwkBuffer implements AutoCloseable {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {AbstractC1974b.m1328u(VexFwkBuffer.class, "nativeHandle", "getNativeHandle()J", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "VexFwkBuffer";

    @Nullable
    private HardwareBuffer hardwareBufferCached;

    /* JADX INFO: renamed from: nativeHandle$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty nativeHandle = Delegates.INSTANCE.notNull();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/vexfwk/sdk/common/runtime/VexFwkBuffer$BitmapBuffer;", "Lcom/samsung/android/vexfwk/sdk/common/runtime/VexFwkBuffer;", "streamId", "", "bitmap", "Landroid/graphics/Bitmap;", "(ILandroid/graphics/Bitmap;)V", "bitmapHardware", "close", "", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    @SuppressLint({WarningType.NewApi})
    public static final class BitmapBuffer extends VexFwkBuffer {

        @NotNull
        private final Bitmap bitmap;

        @NotNull
        private final Bitmap bitmapHardware;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[Bitmap.Config.values().length];
                try {
                    iArr[Bitmap.Config.HARDWARE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public BitmapBuffer(int i, @NotNull Bitmap bitmap) {
            Bitmap bitmapCopy;
            Intrinsics.checkNotNullParameter(bitmap, "bitmap");
            this.bitmap = bitmap;
            Bitmap.Config config = bitmap.getConfig();
            if ((config == null ? -1 : WhenMappings.$EnumSwitchMapping$0[config.ordinal()]) == 1) {
                bitmapCopy = bitmap;
            } else {
                bitmapCopy = bitmap.copy(Bitmap.Config.HARDWARE, false);
                Intrinsics.checkNotNullExpressionValue(bitmapCopy, "copy(...)");
            }
            this.bitmapHardware = bitmapCopy;
            setNativeHandle(VexFwkBuffer.INSTANCE.createBitmapNative(i, bitmap, bitmapCopy));
        }

        @Override // com.samsung.android.vexfwk.sdk.common.runtime.VexFwkBuffer, java.lang.AutoCloseable
        public void close() {
            super.close();
            if (this.bitmap.hashCode() != this.bitmapHardware.hashCode()) {
                this.bitmapHardware.recycle();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0011\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0083 J!\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0083 J\u001b\u0010\u000f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0083 J\u0011\u0010\u0012\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\u0007H\u0083 J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\u000bH\u0007J#\u0010\u0014\u001a\u00020\u0015\"\u0004\b\u0000\u0010\u00162\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u0002H\u0016H\u0007¢\u0006\u0002\u0010\u0018J\u0018\u0010\u0014\u001a\u00020\u00192\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u001bH\u0007J\u0011\u0010\u001c\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\u0007H\u0083 J\u0011\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0007H\u0083 R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, m13886d2 = {"Lcom/samsung/android/vexfwk/sdk/common/runtime/VexFwkBuffer$Companion;", "", "()V", SearchConstants.TargetContents.TAG, "", "kotlin.jvm.PlatformType", "cloneNative", "", "bufferHandle", "createBitmapNative", "streamId", "", "bitmap", "Landroid/graphics/Bitmap;", "bitmapHardware", "createNative", "hardwareBuffer", "Landroid/hardware/HardwareBuffer;", "deleteNative", "", Constants.MessagePayloadKeys.FROM, "Lcom/samsung/android/vexfwk/sdk/common/runtime/VexFwkBuffer;", "T", "buffer", "(ILjava/lang/Object;)Lcom/samsung/android/vexfwk/sdk/common/runtime/VexFwkBuffer;", "Lcom/samsung/android/vexfwk/sdk/common/runtime/VexFwkBuffer$BitmapBuffer;", "image", "Landroid/media/Image;", "getHardwareBufferNative", "getStreamIdNative", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nVexFwkBuffer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VexFwkBuffer.kt\ncom/samsung/android/vexfwk/sdk/common/runtime/VexFwkBuffer$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,108:1\n1#2:109\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long cloneNative(long bufferHandle) {
            return VexFwkBuffer.cloneNative(bufferHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long createBitmapNative(int streamId, Bitmap bitmap, Bitmap bitmapHardware) {
            return VexFwkBuffer.createBitmapNative(streamId, bitmap, bitmapHardware);
        }

        @JvmStatic
        private final long createNative(int streamId, HardwareBuffer hardwareBuffer) {
            return VexFwkBuffer.createNative(streamId, hardwareBuffer);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void deleteNative(long bufferHandle) {
            VexFwkBuffer.deleteNative(bufferHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final HardwareBuffer getHardwareBufferNative(long bufferHandle) {
            return VexFwkBuffer.getHardwareBufferNative(bufferHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int getStreamIdNative(long bufferHandle) {
            return VexFwkBuffer.getStreamIdNative(bufferHandle);
        }

        @JvmStatic
        @NotNull
        public final VexFwkBuffer from(int streamId, @NotNull Image image) {
            Intrinsics.checkNotNullParameter(image, "image");
            VexFwkBuffer vexFwkBuffer = new VexFwkBuffer();
            HardwareBuffer hardwareBuffer = image.getHardwareBuffer();
            Intrinsics.checkNotNull(hardwareBuffer);
            try {
                long jCreateNative = VexFwkBuffer.INSTANCE.createNative(streamId, hardwareBuffer);
                AutoCloseableKt.closeFinally(hardwareBuffer, null);
                vexFwkBuffer.setNativeHandle(jCreateNative);
                return vexFwkBuffer;
            } finally {
            }
        }

        private Companion() {
        }

        @JvmStatic
        @NotNull
        public final BitmapBuffer from(int streamId, @NotNull Bitmap bitmap) {
            Intrinsics.checkNotNullParameter(bitmap, "bitmap");
            return new BitmapBuffer(streamId, bitmap);
        }

        @JvmStatic
        @NotNull
        public final VexFwkBuffer from(int streamId) {
            VexFwkBuffer vexFwkBuffer = new VexFwkBuffer();
            vexFwkBuffer.setNativeHandle(VexFwkBuffer.INSTANCE.createNative(streamId, null));
            return vexFwkBuffer;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @JvmStatic
        @NotNull
        public final <T> VexFwkBuffer from(int streamId, T buffer) {
            if (buffer instanceof Image) {
                return from(streamId, (Image) buffer);
            }
            if (buffer instanceof Bitmap) {
                return from(streamId, (Bitmap) buffer);
            }
            throw new IllegalArgumentException(AbstractC0622a.m1165k(buffer, "Unsupported buffer type(", ")"));
        }
    }

    static {
        VexFwkJniLoader.loadLibrary("sdk-v2-jni.vexfwk.samsung");
    }

    public VexFwkBuffer() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native long cloneNative(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native long createBitmapNative(int i, Bitmap bitmap, Bitmap bitmap2);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native long createNative(int i, HardwareBuffer hardwareBuffer);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void deleteNative(long j);

    @JvmStatic
    @NotNull
    public static final BitmapBuffer from(int i, @NotNull Bitmap bitmap) {
        return INSTANCE.from(i, bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native HardwareBuffer getHardwareBufferNative(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int getStreamIdNative(long j);

    @Override // java.lang.AutoCloseable
    public void close() {
        INSTANCE.deleteNative(getNativeHandle());
        HardwareBuffer hardwareBuffer = this.hardwareBufferCached;
        if (hardwareBuffer != null) {
            hardwareBuffer.close();
        }
        this.hardwareBufferCached = null;
    }

    @NotNull
    public final HardwareBuffer getHardwareBuffer() {
        HardwareBuffer hardwareBuffer = this.hardwareBufferCached;
        if (hardwareBuffer != null) {
            return hardwareBuffer;
        }
        HardwareBuffer hardwareBufferNative = INSTANCE.getHardwareBufferNative(getNativeHandle());
        this.hardwareBufferCached = hardwareBufferNative;
        return hardwareBufferNative;
    }

    public final long getNativeHandle() {
        return ((Number) this.nativeHandle.getValue(this, $$delegatedProperties[0])).longValue();
    }

    public final int getStreamId() {
        return INSTANCE.getStreamIdNative(getNativeHandle());
    }

    public final void setNativeHandle(long j) {
        this.nativeHandle.setValue(this, $$delegatedProperties[0], Long.valueOf(j));
    }

    @JvmStatic
    @NotNull
    public static final VexFwkBuffer from(int i) {
        return INSTANCE.from(i);
    }

    public VexFwkBuffer(long j) {
        setNativeHandle(INSTANCE.cloneNative(j));
    }

    @JvmStatic
    @NotNull
    public static final VexFwkBuffer from(int i, @NotNull Image image) {
        return INSTANCE.from(i, image);
    }

    @JvmStatic
    @NotNull
    public static final <T> VexFwkBuffer from(int i, T t) {
        return INSTANCE.from(i, t);
    }
}
