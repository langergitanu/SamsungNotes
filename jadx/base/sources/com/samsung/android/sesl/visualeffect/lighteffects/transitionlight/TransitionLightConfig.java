package com.samsung.android.sesl.visualeffect.lighteffects.transitionlight;

import android.animation.Animator;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.util.Log;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import androidx.annotation.RequiresApi;
import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.AbstractC1974b;
import com.samsung.android.sesl.visualeffect.lighteffects.common.config.AnimatableAttribute;
import com.samsung.android.sesl.visualeffect.lighteffects.common.config.BaseVibeEffectConfig;
import com.samsung.android.sesl.visualeffect.lighteffects.common.control.VibeEffectControl;
import com.samsung.android.sesl.visualeffect.lighteffects.transitionlight.TransitionLightRenderEffect;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@RequiresApi(33)
@Metadata(m13885d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b9\n\u0002\u0010\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087\b\u0018\u0000 o2\u00020\u0001:\u0003opqB·\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b\u0012\b\b\u0002\u0010\f\u001a\u00020\b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\b\u0012\b\b\u0002\u0010\u0012\u001a\u00020\b\u0012\b\b\u0002\u0010\u0013\u001a\u00020\b\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0019\u0012\b\b\u0002\u0010\u001a\u001a\u00020\b¢\u0006\u0004\b\u001b\u0010\u001cJ\u0014\u0010O\u001a\u00020\u0006*\u00020\u00062\u0006\u0010P\u001a\u00020\u0006H\u0002J\u0014\u0010Q\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0011\u001a\u00020\bH\u0002J\r\u0010R\u001a\u00020SH\u0000¢\u0006\u0002\bTJ\u000b\u0010U\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010W\u001a\u00020\u0006HÆ\u0003J\t\u0010X\u001a\u00020\bHÆ\u0003J\t\u0010Y\u001a\u00020\bHÆ\u0003J\t\u0010Z\u001a\u00020\bHÆ\u0003J\t\u0010[\u001a\u00020\bHÆ\u0003J\t\u0010\\\u001a\u00020\bHÆ\u0003J\t\u0010]\u001a\u00020\u000eHÆ\u0003J\t\u0010^\u001a\u00020\u0010HÆ\u0003J\t\u0010_\u001a\u00020\bHÆ\u0003J\t\u0010`\u001a\u00020\bHÆ\u0003J\t\u0010a\u001a\u00020\bHÆ\u0003J\t\u0010b\u001a\u00020\u0015HÆ\u0003J\u000b\u0010c\u001a\u0004\u0018\u00010\u0017HÆ\u0003J\t\u0010d\u001a\u00020\u0019HÆ\u0003J\t\u0010e\u001a\u00020\bHÆ\u0003J¹\u0001\u0010f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010\u0013\u001a\u00020\b2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\bHÆ\u0001J\u0013\u0010g\u001a\u00020h2\b\u0010i\u001a\u0004\u0018\u00010jHÖ\u0003J\t\u0010k\u001a\u00020lHÖ\u0001J\t\u0010m\u001a\u00020nHÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001e\"\u0004\b\"\u0010 R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010\t\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010(\"\u0004\b,\u0010*R\u001a\u0010\n\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010(\"\u0004\b.\u0010*R\u001a\u0010\u000b\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010(\"\u0004\b0\u0010*R\u001a\u0010\f\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010(\"\u0004\b2\u0010*R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001a\u0010\u0011\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010(\"\u0004\b<\u0010*R\u001a\u0010\u0012\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010(\"\u0004\b>\u0010*R\u001a\u0010\u0013\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010(\"\u0004\b@\u0010*R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u001a\u0010\u001a\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010(\"\u0004\bN\u0010*¨\u0006r"}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/lighteffects/transitionlight/TransitionLightConfig;", "Lcom/samsung/android/sesl/visualeffect/lighteffects/common/config/BaseVibeEffectConfig;", "imageBitmap", "Landroid/graphics/Bitmap;", "transMap", "transPos", "Landroid/graphics/PointF;", "transAlpha", "", "transScale", "tintIntensity", "tintSaturation", "ditherVariation", "revealMode", "Lcom/samsung/android/sesl/visualeffect/lighteffects/transitionlight/TransitionLightConfig$RevealMode;", "durationInMillis", "", "angle", "frameRate", "lightStretch", "scaleType", "Lcom/samsung/android/sesl/visualeffect/lighteffects/transitionlight/TransitionLightConfig$ScaleType;", "onAnimationEndListener", "Ljava/lang/Runnable;", "scaleInterpolator", "Landroid/view/animation/Interpolator;", "maxScale", "<init>", "(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;Landroid/graphics/PointF;FFFFFLcom/samsung/android/sesl/visualeffect/lighteffects/transitionlight/TransitionLightConfig$RevealMode;JFFFLcom/samsung/android/sesl/visualeffect/lighteffects/transitionlight/TransitionLightConfig$ScaleType;Ljava/lang/Runnable;Landroid/view/animation/Interpolator;F)V", "getImageBitmap", "()Landroid/graphics/Bitmap;", "setImageBitmap", "(Landroid/graphics/Bitmap;)V", "getTransMap", "setTransMap", "getTransPos", "()Landroid/graphics/PointF;", "setTransPos", "(Landroid/graphics/PointF;)V", "getTransAlpha", "()F", "setTransAlpha", "(F)V", "getTransScale", "setTransScale", "getTintIntensity", "setTintIntensity", "getTintSaturation", "setTintSaturation", "getDitherVariation", "setDitherVariation", "getRevealMode", "()Lcom/samsung/android/sesl/visualeffect/lighteffects/transitionlight/TransitionLightConfig$RevealMode;", "setRevealMode", "(Lcom/samsung/android/sesl/visualeffect/lighteffects/transitionlight/TransitionLightConfig$RevealMode;)V", "getDurationInMillis", "()J", "setDurationInMillis", "(J)V", "getAngle", "setAngle", "getFrameRate", "setFrameRate", "getLightStretch", "setLightStretch", "getScaleType", "()Lcom/samsung/android/sesl/visualeffect/lighteffects/transitionlight/TransitionLightConfig$ScaleType;", "setScaleType", "(Lcom/samsung/android/sesl/visualeffect/lighteffects/transitionlight/TransitionLightConfig$ScaleType;)V", "getOnAnimationEndListener", "()Ljava/lang/Runnable;", "setOnAnimationEndListener", "(Ljava/lang/Runnable;)V", "getScaleInterpolator", "()Landroid/view/animation/Interpolator;", "setScaleInterpolator", "(Landroid/view/animation/Interpolator;)V", "getMaxScale", "setMaxScale", "minus", "p", "getRotated", "buildAnimationAttribute", "", "buildAnimationAttribute$sesl_visualeffect_INTERNAL_2_1_10_release", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "Companion", "RevealMode", "ScaleType", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final /* data */ class TransitionLightConfig extends BaseVibeEffectConfig {
    public static final float ANGLE = 84.0f;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    public static final long DURATION = 2350;

    @NotNull
    public static final String TAG = "TransitionLightConfig";

    @NotNull
    private static final TransitionLightConfig VI_CONFIG_BITMAP;

    @NotNull
    private static final TransitionLightConfig VI_CONFIG_DEFAULT;

    @NotNull
    private static final TransitionLightConfig VI_CONFIG_VIEW;
    private float angle;
    private float ditherVariation;
    private long durationInMillis;
    private float frameRate;

    @Nullable
    private Bitmap imageBitmap;
    private float lightStretch;
    private float maxScale;

    @Nullable
    private Runnable onAnimationEndListener;

    @NotNull
    private RevealMode revealMode;

    @NotNull
    private Interpolator scaleInterpolator;

    @NotNull
    private ScaleType scaleType;
    private float tintIntensity;
    private float tintSaturation;
    private float transAlpha;

    @Nullable
    private Bitmap transMap;

    @NotNull
    private PointF transPos;
    private float transScale;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\tR\u000e\u0010\u000e\u001a\u00020\u000fX\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/lighteffects/transitionlight/TransitionLightConfig$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "VI_CONFIG_DEFAULT", "Lcom/samsung/android/sesl/visualeffect/lighteffects/transitionlight/TransitionLightConfig;", "getVI_CONFIG_DEFAULT", "()Lcom/samsung/android/sesl/visualeffect/lighteffects/transitionlight/TransitionLightConfig;", "VI_CONFIG_VIEW", "getVI_CONFIG_VIEW", "VI_CONFIG_BITMAP", "getVI_CONFIG_BITMAP", "DURATION", "", "ANGLE", "", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final TransitionLightConfig getVI_CONFIG_BITMAP() {
            return TransitionLightConfig.VI_CONFIG_BITMAP;
        }

        @NotNull
        public final TransitionLightConfig getVI_CONFIG_DEFAULT() {
            return TransitionLightConfig.VI_CONFIG_DEFAULT;
        }

        @NotNull
        public final TransitionLightConfig getVI_CONFIG_VIEW() {
            return TransitionLightConfig.VI_CONFIG_VIEW;
        }

        private Companion() {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/lighteffects/transitionlight/TransitionLightConfig$RevealMode;", "", "<init>", "(Ljava/lang/String;I)V", "BITMAP", "VIEW", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class RevealMode {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ RevealMode[] $VALUES;
        public static final RevealMode BITMAP = new RevealMode("BITMAP", 0);
        public static final RevealMode VIEW = new RevealMode("VIEW", 1);

        private static final /* synthetic */ RevealMode[] $values() {
            return new RevealMode[]{BITMAP, VIEW};
        }

        static {
            RevealMode[] revealModeArr$values = $values();
            $VALUES = revealModeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(revealModeArr$values);
        }

        private RevealMode(String str, int i) {
        }

        @NotNull
        public static EnumEntries<RevealMode> getEntries() {
            return $ENTRIES;
        }

        public static RevealMode valueOf(String str) {
            return (RevealMode) Enum.valueOf(RevealMode.class, str);
        }

        public static RevealMode[] values() {
            return (RevealMode[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/lighteffects/transitionlight/TransitionLightConfig$ScaleType;", "", "<init>", "(Ljava/lang/String;I)V", "FIT_XY", "FIT_CENTER", "CENTER_CROP", "CENTER_INSIDE", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class ScaleType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ScaleType[] $VALUES;
        public static final ScaleType FIT_XY = new ScaleType("FIT_XY", 0);
        public static final ScaleType FIT_CENTER = new ScaleType("FIT_CENTER", 1);
        public static final ScaleType CENTER_CROP = new ScaleType("CENTER_CROP", 2);
        public static final ScaleType CENTER_INSIDE = new ScaleType("CENTER_INSIDE", 3);

        private static final /* synthetic */ ScaleType[] $values() {
            return new ScaleType[]{FIT_XY, FIT_CENTER, CENTER_CROP, CENTER_INSIDE};
        }

        static {
            ScaleType[] scaleTypeArr$values = $values();
            $VALUES = scaleTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(scaleTypeArr$values);
        }

        private ScaleType(String str, int i) {
        }

        @NotNull
        public static EnumEntries<ScaleType> getEntries() {
            return $ENTRIES;
        }

        public static ScaleType valueOf(String str) {
            return (ScaleType) Enum.valueOf(ScaleType.class, str);
        }

        public static ScaleType[] values() {
            return (ScaleType[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        Bitmap bitmap = null;
        float f = 0.0f;
        float f4 = 0.0f;
        float f5 = 0.0f;
        float f6 = 0.0f;
        float f7 = 0.0f;
        float f8 = 0.0f;
        VI_CONFIG_DEFAULT = new TransitionLightConfig(null, bitmap, null, 0.0f, f, f4, f5, f6, null, 0L, 0.0f, f7, f8, null, null, null, 0.0f, 131071, null);
        float f9 = 0.0f;
        float f10 = 0.0f;
        TransitionLightConfig transitionLightConfig = new TransitionLightConfig(bitmap, 0 == true ? 1 : 0, null, f, f4, f5, f6, f9, null, 0L, f7, f8, f10, 0 == true ? 1 : 0, 0 == true ? 1 : 0, null, 0.0f, 131071, null);
        transitionLightConfig.revealMode = RevealMode.VIEW;
        VI_CONFIG_VIEW = transitionLightConfig;
        Object[] objArr = 0 == true ? 1 : 0;
        Object[] objArr2 = 0 == true ? 1 : 0;
        TransitionLightConfig transitionLightConfig2 = new TransitionLightConfig(objArr, 0 == true ? 1 : 0, null, f4, f5, f6, f9, 0.0f, null, 0L, f8, f10, 0.0f, objArr2, 0 == true ? 1 : 0, null, 0.0f, 131071, null);
        transitionLightConfig2.revealMode = RevealMode.BITMAP;
        VI_CONFIG_BITMAP = transitionLightConfig2;
    }

    public TransitionLightConfig() {
        this(null, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, 0L, 0.0f, 0.0f, 0.0f, null, null, null, 0.0f, 131071, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit buildAnimationAttribute$lambda$1(TransitionLightConfig transitionLightConfig, PointF pointF, VibeEffectControl vibeEffectControl, float f, float f4) {
        TransitionLightControl transitionLightControl = vibeEffectControl instanceof TransitionLightControl ? (TransitionLightControl) vibeEffectControl : null;
        if (transitionLightControl != null) {
            transitionLightControl.setProgress(f);
            transitionLightControl.setTransAlpha(RangesKt.coerceAtMost(f4, 1.0f));
            transitionLightControl.setTransScale(transitionLightConfig.scaleInterpolator.getInterpolation(f) * transitionLightConfig.maxScale);
            transitionLightControl.setTransPosition(pointF);
            transitionLightControl.setRevealMode(transitionLightConfig.revealMode);
        }
        return Unit.INSTANCE;
    }

    public static /* synthetic */ TransitionLightConfig copy$default(TransitionLightConfig transitionLightConfig, Bitmap bitmap, Bitmap bitmap2, PointF pointF, float f, float f4, float f5, float f6, float f7, RevealMode revealMode, long j, float f8, float f9, float f10, ScaleType scaleType, Runnable runnable, Interpolator interpolator, float f11, int i, Object obj) {
        float f12;
        Interpolator interpolator2;
        Bitmap bitmap3 = (i & 1) != 0 ? transitionLightConfig.imageBitmap : bitmap;
        Bitmap bitmap4 = (i & 2) != 0 ? transitionLightConfig.transMap : bitmap2;
        PointF pointF2 = (i & 4) != 0 ? transitionLightConfig.transPos : pointF;
        float f13 = (i & 8) != 0 ? transitionLightConfig.transAlpha : f;
        float f14 = (i & 16) != 0 ? transitionLightConfig.transScale : f4;
        float f15 = (i & 32) != 0 ? transitionLightConfig.tintIntensity : f5;
        float f16 = (i & 64) != 0 ? transitionLightConfig.tintSaturation : f6;
        float f17 = (i & 128) != 0 ? transitionLightConfig.ditherVariation : f7;
        RevealMode revealMode2 = (i & 256) != 0 ? transitionLightConfig.revealMode : revealMode;
        long j2 = (i & 512) != 0 ? transitionLightConfig.durationInMillis : j;
        float f18 = (i & 1024) != 0 ? transitionLightConfig.angle : f8;
        float f19 = (i & 2048) != 0 ? transitionLightConfig.frameRate : f9;
        float f20 = (i & 4096) != 0 ? transitionLightConfig.lightStretch : f10;
        Bitmap bitmap5 = bitmap3;
        ScaleType scaleType2 = (i & 8192) != 0 ? transitionLightConfig.scaleType : scaleType;
        Runnable runnable2 = (i & 16384) != 0 ? transitionLightConfig.onAnimationEndListener : runnable;
        Interpolator interpolator3 = (i & 32768) != 0 ? transitionLightConfig.scaleInterpolator : interpolator;
        if ((i & 65536) != 0) {
            interpolator2 = interpolator3;
            f12 = transitionLightConfig.maxScale;
        } else {
            f12 = f11;
            interpolator2 = interpolator3;
        }
        return transitionLightConfig.copy(bitmap5, bitmap4, pointF2, f13, f14, f15, f16, f17, revealMode2, j2, f18, f19, f20, scaleType2, runnable2, interpolator2, f12);
    }

    private final PointF getRotated(PointF pointF, float f) {
        double radians = (float) Math.toRadians(f);
        float fCos = (float) Math.cos(radians);
        float fSin = (float) Math.sin(radians);
        float f4 = pointF.x;
        float f5 = pointF.y;
        return new PointF((f4 * fCos) - (f5 * fSin), (f5 * fCos) + (f4 * fSin));
    }

    private final PointF minus(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x - pointF2.x, pointF.y - pointF2.y);
    }

    /* JADX INFO: renamed from: buildAnimationAttribute$sesl_visualeffect_INTERNAL_2_1_10_release */
    public final void m6739xbc54d8ec() {
        PointF pointFMinus = minus(new PointF(0.5f, 0.5f), getRotated(new PointF(1.0f, 0.0f), this.angle));
        getAnimatableAttribute$sesl_visualeffect_INTERNAL_2_1_10_release().clear();
        this.transPos = pointFMinus;
        long j = this.durationInMillis;
        float f = this.maxScale;
        long j2 = 0;
        Interpolator interpolator = null;
        int i = 0;
        int i2 = 0;
        add(new AnimatableAttribute<>(j, j2, Float.valueOf(0.0f), Float.valueOf(f), interpolator, i, i2, new Animator.AnimatorListener() { // from class: com.samsung.android.sesl.visualeffect.lighteffects.transitionlight.TransitionLightConfig$buildAnimationAttribute$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                Log.i(TransitionLightConfig.TAG, "Transition - onAnimationCancel");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                Log.i(TransitionLightConfig.TAG, "Transition - onAnimationEnd: " + this.this$0.getOnAnimationEndListener());
                Runnable onAnimationEndListener = this.this$0.getOnAnimationEndListener();
                if (onAnimationEndListener != null) {
                    onAnimationEndListener.run();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                Log.i(TransitionLightConfig.TAG, "Transition - onAnimationStart: " + this.this$0.getDurationInMillis() + " revealMode: " + this.this$0.getRevealMode());
            }
        }, new C7884a(this, pointFMinus, 0), 50, null));
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Bitmap getImageBitmap() {
        return this.imageBitmap;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final long getDurationInMillis() {
        return this.durationInMillis;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final float getAngle() {
        return this.angle;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final float getFrameRate() {
        return this.frameRate;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final float getLightStretch() {
        return this.lightStretch;
    }

    @NotNull
    /* JADX INFO: renamed from: component14, reason: from getter */
    public final ScaleType getScaleType() {
        return this.scaleType;
    }

    @Nullable
    /* JADX INFO: renamed from: component15, reason: from getter */
    public final Runnable getOnAnimationEndListener() {
        return this.onAnimationEndListener;
    }

    @NotNull
    /* JADX INFO: renamed from: component16, reason: from getter */
    public final Interpolator getScaleInterpolator() {
        return this.scaleInterpolator;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final float getMaxScale() {
        return this.maxScale;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Bitmap getTransMap() {
        return this.transMap;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final PointF getTransPos() {
        return this.transPos;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final float getTransAlpha() {
        return this.transAlpha;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final float getTransScale() {
        return this.transScale;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final float getTintIntensity() {
        return this.tintIntensity;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final float getTintSaturation() {
        return this.tintSaturation;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final float getDitherVariation() {
        return this.ditherVariation;
    }

    @NotNull
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final RevealMode getRevealMode() {
        return this.revealMode;
    }

    @NotNull
    public final TransitionLightConfig copy(@Nullable Bitmap imageBitmap, @Nullable Bitmap transMap, @NotNull PointF transPos, float transAlpha, float transScale, float tintIntensity, float tintSaturation, float ditherVariation, @NotNull RevealMode revealMode, long durationInMillis, float angle, float frameRate, float lightStretch, @NotNull ScaleType scaleType, @Nullable Runnable onAnimationEndListener, @NotNull Interpolator scaleInterpolator, float maxScale) {
        Intrinsics.checkNotNullParameter(transPos, "transPos");
        Intrinsics.checkNotNullParameter(revealMode, "revealMode");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        Intrinsics.checkNotNullParameter(scaleInterpolator, "scaleInterpolator");
        return new TransitionLightConfig(imageBitmap, transMap, transPos, transAlpha, transScale, tintIntensity, tintSaturation, ditherVariation, revealMode, durationInMillis, angle, frameRate, lightStretch, scaleType, onAnimationEndListener, scaleInterpolator, maxScale);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TransitionLightConfig)) {
            return false;
        }
        TransitionLightConfig transitionLightConfig = (TransitionLightConfig) other;
        return Intrinsics.areEqual(this.imageBitmap, transitionLightConfig.imageBitmap) && Intrinsics.areEqual(this.transMap, transitionLightConfig.transMap) && Intrinsics.areEqual(this.transPos, transitionLightConfig.transPos) && Float.compare(this.transAlpha, transitionLightConfig.transAlpha) == 0 && Float.compare(this.transScale, transitionLightConfig.transScale) == 0 && Float.compare(this.tintIntensity, transitionLightConfig.tintIntensity) == 0 && Float.compare(this.tintSaturation, transitionLightConfig.tintSaturation) == 0 && Float.compare(this.ditherVariation, transitionLightConfig.ditherVariation) == 0 && this.revealMode == transitionLightConfig.revealMode && this.durationInMillis == transitionLightConfig.durationInMillis && Float.compare(this.angle, transitionLightConfig.angle) == 0 && Float.compare(this.frameRate, transitionLightConfig.frameRate) == 0 && Float.compare(this.lightStretch, transitionLightConfig.lightStretch) == 0 && this.scaleType == transitionLightConfig.scaleType && Intrinsics.areEqual(this.onAnimationEndListener, transitionLightConfig.onAnimationEndListener) && Intrinsics.areEqual(this.scaleInterpolator, transitionLightConfig.scaleInterpolator) && Float.compare(this.maxScale, transitionLightConfig.maxScale) == 0;
    }

    public final float getAngle() {
        return this.angle;
    }

    public final float getDitherVariation() {
        return this.ditherVariation;
    }

    public final long getDurationInMillis() {
        return this.durationInMillis;
    }

    public final float getFrameRate() {
        return this.frameRate;
    }

    @Nullable
    public final Bitmap getImageBitmap() {
        return this.imageBitmap;
    }

    public final float getLightStretch() {
        return this.lightStretch;
    }

    public final float getMaxScale() {
        return this.maxScale;
    }

    @Nullable
    public final Runnable getOnAnimationEndListener() {
        return this.onAnimationEndListener;
    }

    @NotNull
    public final RevealMode getRevealMode() {
        return this.revealMode;
    }

    @NotNull
    public final Interpolator getScaleInterpolator() {
        return this.scaleInterpolator;
    }

    @NotNull
    public final ScaleType getScaleType() {
        return this.scaleType;
    }

    public final float getTintIntensity() {
        return this.tintIntensity;
    }

    public final float getTintSaturation() {
        return this.tintSaturation;
    }

    public final float getTransAlpha() {
        return this.transAlpha;
    }

    @Nullable
    public final Bitmap getTransMap() {
        return this.transMap;
    }

    @NotNull
    public final PointF getTransPos() {
        return this.transPos;
    }

    public final float getTransScale() {
        return this.transScale;
    }

    public int hashCode() {
        Bitmap bitmap = this.imageBitmap;
        int iHashCode = (bitmap == null ? 0 : bitmap.hashCode()) * 31;
        Bitmap bitmap2 = this.transMap;
        int iHashCode2 = (this.scaleType.hashCode() + AbstractC0622a.m1156b(this.lightStretch, AbstractC0622a.m1156b(this.frameRate, AbstractC0622a.m1156b(this.angle, AbstractC1974b.m1311d(this.durationInMillis, (this.revealMode.hashCode() + AbstractC0622a.m1156b(this.ditherVariation, AbstractC0622a.m1156b(this.tintSaturation, AbstractC0622a.m1156b(this.tintIntensity, AbstractC0622a.m1156b(this.transScale, AbstractC0622a.m1156b(this.transAlpha, (this.transPos.hashCode() + ((iHashCode + (bitmap2 == null ? 0 : bitmap2.hashCode())) * 31)) * 31, 31), 31), 31), 31), 31)) * 31, 31), 31), 31), 31)) * 31;
        Runnable runnable = this.onAnimationEndListener;
        return Float.hashCode(this.maxScale) + ((this.scaleInterpolator.hashCode() + ((iHashCode2 + (runnable != null ? runnable.hashCode() : 0)) * 31)) * 31);
    }

    public final void setAngle(float f) {
        this.angle = f;
    }

    public final void setDitherVariation(float f) {
        this.ditherVariation = f;
    }

    public final void setDurationInMillis(long j) {
        this.durationInMillis = j;
    }

    public final void setFrameRate(float f) {
        this.frameRate = f;
    }

    public final void setImageBitmap(@Nullable Bitmap bitmap) {
        this.imageBitmap = bitmap;
    }

    public final void setLightStretch(float f) {
        this.lightStretch = f;
    }

    public final void setMaxScale(float f) {
        this.maxScale = f;
    }

    public final void setOnAnimationEndListener(@Nullable Runnable runnable) {
        this.onAnimationEndListener = runnable;
    }

    public final void setRevealMode(@NotNull RevealMode revealMode) {
        Intrinsics.checkNotNullParameter(revealMode, "<set-?>");
        this.revealMode = revealMode;
    }

    public final void setScaleInterpolator(@NotNull Interpolator interpolator) {
        Intrinsics.checkNotNullParameter(interpolator, "<set-?>");
        this.scaleInterpolator = interpolator;
    }

    public final void setScaleType(@NotNull ScaleType scaleType) {
        Intrinsics.checkNotNullParameter(scaleType, "<set-?>");
        this.scaleType = scaleType;
    }

    public final void setTintIntensity(float f) {
        this.tintIntensity = f;
    }

    public final void setTintSaturation(float f) {
        this.tintSaturation = f;
    }

    public final void setTransAlpha(float f) {
        this.transAlpha = f;
    }

    public final void setTransMap(@Nullable Bitmap bitmap) {
        this.transMap = bitmap;
    }

    public final void setTransPos(@NotNull PointF pointF) {
        Intrinsics.checkNotNullParameter(pointF, "<set-?>");
        this.transPos = pointF;
    }

    public final void setTransScale(float f) {
        this.transScale = f;
    }

    @NotNull
    public String toString() {
        Bitmap bitmap = this.imageBitmap;
        Bitmap bitmap2 = this.transMap;
        PointF pointF = this.transPos;
        float f = this.transAlpha;
        float f4 = this.transScale;
        float f5 = this.tintIntensity;
        float f6 = this.tintSaturation;
        float f7 = this.ditherVariation;
        RevealMode revealMode = this.revealMode;
        long j = this.durationInMillis;
        float f8 = this.angle;
        float f9 = this.frameRate;
        float f10 = this.lightStretch;
        ScaleType scaleType = this.scaleType;
        Runnable runnable = this.onAnimationEndListener;
        Interpolator interpolator = this.scaleInterpolator;
        float f11 = this.maxScale;
        StringBuilder sb = new StringBuilder("TransitionLightConfig(imageBitmap=");
        sb.append(bitmap);
        sb.append(", transMap=");
        sb.append(bitmap2);
        sb.append(", transPos=");
        sb.append(pointF);
        sb.append(", transAlpha=");
        sb.append(f);
        sb.append(", transScale=");
        AbstractC11014a.m12337v(sb, f4, ", tintIntensity=", f5, ", tintSaturation=");
        AbstractC11014a.m12337v(sb, f6, ", ditherVariation=", f7, ", revealMode=");
        sb.append(revealMode);
        sb.append(", durationInMillis=");
        sb.append(j);
        sb.append(", angle=");
        sb.append(f8);
        sb.append(", frameRate=");
        sb.append(f9);
        sb.append(", lightStretch=");
        sb.append(f10);
        sb.append(", scaleType=");
        sb.append(scaleType);
        sb.append(", onAnimationEndListener=");
        sb.append(runnable);
        sb.append(", scaleInterpolator=");
        sb.append(interpolator);
        sb.append(", maxScale=");
        sb.append(f11);
        sb.append(")");
        return sb.toString();
    }

    public /* synthetic */ TransitionLightConfig(Bitmap bitmap, Bitmap bitmap2, PointF pointF, float f, float f4, float f5, float f6, float f7, RevealMode revealMode, long j, float f8, float f9, float f10, ScaleType scaleType, Runnable runnable, Interpolator interpolator, float f11, int i, DefaultConstructorMarker defaultConstructorMarker) {
        Runnable runnable2;
        ScaleType scaleType2;
        Bitmap bitmap3;
        PointF pointF2;
        Interpolator pathInterpolator;
        Bitmap bitmap4 = (i & 1) != 0 ? null : bitmap;
        Bitmap bitmap5 = (i & 2) != 0 ? null : bitmap2;
        PointF transPosition = (i & 4) != 0 ? TransitionLightRenderEffect.Companion.Default.INSTANCE.getTransPosition() : pointF;
        float f12 = (i & 8) != 0 ? 0.0f : f;
        float f13 = (i & 16) == 0 ? f4 : 0.0f;
        float f14 = (i & 32) != 0 ? 0.48f : f5;
        float f15 = (i & 64) != 0 ? 1.2f : f6;
        float f16 = (i & 128) != 0 ? 0.07f : f7;
        RevealMode revealMode2 = (i & 256) != 0 ? RevealMode.VIEW : revealMode;
        long j2 = (i & 512) != 0 ? DURATION : j;
        float f17 = (i & 1024) != 0 ? 84.0f : f8;
        float f18 = (i & 2048) != 0 ? 60.0f : f9;
        float f19 = (i & 4096) != 0 ? 1.0f : f10;
        ScaleType scaleType3 = (i & 8192) != 0 ? TransitionLightRenderEffect.Companion.Default.INSTANCE.getScaleType() : scaleType;
        Bitmap bitmap6 = bitmap4;
        Runnable runnable3 = (i & 16384) != 0 ? null : runnable;
        if ((i & 32768) != 0) {
            runnable2 = runnable3;
            scaleType2 = scaleType3;
            bitmap3 = bitmap5;
            pointF2 = transPosition;
            pathInterpolator = new PathInterpolator(0.35f, 0.52f, 0.28f, 1.0f);
        } else {
            runnable2 = runnable3;
            scaleType2 = scaleType3;
            bitmap3 = bitmap5;
            pointF2 = transPosition;
            pathInterpolator = interpolator;
        }
        this(bitmap6, bitmap3, pointF2, f12, f13, f14, f15, f16, revealMode2, j2, f17, f18, f19, scaleType2, runnable2, pathInterpolator, (i & 65536) != 0 ? 8.28f : f11);
    }

    public TransitionLightConfig(@Nullable Bitmap bitmap, @Nullable Bitmap bitmap2, @NotNull PointF transPos, float f, float f4, float f5, float f6, float f7, @NotNull RevealMode revealMode, long j, float f8, float f9, float f10, @NotNull ScaleType scaleType, @Nullable Runnable runnable, @NotNull Interpolator scaleInterpolator, float f11) {
        Intrinsics.checkNotNullParameter(transPos, "transPos");
        Intrinsics.checkNotNullParameter(revealMode, "revealMode");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        Intrinsics.checkNotNullParameter(scaleInterpolator, "scaleInterpolator");
        this.imageBitmap = bitmap;
        this.transMap = bitmap2;
        this.transPos = transPos;
        this.transAlpha = f;
        this.transScale = f4;
        this.tintIntensity = f5;
        this.tintSaturation = f6;
        this.ditherVariation = f7;
        this.revealMode = revealMode;
        this.durationInMillis = j;
        this.angle = f8;
        this.frameRate = f9;
        this.lightStretch = f10;
        this.scaleType = scaleType;
        this.onAnimationEndListener = runnable;
        this.scaleInterpolator = scaleInterpolator;
        this.maxScale = f11;
    }
}
