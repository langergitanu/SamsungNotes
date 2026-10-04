package com.samsung.android.vexfwk.sdk.objeraser;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.Log;
import android.util.Size;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.vexfwk.bitmap.VexFwkBitmapHardware;
import com.samsung.android.vexfwk.metadata.VexFwkMetadataKey;
import com.samsung.android.vexfwk.metadata.VexFwkMetadataNative;
import com.samsung.android.vexfwk.param.VexFwkNodeResultCode;
import com.samsung.android.vexfwk.sdk.common.VexFwkSdkBase;
import com.samsung.android.vexfwk.sdk.common.runtime.VexFwkSessionConfigRequest;
import com.samsung.android.vexfwk.sdk.common.runtime.VexFwkSessionRequest;
import com.samsung.android.vexfwk.sdk.common.runtime.VexFwkSessionRequestKt;
import com.samsung.android.vexfwk.sdk.common.runtime.VexFwkSessionTotalResult;
import com.samsung.android.vexfwk.sdk.imageeffect.C11579a;
import com.samsung.android.vexfwk.session.VexFwkStreamType;
import com.samsung.android.vexfwk.session.VexFwkStreamUsage;
import com.samsung.android.vexfwk.session.VexFwkUsecase;
import com.samsung.android.visual.p167ai.sdkcommon.image.ImageConst;
import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Deprecated(message = "Dropped before release")
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0002\u000e\u000fB\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0000J.\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/vexfwk/sdk/objeraser/VexFwkVideoObjectRemover;", "Lcom/samsung/android/vexfwk/sdk/common/VexFwkSdkBase;", "()V", "configure", "removeObject", "Ljava/util/concurrent/CompletableFuture;", "Lcom/samsung/android/vexfwk/param/VexFwkNodeResultCode;", "inputPath", "", "outputPath", "inputMask", "Lcom/samsung/android/vexfwk/sdk/objeraser/VexFwkVideoObjectRemover$ObjectMask;", "mediaScan", "", "Companion", "ObjectMask", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nVexFwkVideoObjectRemover.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VexFwkVideoObjectRemover.kt\ncom/samsung/android/vexfwk/sdk/objeraser/VexFwkVideoObjectRemover\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,121:1\n1#2:122\n*E\n"})
public final class VexFwkVideoObjectRemover extends VexFwkSdkBase {
    private static final int STREAM_ID_INPUT_MASK = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "VexFwkVideoObjectRemover";
    private static final boolean isAvailable = VexFwkSdkBase.INSTANCE.isAvailable(VexFwkUsecase.VIDEO_OBJECT_REMOVAL);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u0002\u001a\u0004\b\b\u0010\u000b¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/vexfwk/sdk/objeraser/VexFwkVideoObjectRemover$Companion;", "", "()V", "STREAM_ID_INPUT_MASK", "", SearchConstants.TargetContents.TAG, "", "kotlin.jvm.PlatformType", "isAvailable", "", "isAvailable$annotations", "()Z", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void isAvailable$annotations() {
        }

        public final boolean isAvailable() {
            return VexFwkVideoObjectRemover.isAvailable;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001e\u001a\u00020\tHÆ\u0003J1\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020&HÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006'"}, m13886d2 = {"Lcom/samsung/android/vexfwk/sdk/objeraser/VexFwkVideoObjectRemover$ObjectMask;", "", ImageConst.PARAM_MODE_WALLPAPER_MASK, "", "size", "Landroid/util/Size;", "cropRect", "Landroid/graphics/Rect;", "maskFrameTimestampMs", "", "([ILandroid/util/Size;Landroid/graphics/Rect;J)V", "getCropRect", "()Landroid/graphics/Rect;", "setCropRect", "(Landroid/graphics/Rect;)V", "getMask", "()[I", "setMask", "([I)V", "getMaskFrameTimestampMs", "()J", "setMaskFrameTimestampMs", "(J)V", "getSize", "()Landroid/util/Size;", "setSize", "(Landroid/util/Size;)V", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final /* data */ class ObjectMask {

        @NotNull
        private Rect cropRect;

        @NotNull
        private int[] mask;
        private long maskFrameTimestampMs;

        @NotNull
        private Size size;

        public ObjectMask(@NotNull int[] mask, @NotNull Size size, @NotNull Rect cropRect, long j) {
            Intrinsics.checkNotNullParameter(mask, "mask");
            Intrinsics.checkNotNullParameter(size, "size");
            Intrinsics.checkNotNullParameter(cropRect, "cropRect");
            this.mask = mask;
            this.size = size;
            this.cropRect = cropRect;
            this.maskFrameTimestampMs = j;
        }

        public static /* synthetic */ ObjectMask copy$default(ObjectMask objectMask, int[] iArr, Size size, Rect rect, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                iArr = objectMask.mask;
            }
            if ((i & 2) != 0) {
                size = objectMask.size;
            }
            if ((i & 4) != 0) {
                rect = objectMask.cropRect;
            }
            if ((i & 8) != 0) {
                j = objectMask.maskFrameTimestampMs;
            }
            Rect rect2 = rect;
            return objectMask.copy(iArr, size, rect2, j);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int[] getMask() {
            return this.mask;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Size getSize() {
            return this.size;
        }

        @NotNull
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Rect getCropRect() {
            return this.cropRect;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final long getMaskFrameTimestampMs() {
            return this.maskFrameTimestampMs;
        }

        @NotNull
        public final ObjectMask copy(@NotNull int[] mask, @NotNull Size size, @NotNull Rect cropRect, long maskFrameTimestampMs) {
            Intrinsics.checkNotNullParameter(mask, "mask");
            Intrinsics.checkNotNullParameter(size, "size");
            Intrinsics.checkNotNullParameter(cropRect, "cropRect");
            return new ObjectMask(mask, size, cropRect, maskFrameTimestampMs);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ObjectMask)) {
                return false;
            }
            ObjectMask objectMask = (ObjectMask) other;
            return Intrinsics.areEqual(this.mask, objectMask.mask) && Intrinsics.areEqual(this.size, objectMask.size) && Intrinsics.areEqual(this.cropRect, objectMask.cropRect) && this.maskFrameTimestampMs == objectMask.maskFrameTimestampMs;
        }

        @NotNull
        public final Rect getCropRect() {
            return this.cropRect;
        }

        @NotNull
        public final int[] getMask() {
            return this.mask;
        }

        public final long getMaskFrameTimestampMs() {
            return this.maskFrameTimestampMs;
        }

        @NotNull
        public final Size getSize() {
            return this.size;
        }

        public int hashCode() {
            return Long.hashCode(this.maskFrameTimestampMs) + ((this.cropRect.hashCode() + ((this.size.hashCode() + (Arrays.hashCode(this.mask) * 31)) * 31)) * 31);
        }

        public final void setCropRect(@NotNull Rect rect) {
            Intrinsics.checkNotNullParameter(rect, "<set-?>");
            this.cropRect = rect;
        }

        public final void setMask(@NotNull int[] iArr) {
            Intrinsics.checkNotNullParameter(iArr, "<set-?>");
            this.mask = iArr;
        }

        public final void setMaskFrameTimestampMs(long j) {
            this.maskFrameTimestampMs = j;
        }

        public final void setSize(@NotNull Size size) {
            Intrinsics.checkNotNullParameter(size, "<set-?>");
            this.size = size;
        }

        @NotNull
        public String toString() {
            return "ObjectMask(mask=" + Arrays.toString(this.mask) + ", size=" + this.size + ", cropRect=" + this.cropRect + ", maskFrameTimestampMs=" + this.maskFrameTimestampMs + ")";
        }
    }

    public static final boolean isAvailable() {
        return INSTANCE.isAvailable();
    }

    public static /* synthetic */ CompletableFuture removeObject$default(VexFwkVideoObjectRemover vexFwkVideoObjectRemover, String str, String str2, ObjectMask objectMask, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            z = false;
        }
        return vexFwkVideoObjectRemover.removeObject(str, str2, objectMask, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VexFwkNodeResultCode removeObject$lambda$6(boolean z, final ObjectMask inputMask, final String inputPath, final String outputPath, VexFwkVideoObjectRemover this$0) throws Throwable {
        Intrinsics.checkNotNullParameter(inputMask, "$inputMask");
        Intrinsics.checkNotNullParameter(inputPath, "$inputPath");
        Intrinsics.checkNotNullParameter(outputPath, "$outputPath");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String str = TAG;
        Log.d(str, "removeObject E");
        Log.d(str, "inputMask size " + inputMask.getSize() + ", cropRect " + inputMask.getCropRect());
        VexFwkBitmapHardware vexFwkBitmapHardware = new VexFwkBitmapHardware(inputMask.getSize().getWidth(), inputMask.getSize().getHeight(), 1, inputMask.getMask());
        try {
            Bitmap bitmapCropped = vexFwkBitmapHardware.toBitmapCropped(inputMask.getCropRect().left, inputMask.getCropRect().top, inputMask.getCropRect().right, inputMask.getCropRect().bottom, Bitmap.Config.ARGB_8888);
            AutoCloseableKt.closeFinally(vexFwkBitmapHardware, null);
            VexFwkSessionRequest.Builder builderAddInputBuffer = VexFwkSessionRequestKt.addInputBuffer(new VexFwkSessionRequest.Sync.Builder(), 0, bitmapCropped);
            final int i = z ? 1 : 0;
            VexFwkSessionRequest.Sync syncBuild = ((VexFwkSessionRequest.Sync.Builder) VexFwkSessionRequestKt.setSettingMetadata(builderAddInputBuffer, new Function1<VexFwkMetadataNative, Unit>() { // from class: com.samsung.android.vexfwk.sdk.objeraser.VexFwkVideoObjectRemover$removeObject$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(VexFwkMetadataNative vexFwkMetadataNative) {
                    invoke2(vexFwkMetadataNative);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull VexFwkMetadataNative setSettingMetadata) {
                    Intrinsics.checkNotNullParameter(setSettingMetadata, "$this$setSettingMetadata");
                    setSettingMetadata.set(VexFwkMetadataKey.VIDEO_OBJECT_REMOVER_MASK_FRAME_TIMESTAMP_MS.INSTANCE, Long.valueOf(inputMask.getMaskFrameTimestampMs()));
                    setSettingMetadata.set(VexFwkMetadataKey.INPUT_PATH.INSTANCE, inputPath);
                    setSettingMetadata.set(VexFwkMetadataKey.OUTPUT_PATH.INSTANCE, outputPath);
                    setSettingMetadata.set(VexFwkMetadataKey.MEDIA_SCAN.INSTANCE, Integer.valueOf(i));
                }
            })).build();
            try {
                Object objM22200processRequestIoAF18A = this$0.getSession(VexFwkUsecase.VIDEO_OBJECT_REMOVAL).m22200processRequestIoAF18A(syncBuild);
                AutoCloseableKt.closeFinally(syncBuild, null);
                Throwable thM22218exceptionOrNullimpl = Result.m22218exceptionOrNullimpl(objM22200processRequestIoAF18A);
                if (thM22218exceptionOrNullimpl != null) {
                    Log.e(str, "Failed to process request : " + thM22218exceptionOrNullimpl);
                    throw thM22218exceptionOrNullimpl;
                }
                VexFwkSessionTotalResult vexFwkSessionTotalResult = (VexFwkSessionTotalResult) objM22200processRequestIoAF18A;
                try {
                    VexFwkNodeResultCode vexFwkNodeResultCode = (VexFwkNodeResultCode) vexFwkSessionTotalResult.getResultMetadata().get(VexFwkMetadataKey.RESULT_CODE.INSTANCE);
                    AutoCloseableKt.closeFinally(vexFwkSessionTotalResult, null);
                    bitmapCropped.recycle();
                    Log.d(str, "removeObject X");
                    return vexFwkNodeResultCode;
                } finally {
                }
            } finally {
            }
        } finally {
        }
    }

    @NotNull
    public final VexFwkVideoObjectRemover configure() {
        return (VexFwkVideoObjectRemover) configureWith(this, new Function1<VexFwkVideoObjectRemover, Unit>() { // from class: com.samsung.android.vexfwk.sdk.objeraser.VexFwkVideoObjectRemover.configure.1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(VexFwkVideoObjectRemover vexFwkVideoObjectRemover) {
                invoke2(vexFwkVideoObjectRemover);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull VexFwkVideoObjectRemover configureWith) {
                Intrinsics.checkNotNullParameter(configureWith, "$this$configureWith");
                configureWith.createSession(VexFwkUsecase.VIDEO_OBJECT_REMOVAL, new Function1<VexFwkSessionConfigRequest.Builder, Unit>() { // from class: com.samsung.android.vexfwk.sdk.objeraser.VexFwkVideoObjectRemover.configure.1.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(VexFwkSessionConfigRequest.Builder builder) {
                        invoke2(builder);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull VexFwkSessionConfigRequest.Builder createSession) {
                        Intrinsics.checkNotNullParameter(createSession, "$this$createSession");
                        VexFwkSessionConfigRequest.Builder.addInputStream$default(createSession, 0, VexFwkStreamType.BUFFER, VexFwkStreamUsage.MASK, 0, 0, 0, null, 120, null);
                    }
                });
            }
        });
    }

    @NotNull
    public final CompletableFuture<VexFwkNodeResultCode> removeObject(@NotNull String inputPath, @NotNull String outputPath, @NotNull ObjectMask inputMask, boolean mediaScan) {
        Intrinsics.checkNotNullParameter(inputPath, "inputPath");
        Intrinsics.checkNotNullParameter(outputPath, "outputPath");
        Intrinsics.checkNotNullParameter(inputMask, "inputMask");
        CompletableFuture<VexFwkNodeResultCode> completableFutureSupplyAsync = CompletableFuture.supplyAsync(new C11579a(mediaScan, inputMask, inputPath, outputPath, this, 2));
        Intrinsics.checkNotNullExpressionValue(completableFutureSupplyAsync, "supplyAsync(...)");
        return completableFutureSupplyAsync;
    }
}
