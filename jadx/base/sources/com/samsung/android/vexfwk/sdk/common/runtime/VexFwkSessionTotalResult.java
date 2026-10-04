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

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 $2\u00020\u0001:\u0001$B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\"\u001a\u00020#H\u0016R+\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00038B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0004R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0012\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u001b8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u001e\u001a\u00020\u001f8F¢\u0006\u0006\u001a\u0004\b \u0010!¨\u0006%"}, m13886d2 = {"Lcom/samsung/android/vexfwk/sdk/common/runtime/VexFwkSessionTotalResult;", "Ljava/lang/AutoCloseable;", "nativeHandle", "", "(J)V", "<set-?>", "getNativeHandle", "()J", "setNativeHandle", "nativeHandle$delegate", "Lkotlin/properties/ReadWriteProperty;", "partialResults", "", "Lcom/samsung/android/vexfwk/sdk/common/runtime/VexFwkSessionPartialResult;", "getPartialResults", "()Ljava/util/List;", "partialResultsCached", "Ljava/util/LinkedList;", "request", "Lcom/samsung/android/vexfwk/sdk/common/runtime/VexFwkSessionRequest;", "getRequest", "()Lcom/samsung/android/vexfwk/sdk/common/runtime/VexFwkSessionRequest;", "requestNumber", "", "getRequestNumber", "()I", "requestResult", "", "getRequestResult", "()Z", "resultMetadata", "Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataNative;", "getResultMetadata", "()Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataNative;", "close", "", "Companion", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nVexFwkSessionTotalResult.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VexFwkSessionTotalResult.kt\ncom/samsung/android/vexfwk/sdk/common/runtime/VexFwkSessionTotalResult\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,71:1\n1#2:72\n1855#3,2:73\n*S KotlinDebug\n*F\n+ 1 VexFwkSessionTotalResult.kt\ncom/samsung/android/vexfwk/sdk/common/runtime/VexFwkSessionTotalResult\n*L\n65#1:73,2\n*E\n"})
public final class VexFwkSessionTotalResult implements AutoCloseable {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {AbstractC1974b.m1328u(VexFwkSessionTotalResult.class, "nativeHandle", "getNativeHandle()J", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: nativeHandle$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty nativeHandle = Delegates.INSTANCE.notNull();

    @NotNull
    private final LinkedList<VexFwkSessionPartialResult> partialResultsCached = new LinkedList<>();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0011\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0083 J\u0011\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004H\u0083 J\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\b\u001a\u00020\u0004H\u0083 J\u0011\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u0004H\u0083 J\u0011\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u0004H\u0083 J\u0011\u0010\u0010\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\u0004H\u0083 ¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/vexfwk/sdk/common/runtime/VexFwkSessionTotalResult$Companion;", "", "()V", "cloneNative", "", "bufferHandle", "deleteNative", "", "requestHandle", "getPartialResultsNative", "", "Lcom/samsung/android/vexfwk/sdk/common/runtime/VexFwkSessionPartialResult;", "getRequestNative", "Lcom/samsung/android/vexfwk/sdk/common/runtime/VexFwkSessionRequest;", "getRequestResultNative", "", "getResultMetadataNative", "Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataNative;", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long cloneNative(long bufferHandle) {
            return VexFwkSessionTotalResult.cloneNative(bufferHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void deleteNative(long requestHandle) {
            VexFwkSessionTotalResult.deleteNative(requestHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final VexFwkSessionPartialResult[] getPartialResultsNative(long j) {
            return VexFwkSessionTotalResult.getPartialResultsNative(j);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final VexFwkSessionRequest getRequestNative(long requestHandle) {
            return VexFwkSessionTotalResult.getRequestNative(requestHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean getRequestResultNative(long requestHandle) {
            return VexFwkSessionTotalResult.getRequestResultNative(requestHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final VexFwkMetadataNative getResultMetadataNative(long requestHandle) {
            return VexFwkSessionTotalResult.getResultMetadataNative(requestHandle);
        }

        private Companion() {
        }
    }

    static {
        VexFwkJniLoader.loadLibrary("sdk-v2-jni.vexfwk.samsung");
    }

    public VexFwkSessionTotalResult(long j) {
        setNativeHandle(INSTANCE.cloneNative(j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native long cloneNative(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void deleteNative(long j);

    private final long getNativeHandle() {
        return ((Number) this.nativeHandle.getValue(this, $$delegatedProperties[0])).longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native VexFwkSessionPartialResult[] getPartialResultsNative(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native VexFwkSessionRequest getRequestNative(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean getRequestResultNative(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native VexFwkMetadataNative getResultMetadataNative(long j);

    private final void setNativeHandle(long j) {
        this.nativeHandle.setValue(this, $$delegatedProperties[0], Long.valueOf(j));
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        Iterator<T> it = this.partialResultsCached.iterator();
        while (it.hasNext()) {
            ((VexFwkSessionPartialResult) it.next()).close();
        }
        this.partialResultsCached.clear();
        INSTANCE.deleteNative(getNativeHandle());
    }

    @NotNull
    public final List<VexFwkSessionPartialResult> getPartialResults() {
        if (!this.partialResultsCached.isEmpty()) {
            return this.partialResultsCached;
        }
        List<VexFwkSessionPartialResult> list = ArraysKt.toList(INSTANCE.getPartialResultsNative(getNativeHandle()));
        this.partialResultsCached.addAll(list);
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

    public final boolean getRequestResult() {
        return INSTANCE.getRequestResultNative(getNativeHandle());
    }

    @NotNull
    public final VexFwkMetadataNative getResultMetadata() {
        return INSTANCE.getResultMetadataNative(getNativeHandle());
    }
}
