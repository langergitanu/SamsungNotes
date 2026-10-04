package com.samsung.android.sesl.visualeffect.lighteffects.transitionlight;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.PointF;
import android.graphics.RenderEffect;
import android.graphics.RuntimeShader;
import android.graphics.Shader;
import androidx.annotation.RequiresApi;
import com.samsung.android.sdk.bixby2.state.StateHandler;
import com.samsung.android.sesl.visualeffect.lighteffects.common.runtimshader.IColorizable;
import com.samsung.android.sesl.visualeffect.lighteffects.common.runtimshader.IProgressive;
import com.samsung.android.sesl.visualeffect.lighteffects.common.runtimshader.VibeRenderEffectBase;
import com.samsung.android.sesl.visualeffect.lighteffects.guidinglight.C7860l;
import com.samsung.android.sesl.visualeffect.lighteffects.guidinglight.C7863o;
import com.samsung.android.sesl.visualeffect.lighteffects.radialgrad.AbstractC7876d;
import com.samsung.android.sesl.visualeffect.lighteffects.radialgrad.WiggleAnimationConfig;
import com.samsung.android.sesl.visualeffect.lighteffects.transitionlight.TransitionLightConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.intellij.lang.annotations.Language;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@RequiresApi(33)
@Metadata(m13885d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u0000 <2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001<B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001eH\u0014J\u000e\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020!J\u0010\u0010\"\u001a\u00020\u00192\b\u0010#\u001a\u0004\u0018\u00010$J\u000e\u0010%\u001a\u00020\u00192\u0006\u0010&\u001a\u00020\u001bJ\u000e\u0010'\u001a\u00020\u00192\u0006\u0010(\u001a\u00020\u001bJ\u0012\u0010)\u001a\u00020\u00192\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u001c\u0010*\u001a\u00020\u00192\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\u0010\u0010/\u001a\u00020\u00192\b\u0010#\u001a\u0004\u0018\u00010$J\u000e\u00100\u001a\u00020\u00192\u0006\u00101\u001a\u00020.J\u000e\u00102\u001a\u00020\u00192\u0006\u00103\u001a\u00020\u001bJ\u000e\u00104\u001a\u00020\u00192\u0006\u00105\u001a\u00020\u001bJ\u000e\u00106\u001a\u00020\u00192\u0006\u00107\u001a\u00020\u001bJ\u000e\u00108\u001a\u00020\u00192\u0006\u00109\u001a\u00020:J\b\u0010;\u001a\u00020\u0019H\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u0004\u0018\u00010\r8VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006="}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/lighteffects/transitionlight/TransitionLightRenderEffect;", "Lcom/samsung/android/sesl/visualeffect/lighteffects/common/runtimshader/VibeRenderEffectBase;", "Lcom/samsung/android/sesl/visualeffect/lighteffects/common/runtimshader/IProgressive;", "Lcom/samsung/android/sesl/visualeffect/lighteffects/common/runtimshader/IColorizable;", "<init>", "()V", "shader", "Landroid/graphics/RuntimeShader;", "getShader", "()Landroid/graphics/RuntimeShader;", "setShader", "(Landroid/graphics/RuntimeShader;)V", "renderEffect", "Landroid/graphics/RenderEffect;", "getRenderEffect", "()Landroid/graphics/RenderEffect;", "setRenderEffect", "(Landroid/graphics/RenderEffect;)V", "startProgress", "", "getStartProgress", "()J", "setStartProgress", "(J)V", "setProgress", "", "progress", "", "onInitialize", StateHandler.KEY_APP_STATE, "Landroid/content/Context;", "setRevealMode", "revealMode", "Lcom/samsung/android/sesl/visualeffect/lighteffects/transitionlight/TransitionLightConfig$RevealMode;", "setBitmap", "bitmap", "Landroid/graphics/Bitmap;", "setTintIntensity", "tintIntensity", "setTintSaturation", "tintSaturation", "setTintTexture", "setTintShader", "tintShader", "Landroid/graphics/Shader;", "tintFragSize", "Landroid/graphics/PointF;", "setTransMap", "setTransPosition", "pos", "setTransScale", WiggleAnimationConfig.KEY_SCALE, "setTransAlpha", "alpha", "setStretch", "stretch", "setScaleType", "scaleType", "Lcom/samsung/android/sesl/visualeffect/lighteffects/transitionlight/TransitionLightConfig$ScaleType;", "destroy", "Companion", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nTransitionLightRenderEffect.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TransitionLightRenderEffect.kt\ncom/samsung/android/sesl/visualeffect/lighteffects/transitionlight/TransitionLightRenderEffect\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,316:1\n1#2:317\n*E\n"})
public final class TransitionLightRenderEffect extends VibeRenderEffectBase implements IProgressive, IColorizable {

    @Language("AGSL")
    @NotNull
    public static final String SHADER = "\nuniform shader inputShader;\nuniform shader transitionMapShader;\nuniform shader imageBitmapShader;\n\nuniform int uRevealMode;\nuniform vec2 uTransitionMapSize;\nuniform half uStretch;\nuniform vec2 uImageBitmapSize;\nuniform int uScaleType;  // 0: FIT_XY, 1: FIT_CENTER, 2: CENTER_CROP, 3: CENTER_INSIDE\n\nuniform shader tintShader;\nuniform half2 uTintShaderSize;\n// TODO possible for any transforming with mat3 for trs, but currently just for flipping since there's no requirements at least now.\nuniform half2 uTintFlipDirection; \n\nhalf useTint() {\n    return step(0.01, abs(uTintShaderSize.x * uTintShaderSize.y)); \n}\n    \nhalf4 texTint(half2 uv) {\n    uv = mix(uv, half2(1 - uv.x, uv.y), step(0.5, uTintFlipDirection.x));\n    return tintShader.eval(uv * uTintShaderSize);\n}\n\n// get tint color aligned center\nhalf3 getTintColor(half2 uv, half2 resolution) {\n    half2 guv = uv;\n    half asp = resolution.x / resolution.y;\n    if (asp > 1) {\n        guv.y /= asp;\n        guv.y += 0.5 * (1 - 1 / asp);\n    } else {\n        guv.x *= asp;\n        guv.x += 0.5 * (1 - asp);\n    }\n    return clamp(texTint(guv).rgb, half3(0), half3(1));\n}\n\n// get tint color aligned center\nhalf4 getTintColorAlpha(half2 uv, half2 resolution) {\n    half2 guv = uv;\n    half asp = resolution.x / resolution.y;\n    if (asp > 1) {\n        guv.y /= asp;\n        guv.y += 0.5 * (1 - 1 / asp);\n    } else {\n        guv.x *= asp;\n        guv.x += 0.5 * (1 - asp);\n    }\n    half4 tint = texTint(guv);\n    return clamp(tint, half4(0), half4(1));\n}\n        \nuniform float uTintIntensity;\nuniform float uTintSaturation;\n\nuniform vec2 uSize;\nuniform float uProgress;\n\nuniform vec2 uTransPosition;\nuniform float uTransScale;\nuniform float uTransAlpha;\n\nconst int FIT_XY = 0;\nconst int FIT_CENTER = 1;\nconst int CENTER_CROP = 2;\nconst int CENTER_INSIDE = 3;\n\nvec2 getScaledUV(vec2 uv, vec2 viewSize, vec2 imageSize) {\n    float viewAspect = viewSize.x / viewSize.y;\n    float imageAspect = imageSize.x / imageSize.y;\n    \n    if (uScaleType == FIT_XY) { // FIT_XY\n        return uv;\n    } else if (uScaleType == FIT_CENTER) { // FIT_CENTER\n        float scaleX = viewSize.x / imageSize.x;\n        float scaleY = viewSize.y / imageSize.y;\n        float scale = min(scaleX, scaleY);\n        vec2 scaledSize = imageSize * scale;\n        vec2 offset = (viewSize - scaledSize) / 2.0;\n        return (uv * viewSize - offset) / scaledSize;\n    } else if (uScaleType == CENTER_CROP) { // CENTER_CROP\n        float scaleX = viewSize.x / imageSize.x;\n        float scaleY = viewSize.y / imageSize.y;\n        float scale = max(scaleX, scaleY);\n        vec2 scaledSize = imageSize * scale;\n        vec2 offset = (scaledSize - viewSize) / 2.0;\n        return (uv * viewSize + offset) / scaledSize;\n    } else { // CENTER_INSIDE\n        if (imageAspect > viewAspect) {\n            float scale = viewSize.x / imageSize.x;\n            float scaledHeight = imageSize.y * scale;\n            float offsetY = (viewSize.y - scaledHeight) / 2.0;\n            return vec2(uv.x, (uv.y * viewSize.y - offsetY) / scaledHeight);\n        } else {\n            float scale = viewSize.y / imageSize.y;\n            float scaledWidth = imageSize.x * scale;\n            float offsetX = (viewSize.x - scaledWidth) / 2.0;\n            return vec2((uv.x * viewSize.x - offsetX) / scaledWidth, uv.y);\n        }\n    }\n}\n\nvec4 texView(vec2 uv) {\n    return inputShader.eval(uv * uSize);\n}\n\nvec4 texImage(vec2 uv) {\n    vec2 scaledUV = getScaledUV(uv, uSize, uImageBitmapSize);\n    return imageBitmapShader.eval(scaledUV * uImageBitmapSize);\n}\n\n// get relative uv based on longer length among width and height of the view. \nvec2 relativeUv(vec2 uv, vec2 pos, float scale, half stretch) {\n    float asp = uSize.x / uSize.y;\n    asp = mix(asp, stretch, step(0.01, stretch));\n    if (asp > 1) {\n        pos.y /= asp;\n        uv.y /= asp;\n    } else {\n        pos.x *= asp;\n        uv.x *= asp;\n    }\n    pos /= scale;\n    uv /= scale;\n    uv -= pos - vec2(0.5); // translate\n    return uv;\n}\n\nvec4 texTrans(vec2 uv, vec2 pos, float scale, half stretch) {\n    vec2 ruv = relativeUv(uv, pos, scale, stretch);\n    vec4 map = transitionMapShader.eval(ruv * uTransitionMapSize);\n    \n    float alpha = length(map.rgb) / sqrt(3);\n    return vec4(map.rgb, alpha);\n}\n\nhalf getTintAlpha(half alpha) {\n    float tintAlpha = useTint() * alpha;\n    tintAlpha = uTintIntensity * smoothstep(0.5, 0, abs(0.5 - tintAlpha));\n    return min(tintAlpha, smoothstep(1, 0.8, uProgress));  \n}\n\nvec4 main(in vec2 fragCoord) {\n    vec2 uv = fragCoord / uSize;\n    // view color\n    vec4 viewColor = texView(uv);\n    // image color to reveal\n    vec4 imageColor = texImage(uv);\n    // trans color\n    vec4 transColor = texTrans(uv, uTransPosition, uTransScale, uStretch);\n    float alpha = max(uTransAlpha * transColor.a, smoothstep(0.8, 1, uProgress));\n    vec4 color = vec4(0);\n    float tintAlpha = getTintAlpha(transColor.a); \n    if (uRevealMode == 0) {\n        color = mix(viewColor, imageColor, alpha);\n        color = mix(color, vec4(imageColor.rgb, imageColor.a * alpha), step(viewColor.a, 0));\n        color.rgb = mix(color.rgb, getTintColor(uv, uSize) * tintAlpha * uTintSaturation + color.rgb * (1 - tintAlpha), useTint()); \n    } else if (uRevealMode == 1) {\n        color = mix(color, viewColor, alpha); \n        color = mix(color, vec4(getTintColor(uv, uSize) * uTintSaturation, 1) + color * (1 - tintAlpha), tintAlpha);                    \n    }\n    return color;\n}\n        ";

    @Nullable
    private RenderEffect renderEffect;

    @Nullable
    private RuntimeShader shader;
    private long startProgress;

    public TransitionLightRenderEffect() {
        super(false, 1, null);
        this.shader = AbstractC7876d.m6722k();
        setProgress(0.0f);
        Companion.Default r12 = Companion.Default.INSTANCE;
        setRevealMode(r12.getRevealMode());
        setScaleType(TransitionLightConfig.ScaleType.FIT_XY);
        setTransAlpha(0.0f);
        setTransPosition(r12.getTransPosition());
        setTransScale(0.0f);
        setTintIntensity(0.48f);
        setStretch(1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setBitmap$lambda$5(TransitionLightRenderEffect transitionLightRenderEffect, RuntimeShader runtimeShader) {
        RuntimeShader shader = transitionLightRenderEffect.getShader();
        if (shader != null) {
            shader.setFloatUniform("uImageBitmapSize", 0.0f, 0.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setBitmap$lambda$6(TransitionLightRenderEffect transitionLightRenderEffect, Bitmap bitmap, RuntimeShader runtimeShader) {
        RuntimeShader shader = transitionLightRenderEffect.getShader();
        if (shader != null) {
            shader.setInputBuffer("imageBitmapShader", new BitmapShader(bitmap, Shader.TileMode.DECAL, Shader.TileMode.DECAL));
        }
        RuntimeShader shader2 = transitionLightRenderEffect.getShader();
        if (shader2 != null) {
            shader2.setFloatUniform("uImageBitmapSize", bitmap.getWidth(), bitmap.getHeight());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setProgress$lambda$1(TransitionLightRenderEffect transitionLightRenderEffect, float f, RuntimeShader runtimeShader) {
        RuntimeShader shader = transitionLightRenderEffect.getShader();
        if (shader != null) {
            shader.setFloatUniform("uProgress", f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setRevealMode$lambda$4(TransitionLightRenderEffect transitionLightRenderEffect, TransitionLightConfig.RevealMode revealMode, RuntimeShader runtimeShader) {
        RuntimeShader shader = transitionLightRenderEffect.getShader();
        if (shader != null) {
            shader.setIntUniform("uRevealMode", revealMode.ordinal());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setScaleType$lambda$19(TransitionLightRenderEffect transitionLightRenderEffect, TransitionLightConfig.ScaleType scaleType, RuntimeShader runtimeShader) {
        RuntimeShader shader = transitionLightRenderEffect.getShader();
        if (shader != null) {
            shader.setIntUniform("uScaleType", scaleType.ordinal());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setStretch$lambda$18(TransitionLightRenderEffect transitionLightRenderEffect, float f, RuntimeShader runtimeShader) {
        RuntimeShader shader = transitionLightRenderEffect.getShader();
        if (shader != null) {
            shader.setFloatUniform("uStretch", f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setTintIntensity$lambda$7(TransitionLightRenderEffect transitionLightRenderEffect, float f, RuntimeShader runtimeShader) {
        RuntimeShader shader = transitionLightRenderEffect.getShader();
        if (shader != null) {
            shader.setFloatUniform("uTintIntensity", f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setTintSaturation$lambda$8(TransitionLightRenderEffect transitionLightRenderEffect, float f, RuntimeShader runtimeShader) {
        RuntimeShader shader = transitionLightRenderEffect.getShader();
        if (shader != null) {
            shader.setFloatUniform("uTintSaturation", f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setTintShader$lambda$12(TransitionLightRenderEffect transitionLightRenderEffect, Shader shader, PointF pointF, RuntimeShader runtimeShader) {
        RuntimeShader shader2 = transitionLightRenderEffect.getShader();
        if (shader2 != null) {
            transitionLightRenderEffect.setTintShaderUniforms(shader2, shader, pointF);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setTintTexture$lambda$10(TransitionLightRenderEffect transitionLightRenderEffect, Bitmap bitmap, RuntimeShader runtimeShader) {
        RuntimeShader shader = transitionLightRenderEffect.getShader();
        if (shader != null) {
            transitionLightRenderEffect.setTintTexture(shader, bitmap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setTransAlpha$lambda$17(TransitionLightRenderEffect transitionLightRenderEffect, float f, RuntimeShader runtimeShader) {
        RuntimeShader shader = transitionLightRenderEffect.getShader();
        if (shader != null) {
            shader.setFloatUniform("uTransAlpha", f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setTransMap$lambda$13(TransitionLightRenderEffect transitionLightRenderEffect, RuntimeShader runtimeShader) {
        RuntimeShader shader = transitionLightRenderEffect.getShader();
        if (shader != null) {
            shader.setFloatUniform("uTransitionMapSize", 0.0f, 0.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setTransMap$lambda$14(TransitionLightRenderEffect transitionLightRenderEffect, Bitmap bitmap, RuntimeShader runtimeShader) {
        RuntimeShader shader = transitionLightRenderEffect.getShader();
        if (shader != null) {
            shader.setInputBuffer("transitionMapShader", new BitmapShader(bitmap, Shader.TileMode.DECAL, Shader.TileMode.DECAL));
        }
        RuntimeShader shader2 = transitionLightRenderEffect.getShader();
        if (shader2 != null) {
            shader2.setFloatUniform("uTransitionMapSize", bitmap.getWidth(), bitmap.getHeight());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setTransPosition$lambda$15(TransitionLightRenderEffect transitionLightRenderEffect, PointF pointF, RuntimeShader runtimeShader) {
        RuntimeShader shader = transitionLightRenderEffect.getShader();
        if (shader != null) {
            shader.setFloatUniform("uTransPosition", pointF.x, pointF.y);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setTransScale$lambda$16(TransitionLightRenderEffect transitionLightRenderEffect, float f, RuntimeShader runtimeShader) {
        RuntimeShader shader = transitionLightRenderEffect.getShader();
        if (shader != null) {
            shader.setFloatUniform("uTransScale", f);
        }
    }

    @Override // com.samsung.android.sesl.visualeffect.lighteffects.common.runtimshader.VibeRenderEffectBase, com.samsung.android.sesl.visualeffect.lighteffects.common.runtimshader.VibeRenderEffect
    public void destroy() {
        super.destroy();
        setTransMap(null);
        Companion.Default r12 = Companion.Default.INSTANCE;
        Bitmap bmpLightmap = r12.getBmpLightmap();
        if (bmpLightmap != null) {
            bmpLightmap.recycle();
        }
        r12.setBmpLightmap(null);
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
            r02.setBmpLightmap(BitmapFactory.decodeResource(appContext.getResources(), r02.getTransMapRes()));
        }
        Bitmap bmpLightmap = r02.getBmpLightmap();
        if (bmpLightmap != null) {
            setTransMap(bmpLightmap);
        }
        Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(appContext.getResources(), r02.getColorRes());
        if (bitmapDecodeResource != null) {
            setTintTexture(bitmapDecodeResource);
        }
    }

    public final void setBitmap(@Nullable Bitmap bitmap) {
        if (bitmap == null) {
            updateShader(new C7885b(this, 0));
        } else {
            updateShader(new C7886c(this, bitmap, 0));
        }
    }

    @Override // com.samsung.android.sesl.visualeffect.lighteffects.common.runtimshader.IProgressive
    public void setProgress(float progress) {
        updateShader(new C7887d(this, progress, 2));
    }

    public void setRenderEffect(@Nullable RenderEffect renderEffect) {
        this.renderEffect = renderEffect;
    }

    public final void setRevealMode(@NotNull TransitionLightConfig.RevealMode revealMode) {
        Intrinsics.checkNotNullParameter(revealMode, "revealMode");
        updateShader(new C7860l(this, revealMode, 6));
    }

    public final void setScaleType(@NotNull TransitionLightConfig.ScaleType scaleType) {
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        updateShader(new C7860l(this, scaleType, 4));
    }

    public void setShader(@Nullable RuntimeShader runtimeShader) {
        this.shader = runtimeShader;
    }

    @Override // com.samsung.android.sesl.visualeffect.lighteffects.common.runtimshader.IProgressive
    public void setStartProgress(long j) {
        this.startProgress = j;
    }

    public final void setStretch(float stretch) {
        updateShader(new C7887d(this, stretch, 5));
    }

    @Override // com.samsung.android.sesl.visualeffect.lighteffects.common.runtimshader.IColorizable
    public void setTintFlipDirection(@NotNull RuntimeShader runtimeShader, @NotNull PointF pointF) {
        IColorizable.DefaultImpls.setTintFlipDirection(this, runtimeShader, pointF);
    }

    public final void setTintIntensity(float tintIntensity) {
        updateShader(new C7887d(this, tintIntensity, 1));
    }

    public final void setTintSaturation(float tintSaturation) {
        updateShader(new C7887d(this, tintSaturation, 3));
    }

    @Override // com.samsung.android.sesl.visualeffect.lighteffects.common.runtimshader.IColorizable
    public void setTintShader(@Nullable Shader tintShader, @Nullable PointF tintFragSize) {
        updateShader(new C7863o(this, tintShader, tintFragSize, 2));
    }

    @Override // com.samsung.android.sesl.visualeffect.lighteffects.common.runtimshader.IColorizable
    public void setTintShaderUniforms(@NotNull RuntimeShader runtimeShader, @Nullable Shader shader, @Nullable PointF pointF) {
        IColorizable.DefaultImpls.setTintShaderUniforms(this, runtimeShader, shader, pointF);
    }

    @Override // com.samsung.android.sesl.visualeffect.lighteffects.common.runtimshader.IColorizable
    public void setTintTexture(@NotNull RuntimeShader runtimeShader, @Nullable Bitmap bitmap) {
        IColorizable.DefaultImpls.setTintTexture(this, runtimeShader, bitmap);
    }

    public final void setTransAlpha(float alpha) {
        updateShader(new C7887d(this, alpha, 4));
    }

    public final void setTransMap(@Nullable Bitmap bitmap) {
        if (bitmap == null) {
            updateShader(new C7885b(this, 1));
        } else {
            updateShader(new C7886c(this, bitmap, 2));
        }
    }

    public final void setTransPosition(@NotNull PointF pos) {
        Intrinsics.checkNotNullParameter(pos, "pos");
        updateShader(new C7860l(this, pos, 5));
    }

    public final void setTransScale(float scale) {
        updateShader(new C7887d(this, scale, 0));
    }

    @Override // com.samsung.android.sesl.visualeffect.lighteffects.common.runtimshader.IProgressive
    public void updateProgressByTime() {
        IProgressive.DefaultImpls.updateProgressByTime(this);
    }

    @Override // com.samsung.android.sesl.visualeffect.lighteffects.common.runtimshader.IColorizable
    public void setTintTexture(@Nullable Bitmap bitmap) {
        updateShader(new C7886c(this, bitmap, 1));
    }
}
