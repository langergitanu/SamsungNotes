package com.samsung.android.vexfwk.sdk.imagetagger;

import android.graphics.Bitmap;
import android.util.Log;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.C8416h;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.vexfwk.metadata.VexFwkMetadataKey;
import com.samsung.android.vexfwk.metadata.VexFwkMetadataNative;
import com.samsung.android.vexfwk.param.VexFwkImageTaggerResult;
import com.samsung.android.vexfwk.param.VexFwkNodeResultCode;
import com.samsung.android.vexfwk.sdk.common.VexFwkSdkBase;
import com.samsung.android.vexfwk.sdk.common.runtime.VexFwkSessionConfigRequest;
import com.samsung.android.vexfwk.sdk.common.runtime.VexFwkSessionRequest;
import com.samsung.android.vexfwk.sdk.common.runtime.VexFwkSessionRequestKt;
import com.samsung.android.vexfwk.sdk.common.runtime.VexFwkSessionTotalResult;
import com.samsung.android.vexfwk.session.VexFwkStreamType;
import com.samsung.android.vexfwk.session.VexFwkStreamUsage;
import com.samsung.android.vexfwk.session.VexFwkUsecase;
import java.util.ArrayList;
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
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0000J\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bJ+\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\"\u0004\b\u0000\u0010\n2\u0006\u0010\u000b\u001a\u0002H\n2\b\b\u0002\u0010\f\u001a\u00020\rH\u0002¢\u0006\u0002\u0010\u000e¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/vexfwk/sdk/imagetagger/VexFwkImageTagger;", "Lcom/samsung/android/vexfwk/sdk/common/VexFwkSdkBase;", "()V", "configure", "detectImageTags", "Ljava/util/concurrent/CompletableFuture;", "Lcom/samsung/android/vexfwk/param/VexFwkImageTaggerResult;", "image", "Landroid/graphics/Bitmap;", "detectImageTagsImpl", "T", "buffer", "angularRotation", "", "(Ljava/lang/Object;I)Ljava/util/concurrent/CompletableFuture;", "Companion", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nVexFwkImageTagger.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VexFwkImageTagger.kt\ncom/samsung/android/vexfwk/sdk/imagetagger/VexFwkImageTagger\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,76:1\n1#2:77\n*E\n"})
public final class VexFwkImageTagger extends VexFwkSdkBase {
    private static final int STREAM_ID_IMAGE = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "VexFwkImageTagger";
    private static final boolean isAvailable = VexFwkSdkBase.INSTANCE.isAvailable(VexFwkUsecase.IMAGE_TAGGER);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u0002\u001a\u0004\b\b\u0010\u000b¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/vexfwk/sdk/imagetagger/VexFwkImageTagger$Companion;", "", "()V", "STREAM_ID_IMAGE", "", SearchConstants.TargetContents.TAG, "", "kotlin.jvm.PlatformType", "isAvailable", "", "isAvailable$annotations", "()Z", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void isAvailable$annotations() {
        }

        public final boolean isAvailable() {
            return VexFwkImageTagger.isAvailable;
        }

        private Companion() {
        }
    }

    private final <T> CompletableFuture<VexFwkImageTaggerResult> detectImageTagsImpl(final T buffer, final int angularRotation) {
        CompletableFuture<VexFwkImageTaggerResult> completableFutureSupplyAsync = CompletableFuture.supplyAsync(new Supplier() { // from class: com.samsung.android.vexfwk.sdk.imagetagger.a
            @Override // java.util.function.Supplier
            public final Object get() {
                return VexFwkImageTagger.detectImageTagsImpl$lambda$7(buffer, angularRotation, this);
            }
        });
        Intrinsics.checkNotNullExpressionValue(completableFutureSupplyAsync, "supplyAsync(...)");
        return completableFutureSupplyAsync;
    }

    public static /* synthetic */ CompletableFuture detectImageTagsImpl$default(VexFwkImageTagger vexFwkImageTagger, Object obj, int i, int i2, Object obj2) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return vexFwkImageTagger.detectImageTagsImpl(obj, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VexFwkImageTaggerResult detectImageTagsImpl$lambda$7(Object obj, final int i, VexFwkImageTagger this$0) throws Throwable {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String str = TAG;
        Log.d(str, "detectImageTagsImpl E");
        VexFwkSessionRequest.Sync syncBuild = ((VexFwkSessionRequest.Sync.Builder) VexFwkSessionRequestKt.setSettingMetadata(VexFwkSessionRequestKt.addInputBuffer(new VexFwkSessionRequest.Sync.Builder(), 0, obj), new Function1<VexFwkMetadataNative, Unit>() { // from class: com.samsung.android.vexfwk.sdk.imagetagger.VexFwkImageTagger$detectImageTagsImpl$1$1
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
                setSettingMetadata.set(VexFwkMetadataKey.ROTATION_DEGREE.INSTANCE, Integer.valueOf(i));
            }
        })).build();
        try {
            Object objM22200processRequestIoAF18A = this$0.getSession(VexFwkUsecase.IMAGE_TAGGER).m22200processRequestIoAF18A(syncBuild);
            AutoCloseableKt.closeFinally(syncBuild, null);
            Throwable thM22218exceptionOrNullimpl = Result.m22218exceptionOrNullimpl(objM22200processRequestIoAF18A);
            if (thM22218exceptionOrNullimpl != null) {
                Log.e(str, "Failed to process request : " + thM22218exceptionOrNullimpl);
                throw thM22218exceptionOrNullimpl;
            }
            VexFwkSessionTotalResult vexFwkSessionTotalResult = (VexFwkSessionTotalResult) objM22200processRequestIoAF18A;
            try {
                if (((VexFwkNodeResultCode) vexFwkSessionTotalResult.getResultMetadata().get(VexFwkMetadataKey.RESULT_CODE.INSTANCE)) != VexFwkNodeResultCode.f8084OK) {
                    throw new IllegalStateException("Failed to get Image Tagger result");
                }
                VexFwkImageTaggerResult vexFwkImageTaggerResult = (VexFwkImageTaggerResult) vexFwkSessionTotalResult.getResultMetadata().getOrElse(VexFwkMetadataKey.IMAGE_TAGGER_RESULT.INSTANCE, new C8416h(12));
                AutoCloseableKt.closeFinally(vexFwkSessionTotalResult, null);
                Log.d(str, "detectImageTagsImpl X");
                return vexFwkImageTaggerResult;
            } finally {
            }
        } finally {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VexFwkImageTaggerResult detectImageTagsImpl$lambda$7$lambda$4$lambda$3$lambda$2$lambda$1() {
        return new VexFwkImageTaggerResult(new ArrayList());
    }

    public static final boolean isAvailable() {
        return INSTANCE.isAvailable();
    }

    @NotNull
    public final VexFwkImageTagger configure() {
        return (VexFwkImageTagger) configureWith(this, new Function1<VexFwkImageTagger, Unit>() { // from class: com.samsung.android.vexfwk.sdk.imagetagger.VexFwkImageTagger.configure.1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(VexFwkImageTagger vexFwkImageTagger) {
                invoke2(vexFwkImageTagger);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull VexFwkImageTagger configureWith) {
                Intrinsics.checkNotNullParameter(configureWith, "$this$configureWith");
                configureWith.createSession(VexFwkUsecase.IMAGE_TAGGER, new Function1<VexFwkSessionConfigRequest.Builder, Unit>() { // from class: com.samsung.android.vexfwk.sdk.imagetagger.VexFwkImageTagger.configure.1.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(VexFwkSessionConfigRequest.Builder builder) {
                        invoke2(builder);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull VexFwkSessionConfigRequest.Builder createSession) {
                        Intrinsics.checkNotNullParameter(createSession, "$this$createSession");
                        VexFwkSessionConfigRequest.Builder.addInputStream$default(createSession, 0, VexFwkStreamType.BUFFER, VexFwkStreamUsage.IMAGE, 0, 0, 0, null, 120, null);
                    }
                });
            }
        });
    }

    @NotNull
    public final CompletableFuture<VexFwkImageTaggerResult> detectImageTags(@NotNull Bitmap image) {
        Intrinsics.checkNotNullParameter(image, "image");
        return detectImageTagsImpl$default(this, image, 0, 2, null);
    }
}
