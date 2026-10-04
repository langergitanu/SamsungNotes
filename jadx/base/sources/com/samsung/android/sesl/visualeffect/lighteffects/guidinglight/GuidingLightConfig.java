package com.samsung.android.sesl.visualeffect.lighteffects.guidinglight;

import android.graphics.Color;
import android.graphics.PointF;
import androidx.annotation.RequiresApi;
import androidx.collection.AbstractC0622a;
import androidx.glance.AbstractC2821a;
import com.samsung.android.sesl.visualeffect.lighteffects.common.config.BaseVibeEffectConfig;
import com.samsung.android.sesl.visualeffect.lighteffects.guidinglight.GuidingLightEffect;
import com.samsung.android.sesl.visualeffect.lighteffects.guidinglight.GuidingLightRenderEffect;
import com.samsung.android.sesl.visualeffect.lighteffects.radialgrad.PresetEffectColor;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.metadata.VMetaDataKey;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@RequiresApi(33)
@Metadata(m13885d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\bg\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0087\b\u0018\u0000 \u0097\u00012\u00020\u0001:\b\u0094\u0001\u0095\u0001\u0096\u0001\u0097\u0001B\u0097\u0002\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\r\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r\u0012\b\b\u0002\u0010\u0012\u001a\u00020\r\u0012\b\b\u0002\u0010\u0013\u001a\u00020\r\u0012\b\b\u0002\u0010\u0014\u001a\u00020\r\u0012\b\b\u0002\u0010\u0015\u001a\u00020\r\u0012\b\b\u0002\u0010\u0016\u001a\u00020\r\u0012\b\b\u0002\u0010\u0017\u001a\u00020\r\u0012\b\b\u0002\u0010\u0018\u001a\u00020\r\u0012\b\b\u0002\u0010\u0019\u001a\u00020\r\u0012\b\b\u0002\u0010\u001a\u001a\u00020\r\u0012\b\b\u0002\u0010\u001b\u001a\u00020\r\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u001d\u0012\b\b\u0002\u0010\u001e\u001a\u00020\r\u0012\b\b\u0002\u0010\u001f\u001a\u00020\r\u0012\b\b\u0002\u0010 \u001a\u00020\r\u0012\b\b\u0002\u0010!\u001a\u00020\"\u0012\b\b\u0002\u0010#\u001a\u00020\r\u0012\b\b\u0002\u0010$\u001a\u00020%¢\u0006\u0004\b&\u0010'B\u0011\b\u0017\u0012\u0006\u0010(\u001a\u00020\u0000¢\u0006\u0004\b&\u0010)J\t\u0010p\u001a\u00020\u0003HÆ\u0003J\t\u0010q\u001a\u00020\u0005HÆ\u0003J\t\u0010r\u001a\u00020\u0007HÆ\u0003J\t\u0010s\u001a\u00020\tHÆ\u0003J\t\u0010t\u001a\u00020\u000bHÆ\u0003J\t\u0010u\u001a\u00020\rHÆ\u0003J\t\u0010v\u001a\u00020\rHÆ\u0003J\t\u0010w\u001a\u00020\rHÆ\u0003J\t\u0010x\u001a\u00020\rHÆ\u0003J\t\u0010y\u001a\u00020\rHÆ\u0003J\t\u0010z\u001a\u00020\rHÆ\u0003J\t\u0010{\u001a\u00020\rHÆ\u0003J\t\u0010|\u001a\u00020\rHÆ\u0003J\t\u0010}\u001a\u00020\rHÆ\u0003J\t\u0010~\u001a\u00020\rHÆ\u0003J\t\u0010\u007f\u001a\u00020\rHÆ\u0003J\n\u0010\u0080\u0001\u001a\u00020\rHÆ\u0003J\n\u0010\u0081\u0001\u001a\u00020\rHÆ\u0003J\n\u0010\u0082\u0001\u001a\u00020\rHÆ\u0003J\n\u0010\u0083\u0001\u001a\u00020\rHÆ\u0003J\n\u0010\u0084\u0001\u001a\u00020\u001dHÆ\u0003J\n\u0010\u0085\u0001\u001a\u00020\rHÆ\u0003J\n\u0010\u0086\u0001\u001a\u00020\rHÆ\u0003J\n\u0010\u0087\u0001\u001a\u00020\rHÆ\u0003J\n\u0010\u0088\u0001\u001a\u00020\"HÆ\u0003J\n\u0010\u0089\u0001\u001a\u00020\rHÆ\u0003J\n\u0010\u008a\u0001\u001a\u00020%HÆ\u0003J\u0098\u0002\u0010\u008b\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\r2\b\b\u0002\u0010\u0014\u001a\u00020\r2\b\b\u0002\u0010\u0015\u001a\u00020\r2\b\b\u0002\u0010\u0016\u001a\u00020\r2\b\b\u0002\u0010\u0017\u001a\u00020\r2\b\b\u0002\u0010\u0018\u001a\u00020\r2\b\b\u0002\u0010\u0019\u001a\u00020\r2\b\b\u0002\u0010\u001a\u001a\u00020\r2\b\b\u0002\u0010\u001b\u001a\u00020\r2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\r2\b\b\u0002\u0010\u001f\u001a\u00020\r2\b\b\u0002\u0010 \u001a\u00020\r2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\r2\b\b\u0002\u0010$\u001a\u00020%HÆ\u0001J\u0017\u0010\u008c\u0001\u001a\u00030\u008d\u00012\n\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u008f\u0001HÖ\u0003J\u000b\u0010\u0090\u0001\u001a\u00030\u0091\u0001HÖ\u0001J\u000b\u0010\u0092\u0001\u001a\u00030\u0093\u0001HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001a\u0010\u000e\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010=\"\u0004\bA\u0010?R\u001a\u0010\u000f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010=\"\u0004\bC\u0010?R\u001a\u0010\u0010\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010=\"\u0004\bE\u0010?R\u001a\u0010\u0011\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010=\"\u0004\bG\u0010?R\u001a\u0010\u0012\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010=\"\u0004\bI\u0010?R\u001a\u0010\u0013\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010=\"\u0004\bK\u0010?R\u001a\u0010\u0014\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010=\"\u0004\bM\u0010?R\u001a\u0010\u0015\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010=\"\u0004\bO\u0010?R\u001a\u0010\u0016\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010=\"\u0004\bQ\u0010?R\u001a\u0010\u0017\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010=\"\u0004\bS\u0010?R\u001a\u0010\u0018\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010=\"\u0004\bU\u0010?R\u001a\u0010\u0019\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010=\"\u0004\bW\u0010?R\u001a\u0010\u001a\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010=\"\u0004\bY\u0010?R\u001a\u0010\u001b\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010=\"\u0004\b[\u0010?R\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R\u001a\u0010\u001e\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010=\"\u0004\ba\u0010?R\u001a\u0010\u001f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010=\"\u0004\bc\u0010?R\u001a\u0010 \u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010=\"\u0004\be\u0010?R\u001a\u0010!\u001a\u00020\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010g\"\u0004\bh\u0010iR\u001a\u0010#\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u0010=\"\u0004\bk\u0010?R\u001a\u0010$\u001a\u00020%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bl\u0010m\"\u0004\bn\u0010o¨\u0006\u0098\u0001"}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/lighteffects/guidinglight/GuidingLightConfig;", "Lcom/samsung/android/sesl/visualeffect/lighteffects/common/config/BaseVibeEffectConfig;", VMetaDataKey.META_KEY_SHAPE, "Lcom/samsung/android/sesl/visualeffect/lighteffects/guidinglight/GuidingLightConfig$Shape;", "roundRectDirection", "Lcom/samsung/android/sesl/visualeffect/lighteffects/guidinglight/GuidingLightConfig$RoundRectDirection;", "colorState", "Lcom/samsung/android/sesl/visualeffect/lighteffects/radialgrad/PresetEffectColor$State;", "lightBaseColor", "Landroid/graphics/Color;", "lightPos", "Landroid/graphics/PointF;", "lightRadius", "", "lightIntensity", "glowIntensity", "glowRadius", "glowSharpness", "reflLightIntensity", "reflLightRadius", "reflAlbedo", "globalLuminance", "ditherVariation", "saturation", "outerSaturation", "stretch", "stretchDirLit", "initialViewAlpha", "lightMovement", "Lcom/samsung/android/sesl/visualeffect/lighteffects/guidinglight/GuidingLightEffect$Movement;", "frameRate", "outlineThickness", "boundarySmoothWidth", "shaderPrecision", "Lcom/samsung/android/sesl/visualeffect/lighteffects/guidinglight/GuidingLightConfig$ShaderPrecision;", "touchIntensity", "lightMovementInterval", "", "<init>", "(Lcom/samsung/android/sesl/visualeffect/lighteffects/guidinglight/GuidingLightConfig$Shape;Lcom/samsung/android/sesl/visualeffect/lighteffects/guidinglight/GuidingLightConfig$RoundRectDirection;Lcom/samsung/android/sesl/visualeffect/lighteffects/radialgrad/PresetEffectColor$State;Landroid/graphics/Color;Landroid/graphics/PointF;FFFFFFFFFFFFFFFLcom/samsung/android/sesl/visualeffect/lighteffects/guidinglight/GuidingLightEffect$Movement;FFFLcom/samsung/android/sesl/visualeffect/lighteffects/guidinglight/GuidingLightConfig$ShaderPrecision;FJ)V", "source", "(Lcom/samsung/android/sesl/visualeffect/lighteffects/guidinglight/GuidingLightConfig;)V", "getShape", "()Lcom/samsung/android/sesl/visualeffect/lighteffects/guidinglight/GuidingLightConfig$Shape;", "setShape", "(Lcom/samsung/android/sesl/visualeffect/lighteffects/guidinglight/GuidingLightConfig$Shape;)V", "getRoundRectDirection", "()Lcom/samsung/android/sesl/visualeffect/lighteffects/guidinglight/GuidingLightConfig$RoundRectDirection;", "getColorState", "()Lcom/samsung/android/sesl/visualeffect/lighteffects/radialgrad/PresetEffectColor$State;", "setColorState", "(Lcom/samsung/android/sesl/visualeffect/lighteffects/radialgrad/PresetEffectColor$State;)V", "getLightBaseColor", "()Landroid/graphics/Color;", "setLightBaseColor", "(Landroid/graphics/Color;)V", "getLightPos", "()Landroid/graphics/PointF;", "setLightPos", "(Landroid/graphics/PointF;)V", "getLightRadius", "()F", "setLightRadius", "(F)V", "getLightIntensity", "setLightIntensity", "getGlowIntensity", "setGlowIntensity", "getGlowRadius", "setGlowRadius", "getGlowSharpness", "setGlowSharpness", "getReflLightIntensity", "setReflLightIntensity", "getReflLightRadius", "setReflLightRadius", "getReflAlbedo", "setReflAlbedo", "getGlobalLuminance", "setGlobalLuminance", "getDitherVariation", "setDitherVariation", "getSaturation", "setSaturation", "getOuterSaturation", "setOuterSaturation", "getStretch", "setStretch", "getStretchDirLit", "setStretchDirLit", "getInitialViewAlpha", "setInitialViewAlpha", "getLightMovement", "()Lcom/samsung/android/sesl/visualeffect/lighteffects/guidinglight/GuidingLightEffect$Movement;", "setLightMovement", "(Lcom/samsung/android/sesl/visualeffect/lighteffects/guidinglight/GuidingLightEffect$Movement;)V", "getFrameRate", "setFrameRate", "getOutlineThickness", "setOutlineThickness", "getBoundarySmoothWidth", "setBoundarySmoothWidth", "getShaderPrecision", "()Lcom/samsung/android/sesl/visualeffect/lighteffects/guidinglight/GuidingLightConfig$ShaderPrecision;", "setShaderPrecision", "(Lcom/samsung/android/sesl/visualeffect/lighteffects/guidinglight/GuidingLightConfig$ShaderPrecision;)V", "getTouchIntensity", "setTouchIntensity", "getLightMovementInterval", "()J", "setLightMovementInterval", "(J)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "Shape", "RoundRectDirection", "ShaderPrecision", "Companion", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nGuidingLightConfig.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GuidingLightConfig.kt\ncom/samsung/android/sesl/visualeffect/lighteffects/guidinglight/GuidingLightConfig\n+ 2 Color.kt\nandroidx/core/graphics/ColorKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,337:1\n470#2:338\n470#2:340\n470#2:341\n1#3:339\n*S KotlinDebug\n*F\n+ 1 GuidingLightConfig.kt\ncom/samsung/android/sesl/visualeffect/lighteffects/guidinglight/GuidingLightConfig\n*L\n16#1:338\n299#1:340\n322#1:341\n*E\n"})
public final /* data */ class GuidingLightConfig extends BaseVibeEffectConfig {

    @JvmField
    @NotNull
    public static final GuidingLightConfig ACTION_DARK;

    @JvmField
    @NotNull
    public static final GuidingLightConfig ACTION_LIGHT;

    @JvmField
    @NotNull
    public static final GuidingLightConfig BUTTON_DARK;

    @JvmField
    @NotNull
    public static final GuidingLightConfig BUTTON_LIGHT;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @JvmField
    @NotNull
    public static final GuidingLightConfig DEFAULT;

    @JvmField
    @NotNull
    public static final GuidingLightConfig DEFAULT_DARK;

    @JvmField
    @NotNull
    public static final GuidingLightConfig DEFAULT_LIGHT;

    @JvmField
    @NotNull
    public static final GuidingLightConfig NUDGE;

    @JvmField
    @NotNull
    public static final GuidingLightConfig NUDGE_AUTOMATION_DARK;

    @JvmField
    @NotNull
    public static final GuidingLightConfig NUDGE_AUTOMATION_LIGHT;

    @JvmField
    @NotNull
    public static final GuidingLightConfig NUDGE_DARK;

    @JvmField
    @NotNull
    public static final GuidingLightConfig NUDGE_LIGHT;

    @JvmField
    @NotNull
    public static final GuidingLightConfig PROCESSING_85;

    @JvmField
    @NotNull
    public static final GuidingLightConfig RESULT;

    @JvmField
    @NotNull
    public static final GuidingLightConfig RESULT_DARK;

    @JvmField
    @NotNull
    public static final GuidingLightConfig RESULT_LIGHT;

    @NotNull
    public static final String TAG = "GuidingLightConfig";
    public static final float TOUCH_INTENSITY = 0.6f;

    @NotNull
    private static final GuidingLightConfig VI_CONFIG_DEFAULT;

    @NotNull
    private static final GuidingLightConfig VI_CONFIG_DEFAULT_DARK;

    @NotNull
    private static final GuidingLightConfig VI_CONFIG_DEFAULT_LIGHT;
    private float boundarySmoothWidth;

    @NotNull
    private PresetEffectColor.State colorState;
    private float ditherVariation;
    private float frameRate;
    private float globalLuminance;
    private float glowIntensity;
    private float glowRadius;
    private float glowSharpness;
    private float initialViewAlpha;

    @NotNull
    private Color lightBaseColor;
    private float lightIntensity;

    @NotNull
    private GuidingLightEffect.Movement lightMovement;
    private long lightMovementInterval;

    @NotNull
    private PointF lightPos;
    private float lightRadius;
    private float outerSaturation;
    private float outlineThickness;
    private float reflAlbedo;
    private float reflLightIntensity;
    private float reflLightRadius;

    @NotNull
    private final RoundRectDirection roundRectDirection;
    private float saturation;

    @NotNull
    private ShaderPrecision shaderPrecision;

    @NotNull
    private Shape shape;
    private float stretch;
    private float stretchDirLit;
    private float touchIntensity;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u0003\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u0003\u001a\u0004\b\u000f\u0010\fR\u001c\u0010\u0010\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u0003\u001a\u0004\b\u0012\u0010\fR\u0016\u0010\u0013\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0014\u0010\u0003R\u0010\u0010\u0015\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001c\u0010\u0003R\u0010\u0010\u001d\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001f\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b \u0010\u0003R\u0016\u0010!\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\"\u0010\u0003R\u0010\u0010#\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/lighteffects/guidinglight/GuidingLightConfig$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "TOUCH_INTENSITY", "", "VI_CONFIG_DEFAULT", "Lcom/samsung/android/sesl/visualeffect/lighteffects/guidinglight/GuidingLightConfig;", "getVI_CONFIG_DEFAULT$annotations", "getVI_CONFIG_DEFAULT", "()Lcom/samsung/android/sesl/visualeffect/lighteffects/guidinglight/GuidingLightConfig;", "VI_CONFIG_DEFAULT_LIGHT", "getVI_CONFIG_DEFAULT_LIGHT$annotations", "getVI_CONFIG_DEFAULT_LIGHT", "VI_CONFIG_DEFAULT_DARK", "getVI_CONFIG_DEFAULT_DARK$annotations", "getVI_CONFIG_DEFAULT_DARK", "DEFAULT", "getDEFAULT$annotations", "BUTTON_LIGHT", "BUTTON_DARK", "DEFAULT_LIGHT", "DEFAULT_DARK", "ACTION_LIGHT", "ACTION_DARK", "PROCESSING_85", "getPROCESSING_85$annotations", "RESULT_LIGHT", "RESULT_DARK", "RESULT", "getRESULT$annotations", "NUDGE", "getNUDGE$annotations", "NUDGE_LIGHT", "NUDGE_DARK", "NUDGE_AUTOMATION_LIGHT", "NUDGE_AUTOMATION_DARK", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Deprecated(message = "This config is not used since OneUI 8.5. Use specific preset configs like BUTTON_LIGHT, ACTION_LIGHT, etc.")
        public static /* synthetic */ void getDEFAULT$annotations() {
        }

        @Deprecated(message = "Do not use this config, use NUDGE_LIGHT and NUDGE_DARK instead")
        public static /* synthetic */ void getNUDGE$annotations() {
        }

        @Deprecated(message = "Do not use this config on application, only for testing")
        public static /* synthetic */ void getPROCESSING_85$annotations() {
        }

        @Deprecated(message = "Do not use this config, use RESULT_LIGHT and RESULT_DARK instead")
        public static /* synthetic */ void getRESULT$annotations() {
        }

        @Deprecated(message = "Use DEFAULT instead of this constant. This will be removed in the future.")
        public static /* synthetic */ void getVI_CONFIG_DEFAULT$annotations() {
        }

        @Deprecated(message = "Use DEFAULT_DARK instead of this constant. This will be removed in the future.")
        public static /* synthetic */ void getVI_CONFIG_DEFAULT_DARK$annotations() {
        }

        @Deprecated(message = "Use DEFAULT_LIGHT instead of this constant. This will be removed in the future.")
        public static /* synthetic */ void getVI_CONFIG_DEFAULT_LIGHT$annotations() {
        }

        @NotNull
        public final GuidingLightConfig getVI_CONFIG_DEFAULT() {
            return GuidingLightConfig.VI_CONFIG_DEFAULT;
        }

        @NotNull
        public final GuidingLightConfig getVI_CONFIG_DEFAULT_DARK() {
            return GuidingLightConfig.VI_CONFIG_DEFAULT_DARK;
        }

        @NotNull
        public final GuidingLightConfig getVI_CONFIG_DEFAULT_LIGHT() {
            return GuidingLightConfig.VI_CONFIG_DEFAULT_LIGHT;
        }

        private Companion() {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/lighteffects/guidinglight/GuidingLightConfig$RoundRectDirection;", "", "vector", "Landroid/graphics/PointF;", "<init>", "(Ljava/lang/String;ILandroid/graphics/PointF;)V", "getVector", "()Landroid/graphics/PointF;", "ALL", "UP", "RIGHT", "DOWN", "LEFT", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class RoundRectDirection {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ RoundRectDirection[] $VALUES;

        @NotNull
        private final PointF vector;
        public static final RoundRectDirection ALL = new RoundRectDirection("ALL", 0, new PointF(0.0f, 0.0f));

        /* JADX INFO: renamed from: UP */
        public static final RoundRectDirection f5272UP = new RoundRectDirection("UP", 1, new PointF(0.0f, -1.0f));
        public static final RoundRectDirection RIGHT = new RoundRectDirection("RIGHT", 2, new PointF(1.0f, 0.0f));
        public static final RoundRectDirection DOWN = new RoundRectDirection("DOWN", 3, new PointF(0.0f, 1.0f));
        public static final RoundRectDirection LEFT = new RoundRectDirection("LEFT", 4, new PointF(-1.0f, 0.0f));

        private static final /* synthetic */ RoundRectDirection[] $values() {
            return new RoundRectDirection[]{ALL, f5272UP, RIGHT, DOWN, LEFT};
        }

        static {
            RoundRectDirection[] roundRectDirectionArr$values = $values();
            $VALUES = roundRectDirectionArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(roundRectDirectionArr$values);
        }

        private RoundRectDirection(String str, int i, PointF pointF) {
            this.vector = pointF;
        }

        @NotNull
        public static EnumEntries<RoundRectDirection> getEntries() {
            return $ENTRIES;
        }

        public static RoundRectDirection valueOf(String str) {
            return (RoundRectDirection) Enum.valueOf(RoundRectDirection.class, str);
        }

        public static RoundRectDirection[] values() {
            return (RoundRectDirection[]) $VALUES.clone();
        }

        @NotNull
        public final PointF getVector() {
            return this.vector;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B1\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000ej\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/lighteffects/guidinglight/GuidingLightConfig$ShaderPrecision;", "", "level", "", "description", "", "colorPrecision", "geometryPrecision", "coordinatePrecision", "<init>", "(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getLevel", "()I", "getDescription", "()Ljava/lang/String;", "getColorPrecision", "getGeometryPrecision", "getCoordinatePrecision", "LEVEL_0", "LEVEL_1", "LEVEL_2", "LEVEL_3", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class ShaderPrecision {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ShaderPrecision[] $VALUES;
        public static final ShaderPrecision LEVEL_0 = new ShaderPrecision("LEVEL_0", 0, 0, "Ultra Low Power", "lowp", "lowp", "mediump");
        public static final ShaderPrecision LEVEL_1 = new ShaderPrecision("LEVEL_1", 1, 1, "Low Power", "lowp", "mediump", "mediump");
        public static final ShaderPrecision LEVEL_2 = new ShaderPrecision("LEVEL_2", 2, 2, "Balanced", "mediump", "highp", "highp");
        public static final ShaderPrecision LEVEL_3 = new ShaderPrecision("LEVEL_3", 3, 3, "High Quality", "highp", "highp", "highp");

        @NotNull
        private final String colorPrecision;

        @NotNull
        private final String coordinatePrecision;

        @NotNull
        private final String description;

        @NotNull
        private final String geometryPrecision;
        private final int level;

        private static final /* synthetic */ ShaderPrecision[] $values() {
            return new ShaderPrecision[]{LEVEL_0, LEVEL_1, LEVEL_2, LEVEL_3};
        }

        static {
            ShaderPrecision[] shaderPrecisionArr$values = $values();
            $VALUES = shaderPrecisionArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(shaderPrecisionArr$values);
        }

        private ShaderPrecision(String str, int i, int i2, String str2, String str3, String str4, String str5) {
            this.level = i2;
            this.description = str2;
            this.colorPrecision = str3;
            this.geometryPrecision = str4;
            this.coordinatePrecision = str5;
        }

        @NotNull
        public static EnumEntries<ShaderPrecision> getEntries() {
            return $ENTRIES;
        }

        public static ShaderPrecision valueOf(String str) {
            return (ShaderPrecision) Enum.valueOf(ShaderPrecision.class, str);
        }

        public static ShaderPrecision[] values() {
            return (ShaderPrecision[]) $VALUES.clone();
        }

        @NotNull
        public final String getColorPrecision() {
            return this.colorPrecision;
        }

        @NotNull
        public final String getCoordinatePrecision() {
            return this.coordinatePrecision;
        }

        @NotNull
        public final String getDescription() {
            return this.description;
        }

        @NotNull
        public final String getGeometryPrecision() {
            return this.geometryPrecision;
        }

        public final int getLevel() {
            return this.level;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/lighteffects/guidinglight/GuidingLightConfig$Shape;", "", "<init>", "(Ljava/lang/String;I)V", "RoundRect", "Circle", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Shape {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Shape[] $VALUES;
        public static final Shape RoundRect = new Shape("RoundRect", 0);
        public static final Shape Circle = new Shape("Circle", 1);

        private static final /* synthetic */ Shape[] $values() {
            return new Shape[]{RoundRect, Circle};
        }

        static {
            Shape[] shapeArr$values = $values();
            $VALUES = shapeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(shapeArr$values);
        }

        private Shape(String str, int i) {
        }

        @NotNull
        public static EnumEntries<Shape> getEntries() {
            return $ENTRIES;
        }

        public static Shape valueOf(String str) {
            return (Shape) Enum.valueOf(Shape.class, str);
        }

        public static Shape[] values() {
            return (Shape[]) $VALUES.clone();
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
        float f9 = 0.0f;
        float f10 = 0.0f;
        float f11 = 0.0f;
        float f12 = 0.0f;
        float f13 = 0.0f;
        float f14 = 0.0f;
        float f15 = 0.0f;
        float f16 = 0.0f;
        float f17 = 0.0f;
        float f18 = 0.0f;
        VI_CONFIG_DEFAULT = new GuidingLightConfig(null, null, null, null, null, 0.0f, f, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, null, 0.0f, f17, f18, null, 0.0f, 0L, 134217727, null);
        float f19 = 0.0f;
        float f20 = 0.0f;
        GuidingLightConfig guidingLightConfig = new GuidingLightConfig(0 == true ? 1 : 0, 0 == true ? 1 : 0, 0 == true ? 1 : 0, 0 == true ? 1 : 0, null, f, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f19, null, f17, f18, f20, null, 0.0f, 0L, 134217727, null);
        guidingLightConfig.saturation = 1.15f;
        VI_CONFIG_DEFAULT_LIGHT = guidingLightConfig;
        float f21 = 0.0f;
        float f22 = 0.0f;
        GuidingLightConfig guidingLightConfig2 = new GuidingLightConfig(0 == true ? 1 : 0, 0 == true ? 1 : 0, 0 == true ? 1 : 0, 0 == true ? 1 : 0, null, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f19, f21, null, f18, f20, f22, null, 0.0f, 0L, 134217727, null);
        guidingLightConfig2.saturation = 1.25f;
        VI_CONFIG_DEFAULT_DARK = guidingLightConfig2;
        float f23 = 0.0f;
        float f24 = 0.0f;
        DEFAULT = new GuidingLightConfig(0 == true ? 1 : 0, 0 == true ? 1 : 0, 0 == true ? 1 : 0, 0 == true ? 1 : 0, null, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f19, f21, f23, null, f20, f22, f24, null, 0.0f, 0L, 134217727, null);
        GuidingLightConfig guidingLightConfig3 = new GuidingLightConfig(0 == true ? 1 : 0, 0 == true ? 1 : 0, 0 == true ? 1 : 0, 0 == true ? 1 : 0, null, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f19, f21, f23, 0.0f, null, f22, f24, 0.0f, null, 0.0f, 0L, 134217727, null);
        guidingLightConfig3.lightRadius = 3.0f;
        guidingLightConfig3.lightIntensity = 0.27f;
        guidingLightConfig3.glowIntensity = 0.2f;
        guidingLightConfig3.glowRadius = 2.0f;
        guidingLightConfig3.glowSharpness = 20.0f;
        guidingLightConfig3.reflLightIntensity = 0.85f;
        guidingLightConfig3.reflLightRadius = 2.0f;
        guidingLightConfig3.reflAlbedo = 0.15f;
        guidingLightConfig3.ditherVariation = 0.0f;
        guidingLightConfig3.globalLuminance = 1.1f;
        guidingLightConfig3.saturation = 1.16f;
        guidingLightConfig3.outerSaturation = 1.03f;
        guidingLightConfig3.stretch = 1.0f;
        guidingLightConfig3.stretchDirLit = 0.0f;
        guidingLightConfig3.outlineThickness = 75.0f;
        guidingLightConfig3.boundarySmoothWidth = 0.008f;
        guidingLightConfig3.colorState = PresetEffectColor.State.Button;
        GuidingLightEffect.Movement movement = GuidingLightEffect.Movement.NONE;
        guidingLightConfig3.lightMovement = movement;
        BUTTON_LIGHT = guidingLightConfig3;
        GuidingLightConfig guidingLightConfigCopy$default = copy$default(guidingLightConfig3, null, null, null, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, 0.0f, 0.0f, 0.0f, null, 0.0f, 0L, 134217727, null);
        guidingLightConfigCopy$default.lightIntensity = 0.5f;
        guidingLightConfigCopy$default.glowSharpness = 30.0f;
        guidingLightConfigCopy$default.globalLuminance = 1.15f;
        guidingLightConfigCopy$default.outerSaturation = 0.5f;
        guidingLightConfigCopy$default.outlineThickness = 80.0f;
        BUTTON_DARK = guidingLightConfigCopy$default;
        DEFAULT_LIGHT = guidingLightConfig3;
        DEFAULT_DARK = guidingLightConfigCopy$default;
        GuidingLightConfig guidingLightConfig4 = new GuidingLightConfig(null, null, null, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, 0.0f, 0.0f, 0.0f, null, 0.0f, 0L, 134217727, null);
        guidingLightConfig4.lightRadius = 3.0f;
        guidingLightConfig4.lightIntensity = 0.27f;
        guidingLightConfig4.glowIntensity = 0.2f;
        guidingLightConfig4.glowRadius = 2.0f;
        guidingLightConfig4.glowSharpness = 20.0f;
        guidingLightConfig4.reflLightIntensity = 0.85f;
        guidingLightConfig4.reflLightRadius = 2.0f;
        guidingLightConfig4.reflAlbedo = 0.15f;
        guidingLightConfig4.ditherVariation = 0.0f;
        guidingLightConfig4.globalLuminance = 1.0f;
        guidingLightConfig4.saturation = 1.16f;
        guidingLightConfig4.outerSaturation = 1.03f;
        guidingLightConfig4.stretch = 1.0f;
        guidingLightConfig4.stretchDirLit = 0.0f;
        guidingLightConfig4.outlineThickness = 45.0f;
        guidingLightConfig4.colorState = PresetEffectColor.State.Action;
        ACTION_LIGHT = guidingLightConfig4;
        float f25 = 0.0f;
        float f26 = 0.0f;
        float f27 = 0.0f;
        float f28 = 0.0f;
        float f29 = 0.0f;
        float f30 = 0.0f;
        float f31 = 0.0f;
        float f32 = 0.0f;
        float f33 = 0.0f;
        float f34 = 0.0f;
        float f35 = 0.0f;
        float f36 = 0.0f;
        float f37 = 0.0f;
        GuidingLightConfig guidingLightConfigCopy$default2 = copy$default(guidingLightConfig4, null, null, null, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, 0.0f, 0.0f, 0.0f, null, 0.0f, 0L, 134217727, null);
        guidingLightConfigCopy$default2.lightIntensity = 0.5f;
        guidingLightConfigCopy$default2.glowIntensity = 0.3f;
        guidingLightConfigCopy$default2.glowSharpness = 25.0f;
        guidingLightConfigCopy$default2.globalLuminance = 1.0f;
        guidingLightConfigCopy$default2.outerSaturation = 0.6f;
        ACTION_DARK = guidingLightConfigCopy$default2;
        GuidingLightConfig guidingLightConfig5 = new GuidingLightConfig(null, null, null, null, null, f25, f26, f27, f28, f29, f30, f31, f32, f33, f34, f35, 0.0f, 0.0f, f36, f37, null, 0.0f, 0.0f, 0.0f, null, 0.0f, 0L, 134217727, null);
        guidingLightConfig5.lightRadius = 3.0f;
        guidingLightConfig5.lightIntensity = 0.3f;
        guidingLightConfig5.glowIntensity = 0.2f;
        guidingLightConfig5.glowRadius = 2.0f;
        guidingLightConfig5.glowSharpness = 20.0f;
        guidingLightConfig5.reflLightIntensity = 0.85f;
        guidingLightConfig5.reflLightRadius = 2.0f;
        guidingLightConfig5.reflAlbedo = 0.15f;
        guidingLightConfig5.ditherVariation = 0.0f;
        guidingLightConfig5.globalLuminance = 1.0f;
        guidingLightConfig5.saturation = 1.16f;
        guidingLightConfig5.outerSaturation = 1.03f;
        guidingLightConfig5.stretch = 1.0f;
        guidingLightConfig5.stretchDirLit = 0.0f;
        guidingLightConfig5.outlineThickness = 0.0f;
        guidingLightConfig5.colorState = PresetEffectColor.State.Processing85;
        PROCESSING_85 = guidingLightConfig5;
        GuidingLightConfig guidingLightConfigCopy$default3 = copy$default(guidingLightConfig4, null, null, null, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, 0.0f, 0.0f, 0.0f, null, 0.0f, 0L, 134217727, null);
        guidingLightConfigCopy$default3.lightPos = new PointF(0.5f, -0.1f);
        guidingLightConfigCopy$default3.lightRadius = 2.2f;
        guidingLightConfigCopy$default3.lightIntensity = 0.5f;
        guidingLightConfigCopy$default3.outlineThickness = 45.0f;
        PresetEffectColor.State state = PresetEffectColor.State.Result;
        guidingLightConfigCopy$default3.colorState = state;
        guidingLightConfigCopy$default3.lightMovement = movement;
        RESULT_LIGHT = guidingLightConfigCopy$default3;
        GuidingLightConfig guidingLightConfigCopy$default4 = copy$default(guidingLightConfigCopy$default2, null, null, null, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, 0.0f, 0.0f, 0.0f, null, 0.0f, 0L, 134217727, null);
        guidingLightConfigCopy$default4.lightPos = new PointF(0.5f, -0.1f);
        guidingLightConfigCopy$default4.lightRadius = 2.2f;
        guidingLightConfigCopy$default4.lightIntensity = 0.25f;
        guidingLightConfigCopy$default4.colorState = state;
        guidingLightConfigCopy$default4.lightMovement = movement;
        RESULT_DARK = guidingLightConfigCopy$default4;
        RESULT = copy$default(guidingLightConfigCopy$default3, null, null, null, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, 0.0f, 0.0f, 0.0f, null, 0.0f, 0L, 134217727, null);
        float f38 = 0.0f;
        float f39 = 0.0f;
        float f40 = 0.0f;
        GuidingLightConfig guidingLightConfig6 = new GuidingLightConfig(null, null, null, 0 == true ? 1 : 0, null, 0.0f, 0.0f, 0.0f, f25, f26, f27, f28, f29, f30, f31, f32, f33, f34, f35, f38, null, f36, f37, f39, null, f40, 0L, 134217727, null);
        guidingLightConfig6.lightRadius = 3.0f;
        guidingLightConfig6.lightIntensity = 0.1f;
        guidingLightConfig6.glowIntensity = 0.45f;
        guidingLightConfig6.glowRadius = 6.0f;
        guidingLightConfig6.glowSharpness = 20.0f;
        guidingLightConfig6.reflLightIntensity = 0.55f;
        guidingLightConfig6.reflLightRadius = 1.85f;
        guidingLightConfig6.reflAlbedo = 0.15f;
        guidingLightConfig6.ditherVariation = 0.0f;
        guidingLightConfig6.globalLuminance = 1.1f;
        guidingLightConfig6.saturation = 1.0f;
        guidingLightConfig6.outerSaturation = 1.0f;
        guidingLightConfig6.stretch = 1.0f;
        guidingLightConfig6.stretchDirLit = 0.0f;
        guidingLightConfig6.outlineThickness = 55.0f;
        guidingLightConfig6.lightMovement = movement;
        PresetEffectColor.State state2 = PresetEffectColor.State.Nudge;
        guidingLightConfig6.colorState = state2;
        NUDGE = guidingLightConfig6;
        float f41 = 0.0f;
        float f42 = 0.0f;
        float f43 = 0.0f;
        GuidingLightConfig guidingLightConfig7 = new GuidingLightConfig(0 == true ? 1 : 0, null, null, null, null, f26, f27, f28, f29, f30, f31, f32, f33, f34, f35, f38, f41, f36, f37, f39, 0 == true ? 1 : 0, f40, f42, f43, null, 0.0f, 0L, 134217727, null);
        guidingLightConfig7.lightRadius = 3.0f;
        guidingLightConfig7.lightIntensity = 0.1f;
        guidingLightConfig7.glowIntensity = 0.45f;
        guidingLightConfig7.glowRadius = 6.0f;
        guidingLightConfig7.glowSharpness = 20.0f;
        guidingLightConfig7.reflLightIntensity = 0.55f;
        guidingLightConfig7.reflLightRadius = 1.85f;
        guidingLightConfig7.reflAlbedo = 0.15f;
        guidingLightConfig7.ditherVariation = 0.0f;
        guidingLightConfig7.globalLuminance = 1.1f;
        guidingLightConfig7.saturation = 1.0f;
        guidingLightConfig7.outerSaturation = 1.0f;
        guidingLightConfig7.stretch = 1.0f;
        guidingLightConfig7.stretchDirLit = 0.0f;
        guidingLightConfig7.outlineThickness = 55.0f;
        guidingLightConfig7.touchIntensity = 0.1f;
        guidingLightConfig7.lightBaseColor = Color.valueOf(Color.parseColor("#FFFFFFFF"));
        guidingLightConfig7.lightMovement = movement;
        guidingLightConfig7.colorState = state2;
        NUDGE_LIGHT = guidingLightConfig7;
        GuidingLightConfig guidingLightConfig8 = new GuidingLightConfig(0 == true ? 1 : 0, 0 == true ? 1 : 0, 0 == true ? 1 : 0, 0 == true ? 1 : 0, null, f27, f28, f29, f30, f31, f32, f33, f34, f35, f38, f41, f36, f37, f39, 0.0f, null, f42, f43, 0.0f, null, 0.0f, 0L, 134217727, null);
        guidingLightConfig8.lightRadius = 3.0f;
        guidingLightConfig8.lightIntensity = 0.05f;
        guidingLightConfig8.glowIntensity = 0.4f;
        guidingLightConfig8.glowRadius = 6.0f;
        guidingLightConfig8.glowSharpness = 20.0f;
        guidingLightConfig8.reflLightIntensity = 0.55f;
        guidingLightConfig8.reflLightRadius = 1.85f;
        guidingLightConfig8.reflAlbedo = 0.15f;
        guidingLightConfig8.ditherVariation = 0.0f;
        guidingLightConfig8.globalLuminance = 1.1f;
        guidingLightConfig8.saturation = 1.0f;
        guidingLightConfig8.outerSaturation = 1.0f;
        guidingLightConfig8.stretch = 1.0f;
        guidingLightConfig8.stretchDirLit = 0.0f;
        guidingLightConfig8.outlineThickness = 55.0f;
        guidingLightConfig8.touchIntensity = 0.1f;
        guidingLightConfig8.lightBaseColor = Color.valueOf(Color.parseColor("#FFFFFFFF"));
        guidingLightConfig8.lightMovement = movement;
        guidingLightConfig8.colorState = state2;
        NUDGE_DARK = guidingLightConfig8;
        GuidingLightConfig guidingLightConfigCopy$default5 = copy$default(guidingLightConfig7, null, null, null, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, 0.0f, 0.0f, 0.0f, null, 0.0f, 0L, 134217727, null);
        PresetEffectColor.State state3 = PresetEffectColor.State.NudgeAutomation;
        guidingLightConfigCopy$default5.colorState = state3;
        NUDGE_AUTOMATION_LIGHT = guidingLightConfigCopy$default5;
        GuidingLightConfig guidingLightConfigCopy$default6 = copy$default(guidingLightConfig8, null, null, null, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, 0.0f, 0.0f, 0.0f, null, 0.0f, 0L, 134217727, null);
        guidingLightConfigCopy$default6.colorState = state3;
        NUDGE_AUTOMATION_DARK = guidingLightConfigCopy$default6;
    }

    @JvmOverloads
    public GuidingLightConfig() {
        this(null, null, null, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, 0.0f, 0.0f, 0.0f, null, 0.0f, 0L, 134217727, null);
    }

    public static /* synthetic */ GuidingLightConfig copy$default(GuidingLightConfig guidingLightConfig, Shape shape, RoundRectDirection roundRectDirection, PresetEffectColor.State state, Color color, PointF pointF, float f, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, GuidingLightEffect.Movement movement, float f18, float f19, float f20, ShaderPrecision shaderPrecision, float f21, long j, int i, Object obj) {
        long j2;
        float f22;
        float f23;
        Shape shape2 = (i & 1) != 0 ? guidingLightConfig.shape : shape;
        RoundRectDirection roundRectDirection2 = (i & 2) != 0 ? guidingLightConfig.roundRectDirection : roundRectDirection;
        PresetEffectColor.State state2 = (i & 4) != 0 ? guidingLightConfig.colorState : state;
        Color color2 = (i & 8) != 0 ? guidingLightConfig.lightBaseColor : color;
        PointF pointF2 = (i & 16) != 0 ? guidingLightConfig.lightPos : pointF;
        float f24 = (i & 32) != 0 ? guidingLightConfig.lightRadius : f;
        float f25 = (i & 64) != 0 ? guidingLightConfig.lightIntensity : f4;
        float f26 = (i & 128) != 0 ? guidingLightConfig.glowIntensity : f5;
        float f27 = (i & 256) != 0 ? guidingLightConfig.glowRadius : f6;
        float f28 = (i & 512) != 0 ? guidingLightConfig.glowSharpness : f7;
        float f29 = (i & 1024) != 0 ? guidingLightConfig.reflLightIntensity : f8;
        float f30 = (i & 2048) != 0 ? guidingLightConfig.reflLightRadius : f9;
        float f31 = (i & 4096) != 0 ? guidingLightConfig.reflAlbedo : f10;
        float f32 = (i & 8192) != 0 ? guidingLightConfig.globalLuminance : f11;
        Shape shape3 = shape2;
        float f33 = (i & 16384) != 0 ? guidingLightConfig.ditherVariation : f12;
        float f34 = (i & 32768) != 0 ? guidingLightConfig.saturation : f13;
        float f35 = (i & 65536) != 0 ? guidingLightConfig.outerSaturation : f14;
        float f36 = (i & 131072) != 0 ? guidingLightConfig.stretch : f15;
        float f37 = (i & 262144) != 0 ? guidingLightConfig.stretchDirLit : f16;
        float f38 = (i & 524288) != 0 ? guidingLightConfig.initialViewAlpha : f17;
        GuidingLightEffect.Movement movement2 = (i & 1048576) != 0 ? guidingLightConfig.lightMovement : movement;
        float f39 = (i & 2097152) != 0 ? guidingLightConfig.frameRate : f18;
        float f40 = (i & 4194304) != 0 ? guidingLightConfig.outlineThickness : f19;
        float f41 = (i & 8388608) != 0 ? guidingLightConfig.boundarySmoothWidth : f20;
        ShaderPrecision shaderPrecision2 = (i & 16777216) != 0 ? guidingLightConfig.shaderPrecision : shaderPrecision;
        float f42 = (i & 33554432) != 0 ? guidingLightConfig.touchIntensity : f21;
        if ((i & 67108864) != 0) {
            f23 = f33;
            f22 = f42;
            j2 = guidingLightConfig.lightMovementInterval;
        } else {
            j2 = j;
            f22 = f42;
            f23 = f33;
        }
        return guidingLightConfig.copy(shape3, roundRectDirection2, state2, color2, pointF2, f24, f25, f26, f27, f28, f29, f30, f31, f32, f23, f34, f35, f36, f37, f38, movement2, f39, f40, f41, shaderPrecision2, f22, j2);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Shape getShape() {
        return this.shape;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final float getGlowSharpness() {
        return this.glowSharpness;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final float getReflLightIntensity() {
        return this.reflLightIntensity;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final float getReflLightRadius() {
        return this.reflLightRadius;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final float getReflAlbedo() {
        return this.reflAlbedo;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final float getGlobalLuminance() {
        return this.globalLuminance;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final float getDitherVariation() {
        return this.ditherVariation;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final float getSaturation() {
        return this.saturation;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final float getOuterSaturation() {
        return this.outerSaturation;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final float getStretch() {
        return this.stretch;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final float getStretchDirLit() {
        return this.stretchDirLit;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final RoundRectDirection getRoundRectDirection() {
        return this.roundRectDirection;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final float getInitialViewAlpha() {
        return this.initialViewAlpha;
    }

    @NotNull
    /* JADX INFO: renamed from: component21, reason: from getter */
    public final GuidingLightEffect.Movement getLightMovement() {
        return this.lightMovement;
    }

    /* JADX INFO: renamed from: component22, reason: from getter */
    public final float getFrameRate() {
        return this.frameRate;
    }

    /* JADX INFO: renamed from: component23, reason: from getter */
    public final float getOutlineThickness() {
        return this.outlineThickness;
    }

    /* JADX INFO: renamed from: component24, reason: from getter */
    public final float getBoundarySmoothWidth() {
        return this.boundarySmoothWidth;
    }

    @NotNull
    /* JADX INFO: renamed from: component25, reason: from getter */
    public final ShaderPrecision getShaderPrecision() {
        return this.shaderPrecision;
    }

    /* JADX INFO: renamed from: component26, reason: from getter */
    public final float getTouchIntensity() {
        return this.touchIntensity;
    }

    /* JADX INFO: renamed from: component27, reason: from getter */
    public final long getLightMovementInterval() {
        return this.lightMovementInterval;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final PresetEffectColor.State getColorState() {
        return this.colorState;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Color getLightBaseColor() {
        return this.lightBaseColor;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final PointF getLightPos() {
        return this.lightPos;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final float getLightRadius() {
        return this.lightRadius;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final float getLightIntensity() {
        return this.lightIntensity;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final float getGlowIntensity() {
        return this.glowIntensity;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final float getGlowRadius() {
        return this.glowRadius;
    }

    @NotNull
    public final GuidingLightConfig copy(@NotNull Shape shape, @NotNull RoundRectDirection roundRectDirection, @NotNull PresetEffectColor.State colorState, @NotNull Color lightBaseColor, @NotNull PointF lightPos, float lightRadius, float lightIntensity, float glowIntensity, float glowRadius, float glowSharpness, float reflLightIntensity, float reflLightRadius, float reflAlbedo, float globalLuminance, float ditherVariation, float saturation, float outerSaturation, float stretch, float stretchDirLit, float initialViewAlpha, @NotNull GuidingLightEffect.Movement lightMovement, float frameRate, float outlineThickness, float boundarySmoothWidth, @NotNull ShaderPrecision shaderPrecision, float touchIntensity, long lightMovementInterval) {
        Intrinsics.checkNotNullParameter(shape, "shape");
        Intrinsics.checkNotNullParameter(roundRectDirection, "roundRectDirection");
        Intrinsics.checkNotNullParameter(colorState, "colorState");
        Intrinsics.checkNotNullParameter(lightBaseColor, "lightBaseColor");
        Intrinsics.checkNotNullParameter(lightPos, "lightPos");
        Intrinsics.checkNotNullParameter(lightMovement, "lightMovement");
        Intrinsics.checkNotNullParameter(shaderPrecision, "shaderPrecision");
        return new GuidingLightConfig(shape, roundRectDirection, colorState, lightBaseColor, lightPos, lightRadius, lightIntensity, glowIntensity, glowRadius, glowSharpness, reflLightIntensity, reflLightRadius, reflAlbedo, globalLuminance, ditherVariation, saturation, outerSaturation, stretch, stretchDirLit, initialViewAlpha, lightMovement, frameRate, outlineThickness, boundarySmoothWidth, shaderPrecision, touchIntensity, lightMovementInterval);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuidingLightConfig)) {
            return false;
        }
        GuidingLightConfig guidingLightConfig = (GuidingLightConfig) other;
        return this.shape == guidingLightConfig.shape && this.roundRectDirection == guidingLightConfig.roundRectDirection && this.colorState == guidingLightConfig.colorState && Intrinsics.areEqual(this.lightBaseColor, guidingLightConfig.lightBaseColor) && Intrinsics.areEqual(this.lightPos, guidingLightConfig.lightPos) && Float.compare(this.lightRadius, guidingLightConfig.lightRadius) == 0 && Float.compare(this.lightIntensity, guidingLightConfig.lightIntensity) == 0 && Float.compare(this.glowIntensity, guidingLightConfig.glowIntensity) == 0 && Float.compare(this.glowRadius, guidingLightConfig.glowRadius) == 0 && Float.compare(this.glowSharpness, guidingLightConfig.glowSharpness) == 0 && Float.compare(this.reflLightIntensity, guidingLightConfig.reflLightIntensity) == 0 && Float.compare(this.reflLightRadius, guidingLightConfig.reflLightRadius) == 0 && Float.compare(this.reflAlbedo, guidingLightConfig.reflAlbedo) == 0 && Float.compare(this.globalLuminance, guidingLightConfig.globalLuminance) == 0 && Float.compare(this.ditherVariation, guidingLightConfig.ditherVariation) == 0 && Float.compare(this.saturation, guidingLightConfig.saturation) == 0 && Float.compare(this.outerSaturation, guidingLightConfig.outerSaturation) == 0 && Float.compare(this.stretch, guidingLightConfig.stretch) == 0 && Float.compare(this.stretchDirLit, guidingLightConfig.stretchDirLit) == 0 && Float.compare(this.initialViewAlpha, guidingLightConfig.initialViewAlpha) == 0 && this.lightMovement == guidingLightConfig.lightMovement && Float.compare(this.frameRate, guidingLightConfig.frameRate) == 0 && Float.compare(this.outlineThickness, guidingLightConfig.outlineThickness) == 0 && Float.compare(this.boundarySmoothWidth, guidingLightConfig.boundarySmoothWidth) == 0 && this.shaderPrecision == guidingLightConfig.shaderPrecision && Float.compare(this.touchIntensity, guidingLightConfig.touchIntensity) == 0 && this.lightMovementInterval == guidingLightConfig.lightMovementInterval;
    }

    public final float getBoundarySmoothWidth() {
        return this.boundarySmoothWidth;
    }

    @NotNull
    public final PresetEffectColor.State getColorState() {
        return this.colorState;
    }

    public final float getDitherVariation() {
        return this.ditherVariation;
    }

    public final float getFrameRate() {
        return this.frameRate;
    }

    public final float getGlobalLuminance() {
        return this.globalLuminance;
    }

    public final float getGlowIntensity() {
        return this.glowIntensity;
    }

    public final float getGlowRadius() {
        return this.glowRadius;
    }

    public final float getGlowSharpness() {
        return this.glowSharpness;
    }

    public final float getInitialViewAlpha() {
        return this.initialViewAlpha;
    }

    @NotNull
    public final Color getLightBaseColor() {
        return this.lightBaseColor;
    }

    public final float getLightIntensity() {
        return this.lightIntensity;
    }

    @NotNull
    public final GuidingLightEffect.Movement getLightMovement() {
        return this.lightMovement;
    }

    public final long getLightMovementInterval() {
        return this.lightMovementInterval;
    }

    @NotNull
    public final PointF getLightPos() {
        return this.lightPos;
    }

    public final float getLightRadius() {
        return this.lightRadius;
    }

    public final float getOuterSaturation() {
        return this.outerSaturation;
    }

    public final float getOutlineThickness() {
        return this.outlineThickness;
    }

    public final float getReflAlbedo() {
        return this.reflAlbedo;
    }

    public final float getReflLightIntensity() {
        return this.reflLightIntensity;
    }

    public final float getReflLightRadius() {
        return this.reflLightRadius;
    }

    @NotNull
    public final RoundRectDirection getRoundRectDirection() {
        return this.roundRectDirection;
    }

    public final float getSaturation() {
        return this.saturation;
    }

    @NotNull
    public final ShaderPrecision getShaderPrecision() {
        return this.shaderPrecision;
    }

    @NotNull
    public final Shape getShape() {
        return this.shape;
    }

    public final float getStretch() {
        return this.stretch;
    }

    public final float getStretchDirLit() {
        return this.stretchDirLit;
    }

    public final float getTouchIntensity() {
        return this.touchIntensity;
    }

    public int hashCode() {
        return Long.hashCode(this.lightMovementInterval) + AbstractC0622a.m1156b(this.touchIntensity, (this.shaderPrecision.hashCode() + AbstractC0622a.m1156b(this.boundarySmoothWidth, AbstractC0622a.m1156b(this.outlineThickness, AbstractC0622a.m1156b(this.frameRate, (this.lightMovement.hashCode() + AbstractC0622a.m1156b(this.initialViewAlpha, AbstractC0622a.m1156b(this.stretchDirLit, AbstractC0622a.m1156b(this.stretch, AbstractC0622a.m1156b(this.outerSaturation, AbstractC0622a.m1156b(this.saturation, AbstractC0622a.m1156b(this.ditherVariation, AbstractC0622a.m1156b(this.globalLuminance, AbstractC0622a.m1156b(this.reflAlbedo, AbstractC0622a.m1156b(this.reflLightRadius, AbstractC0622a.m1156b(this.reflLightIntensity, AbstractC0622a.m1156b(this.glowSharpness, AbstractC0622a.m1156b(this.glowRadius, AbstractC0622a.m1156b(this.glowIntensity, AbstractC0622a.m1156b(this.lightIntensity, AbstractC0622a.m1156b(this.lightRadius, (this.lightPos.hashCode() + ((this.lightBaseColor.hashCode() + ((this.colorState.hashCode() + ((this.roundRectDirection.hashCode() + (this.shape.hashCode() * 31)) * 31)) * 31)) * 31)) * 31, 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31)) * 31, 31), 31), 31)) * 31, 31);
    }

    public final void setBoundarySmoothWidth(float f) {
        this.boundarySmoothWidth = f;
    }

    public final void setColorState(@NotNull PresetEffectColor.State state) {
        Intrinsics.checkNotNullParameter(state, "<set-?>");
        this.colorState = state;
    }

    public final void setDitherVariation(float f) {
        this.ditherVariation = f;
    }

    public final void setFrameRate(float f) {
        this.frameRate = f;
    }

    public final void setGlobalLuminance(float f) {
        this.globalLuminance = f;
    }

    public final void setGlowIntensity(float f) {
        this.glowIntensity = f;
    }

    public final void setGlowRadius(float f) {
        this.glowRadius = f;
    }

    public final void setGlowSharpness(float f) {
        this.glowSharpness = f;
    }

    public final void setInitialViewAlpha(float f) {
        this.initialViewAlpha = f;
    }

    public final void setLightBaseColor(@NotNull Color color) {
        Intrinsics.checkNotNullParameter(color, "<set-?>");
        this.lightBaseColor = color;
    }

    public final void setLightIntensity(float f) {
        this.lightIntensity = f;
    }

    public final void setLightMovement(@NotNull GuidingLightEffect.Movement movement) {
        Intrinsics.checkNotNullParameter(movement, "<set-?>");
        this.lightMovement = movement;
    }

    public final void setLightMovementInterval(long j) {
        this.lightMovementInterval = j;
    }

    public final void setLightPos(@NotNull PointF pointF) {
        Intrinsics.checkNotNullParameter(pointF, "<set-?>");
        this.lightPos = pointF;
    }

    public final void setLightRadius(float f) {
        this.lightRadius = f;
    }

    public final void setOuterSaturation(float f) {
        this.outerSaturation = f;
    }

    public final void setOutlineThickness(float f) {
        this.outlineThickness = f;
    }

    public final void setReflAlbedo(float f) {
        this.reflAlbedo = f;
    }

    public final void setReflLightIntensity(float f) {
        this.reflLightIntensity = f;
    }

    public final void setReflLightRadius(float f) {
        this.reflLightRadius = f;
    }

    public final void setSaturation(float f) {
        this.saturation = f;
    }

    public final void setShaderPrecision(@NotNull ShaderPrecision shaderPrecision) {
        Intrinsics.checkNotNullParameter(shaderPrecision, "<set-?>");
        this.shaderPrecision = shaderPrecision;
    }

    public final void setShape(@NotNull Shape shape) {
        Intrinsics.checkNotNullParameter(shape, "<set-?>");
        this.shape = shape;
    }

    public final void setStretch(float f) {
        this.stretch = f;
    }

    public final void setStretchDirLit(float f) {
        this.stretchDirLit = f;
    }

    public final void setTouchIntensity(float f) {
        this.touchIntensity = f;
    }

    @NotNull
    public String toString() {
        Shape shape = this.shape;
        RoundRectDirection roundRectDirection = this.roundRectDirection;
        PresetEffectColor.State state = this.colorState;
        Color color = this.lightBaseColor;
        PointF pointF = this.lightPos;
        float f = this.lightRadius;
        float f4 = this.lightIntensity;
        float f5 = this.glowIntensity;
        float f6 = this.glowRadius;
        float f7 = this.glowSharpness;
        float f8 = this.reflLightIntensity;
        float f9 = this.reflLightRadius;
        float f10 = this.reflAlbedo;
        float f11 = this.globalLuminance;
        float f12 = this.ditherVariation;
        float f13 = this.saturation;
        float f14 = this.outerSaturation;
        float f15 = this.stretch;
        float f16 = this.stretchDirLit;
        float f17 = this.initialViewAlpha;
        GuidingLightEffect.Movement movement = this.lightMovement;
        float f18 = this.frameRate;
        float f19 = this.outlineThickness;
        float f20 = this.boundarySmoothWidth;
        ShaderPrecision shaderPrecision = this.shaderPrecision;
        float f21 = this.touchIntensity;
        long j = this.lightMovementInterval;
        StringBuilder sb = new StringBuilder("GuidingLightConfig(shape=");
        sb.append(shape);
        sb.append(", roundRectDirection=");
        sb.append(roundRectDirection);
        sb.append(", colorState=");
        sb.append(state);
        sb.append(", lightBaseColor=");
        sb.append(color);
        sb.append(", lightPos=");
        sb.append(pointF);
        sb.append(", lightRadius=");
        sb.append(f);
        sb.append(", lightIntensity=");
        AbstractC11014a.m12337v(sb, f4, ", glowIntensity=", f5, ", glowRadius=");
        AbstractC11014a.m12337v(sb, f6, ", glowSharpness=", f7, ", reflLightIntensity=");
        AbstractC11014a.m12337v(sb, f8, ", reflLightRadius=", f9, ", reflAlbedo=");
        AbstractC11014a.m12337v(sb, f10, ", globalLuminance=", f11, ", ditherVariation=");
        AbstractC11014a.m12337v(sb, f12, ", saturation=", f13, ", outerSaturation=");
        AbstractC11014a.m12337v(sb, f14, ", stretch=", f15, ", stretchDirLit=");
        AbstractC11014a.m12337v(sb, f16, ", initialViewAlpha=", f17, ", lightMovement=");
        sb.append(movement);
        sb.append(", frameRate=");
        sb.append(f18);
        sb.append(", outlineThickness=");
        AbstractC11014a.m12337v(sb, f19, ", boundarySmoothWidth=", f20, ", shaderPrecision=");
        sb.append(shaderPrecision);
        sb.append(", touchIntensity=");
        sb.append(f21);
        sb.append(", lightMovementInterval=");
        return AbstractC2821a.m2224o(sb, ")", j);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuidingLightConfig(@NotNull Shape shape) {
        this(shape, null, null, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, 0.0f, 0.0f, 0.0f, null, 0.0f, 0L, 134217726, null);
        Intrinsics.checkNotNullParameter(shape, "shape");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuidingLightConfig(@NotNull Shape shape, @NotNull RoundRectDirection roundRectDirection) {
        this(shape, roundRectDirection, null, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, 0.0f, 0.0f, 0.0f, null, 0.0f, 0L, 134217724, null);
        Intrinsics.checkNotNullParameter(shape, "shape");
        Intrinsics.checkNotNullParameter(roundRectDirection, "roundRectDirection");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuidingLightConfig(@NotNull Shape shape, @NotNull RoundRectDirection roundRectDirection, @NotNull PresetEffectColor.State colorState) {
        this(shape, roundRectDirection, colorState, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, 0.0f, 0.0f, 0.0f, null, 0.0f, 0L, 134217720, null);
        Intrinsics.checkNotNullParameter(shape, "shape");
        Intrinsics.checkNotNullParameter(roundRectDirection, "roundRectDirection");
        Intrinsics.checkNotNullParameter(colorState, "colorState");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuidingLightConfig(@NotNull Shape shape, @NotNull RoundRectDirection roundRectDirection, @NotNull PresetEffectColor.State colorState, @NotNull Color lightBaseColor) {
        this(shape, roundRectDirection, colorState, lightBaseColor, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, 0.0f, 0.0f, 0.0f, null, 0.0f, 0L, 134217712, null);
        Intrinsics.checkNotNullParameter(shape, "shape");
        Intrinsics.checkNotNullParameter(roundRectDirection, "roundRectDirection");
        Intrinsics.checkNotNullParameter(colorState, "colorState");
        Intrinsics.checkNotNullParameter(lightBaseColor, "lightBaseColor");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuidingLightConfig(@NotNull Shape shape, @NotNull RoundRectDirection roundRectDirection, @NotNull PresetEffectColor.State colorState, @NotNull Color lightBaseColor, @NotNull PointF lightPos) {
        this(shape, roundRectDirection, colorState, lightBaseColor, lightPos, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, 0.0f, 0.0f, 0.0f, null, 0.0f, 0L, 134217696, null);
        Intrinsics.checkNotNullParameter(shape, "shape");
        Intrinsics.checkNotNullParameter(roundRectDirection, "roundRectDirection");
        Intrinsics.checkNotNullParameter(colorState, "colorState");
        Intrinsics.checkNotNullParameter(lightBaseColor, "lightBaseColor");
        Intrinsics.checkNotNullParameter(lightPos, "lightPos");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuidingLightConfig(@NotNull Shape shape, @NotNull RoundRectDirection roundRectDirection, @NotNull PresetEffectColor.State colorState, @NotNull Color lightBaseColor, @NotNull PointF lightPos, float f) {
        this(shape, roundRectDirection, colorState, lightBaseColor, lightPos, f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, 0.0f, 0.0f, 0.0f, null, 0.0f, 0L, 134217664, null);
        Intrinsics.checkNotNullParameter(shape, "shape");
        Intrinsics.checkNotNullParameter(roundRectDirection, "roundRectDirection");
        Intrinsics.checkNotNullParameter(colorState, "colorState");
        Intrinsics.checkNotNullParameter(lightBaseColor, "lightBaseColor");
        Intrinsics.checkNotNullParameter(lightPos, "lightPos");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuidingLightConfig(@NotNull Shape shape, @NotNull RoundRectDirection roundRectDirection, @NotNull PresetEffectColor.State colorState, @NotNull Color lightBaseColor, @NotNull PointF lightPos, float f, float f4) {
        this(shape, roundRectDirection, colorState, lightBaseColor, lightPos, f, f4, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, 0.0f, 0.0f, 0.0f, null, 0.0f, 0L, 134217600, null);
        Intrinsics.checkNotNullParameter(shape, "shape");
        Intrinsics.checkNotNullParameter(roundRectDirection, "roundRectDirection");
        Intrinsics.checkNotNullParameter(colorState, "colorState");
        Intrinsics.checkNotNullParameter(lightBaseColor, "lightBaseColor");
        Intrinsics.checkNotNullParameter(lightPos, "lightPos");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuidingLightConfig(@NotNull Shape shape, @NotNull RoundRectDirection roundRectDirection, @NotNull PresetEffectColor.State colorState, @NotNull Color lightBaseColor, @NotNull PointF lightPos, float f, float f4, float f5) {
        this(shape, roundRectDirection, colorState, lightBaseColor, lightPos, f, f4, f5, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, 0.0f, 0.0f, 0.0f, null, 0.0f, 0L, 134217472, null);
        Intrinsics.checkNotNullParameter(shape, "shape");
        Intrinsics.checkNotNullParameter(roundRectDirection, "roundRectDirection");
        Intrinsics.checkNotNullParameter(colorState, "colorState");
        Intrinsics.checkNotNullParameter(lightBaseColor, "lightBaseColor");
        Intrinsics.checkNotNullParameter(lightPos, "lightPos");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuidingLightConfig(@NotNull Shape shape, @NotNull RoundRectDirection roundRectDirection, @NotNull PresetEffectColor.State colorState, @NotNull Color lightBaseColor, @NotNull PointF lightPos, float f, float f4, float f5, float f6) {
        this(shape, roundRectDirection, colorState, lightBaseColor, lightPos, f, f4, f5, f6, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, 0.0f, 0.0f, 0.0f, null, 0.0f, 0L, 134217216, null);
        Intrinsics.checkNotNullParameter(shape, "shape");
        Intrinsics.checkNotNullParameter(roundRectDirection, "roundRectDirection");
        Intrinsics.checkNotNullParameter(colorState, "colorState");
        Intrinsics.checkNotNullParameter(lightBaseColor, "lightBaseColor");
        Intrinsics.checkNotNullParameter(lightPos, "lightPos");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuidingLightConfig(@NotNull Shape shape, @NotNull RoundRectDirection roundRectDirection, @NotNull PresetEffectColor.State colorState, @NotNull Color lightBaseColor, @NotNull PointF lightPos, float f, float f4, float f5, float f6, float f7) {
        this(shape, roundRectDirection, colorState, lightBaseColor, lightPos, f, f4, f5, f6, f7, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, 0.0f, 0.0f, 0.0f, null, 0.0f, 0L, 134216704, null);
        Intrinsics.checkNotNullParameter(shape, "shape");
        Intrinsics.checkNotNullParameter(roundRectDirection, "roundRectDirection");
        Intrinsics.checkNotNullParameter(colorState, "colorState");
        Intrinsics.checkNotNullParameter(lightBaseColor, "lightBaseColor");
        Intrinsics.checkNotNullParameter(lightPos, "lightPos");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuidingLightConfig(@NotNull Shape shape, @NotNull RoundRectDirection roundRectDirection, @NotNull PresetEffectColor.State colorState, @NotNull Color lightBaseColor, @NotNull PointF lightPos, float f, float f4, float f5, float f6, float f7, float f8) {
        this(shape, roundRectDirection, colorState, lightBaseColor, lightPos, f, f4, f5, f6, f7, f8, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, 0.0f, 0.0f, 0.0f, null, 0.0f, 0L, 134215680, null);
        Intrinsics.checkNotNullParameter(shape, "shape");
        Intrinsics.checkNotNullParameter(roundRectDirection, "roundRectDirection");
        Intrinsics.checkNotNullParameter(colorState, "colorState");
        Intrinsics.checkNotNullParameter(lightBaseColor, "lightBaseColor");
        Intrinsics.checkNotNullParameter(lightPos, "lightPos");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuidingLightConfig(@NotNull Shape shape, @NotNull RoundRectDirection roundRectDirection, @NotNull PresetEffectColor.State colorState, @NotNull Color lightBaseColor, @NotNull PointF lightPos, float f, float f4, float f5, float f6, float f7, float f8, float f9) {
        this(shape, roundRectDirection, colorState, lightBaseColor, lightPos, f, f4, f5, f6, f7, f8, f9, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, 0.0f, 0.0f, 0.0f, null, 0.0f, 0L, 134213632, null);
        Intrinsics.checkNotNullParameter(shape, "shape");
        Intrinsics.checkNotNullParameter(roundRectDirection, "roundRectDirection");
        Intrinsics.checkNotNullParameter(colorState, "colorState");
        Intrinsics.checkNotNullParameter(lightBaseColor, "lightBaseColor");
        Intrinsics.checkNotNullParameter(lightPos, "lightPos");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuidingLightConfig(@NotNull Shape shape, @NotNull RoundRectDirection roundRectDirection, @NotNull PresetEffectColor.State colorState, @NotNull Color lightBaseColor, @NotNull PointF lightPos, float f, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        this(shape, roundRectDirection, colorState, lightBaseColor, lightPos, f, f4, f5, f6, f7, f8, f9, f10, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, 0.0f, 0.0f, 0.0f, null, 0.0f, 0L, 134209536, null);
        Intrinsics.checkNotNullParameter(shape, "shape");
        Intrinsics.checkNotNullParameter(roundRectDirection, "roundRectDirection");
        Intrinsics.checkNotNullParameter(colorState, "colorState");
        Intrinsics.checkNotNullParameter(lightBaseColor, "lightBaseColor");
        Intrinsics.checkNotNullParameter(lightPos, "lightPos");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuidingLightConfig(@NotNull Shape shape, @NotNull RoundRectDirection roundRectDirection, @NotNull PresetEffectColor.State colorState, @NotNull Color lightBaseColor, @NotNull PointF lightPos, float f, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11) {
        this(shape, roundRectDirection, colorState, lightBaseColor, lightPos, f, f4, f5, f6, f7, f8, f9, f10, f11, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, 0.0f, 0.0f, 0.0f, null, 0.0f, 0L, 134201344, null);
        Intrinsics.checkNotNullParameter(shape, "shape");
        Intrinsics.checkNotNullParameter(roundRectDirection, "roundRectDirection");
        Intrinsics.checkNotNullParameter(colorState, "colorState");
        Intrinsics.checkNotNullParameter(lightBaseColor, "lightBaseColor");
        Intrinsics.checkNotNullParameter(lightPos, "lightPos");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuidingLightConfig(@NotNull Shape shape, @NotNull RoundRectDirection roundRectDirection, @NotNull PresetEffectColor.State colorState, @NotNull Color lightBaseColor, @NotNull PointF lightPos, float f, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12) {
        this(shape, roundRectDirection, colorState, lightBaseColor, lightPos, f, f4, f5, f6, f7, f8, f9, f10, f11, f12, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, 0.0f, 0.0f, 0.0f, null, 0.0f, 0L, 134184960, null);
        Intrinsics.checkNotNullParameter(shape, "shape");
        Intrinsics.checkNotNullParameter(roundRectDirection, "roundRectDirection");
        Intrinsics.checkNotNullParameter(colorState, "colorState");
        Intrinsics.checkNotNullParameter(lightBaseColor, "lightBaseColor");
        Intrinsics.checkNotNullParameter(lightPos, "lightPos");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuidingLightConfig(@NotNull Shape shape, @NotNull RoundRectDirection roundRectDirection, @NotNull PresetEffectColor.State colorState, @NotNull Color lightBaseColor, @NotNull PointF lightPos, float f, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13) {
        this(shape, roundRectDirection, colorState, lightBaseColor, lightPos, f, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, 0.0f, 0.0f, 0.0f, 0.0f, null, 0.0f, 0.0f, 0.0f, null, 0.0f, 0L, 134152192, null);
        Intrinsics.checkNotNullParameter(shape, "shape");
        Intrinsics.checkNotNullParameter(roundRectDirection, "roundRectDirection");
        Intrinsics.checkNotNullParameter(colorState, "colorState");
        Intrinsics.checkNotNullParameter(lightBaseColor, "lightBaseColor");
        Intrinsics.checkNotNullParameter(lightPos, "lightPos");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuidingLightConfig(@NotNull Shape shape, @NotNull RoundRectDirection roundRectDirection, @NotNull PresetEffectColor.State colorState, @NotNull Color lightBaseColor, @NotNull PointF lightPos, float f, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14) {
        this(shape, roundRectDirection, colorState, lightBaseColor, lightPos, f, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, 0.0f, 0.0f, 0.0f, null, 0.0f, 0.0f, 0.0f, null, 0.0f, 0L, 134086656, null);
        Intrinsics.checkNotNullParameter(shape, "shape");
        Intrinsics.checkNotNullParameter(roundRectDirection, "roundRectDirection");
        Intrinsics.checkNotNullParameter(colorState, "colorState");
        Intrinsics.checkNotNullParameter(lightBaseColor, "lightBaseColor");
        Intrinsics.checkNotNullParameter(lightPos, "lightPos");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuidingLightConfig(@NotNull Shape shape, @NotNull RoundRectDirection roundRectDirection, @NotNull PresetEffectColor.State colorState, @NotNull Color lightBaseColor, @NotNull PointF lightPos, float f, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15) {
        this(shape, roundRectDirection, colorState, lightBaseColor, lightPos, f, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, 0.0f, 0.0f, null, 0.0f, 0.0f, 0.0f, null, 0.0f, 0L, 133955584, null);
        Intrinsics.checkNotNullParameter(shape, "shape");
        Intrinsics.checkNotNullParameter(roundRectDirection, "roundRectDirection");
        Intrinsics.checkNotNullParameter(colorState, "colorState");
        Intrinsics.checkNotNullParameter(lightBaseColor, "lightBaseColor");
        Intrinsics.checkNotNullParameter(lightPos, "lightPos");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuidingLightConfig(@NotNull Shape shape, @NotNull RoundRectDirection roundRectDirection, @NotNull PresetEffectColor.State colorState, @NotNull Color lightBaseColor, @NotNull PointF lightPos, float f, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16) {
        this(shape, roundRectDirection, colorState, lightBaseColor, lightPos, f, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, 0.0f, null, 0.0f, 0.0f, 0.0f, null, 0.0f, 0L, 133693440, null);
        Intrinsics.checkNotNullParameter(shape, "shape");
        Intrinsics.checkNotNullParameter(roundRectDirection, "roundRectDirection");
        Intrinsics.checkNotNullParameter(colorState, "colorState");
        Intrinsics.checkNotNullParameter(lightBaseColor, "lightBaseColor");
        Intrinsics.checkNotNullParameter(lightPos, "lightPos");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuidingLightConfig(@NotNull Shape shape, @NotNull RoundRectDirection roundRectDirection, @NotNull PresetEffectColor.State colorState, @NotNull Color lightBaseColor, @NotNull PointF lightPos, float f, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17) {
        this(shape, roundRectDirection, colorState, lightBaseColor, lightPos, f, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17, null, 0.0f, 0.0f, 0.0f, null, 0.0f, 0L, 133169152, null);
        Intrinsics.checkNotNullParameter(shape, "shape");
        Intrinsics.checkNotNullParameter(roundRectDirection, "roundRectDirection");
        Intrinsics.checkNotNullParameter(colorState, "colorState");
        Intrinsics.checkNotNullParameter(lightBaseColor, "lightBaseColor");
        Intrinsics.checkNotNullParameter(lightPos, "lightPos");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuidingLightConfig(@NotNull Shape shape, @NotNull RoundRectDirection roundRectDirection, @NotNull PresetEffectColor.State colorState, @NotNull Color lightBaseColor, @NotNull PointF lightPos, float f, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, @NotNull GuidingLightEffect.Movement lightMovement) {
        this(shape, roundRectDirection, colorState, lightBaseColor, lightPos, f, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17, lightMovement, 0.0f, 0.0f, 0.0f, null, 0.0f, 0L, 132120576, null);
        Intrinsics.checkNotNullParameter(shape, "shape");
        Intrinsics.checkNotNullParameter(roundRectDirection, "roundRectDirection");
        Intrinsics.checkNotNullParameter(colorState, "colorState");
        Intrinsics.checkNotNullParameter(lightBaseColor, "lightBaseColor");
        Intrinsics.checkNotNullParameter(lightPos, "lightPos");
        Intrinsics.checkNotNullParameter(lightMovement, "lightMovement");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuidingLightConfig(@NotNull Shape shape, @NotNull RoundRectDirection roundRectDirection, @NotNull PresetEffectColor.State colorState, @NotNull Color lightBaseColor, @NotNull PointF lightPos, float f, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, @NotNull GuidingLightEffect.Movement lightMovement, float f18) {
        this(shape, roundRectDirection, colorState, lightBaseColor, lightPos, f, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17, lightMovement, f18, 0.0f, 0.0f, null, 0.0f, 0L, 130023424, null);
        Intrinsics.checkNotNullParameter(shape, "shape");
        Intrinsics.checkNotNullParameter(roundRectDirection, "roundRectDirection");
        Intrinsics.checkNotNullParameter(colorState, "colorState");
        Intrinsics.checkNotNullParameter(lightBaseColor, "lightBaseColor");
        Intrinsics.checkNotNullParameter(lightPos, "lightPos");
        Intrinsics.checkNotNullParameter(lightMovement, "lightMovement");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuidingLightConfig(@NotNull Shape shape, @NotNull RoundRectDirection roundRectDirection, @NotNull PresetEffectColor.State colorState, @NotNull Color lightBaseColor, @NotNull PointF lightPos, float f, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, @NotNull GuidingLightEffect.Movement lightMovement, float f18, float f19) {
        this(shape, roundRectDirection, colorState, lightBaseColor, lightPos, f, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17, lightMovement, f18, f19, 0.0f, null, 0.0f, 0L, 125829120, null);
        Intrinsics.checkNotNullParameter(shape, "shape");
        Intrinsics.checkNotNullParameter(roundRectDirection, "roundRectDirection");
        Intrinsics.checkNotNullParameter(colorState, "colorState");
        Intrinsics.checkNotNullParameter(lightBaseColor, "lightBaseColor");
        Intrinsics.checkNotNullParameter(lightPos, "lightPos");
        Intrinsics.checkNotNullParameter(lightMovement, "lightMovement");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuidingLightConfig(@NotNull Shape shape, @NotNull RoundRectDirection roundRectDirection, @NotNull PresetEffectColor.State colorState, @NotNull Color lightBaseColor, @NotNull PointF lightPos, float f, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, @NotNull GuidingLightEffect.Movement lightMovement, float f18, float f19, float f20) {
        this(shape, roundRectDirection, colorState, lightBaseColor, lightPos, f, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17, lightMovement, f18, f19, f20, null, 0.0f, 0L, 117440512, null);
        Intrinsics.checkNotNullParameter(shape, "shape");
        Intrinsics.checkNotNullParameter(roundRectDirection, "roundRectDirection");
        Intrinsics.checkNotNullParameter(colorState, "colorState");
        Intrinsics.checkNotNullParameter(lightBaseColor, "lightBaseColor");
        Intrinsics.checkNotNullParameter(lightPos, "lightPos");
        Intrinsics.checkNotNullParameter(lightMovement, "lightMovement");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuidingLightConfig(@NotNull Shape shape, @NotNull RoundRectDirection roundRectDirection, @NotNull PresetEffectColor.State colorState, @NotNull Color lightBaseColor, @NotNull PointF lightPos, float f, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, @NotNull GuidingLightEffect.Movement lightMovement, float f18, float f19, float f20, @NotNull ShaderPrecision shaderPrecision) {
        this(shape, roundRectDirection, colorState, lightBaseColor, lightPos, f, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17, lightMovement, f18, f19, f20, shaderPrecision, 0.0f, 0L, 100663296, null);
        Intrinsics.checkNotNullParameter(shape, "shape");
        Intrinsics.checkNotNullParameter(roundRectDirection, "roundRectDirection");
        Intrinsics.checkNotNullParameter(colorState, "colorState");
        Intrinsics.checkNotNullParameter(lightBaseColor, "lightBaseColor");
        Intrinsics.checkNotNullParameter(lightPos, "lightPos");
        Intrinsics.checkNotNullParameter(lightMovement, "lightMovement");
        Intrinsics.checkNotNullParameter(shaderPrecision, "shaderPrecision");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuidingLightConfig(@NotNull Shape shape, @NotNull RoundRectDirection roundRectDirection, @NotNull PresetEffectColor.State colorState, @NotNull Color lightBaseColor, @NotNull PointF lightPos, float f, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, @NotNull GuidingLightEffect.Movement lightMovement, float f18, float f19, float f20, @NotNull ShaderPrecision shaderPrecision, float f21) {
        this(shape, roundRectDirection, colorState, lightBaseColor, lightPos, f, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17, lightMovement, f18, f19, f20, shaderPrecision, f21, 0L, 67108864, null);
        Intrinsics.checkNotNullParameter(shape, "shape");
        Intrinsics.checkNotNullParameter(roundRectDirection, "roundRectDirection");
        Intrinsics.checkNotNullParameter(colorState, "colorState");
        Intrinsics.checkNotNullParameter(lightBaseColor, "lightBaseColor");
        Intrinsics.checkNotNullParameter(lightPos, "lightPos");
        Intrinsics.checkNotNullParameter(lightMovement, "lightMovement");
        Intrinsics.checkNotNullParameter(shaderPrecision, "shaderPrecision");
    }

    public /* synthetic */ GuidingLightConfig(Shape shape, RoundRectDirection roundRectDirection, PresetEffectColor.State state, Color color, PointF pointF, float f, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, GuidingLightEffect.Movement movement, float f18, float f19, float f20, ShaderPrecision shaderPrecision, float f21, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Shape.RoundRect : shape, (i & 2) != 0 ? RoundRectDirection.ALL : roundRectDirection, (i & 4) != 0 ? PresetEffectColor.State.Common : state, (i & 8) != 0 ? Color.valueOf(Color.parseColor("#60FFFFFF")) : color, (i & 16) != 0 ? GuidingLightRenderEffect.Companion.Default.INSTANCE.getLightPos() : pointF, (i & 32) != 0 ? 1.92f : f, (i & 64) != 0 ? 0.28f : f4, (i & 128) == 0 ? f5 : 0.28f, (i & 256) != 0 ? 1.25f : f6, (i & 512) != 0 ? 36.0f : f7, (i & 1024) != 0 ? 0.48f : f8, (i & 2048) != 0 ? 1.82f : f9, (i & 4096) != 0 ? 0.0f : f10, (i & 8192) != 0 ? 1.0f : f11, (i & 16384) != 0 ? 0.07f : f12, (i & 32768) != 0 ? 1.15f : f13, (i & 65536) != 0 ? 0.9f : f14, (i & 131072) != 0 ? 1.65f : f15, (i & 262144) != 0 ? 0.0f : f16, (i & 524288) != 0 ? GuidingLightRenderEffect.Companion.Default.INSTANCE.getInitialViewAlpha$sesl_visualeffect_INTERNAL_2_1_10_release() : f17, (i & 1048576) != 0 ? GuidingLightEffect.Movement.DEFAULT : movement, (i & 2097152) != 0 ? 60.0f : f18, (i & 4194304) != 0 ? 48.0f : f19, (i & 8388608) != 0 ? 0.0f : f20, (i & 16777216) != 0 ? ShaderPrecision.LEVEL_1 : shaderPrecision, (i & 33554432) != 0 ? 0.6f : f21, (i & 67108864) != 0 ? 1100L : j);
    }

    @JvmOverloads
    public GuidingLightConfig(@NotNull Shape shape, @NotNull RoundRectDirection roundRectDirection, @NotNull PresetEffectColor.State colorState, @NotNull Color lightBaseColor, @NotNull PointF lightPos, float f, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, @NotNull GuidingLightEffect.Movement lightMovement, float f18, float f19, float f20, @NotNull ShaderPrecision shaderPrecision, float f21, long j) {
        Intrinsics.checkNotNullParameter(shape, "shape");
        Intrinsics.checkNotNullParameter(roundRectDirection, "roundRectDirection");
        Intrinsics.checkNotNullParameter(colorState, "colorState");
        Intrinsics.checkNotNullParameter(lightBaseColor, "lightBaseColor");
        Intrinsics.checkNotNullParameter(lightPos, "lightPos");
        Intrinsics.checkNotNullParameter(lightMovement, "lightMovement");
        Intrinsics.checkNotNullParameter(shaderPrecision, "shaderPrecision");
        this.shape = shape;
        this.roundRectDirection = roundRectDirection;
        this.colorState = colorState;
        this.lightBaseColor = lightBaseColor;
        this.lightPos = lightPos;
        this.lightRadius = f;
        this.lightIntensity = f4;
        this.glowIntensity = f5;
        this.glowRadius = f6;
        this.glowSharpness = f7;
        this.reflLightIntensity = f8;
        this.reflLightRadius = f9;
        this.reflAlbedo = f10;
        this.globalLuminance = f11;
        this.ditherVariation = f12;
        this.saturation = f13;
        this.outerSaturation = f14;
        this.stretch = f15;
        this.stretchDirLit = f16;
        this.initialViewAlpha = f17;
        this.lightMovement = lightMovement;
        this.frameRate = f18;
        this.outlineThickness = f19;
        this.boundarySmoothWidth = f20;
        this.shaderPrecision = shaderPrecision;
        this.touchIntensity = f21;
        this.lightMovementInterval = j;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    @JvmOverloads
    public GuidingLightConfig(@NotNull GuidingLightConfig source) {
        Intrinsics.checkNotNullParameter(source, "source");
        Shape shape = source.shape;
        RoundRectDirection roundRectDirection = source.roundRectDirection;
        PresetEffectColor.State state = source.colorState;
        PointF pointF = source.lightPos;
        this(shape, roundRectDirection, state, null, new PointF(pointF.x, pointF.y), source.lightRadius, source.lightIntensity, source.glowIntensity, source.glowRadius, source.glowSharpness, source.reflLightIntensity, source.reflLightRadius, source.reflAlbedo, source.globalLuminance, source.ditherVariation, source.saturation, source.outerSaturation, source.stretch, source.stretchDirLit, source.initialViewAlpha, source.lightMovement, source.frameRate, source.outlineThickness, source.boundarySmoothWidth, source.shaderPrecision, source.touchIntensity, source.lightMovementInterval, 8, null);
    }
}
