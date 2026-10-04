package com.samsung.android.vexfwk.sdk.objeraser;

import android.graphics.Bitmap;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.vexfwk.bitmap.VexFwkBitmapHardware;
import com.samsung.android.vexfwk.log.VexFwkLog;
import com.samsung.android.vexfwk.metadata.VexFwkMetadataKey;
import com.samsung.android.vexfwk.sdk.common.VexFwkSdkBase;
import com.samsung.android.vexfwk.sdk.common.runtime.VexFwkSessionConfigRequest;
import com.samsung.android.vexfwk.sdk.common.runtime.VexFwkSessionRequest;
import com.samsung.android.vexfwk.sdk.common.runtime.VexFwkSessionRequestKt;
import com.samsung.android.vexfwk.sdk.common.runtime.VexFwkSessionTotalResult;
import com.samsung.android.vexfwk.session.VexFwkStreamType;
import com.samsung.android.vexfwk.session.VexFwkStreamUsage;
import com.samsung.android.vexfwk.session.VexFwkUsecase;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p122b2.C4183f;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \t2\u00020\u0001:\u0002\t\nB\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0000J\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/vexfwk/sdk/objeraser/VexFwkObjSegmentor;", "Lcom/samsung/android/vexfwk/sdk/common/VexFwkSdkBase;", "()V", "configure", "segmentObject", "Ljava/util/concurrent/CompletableFuture;", "Lcom/samsung/android/vexfwk/sdk/objeraser/VexFwkObjSegmentor$InstanceSegmentResult;", "bitmap", "Landroid/graphics/Bitmap;", "Companion", "InstanceSegmentResult", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nVexFwkObjSegmentor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VexFwkObjSegmentor.kt\ncom/samsung/android/vexfwk/sdk/objeraser/VexFwkObjSegmentor\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,85:1\n1#2:86\n*E\n"})
public final class VexFwkObjSegmentor extends VexFwkSdkBase {
    private static final int STREAM_ID_INPUT_IMAGE = 0;
    private static final int STREAM_ID_OUTPUT_MASK = 1;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "VexFwkObjSegmentor";
    private static final boolean isAvailable = VexFwkSdkBase.INSTANCE.isAvailable(VexFwkUsecase.OBJECT_SEGMENTATION);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\u0002\u001a\u0004\b\t\u0010\f¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/vexfwk/sdk/objeraser/VexFwkObjSegmentor$Companion;", "", "()V", "STREAM_ID_INPUT_IMAGE", "", "STREAM_ID_OUTPUT_MASK", SearchConstants.TargetContents.TAG, "", "kotlin.jvm.PlatformType", "isAvailable", "", "isAvailable$annotations", "()Z", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void isAvailable$annotations() {
        }

        public final boolean isAvailable() {
            return VexFwkObjSegmentor.isAvailable;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005¢\u0006\u0002\u0010\bJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005HÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0007HÖ\u0001R(\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0019"}, m13886d2 = {"Lcom/samsung/android/vexfwk/sdk/objeraser/VexFwkObjSegmentor$InstanceSegmentResult;", "", "segmentationMask", "", "categoryData", "", "", "", "([ILjava/util/Map;)V", "getCategoryData", "()Ljava/util/Map;", "setCategoryData", "(Ljava/util/Map;)V", "getSegmentationMask", "()[I", "setSegmentationMask", "([I)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final /* data */ class InstanceSegmentResult {

        @Nullable
        private Map<Integer, String> categoryData;

        @Nullable
        private int[] segmentationMask;

        /* JADX WARN: Multi-variable type inference failed */
        public InstanceSegmentResult() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ InstanceSegmentResult copy$default(InstanceSegmentResult instanceSegmentResult, int[] iArr, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                iArr = instanceSegmentResult.segmentationMask;
            }
            if ((i & 2) != 0) {
                map = instanceSegmentResult.categoryData;
            }
            return instanceSegmentResult.copy(iArr, map);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int[] getSegmentationMask() {
            return this.segmentationMask;
        }

        @Nullable
        public final Map<Integer, String> component2() {
            return this.categoryData;
        }

        @NotNull
        public final InstanceSegmentResult copy(@Nullable int[] segmentationMask, @Nullable Map<Integer, String> categoryData) {
            return new InstanceSegmentResult(segmentationMask, categoryData);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InstanceSegmentResult)) {
                return false;
            }
            InstanceSegmentResult instanceSegmentResult = (InstanceSegmentResult) other;
            return Intrinsics.areEqual(this.segmentationMask, instanceSegmentResult.segmentationMask) && Intrinsics.areEqual(this.categoryData, instanceSegmentResult.categoryData);
        }

        @Nullable
        public final Map<Integer, String> getCategoryData() {
            return this.categoryData;
        }

        @Nullable
        public final int[] getSegmentationMask() {
            return this.segmentationMask;
        }

        public int hashCode() {
            int[] iArr = this.segmentationMask;
            int iHashCode = (iArr == null ? 0 : Arrays.hashCode(iArr)) * 31;
            Map<Integer, String> map = this.categoryData;
            return iHashCode + (map != null ? map.hashCode() : 0);
        }

        public final void setCategoryData(@Nullable Map<Integer, String> map) {
            this.categoryData = map;
        }

        public final void setSegmentationMask(@Nullable int[] iArr) {
            this.segmentationMask = iArr;
        }

        @NotNull
        public String toString() {
            return "InstanceSegmentResult(segmentationMask=" + Arrays.toString(this.segmentationMask) + ", categoryData=" + this.categoryData + ")";
        }

        public InstanceSegmentResult(@Nullable int[] iArr, @Nullable Map<Integer, String> map) {
            this.segmentationMask = iArr;
            this.categoryData = map;
        }

        public /* synthetic */ InstanceSegmentResult(int[] iArr, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : iArr, (i & 2) != 0 ? null : map);
        }
    }

    public static final boolean isAvailable() {
        return INSTANCE.isAvailable();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InstanceSegmentResult segmentObject$lambda$4(Bitmap bitmap, VexFwkObjSegmentor this$0) throws Throwable {
        Intrinsics.checkNotNullParameter(bitmap, "$bitmap");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        VexFwkLog.Companion companion = VexFwkLog.INSTANCE;
        String TAG2 = TAG;
        companion.m12816d(TAG2, "segmentObject E");
        VexFwkBitmapHardware vexFwkBitmapHardware = new VexFwkBitmapHardware(bitmap.getWidth(), bitmap.getHeight(), 1, null);
        MapsKt.emptyMap();
        VexFwkSessionRequest.Sync syncBuild = ((VexFwkSessionRequest.Sync.Builder) VexFwkSessionRequestKt.addOutputBuffer(VexFwkSessionRequestKt.addInputBuffer(new VexFwkSessionRequest.Sync.Builder(), 0, bitmap), 1, vexFwkBitmapHardware.getBitmap())).build();
        try {
            Object objM22200processRequestIoAF18A = this$0.getSession(VexFwkUsecase.OBJECT_SEGMENTATION).m22200processRequestIoAF18A(syncBuild);
            AutoCloseableKt.closeFinally(syncBuild, null);
            Throwable thM22218exceptionOrNullimpl = Result.m22218exceptionOrNullimpl(objM22200processRequestIoAF18A);
            if (thM22218exceptionOrNullimpl != null) {
                vexFwkBitmapHardware.close();
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                companion.m12817e(TAG2, "Failed to process request : " + thM22218exceptionOrNullimpl);
                throw thM22218exceptionOrNullimpl;
            }
            VexFwkSessionTotalResult vexFwkSessionTotalResult = (VexFwkSessionTotalResult) objM22200processRequestIoAF18A;
            Object obj = vexFwkSessionTotalResult.getResultMetadata().get(VexFwkMetadataKey.SEGMENT_CATEGORY_MAP.INSTANCE);
            Intrinsics.checkNotNull(obj);
            vexFwkSessionTotalResult.close();
            companion.m12816d(TAG2, "segmentObject X");
            try {
                int[] intArray = vexFwkBitmapHardware.toIntArray();
                AutoCloseableKt.closeFinally(vexFwkBitmapHardware, null);
                vexFwkBitmapHardware.close();
                return new InstanceSegmentResult(intArray, (Map) obj);
            } finally {
            }
        } finally {
        }
    }

    @NotNull
    public final VexFwkObjSegmentor configure() {
        return (VexFwkObjSegmentor) configureWith(this, new Function1<VexFwkObjSegmentor, Unit>() { // from class: com.samsung.android.vexfwk.sdk.objeraser.VexFwkObjSegmentor.configure.1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(VexFwkObjSegmentor vexFwkObjSegmentor) {
                invoke2(vexFwkObjSegmentor);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull VexFwkObjSegmentor configureWith) {
                Intrinsics.checkNotNullParameter(configureWith, "$this$configureWith");
                configureWith.createSession(VexFwkUsecase.OBJECT_SEGMENTATION, new Function1<VexFwkSessionConfigRequest.Builder, Unit>() { // from class: com.samsung.android.vexfwk.sdk.objeraser.VexFwkObjSegmentor.configure.1.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(VexFwkSessionConfigRequest.Builder builder) {
                        invoke2(builder);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull VexFwkSessionConfigRequest.Builder createSession) {
                        Intrinsics.checkNotNullParameter(createSession, "$this$createSession");
                        VexFwkStreamType vexFwkStreamType = VexFwkStreamType.BUFFER;
                        VexFwkSessionConfigRequest.Builder.addInputStream$default(createSession, 0, vexFwkStreamType, VexFwkStreamUsage.IMAGE, 0, 0, 0, null, 120, null);
                        VexFwkSessionConfigRequest.Builder.addOutputStream$default(createSession, 1, vexFwkStreamType, VexFwkStreamUsage.MASK, 0, 0, 0, null, 120, null);
                    }
                });
            }
        });
    }

    @NotNull
    public final CompletableFuture<InstanceSegmentResult> segmentObject(@NotNull Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        CompletableFuture<InstanceSegmentResult> completableFutureSupplyAsync = CompletableFuture.supplyAsync(new C4183f(bitmap, this, 5));
        Intrinsics.checkNotNullExpressionValue(completableFutureSupplyAsync, "supplyAsync(...)");
        return completableFutureSupplyAsync;
    }
}
