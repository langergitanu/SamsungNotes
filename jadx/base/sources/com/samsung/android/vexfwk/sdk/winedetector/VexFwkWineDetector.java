package com.samsung.android.vexfwk.sdk.winedetector;

import android.graphics.Bitmap;
import android.media.Image;
import android.util.Log;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.C8416h;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.vexfwk.metadata.VexFwkMetadataKey;
import com.samsung.android.vexfwk.param.VexFwkWineInfo;
import com.samsung.android.vexfwk.sdk.common.VexFwkSdkBase;
import com.samsung.android.vexfwk.sdk.common.runtime.VexFwkSessionConfigRequest;
import com.samsung.android.vexfwk.sdk.common.runtime.VexFwkSessionRequest;
import com.samsung.android.vexfwk.sdk.common.runtime.VexFwkSessionRequestKt;
import com.samsung.android.vexfwk.sdk.common.runtime.VexFwkSessionTotalResult;
import com.samsung.android.vexfwk.session.VexFwkStreamType;
import com.samsung.android.vexfwk.session.VexFwkStreamUsage;
import com.samsung.android.vexfwk.session.VexFwkUsecase;
import java.util.LinkedList;
import java.util.concurrent.CompletableFuture;
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
import p122b2.C4183f;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0000J\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bJ\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\tJ!\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\"\u0004\b\u0000\u0010\u000b2\u0006\u0010\f\u001a\u0002H\u000bH\u0002¢\u0006\u0002\u0010\r¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/vexfwk/sdk/winedetector/VexFwkWineDetector;", "Lcom/samsung/android/vexfwk/sdk/common/VexFwkSdkBase;", "()V", "configure", "detectWine", "Ljava/util/concurrent/CompletableFuture;", "Lcom/samsung/android/vexfwk/param/VexFwkWineInfo;", "image", "Landroid/graphics/Bitmap;", "Landroid/media/Image;", "detectWineImpl", "T", "buffer", "(Ljava/lang/Object;)Ljava/util/concurrent/CompletableFuture;", "Companion", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nVexFwkWineDetector.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VexFwkWineDetector.kt\ncom/samsung/android/vexfwk/sdk/winedetector/VexFwkWineDetector\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,91:1\n1#2:92\n*E\n"})
public final class VexFwkWineDetector extends VexFwkSdkBase {
    private static final int STREAM_ID_IMAGE = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "VexFwkWineDetector";
    private static final boolean isAvailable = VexFwkSdkBase.INSTANCE.isAvailable(VexFwkUsecase.WINE_DETECTION);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u0002\u001a\u0004\b\b\u0010\u000b¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/vexfwk/sdk/winedetector/VexFwkWineDetector$Companion;", "", "()V", "STREAM_ID_IMAGE", "", SearchConstants.TargetContents.TAG, "", "kotlin.jvm.PlatformType", "isAvailable", "", "isAvailable$annotations", "()Z", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void isAvailable$annotations() {
        }

        public final boolean isAvailable() {
            return VexFwkWineDetector.isAvailable;
        }

        private Companion() {
        }
    }

    private final <T> CompletableFuture<VexFwkWineInfo> detectWineImpl(T buffer) {
        CompletableFuture<VexFwkWineInfo> completableFutureSupplyAsync = CompletableFuture.supplyAsync(new C4183f(buffer, this, 6));
        Intrinsics.checkNotNullExpressionValue(completableFutureSupplyAsync, "supplyAsync(...)");
        return completableFutureSupplyAsync;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VexFwkWineInfo detectWineImpl$lambda$6(Object obj, VexFwkWineDetector this$0) throws Throwable {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String str = TAG;
        Log.d(str, "detectWineImpl E");
        VexFwkSessionRequest.Sync syncBuild = ((VexFwkSessionRequest.Sync.Builder) VexFwkSessionRequestKt.addInputBuffer(new VexFwkSessionRequest.Sync.Builder(), 0, obj)).build();
        try {
            Object objM22200processRequestIoAF18A = this$0.getSession(VexFwkUsecase.WINE_DETECTION).m22200processRequestIoAF18A(syncBuild);
            AutoCloseableKt.closeFinally(syncBuild, null);
            Throwable thM22218exceptionOrNullimpl = Result.m22218exceptionOrNullimpl(objM22200processRequestIoAF18A);
            if (thM22218exceptionOrNullimpl != null) {
                Log.e(str, "Failed to process request : " + thM22218exceptionOrNullimpl);
                throw thM22218exceptionOrNullimpl;
            }
            VexFwkSessionTotalResult vexFwkSessionTotalResult = (VexFwkSessionTotalResult) objM22200processRequestIoAF18A;
            try {
                VexFwkWineInfo vexFwkWineInfo = (VexFwkWineInfo) vexFwkSessionTotalResult.getResultMetadata().getOrElse(VexFwkMetadataKey.WINE_INFO.INSTANCE, new C8416h(14));
                AutoCloseableKt.closeFinally(vexFwkSessionTotalResult, null);
                Log.d(str, "detectWineImpl X");
                return vexFwkWineInfo;
            } finally {
            }
        } finally {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VexFwkWineInfo detectWineImpl$lambda$6$lambda$3$lambda$2$lambda$1() {
        return new VexFwkWineInfo(new LinkedList());
    }

    public static final boolean isAvailable() {
        return INSTANCE.isAvailable();
    }

    @NotNull
    public final VexFwkWineDetector configure() {
        return (VexFwkWineDetector) configureWith(this, new Function1<VexFwkWineDetector, Unit>() { // from class: com.samsung.android.vexfwk.sdk.winedetector.VexFwkWineDetector.configure.1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(VexFwkWineDetector vexFwkWineDetector) {
                invoke2(vexFwkWineDetector);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull VexFwkWineDetector configureWith) {
                Intrinsics.checkNotNullParameter(configureWith, "$this$configureWith");
                configureWith.createSession(VexFwkUsecase.WINE_DETECTION, new Function1<VexFwkSessionConfigRequest.Builder, Unit>() { // from class: com.samsung.android.vexfwk.sdk.winedetector.VexFwkWineDetector.configure.1.1
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
    public final CompletableFuture<VexFwkWineInfo> detectWine(@NotNull Bitmap image) {
        Intrinsics.checkNotNullParameter(image, "image");
        return detectWineImpl(image);
    }

    @NotNull
    public final CompletableFuture<VexFwkWineInfo> detectWine(@NotNull Image image) {
        Intrinsics.checkNotNullParameter(image, "image");
        return detectWineImpl(image);
    }
}
