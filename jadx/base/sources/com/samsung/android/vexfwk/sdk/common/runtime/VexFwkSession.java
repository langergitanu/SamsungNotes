package com.samsung.android.vexfwk.sdk.common.runtime;

import com.samsung.android.vexfwk.VexFwkJniLoader;
import com.samsung.android.vexfwk.sdk.common.runtime.VexFwkSessionRequest;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\f\u001a\u00020\rH\u0016J\u000e\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u000f\u001a\u00020\rJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J!\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0012\u001a\u00020\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0017\u0010\u0018R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u001a"}, m13886d2 = {"Lcom/samsung/android/vexfwk/sdk/common/runtime/VexFwkSession;", "Ljava/lang/AutoCloseable;", "()V", "configRequest", "Lcom/samsung/android/vexfwk/sdk/common/runtime/VexFwkSessionConfigRequest;", "nativeHandle", "", "streams", "", "Lcom/samsung/android/vexfwk/sdk/common/runtime/VexFwkStream;", "getStreams", "()Ljava/util/List;", "close", "", "configure", "flush", "processRequest", "Lcom/samsung/android/vexfwk/sdk/common/runtime/VexFwkResultCode;", "request", "Lcom/samsung/android/vexfwk/sdk/common/runtime/VexFwkSessionRequest$Async;", "Lkotlin/Result;", "Lcom/samsung/android/vexfwk/sdk/common/runtime/VexFwkSessionTotalResult;", "Lcom/samsung/android/vexfwk/sdk/common/runtime/VexFwkSessionRequest$Sync;", "processRequest-IoAF18A", "(Lcom/samsung/android/vexfwk/sdk/common/runtime/VexFwkSessionRequest$Sync;)Ljava/lang/Object;", "Companion", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nVexFwkSession.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VexFwkSession.kt\ncom/samsung/android/vexfwk/sdk/common/runtime/VexFwkSession\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,70:1\n1#2:71\n*E\n"})
public final class VexFwkSession implements AutoCloseable {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private VexFwkSessionConfigRequest configRequest;
    private final long nativeHandle = INSTANCE.createNative();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0019\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0083 J\t\u0010\b\u001a\u00020\u0006H\u0083 J\u0011\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0083 J\u0011\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0083 J\u0019\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\u0083 ¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/vexfwk/sdk/common/runtime/VexFwkSession$Companion;", "", "()V", "configureNative", "", "sessionHandle", "", "configRequestHandle", "createNative", "deleteNative", "", "flushNative", "processRequestNative", "requestHandle", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int configureNative(long sessionHandle, long configRequestHandle) {
            return VexFwkSession.configureNative(sessionHandle, configRequestHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long createNative() {
            return VexFwkSession.createNative();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void deleteNative(long sessionHandle) {
            VexFwkSession.deleteNative(sessionHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int flushNative(long sessionHandle) {
            return VexFwkSession.flushNative(sessionHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int processRequestNative(long sessionHandle, long requestHandle) {
            return VexFwkSession.processRequestNative(sessionHandle, requestHandle);
        }

        private Companion() {
        }
    }

    static {
        VexFwkJniLoader.loadLibrary("sdk-v2-jni.vexfwk.samsung");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int configureNative(long j, long j2);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native long createNative();

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void deleteNative(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int flushNative(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int processRequestNative(long j, long j2);

    @Override // java.lang.AutoCloseable
    public void close() {
        VexFwkSessionConfigRequest vexFwkSessionConfigRequest = this.configRequest;
        if (vexFwkSessionConfigRequest != null) {
            vexFwkSessionConfigRequest.close();
        }
        INSTANCE.deleteNative(this.nativeHandle);
    }

    public final void configure(@NotNull VexFwkSessionConfigRequest configRequest) {
        Intrinsics.checkNotNullParameter(configRequest, "configRequest");
        VexFwkSessionConfigRequest vexFwkSessionConfigRequest = this.configRequest;
        if (vexFwkSessionConfigRequest != null) {
            vexFwkSessionConfigRequest.close();
        }
        this.configRequest = configRequest;
        INSTANCE.configureNative(this.nativeHandle, configRequest.getNativeHandle());
    }

    public final void flush() {
        INSTANCE.flushNative(this.nativeHandle);
    }

    @NotNull
    public final List<VexFwkStream> getStreams() {
        List<VexFwkStream> streams;
        VexFwkSessionConfigRequest vexFwkSessionConfigRequest = this.configRequest;
        return (vexFwkSessionConfigRequest == null || (streams = vexFwkSessionConfigRequest.getStreams()) == null) ? CollectionsKt.emptyList() : streams;
    }

    @NotNull
    public final VexFwkResultCode processRequest(@NotNull VexFwkSessionRequest.Async request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return VexFwkResultCode.INSTANCE.fromInt(INSTANCE.processRequestNative(this.nativeHandle, request.getNativeHandle()));
    }

    @NotNull
    /* JADX INFO: renamed from: processRequest-IoAF18A, reason: not valid java name */
    public final Object m22200processRequestIoAF18A(@NotNull VexFwkSessionRequest.Sync request) {
        Intrinsics.checkNotNullParameter(request, "request");
        VexFwkResultCode vexFwkResultCodeFromInt = VexFwkResultCode.INSTANCE.fromInt(INSTANCE.processRequestNative(this.nativeHandle, request.getNativeHandle()));
        if (vexFwkResultCodeFromInt != VexFwkResultCode.f8089OK) {
            Result.Companion companion = Result.INSTANCE;
            return Result.m22215constructorimpl(ResultKt.createFailure(new Exception("Sending Request Failed(" + vexFwkResultCodeFromInt + ")")));
        }
        VexFwkSessionTotalResult vexFwkSessionTotalResultAwaitTotalResult = request.awaitTotalResult();
        if (vexFwkSessionTotalResultAwaitTotalResult.getRequestResult()) {
            return Result.m22215constructorimpl(vexFwkSessionTotalResultAwaitTotalResult);
        }
        vexFwkSessionTotalResultAwaitTotalResult.close();
        Result.Companion companion2 = Result.INSTANCE;
        return Result.m22215constructorimpl(ResultKt.createFailure(new Exception("RequestResult Fail Received")));
    }
}
