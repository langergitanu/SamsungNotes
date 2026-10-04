package com.samsung.android.vexfwk.sdk.common.runtime;

import com.samsung.android.sdk.mobileservice.profile.Profile;
import com.samsung.android.support.senl.p148nt.app.sync.cloudsettings.callee.NotesSyncProvider;
import com.samsung.android.vexfwk.VexFwkJniLoader;
import com.samsung.android.vexfwk.metadata.VexFwkMetadataNative;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 ,2\u00020\u0001:\u0004*+,-B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010(\u001a\u00020)H\u0016R(\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR0\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R0\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u0011\"\u0004\b\u001a\u0010\u0013R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0006\u001a\u00020\u001c8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R(\u0010#\u001a\u0004\u0018\u00010\"2\b\u0010\u0006\u001a\u0004\u0018\u00010\"8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006."}, m13886d2 = {"Lcom/samsung/android/vexfwk/sdk/common/runtime/VexFwkSessionRequest;", "Ljava/lang/AutoCloseable;", "()V", "nativeHandle", "", "(J)V", "value", "Lcom/samsung/android/vexfwk/sdk/common/runtime/IVexFwkSessionCallback;", Profile.PhoneNumberData.TYPE_CALLBACK, "getCallback", "()Lcom/samsung/android/vexfwk/sdk/common/runtime/IVexFwkSessionCallback;", "setCallback", "(Lcom/samsung/android/vexfwk/sdk/common/runtime/IVexFwkSessionCallback;)V", "", "Lcom/samsung/android/vexfwk/sdk/common/runtime/VexFwkBuffer;", "inputBuffers", "getInputBuffers", "()Ljava/util/List;", "setInputBuffers", "(Ljava/util/List;)V", "inputBuffersCached", "Ljava/util/LinkedList;", "getNativeHandle", "()J", "outputBuffers", "getOutputBuffers", "setOutputBuffers", "outputBuffersCached", "", "requestFrameNumber", "getRequestFrameNumber", "()I", "setRequestFrameNumber", "(I)V", "Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataNative;", "settingMetadata", "getSettingMetadata", "()Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataNative;", "setSettingMetadata", "(Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataNative;)V", "close", "", "Async", "Builder", "Companion", NotesSyncProvider.METHOD.SYNC, "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nVexFwkSessionRequest.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VexFwkSessionRequest.kt\ncom/samsung/android/vexfwk/sdk/common/runtime/VexFwkSessionRequest\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,158:1\n1#2:159\n1549#3:160\n1620#3,3:161\n1549#3:164\n1620#3,3:165\n1855#3,2:168\n1855#3,2:170\n*S KotlinDebug\n*F\n+ 1 VexFwkSessionRequest.kt\ncom/samsung/android/vexfwk/sdk/common/runtime/VexFwkSessionRequest\n*L\n97#1:160\n97#1:161,3\n106#1:164\n106#1:165,3\n122#1:168,2\n125#1:170,2\n*E\n"})
public class VexFwkSessionRequest implements AutoCloseable {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private final LinkedList<VexFwkBuffer> inputBuffersCached;
    private final long nativeHandle;

    @NotNull
    private final LinkedList<VexFwkBuffer> outputBuffersCached;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/vexfwk/sdk/common/runtime/VexFwkSessionRequest$Async;", "Lcom/samsung/android/vexfwk/sdk/common/runtime/VexFwkSessionRequest;", "()V", "Builder", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class Async extends VexFwkSessionRequest {

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/vexfwk/sdk/common/runtime/VexFwkSessionRequest$Async$Builder;", "Lcom/samsung/android/vexfwk/sdk/common/runtime/VexFwkSessionRequest$Builder;", "()V", Profile.PhoneNumberData.TYPE_CALLBACK, "Lcom/samsung/android/vexfwk/sdk/common/runtime/IVexFwkSessionCallback;", "build", "Lcom/samsung/android/vexfwk/sdk/common/runtime/VexFwkSessionRequest$Async;", "setCallback", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
        @SourceDebugExtension({"SMAP\nVexFwkSessionRequest.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VexFwkSessionRequest.kt\ncom/samsung/android/vexfwk/sdk/common/runtime/VexFwkSessionRequest$Async$Builder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,158:1\n1#2:159\n*E\n"})
        public static final class Builder extends Builder {
            private IVexFwkSessionCallback callback;

            @NotNull
            public final Async build() {
                Async async = new Async();
                async.setSettingMetadata(getSettingMetadata());
                async.setInputBuffers(getInputBuffers());
                async.setOutputBuffers(getOutputBuffers());
                IVexFwkSessionCallback iVexFwkSessionCallback = this.callback;
                if (iVexFwkSessionCallback == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(Profile.PhoneNumberData.TYPE_CALLBACK);
                    iVexFwkSessionCallback = null;
                }
                async.setCallback(iVexFwkSessionCallback);
                return async;
            }

            @NotNull
            public final Builder setCallback(@NotNull IVexFwkSessionCallback callback) {
                Intrinsics.checkNotNullParameter(callback, "callback");
                this.callback = callback;
                return this;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/vexfwk/sdk/common/runtime/VexFwkSessionRequest$Builder;", "", "()V", "inputBuffers", "Ljava/util/LinkedList;", "Lcom/samsung/android/vexfwk/sdk/common/runtime/VexFwkBuffer;", "getInputBuffers", "()Ljava/util/LinkedList;", "outputBuffers", "getOutputBuffers", "settingMetadata", "Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataNative;", "getSettingMetadata", "()Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataNative;", "setSettingMetadata", "(Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataNative;)V", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static abstract class Builder {

        @NotNull
        private final LinkedList<VexFwkBuffer> inputBuffers = new LinkedList<>();

        @NotNull
        private final LinkedList<VexFwkBuffer> outputBuffers = new LinkedList<>();

        @Nullable
        private VexFwkMetadataNative settingMetadata;

        @NotNull
        public final LinkedList<VexFwkBuffer> getInputBuffers() {
            return this.inputBuffers;
        }

        @NotNull
        public final LinkedList<VexFwkBuffer> getOutputBuffers() {
            return this.outputBuffers;
        }

        @Nullable
        public final VexFwkMetadataNative getSettingMetadata() {
            return this.settingMetadata;
        }

        public final void setSettingMetadata(@Nullable VexFwkMetadataNative vexFwkMetadataNative) {
            this.settingMetadata = vexFwkMetadataNative;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0011\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0083 J\u0011\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006H\u0083 J\t\u0010\b\u001a\u00020\u0006H\u0083 J\u0011\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0083 J\u0011\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0083 J\u0019\u0010\r\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fH\u0083 J\u0019\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012H\u0083 J\u0019\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012H\u0083 J\u0019\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0006H\u0083 ¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/vexfwk/sdk/common/runtime/VexFwkSessionRequest$Companion;", "", "()V", "awaitTotalResultNative", "Lcom/samsung/android/vexfwk/sdk/common/runtime/VexFwkSessionTotalResult;", "requestHandle", "", "cloneNative", "createNative", "deleteNative", "", "getRequestNumberNative", "", "setCallbackNative", Profile.PhoneNumberData.TYPE_CALLBACK, "Lcom/samsung/android/vexfwk/sdk/common/runtime/IVexFwkSessionCallback;", "setInputBuffersNative", "bufferHandleArray", "", "setOutputBuffersNative", "setSettingMetadataNative", "settingMetadataHandle", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final VexFwkSessionTotalResult awaitTotalResultNative(long requestHandle) {
            return VexFwkSessionRequest.awaitTotalResultNative(requestHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long cloneNative(long requestHandle) {
            return VexFwkSessionRequest.cloneNative(requestHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long createNative() {
            return VexFwkSessionRequest.createNative();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void deleteNative(long requestHandle) {
            VexFwkSessionRequest.deleteNative(requestHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int getRequestNumberNative(long requestHandle) {
            return VexFwkSessionRequest.getRequestNumberNative(requestHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void setCallbackNative(long requestHandle, IVexFwkSessionCallback callback) {
            VexFwkSessionRequest.setCallbackNative(requestHandle, callback);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void setInputBuffersNative(long requestHandle, long[] bufferHandleArray) {
            VexFwkSessionRequest.setInputBuffersNative(requestHandle, bufferHandleArray);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void setOutputBuffersNative(long requestHandle, long[] bufferHandleArray) {
            VexFwkSessionRequest.setOutputBuffersNative(requestHandle, bufferHandleArray);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void setSettingMetadataNative(long requestHandle, long settingMetadataHandle) {
            VexFwkSessionRequest.setSettingMetadataNative(requestHandle, settingMetadataHandle);
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0005B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/vexfwk/sdk/common/runtime/VexFwkSessionRequest$Sync;", "Lcom/samsung/android/vexfwk/sdk/common/runtime/VexFwkSessionRequest;", "()V", "awaitTotalResult", "Lcom/samsung/android/vexfwk/sdk/common/runtime/VexFwkSessionTotalResult;", "Builder", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class Sync extends VexFwkSessionRequest {

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, m13886d2 = {"Lcom/samsung/android/vexfwk/sdk/common/runtime/VexFwkSessionRequest$Sync$Builder;", "Lcom/samsung/android/vexfwk/sdk/common/runtime/VexFwkSessionRequest$Builder;", "()V", "build", "Lcom/samsung/android/vexfwk/sdk/common/runtime/VexFwkSessionRequest$Sync;", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
        public static final class Builder extends Builder {
            @NotNull
            public final Sync build() {
                Sync sync = new Sync();
                sync.setSettingMetadata(getSettingMetadata());
                sync.setInputBuffers(getInputBuffers());
                sync.setOutputBuffers(getOutputBuffers());
                return sync;
            }
        }

        @NotNull
        public final VexFwkSessionTotalResult awaitTotalResult() {
            return VexFwkSessionRequest.INSTANCE.awaitTotalResultNative(getNativeHandle());
        }
    }

    static {
        VexFwkJniLoader.loadLibrary("sdk-v2-jni.vexfwk.samsung");
    }

    public VexFwkSessionRequest() {
        this.inputBuffersCached = new LinkedList<>();
        this.outputBuffersCached = new LinkedList<>();
        this.nativeHandle = INSTANCE.createNative();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native VexFwkSessionTotalResult awaitTotalResultNative(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native long cloneNative(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native long createNative();

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void deleteNative(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int getRequestNumberNative(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void setCallbackNative(long j, IVexFwkSessionCallback iVexFwkSessionCallback);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void setInputBuffersNative(long j, long[] jArr);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void setOutputBuffersNative(long j, long[] jArr);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void setSettingMetadataNative(long j, long j2);

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
        INSTANCE.deleteNative(this.nativeHandle);
    }

    @Nullable
    public final IVexFwkSessionCallback getCallback() {
        throw new NotImplementedError(null, 1, null);
    }

    @NotNull
    public final List<VexFwkBuffer> getInputBuffers() {
        return this.inputBuffersCached;
    }

    public final long getNativeHandle() {
        return this.nativeHandle;
    }

    @NotNull
    public final List<VexFwkBuffer> getOutputBuffers() {
        return this.outputBuffersCached;
    }

    public final int getRequestFrameNumber() {
        return INSTANCE.getRequestNumberNative(this.nativeHandle);
    }

    @Nullable
    public final VexFwkMetadataNative getSettingMetadata() {
        throw new NotImplementedError(null, 1, null);
    }

    public final void setCallback(@Nullable IVexFwkSessionCallback iVexFwkSessionCallback) {
        if (iVexFwkSessionCallback != null) {
            INSTANCE.setCallbackNative(this.nativeHandle, iVexFwkSessionCallback);
        }
    }

    public final void setInputBuffers(@NotNull List<? extends VexFwkBuffer> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.inputBuffersCached.addAll(value);
        Companion companion = INSTANCE;
        long j = this.nativeHandle;
        List<? extends VexFwkBuffer> list = value;
        ArrayList arrayList = new ArrayList(CollectionsKt.m13952k(list));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(((VexFwkBuffer) it.next()).getNativeHandle()));
        }
        companion.setInputBuffersNative(j, CollectionsKt.toLongArray(arrayList));
    }

    public final void setOutputBuffers(@NotNull List<? extends VexFwkBuffer> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.outputBuffersCached.addAll(value);
        Companion companion = INSTANCE;
        long j = this.nativeHandle;
        List<? extends VexFwkBuffer> list = value;
        ArrayList arrayList = new ArrayList(CollectionsKt.m13952k(list));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(((VexFwkBuffer) it.next()).getNativeHandle()));
        }
        companion.setOutputBuffersNative(j, CollectionsKt.toLongArray(arrayList));
    }

    public final void setRequestFrameNumber(int i) {
        throw new NotImplementedError(null, 1, null);
    }

    public final void setSettingMetadata(@Nullable VexFwkMetadataNative vexFwkMetadataNative) {
        if (vexFwkMetadataNative != null) {
            INSTANCE.setSettingMetadataNative(this.nativeHandle, vexFwkMetadataNative.getNativeHandle());
        }
    }

    public VexFwkSessionRequest(long j) {
        this.inputBuffersCached = new LinkedList<>();
        this.outputBuffersCached = new LinkedList<>();
        this.nativeHandle = INSTANCE.cloneNative(j);
    }
}
