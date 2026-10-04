package com.samsung.android.vexfwk.sdk.imgclipper;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.Log;
import androidx.annotation.RequiresApi;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.vexfwk.hardware.VexFwkHardwareBufferNative;
import com.samsung.android.vexfwk.imageclipper.VexFwkImageClipperResultCode;
import com.samsung.android.vexfwk.metadata.VexFwkMetadataKey;
import com.samsung.android.vexfwk.param.VexFwkImageClipperInfo;
import com.samsung.android.vexfwk.param.VexFwkNodeResultCode;
import com.samsung.android.vexfwk.sdk.common.VexFwkSdkBase;
import com.samsung.android.vexfwk.sdk.common.runtime.VexFwkBuffer;
import com.samsung.android.vexfwk.sdk.common.runtime.VexFwkSessionConfigRequest;
import com.samsung.android.vexfwk.sdk.common.runtime.VexFwkSessionPartialResult;
import com.samsung.android.vexfwk.sdk.common.runtime.VexFwkSessionRequest;
import com.samsung.android.vexfwk.sdk.common.runtime.VexFwkSessionRequestKt;
import com.samsung.android.vexfwk.sdk.common.runtime.VexFwkSessionTotalResult;
import com.samsung.android.vexfwk.session.VexFwkStreamType;
import com.samsung.android.vexfwk.session.VexFwkStreamUsage;
import com.samsung.android.vexfwk.session.VexFwkUsecase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
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
import org.jetbrains.annotations.Nullable;
import p122b2.C4183f;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00122\u00020\u0001:\u0003\u0010\u0011\u0012B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0000J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0003J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0003J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0003¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/vexfwk/sdk/imgclipper/VexFwkImageClipper;", "Lcom/samsung/android/vexfwk/sdk/common/VexFwkSdkBase;", "()V", "configure", "objectCapture", "Ljava/util/concurrent/CompletableFuture;", "Lcom/samsung/android/vexfwk/sdk/imgclipper/VexFwkImageClipper$ClipResult;", "bitmap", "Landroid/graphics/Bitmap;", "objectCaptureClipResult", "clipperInfo", "Lcom/samsung/android/vexfwk/param/VexFwkImageClipperInfo;", "totalResult", "Lcom/samsung/android/vexfwk/sdk/common/runtime/VexFwkSessionTotalResult;", "objectCaptureSuccess", "populateClipBitmap", "ClipBitmap", "ClipResult", "Companion", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nVexFwkImageClipper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VexFwkImageClipper.kt\ncom/samsung/android/vexfwk/sdk/imgclipper/VexFwkImageClipper\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,180:1\n1855#2:181\n766#2:182\n857#2,2:183\n1855#2,2:185\n1856#2:187\n1#3:188\n*S KotlinDebug\n*F\n+ 1 VexFwkImageClipper.kt\ncom/samsung/android/vexfwk/sdk/imgclipper/VexFwkImageClipper\n*L\n149#1:181\n151#1:182\n151#1:183,2\n152#1:185,2\n149#1:187\n*E\n"})
public final class VexFwkImageClipper extends VexFwkSdkBase {
    private static final int STREAM_ID_INPUT_IMAGE = 0;
    private static final int STREAM_ID_OUTPUT_IMAGE = 1;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "VexFwkImageClipper";
    private static final boolean isAvailable = VexFwkSdkBase.INSTANCE.isAvailable(VexFwkUsecase.IMAGE_CLIPPER);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/vexfwk/sdk/imgclipper/VexFwkImageClipper$ClipBitmap;", "", "bitmap", "Landroid/graphics/Bitmap;", "roi", "Landroid/graphics/Rect;", "(Landroid/graphics/Bitmap;Landroid/graphics/Rect;)V", "getBitmap", "()Landroid/graphics/Bitmap;", "getRoi", "()Landroid/graphics/Rect;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final /* data */ class ClipBitmap {

        @NotNull
        private final Bitmap bitmap;

        @NotNull
        private final Rect roi;

        public ClipBitmap(@NotNull Bitmap bitmap, @NotNull Rect roi) {
            Intrinsics.checkNotNullParameter(bitmap, "bitmap");
            Intrinsics.checkNotNullParameter(roi, "roi");
            this.bitmap = bitmap;
            this.roi = roi;
        }

        public static /* synthetic */ ClipBitmap copy$default(ClipBitmap clipBitmap, Bitmap bitmap, Rect rect, int i, Object obj) {
            if ((i & 1) != 0) {
                bitmap = clipBitmap.bitmap;
            }
            if ((i & 2) != 0) {
                rect = clipBitmap.roi;
            }
            return clipBitmap.copy(bitmap, rect);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Bitmap getBitmap() {
            return this.bitmap;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Rect getRoi() {
            return this.roi;
        }

        @NotNull
        public final ClipBitmap copy(@NotNull Bitmap bitmap, @NotNull Rect roi) {
            Intrinsics.checkNotNullParameter(bitmap, "bitmap");
            Intrinsics.checkNotNullParameter(roi, "roi");
            return new ClipBitmap(bitmap, roi);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ClipBitmap)) {
                return false;
            }
            ClipBitmap clipBitmap = (ClipBitmap) other;
            return Intrinsics.areEqual(this.bitmap, clipBitmap.bitmap) && Intrinsics.areEqual(this.roi, clipBitmap.roi);
        }

        @NotNull
        public final Bitmap getBitmap() {
            return this.bitmap;
        }

        @NotNull
        public final Rect getRoi() {
            return this.roi;
        }

        public int hashCode() {
            return this.roi.hashCode() + (this.bitmap.hashCode() * 31);
        }

        @NotNull
        public String toString() {
            return "ClipBitmap(bitmap=" + this.bitmap + ", roi=" + this.roi + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/vexfwk/sdk/imgclipper/VexFwkImageClipper$ClipResult;", "", "()V", "Error", "Success", "Lcom/samsung/android/vexfwk/sdk/imgclipper/VexFwkImageClipper$ClipResult$Error;", "Lcom/samsung/android/vexfwk/sdk/imgclipper/VexFwkImageClipper$ClipResult$Success;", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static abstract class ClipResult {

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/vexfwk/sdk/imgclipper/VexFwkImageClipper$ClipResult$Error;", "Lcom/samsung/android/vexfwk/sdk/imgclipper/VexFwkImageClipper$ClipResult;", "resultCode", "Lcom/samsung/android/vexfwk/imageclipper/VexFwkImageClipperResultCode;", "(Lcom/samsung/android/vexfwk/imageclipper/VexFwkImageClipperResultCode;)V", "getResultCode", "()Lcom/samsung/android/vexfwk/imageclipper/VexFwkImageClipperResultCode;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
        public static final /* data */ class Error extends ClipResult {

            @NotNull
            private final VexFwkImageClipperResultCode resultCode;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Error(@NotNull VexFwkImageClipperResultCode resultCode) {
                super(null);
                Intrinsics.checkNotNullParameter(resultCode, "resultCode");
                this.resultCode = resultCode;
            }

            public static /* synthetic */ Error copy$default(Error error, VexFwkImageClipperResultCode vexFwkImageClipperResultCode, int i, Object obj) {
                if ((i & 1) != 0) {
                    vexFwkImageClipperResultCode = error.resultCode;
                }
                return error.copy(vexFwkImageClipperResultCode);
            }

            @NotNull
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final VexFwkImageClipperResultCode getResultCode() {
                return this.resultCode;
            }

            @NotNull
            public final Error copy(@NotNull VexFwkImageClipperResultCode resultCode) {
                Intrinsics.checkNotNullParameter(resultCode, "resultCode");
                return new Error(resultCode);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Error) && this.resultCode == ((Error) other).resultCode;
            }

            @NotNull
            public final VexFwkImageClipperResultCode getResultCode() {
                return this.resultCode;
            }

            public int hashCode() {
                return this.resultCode.hashCode();
            }

            @NotNull
            public String toString() {
                return "Error(resultCode=" + this.resultCode + ")";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J#\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/vexfwk/sdk/imgclipper/VexFwkImageClipper$ClipResult$Success;", "Lcom/samsung/android/vexfwk/sdk/imgclipper/VexFwkImageClipper$ClipResult;", "singleBitmap", "Lcom/samsung/android/vexfwk/sdk/imgclipper/VexFwkImageClipper$ClipBitmap;", "objectsBitmap", "", "(Lcom/samsung/android/vexfwk/sdk/imgclipper/VexFwkImageClipper$ClipBitmap;Ljava/util/List;)V", "getObjectsBitmap", "()Ljava/util/List;", "getSingleBitmap", "()Lcom/samsung/android/vexfwk/sdk/imgclipper/VexFwkImageClipper$ClipBitmap;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
        public static final /* data */ class Success extends ClipResult {

            @NotNull
            private final List<ClipBitmap> objectsBitmap;

            @NotNull
            private final ClipBitmap singleBitmap;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Success(@NotNull ClipBitmap singleBitmap, @NotNull List<ClipBitmap> objectsBitmap) {
                super(null);
                Intrinsics.checkNotNullParameter(singleBitmap, "singleBitmap");
                Intrinsics.checkNotNullParameter(objectsBitmap, "objectsBitmap");
                this.singleBitmap = singleBitmap;
                this.objectsBitmap = objectsBitmap;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Success copy$default(Success success, ClipBitmap clipBitmap, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    clipBitmap = success.singleBitmap;
                }
                if ((i & 2) != 0) {
                    list = success.objectsBitmap;
                }
                return success.copy(clipBitmap, list);
            }

            @NotNull
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ClipBitmap getSingleBitmap() {
                return this.singleBitmap;
            }

            @NotNull
            public final List<ClipBitmap> component2() {
                return this.objectsBitmap;
            }

            @NotNull
            public final Success copy(@NotNull ClipBitmap singleBitmap, @NotNull List<ClipBitmap> objectsBitmap) {
                Intrinsics.checkNotNullParameter(singleBitmap, "singleBitmap");
                Intrinsics.checkNotNullParameter(objectsBitmap, "objectsBitmap");
                return new Success(singleBitmap, objectsBitmap);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Success)) {
                    return false;
                }
                Success success = (Success) other;
                return Intrinsics.areEqual(this.singleBitmap, success.singleBitmap) && Intrinsics.areEqual(this.objectsBitmap, success.objectsBitmap);
            }

            @NotNull
            public final List<ClipBitmap> getObjectsBitmap() {
                return this.objectsBitmap;
            }

            @NotNull
            public final ClipBitmap getSingleBitmap() {
                return this.singleBitmap;
            }

            public int hashCode() {
                return this.objectsBitmap.hashCode() + (this.singleBitmap.hashCode() * 31);
            }

            @NotNull
            public String toString() {
                return "Success(singleBitmap=" + this.singleBitmap + ", objectsBitmap=" + this.objectsBitmap + ")";
            }
        }

        public /* synthetic */ ClipResult(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private ClipResult() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\u0002\u001a\u0004\b\t\u0010\f¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/vexfwk/sdk/imgclipper/VexFwkImageClipper$Companion;", "", "()V", "STREAM_ID_INPUT_IMAGE", "", "STREAM_ID_OUTPUT_IMAGE", SearchConstants.TargetContents.TAG, "", "kotlin.jvm.PlatformType", "isAvailable", "", "isAvailable$annotations", "()Z", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void isAvailable$annotations() {
        }

        public final boolean isAvailable() {
            return VexFwkImageClipper.isAvailable;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[VexFwkImageClipperResultCode.values().length];
            try {
                iArr[VexFwkImageClipperResultCode.f8082OK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final boolean isAvailable() {
        return INSTANCE.isAvailable();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ClipResult objectCapture$lambda$6(Bitmap bitmap, VexFwkImageClipper this$0) throws Throwable {
        Intrinsics.checkNotNullParameter(bitmap, "$bitmap");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String str = TAG;
        Log.d(str, "objectCapture E");
        VexFwkSessionRequest.Sync syncBuild = ((VexFwkSessionRequest.Sync.Builder) VexFwkSessionRequestKt.addInputBuffer(new VexFwkSessionRequest.Sync.Builder(), 0, bitmap)).build();
        try {
            Object objM22200processRequestIoAF18A = this$0.getSession(VexFwkUsecase.IMAGE_CLIPPER).m22200processRequestIoAF18A(syncBuild);
            AutoCloseableKt.closeFinally(syncBuild, null);
            Throwable thM22218exceptionOrNullimpl = Result.m22218exceptionOrNullimpl(objM22200processRequestIoAF18A);
            if (thM22218exceptionOrNullimpl != null) {
                Log.e(str, "Failed to process request : " + thM22218exceptionOrNullimpl);
                throw thM22218exceptionOrNullimpl;
            }
            VexFwkSessionTotalResult vexFwkSessionTotalResult = (VexFwkSessionTotalResult) objM22200processRequestIoAF18A;
            try {
                if (((VexFwkNodeResultCode) vexFwkSessionTotalResult.getResultMetadata().get(VexFwkMetadataKey.RESULT_CODE.INSTANCE)) != VexFwkNodeResultCode.f8084OK) {
                    throw new IllegalStateException("Failed to capture object");
                }
                ClipResult clipResultObjectCaptureSuccess = this$0.objectCaptureSuccess(vexFwkSessionTotalResult);
                AutoCloseableKt.closeFinally(vexFwkSessionTotalResult, null);
                Log.d(str, "objectCapture X");
                return clipResultObjectCaptureSuccess;
            } finally {
            }
        } finally {
        }
    }

    @RequiresApi(29)
    private final ClipResult objectCaptureClipResult(VexFwkImageClipperInfo clipperInfo, VexFwkSessionTotalResult totalResult) {
        Rect[] objectsRect = clipperInfo.getObjectsRect();
        return (objectsRect != null ? objectsRect.length : 0) > 0 ? populateClipBitmap(clipperInfo, totalResult) : new ClipResult.Error(VexFwkImageClipperResultCode.ERR_NO_OBJECT);
    }

    @RequiresApi(29)
    private final ClipResult objectCaptureSuccess(VexFwkSessionTotalResult totalResult) {
        VexFwkImageClipperInfo vexFwkImageClipperInfo = (VexFwkImageClipperInfo) totalResult.getResultMetadata().get(VexFwkMetadataKey.IMAGE_CLIPPER_INFO.INSTANCE);
        if (vexFwkImageClipperInfo != null) {
            return WhenMappings.$EnumSwitchMapping$0[vexFwkImageClipperInfo.getResultCode().ordinal()] == 1 ? objectCaptureClipResult(vexFwkImageClipperInfo, totalResult) : new ClipResult.Error(vexFwkImageClipperInfo.getResultCode());
        }
        return new ClipResult.Error(VexFwkImageClipperResultCode.ERR_UNKNOWN);
    }

    @RequiresApi(29)
    private final ClipResult populateClipBitmap(VexFwkImageClipperInfo clipperInfo, VexFwkSessionTotalResult totalResult) {
        LinkedList linkedList = new LinkedList();
        Iterator<T> it = totalResult.getPartialResults().iterator();
        boolean z = true;
        int i = 0;
        ClipBitmap clipBitmap = null;
        while (it.hasNext()) {
            List<VexFwkBuffer> outputBuffers = ((VexFwkSessionPartialResult) it.next()).getOutputBuffers();
            ArrayList<VexFwkBuffer> arrayList = new ArrayList();
            for (Object obj : outputBuffers) {
                if (((VexFwkBuffer) obj).getStreamId() == 1) {
                    arrayList.add(obj);
                }
            }
            for (VexFwkBuffer vexFwkBuffer : arrayList) {
                if (z) {
                    Bitmap bitmapConvertToBitmap$default = VexFwkHardwareBufferNative.Companion.convertToBitmap$default(VexFwkHardwareBufferNative.INSTANCE, vexFwkBuffer.getHardwareBuffer(), false, 2, null);
                    Rect singleRect = clipperInfo.getSingleRect();
                    Intrinsics.checkNotNull(singleRect);
                    clipBitmap = new ClipBitmap(bitmapConvertToBitmap$default, singleRect);
                    z = false;
                } else {
                    Bitmap bitmapConvertToBitmap$default2 = VexFwkHardwareBufferNative.Companion.convertToBitmap$default(VexFwkHardwareBufferNative.INSTANCE, vexFwkBuffer.getHardwareBuffer(), false, 2, null);
                    Rect[] objectsRect = clipperInfo.getObjectsRect();
                    Intrinsics.checkNotNull(objectsRect);
                    linkedList.add(new ClipBitmap(bitmapConvertToBitmap$default2, objectsRect[i]));
                    i++;
                }
            }
        }
        Intrinsics.checkNotNull(clipBitmap);
        return new ClipResult.Success(clipBitmap, linkedList);
    }

    @NotNull
    public final VexFwkImageClipper configure() {
        return (VexFwkImageClipper) configureWith(this, new Function1<VexFwkImageClipper, Unit>() { // from class: com.samsung.android.vexfwk.sdk.imgclipper.VexFwkImageClipper.configure.1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(VexFwkImageClipper vexFwkImageClipper) {
                invoke2(vexFwkImageClipper);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull VexFwkImageClipper configureWith) {
                Intrinsics.checkNotNullParameter(configureWith, "$this$configureWith");
                configureWith.createSession(VexFwkUsecase.IMAGE_CLIPPER, new Function1<VexFwkSessionConfigRequest.Builder, Unit>() { // from class: com.samsung.android.vexfwk.sdk.imgclipper.VexFwkImageClipper.configure.1.1
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

    @RequiresApi(29)
    @NotNull
    public final CompletableFuture<ClipResult> objectCapture(@NotNull Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        CompletableFuture<ClipResult> completableFutureSupplyAsync = CompletableFuture.supplyAsync(new C4183f(bitmap, this, 4));
        Intrinsics.checkNotNullExpressionValue(completableFutureSupplyAsync, "supplyAsync(...)");
        return completableFutureSupplyAsync;
    }
}
