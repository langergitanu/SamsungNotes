package com.samsung.android.vexfwk.sdk.common.runtime;

import androidx.compose.runtime.AbstractC1974b;
import com.samsung.android.vexfwk.VexFwkJniLoader;
import com.samsung.android.vexfwk.metadata.VexFwkMetadataNative;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.properties.Delegates;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 #2\u00020\u0001:\u0001#B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010!\u001a\u00020\"H\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\u0002\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00038B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0004R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\tR\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0015\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u001a8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u001e8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 ¨\u0006$"}, m13886d2 = {"Lcom/samsung/android/vexfwk/sdk/common/runtime/VexFwkSessionPartialResult;", "Ljava/lang/AutoCloseable;", "nativeHandle", "", "(J)V", "inputBuffers", "", "Lcom/samsung/android/vexfwk/sdk/common/runtime/VexFwkBuffer;", "getInputBuffers", "()Ljava/util/List;", "inputBuffersCached", "Ljava/util/LinkedList;", "<set-?>", "getNativeHandle", "()J", "setNativeHandle", "nativeHandle$delegate", "Lkotlin/properties/ReadWriteProperty;", "outputBuffers", "getOutputBuffers", "outputBuffersCached", "request", "Lcom/samsung/android/vexfwk/sdk/common/runtime/VexFwkSessionRequest;", "getRequest", "()Lcom/samsung/android/vexfwk/sdk/common/runtime/VexFwkSessionRequest;", "requestNumber", "", "getRequestNumber", "()I", "resultMetadata", "Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataNative;", "getResultMetadata", "()Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataNative;", "close", "", "Companion", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nVexFwkSessionPartialResult.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VexFwkSessionPartialResult.kt\ncom/samsung/android/vexfwk/sdk/common/runtime/VexFwkSessionPartialResult\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,82:1\n1#2:83\n1855#3,2:84\n1855#3,2:86\n*S KotlinDebug\n*F\n+ 1 VexFwkSessionPartialResult.kt\ncom/samsung/android/vexfwk/sdk/common/runtime/VexFwkSessionPartialResult\n*L\n73#1:84,2\n76#1:86,2\n*E\n"})
public final class VexFwkSessionPartialResult implements AutoCloseable {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {AbstractC1974b.m1328u(VexFwkSessionPartialResult.class, "nativeHandle", "getNativeHandle()J", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: nativeHandle$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty nativeHandle = Delegates.INSTANCE.notNull();

    @NotNull
    private final LinkedList<VexFwkBuffer> inputBuffersCached = new LinkedList<>();

    @NotNull
    private final LinkedList<VexFwkBuffer> outputBuffersCached = new LinkedList<>();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0011\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0083 J\u0011\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004H\u0083 J\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\b\u001a\u00020\u0004H\u0083 J\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\b\u001a\u00020\u0004H\u0083 J\u0011\u0010\r\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u0004H\u0083 J\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\b\u001a\u00020\u0004H\u0083 ¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/vexfwk/sdk/common/runtime/VexFwkSessionPartialResult$Companion;", "", "()V", "cloneNative", "", "bufferHandle", "deleteNative", "", "requestHandle", "getInputBuffersNative", "", "Lcom/samsung/android/vexfwk/sdk/common/runtime/VexFwkBuffer;", "getOutputBuffersNative", "getRequestNative", "Lcom/samsung/android/vexfwk/sdk/common/runtime/VexFwkSessionRequest;", "getResultMetadataNative", "Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataNative;", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long cloneNative(long bufferHandle) {
            return VexFwkSessionPartialResult.cloneNative(bufferHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void deleteNative(long requestHandle) {
            VexFwkSessionPartialResult.deleteNative(requestHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final VexFwkBuffer[] getInputBuffersNative(long j) {
            return VexFwkSessionPartialResult.getInputBuffersNative(j);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final VexFwkBuffer[] getOutputBuffersNative(long j) {
            return VexFwkSessionPartialResult.getOutputBuffersNative(j);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final VexFwkSessionRequest getRequestNative(long requestHandle) {
            return VexFwkSessionPartialResult.getRequestNative(requestHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final VexFwkMetadataNative getResultMetadataNative(long requestHandle) {
            return VexFwkSessionPartialResult.getResultMetadataNative(requestHandle);
        }

        private Companion() {
        }
    }

    static {
        VexFwkJniLoader.loadLibrary("sdk-v2-jni.vexfwk.samsung");
    }

    public VexFwkSessionPartialResult(long j) {
        setNativeHandle(INSTANCE.cloneNative(j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native long cloneNative(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void deleteNative(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native VexFwkBuffer[] getInputBuffersNative(long j);

    private final long getNativeHandle() {
        return ((Number) this.nativeHandle.getValue(this, $$delegatedProperties[0])).longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native VexFwkBuffer[] getOutputBuffersNative(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native VexFwkSessionRequest getRequestNative(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native VexFwkMetadataNative getResultMetadataNative(long j);

    private final void setNativeHandle(long j) {
        this.nativeHandle.setValue(this, $$delegatedProperties[0], Long.valueOf(j));
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        Iterator<T> it = this.inputBuffersCached.iterator();
        while (it.hasNext()) {
            ((VexFwkBuffer) it.next()).close();
        }
        this.inputBuffersCached.clear();
        Iterator<T> it2 = this.outputBuffersCached.iterator();
        while (it2.hasNext()) {
            ((VexFwkBuffer) it2.next()).close();
        }
        this.outputBuffersCached.clear();
        INSTANCE.deleteNative(getNativeHandle());
    }

    @NotNull
    public final List<VexFwkBuffer> getInputBuffers() {
        if (!this.inputBuffersCached.isEmpty()) {
            return this.inputBuffersCached;
        }
        List<VexFwkBuffer> list = ArraysKt.toList(INSTANCE.getInputBuffersNative(getNativeHandle()));
        this.inputBuffersCached.addAll(list);
        return list;
    }

    @NotNull
    public final List<VexFwkBuffer> getOutputBuffers() {
        if (!this.outputBuffersCached.isEmpty()) {
            return this.outputBuffersCached;
        }
        List<VexFwkBuffer> list = ArraysKt.toList(INSTANCE.getOutputBuffersNative(getNativeHandle()));
        this.outputBuffersCached.addAll(list);
        return list;
    }

    @NotNull
    public final VexFwkSessionRequest getRequest() {
        return INSTANCE.getRequestNative(getNativeHandle());
    }

    public final int getRequestNumber() {
        VexFwkSessionRequest request = getRequest();
        try {
            int requestFrameNumber = request.getRequestFrameNumber();
            AutoCloseableKt.closeFinally(request, null);
            return requestFrameNumber;
        } finally {
        }
    }

    @Nullable
    public final VexFwkMetadataNative getResultMetadata() {
        return INSTANCE.getResultMetadataNative(getNativeHandle());
    }
}
