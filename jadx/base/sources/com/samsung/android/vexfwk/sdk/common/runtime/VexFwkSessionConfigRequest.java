package com.samsung.android.vexfwk.sdk.common.runtime;

import android.view.Surface;
import com.samsung.android.vexfwk.VexFwkJniLoader;
import com.samsung.android.vexfwk.metadata.VexFwkMetadataNative;
import com.samsung.android.vexfwk.session.VexFwkStreamInoutDirection;
import com.samsung.android.vexfwk.session.VexFwkStreamType;
import com.samsung.android.vexfwk.session.VexFwkStreamUsage;
import com.samsung.android.vexfwk.session.VexFwkUsecase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001e\u001fB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0016R(\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00048B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR0\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u00168F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006 "}, m13886d2 = {"Lcom/samsung/android/vexfwk/sdk/common/runtime/VexFwkSessionConfigRequest;", "Ljava/lang/AutoCloseable;", "()V", "value", "Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataNative;", "configMetadata", "getConfigMetadata", "()Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataNative;", "setConfigMetadata", "(Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataNative;)V", "nativeHandle", "", "getNativeHandle", "()J", "", "Lcom/samsung/android/vexfwk/sdk/common/runtime/VexFwkStream;", "streams", "getStreams", "()Ljava/util/List;", "setStreams", "(Ljava/util/List;)V", "streamsCached", "", "usecasdId", "getUsecasdId", "()I", "setUsecasdId", "(I)V", "close", "", "Builder", "Companion", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nVexFwkSessionConfigRequest.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VexFwkSessionConfigRequest.kt\ncom/samsung/android/vexfwk/sdk/common/runtime/VexFwkSessionConfigRequest\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,134:1\n1#2:135\n1549#3:136\n1620#3,3:137\n1855#3,2:140\n*S KotlinDebug\n*F\n+ 1 VexFwkSessionConfigRequest.kt\ncom/samsung/android/vexfwk/sdk/common/runtime/VexFwkSessionConfigRequest\n*L\n126#1:136\n126#1:137,3\n131#1:140,2\n*E\n"})
public final class VexFwkSessionConfigRequest implements AutoCloseable {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final long nativeHandle = INSTANCE.createNative();

    @Nullable
    private List<VexFwkStream> streamsCached;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004JH\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\f2\b\b\u0002\u0010\u0012\u001a\u00020\f2\b\b\u0002\u0010\u0013\u001a\u00020\f2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015JH\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\f2\b\b\u0002\u0010\u0012\u001a\u00020\f2\b\b\u0002\u0010\u0013\u001a\u00020\f2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015JJ\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002J\u0006\u0010\u001a\u001a\u00020\u001bJ\u001f\u0010\u001c\u001a\u00020\u001d2\u0017\u0010\u001e\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001d0\u001f¢\u0006\u0002\b R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, m13886d2 = {"Lcom/samsung/android/vexfwk/sdk/common/runtime/VexFwkSessionConfigRequest$Builder;", "", "usecase", "Lcom/samsung/android/vexfwk/session/VexFwkUsecase;", "(Lcom/samsung/android/vexfwk/session/VexFwkUsecase;)V", "configMetadata", "Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataNative;", "streams", "", "Lcom/samsung/android/vexfwk/sdk/common/runtime/VexFwkStream;", "addInputStream", "id", "", "streamType", "Lcom/samsung/android/vexfwk/session/VexFwkStreamType;", "usage", "Lcom/samsung/android/vexfwk/session/VexFwkStreamUsage;", "width", "height", "format", "surface", "Landroid/view/Surface;", "addOutputStream", "addStream", "inoutDirection", "Lcom/samsung/android/vexfwk/session/VexFwkStreamInoutDirection;", "build", "Lcom/samsung/android/vexfwk/sdk/common/runtime/VexFwkSessionConfigRequest;", "setConfigMetadata", "", "action", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class Builder {

        @Nullable
        private VexFwkMetadataNative configMetadata;

        @NotNull
        private List<VexFwkStream> streams;

        @NotNull
        private final VexFwkUsecase usecase;

        public Builder(@NotNull VexFwkUsecase usecase) {
            Intrinsics.checkNotNullParameter(usecase, "usecase");
            this.usecase = usecase;
            this.streams = new ArrayList();
        }

        public static /* synthetic */ Builder addInputStream$default(Builder builder, int i, VexFwkStreamType vexFwkStreamType, VexFwkStreamUsage vexFwkStreamUsage, int i2, int i4, int i5, Surface surface, int i6, Object obj) {
            if ((i6 & 8) != 0) {
                i2 = -1;
            }
            if ((i6 & 16) != 0) {
                i4 = -1;
            }
            if ((i6 & 32) != 0) {
                i5 = -1;
            }
            if ((i6 & 64) != 0) {
                surface = null;
            }
            return builder.addInputStream(i, vexFwkStreamType, vexFwkStreamUsage, i2, i4, i5, surface);
        }

        public static /* synthetic */ Builder addOutputStream$default(Builder builder, int i, VexFwkStreamType vexFwkStreamType, VexFwkStreamUsage vexFwkStreamUsage, int i2, int i4, int i5, Surface surface, int i6, Object obj) {
            if ((i6 & 8) != 0) {
                i2 = -1;
            }
            if ((i6 & 16) != 0) {
                i4 = -1;
            }
            if ((i6 & 32) != 0) {
                i5 = -1;
            }
            if ((i6 & 64) != 0) {
                surface = null;
            }
            return builder.addOutputStream(i, vexFwkStreamType, vexFwkStreamUsage, i2, i4, i5, surface);
        }

        private final Builder addStream(int id, VexFwkStreamInoutDirection inoutDirection, VexFwkStreamType streamType, VexFwkStreamUsage usage, int width, int height, int format, Surface surface) {
            List<VexFwkStream> list = this.streams;
            VexFwkStream vexFwkStream = new VexFwkStream();
            vexFwkStream.setId(id);
            vexFwkStream.setInoutDirection(inoutDirection);
            vexFwkStream.setStreamType(streamType);
            vexFwkStream.setUsage(usage);
            vexFwkStream.setWidth(width);
            vexFwkStream.setHeight(height);
            vexFwkStream.setFormat(format);
            vexFwkStream.setSurface(surface);
            list.add(vexFwkStream);
            return this;
        }

        @NotNull
        public final Builder addInputStream(int id, @NotNull VexFwkStreamType streamType, @NotNull VexFwkStreamUsage usage, int width, int height, int format, @Nullable Surface surface) {
            Intrinsics.checkNotNullParameter(streamType, "streamType");
            Intrinsics.checkNotNullParameter(usage, "usage");
            return addStream(id, VexFwkStreamInoutDirection.f8118IN, streamType, usage, width, height, format, surface);
        }

        @NotNull
        public final Builder addOutputStream(int id, @NotNull VexFwkStreamType streamType, @NotNull VexFwkStreamUsage usage, int width, int height, int format, @Nullable Surface surface) {
            Intrinsics.checkNotNullParameter(streamType, "streamType");
            Intrinsics.checkNotNullParameter(usage, "usage");
            return addStream(id, VexFwkStreamInoutDirection.OUT, streamType, usage, width, height, format, surface);
        }

        @NotNull
        public final VexFwkSessionConfigRequest build() {
            VexFwkSessionConfigRequest vexFwkSessionConfigRequest = new VexFwkSessionConfigRequest();
            vexFwkSessionConfigRequest.setUsecasdId(this.usecase.getId());
            vexFwkSessionConfigRequest.setConfigMetadata(this.configMetadata);
            vexFwkSessionConfigRequest.setStreams(this.streams);
            return vexFwkSessionConfigRequest;
        }

        public final void setConfigMetadata(@NotNull Function1<? super VexFwkMetadataNative, Unit> action) {
            Intrinsics.checkNotNullParameter(action, "action");
            VexFwkMetadataNative vexFwkMetadataNative = new VexFwkMetadataNative();
            action.invoke(vexFwkMetadataNative);
            this.configMetadata = vexFwkMetadataNative;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004H\u0083 J\u0011\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0083 J\u0019\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0083 J\u0019\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0083 J\u0019\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0083 ¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/vexfwk/sdk/common/runtime/VexFwkSessionConfigRequest$Companion;", "", "()V", "createNative", "", "deleteNative", "", "configRequestHandle", "setConfigMetadataNative", "configMetadataHandle", "setStreamsNative", "streamHandleArray", "", "setUsecaseIdNative", "usecasdId", "", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long createNative() {
            return VexFwkSessionConfigRequest.createNative();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void deleteNative(long configRequestHandle) {
            VexFwkSessionConfigRequest.deleteNative(configRequestHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void setConfigMetadataNative(long configRequestHandle, long configMetadataHandle) {
            VexFwkSessionConfigRequest.setConfigMetadataNative(configRequestHandle, configMetadataHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void setStreamsNative(long configRequestHandle, long[] streamHandleArray) {
            VexFwkSessionConfigRequest.setStreamsNative(configRequestHandle, streamHandleArray);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void setUsecaseIdNative(long configRequestHandle, int usecasdId) {
            VexFwkSessionConfigRequest.setUsecaseIdNative(configRequestHandle, usecasdId);
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

    /* JADX WARN: Multi-variable type inference failed */
    private final VexFwkMetadataNative getConfigMetadata() {
        throw new NotImplementedError(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setConfigMetadata(VexFwkMetadataNative vexFwkMetadataNative) {
        if (vexFwkMetadataNative != null) {
            INSTANCE.setConfigMetadataNative(this.nativeHandle, vexFwkMetadataNative.getNativeHandle());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void setConfigMetadataNative(long j, long j2);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void setStreamsNative(long j, long[] jArr);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void setUsecaseIdNative(long j, int i);

    @Override // java.lang.AutoCloseable
    public void close() {
        INSTANCE.deleteNative(this.nativeHandle);
        List<VexFwkStream> list = this.streamsCached;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                ((VexFwkStream) it.next()).close();
            }
        }
    }

    public final long getNativeHandle() {
        return this.nativeHandle;
    }

    @NotNull
    public final List<VexFwkStream> getStreams() {
        List<VexFwkStream> list = this.streamsCached;
        return list == null ? CollectionsKt.emptyList() : list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int getUsecasdId() {
        throw new NotImplementedError(null, 1, 0 == true ? 1 : 0);
    }

    public final void setStreams(@NotNull List<VexFwkStream> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.streamsCached = value;
        Companion companion = INSTANCE;
        long j = this.nativeHandle;
        List<VexFwkStream> list = value;
        ArrayList arrayList = new ArrayList(CollectionsKt.m13952k(list));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(((VexFwkStream) it.next()).getNativeHandle()));
        }
        companion.setStreamsNative(j, CollectionsKt.toLongArray(arrayList));
    }

    public final void setUsecasdId(int i) {
        INSTANCE.setUsecaseIdNative(this.nativeHandle, i);
    }
}
