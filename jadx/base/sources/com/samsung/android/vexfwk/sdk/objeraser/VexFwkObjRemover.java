package com.samsung.android.vexfwk.sdk.objeraser;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.Log;
import androidx.collection.AbstractC0622a;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.vexfwk.bitmap.VexFwkBitmapHardware;
import com.samsung.android.vexfwk.metadata.VexFwkMetadataKey;
import com.samsung.android.vexfwk.param.VexFwkNodeResultCode;
import com.samsung.android.vexfwk.sdk.common.VexFwkSdkBase;
import com.samsung.android.vexfwk.sdk.common.runtime.VexFwkSessionConfigRequest;
import com.samsung.android.vexfwk.sdk.common.runtime.VexFwkSessionRequest;
import com.samsung.android.vexfwk.sdk.common.runtime.VexFwkSessionRequestKt;
import com.samsung.android.vexfwk.sdk.common.runtime.VexFwkSessionTotalResult;
import com.samsung.android.vexfwk.sdk.docscan.C11576a;
import com.samsung.android.vexfwk.session.VexFwkStreamType;
import com.samsung.android.vexfwk.session.VexFwkStreamUsage;
import com.samsung.android.vexfwk.session.VexFwkUsecase;
import com.samsung.android.visual.p167ai.sdkcommon.image.ImageConst;
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
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0000J$\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/vexfwk/sdk/objeraser/VexFwkObjRemover;", "Lcom/samsung/android/vexfwk/sdk/common/VexFwkSdkBase;", "()V", "configure", "removeObject", "Ljava/util/concurrent/CompletableFuture;", "Landroid/graphics/Bitmap;", "bitmap", ImageConst.PARAM_MODE_WALLPAPER_MASK, "", "roi", "Landroid/graphics/Rect;", "Companion", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nVexFwkObjRemover.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VexFwkObjRemover.kt\ncom/samsung/android/vexfwk/sdk/objeraser/VexFwkObjRemover\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,104:1\n1#2:105\n*E\n"})
public final class VexFwkObjRemover extends VexFwkSdkBase {
    private static final int STREAM_ID_INPUT_IMAGE = 0;
    private static final int STREAM_ID_INPUT_MASK = 1;
    private static final int STREAM_ID_OUTPUT_IMAGE = 2;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "VexFwkObjRemover";
    private static final boolean isAvailable = VexFwkSdkBase.INSTANCE.isAvailable(VexFwkUsecase.OBJECT_REMOVAL);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\u0002\u001a\u0004\b\n\u0010\r¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/vexfwk/sdk/objeraser/VexFwkObjRemover$Companion;", "", "()V", "STREAM_ID_INPUT_IMAGE", "", "STREAM_ID_INPUT_MASK", "STREAM_ID_OUTPUT_IMAGE", SearchConstants.TargetContents.TAG, "", "kotlin.jvm.PlatformType", "isAvailable", "", "isAvailable$annotations", "()Z", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void isAvailable$annotations() {
        }

        public final boolean isAvailable() {
            return VexFwkObjRemover.isAvailable;
        }

        private Companion() {
        }
    }

    public static final boolean isAvailable() {
        return INSTANCE.isAvailable();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Bitmap removeObject$lambda$7(Rect roi, int[] mask, Bitmap bitmap, VexFwkObjRemover this$0) throws Throwable {
        Intrinsics.checkNotNullParameter(roi, "$roi");
        Intrinsics.checkNotNullParameter(mask, "$mask");
        Intrinsics.checkNotNullParameter(bitmap, "$bitmap");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String str = TAG;
        Log.d(str, "removeObject E");
        VexFwkBitmapHardware vexFwkBitmapHardware = new VexFwkBitmapHardware(roi.width(), roi.height(), 1, mask);
        VexFwkBitmapHardware vexFwkBitmapHardware2 = new VexFwkBitmapHardware(roi.width(), roi.height(), 1, null);
        VexFwkSessionRequest.Sync syncBuild = ((VexFwkSessionRequest.Sync.Builder) VexFwkSessionRequestKt.addOutputBuffer(VexFwkSessionRequestKt.addInputBuffer(VexFwkSessionRequestKt.addInputBuffer(new VexFwkSessionRequest.Sync.Builder(), 0, bitmap), 1, vexFwkBitmapHardware.getBitmap()), 2, vexFwkBitmapHardware2.getBitmap())).build();
        try {
            Object objM22200processRequestIoAF18A = this$0.getSession(VexFwkUsecase.OBJECT_REMOVAL).m22200processRequestIoAF18A(syncBuild);
            AutoCloseableKt.closeFinally(syncBuild, null);
            Throwable thM22218exceptionOrNullimpl = Result.m22218exceptionOrNullimpl(objM22200processRequestIoAF18A);
            if (thM22218exceptionOrNullimpl != null) {
                Log.e(str, "Failed to process request : " + thM22218exceptionOrNullimpl);
                vexFwkBitmapHardware.close();
                vexFwkBitmapHardware2.close();
                throw thM22218exceptionOrNullimpl;
            }
            VexFwkSessionTotalResult vexFwkSessionTotalResult = (VexFwkSessionTotalResult) objM22200processRequestIoAF18A;
            try {
                if (((VexFwkNodeResultCode) vexFwkSessionTotalResult.getResultMetadata().get(VexFwkMetadataKey.RESULT_CODE.INSTANCE)) != VexFwkNodeResultCode.f8084OK) {
                    vexFwkBitmapHardware.close();
                    vexFwkBitmapHardware2.close();
                    throw new IllegalStateException("Failed to remove object");
                }
                Unit unit = Unit.INSTANCE;
                AutoCloseableKt.closeFinally(vexFwkSessionTotalResult, null);
                vexFwkBitmapHardware.close();
                int width = vexFwkBitmapHardware2.getWidth();
                int height = vexFwkBitmapHardware2.getHeight();
                int iWidth = roi.width();
                int iHeight = roi.height();
                StringBuilder sbM1173s = AbstractC0622a.m1173s(width, height, "removeObject : ", "x", " -> ");
                sbM1173s.append(iWidth);
                sbM1173s.append("x");
                sbM1173s.append(iHeight);
                Log.d(str, sbM1173s.toString());
                try {
                    int i = roi.left;
                    int i2 = roi.top;
                    int i4 = roi.right;
                    int i5 = roi.bottom;
                    Bitmap.Config config = bitmap.getConfig();
                    Intrinsics.checkNotNull(config);
                    Bitmap bitmapCropped = vexFwkBitmapHardware2.toBitmapCropped(i, i2, i4, i5, config);
                    AutoCloseableKt.closeFinally(vexFwkBitmapHardware2, null);
                    Log.d(str, "removeObject X");
                    return bitmapCropped;
                } finally {
                }
            } finally {
            }
        } finally {
        }
    }

    @NotNull
    public final VexFwkObjRemover configure() {
        return (VexFwkObjRemover) configureWith(this, new Function1<VexFwkObjRemover, Unit>() { // from class: com.samsung.android.vexfwk.sdk.objeraser.VexFwkObjRemover.configure.1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(VexFwkObjRemover vexFwkObjRemover) {
                invoke2(vexFwkObjRemover);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull VexFwkObjRemover configureWith) {
                Intrinsics.checkNotNullParameter(configureWith, "$this$configureWith");
                configureWith.createSession(VexFwkUsecase.OBJECT_REMOVAL, new Function1<VexFwkSessionConfigRequest.Builder, Unit>() { // from class: com.samsung.android.vexfwk.sdk.objeraser.VexFwkObjRemover.configure.1.1
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
                        VexFwkSessionConfigRequest.Builder.addInputStream$default(createSession, 1, vexFwkStreamType, VexFwkStreamUsage.MASK, 0, 0, 0, null, 120, null);
                        VexFwkSessionConfigRequest.Builder.addOutputStream$default(createSession, 2, vexFwkStreamType, vexFwkStreamUsage, 0, 0, 0, null, 120, null);
                    }
                });
            }
        });
    }

    @NotNull
    public final CompletableFuture<Bitmap> removeObject(@NotNull Bitmap bitmap, @NotNull int[] mask, @NotNull Rect roi) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(mask, "mask");
        Intrinsics.checkNotNullParameter(roi, "roi");
        CompletableFuture<Bitmap> completableFutureSupplyAsync = CompletableFuture.supplyAsync(new C11576a(roi, mask, bitmap, this, 2));
        Intrinsics.checkNotNullExpressionValue(completableFutureSupplyAsync, "supplyAsync(...)");
        return completableFutureSupplyAsync;
    }
}
