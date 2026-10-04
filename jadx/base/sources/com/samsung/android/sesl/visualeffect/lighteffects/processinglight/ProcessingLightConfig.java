package com.samsung.android.sesl.visualeffect.lighteffects.processinglight;

import android.graphics.Color;
import android.graphics.PointF;
import android.view.animation.PathInterpolator;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.AbstractC1974b;
import androidx.glance.AbstractC2821a;
import com.samsung.android.sesl.visualeffect.lighteffects.common.config.AnimatableAttribute;
import com.samsung.android.sesl.visualeffect.lighteffects.common.config.BaseVibeEffectConfig;
import com.samsung.android.sesl.visualeffect.lighteffects.common.control.VibeEffectControl;
import com.samsung.android.sesl.visualeffect.lighteffects.processinglight.ProcessingLightRenderEffect;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.visual.p167ai.sdkcommon.image.ImageConst;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@RequiresApi(33)
@Metadata(m13885d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\bY\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0087\b\u0018\u0000 u2\u00020\u0001:\u0002tuB½\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\b\b\u0003\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u0012\b\b\u0002\u0010\u000f\u001a\u00020\t\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u0011\u001a\u00020\t\u0012\b\b\u0002\u0010\u0012\u001a\u00020\t\u0012\b\b\u0002\u0010\u0013\u001a\u00020\t\u0012\b\b\u0002\u0010\u0014\u001a\u00020\t\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0018\u001a\u00020\t\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010O\u001a\u00020\u0000H\u0000¢\u0006\u0002\bPJ\f\u0010Q\u001a\u00020\t*\u00020\tH\u0002J \u0010R\u001a\u00020\u00072\u0006\u0010S\u001a\u00020\u00072\u0006\u0010T\u001a\u00020\u00072\u0006\u0010U\u001a\u00020\tH\u0002J\u0014\u0010V\u001a\u00020\u0007*\u00020\u00072\u0006\u0010W\u001a\u00020\u0007H\u0002J\u0014\u0010X\u001a\u00020\u0007*\u00020\u00072\u0006\u0010W\u001a\u00020\u0007H\u0002J\u0014\u0010Y\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u0014\u001a\u00020\tH\u0002J\t\u0010Z\u001a\u00020\u0003HÆ\u0003J\t\u0010[\u001a\u00020\u0005HÆ\u0003J\t\u0010\\\u001a\u00020\u0007HÆ\u0003J\t\u0010]\u001a\u00020\tHÆ\u0003J\t\u0010^\u001a\u00020\tHÆ\u0003J\t\u0010_\u001a\u00020\tHÆ\u0003J\t\u0010`\u001a\u00020\rHÆ\u0003J\t\u0010a\u001a\u00020\tHÆ\u0003J\t\u0010b\u001a\u00020\tHÆ\u0003J\u0010\u0010c\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u00109J\t\u0010d\u001a\u00020\tHÆ\u0003J\t\u0010e\u001a\u00020\tHÆ\u0003J\t\u0010f\u001a\u00020\tHÆ\u0003J\t\u0010g\u001a\u00020\tHÆ\u0003J\t\u0010h\u001a\u00020\u0016HÆ\u0003J\t\u0010i\u001a\u00020\u0003HÆ\u0003J\t\u0010j\u001a\u00020\tHÆ\u0003J\t\u0010k\u001a\u00020\u0016HÆ\u0003JÄ\u0001\u0010l\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0003\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\t2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\t2\b\b\u0002\u0010\u0013\u001a\u00020\t2\b\b\u0002\u0010\u0014\u001a\u00020\t2\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\t2\b\b\u0002\u0010\u0019\u001a\u00020\u0016HÆ\u0001¢\u0006\u0002\u0010mJ\u0013\u0010n\u001a\u00020\u00032\b\u0010o\u001a\u0004\u0018\u00010pHÖ\u0003J\t\u0010q\u001a\u00020\rHÖ\u0001J\t\u0010r\u001a\u00020sHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010\n\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010)\"\u0004\b-\u0010+R\u001a\u0010\u000b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010)\"\u0004\b/\u0010+R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001a\u0010\u000e\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010)\"\u0004\b5\u0010+R\u001a\u0010\u000f\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010)\"\u0004\b7\u0010+R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u0010\n\u0002\u0010<\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001a\u0010\u0011\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010)\"\u0004\b>\u0010+R\u001a\u0010\u0012\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010)\"\u0004\b@\u0010+R\u001a\u0010\u0013\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010)\"\u0004\bB\u0010+R\u001a\u0010\u0014\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010)\"\u0004\bD\u0010+R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u001a\u0010\u0017\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\u001d\"\u0004\bJ\u0010\u001fR\u001a\u0010\u0018\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010)\"\u0004\bL\u0010+R\u001a\u0010\u0019\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010F\"\u0004\bN\u0010H¨\u0006v"}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/lighteffects/processinglight/ProcessingLightConfig;", "Lcom/samsung/android/sesl/visualeffect/lighteffects/common/config/BaseVibeEffectConfig;", "useLightnessCalibration", "", "blendMode", "Lcom/samsung/android/sesl/visualeffect/lighteffects/processinglight/ProcessingLightConfig$BlendMode;", "lightPos", "Landroid/graphics/PointF;", "lightAngle", "", "lightScale", "lightStretch", "lightColor", "", "lightIntensity", "lightSaturation", "domainColor", "domainStrength", "domainDeltaRatio", "ditherVariation", "angle", "durationInMillis", "", "useDynamicDomainColor", "frameRate", "repeatDelay", "<init>", "(ZLcom/samsung/android/sesl/visualeffect/lighteffects/processinglight/ProcessingLightConfig$BlendMode;Landroid/graphics/PointF;FFFIFFLjava/lang/Integer;FFFFJZFJ)V", "getUseLightnessCalibration", "()Z", "setUseLightnessCalibration", "(Z)V", "getBlendMode", "()Lcom/samsung/android/sesl/visualeffect/lighteffects/processinglight/ProcessingLightConfig$BlendMode;", "setBlendMode", "(Lcom/samsung/android/sesl/visualeffect/lighteffects/processinglight/ProcessingLightConfig$BlendMode;)V", "getLightPos", "()Landroid/graphics/PointF;", "setLightPos", "(Landroid/graphics/PointF;)V", "getLightAngle", "()F", "setLightAngle", "(F)V", "getLightScale", "setLightScale", "getLightStretch", "setLightStretch", "getLightColor", "()I", "setLightColor", "(I)V", "getLightIntensity", "setLightIntensity", "getLightSaturation", "setLightSaturation", "getDomainColor", "()Ljava/lang/Integer;", "setDomainColor", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getDomainStrength", "setDomainStrength", "getDomainDeltaRatio", "setDomainDeltaRatio", "getDitherVariation", "setDitherVariation", "getAngle", "setAngle", "getDurationInMillis", "()J", "setDurationInMillis", "(J)V", "getUseDynamicDomainColor", "setUseDynamicDomainColor", "getFrameRate", "setFrameRate", "getRepeatDelay", "setRepeatDelay", "makeConfigWithAnimator", "makeConfigWithAnimator$sesl_visualeffect_INTERNAL_2_1_10_release", "toRadian", ImageConst.PARAM_MODE_WALLPAPER_MIX, "p1", "p2", "ratio", "minus", "p", "plus", "getRotated", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "copy", "(ZLcom/samsung/android/sesl/visualeffect/lighteffects/processinglight/ProcessingLightConfig$BlendMode;Landroid/graphics/PointF;FFFIFFLjava/lang/Integer;FFFFJZFJ)Lcom/samsung/android/sesl/visualeffect/lighteffects/processinglight/ProcessingLightConfig;", "equals", "other", "", "hashCode", "toString", "", "BlendMode", "Companion", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final /* data */ class ProcessingLightConfig extends BaseVibeEffectConfig {
    public static final float ANGLE = 84.0f;
    public static final long DURATION = 2000;

    @NotNull
    public static final String TAG = "ProcessingLightConfig";

    @NotNull
    private static final ProcessingLightConfig VI_CONFIG_CAPTURE;

    @NotNull
    private static final ProcessingLightConfig VI_CONFIG_DEFAULT;

    @NotNull
    private static final ProcessingLightConfig VI_CONFIG_OVERLAY;
    private float angle;

    @NotNull
    private BlendMode blendMode;
    private float ditherVariation;

    @Nullable
    private Integer domainColor;
    private float domainDeltaRatio;
    private float domainStrength;
    private long durationInMillis;
    private float frameRate;
    private float lightAngle;
    private int lightColor;
    private float lightIntensity;

    @NotNull
    private PointF lightPos;
    private float lightSaturation;
    private float lightScale;
    private float lightStretch;
    private long repeatDelay;
    private boolean useDynamicDomainColor;
    private boolean useLightnessCalibration;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final PathInterpolator positionInterpolator = new PathInterpolator(0.33f, 0.22f, 0.42f, 1.0f);

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/lighteffects/processinglight/ProcessingLightConfig$BlendMode;", "", "<init>", "(Ljava/lang/String;I)V", "PREMULT", "ADD", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class BlendMode {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ BlendMode[] $VALUES;
        public static final BlendMode PREMULT = new BlendMode("PREMULT", 0);
        public static final BlendMode ADD = new BlendMode("ADD", 1);

        private static final /* synthetic */ BlendMode[] $values() {
            return new BlendMode[]{PREMULT, ADD};
        }

        static {
            BlendMode[] blendModeArr$values = $values();
            $VALUES = blendModeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(blendModeArr$values);
        }

        private BlendMode(String str, int i) {
        }

        @NotNull
        public static EnumEntries<BlendMode> getEntries() {
            return $ENTRIES;
        }

        public static BlendMode valueOf(String str) {
            return (BlendMode) Enum.valueOf(BlendMode.class, str);
        }

        public static BlendMode[] values() {
            return (BlendMode[]) $VALUES.clone();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0080T¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0080T¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0014\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/lighteffects/processinglight/ProcessingLightConfig$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "DURATION", "", "positionInterpolator", "Landroid/view/animation/PathInterpolator;", "getPositionInterpolator$sesl_visualeffect_INTERNAL_2_1_10_release", "()Landroid/view/animation/PathInterpolator;", "ANGLE", "", "VI_CONFIG_DEFAULT", "Lcom/samsung/android/sesl/visualeffect/lighteffects/processinglight/ProcessingLightConfig;", "getVI_CONFIG_DEFAULT", "()Lcom/samsung/android/sesl/visualeffect/lighteffects/processinglight/ProcessingLightConfig;", "VI_CONFIG_OVERLAY", "getVI_CONFIG_OVERLAY", "VI_CONFIG_CAPTURE", "getVI_CONFIG_CAPTURE", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        /* JADX INFO: renamed from: getPositionInterpolator$sesl_visualeffect_INTERNAL_2_1_10_release */
        public final PathInterpolator m6661x1d9fcf6c() {
            return ProcessingLightConfig.positionInterpolator;
        }

        @NotNull
        public final ProcessingLightConfig getVI_CONFIG_CAPTURE() {
            return ProcessingLightConfig.VI_CONFIG_CAPTURE;
        }

        @NotNull
        public final ProcessingLightConfig getVI_CONFIG_DEFAULT() {
            return ProcessingLightConfig.VI_CONFIG_DEFAULT;
        }

        @NotNull
        public final ProcessingLightConfig getVI_CONFIG_OVERLAY() {
            return ProcessingLightConfig.VI_CONFIG_OVERLAY;
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        float f = 0.0f;
        float f4 = 0.0f;
        float f5 = 0.0f;
        float f6 = 0.0f;
        float f7 = 0.0f;
        float f8 = 0.0f;
        ProcessingLightConfig processingLightConfig = new ProcessingLightConfig(false, null, null, 0.0f, f, f4, 0, 0.0f, f5, null, 0.0f, f6, f7, f8, 0L, false, 0.0f, 0L, 262143, null);
        BlendMode blendMode = BlendMode.PREMULT;
        processingLightConfig.blendMode = blendMode;
        processingLightConfig.domainDeltaRatio = 0.23f;
        processingLightConfig.useDynamicDomainColor = true;
        processingLightConfig.useLightnessCalibration = true;
        VI_CONFIG_DEFAULT = processingLightConfig;
        float f9 = 0.0f;
        float f10 = 0.0f;
        float f11 = 0.0f;
        ProcessingLightConfig processingLightConfig2 = new ProcessingLightConfig(false, null == true ? 1 : 0, null, f, f4, f9, 0, f5, f10, null, f6, f7, f8, f11, 0L, false, 0.0f, 0L, 262143, null);
        processingLightConfig2.blendMode = BlendMode.ADD;
        processingLightConfig2.domainColor = Integer.valueOf(Color.parseColor("#010101"));
        processingLightConfig2.useDynamicDomainColor = false;
        processingLightConfig2.useLightnessCalibration = true;
        processingLightConfig2.lightScale = 2.5f;
        processingLightConfig2.lightStretch = 1.0f;
        processingLightConfig2.lightIntensity = 0.7f;
        processingLightConfig2.lightSaturation = 3.0f;
        processingLightConfig2.domainDeltaRatio = 0.0f;
        processingLightConfig2.ditherVariation = 0.05f;
        VI_CONFIG_OVERLAY = processingLightConfig2;
        ProcessingLightConfig processingLightConfig3 = new ProcessingLightConfig(false, null == true ? 1 : 0, null, f4, f9, 0.0f, 0, f10, 0.0f, null, f7, f8, f11, 0.0f, 0L, false, 0.0f, 0L, 262143, null);
        processingLightConfig3.blendMode = blendMode;
        processingLightConfig3.domainDeltaRatio = 0.0f;
        processingLightConfig3.useDynamicDomainColor = false;
        processingLightConfig3.domainColor = -1;
        processingLightConfig3.useLightnessCalibration = false;
        VI_CONFIG_CAPTURE = processingLightConfig3;
    }

    public ProcessingLightConfig() {
        this(false, null, null, 0.0f, 0.0f, 0.0f, 0, 0.0f, 0.0f, null, 0.0f, 0.0f, 0.0f, 0.0f, 0L, false, 0.0f, 0L, 262143, null);
    }

    public static /* synthetic */ ProcessingLightConfig copy$default(ProcessingLightConfig processingLightConfig, boolean z, BlendMode blendMode, PointF pointF, float f, float f4, float f5, int i, float f6, float f7, Integer num, float f8, float f9, float f10, float f11, long j, boolean z2, float f12, long j2, int i2, Object obj) {
        long j3;
        boolean z3;
        float f13;
        boolean z4 = (i2 & 1) != 0 ? processingLightConfig.useLightnessCalibration : z;
        BlendMode blendMode2 = (i2 & 2) != 0 ? processingLightConfig.blendMode : blendMode;
        PointF pointF2 = (i2 & 4) != 0 ? processingLightConfig.lightPos : pointF;
        float f14 = (i2 & 8) != 0 ? processingLightConfig.lightAngle : f;
        float f15 = (i2 & 16) != 0 ? processingLightConfig.lightScale : f4;
        float f16 = (i2 & 32) != 0 ? processingLightConfig.lightStretch : f5;
        int i4 = (i2 & 64) != 0 ? processingLightConfig.lightColor : i;
        float f17 = (i2 & 128) != 0 ? processingLightConfig.lightIntensity : f6;
        float f18 = (i2 & 256) != 0 ? processingLightConfig.lightSaturation : f7;
        Integer num2 = (i2 & 512) != 0 ? processingLightConfig.domainColor : num;
        float f19 = (i2 & 1024) != 0 ? processingLightConfig.domainStrength : f8;
        float f20 = (i2 & 2048) != 0 ? processingLightConfig.domainDeltaRatio : f9;
        float f21 = (i2 & 4096) != 0 ? processingLightConfig.ditherVariation : f10;
        float f22 = (i2 & 8192) != 0 ? processingLightConfig.angle : f11;
        boolean z5 = z4;
        long j5 = (i2 & 16384) != 0 ? processingLightConfig.durationInMillis : j;
        boolean z6 = (i2 & 32768) != 0 ? processingLightConfig.useDynamicDomainColor : z2;
        float f23 = (i2 & 65536) != 0 ? processingLightConfig.frameRate : f12;
        if ((i2 & 131072) != 0) {
            z3 = z6;
            f13 = f23;
            j3 = processingLightConfig.repeatDelay;
        } else {
            j3 = j2;
            z3 = z6;
            f13 = f23;
        }
        return processingLightConfig.copy(z5, blendMode2, pointF2, f14, f15, f16, i4, f17, f18, num2, f19, f20, f21, f22, j5, z3, f13, j3);
    }

    private final PointF getRotated(PointF pointF, float f) {
        double radians = (float) Math.toRadians(f);
        float fCos = (float) Math.cos(radians);
        float fSin = (float) Math.sin(radians);
        float f4 = pointF.x;
        float f5 = pointF.y;
        return new PointF((f4 * fCos) - (f5 * fSin), (f5 * fCos) + (f4 * fSin));
    }

    private static final float makeConfigWithAnimator$lambda$1$getHypotenuse(ProcessingLightConfig processingLightConfig, float f, float f4) {
        return f / ((float) Math.cos(processingLightConfig.toRadian(f4)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit makeConfigWithAnimator$lambda$1$lambda$0(ProcessingLightConfig processingLightConfig, VibeEffectControl vibeEffectControl, float f, float f4) {
        float f5 = processingLightConfig.angle % 90;
        if (f5 > 45.0f) {
            f5 = 90.0f - f5;
        }
        PointF rotated = processingLightConfig.getRotated(new PointF(makeConfigWithAnimator$lambda$1$getHypotenuse(processingLightConfig, 0.5f, f5) + makeConfigWithAnimator$lambda$1$getHypotenuse(processingLightConfig, processingLightConfig.lightScale * 0.5f, f5), 0.0f), processingLightConfig.angle);
        PointF pointF = new PointF(0.5f, 0.5f);
        PointF pointFMix = processingLightConfig.mix(processingLightConfig.minus(pointF, rotated), processingLightConfig.plus(pointF, rotated), positionInterpolator.getInterpolation(f));
        boolean z = vibeEffectControl instanceof ProcessingLightControl;
        ProcessingLightControl processingLightControl = z ? (ProcessingLightControl) vibeEffectControl : null;
        if (processingLightControl != null) {
            processingLightControl.setLightPosition(pointFMix);
        }
        ProcessingLightControl processingLightControl2 = z ? (ProcessingLightControl) vibeEffectControl : null;
        if (processingLightControl2 != null) {
            processingLightControl2.setLightScale(processingLightConfig.lightScale);
        }
        return Unit.INSTANCE;
    }

    private final PointF minus(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x - pointF2.x, pointF.y - pointF2.y);
    }

    private final PointF mix(PointF p1, PointF p2, float ratio) {
        float f = 1.0f - ratio;
        return new PointF((p2.x * ratio) + (p1.x * f), (p2.y * ratio) + (p1.y * f));
    }

    private final PointF plus(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y);
    }

    private final float toRadian(float f) {
        return (f * 3.1415927f) / 180.0f;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getUseLightnessCalibration() {
        return this.useLightnessCalibration;
    }

    @Nullable
    /* JADX INFO: renamed from: component10, reason: from getter */
    public final Integer getDomainColor() {
        return this.domainColor;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final float getDomainStrength() {
        return this.domainStrength;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final float getDomainDeltaRatio() {
        return this.domainDeltaRatio;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final float getDitherVariation() {
        return this.ditherVariation;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final float getAngle() {
        return this.angle;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final long getDurationInMillis() {
        return this.durationInMillis;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final boolean getUseDynamicDomainColor() {
        return this.useDynamicDomainColor;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final float getFrameRate() {
        return this.frameRate;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final long getRepeatDelay() {
        return this.repeatDelay;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final BlendMode getBlendMode() {
        return this.blendMode;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final PointF getLightPos() {
        return this.lightPos;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final float getLightAngle() {
        return this.lightAngle;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final float getLightScale() {
        return this.lightScale;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final float getLightStretch() {
        return this.lightStretch;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getLightColor() {
        return this.lightColor;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final float getLightIntensity() {
        return this.lightIntensity;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final float getLightSaturation() {
        return this.lightSaturation;
    }

    @NotNull
    public final ProcessingLightConfig copy(boolean useLightnessCalibration, @NotNull BlendMode blendMode, @NotNull PointF lightPos, float lightAngle, float lightScale, float lightStretch, @ColorInt int lightColor, float lightIntensity, float lightSaturation, @Nullable Integer domainColor, float domainStrength, float domainDeltaRatio, float ditherVariation, float angle, long durationInMillis, boolean useDynamicDomainColor, float frameRate, long repeatDelay) {
        Intrinsics.checkNotNullParameter(blendMode, "blendMode");
        Intrinsics.checkNotNullParameter(lightPos, "lightPos");
        return new ProcessingLightConfig(useLightnessCalibration, blendMode, lightPos, lightAngle, lightScale, lightStretch, lightColor, lightIntensity, lightSaturation, domainColor, domainStrength, domainDeltaRatio, ditherVariation, angle, durationInMillis, useDynamicDomainColor, frameRate, repeatDelay);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ProcessingLightConfig)) {
            return false;
        }
        ProcessingLightConfig processingLightConfig = (ProcessingLightConfig) other;
        return this.useLightnessCalibration == processingLightConfig.useLightnessCalibration && this.blendMode == processingLightConfig.blendMode && Intrinsics.areEqual(this.lightPos, processingLightConfig.lightPos) && Float.compare(this.lightAngle, processingLightConfig.lightAngle) == 0 && Float.compare(this.lightScale, processingLightConfig.lightScale) == 0 && Float.compare(this.lightStretch, processingLightConfig.lightStretch) == 0 && this.lightColor == processingLightConfig.lightColor && Float.compare(this.lightIntensity, processingLightConfig.lightIntensity) == 0 && Float.compare(this.lightSaturation, processingLightConfig.lightSaturation) == 0 && Intrinsics.areEqual(this.domainColor, processingLightConfig.domainColor) && Float.compare(this.domainStrength, processingLightConfig.domainStrength) == 0 && Float.compare(this.domainDeltaRatio, processingLightConfig.domainDeltaRatio) == 0 && Float.compare(this.ditherVariation, processingLightConfig.ditherVariation) == 0 && Float.compare(this.angle, processingLightConfig.angle) == 0 && this.durationInMillis == processingLightConfig.durationInMillis && this.useDynamicDomainColor == processingLightConfig.useDynamicDomainColor && Float.compare(this.frameRate, processingLightConfig.frameRate) == 0 && this.repeatDelay == processingLightConfig.repeatDelay;
    }

    public final float getAngle() {
        return this.angle;
    }

    @NotNull
    public final BlendMode getBlendMode() {
        return this.blendMode;
    }

    public final float getDitherVariation() {
        return this.ditherVariation;
    }

    @Nullable
    public final Integer getDomainColor() {
        return this.domainColor;
    }

    public final float getDomainDeltaRatio() {
        return this.domainDeltaRatio;
    }

    public final float getDomainStrength() {
        return this.domainStrength;
    }

    public final long getDurationInMillis() {
        return this.durationInMillis;
    }

    public final float getFrameRate() {
        return this.frameRate;
    }

    public final float getLightAngle() {
        return this.lightAngle;
    }

    public final int getLightColor() {
        return this.lightColor;
    }

    public final float getLightIntensity() {
        return this.lightIntensity;
    }

    @NotNull
    public final PointF getLightPos() {
        return this.lightPos;
    }

    public final float getLightSaturation() {
        return this.lightSaturation;
    }

    public final float getLightScale() {
        return this.lightScale;
    }

    public final float getLightStretch() {
        return this.lightStretch;
    }

    public final long getRepeatDelay() {
        return this.repeatDelay;
    }

    public final boolean getUseDynamicDomainColor() {
        return this.useDynamicDomainColor;
    }

    public final boolean getUseLightnessCalibration() {
        return this.useLightnessCalibration;
    }

    public int hashCode() {
        int iM1156b = AbstractC0622a.m1156b(this.lightSaturation, AbstractC0622a.m1156b(this.lightIntensity, AbstractC0622a.m1157c(this.lightColor, AbstractC0622a.m1156b(this.lightStretch, AbstractC0622a.m1156b(this.lightScale, AbstractC0622a.m1156b(this.lightAngle, (this.lightPos.hashCode() + ((this.blendMode.hashCode() + (Boolean.hashCode(this.useLightnessCalibration) * 31)) * 31)) * 31, 31), 31), 31), 31), 31), 31);
        Integer num = this.domainColor;
        return Long.hashCode(this.repeatDelay) + AbstractC0622a.m1156b(this.frameRate, AbstractC0622a.m1160f(this.useDynamicDomainColor, AbstractC1974b.m1311d(this.durationInMillis, AbstractC0622a.m1156b(this.angle, AbstractC0622a.m1156b(this.ditherVariation, AbstractC0622a.m1156b(this.domainDeltaRatio, AbstractC0622a.m1156b(this.domainStrength, (iM1156b + (num == null ? 0 : num.hashCode())) * 31, 31), 31), 31), 31), 31), 31), 31);
    }

    @NotNull
    public final ProcessingLightConfig makeConfigWithAnimator$sesl_visualeffect_INTERNAL_2_1_10_release() {
        boolean z = this.useLightnessCalibration;
        BlendMode blendMode = this.blendMode;
        int i = this.lightColor;
        float f = this.lightIntensity;
        PointF pointF = null;
        float f4 = 0.0f;
        ProcessingLightConfig processingLightConfig = new ProcessingLightConfig(z, blendMode, pointF, this.lightAngle, this.lightScale, this.lightStretch, i, f, f4, this.domainColor, this.domainStrength, this.domainDeltaRatio, this.ditherVariation, this.angle, this.durationInMillis, false, this.frameRate, this.repeatDelay, 33028, null);
        processingLightConfig.getAnimatableAttribute$sesl_visualeffect_INTERNAL_2_1_10_release().clear();
        processingLightConfig.add(new AnimatableAttribute<>(processingLightConfig.durationInMillis, 0L, Float.valueOf(0.0f), Float.valueOf(1.0f), null, -1, 0, new ProcessingLightConfig$makeConfigWithAnimator$1$1(processingLightConfig), new C7868a(processingLightConfig, 0), 82, null));
        return processingLightConfig;
    }

    public final void setAngle(float f) {
        this.angle = f;
    }

    public final void setBlendMode(@NotNull BlendMode blendMode) {
        Intrinsics.checkNotNullParameter(blendMode, "<set-?>");
        this.blendMode = blendMode;
    }

    public final void setDitherVariation(float f) {
        this.ditherVariation = f;
    }

    public final void setDomainColor(@Nullable Integer num) {
        this.domainColor = num;
    }

    public final void setDomainDeltaRatio(float f) {
        this.domainDeltaRatio = f;
    }

    public final void setDomainStrength(float f) {
        this.domainStrength = f;
    }

    public final void setDurationInMillis(long j) {
        this.durationInMillis = j;
    }

    public final void setFrameRate(float f) {
        this.frameRate = f;
    }

    public final void setLightAngle(float f) {
        this.lightAngle = f;
    }

    public final void setLightColor(int i) {
        this.lightColor = i;
    }

    public final void setLightIntensity(float f) {
        this.lightIntensity = f;
    }

    public final void setLightPos(@NotNull PointF pointF) {
        Intrinsics.checkNotNullParameter(pointF, "<set-?>");
        this.lightPos = pointF;
    }

    public final void setLightSaturation(float f) {
        this.lightSaturation = f;
    }

    public final void setLightScale(float f) {
        this.lightScale = f;
    }

    public final void setLightStretch(float f) {
        this.lightStretch = f;
    }

    public final void setRepeatDelay(long j) {
        this.repeatDelay = j;
    }

    public final void setUseDynamicDomainColor(boolean z) {
        this.useDynamicDomainColor = z;
    }

    public final void setUseLightnessCalibration(boolean z) {
        this.useLightnessCalibration = z;
    }

    @NotNull
    public String toString() {
        boolean z = this.useLightnessCalibration;
        BlendMode blendMode = this.blendMode;
        PointF pointF = this.lightPos;
        float f = this.lightAngle;
        float f4 = this.lightScale;
        float f5 = this.lightStretch;
        int i = this.lightColor;
        float f6 = this.lightIntensity;
        float f7 = this.lightSaturation;
        Integer num = this.domainColor;
        float f8 = this.domainStrength;
        float f9 = this.domainDeltaRatio;
        float f10 = this.ditherVariation;
        float f11 = this.angle;
        long j = this.durationInMillis;
        boolean z2 = this.useDynamicDomainColor;
        float f12 = this.frameRate;
        long j2 = this.repeatDelay;
        StringBuilder sb = new StringBuilder("ProcessingLightConfig(useLightnessCalibration=");
        sb.append(z);
        sb.append(", blendMode=");
        sb.append(blendMode);
        sb.append(", lightPos=");
        sb.append(pointF);
        sb.append(", lightAngle=");
        sb.append(f);
        sb.append(", lightScale=");
        AbstractC11014a.m12337v(sb, f4, ", lightStretch=", f5, ", lightColor=");
        sb.append(i);
        sb.append(", lightIntensity=");
        sb.append(f6);
        sb.append(", lightSaturation=");
        sb.append(f7);
        sb.append(", domainColor=");
        sb.append(num);
        sb.append(", domainStrength=");
        AbstractC11014a.m12337v(sb, f8, ", domainDeltaRatio=", f9, ", ditherVariation=");
        AbstractC11014a.m12337v(sb, f10, ", angle=", f11, ", durationInMillis=");
        sb.append(j);
        sb.append(", useDynamicDomainColor=");
        sb.append(z2);
        sb.append(", frameRate=");
        sb.append(f12);
        sb.append(", repeatDelay=");
        return AbstractC2821a.m2224o(sb, ")", j2);
    }

    public /* synthetic */ ProcessingLightConfig(boolean z, BlendMode blendMode, PointF pointF, float f, float f4, float f5, int i, float f6, float f7, Integer num, float f8, float f9, float f10, float f11, long j, boolean z2, float f12, long j2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? true : z, (i2 & 2) != 0 ? BlendMode.ADD : blendMode, (i2 & 4) != 0 ? ProcessingLightRenderEffect.Companion.Default.INSTANCE.getLightPos() : pointF, (i2 & 8) != 0 ? 0.0f : f, (i2 & 16) != 0 ? 2.05f : f4, (i2 & 32) != 0 ? 1.0f : f5, (i2 & 64) != 0 ? -1 : i, (i2 & 128) == 0 ? f6 : 1.0f, (i2 & 256) != 0 ? 1.15f : f7, (i2 & 512) != 0 ? null : num, (i2 & 1024) != 0 ? 1.16f : f8, (i2 & 2048) != 0 ? 0.2f : f9, (i2 & 4096) != 0 ? 0.05f : f10, (i2 & 8192) != 0 ? 84.0f : f11, (i2 & 16384) != 0 ? 2000L : j, (i2 & 32768) != 0 ? false : z2, (i2 & 65536) != 0 ? 60.0f : f12, (i2 & 131072) != 0 ? 0L : j2);
    }

    public ProcessingLightConfig(boolean z, @NotNull BlendMode blendMode, @NotNull PointF lightPos, float f, float f4, float f5, @ColorInt int i, float f6, float f7, @Nullable Integer num, float f8, float f9, float f10, float f11, long j, boolean z2, float f12, long j2) {
        Intrinsics.checkNotNullParameter(blendMode, "blendMode");
        Intrinsics.checkNotNullParameter(lightPos, "lightPos");
        this.useLightnessCalibration = z;
        this.blendMode = blendMode;
        this.lightPos = lightPos;
        this.lightAngle = f;
        this.lightScale = f4;
        this.lightStretch = f5;
        this.lightColor = i;
        this.lightIntensity = f6;
        this.lightSaturation = f7;
        this.domainColor = num;
        this.domainStrength = f8;
        this.domainDeltaRatio = f9;
        this.ditherVariation = f10;
        this.angle = f11;
        this.durationInMillis = j;
        this.useDynamicDomainColor = z2;
        this.frameRate = f12;
        this.repeatDelay = j2;
    }
}
