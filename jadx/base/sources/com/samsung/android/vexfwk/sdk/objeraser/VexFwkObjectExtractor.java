package com.samsung.android.vexfwk.sdk.objeraser;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.util.Log;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.vexfwk.bitmap.VexFwkBitmapHardware;
import com.samsung.android.vexfwk.metadata.VexFwkMetadataKey;
import com.samsung.android.vexfwk.metadata.VexFwkMetadataNative;
import com.samsung.android.vexfwk.sdk.common.VexFwkSdkBase;
import com.samsung.android.vexfwk.sdk.common.runtime.VexFwkSessionConfigRequest;
import com.samsung.android.vexfwk.sdk.common.runtime.VexFwkSessionRequest;
import com.samsung.android.vexfwk.sdk.common.runtime.VexFwkSessionRequestKt;
import com.samsung.android.vexfwk.sdk.common.runtime.VexFwkSessionTotalResult;
import com.samsung.android.vexfwk.session.VexFwkStreamType;
import com.samsung.android.vexfwk.session.VexFwkStreamUsage;
import com.samsung.android.vexfwk.session.VexFwkUsecase;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;
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

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0000J$\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/vexfwk/sdk/objeraser/VexFwkObjectExtractor;", "Lcom/samsung/android/vexfwk/sdk/common/VexFwkSdkBase;", "()V", "configure", "extractObject", "Ljava/util/concurrent/CompletableFuture;", "", "bitmap", "Landroid/graphics/Bitmap;", "touchCoordinateX", "", "touchCoordinateY", "Companion", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nVexFwkObjectExtractor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VexFwkObjectExtractor.kt\ncom/samsung/android/vexfwk/sdk/objeraser/VexFwkObjectExtractor\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,85:1\n1#2:86\n*E\n"})
public final class VexFwkObjectExtractor extends VexFwkSdkBase {
    private static final int STREAM_ID_INPUT_IMAGE = 0;
    private static final int STREAM_ID_OUTPUT_MASK = 1;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "VexFwkObjectExtractor";
    private static final boolean isAvailable = VexFwkSdkBase.INSTANCE.isAvailable(VexFwkUsecase.OBJECT_EXTRACTION);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\u0002\u001a\u0004\b\t\u0010\f¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/vexfwk/sdk/objeraser/VexFwkObjectExtractor$Companion;", "", "()V", "STREAM_ID_INPUT_IMAGE", "", "STREAM_ID_OUTPUT_MASK", SearchConstants.TargetContents.TAG, "", "kotlin.jvm.PlatformType", "isAvailable", "", "isAvailable$annotations", "()Z", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void isAvailable$annotations() {
        }

        public final boolean isAvailable() {
            return VexFwkObjectExtractor.isAvailable;
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int[] extractObject$lambda$4(float f, float f4, Bitmap bitmap, VexFwkObjectExtractor this$0) {
        Intrinsics.checkNotNullParameter(bitmap, "$bitmap");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String str = TAG;
        Log.d(str, "extractObject E");
        final PointF pointF = new PointF(f, f4);
        VexFwkBitmapHardware vexFwkBitmapHardware = new VexFwkBitmapHardware(bitmap.getWidth(), bitmap.getHeight(), 1, null);
        VexFwkSessionRequest.Sync syncBuild = ((VexFwkSessionRequest.Sync.Builder) VexFwkSessionRequestKt.setSettingMetadata(VexFwkSessionRequestKt.addOutputBuffer(VexFwkSessionRequestKt.addInputBuffer(new VexFwkSessionRequest.Sync.Builder(), 0, bitmap), 1, vexFwkBitmapHardware.getBitmap()), new Function1<VexFwkMetadataNative, Unit>() { // from class: com.samsung.android.vexfwk.sdk.objeraser.VexFwkObjectExtractor$extractObject$1$1
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
                setSettingMetadata.set(VexFwkMetadataKey.AILASSO_TOUCH_COORDINATE.INSTANCE, pointF);
            }
        })).build();
        try {
            Object objM22200processRequestIoAF18A = this$0.getSession(VexFwkUsecase.OBJECT_EXTRACTION).m22200processRequestIoAF18A(syncBuild);
            AutoCloseableKt.closeFinally(syncBuild, null);
            if (Result.m22222isSuccessimpl(objM22200processRequestIoAF18A)) {
                ((VexFwkSessionTotalResult) objM22200processRequestIoAF18A).close();
                Result.m22215constructorimpl(Unit.INSTANCE);
            } else {
                Result.m22215constructorimpl(objM22200processRequestIoAF18A);
            }
            try {
                int[] intArray = vexFwkBitmapHardware.toIntArray();
                AutoCloseableKt.closeFinally(vexFwkBitmapHardware, null);
                Log.d(str, "extractObject X");
                return intArray;
            } finally {
            }
        } finally {
        }
    }

    public static final boolean isAvailable() {
        return INSTANCE.isAvailable();
    }

    @NotNull
    public final VexFwkObjectExtractor configure() {
        return (VexFwkObjectExtractor) configureWith(this, new Function1<VexFwkObjectExtractor, Unit>() { // from class: com.samsung.android.vexfwk.sdk.objeraser.VexFwkObjectExtractor.configure.1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(VexFwkObjectExtractor vexFwkObjectExtractor) {
                invoke2(vexFwkObjectExtractor);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull VexFwkObjectExtractor configureWith) {
                Intrinsics.checkNotNullParameter(configureWith, "$this$configureWith");
                configureWith.createSession(VexFwkUsecase.OBJECT_EXTRACTION, new Function1<VexFwkSessionConfigRequest.Builder, Unit>() { // from class: com.samsung.android.vexfwk.sdk.objeraser.VexFwkObjectExtractor.configure.1.1
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
    public final CompletableFuture<int[]> extractObject(@NotNull final Bitmap bitmap, final float touchCoordinateX, final float touchCoordinateY) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        CompletableFuture<int[]> completableFutureSupplyAsync = CompletableFuture.supplyAsync(new Supplier() { // from class: com.samsung.android.vexfwk.sdk.objeraser.a
            @Override // java.util.function.Supplier
            public final Object get() {
                return VexFwkObjectExtractor.extractObject$lambda$4(touchCoordinateX, touchCoordinateY, bitmap, this);
            }
        });
        Intrinsics.checkNotNullExpressionValue(completableFutureSupplyAsync, "supplyAsync(...)");
        return completableFutureSupplyAsync;
    }
}
