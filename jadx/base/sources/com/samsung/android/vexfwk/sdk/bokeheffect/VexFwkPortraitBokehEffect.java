package com.samsung.android.vexfwk.sdk.bokeheffect;

import android.graphics.Bitmap;
import androidx.collection.AbstractC0622a;
import androidx.glance.AbstractC2821a;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.vexfwk.Bokeheffect.BokehEffectType;
import com.samsung.android.vexfwk.bitmap.VexFwkBitmapHardware;
import com.samsung.android.vexfwk.log.VexFwkLog;
import com.samsung.android.vexfwk.metadata.VexFwkMetadataKey;
import com.samsung.android.vexfwk.metadata.VexFwkMetadataNative;
import com.samsung.android.vexfwk.param.VexFwkBokehEffectParams;
import com.samsung.android.vexfwk.param.VexFwkNodeResultCode;
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
import kotlin.NoWhenBranchMatchedException;
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

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000e2\u00020\u0001:\u0002\r\u000eB\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\u0000J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\bH\u0002¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/vexfwk/sdk/bokeheffect/VexFwkPortraitBokehEffect;", "Lcom/samsung/android/vexfwk/sdk/common/VexFwkSdkBase;", "()V", "applyEffect", "Ljava/util/concurrent/CompletableFuture;", "Landroid/graphics/Bitmap;", "bitmap", "effect", "Lcom/samsung/android/vexfwk/sdk/bokeheffect/VexFwkPortraitBokehEffect$BokehEffect;", "configure", "convertToBokehEffectParams", "Lcom/samsung/android/vexfwk/param/VexFwkBokehEffectParams;", "bokehEffect", "BokehEffect", "Companion", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nVexFwkPortraitBokehEffect.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VexFwkPortraitBokehEffect.kt\ncom/samsung/android/vexfwk/sdk/bokeheffect/VexFwkPortraitBokehEffect\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,131:1\n1#2:132\n*E\n"})
public final class VexFwkPortraitBokehEffect extends VexFwkSdkBase {
    private static final int STREAM_ID_IMAGE = 0;
    private static final int STREAM_ID_OUTPUT_IMAGE = 1;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "VexFwkPortraitBokehEffect";
    private static final boolean isAvailable = VexFwkSdkBase.INSTANCE.isAvailable(VexFwkUsecase.PORTRAIT_BOKEH_EFFECT);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0001\u0004¨\u0006\u0005"}, m13886d2 = {"Lcom/samsung/android/vexfwk/sdk/bokeheffect/VexFwkPortraitBokehEffect$BokehEffect;", "", "()V", "BokehLens", "Lcom/samsung/android/vexfwk/sdk/bokeheffect/VexFwkPortraitBokehEffect$BokehEffect$BokehLens;", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static abstract class BokehEffect {

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J;\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\u0005HÖ\u0001J\t\u0010#\u001a\u00020$HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\rR\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\r¨\u0006%"}, m13886d2 = {"Lcom/samsung/android/vexfwk/sdk/bokeheffect/VexFwkPortraitBokehEffect$BokehEffect$BokehLens;", "Lcom/samsung/android/vexfwk/sdk/bokeheffect/VexFwkPortraitBokehEffect$BokehEffect;", "effectTypeId", "Lcom/samsung/android/vexfwk/Bokeheffect/BokehEffectType;", "effectLevel", "", "imageOrientation", "saveAsFlip", "reLightLevel", "(Lcom/samsung/android/vexfwk/Bokeheffect/BokehEffectType;IIII)V", "getEffectLevel", "()I", "setEffectLevel", "(I)V", "getEffectTypeId", "()Lcom/samsung/android/vexfwk/Bokeheffect/BokehEffectType;", "setEffectTypeId", "(Lcom/samsung/android/vexfwk/Bokeheffect/BokehEffectType;)V", "getImageOrientation", "setImageOrientation", "getReLightLevel", "setReLightLevel", "getSaveAsFlip", "setSaveAsFlip", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
        public static final /* data */ class BokehLens extends BokehEffect {
            private int effectLevel;

            @NotNull
            private BokehEffectType effectTypeId;
            private int imageOrientation;
            private int reLightLevel;
            private int saveAsFlip;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public BokehLens(@NotNull BokehEffectType effectTypeId, int i, int i2, int i4, int i5) {
                super(null);
                Intrinsics.checkNotNullParameter(effectTypeId, "effectTypeId");
                this.effectTypeId = effectTypeId;
                this.effectLevel = i;
                this.imageOrientation = i2;
                this.saveAsFlip = i4;
                this.reLightLevel = i5;
            }

            public static /* synthetic */ BokehLens copy$default(BokehLens bokehLens, BokehEffectType bokehEffectType, int i, int i2, int i4, int i5, int i6, Object obj) {
                if ((i6 & 1) != 0) {
                    bokehEffectType = bokehLens.effectTypeId;
                }
                if ((i6 & 2) != 0) {
                    i = bokehLens.effectLevel;
                }
                if ((i6 & 4) != 0) {
                    i2 = bokehLens.imageOrientation;
                }
                if ((i6 & 8) != 0) {
                    i4 = bokehLens.saveAsFlip;
                }
                if ((i6 & 16) != 0) {
                    i5 = bokehLens.reLightLevel;
                }
                int i7 = i5;
                int i8 = i2;
                return bokehLens.copy(bokehEffectType, i, i8, i4, i7);
            }

            @NotNull
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final BokehEffectType getEffectTypeId() {
                return this.effectTypeId;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final int getEffectLevel() {
                return this.effectLevel;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final int getImageOrientation() {
                return this.imageOrientation;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final int getSaveAsFlip() {
                return this.saveAsFlip;
            }

            /* JADX INFO: renamed from: component5, reason: from getter */
            public final int getReLightLevel() {
                return this.reLightLevel;
            }

            @NotNull
            public final BokehLens copy(@NotNull BokehEffectType effectTypeId, int effectLevel, int imageOrientation, int saveAsFlip, int reLightLevel) {
                Intrinsics.checkNotNullParameter(effectTypeId, "effectTypeId");
                return new BokehLens(effectTypeId, effectLevel, imageOrientation, saveAsFlip, reLightLevel);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof BokehLens)) {
                    return false;
                }
                BokehLens bokehLens = (BokehLens) other;
                return this.effectTypeId == bokehLens.effectTypeId && this.effectLevel == bokehLens.effectLevel && this.imageOrientation == bokehLens.imageOrientation && this.saveAsFlip == bokehLens.saveAsFlip && this.reLightLevel == bokehLens.reLightLevel;
            }

            public final int getEffectLevel() {
                return this.effectLevel;
            }

            @NotNull
            public final BokehEffectType getEffectTypeId() {
                return this.effectTypeId;
            }

            public final int getImageOrientation() {
                return this.imageOrientation;
            }

            public final int getReLightLevel() {
                return this.reLightLevel;
            }

            public final int getSaveAsFlip() {
                return this.saveAsFlip;
            }

            public int hashCode() {
                return Integer.hashCode(this.reLightLevel) + AbstractC0622a.m1157c(this.saveAsFlip, AbstractC0622a.m1157c(this.imageOrientation, AbstractC0622a.m1157c(this.effectLevel, this.effectTypeId.hashCode() * 31, 31), 31), 31);
            }

            public final void setEffectLevel(int i) {
                this.effectLevel = i;
            }

            public final void setEffectTypeId(@NotNull BokehEffectType bokehEffectType) {
                Intrinsics.checkNotNullParameter(bokehEffectType, "<set-?>");
                this.effectTypeId = bokehEffectType;
            }

            public final void setImageOrientation(int i) {
                this.imageOrientation = i;
            }

            public final void setReLightLevel(int i) {
                this.reLightLevel = i;
            }

            public final void setSaveAsFlip(int i) {
                this.saveAsFlip = i;
            }

            @NotNull
            public String toString() {
                BokehEffectType bokehEffectType = this.effectTypeId;
                int i = this.effectLevel;
                int i2 = this.imageOrientation;
                int i4 = this.saveAsFlip;
                int i5 = this.reLightLevel;
                StringBuilder sb = new StringBuilder("BokehLens(effectTypeId=");
                sb.append(bokehEffectType);
                sb.append(", effectLevel=");
                sb.append(i);
                sb.append(", imageOrientation=");
                AbstractC2821a.m2235z(sb, i2, i4, ", saveAsFlip=", ", reLightLevel=");
                return AbstractC2821a.m2223n(sb, ")", i5);
            }
        }

        public /* synthetic */ BokehEffect(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private BokehEffect() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\u0002\u001a\u0004\b\t\u0010\f¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/vexfwk/sdk/bokeheffect/VexFwkPortraitBokehEffect$Companion;", "", "()V", "STREAM_ID_IMAGE", "", "STREAM_ID_OUTPUT_IMAGE", SearchConstants.TargetContents.TAG, "", "kotlin.jvm.PlatformType", "isAvailable", "", "isAvailable$annotations", "()Z", "getEffect", "Lcom/samsung/android/vexfwk/sdk/bokeheffect/VexFwkPortraitBokehEffect$BokehEffect;", "effectType", "Lcom/samsung/android/vexfwk/Bokeheffect/BokehEffectType;", "getEffectImpl", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class Companion {

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[BokehEffectType.values().length];
                try {
                    iArr[BokehEffectType.EFFECT_TYPE_BOKEH_LENS.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final BokehEffect getEffectImpl(BokehEffectType effectType) {
            if (WhenMappings.$EnumSwitchMapping$0[effectType.ordinal()] == 1) {
                return new BokehEffect.BokehLens(BokehEffectType.EFFECT_TYPE_BOKEH_LENS, 5, 0, 0, 5);
            }
            throw new NoWhenBranchMatchedException();
        }

        @JvmStatic
        public static /* synthetic */ void isAvailable$annotations() {
        }

        @NotNull
        public final BokehEffect getEffect(@NotNull BokehEffectType effectType) {
            Intrinsics.checkNotNullParameter(effectType, "effectType");
            return getEffectImpl(effectType);
        }

        public final boolean isAvailable() {
            return VexFwkPortraitBokehEffect.isAvailable;
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Bitmap applyEffect$lambda$8(Bitmap bitmap, VexFwkPortraitBokehEffect this$0, BokehEffect effect) throws Throwable {
        Intrinsics.checkNotNullParameter(bitmap, "$bitmap");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(effect, "$effect");
        VexFwkLog.Companion companion = VexFwkLog.INSTANCE;
        String TAG2 = TAG;
        companion.m12816d(TAG2, "applyBokehEffect : E");
        VexFwkBitmapHardware vexFwkBitmapHardware = new VexFwkBitmapHardware(bitmap.getWidth(), bitmap.getHeight(), 1, null);
        final VexFwkBokehEffectParams vexFwkBokehEffectParamsConvertToBokehEffectParams = this$0.convertToBokehEffectParams(effect);
        VexFwkSessionRequest.Sync syncBuild = ((VexFwkSessionRequest.Sync.Builder) VexFwkSessionRequestKt.setSettingMetadata(VexFwkSessionRequestKt.addOutputBuffer(VexFwkSessionRequestKt.addInputBuffer(new VexFwkSessionRequest.Sync.Builder(), 0, bitmap), 1, vexFwkBitmapHardware.getBitmap()), new Function1<VexFwkMetadataNative, Unit>() { // from class: com.samsung.android.vexfwk.sdk.bokeheffect.VexFwkPortraitBokehEffect$applyEffect$1$1
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
                setSettingMetadata.set(VexFwkMetadataKey.PORTRAIT_BOKEH_EFFECT.INSTANCE, vexFwkBokehEffectParamsConvertToBokehEffectParams);
            }
        })).build();
        try {
            Object objM22200processRequestIoAF18A = this$0.getSession(VexFwkUsecase.PORTRAIT_BOKEH_EFFECT).m22200processRequestIoAF18A(syncBuild);
            AutoCloseableKt.closeFinally(syncBuild, null);
            Throwable thM22218exceptionOrNullimpl = Result.m22218exceptionOrNullimpl(objM22200processRequestIoAF18A);
            if (thM22218exceptionOrNullimpl != null) {
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                companion.m12817e(TAG2, "Failed to process request : " + thM22218exceptionOrNullimpl);
                vexFwkBitmapHardware.close();
                throw thM22218exceptionOrNullimpl;
            }
            VexFwkSessionTotalResult vexFwkSessionTotalResult = (VexFwkSessionTotalResult) objM22200processRequestIoAF18A;
            try {
                if (((VexFwkNodeResultCode) vexFwkSessionTotalResult.getResultMetadata().get(VexFwkMetadataKey.RESULT_CODE.INSTANCE)) != VexFwkNodeResultCode.f8084OK) {
                    vexFwkBitmapHardware.close();
                    throw new IllegalStateException("Failed to apply bokeh effect");
                }
                Unit unit = Unit.INSTANCE;
                AutoCloseableKt.closeFinally(vexFwkSessionTotalResult, null);
                companion.m12816d(TAG2, "applyBokehEffect : X");
                try {
                    int width = bitmap.getWidth();
                    int height = bitmap.getHeight();
                    Bitmap.Config config = bitmap.getConfig();
                    Intrinsics.checkNotNull(config);
                    Bitmap bitmapCropped = vexFwkBitmapHardware.toBitmapCropped(0, 0, width, height, config);
                    AutoCloseableKt.closeFinally(vexFwkBitmapHardware, null);
                    companion.m12816d(TAG2, "applyBokehEffect : X");
                    return bitmapCropped;
                } finally {
                }
            } finally {
            }
        } finally {
        }
    }

    private final VexFwkBokehEffectParams convertToBokehEffectParams(BokehEffect bokehEffect) {
        if (!(bokehEffect instanceof BokehEffect.BokehLens)) {
            throw new NoWhenBranchMatchedException();
        }
        BokehEffect.BokehLens bokehLens = (BokehEffect.BokehLens) bokehEffect;
        return new VexFwkBokehEffectParams(bokehLens.getEffectTypeId(), bokehLens.getEffectLevel(), bokehLens.getImageOrientation(), bokehLens.getSaveAsFlip(), bokehLens.getReLightLevel());
    }

    public static final boolean isAvailable() {
        return INSTANCE.isAvailable();
    }

    @NotNull
    public final CompletableFuture<Bitmap> applyEffect(@NotNull Bitmap bitmap, @NotNull BokehEffect effect) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(effect, "effect");
        CompletableFuture<Bitmap> completableFutureSupplyAsync = CompletableFuture.supplyAsync(new C11571a(bitmap, 0, this, effect));
        Intrinsics.checkNotNullExpressionValue(completableFutureSupplyAsync, "supplyAsync(...)");
        return completableFutureSupplyAsync;
    }

    @NotNull
    public final VexFwkPortraitBokehEffect configure() {
        return (VexFwkPortraitBokehEffect) configureWith(this, new Function1<VexFwkPortraitBokehEffect, Unit>() { // from class: com.samsung.android.vexfwk.sdk.bokeheffect.VexFwkPortraitBokehEffect.configure.1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(VexFwkPortraitBokehEffect vexFwkPortraitBokehEffect) {
                invoke2(vexFwkPortraitBokehEffect);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull VexFwkPortraitBokehEffect configureWith) {
                Intrinsics.checkNotNullParameter(configureWith, "$this$configureWith");
                configureWith.createSession(VexFwkUsecase.PORTRAIT_BOKEH_EFFECT, new Function1<VexFwkSessionConfigRequest.Builder, Unit>() { // from class: com.samsung.android.vexfwk.sdk.bokeheffect.VexFwkPortraitBokehEffect.configure.1.1
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
}
