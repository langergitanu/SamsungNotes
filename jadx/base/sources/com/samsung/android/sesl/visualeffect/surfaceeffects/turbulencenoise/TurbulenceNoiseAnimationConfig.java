package com.samsung.android.sesl.visualeffect.surfaceeffects.turbulencenoise;

import android.graphics.BlendMode;
import androidx.annotation.RequiresApi;
import androidx.collection.AbstractC0622a;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.glance.AbstractC2821a;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@RequiresApi(29)
@Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b0\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 K2\u00020\u0001:\u0001KB½\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\tHÆ\u0003J\t\u00108\u001a\u00020\tHÆ\u0003J\t\u00109\u001a\u00020\tHÆ\u0003J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u0003HÆ\u0003J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\t\u0010>\u001a\u00020\u0003HÆ\u0003J\t\u0010?\u001a\u00020\u0003HÆ\u0003J\t\u0010@\u001a\u00020\u0013HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\t\u0010B\u001a\u00020\u0003HÆ\u0003J\t\u0010C\u001a\u00020\u0003HÆ\u0003J¿\u0001\u0010D\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u0003HÆ\u0001J\u0013\u0010E\u001a\u00020F2\b\u0010G\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010H\u001a\u00020\tHÖ\u0001J\t\u0010I\u001a\u00020JHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001bR\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b$\u0010!R\u0011\u0010\u000b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b%\u0010!R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001bR\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001bR\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001bR\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001bR\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001bR\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001bR\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0011\u0010\u0016\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001bR\u0011\u0010\u0017\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u001b¨\u0006L"}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/surfaceeffects/turbulencenoise/TurbulenceNoiseAnimationConfig;", "", "gridCount", "", "luminosityMultiplier", "noiseMoveSpeedX", "noiseMoveSpeedY", "noiseMoveSpeedZ", "color", "", "backgroundColor", "opacity", "width", "height", "maxDuration", "easeInDuration", "easeOutDuration", "pixelDensity", "blendMode", "Landroid/graphics/BlendMode;", "onAnimationEnd", "Ljava/lang/Runnable;", "lumaMatteBlendFactor", "lumaMatteOverallBrightness", "<init>", "(FFFFFIIIFFFFFFLandroid/graphics/BlendMode;Ljava/lang/Runnable;FF)V", "getGridCount", "()F", "getLuminosityMultiplier", "getNoiseMoveSpeedX", "getNoiseMoveSpeedY", "getNoiseMoveSpeedZ", "getColor", "()I", "setColor", "(I)V", "getBackgroundColor", "getOpacity", "getWidth", "getHeight", "getMaxDuration", "getEaseInDuration", "getEaseOutDuration", "getPixelDensity", "getBlendMode", "()Landroid/graphics/BlendMode;", "getOnAnimationEnd", "()Ljava/lang/Runnable;", "getLumaMatteBlendFactor", "getLumaMatteOverallBrightness", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "copy", "equals", "", "other", "hashCode", "toString", "", "Companion", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final /* data */ class TurbulenceNoiseAnimationConfig {
    public static final int DEFAULT_BACKGROUND_COLOR = -16777216;
    public static final int DEFAULT_COLOR = -1;
    public static final float DEFAULT_EASING_DURATION_IN_MILLIS = 750.0f;
    public static final float DEFAULT_LUMA_MATTE_BLEND_FACTOR = 1.0f;
    public static final float DEFAULT_LUMA_MATTE_OVERALL_BRIGHTNESS = 0.0f;
    public static final float DEFAULT_LUMINOSITY_MULTIPLIER = 1.0f;
    public static final float DEFAULT_MAX_DURATION_IN_MILLIS = 30000.0f;
    public static final float DEFAULT_NOISE_GRID_COUNT = 1.2f;
    public static final float DEFAULT_NOISE_SPEED_Z = 0.3f;
    public static final int DEFAULT_OPACITY = 150;
    private final int backgroundColor;

    @NotNull
    private final BlendMode blendMode;
    private int color;
    private final float easeInDuration;
    private final float easeOutDuration;
    private final float gridCount;
    private final float height;
    private final float lumaMatteBlendFactor;
    private final float lumaMatteOverallBrightness;
    private final float luminosityMultiplier;
    private final float maxDuration;
    private final float noiseMoveSpeedX;
    private final float noiseMoveSpeedY;
    private final float noiseMoveSpeedZ;

    @Nullable
    private final Runnable onAnimationEnd;
    private final int opacity;
    private final float pixelDensity;
    private final float width;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @RequiresApi(29)
    @NotNull
    private static final BlendMode DEFAULT_BLEND_MODE = BlendMode.SRC_OVER;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\u00020\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/surfaceeffects/turbulencenoise/TurbulenceNoiseAnimationConfig$Companion;", "", "<init>", "()V", "DEFAULT_MAX_DURATION_IN_MILLIS", "", "DEFAULT_EASING_DURATION_IN_MILLIS", "DEFAULT_LUMINOSITY_MULTIPLIER", "DEFAULT_NOISE_GRID_COUNT", "DEFAULT_NOISE_SPEED_Z", "DEFAULT_OPACITY", "", "DEFAULT_COLOR", "DEFAULT_LUMA_MATTE_BLEND_FACTOR", "DEFAULT_LUMA_MATTE_OVERALL_BRIGHTNESS", "DEFAULT_BACKGROUND_COLOR", "DEFAULT_BLEND_MODE", "Landroid/graphics/BlendMode;", "getDEFAULT_BLEND_MODE", "()Landroid/graphics/BlendMode;", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final BlendMode getDEFAULT_BLEND_MODE() {
            return TurbulenceNoiseAnimationConfig.DEFAULT_BLEND_MODE;
        }

        private Companion() {
        }
    }

    public TurbulenceNoiseAnimationConfig() {
        this(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, 0.0f, 0.0f, 262143, null);
    }

    public static /* synthetic */ TurbulenceNoiseAnimationConfig copy$default(TurbulenceNoiseAnimationConfig turbulenceNoiseAnimationConfig, float f, float f4, float f5, float f6, float f7, int i, int i2, int i4, float f8, float f9, float f10, float f11, float f12, float f13, BlendMode blendMode, Runnable runnable, float f14, float f15, int i5, Object obj) {
        float f16;
        float f17;
        float f18 = (i5 & 1) != 0 ? turbulenceNoiseAnimationConfig.gridCount : f;
        float f19 = (i5 & 2) != 0 ? turbulenceNoiseAnimationConfig.luminosityMultiplier : f4;
        float f20 = (i5 & 4) != 0 ? turbulenceNoiseAnimationConfig.noiseMoveSpeedX : f5;
        float f21 = (i5 & 8) != 0 ? turbulenceNoiseAnimationConfig.noiseMoveSpeedY : f6;
        float f22 = (i5 & 16) != 0 ? turbulenceNoiseAnimationConfig.noiseMoveSpeedZ : f7;
        int i6 = (i5 & 32) != 0 ? turbulenceNoiseAnimationConfig.color : i;
        int i7 = (i5 & 64) != 0 ? turbulenceNoiseAnimationConfig.backgroundColor : i2;
        int i8 = (i5 & 128) != 0 ? turbulenceNoiseAnimationConfig.opacity : i4;
        float f23 = (i5 & 256) != 0 ? turbulenceNoiseAnimationConfig.width : f8;
        float f24 = (i5 & 512) != 0 ? turbulenceNoiseAnimationConfig.height : f9;
        float f25 = (i5 & 1024) != 0 ? turbulenceNoiseAnimationConfig.maxDuration : f10;
        float f26 = (i5 & 2048) != 0 ? turbulenceNoiseAnimationConfig.easeInDuration : f11;
        float f27 = (i5 & 4096) != 0 ? turbulenceNoiseAnimationConfig.easeOutDuration : f12;
        float f28 = (i5 & 8192) != 0 ? turbulenceNoiseAnimationConfig.pixelDensity : f13;
        float f29 = f18;
        BlendMode blendMode2 = (i5 & 16384) != 0 ? turbulenceNoiseAnimationConfig.blendMode : blendMode;
        Runnable runnable2 = (i5 & 32768) != 0 ? turbulenceNoiseAnimationConfig.onAnimationEnd : runnable;
        float f30 = (i5 & 65536) != 0 ? turbulenceNoiseAnimationConfig.lumaMatteBlendFactor : f14;
        if ((i5 & 131072) != 0) {
            f17 = f30;
            f16 = turbulenceNoiseAnimationConfig.lumaMatteOverallBrightness;
        } else {
            f16 = f15;
            f17 = f30;
        }
        return turbulenceNoiseAnimationConfig.copy(f29, f19, f20, f21, f22, i6, i7, i8, f23, f24, f25, f26, f27, f28, blendMode2, runnable2, f17, f16);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final float getGridCount() {
        return this.gridCount;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final float getHeight() {
        return this.height;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final float getMaxDuration() {
        return this.maxDuration;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final float getEaseInDuration() {
        return this.easeInDuration;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final float getEaseOutDuration() {
        return this.easeOutDuration;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final float getPixelDensity() {
        return this.pixelDensity;
    }

    @NotNull
    /* JADX INFO: renamed from: component15, reason: from getter */
    public final BlendMode getBlendMode() {
        return this.blendMode;
    }

    @Nullable
    /* JADX INFO: renamed from: component16, reason: from getter */
    public final Runnable getOnAnimationEnd() {
        return this.onAnimationEnd;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final float getLumaMatteBlendFactor() {
        return this.lumaMatteBlendFactor;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final float getLumaMatteOverallBrightness() {
        return this.lumaMatteOverallBrightness;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final float getLuminosityMultiplier() {
        return this.luminosityMultiplier;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final float getNoiseMoveSpeedX() {
        return this.noiseMoveSpeedX;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final float getNoiseMoveSpeedY() {
        return this.noiseMoveSpeedY;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final float getNoiseMoveSpeedZ() {
        return this.noiseMoveSpeedZ;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getColor() {
        return this.color;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getBackgroundColor() {
        return this.backgroundColor;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final int getOpacity() {
        return this.opacity;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final float getWidth() {
        return this.width;
    }

    @NotNull
    public final TurbulenceNoiseAnimationConfig copy(float gridCount, float luminosityMultiplier, float noiseMoveSpeedX, float noiseMoveSpeedY, float noiseMoveSpeedZ, int color, int backgroundColor, int opacity, float width, float height, float maxDuration, float easeInDuration, float easeOutDuration, float pixelDensity, @NotNull BlendMode blendMode, @Nullable Runnable onAnimationEnd, float lumaMatteBlendFactor, float lumaMatteOverallBrightness) {
        Intrinsics.checkNotNullParameter(blendMode, "blendMode");
        return new TurbulenceNoiseAnimationConfig(gridCount, luminosityMultiplier, noiseMoveSpeedX, noiseMoveSpeedY, noiseMoveSpeedZ, color, backgroundColor, opacity, width, height, maxDuration, easeInDuration, easeOutDuration, pixelDensity, blendMode, onAnimationEnd, lumaMatteBlendFactor, lumaMatteOverallBrightness);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TurbulenceNoiseAnimationConfig)) {
            return false;
        }
        TurbulenceNoiseAnimationConfig turbulenceNoiseAnimationConfig = (TurbulenceNoiseAnimationConfig) other;
        return Float.compare(this.gridCount, turbulenceNoiseAnimationConfig.gridCount) == 0 && Float.compare(this.luminosityMultiplier, turbulenceNoiseAnimationConfig.luminosityMultiplier) == 0 && Float.compare(this.noiseMoveSpeedX, turbulenceNoiseAnimationConfig.noiseMoveSpeedX) == 0 && Float.compare(this.noiseMoveSpeedY, turbulenceNoiseAnimationConfig.noiseMoveSpeedY) == 0 && Float.compare(this.noiseMoveSpeedZ, turbulenceNoiseAnimationConfig.noiseMoveSpeedZ) == 0 && this.color == turbulenceNoiseAnimationConfig.color && this.backgroundColor == turbulenceNoiseAnimationConfig.backgroundColor && this.opacity == turbulenceNoiseAnimationConfig.opacity && Float.compare(this.width, turbulenceNoiseAnimationConfig.width) == 0 && Float.compare(this.height, turbulenceNoiseAnimationConfig.height) == 0 && Float.compare(this.maxDuration, turbulenceNoiseAnimationConfig.maxDuration) == 0 && Float.compare(this.easeInDuration, turbulenceNoiseAnimationConfig.easeInDuration) == 0 && Float.compare(this.easeOutDuration, turbulenceNoiseAnimationConfig.easeOutDuration) == 0 && Float.compare(this.pixelDensity, turbulenceNoiseAnimationConfig.pixelDensity) == 0 && this.blendMode == turbulenceNoiseAnimationConfig.blendMode && Intrinsics.areEqual(this.onAnimationEnd, turbulenceNoiseAnimationConfig.onAnimationEnd) && Float.compare(this.lumaMatteBlendFactor, turbulenceNoiseAnimationConfig.lumaMatteBlendFactor) == 0 && Float.compare(this.lumaMatteOverallBrightness, turbulenceNoiseAnimationConfig.lumaMatteOverallBrightness) == 0;
    }

    public final int getBackgroundColor() {
        return this.backgroundColor;
    }

    @NotNull
    public final BlendMode getBlendMode() {
        return this.blendMode;
    }

    public final int getColor() {
        return this.color;
    }

    public final float getEaseInDuration() {
        return this.easeInDuration;
    }

    public final float getEaseOutDuration() {
        return this.easeOutDuration;
    }

    public final float getGridCount() {
        return this.gridCount;
    }

    public final float getHeight() {
        return this.height;
    }

    public final float getLumaMatteBlendFactor() {
        return this.lumaMatteBlendFactor;
    }

    public final float getLumaMatteOverallBrightness() {
        return this.lumaMatteOverallBrightness;
    }

    public final float getLuminosityMultiplier() {
        return this.luminosityMultiplier;
    }

    public final float getMaxDuration() {
        return this.maxDuration;
    }

    public final float getNoiseMoveSpeedX() {
        return this.noiseMoveSpeedX;
    }

    public final float getNoiseMoveSpeedY() {
        return this.noiseMoveSpeedY;
    }

    public final float getNoiseMoveSpeedZ() {
        return this.noiseMoveSpeedZ;
    }

    @Nullable
    public final Runnable getOnAnimationEnd() {
        return this.onAnimationEnd;
    }

    public final int getOpacity() {
        return this.opacity;
    }

    public final float getPixelDensity() {
        return this.pixelDensity;
    }

    public final float getWidth() {
        return this.width;
    }

    public int hashCode() {
        int iHashCode = (this.blendMode.hashCode() + AbstractC0622a.m1156b(this.pixelDensity, AbstractC0622a.m1156b(this.easeOutDuration, AbstractC0622a.m1156b(this.easeInDuration, AbstractC0622a.m1156b(this.maxDuration, AbstractC0622a.m1156b(this.height, AbstractC0622a.m1156b(this.width, AbstractC0622a.m1157c(this.opacity, AbstractC0622a.m1157c(this.backgroundColor, AbstractC0622a.m1157c(this.color, AbstractC0622a.m1156b(this.noiseMoveSpeedZ, AbstractC0622a.m1156b(this.noiseMoveSpeedY, AbstractC0622a.m1156b(this.noiseMoveSpeedX, AbstractC0622a.m1156b(this.luminosityMultiplier, Float.hashCode(this.gridCount) * 31, 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31)) * 31;
        Runnable runnable = this.onAnimationEnd;
        return Float.hashCode(this.lumaMatteOverallBrightness) + AbstractC0622a.m1156b(this.lumaMatteBlendFactor, (iHashCode + (runnable == null ? 0 : runnable.hashCode())) * 31, 31);
    }

    public final void setColor(int i) {
        this.color = i;
    }

    @NotNull
    public String toString() {
        float f = this.gridCount;
        float f4 = this.luminosityMultiplier;
        float f5 = this.noiseMoveSpeedX;
        float f6 = this.noiseMoveSpeedY;
        float f7 = this.noiseMoveSpeedZ;
        int i = this.color;
        int i2 = this.backgroundColor;
        int i4 = this.opacity;
        float f8 = this.width;
        float f9 = this.height;
        float f10 = this.maxDuration;
        float f11 = this.easeInDuration;
        float f12 = this.easeOutDuration;
        float f13 = this.pixelDensity;
        BlendMode blendMode = this.blendMode;
        Runnable runnable = this.onAnimationEnd;
        float f14 = this.lumaMatteBlendFactor;
        float f15 = this.lumaMatteOverallBrightness;
        StringBuilder sbM1176v = AbstractC0622a.m1176v("TurbulenceNoiseAnimationConfig(gridCount=", f, ", luminosityMultiplier=", f4, ", noiseMoveSpeedX=");
        AbstractC11014a.m12337v(sbM1176v, f5, ", noiseMoveSpeedY=", f6, ", noiseMoveSpeedZ=");
        sbM1176v.append(f7);
        sbM1176v.append(", color=");
        sbM1176v.append(i);
        sbM1176v.append(", backgroundColor=");
        AbstractC2821a.m2235z(sbM1176v, i2, i4, ", opacity=", ", width=");
        AbstractC11014a.m12337v(sbM1176v, f8, ", height=", f9, ", maxDuration=");
        AbstractC11014a.m12337v(sbM1176v, f10, ", easeInDuration=", f11, ", easeOutDuration=");
        AbstractC11014a.m12337v(sbM1176v, f12, ", pixelDensity=", f13, ", blendMode=");
        sbM1176v.append(blendMode);
        sbM1176v.append(", onAnimationEnd=");
        sbM1176v.append(runnable);
        sbM1176v.append(", lumaMatteBlendFactor=");
        return AbstractC1038a.m1216q(sbM1176v, f14, ", lumaMatteOverallBrightness=", f15, ")");
    }

    public TurbulenceNoiseAnimationConfig(float f, float f4, float f5, float f6, float f7, int i, int i2, int i4, float f8, float f9, float f10, float f11, float f12, float f13, @NotNull BlendMode blendMode, @Nullable Runnable runnable, float f14, float f15) {
        Intrinsics.checkNotNullParameter(blendMode, "blendMode");
        this.gridCount = f;
        this.luminosityMultiplier = f4;
        this.noiseMoveSpeedX = f5;
        this.noiseMoveSpeedY = f6;
        this.noiseMoveSpeedZ = f7;
        this.color = i;
        this.backgroundColor = i2;
        this.opacity = i4;
        this.width = f8;
        this.height = f9;
        this.maxDuration = f10;
        this.easeInDuration = f11;
        this.easeOutDuration = f12;
        this.pixelDensity = f13;
        this.blendMode = blendMode;
        this.onAnimationEnd = runnable;
        this.lumaMatteBlendFactor = f14;
        this.lumaMatteOverallBrightness = f15;
    }

    public /* synthetic */ TurbulenceNoiseAnimationConfig(float f, float f4, float f5, float f6, float f7, int i, int i2, int i4, float f8, float f9, float f10, float f11, float f12, float f13, BlendMode blendMode, Runnable runnable, float f14, float f15, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? 1.2f : f, (i5 & 2) != 0 ? 1.0f : f4, (i5 & 4) != 0 ? 0.0f : f5, (i5 & 8) != 0 ? 0.0f : f6, (i5 & 16) != 0 ? 0.3f : f7, (i5 & 32) != 0 ? -1 : i, (i5 & 64) != 0 ? -16777216 : i2, (i5 & 128) != 0 ? 150 : i4, (i5 & 256) != 0 ? 0.0f : f8, (i5 & 512) != 0 ? 0.0f : f9, (i5 & 1024) != 0 ? 30000.0f : f10, (i5 & 2048) != 0 ? 750.0f : f11, (i5 & 4096) == 0 ? f12 : 750.0f, (i5 & 8192) != 0 ? 1.0f : f13, (i5 & 16384) != 0 ? DEFAULT_BLEND_MODE : blendMode, (i5 & 32768) != 0 ? null : runnable, (i5 & 65536) != 0 ? 1.0f : f14, (i5 & 131072) != 0 ? 0.0f : f15);
    }
}
