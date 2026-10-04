package com.samsung.android.sesl.visualeffect.surfaceeffects.ripple;

import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import androidx.annotation.RequiresApi;
import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.AbstractC1974b;
import com.samsung.android.sesl.visualeffect.lighteffects.radialgrad.WiggleAnimationConfig;
import com.samsung.android.sesl.visualeffect.surfaceeffects.ripple.RippleShader;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@RequiresApi(33)
@Metadata(m13885d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b?\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001Bá\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u001b\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0018¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010 J\t\u0010A\u001a\u00020\u0005HÆ\u0003J\t\u0010B\u001a\u00020\u0003HÆ\u0003J\t\u0010C\u001a\u00020\u0003HÆ\u0003J\t\u0010D\u001a\u00020\u0003HÆ\u0003J\t\u0010E\u001a\u00020\u0003HÆ\u0003J\t\u0010F\u001a\u00020\u0003HÆ\u0003J\t\u0010G\u001a\u00020\u0003HÆ\u0003J\t\u0010H\u001a\u00020\u0003HÆ\u0003J\t\u0010I\u001a\u00020\u0003HÆ\u0003J\t\u0010J\u001a\u00020\u000fHÆ\u0003J\t\u0010K\u001a\u00020\u000fHÆ\u0003J\t\u0010L\u001a\u00020\u000fHÆ\u0003J\t\u0010M\u001a\u00020\u0003HÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\t\u0010Q\u001a\u00020\u0018HÆ\u0003J\t\u0010R\u001a\u00020\u0018HÆ\u0003J\t\u0010S\u001a\u00020\u001bHÆ\u0003J\t\u0010T\u001a\u00020\u0018HÆ\u0003Jè\u0001\u0010U\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u0018HÆ\u0001¢\u0006\u0002\u0010VJ\u0013\u0010W\u001a\u00020\u00182\b\u0010X\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010Y\u001a\u00020\u000fHÖ\u0001J\t\u0010Z\u001a\u00020[HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010%R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010%R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010%R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010%R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010%R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010%R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010%R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001a\u0010\u0010\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010.\"\u0004\b2\u00100R\u0011\u0010\u0011\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b3\u0010.R\u001a\u0010\u0012\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010%\"\u0004\b5\u00106R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b9\u00108R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b:\u00108R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u0011\u0010\u0019\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010<R\u0011\u0010\u001a\u001a\u00020\u001b¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u0011\u0010\u001c\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b?\u0010<¨\u0006\\"}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/surfaceeffects/ripple/RippleAnimationConfig;", "", "requestedFrameRate", "", XmlErrorCodes.DURATION, "", "centerX", "centerY", "moveSpeedX", "moveSpeedY", WiggleAnimationConfig.KEY_SCALE, "maxWidth", "maxHeight", "pixelDensity", "color", "", "sparkleColor", "opacity", "sparkleStrength", "baseRingFadeParams", "Lcom/samsung/android/sesl/visualeffect/surfaceeffects/ripple/RippleShader$FadeParams;", "sparkleRingFadeParams", "centerFillFadeParams", "shouldDistort", "", "isReverse", "interpolator", "Landroid/view/animation/Interpolator;", "hintSparkleOnly", "<init>", "(Ljava/lang/Float;JFFFFFFFFIIIFLcom/samsung/android/sesl/visualeffect/surfaceeffects/ripple/RippleShader$FadeParams;Lcom/samsung/android/sesl/visualeffect/surfaceeffects/ripple/RippleShader$FadeParams;Lcom/samsung/android/sesl/visualeffect/surfaceeffects/ripple/RippleShader$FadeParams;ZZLandroid/view/animation/Interpolator;Z)V", "getRequestedFrameRate", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getDuration", "()J", "getCenterX", "()F", "getCenterY", "getMoveSpeedX", "getMoveSpeedY", "getScale", "getMaxWidth", "getMaxHeight", "getPixelDensity", "getColor", "()I", "setColor", "(I)V", "getSparkleColor", "setSparkleColor", "getOpacity", "getSparkleStrength", "setSparkleStrength", "(F)V", "getBaseRingFadeParams", "()Lcom/samsung/android/sesl/visualeffect/surfaceeffects/ripple/RippleShader$FadeParams;", "getSparkleRingFadeParams", "getCenterFillFadeParams", "getShouldDistort", "()Z", "getInterpolator", "()Landroid/view/animation/Interpolator;", "getHintSparkleOnly", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "copy", "(Ljava/lang/Float;JFFFFFFFFIIIFLcom/samsung/android/sesl/visualeffect/surfaceeffects/ripple/RippleShader$FadeParams;Lcom/samsung/android/sesl/visualeffect/surfaceeffects/ripple/RippleShader$FadeParams;Lcom/samsung/android/sesl/visualeffect/surfaceeffects/ripple/RippleShader$FadeParams;ZZLandroid/view/animation/Interpolator;Z)Lcom/samsung/android/sesl/visualeffect/surfaceeffects/ripple/RippleAnimationConfig;", "equals", "other", "hashCode", "toString", "", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final /* data */ class RippleAnimationConfig {

    @Nullable
    private final RippleShader.FadeParams baseRingFadeParams;

    @Nullable
    private final RippleShader.FadeParams centerFillFadeParams;
    private final float centerX;
    private final float centerY;
    private int color;
    private final long duration;
    private final boolean hintSparkleOnly;

    @NotNull
    private final Interpolator interpolator;
    private final boolean isReverse;
    private final float maxHeight;
    private final float maxWidth;
    private final float moveSpeedX;
    private final float moveSpeedY;
    private final int opacity;
    private final float pixelDensity;

    @Nullable
    private final Float requestedFrameRate;
    private final float scale;
    private final boolean shouldDistort;
    private int sparkleColor;

    @Nullable
    private final RippleShader.FadeParams sparkleRingFadeParams;
    private float sparkleStrength;

    public RippleAnimationConfig() {
        this(null, 0L, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0, 0, 0.0f, null, null, null, false, false, null, false, 2097151, null);
    }

    public static /* synthetic */ RippleAnimationConfig copy$default(RippleAnimationConfig rippleAnimationConfig, Float f, long j, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, int i, int i2, int i4, float f12, RippleShader.FadeParams fadeParams, RippleShader.FadeParams fadeParams2, RippleShader.FadeParams fadeParams3, boolean z, boolean z2, Interpolator interpolator, boolean z3, int i5, Object obj) {
        boolean z4;
        Interpolator interpolator2;
        Float f13 = (i5 & 1) != 0 ? rippleAnimationConfig.requestedFrameRate : f;
        long j2 = (i5 & 2) != 0 ? rippleAnimationConfig.duration : j;
        float f14 = (i5 & 4) != 0 ? rippleAnimationConfig.centerX : f4;
        float f15 = (i5 & 8) != 0 ? rippleAnimationConfig.centerY : f5;
        float f16 = (i5 & 16) != 0 ? rippleAnimationConfig.moveSpeedX : f6;
        float f17 = (i5 & 32) != 0 ? rippleAnimationConfig.moveSpeedY : f7;
        float f18 = (i5 & 64) != 0 ? rippleAnimationConfig.scale : f8;
        float f19 = (i5 & 128) != 0 ? rippleAnimationConfig.maxWidth : f9;
        float f20 = (i5 & 256) != 0 ? rippleAnimationConfig.maxHeight : f10;
        float f21 = (i5 & 512) != 0 ? rippleAnimationConfig.pixelDensity : f11;
        int i6 = (i5 & 1024) != 0 ? rippleAnimationConfig.color : i;
        int i7 = (i5 & 2048) != 0 ? rippleAnimationConfig.sparkleColor : i2;
        int i8 = (i5 & 4096) != 0 ? rippleAnimationConfig.opacity : i4;
        Float f22 = f13;
        float f23 = (i5 & 8192) != 0 ? rippleAnimationConfig.sparkleStrength : f12;
        RippleShader.FadeParams fadeParams4 = (i5 & 16384) != 0 ? rippleAnimationConfig.baseRingFadeParams : fadeParams;
        RippleShader.FadeParams fadeParams5 = (i5 & 32768) != 0 ? rippleAnimationConfig.sparkleRingFadeParams : fadeParams2;
        RippleShader.FadeParams fadeParams6 = (i5 & 65536) != 0 ? rippleAnimationConfig.centerFillFadeParams : fadeParams3;
        boolean z5 = (i5 & 131072) != 0 ? rippleAnimationConfig.shouldDistort : z;
        boolean z6 = (i5 & 262144) != 0 ? rippleAnimationConfig.isReverse : z2;
        Interpolator interpolator3 = (i5 & 524288) != 0 ? rippleAnimationConfig.interpolator : interpolator;
        if ((i5 & 1048576) != 0) {
            interpolator2 = interpolator3;
            z4 = rippleAnimationConfig.hintSparkleOnly;
        } else {
            z4 = z3;
            interpolator2 = interpolator3;
        }
        return rippleAnimationConfig.copy(f22, j2, f14, f15, f16, f17, f18, f19, f20, f21, i6, i7, i8, f23, fadeParams4, fadeParams5, fadeParams6, z5, z6, interpolator2, z4);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Float getRequestedFrameRate() {
        return this.requestedFrameRate;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final float getPixelDensity() {
        return this.pixelDensity;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final int getColor() {
        return this.color;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final int getSparkleColor() {
        return this.sparkleColor;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final int getOpacity() {
        return this.opacity;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final float getSparkleStrength() {
        return this.sparkleStrength;
    }

    @Nullable
    /* JADX INFO: renamed from: component15, reason: from getter */
    public final RippleShader.FadeParams getBaseRingFadeParams() {
        return this.baseRingFadeParams;
    }

    @Nullable
    /* JADX INFO: renamed from: component16, reason: from getter */
    public final RippleShader.FadeParams getSparkleRingFadeParams() {
        return this.sparkleRingFadeParams;
    }

    @Nullable
    /* JADX INFO: renamed from: component17, reason: from getter */
    public final RippleShader.FadeParams getCenterFillFadeParams() {
        return this.centerFillFadeParams;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final boolean getShouldDistort() {
        return this.shouldDistort;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final boolean getIsReverse() {
        return this.isReverse;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getDuration() {
        return this.duration;
    }

    @NotNull
    /* JADX INFO: renamed from: component20, reason: from getter */
    public final Interpolator getInterpolator() {
        return this.interpolator;
    }

    /* JADX INFO: renamed from: component21, reason: from getter */
    public final boolean getHintSparkleOnly() {
        return this.hintSparkleOnly;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final float getCenterX() {
        return this.centerX;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final float getCenterY() {
        return this.centerY;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final float getMoveSpeedX() {
        return this.moveSpeedX;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final float getMoveSpeedY() {
        return this.moveSpeedY;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final float getScale() {
        return this.scale;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final float getMaxWidth() {
        return this.maxWidth;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final float getMaxHeight() {
        return this.maxHeight;
    }

    @NotNull
    public final RippleAnimationConfig copy(@Nullable Float requestedFrameRate, long duration, float centerX, float centerY, float moveSpeedX, float moveSpeedY, float scale, float maxWidth, float maxHeight, float pixelDensity, int color, int sparkleColor, int opacity, float sparkleStrength, @Nullable RippleShader.FadeParams baseRingFadeParams, @Nullable RippleShader.FadeParams sparkleRingFadeParams, @Nullable RippleShader.FadeParams centerFillFadeParams, boolean shouldDistort, boolean isReverse, @NotNull Interpolator interpolator, boolean hintSparkleOnly) {
        Intrinsics.checkNotNullParameter(interpolator, "interpolator");
        return new RippleAnimationConfig(requestedFrameRate, duration, centerX, centerY, moveSpeedX, moveSpeedY, scale, maxWidth, maxHeight, pixelDensity, color, sparkleColor, opacity, sparkleStrength, baseRingFadeParams, sparkleRingFadeParams, centerFillFadeParams, shouldDistort, isReverse, interpolator, hintSparkleOnly);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RippleAnimationConfig)) {
            return false;
        }
        RippleAnimationConfig rippleAnimationConfig = (RippleAnimationConfig) other;
        return Intrinsics.areEqual((Object) this.requestedFrameRate, (Object) rippleAnimationConfig.requestedFrameRate) && this.duration == rippleAnimationConfig.duration && Float.compare(this.centerX, rippleAnimationConfig.centerX) == 0 && Float.compare(this.centerY, rippleAnimationConfig.centerY) == 0 && Float.compare(this.moveSpeedX, rippleAnimationConfig.moveSpeedX) == 0 && Float.compare(this.moveSpeedY, rippleAnimationConfig.moveSpeedY) == 0 && Float.compare(this.scale, rippleAnimationConfig.scale) == 0 && Float.compare(this.maxWidth, rippleAnimationConfig.maxWidth) == 0 && Float.compare(this.maxHeight, rippleAnimationConfig.maxHeight) == 0 && Float.compare(this.pixelDensity, rippleAnimationConfig.pixelDensity) == 0 && this.color == rippleAnimationConfig.color && this.sparkleColor == rippleAnimationConfig.sparkleColor && this.opacity == rippleAnimationConfig.opacity && Float.compare(this.sparkleStrength, rippleAnimationConfig.sparkleStrength) == 0 && Intrinsics.areEqual(this.baseRingFadeParams, rippleAnimationConfig.baseRingFadeParams) && Intrinsics.areEqual(this.sparkleRingFadeParams, rippleAnimationConfig.sparkleRingFadeParams) && Intrinsics.areEqual(this.centerFillFadeParams, rippleAnimationConfig.centerFillFadeParams) && this.shouldDistort == rippleAnimationConfig.shouldDistort && this.isReverse == rippleAnimationConfig.isReverse && Intrinsics.areEqual(this.interpolator, rippleAnimationConfig.interpolator) && this.hintSparkleOnly == rippleAnimationConfig.hintSparkleOnly;
    }

    @Nullable
    public final RippleShader.FadeParams getBaseRingFadeParams() {
        return this.baseRingFadeParams;
    }

    @Nullable
    public final RippleShader.FadeParams getCenterFillFadeParams() {
        return this.centerFillFadeParams;
    }

    public final float getCenterX() {
        return this.centerX;
    }

    public final float getCenterY() {
        return this.centerY;
    }

    public final int getColor() {
        return this.color;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final boolean getHintSparkleOnly() {
        return this.hintSparkleOnly;
    }

    @NotNull
    public final Interpolator getInterpolator() {
        return this.interpolator;
    }

    public final float getMaxHeight() {
        return this.maxHeight;
    }

    public final float getMaxWidth() {
        return this.maxWidth;
    }

    public final float getMoveSpeedX() {
        return this.moveSpeedX;
    }

    public final float getMoveSpeedY() {
        return this.moveSpeedY;
    }

    public final int getOpacity() {
        return this.opacity;
    }

    public final float getPixelDensity() {
        return this.pixelDensity;
    }

    @Nullable
    public final Float getRequestedFrameRate() {
        return this.requestedFrameRate;
    }

    public final float getScale() {
        return this.scale;
    }

    public final boolean getShouldDistort() {
        return this.shouldDistort;
    }

    public final int getSparkleColor() {
        return this.sparkleColor;
    }

    @Nullable
    public final RippleShader.FadeParams getSparkleRingFadeParams() {
        return this.sparkleRingFadeParams;
    }

    public final float getSparkleStrength() {
        return this.sparkleStrength;
    }

    public int hashCode() {
        Float f = this.requestedFrameRate;
        int iM1156b = AbstractC0622a.m1156b(this.sparkleStrength, AbstractC0622a.m1157c(this.opacity, AbstractC0622a.m1157c(this.sparkleColor, AbstractC0622a.m1157c(this.color, AbstractC0622a.m1156b(this.pixelDensity, AbstractC0622a.m1156b(this.maxHeight, AbstractC0622a.m1156b(this.maxWidth, AbstractC0622a.m1156b(this.scale, AbstractC0622a.m1156b(this.moveSpeedY, AbstractC0622a.m1156b(this.moveSpeedX, AbstractC0622a.m1156b(this.centerY, AbstractC0622a.m1156b(this.centerX, AbstractC1974b.m1311d(this.duration, (f == null ? 0 : f.hashCode()) * 31, 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31);
        RippleShader.FadeParams fadeParams = this.baseRingFadeParams;
        int iHashCode = (iM1156b + (fadeParams == null ? 0 : fadeParams.hashCode())) * 31;
        RippleShader.FadeParams fadeParams2 = this.sparkleRingFadeParams;
        int iHashCode2 = (iHashCode + (fadeParams2 == null ? 0 : fadeParams2.hashCode())) * 31;
        RippleShader.FadeParams fadeParams3 = this.centerFillFadeParams;
        return Boolean.hashCode(this.hintSparkleOnly) + ((this.interpolator.hashCode() + AbstractC0622a.m1160f(this.isReverse, AbstractC0622a.m1160f(this.shouldDistort, (iHashCode2 + (fadeParams3 != null ? fadeParams3.hashCode() : 0)) * 31, 31), 31)) * 31);
    }

    public final boolean isReverse() {
        return this.isReverse;
    }

    public final void setColor(int i) {
        this.color = i;
    }

    public final void setSparkleColor(int i) {
        this.sparkleColor = i;
    }

    public final void setSparkleStrength(float f) {
        this.sparkleStrength = f;
    }

    @NotNull
    public String toString() {
        Float f = this.requestedFrameRate;
        long j = this.duration;
        float f4 = this.centerX;
        float f5 = this.centerY;
        float f6 = this.moveSpeedX;
        float f7 = this.moveSpeedY;
        float f8 = this.scale;
        float f9 = this.maxWidth;
        float f10 = this.maxHeight;
        float f11 = this.pixelDensity;
        int i = this.color;
        int i2 = this.sparkleColor;
        int i4 = this.opacity;
        float f12 = this.sparkleStrength;
        RippleShader.FadeParams fadeParams = this.baseRingFadeParams;
        RippleShader.FadeParams fadeParams2 = this.sparkleRingFadeParams;
        RippleShader.FadeParams fadeParams3 = this.centerFillFadeParams;
        boolean z = this.shouldDistort;
        boolean z2 = this.isReverse;
        Interpolator interpolator = this.interpolator;
        boolean z3 = this.hintSparkleOnly;
        StringBuilder sb = new StringBuilder("RippleAnimationConfig(requestedFrameRate=");
        sb.append(f);
        sb.append(", duration=");
        sb.append(j);
        sb.append(", centerX=");
        sb.append(f4);
        sb.append(", centerY=");
        sb.append(f5);
        sb.append(", moveSpeedX=");
        sb.append(f6);
        sb.append(", moveSpeedY=");
        sb.append(f7);
        sb.append(", scale=");
        sb.append(f8);
        sb.append(", maxWidth=");
        sb.append(f9);
        sb.append(", maxHeight=");
        sb.append(f10);
        sb.append(", pixelDensity=");
        sb.append(f11);
        AbstractC0622a.m1180z(sb, i, i2, ", color=", ", sparkleColor=");
        sb.append(", opacity=");
        sb.append(i4);
        sb.append(", sparkleStrength=");
        sb.append(f12);
        sb.append(", baseRingFadeParams=");
        sb.append(fadeParams);
        sb.append(", sparkleRingFadeParams=");
        sb.append(fadeParams2);
        sb.append(", centerFillFadeParams=");
        sb.append(fadeParams3);
        sb.append(", shouldDistort=");
        sb.append(z);
        sb.append(", isReverse=");
        sb.append(z2);
        sb.append(", interpolator=");
        sb.append(interpolator);
        sb.append(", hintSparkleOnly=");
        sb.append(z3);
        sb.append(")");
        return sb.toString();
    }

    public RippleAnimationConfig(@Nullable Float f, long j, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, int i, int i2, int i4, float f12, @Nullable RippleShader.FadeParams fadeParams, @Nullable RippleShader.FadeParams fadeParams2, @Nullable RippleShader.FadeParams fadeParams3, boolean z, boolean z2, @NotNull Interpolator interpolator, boolean z3) {
        Intrinsics.checkNotNullParameter(interpolator, "interpolator");
        this.requestedFrameRate = f;
        this.duration = j;
        this.centerX = f4;
        this.centerY = f5;
        this.moveSpeedX = f6;
        this.moveSpeedY = f7;
        this.scale = f8;
        this.maxWidth = f9;
        this.maxHeight = f10;
        this.pixelDensity = f11;
        this.color = i;
        this.sparkleColor = i2;
        this.opacity = i4;
        this.sparkleStrength = f12;
        this.baseRingFadeParams = fadeParams;
        this.sparkleRingFadeParams = fadeParams2;
        this.centerFillFadeParams = fadeParams3;
        this.shouldDistort = z;
        this.isReverse = z2;
        this.interpolator = interpolator;
        this.hintSparkleOnly = z3;
    }

    public /* synthetic */ RippleAnimationConfig(Float f, long j, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, int i, int i2, int i4, float f12, RippleShader.FadeParams fadeParams, RippleShader.FadeParams fadeParams2, RippleShader.FadeParams fadeParams3, boolean z, boolean z2, Interpolator interpolator, boolean z3, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        Float f13;
        int i6;
        long j2;
        Interpolator pathInterpolator;
        Float f14 = (i5 & 1) != 0 ? null : f;
        long j3 = (i5 & 2) != 0 ? 0L : j;
        float f15 = (i5 & 4) != 0 ? 0.0f : f4;
        float f16 = (i5 & 8) != 0 ? 0.0f : f5;
        float f17 = (i5 & 16) != 0 ? 0.0f : f6;
        float f18 = (i5 & 32) != 0 ? 0.0f : f7;
        float f19 = (i5 & 64) != 0 ? 1.0f : f8;
        float f20 = (i5 & 128) != 0 ? 0.0f : f9;
        float f21 = (i5 & 256) != 0 ? 0.0f : f10;
        float f22 = (i5 & 512) != 0 ? 1.0f : f11;
        int i7 = (i5 & 1024) != 0 ? -1 : i;
        int i8 = (i5 & 2048) == 0 ? i2 : -1;
        int i9 = (i5 & 4096) != 0 ? 115 : i4;
        float f23 = (i5 & 8192) != 0 ? 0.3f : f12;
        RippleShader.FadeParams fadeParams4 = (i5 & 16384) != 0 ? null : fadeParams;
        RippleShader.FadeParams fadeParams5 = (i5 & 32768) != 0 ? null : fadeParams2;
        RippleShader.FadeParams fadeParams6 = (i5 & 65536) != 0 ? null : fadeParams3;
        boolean z4 = (i5 & 131072) != 0 ? true : z;
        boolean z5 = (i5 & 262144) != 0 ? false : z2;
        if ((i5 & 524288) != 0) {
            f13 = f14;
            i6 = i9;
            j2 = j3;
            pathInterpolator = new PathInterpolator(0.2f, 0.0f, 0.0f, 1.0f);
        } else {
            f13 = f14;
            i6 = i9;
            j2 = j3;
            pathInterpolator = interpolator;
        }
        this(f13, j2, f15, f16, f17, f18, f19, f20, f21, f22, i7, i8, i6, f23, fadeParams4, fadeParams5, fadeParams6, z4, z5, pathInterpolator, (i5 & 1048576) != 0 ? false : z3);
    }
}
