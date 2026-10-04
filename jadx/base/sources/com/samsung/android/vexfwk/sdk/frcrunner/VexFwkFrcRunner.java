package com.samsung.android.vexfwk.sdk.frcrunner;

import android.util.Log;
import android.util.Size;
import android.view.Surface;
import androidx.compose.runtime.AbstractC1974b;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.vexfwk.metadata.VexFwkMetadataKey;
import com.samsung.android.vexfwk.metadata.VexFwkMetadataNative;
import com.samsung.android.vexfwk.sdk.common.VexFwkSdkBase;
import com.samsung.android.vexfwk.sdk.common.runtime.IVexFwkSessionCallback;
import com.samsung.android.vexfwk.sdk.common.runtime.VexFwkSession;
import com.samsung.android.vexfwk.sdk.common.runtime.VexFwkSessionConfigRequest;
import com.samsung.android.vexfwk.sdk.common.runtime.VexFwkSessionPartialResult;
import com.samsung.android.vexfwk.sdk.common.runtime.VexFwkSessionRequest;
import com.samsung.android.vexfwk.sdk.common.runtime.VexFwkSessionRequestKt;
import com.samsung.android.vexfwk.sdk.common.runtime.VexFwkSessionTotalResult;
import com.samsung.android.vexfwk.sdk.common.runtime.VexFwkStream;
import com.samsung.android.vexfwk.session.VexFwkStreamType;
import com.samsung.android.vexfwk.session.VexFwkStreamUsage;
import com.samsung.android.vexfwk.session.VexFwkUsecase;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Unit;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.properties.Delegates;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000+\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0011\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0005¢\u0006\u0002\u0010\u0002J0\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\bJ\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u0010\u001a\u001a\u00020\u0019J\u0006\u0010\u001b\u001a\u00020\u0019R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R+\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0010\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012¨\u0006\u001d"}, m13886d2 = {"Lcom/samsung/android/vexfwk/sdk/frcrunner/VexFwkFrcRunner;", "Lcom/samsung/android/vexfwk/sdk/common/VexFwkSdkBase;", "()V", "inputSurface", "Landroid/view/Surface;", "getInputSurface", "()Landroid/view/Surface;", "<set-?>", "", "rotationDegree", "getRotationDegree", "()I", "setRotationDegree", "(I)V", "rotationDegree$delegate", "Lkotlin/properties/ReadWriteProperty;", "sessionCallback", "com/samsung/android/vexfwk/sdk/frcrunner/VexFwkFrcRunner$sessionCallback$1", "Lcom/samsung/android/vexfwk/sdk/frcrunner/VexFwkFrcRunner$sessionCallback$1;", "configure", "inputWidth", "inputHeight", "outputSurface", "upsampleFactor", "run", "", "start", "stop", "Companion", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nVexFwkFrcRunner.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VexFwkFrcRunner.kt\ncom/samsung/android/vexfwk/sdk/frcrunner/VexFwkFrcRunner\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,105:1\n1#2:106\n*E\n"})
public final class VexFwkFrcRunner extends VexFwkSdkBase {
    private static final int STREAM_ID_INPUT_SURFACE = 0;
    private static final int STREAM_ID_OUTPUT_SURFACE = 1;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {AbstractC1974b.m1328u(VexFwkFrcRunner.class, "rotationDegree", "getRotationDegree()I", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "VexFwkFrcRunner";
    private static final boolean isAvailable = VexFwkSdkBase.INSTANCE.isAvailable(VexFwkUsecase.FRAME_RATE_CONVERSION);

    @NotNull
    private final VexFwkFrcRunner$sessionCallback$1 sessionCallback = new IVexFwkSessionCallback() { // from class: com.samsung.android.vexfwk.sdk.frcrunner.VexFwkFrcRunner$sessionCallback$1
        @Override // com.samsung.android.vexfwk.sdk.common.runtime.IVexFwkSessionCallback
        public void onRequestCompleted(@NotNull VexFwkSessionTotalResult totalResult) {
            Intrinsics.checkNotNullParameter(totalResult, "totalResult");
            IVexFwkSessionCallback.DefaultImpls.onRequestCompleted(this, totalResult);
        }

        @Override // com.samsung.android.vexfwk.sdk.common.runtime.IVexFwkSessionCallback
        public void onRequestProgressed(@NotNull VexFwkSessionPartialResult partialResult) {
            Intrinsics.checkNotNullParameter(partialResult, "partialResult");
            IVexFwkSessionCallback.DefaultImpls.onRequestProgressed(this, partialResult);
        }
    };

    /* JADX INFO: renamed from: rotationDegree$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty rotationDegree = Delegates.INSTANCE.notNull();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\u0002\u001a\u0004\b\t\u0010\f¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/vexfwk/sdk/frcrunner/VexFwkFrcRunner$Companion;", "", "()V", "STREAM_ID_INPUT_SURFACE", "", "STREAM_ID_OUTPUT_SURFACE", SearchConstants.TargetContents.TAG, "", "kotlin.jvm.PlatformType", "isAvailable", "", "isAvailable$annotations", "()Z", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void isAvailable$annotations() {
        }

        public final boolean isAvailable() {
            return VexFwkFrcRunner.isAvailable;
        }

        private Companion() {
        }
    }

    private final int getRotationDegree() {
        return ((Number) this.rotationDegree.getValue(this, $$delegatedProperties[0])).intValue();
    }

    public static final boolean isAvailable() {
        return INSTANCE.isAvailable();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setRotationDegree(int i) {
        this.rotationDegree.setValue(this, $$delegatedProperties[0], Integer.valueOf(i));
    }

    @NotNull
    public final VexFwkFrcRunner configure(final int inputWidth, final int inputHeight, @Nullable final Surface outputSurface, final int rotationDegree, final int upsampleFactor) {
        return (VexFwkFrcRunner) configureWith(this, new Function1<VexFwkFrcRunner, Unit>() { // from class: com.samsung.android.vexfwk.sdk.frcrunner.VexFwkFrcRunner.configure.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(VexFwkFrcRunner vexFwkFrcRunner) {
                invoke2(vexFwkFrcRunner);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull VexFwkFrcRunner configureWith) {
                Intrinsics.checkNotNullParameter(configureWith, "$this$configureWith");
                VexFwkUsecase vexFwkUsecase = VexFwkUsecase.FRAME_RATE_CONVERSION;
                final int i = inputWidth;
                final int i2 = inputHeight;
                final Surface surface = outputSurface;
                final int i4 = upsampleFactor;
                final int i5 = rotationDegree;
                configureWith.createSession(vexFwkUsecase, new Function1<VexFwkSessionConfigRequest.Builder, Unit>() { // from class: com.samsung.android.vexfwk.sdk.frcrunner.VexFwkFrcRunner.configure.1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(VexFwkSessionConfigRequest.Builder builder) {
                        invoke2(builder);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull VexFwkSessionConfigRequest.Builder createSession) {
                        Intrinsics.checkNotNullParameter(createSession, "$this$createSession");
                        VexFwkStreamType vexFwkStreamType = VexFwkStreamType.SURFACE;
                        VexFwkStreamUsage vexFwkStreamUsage = VexFwkStreamUsage.IMAGE;
                        VexFwkSessionConfigRequest.Builder.addInputStream$default(createSession, 0, vexFwkStreamType, vexFwkStreamUsage, i, i2, 35, null, 64, null);
                        createSession.addOutputStream(1, vexFwkStreamType, vexFwkStreamUsage, i, i2, 35, surface);
                        final int i6 = i;
                        final int i7 = i2;
                        final int i8 = i4;
                        final int i9 = i5;
                        createSession.setConfigMetadata(new Function1<VexFwkMetadataNative, Unit>() { // from class: com.samsung.android.vexfwk.sdk.frcrunner.VexFwkFrcRunner.configure.1.1.1
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
                            public final void invoke2(@NotNull VexFwkMetadataNative setConfigMetadata) {
                                Intrinsics.checkNotNullParameter(setConfigMetadata, "$this$setConfigMetadata");
                                setConfigMetadata.set(VexFwkMetadataKey.IMAGE_SIZE.INSTANCE, new Size(i6, i7));
                                setConfigMetadata.set(VexFwkMetadataKey.UPSAMPLE_FACTOR.INSTANCE, Integer.valueOf(i8));
                                setConfigMetadata.set(VexFwkMetadataKey.ROTATION_DEGREE.INSTANCE, Integer.valueOf(i9));
                            }
                        });
                    }
                });
                configureWith.setRotationDegree(rotationDegree);
            }
        });
    }

    @NotNull
    public final Surface getInputSurface() {
        Object next;
        Iterator<T> it = getSession(VexFwkUsecase.FRAME_RATE_CONVERSION).getStreams().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((VexFwkStream) next).getId() == 0) {
                break;
            }
        }
        Intrinsics.checkNotNull(next);
        Surface surface = ((VexFwkStream) next).getSurface();
        Intrinsics.checkNotNull(surface);
        return surface;
    }

    public final void run() {
        String str = TAG;
        Log.d(str, "run E");
        VexFwkSessionRequest.Async asyncBuild = ((VexFwkSessionRequest.Async.Builder) VexFwkSessionRequestKt.addOutputBuffer(VexFwkSessionRequestKt.addInputBuffer(new VexFwkSessionRequest.Async.Builder(), 0), 1)).setCallback(this.sessionCallback).build();
        try {
            VexFwkSession session = getSession(VexFwkUsecase.FRAME_RATE_CONVERSION);
            session.flush();
            session.processRequest(asyncBuild);
            AutoCloseableKt.closeFinally(asyncBuild, null);
            Log.d(str, "run X");
        } finally {
        }
    }

    public final void start() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    public final void stop() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }
}
