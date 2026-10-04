package com.samsung.android.vexfwk.sdk.docscan;

import android.graphics.Bitmap;
import android.media.Image;
import android.util.Log;
import com.samsung.android.sdk.mobileservice.profile.Profile;
import com.samsung.android.sdk.mobileservice.social.group.provider.GroupContract;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.vexfwk.metadata.VexFwkMetadataKey;
import com.samsung.android.vexfwk.metadata.VexFwkMetadataNative;
import com.samsung.android.vexfwk.param.VexFwkDocumentCorners;
import com.samsung.android.vexfwk.sdk.common.VexFwkSdkBase;
import com.samsung.android.vexfwk.sdk.common.runtime.IVexFwkSessionCallback;
import com.samsung.android.vexfwk.sdk.common.runtime.VexFwkResultCode;
import com.samsung.android.vexfwk.sdk.common.runtime.VexFwkSessionConfigRequest;
import com.samsung.android.vexfwk.sdk.common.runtime.VexFwkSessionPartialResult;
import com.samsung.android.vexfwk.sdk.common.runtime.VexFwkSessionRequest;
import com.samsung.android.vexfwk.sdk.common.runtime.VexFwkSessionRequestKt;
import com.samsung.android.vexfwk.sdk.common.runtime.VexFwkSessionTotalResult;
import com.samsung.android.vexfwk.sdk.docscan.VexFwkDocDetector;
import com.samsung.android.vexfwk.session.VexFwkStreamType;
import com.samsung.android.vexfwk.session.VexFwkStreamUsage;
import com.samsung.android.vexfwk.session.VexFwkUsecase;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
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
@Metadata(m13885d1 = {"\u0000?\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t*\u0001\n\u0018\u0000 \u00192\u00020\u0001:\u0003\u0018\u0019\u001aB\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\f\u001a\u00020\u0000J\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u0011J\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\bJ\u0016\u0010\r\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0007J!\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\"\u0004\b\u0000\u0010\u00152\u0006\u0010\u0016\u001a\u0002H\u0015H\u0002¢\u0006\u0002\u0010\u0017J\u0018\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0007H\u0002R&\u0010\u0003\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000b¨\u0006\u001b"}, m13886d2 = {"Lcom/samsung/android/vexfwk/sdk/docscan/VexFwkDocDetector;", "Lcom/samsung/android/vexfwk/sdk/common/VexFwkSdkBase;", "()V", "requestMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lkotlin/Pair;", "Lcom/samsung/android/vexfwk/sdk/docscan/VexFwkDocDetector$Callback;", "Landroid/media/Image;", "sessionCallback", "com/samsung/android/vexfwk/sdk/docscan/VexFwkDocDetector$sessionCallback$1", "Lcom/samsung/android/vexfwk/sdk/docscan/VexFwkDocDetector$sessionCallback$1;", "configure", "detectDocument", "Ljava/util/concurrent/CompletableFuture;", "Lcom/samsung/android/vexfwk/sdk/docscan/VexFwkDocDetector$DetectResult;", "image", "Landroid/graphics/Bitmap;", "", Profile.PhoneNumberData.TYPE_CALLBACK, "detectDocumentImpl", "T", "buffer", "(Ljava/lang/Object;)Ljava/util/concurrent/CompletableFuture;", "Callback", "Companion", "DetectResult", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nVexFwkDocDetector.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VexFwkDocDetector.kt\ncom/samsung/android/vexfwk/sdk/docscan/VexFwkDocDetector\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,173:1\n1#2:174\n*E\n"})
public final class VexFwkDocDetector extends VexFwkSdkBase {
    private static final int STREAM_ID_IMAGE = 0;

    @NotNull
    private final ConcurrentHashMap<Integer, Pair<Callback, Image>> requestMap = new ConcurrentHashMap<>();

    @NotNull
    private final VexFwkDocDetector$sessionCallback$1 sessionCallback = new IVexFwkSessionCallback() { // from class: com.samsung.android.vexfwk.sdk.docscan.VexFwkDocDetector$sessionCallback$1
        @Override // com.samsung.android.vexfwk.sdk.common.runtime.IVexFwkSessionCallback
        public void onRequestCompleted(@NotNull VexFwkSessionTotalResult totalResult) {
            Object objM22215constructorimpl;
            Intrinsics.checkNotNullParameter(totalResult, "totalResult");
            IVexFwkSessionCallback.DefaultImpls.onRequestCompleted(this, totalResult);
            Pair pair = (Pair) this.this$0.requestMap.remove(Integer.valueOf(totalResult.getRequestNumber()));
            if (pair != null) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    objM22215constructorimpl = Result.m22215constructorimpl(VexFwkDocDetector.INSTANCE.createDetectResult(totalResult.getResultMetadata()));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objM22215constructorimpl = Result.m22215constructorimpl(ResultKt.createFailure(th));
                }
                if (Result.m22222isSuccessimpl(objM22215constructorimpl)) {
                    ((VexFwkDocDetector.Callback) pair.getFirst()).onDetected((Image) pair.getSecond(), Result.m22215constructorimpl((VexFwkDocDetector.DetectResult) objM22215constructorimpl));
                }
                Throwable thM22218exceptionOrNullimpl = Result.m22218exceptionOrNullimpl(objM22215constructorimpl);
                if (thM22218exceptionOrNullimpl != null) {
                    Log.w(VexFwkDocDetector.TAG, "onRequestCompleted : createDetectResult failed, " + thM22218exceptionOrNullimpl);
                }
                Result.m22214boximpl(objM22215constructorimpl);
            }
        }

        @Override // com.samsung.android.vexfwk.sdk.common.runtime.IVexFwkSessionCallback
        public void onRequestProgressed(@NotNull VexFwkSessionPartialResult vexFwkSessionPartialResult) {
            IVexFwkSessionCallback.DefaultImpls.onRequestProgressed(this, vexFwkSessionPartialResult);
        }
    };

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "VexFwkDocDetector";
    private static final boolean isAvailable = VexFwkSdkBase.INSTANCE.isAvailable(VexFwkUsecase.DOCUMENT_DETECTION);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J#\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&¢\u0006\u0002\u0010\t¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/vexfwk/sdk/docscan/VexFwkDocDetector$Callback;", "", "onDetected", "", "image", "Landroid/media/Image;", "result", "Lkotlin/Result;", "Lcom/samsung/android/vexfwk/sdk/docscan/VexFwkDocDetector$DetectResult;", "(Landroid/media/Image;Ljava/lang/Object;)V", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public interface Callback {
        void onDetected(@NotNull Image image, @NotNull Object result);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0003R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u0002\u001a\u0004\b\b\u0010\u000b¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/vexfwk/sdk/docscan/VexFwkDocDetector$Companion;", "", "()V", "STREAM_ID_IMAGE", "", SearchConstants.TargetContents.TAG, "", "kotlin.jvm.PlatformType", "isAvailable", "", "isAvailable$annotations", "()Z", "createDetectResult", "Lcom/samsung/android/vexfwk/sdk/docscan/VexFwkDocDetector$DetectResult;", GroupContract.Group.META_DATA, "Lcom/samsung/android/vexfwk/metadata/VexFwkMetadataNative;", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        @JvmStatic
        public final DetectResult createDetectResult(VexFwkMetadataNative metadata) {
            if (metadata == null) {
                return new DetectResult(null, 0, 3, 0 == true ? 1 : 0);
            }
            VexFwkDocumentCorners vexFwkDocumentCorners = (VexFwkDocumentCorners) metadata.get(VexFwkMetadataKey.DOCUMENT_RECT.INSTANCE);
            Integer num = (Integer) metadata.get(VexFwkMetadataKey.DOCUMENT_SCAN_STABILITY.INSTANCE);
            return new DetectResult(vexFwkDocumentCorners, num != null ? num.intValue() : -1);
        }

        @JvmStatic
        public static /* synthetic */ void isAvailable$annotations() {
        }

        public final boolean isAvailable() {
            return VexFwkDocDetector.isAvailable;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0018"}, m13886d2 = {"Lcom/samsung/android/vexfwk/sdk/docscan/VexFwkDocDetector$DetectResult;", "", "corners", "Lcom/samsung/android/vexfwk/param/VexFwkDocumentCorners;", "stability", "", "(Lcom/samsung/android/vexfwk/param/VexFwkDocumentCorners;I)V", "getCorners", "()Lcom/samsung/android/vexfwk/param/VexFwkDocumentCorners;", "setCorners", "(Lcom/samsung/android/vexfwk/param/VexFwkDocumentCorners;)V", "getStability", "()I", "setStability", "(I)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final /* data */ class DetectResult {

        @Nullable
        private VexFwkDocumentCorners corners;
        private int stability;

        /* JADX WARN: Multi-variable type inference failed */
        public DetectResult() {
            this(null, 0, 3, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ DetectResult copy$default(DetectResult detectResult, VexFwkDocumentCorners vexFwkDocumentCorners, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                vexFwkDocumentCorners = detectResult.corners;
            }
            if ((i2 & 2) != 0) {
                i = detectResult.stability;
            }
            return detectResult.copy(vexFwkDocumentCorners, i);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final VexFwkDocumentCorners getCorners() {
            return this.corners;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getStability() {
            return this.stability;
        }

        @NotNull
        public final DetectResult copy(@Nullable VexFwkDocumentCorners corners, int stability) {
            return new DetectResult(corners, stability);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DetectResult)) {
                return false;
            }
            DetectResult detectResult = (DetectResult) other;
            return Intrinsics.areEqual(this.corners, detectResult.corners) && this.stability == detectResult.stability;
        }

        @Nullable
        public final VexFwkDocumentCorners getCorners() {
            return this.corners;
        }

        public final int getStability() {
            return this.stability;
        }

        public int hashCode() {
            VexFwkDocumentCorners vexFwkDocumentCorners = this.corners;
            return Integer.hashCode(this.stability) + ((vexFwkDocumentCorners == null ? 0 : vexFwkDocumentCorners.hashCode()) * 31);
        }

        public final void setCorners(@Nullable VexFwkDocumentCorners vexFwkDocumentCorners) {
            this.corners = vexFwkDocumentCorners;
        }

        public final void setStability(int i) {
            this.stability = i;
        }

        @NotNull
        public String toString() {
            return "DetectResult(corners=" + this.corners + ", stability=" + this.stability + ")";
        }

        public DetectResult(@Nullable VexFwkDocumentCorners vexFwkDocumentCorners, int i) {
            this.corners = vexFwkDocumentCorners;
            this.stability = i;
        }

        public /* synthetic */ DetectResult(VexFwkDocumentCorners vexFwkDocumentCorners, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? null : vexFwkDocumentCorners, (i2 & 2) != 0 ? -1 : i);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[VexFwkResultCode.values().length];
            try {
                iArr[VexFwkResultCode.f8089OK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @JvmStatic
    private static final DetectResult createDetectResult(VexFwkMetadataNative vexFwkMetadataNative) {
        return INSTANCE.createDetectResult(vexFwkMetadataNative);
    }

    private final void detectDocumentImpl(Image image, Callback callback) {
        String str = TAG;
        Log.d(str, "detectDocumentImpl E");
        VexFwkSessionRequest.Async asyncBuild = ((VexFwkSessionRequest.Async.Builder) VexFwkSessionRequestKt.addInputBuffer(new VexFwkSessionRequest.Async.Builder(), 0, image)).setCallback(this.sessionCallback).build();
        try {
            if (WhenMappings.$EnumSwitchMapping$0[getSession(VexFwkUsecase.DOCUMENT_DETECTION).processRequest(asyncBuild).ordinal()] == 1) {
                this.requestMap.put(Integer.valueOf(asyncBuild.getRequestFrameNumber()), new Pair<>(callback, image));
            } else {
                Result.Companion companion = Result.INSTANCE;
                callback.onDetected(image, Result.m22215constructorimpl(ResultKt.createFailure(new RuntimeException("Failed to process request"))));
            }
            Unit unit = Unit.INSTANCE;
            AutoCloseableKt.closeFinally(asyncBuild, null);
            Log.d(str, "detectDocumentImpl X");
        } finally {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DetectResult detectDocumentImpl$lambda$7(Object obj, VexFwkDocDetector this$0) throws Throwable {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String str = TAG;
        Log.d(str, "detectDocumentImpl E");
        VexFwkSessionRequest.Sync syncBuild = ((VexFwkSessionRequest.Sync.Builder) VexFwkSessionRequestKt.addInputBuffer(new VexFwkSessionRequest.Sync.Builder(), 0, obj)).build();
        try {
            Object objM22200processRequestIoAF18A = this$0.getSession(VexFwkUsecase.DOCUMENT_DETECTION).m22200processRequestIoAF18A(syncBuild);
            AutoCloseableKt.closeFinally(syncBuild, null);
            Throwable thM22218exceptionOrNullimpl = Result.m22218exceptionOrNullimpl(objM22200processRequestIoAF18A);
            if (thM22218exceptionOrNullimpl != null) {
                Log.e(str, "Failed to process request : " + thM22218exceptionOrNullimpl);
                throw thM22218exceptionOrNullimpl;
            }
            VexFwkSessionTotalResult vexFwkSessionTotalResult = (VexFwkSessionTotalResult) objM22200processRequestIoAF18A;
            try {
                DetectResult detectResultCreateDetectResult = INSTANCE.createDetectResult(vexFwkSessionTotalResult.getResultMetadata());
                AutoCloseableKt.closeFinally(vexFwkSessionTotalResult, null);
                Log.d(str, "detectDocumentImpl X");
                return detectResultCreateDetectResult;
            } finally {
            }
        } finally {
        }
    }

    public static final boolean isAvailable() {
        return INSTANCE.isAvailable();
    }

    @NotNull
    public final VexFwkDocDetector configure() {
        return (VexFwkDocDetector) configureWith(this, new Function1<VexFwkDocDetector, Unit>() { // from class: com.samsung.android.vexfwk.sdk.docscan.VexFwkDocDetector.configure.1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(VexFwkDocDetector vexFwkDocDetector) {
                invoke2(vexFwkDocDetector);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull VexFwkDocDetector configureWith) {
                Intrinsics.checkNotNullParameter(configureWith, "$this$configureWith");
                configureWith.createSession(VexFwkUsecase.DOCUMENT_DETECTION, new Function1<VexFwkSessionConfigRequest.Builder, Unit>() { // from class: com.samsung.android.vexfwk.sdk.docscan.VexFwkDocDetector.configure.1.1
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

    public final void detectDocument(@NotNull Image image, @NotNull Callback callback) {
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(callback, "callback");
        detectDocumentImpl(image, callback);
    }

    @NotNull
    public final CompletableFuture<DetectResult> detectDocument(@NotNull Image image) {
        Intrinsics.checkNotNullParameter(image, "image");
        return detectDocumentImpl(image);
    }

    @NotNull
    public final CompletableFuture<DetectResult> detectDocument(@NotNull Bitmap image) {
        Intrinsics.checkNotNullParameter(image, "image");
        return detectDocumentImpl(image);
    }

    private final <T> CompletableFuture<DetectResult> detectDocumentImpl(T buffer) {
        CompletableFuture<DetectResult> completableFutureSupplyAsync = CompletableFuture.supplyAsync(new C4183f(buffer, this, 3));
        Intrinsics.checkNotNullExpressionValue(completableFutureSupplyAsync, "supplyAsync(...)");
        return completableFutureSupplyAsync;
    }
}
