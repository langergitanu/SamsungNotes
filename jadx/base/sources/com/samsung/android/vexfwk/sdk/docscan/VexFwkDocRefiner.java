package com.samsung.android.vexfwk.sdk.docscan;

import android.graphics.Bitmap;
import android.media.Image;
import android.util.Log;
import android.util.Size;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.C8416h;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.vexfwk.bitmap.VexFwkBitmapHardware;
import com.samsung.android.vexfwk.docscan.VexFwkDocRefineModes;
import com.samsung.android.vexfwk.docscan.VexFwkDocRefinerCapabilities;
import com.samsung.android.vexfwk.metadata.VexFwkMetadataKey;
import com.samsung.android.vexfwk.metadata.VexFwkMetadataNative;
import com.samsung.android.vexfwk.sdk.common.VexFwkSdkBase;
import com.samsung.android.vexfwk.sdk.common.runtime.VexFwkProvider;
import com.samsung.android.vexfwk.sdk.common.runtime.VexFwkSessionConfigRequest;
import com.samsung.android.vexfwk.sdk.common.runtime.VexFwkSessionRequest;
import com.samsung.android.vexfwk.sdk.common.runtime.VexFwkSessionRequestKt;
import com.samsung.android.vexfwk.sdk.common.runtime.VexFwkSessionTotalResult;
import com.samsung.android.vexfwk.session.VexFwkStreamType;
import com.samsung.android.vexfwk.session.VexFwkStreamUsage;
import com.samsung.android.vexfwk.session.VexFwkUsecase;
import java.util.concurrent.CompletableFuture;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0000J$\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ$\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ1\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\"\u0004\b\u0000\u0010\u000f2\u0006\u0010\u0010\u001a\u0002H\u000f2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010\u0011¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/vexfwk/sdk/docscan/VexFwkDocRefiner;", "Lcom/samsung/android/vexfwk/sdk/common/VexFwkSdkBase;", "()V", "configure", "refineDocument", "Ljava/util/concurrent/CompletableFuture;", "Landroid/graphics/Bitmap;", "bitmap", "enhance", "Lcom/samsung/android/vexfwk/docscan/VexFwkDocRefineModes$Companion$EnhancementMode;", "colorFilter", "Lcom/samsung/android/vexfwk/docscan/VexFwkDocRefineModes$Companion$ColorFilterType;", "image", "Landroid/media/Image;", "refineDocumentImpl", "T", "buffer", "(Ljava/lang/Object;Lcom/samsung/android/vexfwk/docscan/VexFwkDocRefineModes$Companion$EnhancementMode;Lcom/samsung/android/vexfwk/docscan/VexFwkDocRefineModes$Companion$ColorFilterType;)Ljava/util/concurrent/CompletableFuture;", "Companion", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nVexFwkDocRefiner.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VexFwkDocRefiner.kt\ncom/samsung/android/vexfwk/sdk/docscan/VexFwkDocRefiner\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,164:1\n1#2:165\n*E\n"})
public final class VexFwkDocRefiner extends VexFwkSdkBase {
    private static final int STREAM_ID_INPUT_IMAGE = 0;
    private static final int STREAM_ID_OUTPUT_IMAGE = 1;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "VexFwkDocRefiner";
    private static final boolean isAvailable = VexFwkSdkBase.INSTANCE.isAvailable(VexFwkUsecase.DOCUMENT_REFINEMENT);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\r\u001a\u00020\u000eH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\u0002\u001a\u0004\b\t\u0010\f¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/vexfwk/sdk/docscan/VexFwkDocRefiner$Companion;", "", "()V", "STREAM_ID_INPUT_IMAGE", "", "STREAM_ID_OUTPUT_IMAGE", SearchConstants.TargetContents.TAG, "", "kotlin.jvm.PlatformType", "isAvailable", "", "isAvailable$annotations", "()Z", "capabilities", "Lcom/samsung/android/vexfwk/docscan/VexFwkDocRefinerCapabilities;", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nVexFwkDocRefiner.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VexFwkDocRefiner.kt\ncom/samsung/android/vexfwk/sdk/docscan/VexFwkDocRefiner$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,164:1\n1#2:165\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final VexFwkDocRefinerCapabilities capabilities$lambda$1$lambda$0() {
            return new VexFwkDocRefinerCapabilities(new int[0]);
        }

        @JvmStatic
        public static /* synthetic */ void isAvailable$annotations() {
        }

        @JvmStatic
        @NotNull
        public final VexFwkDocRefinerCapabilities capabilities() {
            VexFwkDocRefinerCapabilities vexFwkDocRefinerCapabilities = (VexFwkDocRefinerCapabilities) VexFwkProvider.INSTANCE.fetchProperties(VexFwkUsecase.DOCUMENT_REFINEMENT).getOrElse(VexFwkMetadataKey.PROPERTY_DOC_REFINER_CAPABILITIES.INSTANCE, new C8416h(10));
            AbstractC2322a.m1609C("capabilities : ", CollectionsKt.m13955n(vexFwkDocRefinerCapabilities, null, null, null, null, 63), VexFwkDocRefiner.TAG);
            return vexFwkDocRefinerCapabilities;
        }

        public final boolean isAvailable() {
            return VexFwkDocRefiner.isAvailable;
        }

        private Companion() {
        }
    }

    @JvmStatic
    @NotNull
    public static final VexFwkDocRefinerCapabilities capabilities() {
        return INSTANCE.capabilities();
    }

    public static final boolean isAvailable() {
        return INSTANCE.isAvailable();
    }

    private final <T> CompletableFuture<Bitmap> refineDocumentImpl(T buffer, VexFwkDocRefineModes.Companion.EnhancementMode enhance, VexFwkDocRefineModes.Companion.ColorFilterType colorFilter) {
        CompletableFuture<Bitmap> completableFutureSupplyAsync = CompletableFuture.supplyAsync(new C11576a(enhance, colorFilter, buffer, this));
        Intrinsics.checkNotNullExpressionValue(completableFutureSupplyAsync, "supplyAsync(...)");
        return completableFutureSupplyAsync;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Bitmap refineDocumentImpl$lambda$6(final VexFwkDocRefineModes.Companion.EnhancementMode enhance, final VexFwkDocRefineModes.Companion.ColorFilterType colorFilter, Object obj, VexFwkDocRefiner this$0) throws Throwable {
        Size size;
        Intrinsics.checkNotNullParameter(enhance, "$enhance");
        Intrinsics.checkNotNullParameter(colorFilter, "$colorFilter");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String str = TAG;
        Log.i(str, "refineDocumentImpl E");
        if (enhance == VexFwkDocRefineModes.Companion.EnhancementMode.OFF && colorFilter == VexFwkDocRefineModes.Companion.ColorFilterType.COLOR_FILTER_NONE && !(obj instanceof Image) && (obj instanceof Bitmap)) {
            return (Bitmap) obj;
        }
        if (obj instanceof Image) {
            Image image = (Image) obj;
            size = new Size(image.getWidth(), image.getHeight());
        } else {
            if (!(obj instanceof Bitmap)) {
                throw new IllegalArgumentException("Unsupported image type");
            }
            Bitmap bitmap = (Bitmap) obj;
            size = new Size(bitmap.getWidth(), bitmap.getHeight());
        }
        VexFwkBitmapHardware vexFwkBitmapHardware = new VexFwkBitmapHardware(size.getWidth(), size.getHeight(), 1, null);
        Log.d(str, "refineDocumentImpl enhance: " + enhance);
        Log.d(str, "refineDocumentImpl colorfilter: " + colorFilter);
        VexFwkSessionRequest.Sync syncBuild = ((VexFwkSessionRequest.Sync.Builder) VexFwkSessionRequestKt.setSettingMetadata(VexFwkSessionRequestKt.addOutputBuffer(VexFwkSessionRequestKt.addInputBuffer(new VexFwkSessionRequest.Sync.Builder(), 0, obj), 1, vexFwkBitmapHardware.getBitmap()), new Function1<VexFwkMetadataNative, Unit>() { // from class: com.samsung.android.vexfwk.sdk.docscan.VexFwkDocRefiner$refineDocumentImpl$1$1
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
                setSettingMetadata.set(VexFwkMetadataKey.DOCUMENT_REFINE_COLOR_FILTER_TYPE.INSTANCE, Integer.valueOf(colorFilter.getValue()));
                setSettingMetadata.set(VexFwkMetadataKey.DOCUMENT_REFINE_ENHANCE.INSTANCE, Integer.valueOf(enhance.getValue()));
            }
        })).build();
        try {
            Object objM22200processRequestIoAF18A = this$0.getSession(VexFwkUsecase.DOCUMENT_REFINEMENT).m22200processRequestIoAF18A(syncBuild);
            AutoCloseableKt.closeFinally(syncBuild, null);
            Throwable thM22218exceptionOrNullimpl = Result.m22218exceptionOrNullimpl(objM22200processRequestIoAF18A);
            if (thM22218exceptionOrNullimpl != null) {
                Log.e(str, "Failed to process request : " + thM22218exceptionOrNullimpl);
                throw thM22218exceptionOrNullimpl;
            }
            Log.d(str, "refineDocumentImpl success");
            ((VexFwkSessionTotalResult) objM22200processRequestIoAF18A).close();
            try {
                Bitmap bitmapCropped = vexFwkBitmapHardware.toBitmapCropped(0, 0, vexFwkBitmapHardware.getWidth(), vexFwkBitmapHardware.getHeight(), Bitmap.Config.ARGB_8888);
                AutoCloseableKt.closeFinally(vexFwkBitmapHardware, null);
                Log.i(str, "refineDocumentImpl X");
                return bitmapCropped;
            } finally {
            }
        } finally {
        }
    }

    @NotNull
    public final VexFwkDocRefiner configure() {
        return (VexFwkDocRefiner) configureWith(this, new Function1<VexFwkDocRefiner, Unit>() { // from class: com.samsung.android.vexfwk.sdk.docscan.VexFwkDocRefiner.configure.1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(VexFwkDocRefiner vexFwkDocRefiner) {
                invoke2(vexFwkDocRefiner);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull VexFwkDocRefiner configureWith) {
                Intrinsics.checkNotNullParameter(configureWith, "$this$configureWith");
                configureWith.createSession(VexFwkUsecase.DOCUMENT_REFINEMENT, new Function1<VexFwkSessionConfigRequest.Builder, Unit>() { // from class: com.samsung.android.vexfwk.sdk.docscan.VexFwkDocRefiner.configure.1.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(VexFwkSessionConfigRequest.Builder builder) {
                        invoke2(builder);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull VexFwkSessionConfigRequest.Builder createSession) {
                        Intrinsics.checkNotNullParameter(createSession, "$this$createSession");
                        VexFwkStreamType vexFwkStreamType = VexFwkStreamType.BUFFER;
                        VexFwkStreamUsage vexFwkStreamUsage = VexFwkStreamUsage.IMAGE;
                        VexFwkSessionConfigRequest.Builder.addInputStream$default(createSession, 0, vexFwkStreamType, vexFwkStreamUsage, 0, 0, 0, null, 120, null);
                        VexFwkSessionConfigRequest.Builder.addOutputStream$default(createSession, 1, vexFwkStreamType, vexFwkStreamUsage, 0, 0, 0, null, 120, null);
                    }
                });
            }
        });
    }

    @NotNull
    public final CompletableFuture<Bitmap> refineDocument(@NotNull Image image, @NotNull VexFwkDocRefineModes.Companion.EnhancementMode enhance, @NotNull VexFwkDocRefineModes.Companion.ColorFilterType colorFilter) {
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(enhance, "enhance");
        Intrinsics.checkNotNullParameter(colorFilter, "colorFilter");
        return refineDocumentImpl(image, enhance, colorFilter);
    }

    @NotNull
    public final CompletableFuture<Bitmap> refineDocument(@NotNull Bitmap bitmap, @NotNull VexFwkDocRefineModes.Companion.EnhancementMode enhance, @NotNull VexFwkDocRefineModes.Companion.ColorFilterType colorFilter) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(enhance, "enhance");
        Intrinsics.checkNotNullParameter(colorFilter, "colorFilter");
        return refineDocumentImpl(bitmap, enhance, colorFilter);
    }
}
