package com.samsung.android.sesl.visualeffect.lighteffects.guidinglight;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.RenderEffect;
import android.graphics.RuntimeShader;
import android.graphics.Shader;
import android.util.Log;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import androidx.glance.AbstractC2821a;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.samsung.android.app.notes.widget.util.AbstractC7011a;
import com.samsung.android.sdk.bixby2.state.StateHandler;
import com.samsung.android.sesl.visualeffect.C7843R;
import com.samsung.android.sesl.visualeffect.lighteffects.common.runtimshader.IColorizable;
import com.samsung.android.sesl.visualeffect.lighteffects.common.runtimshader.IProgressive;
import com.samsung.android.sesl.visualeffect.lighteffects.common.runtimshader.VibeRenderEffectBase;
import com.samsung.android.sesl.visualeffect.lighteffects.guidinglight.GuidingLightConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.random.Random;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.intellij.lang.annotations.Language;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@RequiresApi(33)
@Metadata(m13885d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\n\b\u0001\u0018\u0000 _2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001_B\u0019\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0014J\u0010\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\"H\u0016J\u0018\u0010#\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020\"H\u0002J\u000e\u0010)\u001a\u00020\u001d2\u0006\u0010*\u001a\u00020\"J\u000e\u0010+\u001a\u00020\u001d2\u0006\u0010*\u001a\u00020\"J\u000e\u0010,\u001a\u00020\u001d2\u0006\u0010-\u001a\u00020\"J\u000e\u0010.\u001a\u00020\u001d2\u0006\u0010/\u001a\u00020\"J\u000e\u00100\u001a\u00020\u001d2\u0006\u00101\u001a\u00020\"J\u0010\u00102\u001a\u00020\u001d2\u0006\u00103\u001a\u000204H\u0002J\u000e\u00105\u001a\u00020\u001d2\u0006\u00106\u001a\u000207J\u000e\u00108\u001a\u00020\u001d2\u0006\u00109\u001a\u000204J\u000e\u0010:\u001a\u00020\u001d2\u0006\u0010;\u001a\u00020\"J\u0010\u0010<\u001a\u00020\u001d2\b\u0010=\u001a\u0004\u0018\u00010>J\u0010\u0010?\u001a\u00020\u001d2\b\u0010=\u001a\u0004\u0018\u00010>J\u000e\u0010@\u001a\u00020\u001d2\u0006\u0010A\u001a\u000204J\u000e\u0010B\u001a\u00020\u001d2\u0006\u0010;\u001a\u00020\"J\u000e\u0010C\u001a\u00020\u001d2\u0006\u0010D\u001a\u00020\"J\u0010\u0010E\u001a\u00020\u001d2\b\b\u0001\u0010F\u001a\u00020GJ\u000e\u0010H\u001a\u00020\u001d2\u0006\u0010D\u001a\u00020\"J\u000e\u0010I\u001a\u00020\u001d2\u0006\u0010;\u001a\u00020\"J\u000e\u0010J\u001a\u00020\u001d2\u0006\u0010K\u001a\u00020\"J\u000e\u0010L\u001a\u00020\u001d2\u0006\u0010;\u001a\u00020\"J\u000e\u0010M\u001a\u00020\u001d2\u0006\u0010D\u001a\u00020\"J\u000e\u0010N\u001a\u00020\u001d2\u0006\u0010O\u001a\u00020\"J\u000e\u0010P\u001a\u00020\u001d2\u0006\u0010Q\u001a\u00020\"J\u000e\u0010R\u001a\u00020\u001d2\u0006\u0010;\u001a\u00020\"J\u0012\u0010S\u001a\u00020\u001d2\b\u0010=\u001a\u0004\u0018\u00010>H\u0016J\u001c\u0010T\u001a\u00020\u001d2\b\u0010U\u001a\u0004\u0018\u00010V2\b\u0010W\u001a\u0004\u0018\u000104H\u0016J\u000e\u0010X\u001a\u00020\u001d2\u0006\u0010Y\u001a\u00020\u0005J\u000e\u0010Z\u001a\u00020\u001d2\u0006\u0010[\u001a\u00020\"J\u000e\u0010\\\u001a\u00020\u001d2\u0006\u0010]\u001a\u00020\"J\b\u0010^\u001a\u00020\u001dH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00118VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0012\u0010'\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0004\n\u0002\u0010(¨\u0006`"}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/lighteffects/guidinglight/GuidingLightRenderEffect;", "Lcom/samsung/android/sesl/visualeffect/lighteffects/common/runtimshader/VibeRenderEffectBase;", "Lcom/samsung/android/sesl/visualeffect/lighteffects/common/runtimshader/IColorizable;", "Lcom/samsung/android/sesl/visualeffect/lighteffects/common/runtimshader/IProgressive;", "roundRectType", "", "precision", "Lcom/samsung/android/sesl/visualeffect/lighteffects/guidinglight/GuidingLightConfig$ShaderPrecision;", "<init>", "(ZLcom/samsung/android/sesl/visualeffect/lighteffects/guidinglight/GuidingLightConfig$ShaderPrecision;)V", "shader", "Landroid/graphics/RuntimeShader;", "getShader", "()Landroid/graphics/RuntimeShader;", "setShader", "(Landroid/graphics/RuntimeShader;)V", "renderEffect", "Landroid/graphics/RenderEffect;", "getRenderEffect", "()Landroid/graphics/RenderEffect;", "setRenderEffect", "(Landroid/graphics/RenderEffect;)V", "startProgress", "", "getStartProgress", "()J", "setStartProgress", "(J)V", "onInitialize", "", StateHandler.KEY_APP_STATE, "Landroid/content/Context;", "setProgress", "progress", "", "setViewAlpha", "view", "Landroid/view/View;", "alpha", "prevViewAlpha", "Ljava/lang/Float;", "setStretch", "stretch", "setStretchDirLit", "setSaturation", "saturation", "setGlobalLuminance", "luminance", "setOuterSaturation", "outerSaturation", "setViewCenter", "center", "Landroid/graphics/PointF;", "setBorderWidth", "borderInPixel", "Landroid/graphics/Point;", "setRoundRectDirection", "directionVector", "setViewCornerRadius", "radius", "setLightmap", "bitmap", "Landroid/graphics/Bitmap;", "setLightmapGlow", "setLightPos", "pos", "setLightRadius", "setLightIntensity", "intensity", "setLightColor", "color", "", "setGlowIntensity", "setGlowRadius", "setGlowSharpness", "sharpness", "setReflLightRadius", "setReflLightIntensity", "setReflAlbedo", "albedo", "setDitherVariation", "ditherVariation", "setCircleRadius", "setTintTexture", "setTintShader", "tintShader", "Landroid/graphics/Shader;", "tintFragSize", "setTintFlipX", "flipX", "setOutlineThickness", "size", "setBoundarySmoothWidth", "width", "destroy", "Companion", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nGuidingLightRenderEffect.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GuidingLightRenderEffect.kt\ncom/samsung/android/sesl/visualeffect/lighteffects/guidinglight/GuidingLightRenderEffect\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,561:1\n1#2:562\n*E\n"})
public final class GuidingLightRenderEffect extends VibeRenderEffectBase implements IColorizable, IProgressive {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private final GuidingLightConfig.ShaderPrecision precision;

    @Nullable
    private Float prevViewAlpha;

    @Nullable
    private RenderEffect renderEffect;
    private final boolean roundRectType;

    @Nullable
    private RuntimeShader shader;
    private long startProgress;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/lighteffects/guidinglight/GuidingLightRenderEffect$Companion;", "", "<init>", "()V", "generateShader", "", "precision", "Lcom/samsung/android/sesl/visualeffect/lighteffects/guidinglight/GuidingLightConfig$ShaderPrecision;", AuthenticationConstants.Broker.ACCOUNT_DEFAULT_NAME, "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0013\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0015X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0015X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0015X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0015X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0015X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0015X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0015X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0015X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0015X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0015X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0015X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0015X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0015X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0015X\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010%\u001a\u00020\u0015X\u0080D¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'¨\u0006("}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/lighteffects/guidinglight/GuidingLightRenderEffect$Companion$Default;", "", "<init>", "()V", "lightmapRes", "", "getLightmapRes", "()I", "lightPos", "Landroid/graphics/PointF;", "getLightPos", "()Landroid/graphics/PointF;", "lightColor", "getLightColor", "bmpLightmap", "Landroid/graphics/Bitmap;", "getBmpLightmap", "()Landroid/graphics/Bitmap;", "setBmpLightmap", "(Landroid/graphics/Bitmap;)V", "lightRadius", "", "lightIntensity", "glowIntensity", "glowRadius", "glowSharpness", "reflLightIntensity", "reflLightRadius", "reflAlbedo", "ditherVariation", "globalLuminance", "saturation", "outerSaturation", "stretch", "stretchDirLit", "outlineThickness", "boundarySmoothWidth", "initialViewAlpha", "getInitialViewAlpha$sesl_visualeffect_INTERNAL_2_1_10_release", "()F", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
        public static final class Default {

            @Nullable
            private static Bitmap bmpLightmap = null;
            public static final float boundarySmoothWidth = 0.0f;
            public static final float ditherVariation = 0.07f;
            public static final float globalLuminance = 1.0f;
            public static final float glowIntensity = 0.28f;
            public static final float glowRadius = 1.25f;
            public static final float glowSharpness = 36.0f;
            public static final float lightIntensity = 0.28f;
            public static final float lightRadius = 1.92f;
            public static final float outerSaturation = 0.9f;
            public static final float outlineThickness = 48.0f;
            public static final float reflAlbedo = 0.0f;
            public static final float reflLightIntensity = 0.48f;
            public static final float reflLightRadius = 1.82f;
            public static final float saturation = 1.15f;
            public static final float stretch = 1.65f;
            public static final float stretchDirLit = 0.0f;

            @NotNull
            public static final Default INSTANCE = new Default();
            private static final int lightmapRes = C7843R.drawable.lightmap;

            @NotNull
            private static final PointF lightPos = new PointF(0.5f, 0.5f);
            private static final int lightColor = Color.parseColor("#FFFFFF");
            private static final float initialViewAlpha = 1.0f;

            private Default() {
            }

            @Nullable
            public final Bitmap getBmpLightmap() {
                return bmpLightmap;
            }

            public final float getInitialViewAlpha$sesl_visualeffect_INTERNAL_2_1_10_release() {
                return initialViewAlpha;
            }

            public final int getLightColor() {
                return lightColor;
            }

            @NotNull
            public final PointF getLightPos() {
                return lightPos;
            }

            public final int getLightmapRes() {
                return lightmapRes;
            }

            public final void setBmpLightmap(@Nullable Bitmap bitmap) {
                bmpLightmap = bitmap;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Language("AGSL")
        @NotNull
        public final String generateShader(@NotNull GuidingLightConfig.ShaderPrecision precision) {
            Intrinsics.checkNotNullParameter(precision, "precision");
            String str = (Intrinsics.areEqual(precision.getColorPrecision(), "lowp") || Intrinsics.areEqual(precision.getColorPrecision(), "mediump")) ? "half" : "float";
            String str2 = (Intrinsics.areEqual(precision.getGeometryPrecision(), "lowp") || Intrinsics.areEqual(precision.getGeometryPrecision(), "mediump")) ? "half" : "float";
            String str3 = (Intrinsics.areEqual(precision.getCoordinatePrecision(), "lowp") || Intrinsics.areEqual(precision.getCoordinatePrecision(), "mediump")) ? "half" : "float";
            StringBuilder sbM16m = AbstractC0000a.m16m("\n\nuniform shader tintShader;\nuniform half2 uTintShaderSize;\n// TODO possible for any transforming with mat3 for trs, but currently just for flipping since there's no requirements at least now.\nuniform half2 uTintFlipDirection; \n\nhalf useTint() {\n    return step(0.01, abs(uTintShaderSize.x * uTintShaderSize.y)); \n}\n    \nhalf4 texTint(half2 uv) {\n    uv = mix(uv, half2(1 - uv.x, uv.y), step(0.5, uTintFlipDirection.x));\n    return tintShader.eval(uv * uTintShaderSize);\n}\n\n// get tint color aligned center\nhalf3 getTintColor(half2 uv, half2 resolution) {\n    half2 guv = uv;\n    half asp = resolution.x / resolution.y;\n    if (asp > 1) {\n        guv.y /= asp;\n        guv.y += 0.5 * (1 - 1 / asp);\n    } else {\n        guv.x *= asp;\n        guv.x += 0.5 * (1 - asp);\n    }\n    return clamp(texTint(guv).rgb, half3(0), half3(1));\n}\n\n// get tint color aligned center\nhalf4 getTintColorAlpha(half2 uv, half2 resolution) {\n    half2 guv = uv;\n    half asp = resolution.x / resolution.y;\n    if (asp > 1) {\n        guv.y /= asp;\n        guv.y += 0.5 * (1 - 1 / asp);\n    } else {\n        guv.x *= asp;\n        guv.x += 0.5 * (1 - asp);\n    }\n    half4 tint = texTint(guv);\n    return clamp(tint, half4(0), half4(1));\n}\n        \nuniform shader inputShader;\nuniform shader lightMapShader;\nuniform shader lightMapGlowShader;\n\nuniform ", str3, "2 uSize;\nuniform ", str, " uProgress;\n\nuniform ");
            AbstractC2821a.m2207B(sbM16m, str3, "2 uLightMapSize;\nuniform ", str3, "2 uLightMapGlowSize;\n\nuniform ");
            AbstractC2821a.m2207B(sbM16m, str, " uDitherVariation;\n\n// for view shape\nuniform ", str3, "2 uViewCenter; // normalized value\nuniform ");
            AbstractC2821a.m2207B(sbM16m, str, " uViewAlpha;\nuniform int uRoundRectShape;\nuniform ", str2, " uCornerRadius;\nuniform ");
            AbstractC2821a.m2207B(sbM16m, str2, " uOutlineThickness;\nuniform ", str3, "2 uRoundRectDirection;\nuniform ");
            AbstractC2821a.m2207B(sbM16m, str2, " uCircleRadius;\nuniform ", str3, "2 uBorderWidth; // inset\n\n// directional light \nuniform ");
            AbstractC2821a.m2207B(sbM16m, str3, "2 uLightPos;\nuniform ", str, " uLightRadius;\nuniform ");
            AbstractC2821a.m2207B(sbM16m, str, "4 uLightColor;\nuniform ", str, " uLightIntensity;\n\n// glow light\nuniform ");
            AbstractC2821a.m2207B(sbM16m, str, " uGlowIntensity;\nuniform ", str, " uGlowRadius;\nuniform ");
            AbstractC2821a.m2207B(sbM16m, str, " uGlowSharpness;\n\n// reflection light\nuniform ", str, " uReflRadius;\nuniform ");
            AbstractC2821a.m2207B(sbM16m, str, " uReflLightIntensity;\nuniform ", str, " uReflAlbedo;\n\nuniform ");
            AbstractC2821a.m2207B(sbM16m, str, " uGlobalLuminance;\nuniform ", str, " uOuterSaturation;\nuniform ");
            AbstractC2821a.m2207B(sbM16m, str, " uSaturation;\n\nuniform ", str, " uStretch;\nuniform ");
            AbstractC2821a.m2207B(sbM16m, str, " uStretchDirLit;\n\nuniform ", str, " uBoundarySmoothWidth;\n\n// get relative uv based on longer length among width and height of the view.\n");
            AbstractC2821a.m2207B(sbM16m, str3, "2 relativeUv(", str3, "2 uv, ");
            AbstractC2821a.m2207B(sbM16m, str3, "2 pos, ", str, " scale, ");
            AbstractC2821a.m2207B(sbM16m, str, " stretch) {\n    ", str3, " asp = uSize.x / uSize.y;\n    asp = stretch >= 0.01 ? stretch : asp;\n\n    if (asp > 1) {\n    pos.y /= asp;\n    uv.y /= asp;\n    } else {\n    pos.x *= asp;\n    uv.x *= asp;\n    }\n    pos /= scale;\n    uv /= scale;\n    uv -= pos - ");
            AbstractC2821a.m2207B(sbM16m, str3, "2(0.5);// translate\n    return uv;\n}\n\n", str, "4 texView(");
            AbstractC2821a.m2207B(sbM16m, str3, "2 uv) {\n    ", str, "4 c = inputShader.eval(uv * uSize);\n    c.rgb *= c.a;\n    return c;\n}\n\n");
            AbstractC2821a.m2207B(sbM16m, str, " rand(", str3, "2 uv) {\n    return fract(sin(dot(uv, ");
            AbstractC2821a.m2207B(sbM16m, str3, "2(12.9898, 78.233))) * 43758.5453);\n}\n\n", str, " dither(");
            AbstractC2821a.m2207B(sbM16m, str3, "2 uv, ", str, " variation) {\n    return 1 + variation * 2 * (rand(uv * 10.0) - 0.5);\n}\n\n");
            AbstractC2821a.m2207B(sbM16m, str2, " sdRoundRect(vec2 fragCoord, ", str3, "2 center, ");
            AbstractC2821a.m2207B(sbM16m, str3, "2 size, ", str2, " radius) {\n    return length(max(abs(fragCoord - center) - size + radius, 0.0)) - radius;\n}\n\n");
            AbstractC2821a.m2207B(sbM16m, str, " lightmap(", str3, "2 uv, ");
            AbstractC2821a.m2207B(sbM16m, str3, "2 pos, ", str, " scale, ");
            AbstractC2821a.m2207B(sbM16m, str, " intensity, ", str, " stretch) {\n    uv = relativeUv(uv, pos, scale, stretch);\n    return length(lightMapShader.eval(uv * uLightMapSize).rgb) / sqrt(3) * intensity;\n}\n\n");
            AbstractC2821a.m2207B(sbM16m, str, " lightmapGlow(", str3, "2 uv, ");
            AbstractC2821a.m2207B(sbM16m, str3, "2 pos, ", str, " scale, ");
            AbstractC2821a.m2207B(sbM16m, str, " intensity, ", str, " stretch) {\n    uv = relativeUv(uv, pos, scale, stretch);\n    return length(lightMapGlowShader.eval(uv * uLightMapGlowSize).rgb) / sqrt(3) * intensity;\n}\n\nfloat getRadius(");
            AbstractC2821a.m2207B(sbM16m, str3, "2 halfViewSize, bool useDirection, bool isCornerDirection) {\n    if (uRoundRectShape == 0) { // circle\n        return uCircleRadius;\n    }\n    \n    if (!useDirection || isCornerDirection) {\n        return min(min(halfViewSize.x, halfViewSize.y), uCornerRadius);\n    }\n\n    return 0.01;\n}\n\nfloat sdf(vec2 fragCoord, ", str3, "2 halfViewSize) {\n    // detect rounded direction\n    vec2 signedQuadrant = fragCoord - uViewCenter * uSize;\n    vec2 dv = uRoundRectDirection * signedQuadrant;\n    bool useDirection = length(uRoundRectDirection) >= 0.1;\n    bool isCornerDirection = dv.x + dv.y >= 1.;\n    float radius = getRadius(halfViewSize, useDirection, isCornerDirection);\n\n    ");
            AbstractC2821a.m2207B(sbM16m, str2, " dist = sdRoundRect(fragCoord, uViewCenter * uSize, halfViewSize, radius);\n    ", str2, " attenuation = uOutlineThickness;\n\n    return dist / attenuation;\n}\n\n");
            AbstractC2821a.m2207B(sbM16m, str, "4 main(vec2 fragCoord) {\n    vec2 uv = fragCoord / uSize;\n\n    ", str, "4 view = texView(uv);\n    ");
            AbstractC2821a.m2207B(sbM16m, str3, "2 halfViewSize = 0.5 * uSize - uBorderWidth;\n    ", str3, " ratioByY = uSize.x / uSize.y;\n    ");
            AbstractC2821a.m2207B(sbM16m, str3, " minSizeLength = ratioByY >= 1. ? uSize.y : uSize.x;\n\n    // use proper sdf by primitive type of the view.\n    float dist = sdf(fragCoord, halfViewSize);\n\n    // smooth transition factor for inner/outer boundary (0.0 = inner, 1.0 = outer)\n    float outFactor = smoothstep(-uBoundarySmoothWidth, uBoundarySmoothWidth, dist);\n\n    // compute light\n    ", str, " lit = lightmap(uv, uLightPos, uLightRadius, uLightIntensity, uStretchDirLit);\n\n    // compute glow\n    // Note that RoundedRect using direction should have disabled the glow light because of limitation of the sdf.\n    ");
            AbstractC2821a.m2207B(sbM16m, str, " useDirection = step(0.1, length(uRoundRectDirection));\n    ", str, " glowLit = lightmapGlow(uv, uLightPos, uGlowRadius, uGlowIntensity, uStretch);\n    ");
            AbstractC2821a.m2207B(sbM16m, str, " glow = (1 - useDirection) * smoothstep(glowLit, 0, abs(dist));\n    glow = pow(glow, uGlowSharpness);\n\n    // compute fakey light reflection by sdf\n    ", str, " reflLit = lightmapGlow(uv, uLightPos, uReflRadius, uReflLightIntensity, uStretch);\n    ");
            AbstractC2821a.m2207B(sbM16m, str, " distForOut = clamp(dist, 0.0, 0.99);\n    ", str, " outerReflLit = reflLit * clamp(pow(1 - distForOut, 4.5) + 0.1 * (1 - distForOut), 0, 1);\n    ");
            AbstractC2821a.m2207B(sbM16m, str, " innerReflLit = uReflAlbedo * reflLit;\n    reflLit = mix(innerReflLit, outerReflLit, outFactor);\n    ", str, " refl = smoothstep(uReflRadius, 0, dist);\n\n    // build lights\n    ");
            AbstractC2821a.m2207B(sbM16m, str, " luminance = max(glow * glowLit, refl * reflLit);\n    // add directional light on the view (smoothly blended at boundary)\n    luminance += mix(lit, 0.0, outFactor);\n    ", str, " alpha = mix(luminance * uGlobalLuminance, view.a, view.a);\n    const ");
            AbstractC2821a.m2207B(sbM16m, str, " epsilon = 0.0001;\n    if (alpha < epsilon) {\n    return ", str, "4(0, 0, 0, 0);\n    }\n    luminance = clamp(luminance, 0, 1);\n\n    ");
            AbstractC2821a.m2207B(sbM16m, str, "4 litColor = ", str, "4(0.0);\n    litColor.rgb += luminance * uLightColor.rgb;\n    litColor.rgb *= dither(fract(uv * uProgress), uDitherVariation);\n    litColor.rgb = clamp(litColor.rgb, ");
            AbstractC2821a.m2207B(sbM16m, str, "3(0), ", str, "3(1));\n\n    // apply color tint\n    ");
            AbstractC2821a.m2207B(sbM16m, str, "4 tintColor = getTintColorAlpha(uv, uSize);\n    litColor.rgb = mix(litColor.rgb, litColor.rgb * tintColor.rgb, useTint()) * uSaturation;\n    // smooth transition for outer saturation at boundary\n    litColor.rgb = mix(litColor.rgb, litColor.rgb * uOuterSaturation, outFactor);\n    luminance *= tintColor.a;\n    litColor.a = luminance * uGlobalLuminance;\n\n    ", str, "3 color = litColor.rgb * uGlobalLuminance + view.rgb * view.a * (1 - litColor.a);\n    // use premult as default btw lighting and view\n    return ");
            sbM16m.append(str);
            sbM16m.append("4(color, alpha);\n}\n            ");
            return StringsKt.trimIndent(sbM16m.toString());
        }

        private Companion() {
        }
    }

    public /* synthetic */ GuidingLightRenderEffect(boolean z, GuidingLightConfig.ShaderPrecision shaderPrecision, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, (i & 2) != 0 ? GuidingLightConfig.ShaderPrecision.LEVEL_1 : shaderPrecision);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$1(GuidingLightRenderEffect guidingLightRenderEffect, RuntimeShader runtimeShader) {
        RuntimeShader shader = guidingLightRenderEffect.getShader();
        if (shader != null) {
            shader.setIntUniform("uRoundRectShape", guidingLightRenderEffect.roundRectType ? 1 : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setBorderWidth$lambda$11(GuidingLightRenderEffect guidingLightRenderEffect, Point point, RuntimeShader runtimeShader) {
        RuntimeShader shader = guidingLightRenderEffect.getShader();
        if (shader != null) {
            shader.setFloatUniform("uBorderWidth", point.x, point.y);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setBoundarySmoothWidth$lambda$37(GuidingLightRenderEffect guidingLightRenderEffect, float f, RuntimeShader runtimeShader) {
        RuntimeShader shader = guidingLightRenderEffect.getShader();
        if (shader != null) {
            shader.setFloatUniform("uBoundarySmoothWidth", f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setCircleRadius$lambda$29(GuidingLightRenderEffect guidingLightRenderEffect, float f, RuntimeShader runtimeShader) {
        RuntimeShader shader = guidingLightRenderEffect.getShader();
        if (shader != null) {
            shader.setFloatUniform("uCircleRadius", f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setDitherVariation$lambda$28(GuidingLightRenderEffect guidingLightRenderEffect, float f, RuntimeShader runtimeShader) {
        RuntimeShader shader = guidingLightRenderEffect.getShader();
        if (shader != null) {
            shader.setFloatUniform("uDitherVariation", f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setGlobalLuminance$lambda$8(GuidingLightRenderEffect guidingLightRenderEffect, float f, RuntimeShader runtimeShader) {
        RuntimeShader shader = guidingLightRenderEffect.getShader();
        if (shader != null) {
            shader.setFloatUniform("uGlobalLuminance", f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setGlowIntensity$lambda$22(GuidingLightRenderEffect guidingLightRenderEffect, float f, RuntimeShader runtimeShader) {
        RuntimeShader shader = guidingLightRenderEffect.getShader();
        if (shader != null) {
            shader.setFloatUniform("uGlowIntensity", f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setGlowRadius$lambda$23(GuidingLightRenderEffect guidingLightRenderEffect, float f, RuntimeShader runtimeShader) {
        RuntimeShader shader = guidingLightRenderEffect.getShader();
        if (shader != null) {
            shader.setFloatUniform("uGlowRadius", f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setGlowSharpness$lambda$24(GuidingLightRenderEffect guidingLightRenderEffect, float f, RuntimeShader runtimeShader) {
        RuntimeShader shader = guidingLightRenderEffect.getShader();
        if (shader != null) {
            shader.setFloatUniform("uGlowSharpness", f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setLightColor$lambda$21(GuidingLightRenderEffect guidingLightRenderEffect, Color color, RuntimeShader runtimeShader) {
        RuntimeShader shader = guidingLightRenderEffect.getShader();
        if (shader != null) {
            shader.setFloatUniform("uLightColor", color.red(), color.green(), color.blue(), color.alpha());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setLightIntensity$lambda$20(GuidingLightRenderEffect guidingLightRenderEffect, float f, RuntimeShader runtimeShader) {
        RuntimeShader shader = guidingLightRenderEffect.getShader();
        if (shader != null) {
            shader.setFloatUniform("uLightIntensity", f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setLightPos$lambda$18(GuidingLightRenderEffect guidingLightRenderEffect, PointF pointF, RuntimeShader runtimeShader) {
        RuntimeShader shader = guidingLightRenderEffect.getShader();
        if (shader != null) {
            shader.setFloatUniform("uLightPos", pointF.x, pointF.y);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setLightRadius$lambda$19(GuidingLightRenderEffect guidingLightRenderEffect, float f, RuntimeShader runtimeShader) {
        RuntimeShader shader = guidingLightRenderEffect.getShader();
        if (shader != null) {
            shader.setFloatUniform("uLightRadius", f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setLightmap$lambda$15(Bitmap bitmap, GuidingLightRenderEffect guidingLightRenderEffect, RuntimeShader runtimeShader) {
        if (bitmap != null) {
            RuntimeShader shader = guidingLightRenderEffect.getShader();
            if (shader != null) {
                shader.setInputBuffer("lightMapShader", new BitmapShader(bitmap, Shader.TileMode.DECAL, Shader.TileMode.DECAL));
            }
            RuntimeShader shader2 = guidingLightRenderEffect.getShader();
            if (shader2 != null) {
                shader2.setFloatUniform("uLightMapSize", bitmap.getWidth(), bitmap.getHeight());
                return;
            }
            return;
        }
        Bitmap bmpLightmap = Companion.Default.INSTANCE.getBmpLightmap();
        if (bmpLightmap != null) {
            RuntimeShader shader3 = guidingLightRenderEffect.getShader();
            if (shader3 != null) {
                shader3.setInputBuffer("lightMapShader", new BitmapShader(bmpLightmap, Shader.TileMode.DECAL, Shader.TileMode.DECAL));
            }
            RuntimeShader shader4 = guidingLightRenderEffect.getShader();
            if (shader4 != null) {
                shader4.setFloatUniform("uLightMapSize", bmpLightmap.getWidth(), bmpLightmap.getHeight());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setLightmapGlow$lambda$17(Bitmap bitmap, GuidingLightRenderEffect guidingLightRenderEffect, RuntimeShader runtimeShader) {
        if (bitmap != null) {
            RuntimeShader shader = guidingLightRenderEffect.getShader();
            if (shader != null) {
                shader.setInputBuffer("lightMapGlowShader", new BitmapShader(bitmap, Shader.TileMode.DECAL, Shader.TileMode.DECAL));
            }
            RuntimeShader shader2 = guidingLightRenderEffect.getShader();
            if (shader2 != null) {
                shader2.setFloatUniform("uLightMapGlowSize", bitmap.getWidth(), bitmap.getHeight());
                return;
            }
            return;
        }
        Bitmap bmpLightmap = Companion.Default.INSTANCE.getBmpLightmap();
        if (bmpLightmap != null) {
            RuntimeShader shader3 = guidingLightRenderEffect.getShader();
            if (shader3 != null) {
                shader3.setInputBuffer("lightMapGlowShader", new BitmapShader(bmpLightmap, Shader.TileMode.DECAL, Shader.TileMode.DECAL));
            }
            RuntimeShader shader4 = guidingLightRenderEffect.getShader();
            if (shader4 != null) {
                shader4.setFloatUniform("uLightMapGlowSize", bmpLightmap.getWidth(), bmpLightmap.getHeight());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setOuterSaturation$lambda$9(GuidingLightRenderEffect guidingLightRenderEffect, float f, RuntimeShader runtimeShader) {
        RuntimeShader shader = guidingLightRenderEffect.getShader();
        if (shader != null) {
            shader.setFloatUniform("uOuterSaturation", f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setOutlineThickness$lambda$36(GuidingLightRenderEffect guidingLightRenderEffect, float f, RuntimeShader runtimeShader) {
        RuntimeShader shader = guidingLightRenderEffect.getShader();
        if (shader != null) {
            shader.setFloatUniform("uOutlineThickness", f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setProgress$lambda$3(GuidingLightRenderEffect guidingLightRenderEffect, float f, RuntimeShader runtimeShader) {
        RuntimeShader shader = guidingLightRenderEffect.getShader();
        if (shader != null) {
            shader.setFloatUniform("uProgress", f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setReflAlbedo$lambda$27(GuidingLightRenderEffect guidingLightRenderEffect, float f, RuntimeShader runtimeShader) {
        RuntimeShader shader = guidingLightRenderEffect.getShader();
        if (shader != null) {
            shader.setFloatUniform("uReflAlbedo", f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setReflLightIntensity$lambda$26(GuidingLightRenderEffect guidingLightRenderEffect, float f, RuntimeShader runtimeShader) {
        RuntimeShader shader = guidingLightRenderEffect.getShader();
        if (shader != null) {
            shader.setFloatUniform("uReflLightIntensity", f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setReflLightRadius$lambda$25(GuidingLightRenderEffect guidingLightRenderEffect, float f, RuntimeShader runtimeShader) {
        RuntimeShader shader = guidingLightRenderEffect.getShader();
        if (shader != null) {
            shader.setFloatUniform("uReflRadius", f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setRoundRectDirection$lambda$12(GuidingLightRenderEffect guidingLightRenderEffect, PointF pointF, RuntimeShader runtimeShader) {
        RuntimeShader shader = guidingLightRenderEffect.getShader();
        if (shader != null) {
            shader.setFloatUniform("uRoundRectDirection", pointF.x, pointF.y);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setSaturation$lambda$7(GuidingLightRenderEffect guidingLightRenderEffect, float f, RuntimeShader runtimeShader) {
        RuntimeShader shader = guidingLightRenderEffect.getShader();
        if (shader != null) {
            shader.setFloatUniform("uSaturation", f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setStretch$lambda$5(GuidingLightRenderEffect guidingLightRenderEffect, float f, RuntimeShader runtimeShader) {
        RuntimeShader shader = guidingLightRenderEffect.getShader();
        if (shader != null) {
            shader.setFloatUniform("uStretch", f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setStretchDirLit$lambda$6(GuidingLightRenderEffect guidingLightRenderEffect, float f, RuntimeShader runtimeShader) {
        RuntimeShader shader = guidingLightRenderEffect.getShader();
        if (shader != null) {
            shader.setFloatUniform("uStretchDirLit", f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setTintFlipX$lambda$35(GuidingLightRenderEffect guidingLightRenderEffect, boolean z, RuntimeShader runtimeShader) {
        RuntimeShader shader = guidingLightRenderEffect.getShader();
        if (shader != null) {
            guidingLightRenderEffect.setTintFlipDirection(shader, new PointF(z ? 1.0f : 0.0f, 0.0f));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setTintShader$lambda$33(GuidingLightRenderEffect guidingLightRenderEffect, Shader shader, PointF pointF, RuntimeShader runtimeShader) {
        RuntimeShader shader2 = guidingLightRenderEffect.getShader();
        if (shader2 != null) {
            guidingLightRenderEffect.setTintShaderUniforms(shader2, shader, pointF);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setTintTexture$lambda$31(GuidingLightRenderEffect guidingLightRenderEffect, Bitmap bitmap, RuntimeShader runtimeShader) {
        RuntimeShader shader = guidingLightRenderEffect.getShader();
        if (shader != null) {
            guidingLightRenderEffect.setTintTexture(shader, bitmap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setViewAlpha$lambda$4(GuidingLightRenderEffect guidingLightRenderEffect, float f, RuntimeShader runtimeShader) {
        RuntimeShader shader = guidingLightRenderEffect.getShader();
        if (shader != null) {
            shader.setFloatUniform("uViewAlpha", f);
        }
        guidingLightRenderEffect.prevViewAlpha = Float.valueOf(f);
    }

    private final void setViewCenter(PointF center) {
        updateShader(new C7861m(this, center, 2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setViewCenter$lambda$10(GuidingLightRenderEffect guidingLightRenderEffect, PointF pointF, RuntimeShader runtimeShader) {
        RuntimeShader shader = guidingLightRenderEffect.getShader();
        if (shader != null) {
            shader.setFloatUniform("uViewCenter", pointF.x, pointF.y);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setViewCornerRadius$lambda$13(GuidingLightRenderEffect guidingLightRenderEffect, float f, RuntimeShader runtimeShader) {
        RuntimeShader shader = guidingLightRenderEffect.getShader();
        if (shader != null) {
            shader.setFloatUniform("uCornerRadius", f);
        }
    }

    @Override // com.samsung.android.sesl.visualeffect.lighteffects.common.runtimshader.VibeRenderEffectBase, com.samsung.android.sesl.visualeffect.lighteffects.common.runtimshader.VibeRenderEffect
    public void destroy() {
        super.destroy();
        Log.i(VibeRenderEffectBase.TAG, "destroy");
        Companion.Default r02 = Companion.Default.INSTANCE;
        Bitmap bmpLightmap = r02.getBmpLightmap();
        if (bmpLightmap != null) {
            bmpLightmap.recycle();
        }
        r02.setBmpLightmap(null);
        setRenderEffect(null);
        setShader(null);
    }

    @Override // com.samsung.android.sesl.visualeffect.lighteffects.common.runtimshader.VibeRenderEffect
    @Nullable
    public RenderEffect getRenderEffect() {
        RuntimeShader shader = getShader();
        if (shader != null) {
            return RenderEffect.createRuntimeShaderEffect(shader, "inputShader");
        }
        return null;
    }

    @Override // com.samsung.android.sesl.visualeffect.lighteffects.common.runtimshader.VibeRenderEffect
    @Nullable
    public RuntimeShader getShader() {
        return this.shader;
    }

    @Override // com.samsung.android.sesl.visualeffect.lighteffects.common.runtimshader.IProgressive
    public long getStartProgress() {
        return this.startProgress;
    }

    @Override // com.samsung.android.sesl.visualeffect.lighteffects.common.runtimshader.IProgressive
    public void initProgressByTime() {
        IProgressive.DefaultImpls.initProgressByTime(this);
    }

    @Override // com.samsung.android.sesl.visualeffect.lighteffects.common.runtimshader.VibeRenderEffectBase
    public void onInitialize(@NotNull Context appContext) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Companion.Default r02 = Companion.Default.INSTANCE;
        if (r02.getBmpLightmap() == null) {
            r02.setBmpLightmap(BitmapFactory.decodeResource(appContext.getResources(), r02.getLightmapRes()));
        }
        Bitmap bmpLightmap = r02.getBmpLightmap();
        if (bmpLightmap != null) {
            setLightmap(bmpLightmap);
            setLightmapGlow(bmpLightmap);
        }
    }

    public final void setBorderWidth(@NotNull Point borderInPixel) {
        Intrinsics.checkNotNullParameter(borderInPixel, "borderInPixel");
        updateShader(new C7860l(this, borderInPixel, 1));
    }

    public final void setBoundarySmoothWidth(float width) {
        updateShader(new C7859k(this, width, 5));
    }

    public final void setCircleRadius(float radius) {
        updateShader(new C7859k(this, radius, 4));
    }

    public final void setDitherVariation(float ditherVariation) {
        updateShader(new C7859k(this, ditherVariation, 1));
    }

    public final void setGlobalLuminance(float luminance) {
        updateShader(new C7859k(this, luminance, 8));
    }

    public final void setGlowIntensity(float intensity) {
        updateShader(new C7859k(this, intensity, 15));
    }

    public final void setGlowRadius(float radius) {
        updateShader(new C7859k(this, radius, 16));
    }

    public final void setGlowSharpness(float sharpness) {
        updateShader(new C7859k(this, sharpness, 3));
    }

    public final void setLightColor(@ColorInt int color) {
        Color colorValueOf = Color.valueOf(color);
        Intrinsics.checkNotNullExpressionValue(colorValueOf, "valueOf(...)");
        updateShader(new C7860l(this, colorValueOf, 0));
    }

    public final void setLightIntensity(float intensity) {
        updateShader(new C7859k(this, intensity, 14));
    }

    public final void setLightPos(@NotNull PointF pos) {
        Intrinsics.checkNotNullParameter(pos, "pos");
        updateShader(new C7861m(this, pos, 1));
    }

    public final void setLightRadius(float radius) {
        updateShader(new C7859k(this, radius, 17));
    }

    public final void setLightmap(@Nullable Bitmap bitmap) {
        updateShader(new C7862n(bitmap, this, 1));
    }

    public final void setLightmapGlow(@Nullable Bitmap bitmap) {
        updateShader(new C7862n(bitmap, this, 2));
    }

    public final void setOuterSaturation(float outerSaturation) {
        updateShader(new C7859k(this, outerSaturation, 6));
    }

    public final void setOutlineThickness(float size) {
        updateShader(new C7859k(this, size, 13));
    }

    @Override // com.samsung.android.sesl.visualeffect.lighteffects.common.runtimshader.IProgressive
    public void setProgress(float progress) {
        updateShader(new C7859k(this, progress, 10));
    }

    public final void setReflAlbedo(float albedo) {
        updateShader(new C7859k(this, albedo, 7));
    }

    public final void setReflLightIntensity(float intensity) {
        updateShader(new C7859k(this, intensity, 0));
    }

    public final void setReflLightRadius(float radius) {
        updateShader(new C7859k(this, radius, 12));
    }

    public void setRenderEffect(@Nullable RenderEffect renderEffect) {
        this.renderEffect = renderEffect;
    }

    public final void setRoundRectDirection(@NotNull PointF directionVector) {
        Intrinsics.checkNotNullParameter(directionVector, "directionVector");
        updateShader(new C7861m(this, directionVector, 0));
    }

    public final void setSaturation(float saturation) {
        updateShader(new C7859k(this, saturation, 19));
    }

    public void setShader(@Nullable RuntimeShader runtimeShader) {
        this.shader = runtimeShader;
    }

    @Override // com.samsung.android.sesl.visualeffect.lighteffects.common.runtimshader.IProgressive
    public void setStartProgress(long j) {
        this.startProgress = j;
    }

    public final void setStretch(float stretch) {
        updateShader(new C7859k(this, stretch, 9));
    }

    public final void setStretchDirLit(float stretch) {
        updateShader(new C7859k(this, stretch, 18));
    }

    @Override // com.samsung.android.sesl.visualeffect.lighteffects.common.runtimshader.IColorizable
    public void setTintFlipDirection(@NotNull RuntimeShader runtimeShader, @NotNull PointF pointF) {
        IColorizable.DefaultImpls.setTintFlipDirection(this, runtimeShader, pointF);
    }

    public final void setTintFlipX(boolean flipX) {
        updateShader(new C7864p(this, flipX, 0));
    }

    @Override // com.samsung.android.sesl.visualeffect.lighteffects.common.runtimshader.IColorizable
    public void setTintShader(@Nullable Shader tintShader, @Nullable PointF tintFragSize) {
        updateShader(new C7863o(this, tintShader, tintFragSize, 0));
    }

    @Override // com.samsung.android.sesl.visualeffect.lighteffects.common.runtimshader.IColorizable
    public void setTintShaderUniforms(@NotNull RuntimeShader runtimeShader, @Nullable Shader shader, @Nullable PointF pointF) {
        IColorizable.DefaultImpls.setTintShaderUniforms(this, runtimeShader, shader, pointF);
    }

    @Override // com.samsung.android.sesl.visualeffect.lighteffects.common.runtimshader.IColorizable
    public void setTintTexture(@NotNull RuntimeShader runtimeShader, @Nullable Bitmap bitmap) {
        IColorizable.DefaultImpls.setTintTexture(this, runtimeShader, bitmap);
    }

    @Override // com.samsung.android.sesl.visualeffect.lighteffects.common.runtimshader.VibeRenderEffectBase
    public void setViewAlpha(@NotNull View view, float alpha) {
        Intrinsics.checkNotNullParameter(view, "view");
        setViewAlpha(alpha);
    }

    public final void setViewCornerRadius(float radius) {
        updateShader(new C7859k(this, radius, 11));
    }

    @Override // com.samsung.android.sesl.visualeffect.lighteffects.common.runtimshader.IProgressive
    public void updateProgressByTime() {
        IProgressive.DefaultImpls.updateProgressByTime(this);
    }

    private final void setViewAlpha(float alpha) {
        Float f = this.prevViewAlpha;
        if (f == null || Float.compare(f.floatValue(), alpha) != 0) {
            updateShader(new C7859k(this, alpha, 2));
        }
    }

    @Override // com.samsung.android.sesl.visualeffect.lighteffects.common.runtimshader.IColorizable
    public void setTintTexture(@Nullable Bitmap bitmap) {
        updateShader(new C7862n(this, bitmap));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuidingLightRenderEffect(boolean z, @NotNull GuidingLightConfig.ShaderPrecision precision) {
        super(false, 1, null);
        Intrinsics.checkNotNullParameter(precision, "precision");
        this.roundRectType = z;
        this.precision = precision;
        AbstractC7011a.m5287q();
        this.shader = AbstractC7011a.m5275e(INSTANCE.generateShader(precision));
        this.startProgress = (long) RangesKt.coerceAtLeast(Random.INSTANCE.nextFloat() * 10000, 1.0f);
        updateShader(new C7865q(this, 0));
        setViewCenter(new PointF(0.5f, 0.5f));
        Companion.Default r4 = Companion.Default.INSTANCE;
        setViewAlpha(r4.getInitialViewAlpha$sesl_visualeffect_INTERNAL_2_1_10_release());
        setSaturation(1.15f);
        setGlobalLuminance(1.0f);
        setOuterSaturation(0.9f);
        setLightPos(r4.getLightPos());
        setLightRadius(1.92f);
        setLightColor(r4.getLightColor());
        setLightIntensity(0.28f);
        setGlowIntensity(0.28f);
        setGlowRadius(1.25f);
        setGlowSharpness(36.0f);
        setReflLightIntensity(0.48f);
        setReflLightRadius(1.82f);
        setReflAlbedo(0.0f);
        setProgress(getStartProgress());
        setDitherVariation(0.07f);
        setOutlineThickness(48.0f);
        setBoundarySmoothWidth(0.0f);
        setTintShader(null, null);
    }
}
