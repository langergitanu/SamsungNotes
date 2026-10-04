package com.samsung.android.vexfwk.metadata;

import android.hardware.HardwareBuffer;
import android.util.Log;
import androidx.core.util.Supplier;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.vexfwk.VexFwkJniLoader;
import java.nio.ByteBuffer;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.commons.beanutils.FluentPropertyBeanIntrospector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 )2\u00020\u0001:\u0001)B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0000¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u0011\b\u0016\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\b\u0010\u0016\u001a\u0004\u0018\u00010\tJ\b\u0010\u0017\u001a\u00020\u0018H\u0004J$\u0010\u0019\u001a\u0004\u0018\u0001H\u001a\"\u0004\b\u0000\u0010\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u001a0\u001cH\u0086\u0002¢\u0006\u0002\u0010\u001dJ-\u0010\u001e\u001a\u0002H\u001a\"\u0004\b\u0000\u0010\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u001a0\u001c2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u001a0 ¢\u0006\u0002\u0010!J\u0006\u0010\"\u001a\u00020#J*\u0010$\u001a\u00020\u0018\"\u0004\b\u0000\u0010\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u001a0\u001c2\u0006\u0010%\u001a\u0002H\u001aH\u0086\u0002¢\u0006\u0002\u0010&J\u000e\u0010'\u001a\u00020\u00182\u0006\u0010(\u001a\u00020#R\u0011\u0010\u000b\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u001e\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0014\u0010\u0005\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\r¨\u0006*"}, m13886d2 = {"Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataNative;", "", "()V", "other", "(Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataNative;)V", "rawHandle", "", "(J)V", "hardwareBuffer", "Landroid/hardware/HardwareBuffer;", "(Landroid/hardware/HardwareBuffer;)V", "bufferCompactSize", "getBufferCompactSize", "()J", "bufferSize", "getBufferSize", "<set-?>", "nativeHandle", "getNativeHandle", "getRawHandle", "copyToByteArray", "", "copyToHardwareBuffer", "finalize", "", "get", "T", "key", "Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey;", "(Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey;)Ljava/lang/Object;", "getOrElse", "defaultValue", "Landroidx/core/util/Supplier;", "(Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey;Landroidx/core/util/Supplier;)Ljava/lang/Object;", "lock", "Ljava/nio/ByteBuffer;", FluentPropertyBeanIntrospector.DEFAULT_WRITE_METHOD_PREFIX, "value", "(Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataKey;Ljava/lang/Object;)V", "unlock", "buffer", "Companion", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nVexFwkMetadataNative.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VexFwkMetadataNative.kt\ncom/samsung/android/vexfwk/metadata/VexFwkMetadataNative\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,172:1\n1#2:173\n*E\n"})
public final class VexFwkMetadataNative {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "VexFwkMetadataNative";
    private static final boolean m_jniLoaded = VexFwkJniLoader.loadLibrary("common-jni.vexfwk.samsung");
    private long nativeHandle;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0011\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0083 J\u0011\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH\u0083 J\u0011\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\tH\u0083 J\u0011\u0010\u0011\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0083 J\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\tH\u0083 J\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\n\u001a\u00020\tH\u0083 J\t\u0010\u0014\u001a\u00020\tH\u0083 J\u0011\u0010\u0015\u001a\u00020\u00162\u0006\u0010\n\u001a\u00020\tH\u0083 J\u0011\u0010\u0017\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\tH\u0083 J\u0011\u0010\u0019\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0083 J\u0011\u0010\u001a\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0083 J\u0011\u0010\u001b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0083 J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0004H\u0007J\u0019\u0010\u001f\u001a\u00020\u001d2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u0004H\u0083 J\u0011\u0010!\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u0004H\u0083 J\u0019\u0010\"\u001a\u00020\u001d2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010#\u001a\u00020\u001dH\u0083 J\u001b\u0010$\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010#\u001a\u00020\u001dH\u0083 J\u0018\u0010%\u001a\u00020\u00162\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020'H\u0007J\u0019\u0010)\u001a\u00020\u00162\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\tH\u0083 J\u0019\u0010*\u001a\u00020\u00162\u0006\u0010\n\u001a\u00020\t2\u0006\u0010+\u001a\u00020\u0018H\u0083 J\u0018\u0010,\u001a\u00020\u00162\u0006\u0010-\u001a\u00020'2\u0006\u0010\n\u001a\u00020'H\u0007J\u0019\u0010.\u001a\u00020\u00162\u0006\u0010-\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0083 J!\u0010/\u001a\u00020\u00162\u0006\u0010-\u001a\u00020\t2\u0006\u0010#\u001a\u00020\u001d2\u0006\u0010\n\u001a\u00020\u000bH\u0083 R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00060"}, m13886d2 = {"Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataNative$Companion;", "", "()V", SearchConstants.TargetContents.TAG, "", "kotlin.jvm.PlatformType", "m_jniLoaded", "", "cloneMetadataFromByteArrayNative", "", "src", "", "cloneMetadataFromHardwareBufferNative", "hardwareBuffer", "Landroid/hardware/HardwareBuffer;", "cloneMetadataNative", "other", "cloneMetadataRawNative", "copyToByteArrayNative", "copyToHardwareBufferNative", "createMetadataNative", "freeMetadataNative", "", "getAndLockByteBufferNative", "Ljava/nio/ByteBuffer;", "getBufferCompactSizeNative", "getBufferSizeNative", "getRawHandleNative", "getTag", "", "keyName", "getTagFromKeyLocalNative", "key", "getTagFromKeyNative", "getTypeFromTagLocalNative", "tag", "readValuesNative", "swap", "a", "Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataNative;", "b", "swapNative", "unlockByteBufferNative", "buffer", Constants.ARG_UPDATE, "dst", "updateNative", "writeValuesNative", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        private final long cloneMetadataFromByteArrayNative(byte[] src) {
            return VexFwkMetadataNative.cloneMetadataFromByteArrayNative(src);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long cloneMetadataFromHardwareBufferNative(HardwareBuffer hardwareBuffer) {
            return VexFwkMetadataNative.cloneMetadataFromHardwareBufferNative(hardwareBuffer);
        }

        @JvmStatic
        private final long cloneMetadataNative(long other) {
            return VexFwkMetadataNative.cloneMetadataNative(other);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Deprecated(message = "This will be removed when JNI usage is removed.")
        @JvmStatic
        public final long cloneMetadataRawNative(long src) {
            return VexFwkMetadataNative.cloneMetadataRawNative(src);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final byte[] copyToByteArrayNative(long src) {
            return VexFwkMetadataNative.copyToByteArrayNative(src);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final HardwareBuffer copyToHardwareBufferNative(long src) {
            return VexFwkMetadataNative.copyToHardwareBufferNative(src);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long createMetadataNative() {
            return VexFwkMetadataNative.createMetadataNative();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void freeMetadataNative(long src) {
            VexFwkMetadataNative.freeMetadataNative(src);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final ByteBuffer getAndLockByteBufferNative(long src) {
            return VexFwkMetadataNative.getAndLockByteBufferNative(src);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long getBufferCompactSizeNative(long src) {
            return VexFwkMetadataNative.getBufferCompactSizeNative(src);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long getBufferSizeNative(long src) {
            return VexFwkMetadataNative.getBufferSizeNative(src);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Deprecated(message = "This will be removed when JNI usage is removed.")
        @JvmStatic
        public final long getRawHandleNative(long src) {
            return VexFwkMetadataNative.getRawHandleNative(src);
        }

        @Deprecated(message = "Not implemented yet")
        @JvmStatic
        private final int getTagFromKeyLocalNative(long src, String key) {
            return VexFwkMetadataNative.getTagFromKeyLocalNative(src, key);
        }

        @JvmStatic
        private final int getTagFromKeyNative(String key) {
            return VexFwkMetadataNative.getTagFromKeyNative(key);
        }

        @JvmStatic
        private final int getTypeFromTagLocalNative(long src, int tag) {
            return VexFwkMetadataNative.getTypeFromTagLocalNative(src, tag);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final byte[] readValuesNative(long src, int tag) {
            return VexFwkMetadataNative.readValuesNative(src, tag);
        }

        @JvmStatic
        private final void swapNative(long src, long other) {
            VexFwkMetadataNative.swapNative(src, other);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void unlockByteBufferNative(long src, ByteBuffer buffer) {
            VexFwkMetadataNative.unlockByteBufferNative(src, buffer);
        }

        @JvmStatic
        private final void updateNative(long dst, long src) {
            VexFwkMetadataNative.updateNative(dst, src);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void writeValuesNative(long dst, int tag, byte[] src) {
            VexFwkMetadataNative.writeValuesNative(dst, tag, src);
        }

        @JvmStatic
        public final int getTag(@NotNull String keyName) {
            Intrinsics.checkNotNullParameter(keyName, "keyName");
            return getTagFromKeyNative(keyName);
        }

        @JvmStatic
        public final void swap(@NotNull VexFwkMetadataNative a, @NotNull VexFwkMetadataNative b) {
            Intrinsics.checkNotNullParameter(a, "a");
            Intrinsics.checkNotNullParameter(b, "b");
            swapNative(a.getNativeHandle(), b.getNativeHandle());
        }

        @JvmStatic
        public final void update(@NotNull VexFwkMetadataNative dst, @NotNull VexFwkMetadataNative src) {
            Intrinsics.checkNotNullParameter(dst, "dst");
            Intrinsics.checkNotNullParameter(src, "src");
            updateNative(dst.getNativeHandle(), src.getNativeHandle());
        }

        private Companion() {
        }
    }

    public VexFwkMetadataNative() {
        this(0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native long cloneMetadataFromByteArrayNative(byte[] bArr);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native long cloneMetadataFromHardwareBufferNative(HardwareBuffer hardwareBuffer);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native long cloneMetadataNative(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @Deprecated(message = "This will be removed when JNI usage is removed.")
    @JvmStatic
    public static final native long cloneMetadataRawNative(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native byte[] copyToByteArrayNative(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native HardwareBuffer copyToHardwareBufferNative(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native long createMetadataNative();

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void freeMetadataNative(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native ByteBuffer getAndLockByteBufferNative(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native long getBufferCompactSizeNative(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native long getBufferSizeNative(long j);

    private final long getRawHandle() {
        return INSTANCE.getRawHandleNative(this.nativeHandle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Deprecated(message = "This will be removed when JNI usage is removed.")
    @JvmStatic
    public static final native long getRawHandleNative(long j);

    @JvmStatic
    public static final int getTag(@NotNull String str) {
        return INSTANCE.getTag(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Deprecated(message = "Not implemented yet")
    @JvmStatic
    public static final native int getTagFromKeyLocalNative(long j, String str);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int getTagFromKeyNative(String str);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int getTypeFromTagLocalNative(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native byte[] readValuesNative(long j, int i);

    @JvmStatic
    public static final void swap(@NotNull VexFwkMetadataNative vexFwkMetadataNative, @NotNull VexFwkMetadataNative vexFwkMetadataNative2) {
        INSTANCE.swap(vexFwkMetadataNative, vexFwkMetadataNative2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void swapNative(long j, long j2);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void unlockByteBufferNative(long j, ByteBuffer byteBuffer);

    @JvmStatic
    public static final void update(@NotNull VexFwkMetadataNative vexFwkMetadataNative, @NotNull VexFwkMetadataNative vexFwkMetadataNative2) {
        INSTANCE.update(vexFwkMetadataNative, vexFwkMetadataNative2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void updateNative(long j, long j2);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void writeValuesNative(long j, int i, byte[] bArr);

    @Nullable
    public final byte[] copyToByteArray() {
        return INSTANCE.copyToByteArrayNative(this.nativeHandle);
    }

    @Nullable
    public final HardwareBuffer copyToHardwareBuffer() {
        return INSTANCE.copyToHardwareBufferNative(this.nativeHandle);
    }

    public final void finalize() {
        Object objM22215constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            long j = this.nativeHandle;
            if (0 != j) {
                INSTANCE.freeMetadataNative(j);
            }
            this.nativeHandle = 0L;
            objM22215constructorimpl = Result.m22215constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM22215constructorimpl = Result.m22215constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m22218exceptionOrNullimpl(objM22215constructorimpl) != null) {
            Log.e(TAG, "Failed to finalize VexFwkMetadataNativeKot");
        }
    }

    @Nullable
    public final <T> T get(@NotNull VexFwkMetadataKey<T> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        byte[] valuesNative = INSTANCE.readValuesNative(this.nativeHandle, key.getTag());
        if (valuesNative == null) {
            return null;
        }
        return key.getConverter().from(valuesNative);
    }

    public final long getBufferCompactSize() {
        return INSTANCE.getBufferCompactSizeNative(this.nativeHandle);
    }

    public final long getBufferSize() {
        return INSTANCE.getBufferSizeNative(this.nativeHandle);
    }

    public final long getNativeHandle() {
        return this.nativeHandle;
    }

    public final <T> T getOrElse(@NotNull VexFwkMetadataKey<T> key, @NotNull Supplier<T> defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        T t = (T) get(key);
        return t == null ? defaultValue.get() : t;
    }

    @NotNull
    public final ByteBuffer lock() {
        return INSTANCE.getAndLockByteBufferNative(this.nativeHandle);
    }

    public final <T> void set(@NotNull VexFwkMetadataKey<T> key, T value) {
        Intrinsics.checkNotNullParameter(key, "key");
        INSTANCE.writeValuesNative(this.nativeHandle, key.getTag(), key.getConverter().mo12821to(value));
    }

    public final void unlock(@NotNull ByteBuffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        INSTANCE.unlockByteBufferNative(this.nativeHandle, buffer);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VexFwkMetadataNative(@NotNull VexFwkMetadataNative other) {
        this(other.getRawHandle());
        Intrinsics.checkNotNullParameter(other, "other");
    }

    public VexFwkMetadataNative(long j) {
        long jCreateMetadataNative = j == 0 ? INSTANCE.createMetadataNative() : INSTANCE.cloneMetadataRawNative(j);
        this.nativeHandle = jCreateMetadataNative;
        if (0 == jCreateMetadataNative) {
            throw new OutOfMemoryError("Failed to allocate native VexFwkMetadata.");
        }
    }

    public VexFwkMetadataNative(@Nullable HardwareBuffer hardwareBuffer) {
        long jCloneMetadataFromHardwareBufferNative;
        if (hardwareBuffer == null) {
            jCloneMetadataFromHardwareBufferNative = INSTANCE.createMetadataNative();
        } else if (hardwareBuffer.getFormat() == 33) {
            jCloneMetadataFromHardwareBufferNative = INSTANCE.cloneMetadataFromHardwareBufferNative(hardwareBuffer);
        } else {
            throw new RuntimeException(AbstractC0000a.m11h(hardwareBuffer.getFormat(), "Only BLOB format is supported for metadata input. : format="));
        }
        this.nativeHandle = jCloneMetadataFromHardwareBufferNative;
        if (0 == jCloneMetadataFromHardwareBufferNative) {
            throw new OutOfMemoryError("Failed to allocate native VexFwkMetadata.");
        }
    }
}
