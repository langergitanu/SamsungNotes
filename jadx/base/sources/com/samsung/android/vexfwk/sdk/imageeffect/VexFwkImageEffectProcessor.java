package com.samsung.android.vexfwk.sdk.imageeffect;

import android.graphics.Bitmap;
import android.media.Image;
import android.util.Log;
import android.util.Size;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.C8416h;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.vexfwk.bitmap.VexFwkBitmapHardware;
import com.samsung.android.vexfwk.imageeffect.ImageEffectType;
import com.samsung.android.vexfwk.imageeffect.VexFwkImageEffectCapabilities;
import com.samsung.android.vexfwk.metadata.VexFwkMetadataKey;
import com.samsung.android.vexfwk.metadata.VexFwkMetadataNative;
import com.samsung.android.vexfwk.param.VexFwkImageEffectParams;
import com.samsung.android.vexfwk.sdk.common.VexFwkSdkBase;
import com.samsung.android.vexfwk.sdk.common.runtime.VexFwkProvider;
import com.samsung.android.vexfwk.sdk.common.runtime.VexFwkSessionConfigRequest;
import com.samsung.android.vexfwk.sdk.common.runtime.VexFwkSessionRequest;
import com.samsung.android.vexfwk.sdk.common.runtime.VexFwkSessionRequestKt;
import com.samsung.android.vexfwk.sdk.common.runtime.VexFwkSessionTotalResult;
import com.samsung.android.vexfwk.session.VexFwkStreamType;
import com.samsung.android.vexfwk.session.VexFwkStreamUsage;
import com.samsung.android.vexfwk.session.VexFwkUsecase;
import com.samsung.android.visual.p167ai.sdkcommon.image.ImageConst;
import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00192\u00020\u0001:\u0003\u0019\u001a\u001bB\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005J,\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u001c\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eJ,\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ;\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\"\u0004\b\u0000\u0010\u00102\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u0002H\u00102\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0012\u001a\u00020\fH\u0002¢\u0006\u0002\u0010\u0013J\u0006\u0010\u0014\u001a\u00020\u0000J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\fH\u0002¨\u0006\u001c"}, m13886d2 = {"Lcom/samsung/android/vexfwk/sdk/imageeffect/VexFwkImageEffectProcessor;", "Lcom/samsung/android/vexfwk/sdk/common/VexFwkSdkBase;", "()V", "applyEffect", "Ljava/util/concurrent/CompletableFuture;", "Landroid/graphics/Bitmap;", "effect", "Lcom/samsung/android/vexfwk/sdk/imageeffect/VexFwkImageEffectProcessor$ImageEffect;", "bitmap", "inputMask", "Lcom/samsung/android/vexfwk/sdk/imageeffect/VexFwkImageEffectProcessor$SegMask;", "isApplyBG", "", "image", "Landroid/media/Image;", "applyEffectImpl", "T", "buffer", "isNegativeMask", "(Lcom/samsung/android/vexfwk/sdk/imageeffect/VexFwkImageEffectProcessor$ImageEffect;Ljava/lang/Object;Lcom/samsung/android/vexfwk/sdk/imageeffect/VexFwkImageEffectProcessor$SegMask;Z)Ljava/util/concurrent/CompletableFuture;", "configure", "convertToImageEffectParams", "Lcom/samsung/android/vexfwk/param/VexFwkImageEffectParams;", "imageEffect", "applyNegativeSegMask", "Companion", "ImageEffect", "SegMask", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nVexFwkImageEffectProcessor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VexFwkImageEffectProcessor.kt\ncom/samsung/android/vexfwk/sdk/imageeffect/VexFwkImageEffectProcessor\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,292:1\n1#2:293\n*E\n"})
public final class VexFwkImageEffectProcessor extends VexFwkSdkBase {
    private static final int STREAM_ID_INPUT_IMAGE = 0;
    private static final int STREAM_ID_INPUT_MASK = 1;
    private static final int STREAM_ID_OUTPUT_IMAGE = 2;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "VexFwkImageEffectProcessor";
    private static final boolean isAvailable = VexFwkSdkBase.INSTANCE.isAvailable(VexFwkUsecase.IMAGE_EFFECT);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\u0002\u001a\u0004\b\n\u0010\r¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/vexfwk/sdk/imageeffect/VexFwkImageEffectProcessor$Companion;", "", "()V", "STREAM_ID_INPUT_IMAGE", "", "STREAM_ID_INPUT_MASK", "STREAM_ID_OUTPUT_IMAGE", SearchConstants.TargetContents.TAG, "", "kotlin.jvm.PlatformType", "isAvailable", "", "isAvailable$annotations", "()Z", "getEffect", "Lcom/samsung/android/vexfwk/sdk/imageeffect/VexFwkImageEffectProcessor$ImageEffect;", "effectType", "Lcom/samsung/android/vexfwk/imageeffect/ImageEffectType;", "getEffectImpl", "getSupportedFilters", "Lcom/samsung/android/vexfwk/imageeffect/VexFwkImageEffectCapabilities;", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nVexFwkImageEffectProcessor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VexFwkImageEffectProcessor.kt\ncom/samsung/android/vexfwk/sdk/imageeffect/VexFwkImageEffectProcessor$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,292:1\n1#2:293\n*E\n"})
    public static final class Companion {

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[ImageEffectType.values().length];
                try {
                    iArr[ImageEffectType.EFFECT_TYPE_GRAYSCALE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[ImageEffectType.EFFECT_TYPE_BLUR.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final ImageEffect getEffectImpl(ImageEffectType effectType) {
            int i = WhenMappings.$EnumSwitchMapping$0[effectType.ordinal()];
            if (i == 1) {
                return new ImageEffect.GrayScale(ImageEffectType.EFFECT_TYPE_GRAYSCALE, 100, 0, 0);
            }
            if (i == 2) {
                return new ImageEffect.Blur(ImageEffectType.EFFECT_TYPE_BLUR, 25.0f);
            }
            throw new NoWhenBranchMatchedException();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final VexFwkImageEffectCapabilities getSupportedFilters$lambda$1$lambda$0() {
            return new VexFwkImageEffectCapabilities(new int[0]);
        }

        @JvmStatic
        public static /* synthetic */ void isAvailable$annotations() {
        }

        @NotNull
        public final ImageEffect getEffect(@NotNull ImageEffectType effectType) {
            Intrinsics.checkNotNullParameter(effectType, "effectType");
            return getEffectImpl(effectType);
        }

        @JvmStatic
        @NotNull
        public final VexFwkImageEffectCapabilities getSupportedFilters() {
            VexFwkImageEffectCapabilities vexFwkImageEffectCapabilities = (VexFwkImageEffectCapabilities) VexFwkProvider.INSTANCE.fetchProperties(VexFwkUsecase.IMAGE_EFFECT).getOrElse(VexFwkMetadataKey.PROPERTY_IMAGE_EFFECT_CAPABILITIES.INSTANCE, new C8416h(11));
            AbstractC2322a.m1609C("capabilities : ", CollectionsKt.m13955n(vexFwkImageEffectCapabilities, null, null, null, null, 63), VexFwkImageEffectProcessor.TAG);
            return vexFwkImageEffectCapabilities;
        }

        public final boolean isAvailable() {
            return VexFwkImageEffectProcessor.isAvailable;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/vexfwk/sdk/imageeffect/VexFwkImageEffectProcessor$ImageEffect;", "", "()V", "Blur", "GrayScale", "Lcom/samsung/android/vexfwk/sdk/imageeffect/VexFwkImageEffectProcessor$ImageEffect$Blur;", "Lcom/samsung/android/vexfwk/sdk/imageeffect/VexFwkImageEffectProcessor$ImageEffect$GrayScale;", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static abstract class ImageEffect {

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0018"}, m13886d2 = {"Lcom/samsung/android/vexfwk/sdk/imageeffect/VexFwkImageEffectProcessor$ImageEffect$Blur;", "Lcom/samsung/android/vexfwk/sdk/imageeffect/VexFwkImageEffectProcessor$ImageEffect;", "effectType", "Lcom/samsung/android/vexfwk/imageeffect/ImageEffectType;", "radius", "", "(Lcom/samsung/android/vexfwk/imageeffect/ImageEffectType;F)V", "getEffectType", "()Lcom/samsung/android/vexfwk/imageeffect/ImageEffectType;", "getRadius", "()F", "setRadius", "(F)V", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
        public static final /* data */ class Blur extends ImageEffect {

            @NotNull
            private final ImageEffectType effectType;
            private float radius;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Blur(@NotNull ImageEffectType effectType, float f) {
                super(null);
                Intrinsics.checkNotNullParameter(effectType, "effectType");
                this.effectType = effectType;
                this.radius = f;
            }

            public static /* synthetic */ Blur copy$default(Blur blur, ImageEffectType imageEffectType, float f, int i, Object obj) {
                if ((i & 1) != 0) {
                    imageEffectType = blur.effectType;
                }
                if ((i & 2) != 0) {
                    f = blur.radius;
                }
                return blur.copy(imageEffectType, f);
            }

            @NotNull
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ImageEffectType getEffectType() {
                return this.effectType;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final float getRadius() {
                return this.radius;
            }

            @NotNull
            public final Blur copy(@NotNull ImageEffectType effectType, float radius) {
                Intrinsics.checkNotNullParameter(effectType, "effectType");
                return new Blur(effectType, radius);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Blur)) {
                    return false;
                }
                Blur blur = (Blur) other;
                return this.effectType == blur.effectType && Float.compare(this.radius, blur.radius) == 0;
            }

            @NotNull
            public final ImageEffectType getEffectType() {
                return this.effectType;
            }

            public final float getRadius() {
                return this.radius;
            }

            public int hashCode() {
                return Float.hashCode(this.radius) + (this.effectType.hashCode() * 31);
            }

            public final void setRadius(float f) {
                this.radius = f;
            }

            @NotNull
            public String toString() {
                return "Blur(effectType=" + this.effectType + ", radius=" + this.radius + ")";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J1\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\f¨\u0006\u001f"}, m13886d2 = {"Lcom/samsung/android/vexfwk/sdk/imageeffect/VexFwkImageEffectProcessor$ImageEffect$GrayScale;", "Lcom/samsung/android/vexfwk/sdk/imageeffect/VexFwkImageEffectProcessor$ImageEffect;", "effectType", "Lcom/samsung/android/vexfwk/imageeffect/ImageEffectType;", "intensity", "", "contrast", "grain", "(Lcom/samsung/android/vexfwk/imageeffect/ImageEffectType;III)V", "getContrast", "()I", "setContrast", "(I)V", "getEffectType", "()Lcom/samsung/android/vexfwk/imageeffect/ImageEffectType;", "getGrain", "setGrain", "getIntensity", "setIntensity", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
        public static final /* data */ class GrayScale extends ImageEffect {
            private int contrast;

            @NotNull
            private final ImageEffectType effectType;
            private int grain;
            private int intensity;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public GrayScale(@NotNull ImageEffectType effectType, int i, int i2, int i4) {
                super(null);
                Intrinsics.checkNotNullParameter(effectType, "effectType");
                this.effectType = effectType;
                this.intensity = i;
                this.contrast = i2;
                this.grain = i4;
            }

            public static /* synthetic */ GrayScale copy$default(GrayScale grayScale, ImageEffectType imageEffectType, int i, int i2, int i4, int i5, Object obj) {
                if ((i5 & 1) != 0) {
                    imageEffectType = grayScale.effectType;
                }
                if ((i5 & 2) != 0) {
                    i = grayScale.intensity;
                }
                if ((i5 & 4) != 0) {
                    i2 = grayScale.contrast;
                }
                if ((i5 & 8) != 0) {
                    i4 = grayScale.grain;
                }
                return grayScale.copy(imageEffectType, i, i2, i4);
            }

            @NotNull
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ImageEffectType getEffectType() {
                return this.effectType;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final int getIntensity() {
                return this.intensity;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final int getContrast() {
                return this.contrast;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final int getGrain() {
                return this.grain;
            }

            @NotNull
            public final GrayScale copy(@NotNull ImageEffectType effectType, int intensity, int contrast, int grain) {
                Intrinsics.checkNotNullParameter(effectType, "effectType");
                return new GrayScale(effectType, intensity, contrast, grain);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof GrayScale)) {
                    return false;
                }
                GrayScale grayScale = (GrayScale) other;
                return this.effectType == grayScale.effectType && this.intensity == grayScale.intensity && this.contrast == grayScale.contrast && this.grain == grayScale.grain;
            }

            public final int getContrast() {
                return this.contrast;
            }

            @NotNull
            public final ImageEffectType getEffectType() {
                return this.effectType;
            }

            public final int getGrain() {
                return this.grain;
            }

            public final int getIntensity() {
                return this.intensity;
            }

            public int hashCode() {
                return Integer.hashCode(this.grain) + AbstractC0622a.m1157c(this.contrast, AbstractC0622a.m1157c(this.intensity, this.effectType.hashCode() * 31, 31), 31);
            }

            public final void setContrast(int i) {
                this.contrast = i;
            }

            public final void setGrain(int i) {
                this.grain = i;
            }

            public final void setIntensity(int i) {
                this.intensity = i;
            }

            @NotNull
            public String toString() {
                ImageEffectType imageEffectType = this.effectType;
                int i = this.intensity;
                int i2 = this.contrast;
                int i4 = this.grain;
                StringBuilder sb = new StringBuilder("GrayScale(effectType=");
                sb.append(imageEffectType);
                sb.append(", intensity=");
                sb.append(i);
                sb.append(", contrast=");
                return AbstractC2322a.m1625o(sb, i2, i4, ", grain=", ")");
            }
        }

        public /* synthetic */ ImageEffect(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private ImageEffect() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0019"}, m13886d2 = {"Lcom/samsung/android/vexfwk/sdk/imageeffect/VexFwkImageEffectProcessor$SegMask;", "", ImageConst.PARAM_MODE_WALLPAPER_MASK, "", "size", "Landroid/util/Size;", "([ILandroid/util/Size;)V", "getMask", "()[I", "setMask", "([I)V", "getSize", "()Landroid/util/Size;", "setSize", "(Landroid/util/Size;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final /* data */ class SegMask {

        @NotNull
        private int[] mask;

        @NotNull
        private Size size;

        public SegMask(@NotNull int[] mask, @NotNull Size size) {
            Intrinsics.checkNotNullParameter(mask, "mask");
            Intrinsics.checkNotNullParameter(size, "size");
            this.mask = mask;
            this.size = size;
        }

        public static /* synthetic */ SegMask copy$default(SegMask segMask, int[] iArr, Size size, int i, Object obj) {
            if ((i & 1) != 0) {
                iArr = segMask.mask;
            }
            if ((i & 2) != 0) {
                size = segMask.size;
            }
            return segMask.copy(iArr, size);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int[] getMask() {
            return this.mask;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Size getSize() {
            return this.size;
        }

        @NotNull
        public final SegMask copy(@NotNull int[] mask, @NotNull Size size) {
            Intrinsics.checkNotNullParameter(mask, "mask");
            Intrinsics.checkNotNullParameter(size, "size");
            return new SegMask(mask, size);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!Intrinsics.areEqual(SegMask.class, other != null ? other.getClass() : null)) {
                return false;
            }
            Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.samsung.android.vexfwk.sdk.imageeffect.VexFwkImageEffectProcessor.SegMask");
            SegMask segMask = (SegMask) other;
            return Arrays.equals(this.mask, segMask.mask) && Intrinsics.areEqual(this.size, segMask.size);
        }

        @NotNull
        public final int[] getMask() {
            return this.mask;
        }

        @NotNull
        public final Size getSize() {
            return this.size;
        }

        public int hashCode() {
            return this.size.hashCode() + (Arrays.hashCode(this.mask) * 31);
        }

        public final void setMask(@NotNull int[] iArr) {
            Intrinsics.checkNotNullParameter(iArr, "<set-?>");
            this.mask = iArr;
        }

        public final void setSize(@NotNull Size size) {
            Intrinsics.checkNotNullParameter(size, "<set-?>");
            this.size = size;
        }

        @NotNull
        public String toString() {
            return "SegMask(mask=" + Arrays.toString(this.mask) + ", size=" + this.size + ")";
        }
    }

    private final <T> CompletableFuture<Bitmap> applyEffectImpl(ImageEffect effect, T buffer, SegMask inputMask, boolean isNegativeMask) {
        CompletableFuture<Bitmap> completableFutureSupplyAsync = CompletableFuture.supplyAsync(new C11579a(buffer, inputMask, this, effect, isNegativeMask));
        Intrinsics.checkNotNullExpressionValue(completableFutureSupplyAsync, "supplyAsync(...)");
        return completableFutureSupplyAsync;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Bitmap applyEffectImpl$lambda$6(Object obj, SegMask segMask, VexFwkImageEffectProcessor this$0, ImageEffect effect, boolean z) throws Throwable {
        Size size;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(effect, "$effect");
        String str = TAG;
        Log.i(str, "imageEffectImpl E");
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
        VexFwkBitmapHardware vexFwkBitmapHardware2 = segMask != null ? new VexFwkBitmapHardware(segMask.getSize().getWidth(), segMask.getSize().getHeight(), 1, segMask.getMask()) : new VexFwkBitmapHardware(1, 1, 1, null);
        final VexFwkImageEffectParams vexFwkImageEffectParamsConvertToImageEffectParams = this$0.convertToImageEffectParams(effect, z);
        VexFwkSessionRequest.Sync syncBuild = ((VexFwkSessionRequest.Sync.Builder) VexFwkSessionRequestKt.addOutputBuffer(VexFwkSessionRequestKt.setSettingMetadata(VexFwkSessionRequestKt.addInputBuffer(VexFwkSessionRequestKt.addInputBuffer(new VexFwkSessionRequest.Sync.Builder(), 0, obj), 1, vexFwkBitmapHardware2.getBitmap()), new Function1<VexFwkMetadataNative, Unit>() { // from class: com.samsung.android.vexfwk.sdk.imageeffect.VexFwkImageEffectProcessor$applyEffectImpl$1$1
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
                setSettingMetadata.set(VexFwkMetadataKey.IMAGE_EFFECT_PARAMS.INSTANCE, vexFwkImageEffectParamsConvertToImageEffectParams);
            }
        }), 2, vexFwkBitmapHardware.getBitmap())).build();
        try {
            Object objM22200processRequestIoAF18A = this$0.getSession(VexFwkUsecase.IMAGE_EFFECT).m22200processRequestIoAF18A(syncBuild);
            AutoCloseableKt.closeFinally(syncBuild, null);
            Throwable thM22218exceptionOrNullimpl = Result.m22218exceptionOrNullimpl(objM22200processRequestIoAF18A);
            if (thM22218exceptionOrNullimpl != null) {
                Log.e(str, "Failed to process request : " + thM22218exceptionOrNullimpl);
                vexFwkBitmapHardware2.close();
                vexFwkBitmapHardware.close();
                throw thM22218exceptionOrNullimpl;
            }
            Log.d(str, "ImageEffectImpl success");
            ((VexFwkSessionTotalResult) objM22200processRequestIoAF18A).close();
            vexFwkBitmapHardware2.close();
            try {
                Bitmap bitmapCropped = vexFwkBitmapHardware.toBitmapCropped(0, 0, vexFwkBitmapHardware.getWidth(), vexFwkBitmapHardware.getHeight(), Bitmap.Config.ARGB_8888);
                AutoCloseableKt.closeFinally(vexFwkBitmapHardware, null);
                Log.i(str, "imageEffectImpl X");
                return bitmapCropped;
            } finally {
            }
        } finally {
        }
    }

    private final VexFwkImageEffectParams convertToImageEffectParams(ImageEffect imageEffect, boolean applyNegativeSegMask) {
        if (imageEffect instanceof ImageEffect.GrayScale) {
            ImageEffect.GrayScale grayScale = (ImageEffect.GrayScale) imageEffect;
            return new VexFwkImageEffectParams(ImageEffectType.EFFECT_TYPE_GRAYSCALE, grayScale.getIntensity(), 0, 0, grayScale.getContrast(), grayScale.getGrain(), 0.0f, applyNegativeSegMask);
        }
        if (imageEffect instanceof ImageEffect.Blur) {
            return new VexFwkImageEffectParams(ImageEffectType.EFFECT_TYPE_BLUR, 0, 0, 0, 0, 0, ((ImageEffect.Blur) imageEffect).getRadius(), applyNegativeSegMask);
        }
        throw new NoWhenBranchMatchedException();
    }

    @JvmStatic
    @NotNull
    public static final VexFwkImageEffectCapabilities getSupportedFilters() {
        return INSTANCE.getSupportedFilters();
    }

    public static final boolean isAvailable() {
        return INSTANCE.isAvailable();
    }

    @NotNull
    public final CompletableFuture<Bitmap> applyEffect(@NotNull ImageEffect effect, @NotNull Image image, @NotNull SegMask inputMask, boolean isApplyBG) {
        Intrinsics.checkNotNullParameter(effect, "effect");
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(inputMask, "inputMask");
        return applyEffectImpl(effect, image, inputMask, isApplyBG);
    }

    @NotNull
    public final VexFwkImageEffectProcessor configure() {
        return (VexFwkImageEffectProcessor) configureWith(this, new Function1<VexFwkImageEffectProcessor, Unit>() { // from class: com.samsung.android.vexfwk.sdk.imageeffect.VexFwkImageEffectProcessor.configure.1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(VexFwkImageEffectProcessor vexFwkImageEffectProcessor) {
                invoke2(vexFwkImageEffectProcessor);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull VexFwkImageEffectProcessor configureWith) {
                Intrinsics.checkNotNullParameter(configureWith, "$this$configureWith");
                configureWith.createSession(VexFwkUsecase.IMAGE_EFFECT, new Function1<VexFwkSessionConfigRequest.Builder, Unit>() { // from class: com.samsung.android.vexfwk.sdk.imageeffect.VexFwkImageEffectProcessor.configure.1.1
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
    public final CompletableFuture<Bitmap> applyEffect(@NotNull ImageEffect effect, @NotNull Bitmap bitmap, @NotNull SegMask inputMask, boolean isApplyBG) {
        Intrinsics.checkNotNullParameter(effect, "effect");
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(inputMask, "inputMask");
        return applyEffectImpl(effect, bitmap, inputMask, isApplyBG);
    }

    @NotNull
    public final CompletableFuture<Bitmap> applyEffect(@NotNull ImageEffect effect, @NotNull Image image) {
        Intrinsics.checkNotNullParameter(effect, "effect");
        Intrinsics.checkNotNullParameter(image, "image");
        return applyEffectImpl(effect, image, null, false);
    }

    @NotNull
    public final CompletableFuture<Bitmap> applyEffect(@NotNull ImageEffect effect, @NotNull Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(effect, "effect");
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        return applyEffectImpl(effect, bitmap, null, false);
    }
}
