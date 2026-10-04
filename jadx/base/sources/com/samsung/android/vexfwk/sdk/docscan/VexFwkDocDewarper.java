package com.samsung.android.vexfwk.sdk.docscan;

import android.graphics.Bitmap;
import android.media.Image;
import android.util.Log;
import android.util.Size;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.C8416h;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.vexfwk.bitmap.VexFwkBitmapHardware;
import com.samsung.android.vexfwk.docscan.VexFwkDocDewarpModes;
import com.samsung.android.vexfwk.metadata.VexFwkMetadataKey;
import com.samsung.android.vexfwk.metadata.VexFwkMetadataNative;
import com.samsung.android.vexfwk.param.VexFwkDocumentCorners;
import com.samsung.android.vexfwk.param.VexFwkDocumentScanRect;
import com.samsung.android.vexfwk.sdk.common.VexFwkSdkBase;
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
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0000J&\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bJ&\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bJ1\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\"\u0004\b\u0000\u0010\u000f2\u0006\u0010\u0010\u001a\u0002H\u000f2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010\u0011¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/vexfwk/sdk/docscan/VexFwkDocDewarper;", "Lcom/samsung/android/vexfwk/sdk/common/VexFwkSdkBase;", "()V", "configure", "dewarpDocument", "Ljava/util/concurrent/CompletableFuture;", "Landroid/graphics/Bitmap;", "bitmap", "corners", "Lcom/samsung/android/vexfwk/param/VexFwkDocumentCorners;", "dewarpMode", "Lcom/samsung/android/vexfwk/docscan/VexFwkDocDewarpModes$Companion$DewarpMode;", "image", "Landroid/media/Image;", "dewarpDocumentImpl", "T", "buffer", "(Ljava/lang/Object;Lcom/samsung/android/vexfwk/param/VexFwkDocumentCorners;Lcom/samsung/android/vexfwk/docscan/VexFwkDocDewarpModes$Companion$DewarpMode;)Ljava/util/concurrent/CompletableFuture;", "Companion", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nVexFwkDocDewarper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VexFwkDocDewarper.kt\ncom/samsung/android/vexfwk/sdk/docscan/VexFwkDocDewarper\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,143:1\n1#2:144\n*E\n"})
public final class VexFwkDocDewarper extends VexFwkSdkBase {
    private static final int STREAM_ID_INPUT_IMAGE = 0;
    private static final int STREAM_ID_OUTPUT_IMAGE = 1;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "VexFwkDocDewarper";
    private static final boolean isAvailable = VexFwkSdkBase.INSTANCE.isAvailable(VexFwkUsecase.DOCUMENT_DEWARPING);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\u0002\u001a\u0004\b\t\u0010\f¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/vexfwk/sdk/docscan/VexFwkDocDewarper$Companion;", "", "()V", "STREAM_ID_INPUT_IMAGE", "", "STREAM_ID_OUTPUT_IMAGE", SearchConstants.TargetContents.TAG, "", "kotlin.jvm.PlatformType", "isAvailable", "", "isAvailable$annotations", "()Z", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void isAvailable$annotations() {
        }

        public final boolean isAvailable() {
            return VexFwkDocDewarper.isAvailable;
        }

        private Companion() {
        }
    }

    public static /* synthetic */ CompletableFuture dewarpDocument$default(VexFwkDocDewarper vexFwkDocDewarper, Image image, VexFwkDocumentCorners vexFwkDocumentCorners, VexFwkDocDewarpModes.Companion.DewarpMode dewarpMode, int i, Object obj) {
        if ((i & 4) != 0) {
            dewarpMode = VexFwkDocDewarpModes.Companion.DewarpMode.DEWARP_MODE_CV;
        }
        return vexFwkDocDewarper.dewarpDocument(image, vexFwkDocumentCorners, dewarpMode);
    }

    private final <T> CompletableFuture<Bitmap> dewarpDocumentImpl(T buffer, VexFwkDocumentCorners corners, VexFwkDocDewarpModes.Companion.DewarpMode dewarpMode) {
        CompletableFuture<Bitmap> completableFutureSupplyAsync = CompletableFuture.supplyAsync(new C11576a(buffer, corners, dewarpMode, this, 0));
        Intrinsics.checkNotNullExpressionValue(completableFutureSupplyAsync, "supplyAsync(...)");
        return completableFutureSupplyAsync;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Bitmap dewarpDocumentImpl$lambda$9(Object obj, final VexFwkDocumentCorners corners, final VexFwkDocDewarpModes.Companion.DewarpMode dewarpMode, VexFwkDocDewarper this$0) throws Throwable {
        Size size;
        Intrinsics.checkNotNullParameter(corners, "$corners");
        Intrinsics.checkNotNullParameter(dewarpMode, "$dewarpMode");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String str = TAG;
        Log.d(str, "dewarpDocumentImpl E");
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
        VexFwkSessionRequest.Sync syncBuild = ((VexFwkSessionRequest.Sync.Builder) VexFwkSessionRequestKt.setSettingMetadata(VexFwkSessionRequestKt.addOutputBuffer(VexFwkSessionRequestKt.addInputBuffer(new VexFwkSessionRequest.Sync.Builder(), 0, obj), 1, vexFwkBitmapHardware.getBitmap()), new Function1<VexFwkMetadataNative, Unit>() { // from class: com.samsung.android.vexfwk.sdk.docscan.VexFwkDocDewarper$dewarpDocumentImpl$1$1
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
                setSettingMetadata.set(VexFwkMetadataKey.DOCUMENT_RECT.INSTANCE, corners);
                setSettingMetadata.set(VexFwkMetadataKey.DOCUMENT_DEWARP_MODE.INSTANCE, Integer.valueOf(dewarpMode.getValue()));
            }
        })).build();
        try {
            Object objM22200processRequestIoAF18A = this$0.getSession(VexFwkUsecase.DOCUMENT_DEWARPING).m22200processRequestIoAF18A(syncBuild);
            AutoCloseableKt.closeFinally(syncBuild, null);
            Throwable thM22218exceptionOrNullimpl = Result.m22218exceptionOrNullimpl(objM22200processRequestIoAF18A);
            if (thM22218exceptionOrNullimpl != null) {
                Log.e(str, "Failed to process request : " + thM22218exceptionOrNullimpl);
                throw thM22218exceptionOrNullimpl;
            }
            VexFwkSessionTotalResult vexFwkSessionTotalResult = (VexFwkSessionTotalResult) objM22200processRequestIoAF18A;
            try {
                VexFwkDocumentScanRect vexFwkDocumentScanRect = (VexFwkDocumentScanRect) vexFwkSessionTotalResult.getResultMetadata().getOrElse(VexFwkMetadataKey.DOCUMENT_SCAN_RECT.INSTANCE, new C8416h(9));
                AutoCloseableKt.closeFinally(vexFwkSessionTotalResult, null);
                Log.d(str, "documentRectificationRect(" + vexFwkDocumentScanRect + ")");
                try {
                    Bitmap bitmapCropped = vexFwkBitmapHardware.toBitmapCropped(vexFwkDocumentScanRect.getLeft(), vexFwkDocumentScanRect.getTop(), vexFwkDocumentScanRect.getRight(), vexFwkDocumentScanRect.getBottom(), Bitmap.Config.ARGB_8888);
                    AutoCloseableKt.closeFinally(vexFwkBitmapHardware, null);
                    Log.d(str, "dewarpDocumentImpl X");
                    return bitmapCropped;
                } finally {
                }
            } finally {
            }
        } finally {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VexFwkDocumentScanRect dewarpDocumentImpl$lambda$9$lambda$4$lambda$3$lambda$2() throws Exception {
        throw new Exception("Request Failed due to no ROI metadata found in result metadata.");
    }

    public static final boolean isAvailable() {
        return INSTANCE.isAvailable();
    }

    @NotNull
    public final VexFwkDocDewarper configure() {
        return (VexFwkDocDewarper) configureWith(this, new Function1<VexFwkDocDewarper, Unit>() { // from class: com.samsung.android.vexfwk.sdk.docscan.VexFwkDocDewarper.configure.1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(VexFwkDocDewarper vexFwkDocDewarper) {
                invoke2(vexFwkDocDewarper);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull VexFwkDocDewarper configureWith) {
                Intrinsics.checkNotNullParameter(configureWith, "$this$configureWith");
                configureWith.createSession(VexFwkUsecase.DOCUMENT_DEWARPING, new Function1<VexFwkSessionConfigRequest.Builder, Unit>() { // from class: com.samsung.android.vexfwk.sdk.docscan.VexFwkDocDewarper.configure.1.1
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
    public final CompletableFuture<Bitmap> dewarpDocument(@NotNull Image image, @NotNull VexFwkDocumentCorners corners, @NotNull VexFwkDocDewarpModes.Companion.DewarpMode dewarpMode) {
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(corners, "corners");
        Intrinsics.checkNotNullParameter(dewarpMode, "dewarpMode");
        return dewarpDocumentImpl(image, corners, dewarpMode);
    }

    @NotNull
    public final CompletableFuture<Bitmap> dewarpDocument(@NotNull Bitmap bitmap, @NotNull VexFwkDocumentCorners corners, @NotNull VexFwkDocDewarpModes.Companion.DewarpMode dewarpMode) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(corners, "corners");
        Intrinsics.checkNotNullParameter(dewarpMode, "dewarpMode");
        return dewarpDocumentImpl(bitmap, corners, dewarpMode);
    }

    public static /* synthetic */ CompletableFuture dewarpDocument$default(VexFwkDocDewarper vexFwkDocDewarper, Bitmap bitmap, VexFwkDocumentCorners vexFwkDocumentCorners, VexFwkDocDewarpModes.Companion.DewarpMode dewarpMode, int i, Object obj) {
        if ((i & 4) != 0) {
            dewarpMode = VexFwkDocDewarpModes.Companion.DewarpMode.DEWARP_MODE_CV;
        }
        return vexFwkDocDewarper.dewarpDocument(bitmap, vexFwkDocumentCorners, dewarpMode);
    }
}
