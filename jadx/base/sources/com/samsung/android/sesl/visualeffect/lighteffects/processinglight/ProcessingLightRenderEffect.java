package com.samsung.android.sesl.visualeffect.lighteffects.processinglight;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.RenderEffect;
import android.graphics.RuntimeShader;
import android.graphics.Shader;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import androidx.collection.AbstractC0622a;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.samsung.android.app.notes.widget.util.AbstractC7011a;
import com.samsung.android.sdk.bixby2.state.StateHandler;
import com.samsung.android.sesl.visualeffect.C7843R;
import com.samsung.android.sesl.visualeffect.lighteffects.common.runtimshader.IColorizable;
import com.samsung.android.sesl.visualeffect.lighteffects.common.runtimshader.VibeRenderEffectBase;
import com.samsung.android.sesl.visualeffect.lighteffects.guidinglight.C7860l;
import com.samsung.android.sesl.visualeffect.lighteffects.guidinglight.C7863o;
import com.samsung.android.sesl.visualeffect.lighteffects.guidinglight.C7864p;
import com.samsung.android.sesl.visualeffect.lighteffects.guidinglight.C7865q;
import com.samsung.android.sesl.visualeffect.lighteffects.processinglight.ProcessingLightConfig;
import com.samsung.android.sesl.visualeffect.lighteffects.radialgrad.WiggleAnimationConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.intellij.lang.annotations.Language;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@RequiresApi(33)
@Metadata(m13885d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0016\b\u0001\u0018\u0000 <2\u00020\u00012\u00020\u0002:\u0001<B\u0019\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0014J\u0012\u0010\u0019\u001a\u00020\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u001c\u0010\u001c\u001a\u00020\u00162\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0012\u0010!\u001a\u00020\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002J\u0010\u0010\"\u001a\u00020\u00162\b\b\u0001\u0010#\u001a\u00020$J\u000e\u0010%\u001a\u00020\u00162\u0006\u0010&\u001a\u00020'J\u000e\u0010(\u001a\u00020\u00162\u0006\u0010)\u001a\u00020 J\u000e\u0010*\u001a\u00020\u00162\u0006\u0010+\u001a\u00020\u0004J\u000e\u0010,\u001a\u00020\u00162\u0006\u0010-\u001a\u00020'J\u000e\u0010.\u001a\u00020\u00162\u0006\u0010/\u001a\u00020'J\u000e\u00100\u001a\u00020\u00162\u0006\u00101\u001a\u00020'J\u000e\u00102\u001a\u00020\u00162\u0006\u00103\u001a\u00020'J\u0010\u00104\u001a\u00020\u00162\b\b\u0001\u0010#\u001a\u00020$J\u000e\u00105\u001a\u00020\u00162\u0006\u00106\u001a\u00020'J\u000e\u00107\u001a\u00020\u00162\u0006\u00108\u001a\u00020'J\u000e\u00109\u001a\u00020\u00162\u0006\u0010:\u001a\u00020'J\b\u0010;\u001a\u00020\u0016H\u0016R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00108VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006="}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/lighteffects/processinglight/ProcessingLightRenderEffect;", "Lcom/samsung/android/sesl/visualeffect/lighteffects/common/runtimshader/VibeRenderEffectBase;", "Lcom/samsung/android/sesl/visualeffect/lighteffects/common/runtimshader/IColorizable;", "useLightnessCalibration", "", "blendMode", "Lcom/samsung/android/sesl/visualeffect/lighteffects/processinglight/ProcessingLightConfig$BlendMode;", "<init>", "(ZLcom/samsung/android/sesl/visualeffect/lighteffects/processinglight/ProcessingLightConfig$BlendMode;)V", "shader", "Landroid/graphics/RuntimeShader;", "getShader", "()Landroid/graphics/RuntimeShader;", "setShader", "(Landroid/graphics/RuntimeShader;)V", "renderEffect", "Landroid/graphics/RenderEffect;", "getRenderEffect", "()Landroid/graphics/RenderEffect;", "setRenderEffect", "(Landroid/graphics/RenderEffect;)V", "onInitialize", "", StateHandler.KEY_APP_STATE, "Landroid/content/Context;", "setTintTexture", "bitmap", "Landroid/graphics/Bitmap;", "setTintShader", "tintShader", "Landroid/graphics/Shader;", "tintFragSize", "Landroid/graphics/PointF;", "setLightMap", "setLightColor", "colorInt", "", "setLightRotation", "angle", "", "setLightPosition", "pos", "setLightPositionStretch", "usePositionStretched", "setLightScale", WiggleAnimationConfig.KEY_SCALE, "setStretch", "stretch", "setLightIntensity", "intensity", "setLightSaturation", "saturation", "setDomainColor", "setDomainDeltaRatio", "deltaRatio", "setDomainStrength", "strength", "setDitherVariation", "ditherVariation", "destroy", "Companion", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nProcessingLightRenderEffect.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ProcessingLightRenderEffect.kt\ncom/samsung/android/sesl/visualeffect/lighteffects/processinglight/ProcessingLightRenderEffect\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,388:1\n1#2:389\n*E\n"})
public final class ProcessingLightRenderEffect extends VibeRenderEffectBase implements IColorizable {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private RenderEffect renderEffect;

    @Nullable
    private RuntimeShader shader;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\nB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0003¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/lighteffects/processinglight/ProcessingLightRenderEffect$Companion;", "", "<init>", "()V", "assembleShader", "", "useLightnessCalibration", "", "blendMode", "Lcom/samsung/android/sesl/visualeffect/lighteffects/processinglight/ProcessingLightConfig$BlendMode;", AuthenticationConstants.Broker.ACCOUNT_DEFAULT_NAME, "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\tR\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0018X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0018X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0018X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0018X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0018X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0018X\u0086T¢\u0006\u0002\n\u0000¨\u0006!"}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/lighteffects/processinglight/ProcessingLightRenderEffect$Companion$Default;", "", "<init>", "()V", "useLightnessCalibration", "", "lightmapRes", "", "getLightmapRes", "()I", "bmpLightmap", "Landroid/graphics/Bitmap;", "getBmpLightmap", "()Landroid/graphics/Bitmap;", "setBmpLightmap", "(Landroid/graphics/Bitmap;)V", "colorRes", "getColorRes", "lightPos", "Landroid/graphics/PointF;", "getLightPos", "()Landroid/graphics/PointF;", "lightColor", "lightScale", "", "lightAngle", "lightStretch", "lightIntensity", "lightSaturation", "ditherVariation", "domainColor", "domainDeltaRatio", "domainStrength", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
        public static final class Default {

            @Nullable
            private static Bitmap bmpLightmap = null;
            public static final float ditherVariation = 0.05f;
            public static final int domainColor = 0;
            public static final float domainDeltaRatio = 0.2f;
            public static final float domainStrength = 1.16f;
            public static final float lightAngle = 0.0f;
            public static final int lightColor = -1;
            public static final float lightIntensity = 1.0f;
            public static final float lightSaturation = 1.15f;
            public static final float lightScale = 2.05f;
            public static final float lightStretch = 1.0f;
            public static final boolean useLightnessCalibration = true;

            @NotNull
            public static final Default INSTANCE = new Default();
            private static final int lightmapRes = C7843R.drawable.lightmap;
            private static final int colorRes = C7843R.drawable.grad_processing_640_oneui85;

            @NotNull
            private static final PointF lightPos = new PointF(0.5f, 0.5f);

            private Default() {
            }

            @Nullable
            public final Bitmap getBmpLightmap() {
                return bmpLightmap;
            }

            public final int getColorRes() {
                return colorRes;
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

        /* JADX INFO: Access modifiers changed from: private */
        @Language("AGSL")
        public final String assembleShader(boolean useLightnessCalibration, ProcessingLightConfig.BlendMode blendMode) {
            String str = useLightnessCalibration ? " lightColor *= 1.15 - 0.5 * abs(tintLightness - viewLightness); " : "";
            ProcessingLightConfig.BlendMode blendMode2 = ProcessingLightConfig.BlendMode.PREMULT;
            return AbstractC0622a.m1170p(blendMode == blendMode2 ? "\ncolor *= viewColor.a;\ncolor += viewColor.rgb * (1 - lightColor.a);\ncolor = clamp(color, half3(0), half3(1));\nreturn half4(color, viewColor.a);\n                    " : "\nfloat alpha = max(length(color) / sqrt(3), viewColor.a);\ncolor += viewColor.rgb * (1 - lightColor.a);\ncolor = clamp(color, half3(0), half3(1));\nreturn half4(color, alpha);\n                    ", "\n}\n                ", AbstractC0000a.m16m("\nuniform shader inputShader;\nuniform shader lightMapShader;\n\nuniform shader tintShader;\nuniform half2 uTintShaderSize;\n// TODO possible for any transforming with mat3 for trs, but currently just for flipping since there's no requirements at least now.\nuniform half2 uTintFlipDirection; \n\nhalf useTint() {\n    return step(0.01, abs(uTintShaderSize.x * uTintShaderSize.y)); \n}\n    \nhalf4 texTint(half2 uv) {\n    uv = mix(uv, half2(1 - uv.x, uv.y), step(0.5, uTintFlipDirection.x));\n    return tintShader.eval(uv * uTintShaderSize);\n}\n\n// get tint color aligned center\nhalf3 getTintColor(half2 uv, half2 resolution) {\n    half2 guv = uv;\n    half asp = resolution.x / resolution.y;\n    if (asp > 1) {\n        guv.y /= asp;\n        guv.y += 0.5 * (1 - 1 / asp);\n    } else {\n        guv.x *= asp;\n        guv.x += 0.5 * (1 - asp);\n    }\n    return clamp(texTint(guv).rgb, half3(0), half3(1));\n}\n\n// get tint color aligned center\nhalf4 getTintColorAlpha(half2 uv, half2 resolution) {\n    half2 guv = uv;\n    half asp = resolution.x / resolution.y;\n    if (asp > 1) {\n        guv.y /= asp;\n        guv.y += 0.5 * (1 - 1 / asp);\n    } else {\n        guv.x *= asp;\n        guv.x += 0.5 * (1 - asp);\n    }\n    half4 tint = texTint(guv);\n    return clamp(tint, half4(0), half4(1));\n}\n        \n\nuniform half2 uLightMapSize;\nuniform half uStretch;\nuniform int uLightPositionStretch;\nuniform half2 uSize;\n\nuniform half2 uLightPosition;\nuniform half uLightRotation;\nuniform half uLightScale;\nuniform half4 uLightColor; // TODO for dev phase. use tint shader\nuniform half uLightIntensity;\nuniform half uLightSaturation;\n\nuniform half4 uDomainColor;\nuniform half uDomainStrength;\nuniform half uDomainDeltaRatio;\n\nuniform half uDitherVariation;\n\nhalf rand(half2 uv) {\n    return fract(sin(dot(uv, half2(12.9898, 78.233))) * 43758.5453);\n}\n\nhalf dither(half2 uv, half variation) {\n    return 1 + variation * 2 * (rand(uv * 10.0) - 0.5);\n}\n\nhalf2 rotate(half2 p, half angle) {\n    half r = radians(angle);\n    half s = sin(r);\n    half c = cos(r);\n    return mat2(c, -s, s, c) * p;\n}\n\nhalf4 texView(half2 uv) {\n    return inputShader.eval(uv * uSize);\n}\n\n// get relative uv based on longer length among width and height of the view. \nhalf2 relativeUv(half2 uv, half2 pos, half scale, half stretch) {\n    half asp = uSize.x / uSize.y;\n    asp = mix(asp, stretch, step(0.01, stretch));\n    if (asp > 1) {\n        pos.y /= asp;\n        uv.y /= asp;\n    } else {\n        pos.x *= asp;\n        uv.x *= asp;\n    }\n    pos /= scale;\n    uv /= scale;\n    uv -= pos - half2(0.5); // translate\n    return uv;\n}\n\nhalf4 texLight(half2 uv, half2 pos, half rotation, half scale, half stretch) {\n    half2 ruv = relativeUv(rotate(uv, rotation), rotate(pos, rotation), scale, stretch);\n    half4 map = lightMapShader.eval(ruv * uLightMapSize);\n    // TODO alpha should be the actual alpha of the map in future.\n    return half4(map.rgb, length(map.rgb) / sqrt(3));\n}\n\nhalf2 stretchedPos(half2 pos, half scale) {\n    half aspectRatio = uSize.x / uSize.y;\n    half2 dPos = 0.5 * half2(pos - half2(0.5, 0.5));\n    if (scale > 1) {\n        dPos *= scale;\n    }\n    half asp = aspectRatio;\n    dPos.x *= step(aspectRatio, 1);\n    dPos.y *= step(1, aspectRatio);\n    asp = mix(asp, 1 / aspectRatio, step(aspectRatio, 1));\n    return half2(pos + (asp - 1) * dPos);\n}\n\nconst half epsilon = 0.0001;\nhalf3 rgb2hsl(half3 rgb) {\n    half minColor = min(rgb.r, min(rgb.g, rgb.b));\n    half maxColor = max(rgb.r, max(rgb.g, rgb.b));\n    half3 mask = step(rgb.grr, rgb.rgb) * step(rgb.bbg, rgb.rgb);\n    half3 hue = mask * (half3(0, 2, 4) + (rgb.gbr - rgb.brg) / (maxColor - minColor + epsilon)) / 6;\n    return half3(\n            fract(1 + hue.x + hue.y + hue.z), // h \n            (maxColor - minColor) / (1 - abs(minColor + maxColor - 1) + epsilon), // s\n            (minColor + maxColor) * 0.5 // l\n    );\n}\n\nhalf triangular(half x) {\n    half dbx = 2 * x;\n    return mix(dbx, 2 - dbx, step(1, dbx));\n}\n\n// a simple way to compute color delta using HSL Color Space. Imagine a HSL cylinder for deep understanding.\n// TODO do a test with CIELAB color model to mimic human eyes, not just using this model. \nhalf computeColorDelta(half4 c1, half4 c2) {\n    half3 hsl1 = rgb2hsl(c1.rgb * c1.a);\n    half3 hsl2 = rgb2hsl(c2.rgb * c2.a);\n    half dl = abs(hsl1.z - hsl2.z);\n    half ds = abs(hsl1.y - hsl2.y);\n    half dh = abs(hsl1.x - hsl2.x);\n    dh = mix(dh, 1 - dh, step(0.5, dh)) * 2; // for closer angle with normalization\n\n    // apply weights for each channel. this would be a tune point of the color delta model.\n    half w = abs(1 - dl) * smoothstep(0.6, 1, triangular(hsl1.z) * triangular(hsl2.z)); // weight based on delta lightness.\n    ds *= 0.1 * smoothstep(0.1, 0, dh * dl); // apply delta saturation only if other delta is almost zero.                \n    dh *= w; // apply delta lightness as a weight of the hue.\n    return max(dh, max(ds, dl));\n}\n\nhalf4 main(in vec2 fragCoord) {\n    vec2 uv = fragCoord / uSize;\n    half4 viewColor = texView(uv);\n    ", blendMode == blendMode2 ? " if (viewColor.a < epsilon) return half4(0, 0, 0, 0); " : "", "\n    half2 pos = mix(uLightPosition, stretchedPos(uLightPosition, uLightScale), step(1, half(uLightPositionStretch)));\n\n    // light color\n    half4 lightColor = texLight(uv, pos, uLightRotation, uLightScale, uStretch);\n    lightColor *= uLightIntensity;\n    lightColor = clamp(lightColor, half4(0), half4(1));\n    half3 tintColor = mix(uLightColor.rgb, getTintColor(uv, uSize), useTint());\n    lightColor.rgb *= tintColor;\n    lightColor.rgb *= dither(uv, uDitherVariation);\n    \n    half useDomain = step(0.1, uDomainColor.a);\n    half domainLuminance = clamp(max(computeColorDelta(viewColor, uDomainColor), uDomainDeltaRatio) * uDomainStrength, 0.0, 1.0);\n    lightColor.a = mix(lightColor.a, lightColor.a * domainLuminance, useDomain);\n    lightColor.a = clamp(lightColor.a, 0, 1);\n\n    // reduce tinting light by delta lightness btw tint and view pixels.\n    half tintLightness = length(tintColor.rgb) / sqrt(3);\n    half viewLightness = length(viewColor.rgb * viewColor.a) / sqrt(3);\n    ", str, "\n\n    half3 color = mix(lightColor.rgb, lightColor.rgb * domainLuminance, useDomain);\n    "));
        }

        private Companion() {
        }
    }

    public /* synthetic */ ProcessingLightRenderEffect(boolean z, ProcessingLightConfig.BlendMode blendMode, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z, blendMode);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setDitherVariation$lambda$20(ProcessingLightRenderEffect processingLightRenderEffect, float f, RuntimeShader runtimeShader) {
        RuntimeShader shader = processingLightRenderEffect.getShader();
        if (shader != null) {
            shader.setFloatUniform("uDitherVariation", f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setDomainColor$lambda$17(int i, ProcessingLightRenderEffect processingLightRenderEffect, RuntimeShader runtimeShader) {
        Color colorValueOf = Color.valueOf(i);
        Intrinsics.checkNotNullExpressionValue(colorValueOf, "valueOf(...)");
        RuntimeShader shader = processingLightRenderEffect.getShader();
        if (shader != null) {
            shader.setFloatUniform("uDomainColor", colorValueOf.red(), colorValueOf.green(), colorValueOf.blue(), colorValueOf.alpha());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setDomainDeltaRatio$lambda$18(ProcessingLightRenderEffect processingLightRenderEffect, float f, RuntimeShader runtimeShader) {
        RuntimeShader shader = processingLightRenderEffect.getShader();
        if (shader != null) {
            shader.setFloatUniform("uDomainDeltaRatio", f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setDomainStrength$lambda$19(ProcessingLightRenderEffect processingLightRenderEffect, float f, RuntimeShader runtimeShader) {
        RuntimeShader shader = processingLightRenderEffect.getShader();
        if (shader != null) {
            shader.setFloatUniform("uDomainStrength", f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setLightColor$lambda$9(int i, ProcessingLightRenderEffect processingLightRenderEffect, RuntimeShader runtimeShader) {
        Color colorValueOf = Color.valueOf(i);
        Intrinsics.checkNotNullExpressionValue(colorValueOf, "valueOf(...)");
        RuntimeShader shader = processingLightRenderEffect.getShader();
        if (shader != null) {
            shader.setFloatUniform("uLightColor", colorValueOf.red(), colorValueOf.green(), colorValueOf.blue(), colorValueOf.alpha());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setLightIntensity$lambda$15(ProcessingLightRenderEffect processingLightRenderEffect, float f, RuntimeShader runtimeShader) {
        RuntimeShader shader = processingLightRenderEffect.getShader();
        if (shader != null) {
            shader.setFloatUniform("uLightIntensity", f);
        }
    }

    private final void setLightMap(Bitmap bitmap) {
        if (bitmap == null) {
            updateShader(new C7865q(this, 1));
        } else {
            updateShader(new C7871d(this, bitmap, 0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setLightMap$lambda$7(ProcessingLightRenderEffect processingLightRenderEffect, RuntimeShader runtimeShader) {
        RuntimeShader shader = processingLightRenderEffect.getShader();
        if (shader != null) {
            shader.setFloatUniform("uLightMapSize", 0.0f, 0.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setLightMap$lambda$8(ProcessingLightRenderEffect processingLightRenderEffect, Bitmap bitmap, RuntimeShader runtimeShader) {
        RuntimeShader shader = processingLightRenderEffect.getShader();
        if (shader != null) {
            shader.setInputBuffer("lightMapShader", new BitmapShader(bitmap, Shader.TileMode.DECAL, Shader.TileMode.DECAL));
        }
        RuntimeShader shader2 = processingLightRenderEffect.getShader();
        if (shader2 != null) {
            shader2.setFloatUniform("uLightMapSize", bitmap.getWidth(), bitmap.getHeight());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setLightPosition$lambda$11(ProcessingLightRenderEffect processingLightRenderEffect, PointF pointF, RuntimeShader runtimeShader) {
        RuntimeShader shader = processingLightRenderEffect.getShader();
        if (shader != null) {
            shader.setFloatUniform("uLightPosition", pointF.x, pointF.y);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setLightPositionStretch$lambda$12(ProcessingLightRenderEffect processingLightRenderEffect, boolean z, RuntimeShader runtimeShader) {
        RuntimeShader shader = processingLightRenderEffect.getShader();
        if (shader != null) {
            shader.setIntUniform("uLightPositionStretch", z ? 1 : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setLightRotation$lambda$10(ProcessingLightRenderEffect processingLightRenderEffect, float f, RuntimeShader runtimeShader) {
        RuntimeShader shader = processingLightRenderEffect.getShader();
        if (shader != null) {
            shader.setFloatUniform("uLightRotation", f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setLightSaturation$lambda$16(ProcessingLightRenderEffect processingLightRenderEffect, float f, RuntimeShader runtimeShader) {
        RuntimeShader shader = processingLightRenderEffect.getShader();
        if (shader != null) {
            shader.setFloatUniform("uLightSaturation", f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setLightScale$lambda$13(ProcessingLightRenderEffect processingLightRenderEffect, float f, RuntimeShader runtimeShader) {
        RuntimeShader shader = processingLightRenderEffect.getShader();
        if (shader != null) {
            shader.setFloatUniform("uLightScale", f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setStretch$lambda$14(ProcessingLightRenderEffect processingLightRenderEffect, float f, RuntimeShader runtimeShader) {
        RuntimeShader shader = processingLightRenderEffect.getShader();
        if (shader != null) {
            shader.setFloatUniform("uStretch", f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setTintShader$lambda$6(ProcessingLightRenderEffect processingLightRenderEffect, Shader shader, PointF pointF, RuntimeShader runtimeShader) {
        RuntimeShader shader2 = processingLightRenderEffect.getShader();
        if (shader2 != null) {
            processingLightRenderEffect.setTintShaderUniforms(shader2, shader, pointF);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setTintTexture$lambda$4(ProcessingLightRenderEffect processingLightRenderEffect, Bitmap bitmap, RuntimeShader runtimeShader) {
        RuntimeShader shader = processingLightRenderEffect.getShader();
        if (shader != null) {
            processingLightRenderEffect.setTintTexture(shader, bitmap);
        }
    }

    @Override // com.samsung.android.sesl.visualeffect.lighteffects.common.runtimshader.VibeRenderEffectBase, com.samsung.android.sesl.visualeffect.lighteffects.common.runtimshader.VibeRenderEffect
    public void destroy() {
        super.destroy();
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

    @Override // com.samsung.android.sesl.visualeffect.lighteffects.common.runtimshader.VibeRenderEffectBase
    public void onInitialize(@NotNull Context appContext) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Companion.Default r02 = Companion.Default.INSTANCE;
        if (r02.getBmpLightmap() == null) {
            r02.setBmpLightmap(BitmapFactory.decodeResource(appContext.getResources(), r02.getLightmapRes()));
        }
        Bitmap bmpLightmap = r02.getBmpLightmap();
        if (bmpLightmap != null) {
            setLightMap(bmpLightmap);
        }
        Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(appContext.getResources(), r02.getColorRes());
        if (bitmapDecodeResource != null) {
            setTintTexture(bitmapDecodeResource);
        }
    }

    public final void setDitherVariation(float ditherVariation) {
        updateShader(new C7870c(this, ditherVariation, 2));
    }

    public final void setDomainColor(@ColorInt int colorInt) {
        updateShader(new C7872e(colorInt, this, 1));
    }

    public final void setDomainDeltaRatio(float deltaRatio) {
        updateShader(new C7870c(this, deltaRatio, 6));
    }

    public final void setDomainStrength(float strength) {
        updateShader(new C7870c(this, strength, 1));
    }

    public final void setLightColor(@ColorInt int colorInt) {
        updateShader(new C7872e(colorInt, this, 0));
    }

    public final void setLightIntensity(float intensity) {
        updateShader(new C7870c(this, intensity, 7));
    }

    public final void setLightPosition(@NotNull PointF pos) {
        Intrinsics.checkNotNullParameter(pos, "pos");
        updateShader(new C7860l(this, pos, 2));
    }

    public final void setLightPositionStretch(boolean usePositionStretched) {
        updateShader(new C7864p(this, usePositionStretched, 1));
    }

    public final void setLightRotation(float angle) {
        updateShader(new C7870c(this, angle, 0));
    }

    public final void setLightSaturation(float saturation) {
        updateShader(new C7870c(this, saturation, 4));
    }

    public final void setLightScale(float scale) {
        updateShader(new C7870c(this, scale, 3));
    }

    public void setRenderEffect(@Nullable RenderEffect renderEffect) {
        this.renderEffect = renderEffect;
    }

    public void setShader(@Nullable RuntimeShader runtimeShader) {
        this.shader = runtimeShader;
    }

    public final void setStretch(float stretch) {
        updateShader(new C7870c(this, stretch, 5));
    }

    @Override // com.samsung.android.sesl.visualeffect.lighteffects.common.runtimshader.IColorizable
    public void setTintFlipDirection(@NotNull RuntimeShader runtimeShader, @NotNull PointF pointF) {
        IColorizable.DefaultImpls.setTintFlipDirection(this, runtimeShader, pointF);
    }

    @Override // com.samsung.android.sesl.visualeffect.lighteffects.common.runtimshader.IColorizable
    public void setTintShader(@Nullable Shader tintShader, @Nullable PointF tintFragSize) {
        updateShader(new C7863o(this, tintShader, tintFragSize, 1));
    }

    @Override // com.samsung.android.sesl.visualeffect.lighteffects.common.runtimshader.IColorizable
    public void setTintShaderUniforms(@NotNull RuntimeShader runtimeShader, @Nullable Shader shader, @Nullable PointF pointF) {
        IColorizable.DefaultImpls.setTintShaderUniforms(this, runtimeShader, shader, pointF);
    }

    @Override // com.samsung.android.sesl.visualeffect.lighteffects.common.runtimshader.IColorizable
    public void setTintTexture(@NotNull RuntimeShader runtimeShader, @Nullable Bitmap bitmap) {
        IColorizable.DefaultImpls.setTintTexture(this, runtimeShader, bitmap);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProcessingLightRenderEffect(boolean z, @NotNull ProcessingLightConfig.BlendMode blendMode) {
        super(false, 1, null);
        Intrinsics.checkNotNullParameter(blendMode, "blendMode");
        AbstractC7011a.m5287q();
        this.shader = AbstractC7011a.m5275e(INSTANCE.assembleShader(z, blendMode));
        setLightColor(-1);
        setLightPosition(Companion.Default.INSTANCE.getLightPos());
        setLightScale(2.05f);
        setLightIntensity(1.0f);
        setLightSaturation(1.15f);
        setStretch(1.0f);
        setDomainColor(0);
        setDomainStrength(1.16f);
        setDomainDeltaRatio(0.2f);
    }

    @Override // com.samsung.android.sesl.visualeffect.lighteffects.common.runtimshader.IColorizable
    public void setTintTexture(@Nullable Bitmap bitmap) {
        updateShader(new C7871d(this, bitmap, 1));
    }
}
