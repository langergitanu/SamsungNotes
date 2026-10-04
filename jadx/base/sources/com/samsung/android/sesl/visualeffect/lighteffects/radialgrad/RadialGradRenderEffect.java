package com.samsung.android.sesl.visualeffect.lighteffects.radialgrad;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.RenderEffect;
import android.graphics.RuntimeShader;
import android.graphics.Shader;
import android.util.Log;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import com.samsung.android.sdk.bixby2.state.StateHandler;
import com.samsung.android.sesl.visualeffect.lighteffects.common.runtimshader.C7846a;
import com.samsung.android.sesl.visualeffect.lighteffects.common.runtimshader.VibeRenderEffectBase;
import com.samsung.android.sesl.visualeffect.lighteffects.guidinglight.C7860l;
import java.util.function.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.intellij.lang.annotations.Language;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@RequiresApi(33)
@Metadata(m13885d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0014\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u0007\u0018\u0000 92\u00020\u0001:\u00019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u001d\u001a\u00020\u0011*\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u000fH\u0002J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0014J\u0010\u0010#\u001a\u00020 2\u0006\u0010$\u001a\u00020\u000fH\u0002J\u000e\u0010%\u001a\u00020 2\u0006\u0010&\u001a\u00020'J\u0010\u0010(\u001a\u00020 2\b\b\u0001\u0010)\u001a\u00020\u000fJ\u000e\u0010*\u001a\u00020 2\u0006\u0010$\u001a\u00020\u000fJ\u0016\u0010+\u001a\u00020 2\u0006\u0010,\u001a\u00020\u000f2\u0006\u0010-\u001a\u00020\u001cJ\u0018\u0010.\u001a\u00020 2\u0006\u0010,\u001a\u00020\u000f2\b\b\u0001\u0010)\u001a\u00020\u000fJ\u000e\u0010/\u001a\u00020\u000f2\u0006\u0010,\u001a\u00020\u000fJ\u0016\u00100\u001a\u00020 2\u0006\u0010,\u001a\u00020\u000f2\u0006\u00101\u001a\u000202J\u000e\u00103\u001a\u0002022\u0006\u0010,\u001a\u00020\u000fJ\u0016\u00104\u001a\u00020 2\u0006\u0010,\u001a\u00020\u000f2\u0006\u00105\u001a\u000206J\u000e\u00107\u001a\u0002062\u0006\u0010,\u001a\u00020\u000fJ\b\u00108\u001a\u00020 H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u000f@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006:"}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/lighteffects/radialgrad/RadialGradRenderEffect;", "Lcom/samsung/android/sesl/visualeffect/lighteffects/common/runtimshader/VibeRenderEffectBase;", "<init>", "()V", "shader", "Landroid/graphics/RuntimeShader;", "getShader", "()Landroid/graphics/RuntimeShader;", "setShader", "(Landroid/graphics/RuntimeShader;)V", "renderEffect", "Landroid/graphics/RenderEffect;", "getRenderEffect", "()Landroid/graphics/RenderEffect;", "spotCount", "", "spotEnabled", "", "spotColors", "spotPositions", "spotScales", "value", "blurRadius", "getBlurRadius", "()I", "setBlurRadius", "(I)V", "hasLightMap", "", "resize", "newSize", "onInitialize", "", StateHandler.KEY_APP_STATE, "Landroid/content/Context;", "buildSpotArrays", "count", "setLightMap", "bitmap", "Landroid/graphics/Bitmap;", "setBackgroundColor", "color", "setSpotCount", "setSpotEnabled", "index", "enabled", "setSpotColor", "getSpotColor", "setSpotPosition", "position", "Landroid/graphics/PointF;", "getSpotPosition", "setSpotScale", WiggleAnimationConfig.KEY_SCALE, "", "getSpotScale", "destroy", "Companion", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nRadialGradRenderEffect.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RadialGradRenderEffect.kt\ncom/samsung/android/sesl/visualeffect/lighteffects/radialgrad/RadialGradRenderEffect\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,240:1\n1#2:241\n13524#3,3:242\n*S KotlinDebug\n*F\n+ 1 RadialGradRenderEffect.kt\ncom/samsung/android/sesl/visualeffect/lighteffects/radialgrad/RadialGradRenderEffect\n*L\n120#1:242,3\n*E\n"})
public final class RadialGradRenderEffect extends VibeRenderEffectBase {
    public static final int MAX_SPOTS = 5;

    @Language("AGSL")
    @NotNull
    public static final String SHADER = "\nconst int MaxSpots = 5;\n    \nuniform shader inputShader;\nuniform shader spotLightMapShader;\nuniform half2 uLightMapSize;\n\nuniform half2 uSize;\nuniform half uTime;\n\nuniform half4 uBaseColor;\nuniform int uSpotCount;\n\nuniform half uSpotEnabled[MaxSpots];\nuniform half4 uSpotColors[MaxSpots];\nuniform half2 uSpotPositions[MaxSpots];\nuniform half uSpotScales[MaxSpots];\n\nconst half QPI = 3.141592 * 0.25;\n\nhalf4 spotData(half2 uv, half4 color, half2 pos, half scale) {\n    half asp = uSize.x / uSize.y;\n    \n    pos.x *= asp;\n    pos /= scale;\n    pos -= half2(0.5, 0.5);\n    uv.x *= asp;\n    uv /= scale; // scale by radius\n    uv -= pos; // translate\n    half4 spot = spotLightMapShader.eval(uv * uLightMapSize);\n    half alpha = color.a * length(spot.rgb) / sqrt(3); // TODO use actual alpha channel in future.\n    return half4(color.a * spot.rgb * color.rgb, alpha);\n}\n\nhalf4 main(vec2 fragCoord) {\n    vec2 uv = fragCoord / uSize;\n    half4 spots = uBaseColor;\n    for (int i = 0; i < MaxSpots; i++) { // AGSL not support conditional loop with uniform at least now\n        if (uSpotCount == i) {\n            break;\n        }\n        if (uSpotEnabled[i] > 0) {\n            half4 s = spotData(uv, uSpotColors[i], uSpotPositions[i], uSpotScales[i]);\n            spots.rgb = s.rgb + spots.rgb * (1 - s.a); // using premult\n            spots.a += s.a * (1 - spots.a);\n        }\n    }\n    half4 view = inputShader.eval(fragCoord);\n    half useView = step(0.01, view.a);\n    \n    return mix(spots, view * spots, useView); // tint if there is alpha on the view \n}\n        ";

    @NotNull
    public static final String TAG = "RadialGradRenderEffect";
    private int blurRadius;
    private boolean hasLightMap;

    @Nullable
    private RuntimeShader shader;

    @NotNull
    private float[] spotColors;
    private int spotCount;

    @NotNull
    private float[] spotEnabled;

    @NotNull
    private float[] spotPositions;

    @NotNull
    private float[] spotScales;

    public RadialGradRenderEffect() {
        super(false, 1, null);
        this.shader = AbstractC7876d.m6712a();
        this.spotEnabled = new float[0];
        this.spotColors = new float[0];
        this.spotPositions = new float[0];
        this.spotScales = new float[0];
    }

    private final void buildSpotArrays(int count) {
        this.spotEnabled = resize(this.spotEnabled, count);
        this.spotColors = resize(this.spotColors, count * 4);
        this.spotPositions = resize(this.spotPositions, count * 2);
        this.spotScales = resize(this.spotScales, count);
    }

    private final float[] resize(float[] fArr, int i) {
        float[] fArr2 = new float[i];
        int length = fArr.length;
        int i2 = 0;
        int i4 = 0;
        while (i2 < length) {
            fArr2[i4] = fArr[i2];
            i2++;
            i4++;
        }
        return fArr2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setBackgroundColor$lambda$6(int i, RadialGradRenderEffect radialGradRenderEffect, RuntimeShader runtimeShader) {
        Color colorValueOf = Color.valueOf(i);
        RuntimeShader shader = radialGradRenderEffect.getShader();
        if (shader != null) {
            shader.setFloatUniform("uBaseColor", colorValueOf.alpha() * colorValueOf.red(), colorValueOf.alpha() * colorValueOf.green(), colorValueOf.alpha() * colorValueOf.blue(), colorValueOf.alpha());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setLightMap$lambda$4(RadialGradRenderEffect radialGradRenderEffect, Bitmap bitmap, RuntimeShader runtimeShader) {
        RuntimeShader shader = radialGradRenderEffect.getShader();
        if (shader != null) {
            shader.setInputBuffer("spotLightMapShader", new BitmapShader(bitmap, Shader.TileMode.DECAL, Shader.TileMode.DECAL));
        }
        RuntimeShader shader2 = radialGradRenderEffect.getShader();
        if (shader2 != null) {
            shader2.setFloatUniform("uLightMapSize", bitmap.getWidth(), bitmap.getHeight());
        }
        radialGradRenderEffect.hasLightMap = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setSpotColor$lambda$10(int i, RadialGradRenderEffect radialGradRenderEffect, int i2, RuntimeShader runtimeShader) {
        Color colorValueOf = Color.valueOf(i);
        int i4 = i2 * 4;
        radialGradRenderEffect.spotColors[i4] = colorValueOf.red();
        radialGradRenderEffect.spotColors[i4 + 1] = colorValueOf.green();
        radialGradRenderEffect.spotColors[i4 + 2] = colorValueOf.blue();
        radialGradRenderEffect.spotColors[i4 + 3] = colorValueOf.alpha();
        RuntimeShader shader = radialGradRenderEffect.getShader();
        if (shader != null) {
            shader.setFloatUniform("uSpotColors", radialGradRenderEffect.spotColors);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setSpotCount$lambda$7(RadialGradRenderEffect radialGradRenderEffect, int i, RuntimeShader runtimeShader) {
        radialGradRenderEffect.buildSpotArrays(5);
        RuntimeShader shader = radialGradRenderEffect.getShader();
        if (shader != null) {
            shader.setIntUniform("uSpotCount", i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setSpotEnabled$lambda$8(RadialGradRenderEffect radialGradRenderEffect, int i, boolean z, RuntimeShader runtimeShader) {
        radialGradRenderEffect.spotEnabled[i] = z ? 1.0f : 0.0f;
        RuntimeShader shader = radialGradRenderEffect.getShader();
        if (shader != null) {
            shader.setFloatUniform("uSpotEnabled", radialGradRenderEffect.spotEnabled);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setSpotPosition$lambda$11(RadialGradRenderEffect radialGradRenderEffect, int i, PointF pointF, RuntimeShader runtimeShader) {
        float[] fArr = radialGradRenderEffect.spotPositions;
        int i2 = i * 2;
        fArr[i2] = pointF.x;
        fArr[i2 + 1] = pointF.y;
        RuntimeShader shader = radialGradRenderEffect.getShader();
        if (shader != null) {
            shader.setFloatUniform("uSpotPositions", radialGradRenderEffect.spotPositions);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setSpotScale$lambda$12(RadialGradRenderEffect radialGradRenderEffect, int i, float f, RuntimeShader runtimeShader) {
        radialGradRenderEffect.spotScales[i] = f;
        RuntimeShader shader = radialGradRenderEffect.getShader();
        if (shader != null) {
            shader.setFloatUniform("uSpotScales", radialGradRenderEffect.spotScales);
        }
    }

    @Override // com.samsung.android.sesl.visualeffect.lighteffects.common.runtimshader.VibeRenderEffectBase, com.samsung.android.sesl.visualeffect.lighteffects.common.runtimshader.VibeRenderEffect
    public void destroy() {
        super.destroy();
        Log.i(TAG, "destroy");
        Companion.Default r02 = Companion.Default.INSTANCE;
        Bitmap bmpLightmap = r02.getBmpLightmap();
        if (bmpLightmap != null) {
            bmpLightmap.recycle();
        }
        r02.setBmpLightmap(null);
        setShader(null);
    }

    public final int getBlurRadius() {
        return this.blurRadius;
    }

    @Override // com.samsung.android.sesl.visualeffect.lighteffects.common.runtimshader.VibeRenderEffect
    @NotNull
    public RenderEffect getRenderEffect() {
        RuntimeShader shader = getShader();
        RenderEffect renderEffectCreateRuntimeShaderEffect = shader != null ? RenderEffect.createRuntimeShaderEffect(shader, "inputShader") : null;
        int i = this.blurRadius;
        if (i <= 0) {
            Intrinsics.checkNotNull(renderEffectCreateRuntimeShaderEffect);
            return renderEffectCreateRuntimeShaderEffect;
        }
        float f = i;
        Intrinsics.checkNotNull(renderEffectCreateRuntimeShaderEffect);
        Shader.TileMode tileMode = Shader.TileMode.MIRROR;
        RenderEffect renderEffectCreateBlurEffect = RenderEffect.createBlurEffect(f, f, renderEffectCreateRuntimeShaderEffect, Shader.TileMode.MIRROR);
        Intrinsics.checkNotNull(renderEffectCreateBlurEffect);
        return renderEffectCreateBlurEffect;
    }

    @Override // com.samsung.android.sesl.visualeffect.lighteffects.common.runtimshader.VibeRenderEffect
    @Nullable
    public RuntimeShader getShader() {
        return this.shader;
    }

    public final int getSpotColor(int index) {
        float[] fArr = this.spotColors;
        int i = index * 4;
        return Color.argb(fArr[i + 3], fArr[i], fArr[i + 1], fArr[i + 2]);
    }

    @NotNull
    public final PointF getSpotPosition(int index) {
        float[] fArr = this.spotPositions;
        int i = index * 2;
        return new PointF(fArr[i], fArr[i + 1]);
    }

    public final float getSpotScale(int index) {
        return this.spotScales[index];
    }

    @Override // com.samsung.android.sesl.visualeffect.lighteffects.common.runtimshader.VibeRenderEffectBase
    public void onInitialize(@NotNull Context appContext) {
        Bitmap bmpLightmap;
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Companion.Default r02 = Companion.Default.INSTANCE;
        if (r02.getBmpLightmap() == null) {
            r02.setBmpLightmap(BitmapFactory.decodeResource(appContext.getResources(), r02.getLightmapRes()));
        }
        if (this.hasLightMap || (bmpLightmap = r02.getBmpLightmap()) == null) {
            return;
        }
        setLightMap(bmpLightmap);
    }

    public final void setBackgroundColor(@ColorInt int color) {
        updateShader(new C7877e(color, this));
    }

    public final void setBlurRadius(int i) {
        this.blurRadius = i;
        invalidate();
    }

    public final void setLightMap(@NotNull Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        updateShader(new C7860l(this, bitmap, 3));
    }

    public void setShader(@Nullable RuntimeShader runtimeShader) {
        this.shader = runtimeShader;
    }

    public final void setSpotColor(int index, @ColorInt int color) {
        updateShader(new C7846a(this, color, index));
    }

    public final void setSpotCount(int count) {
        if (this.spotCount != count) {
            this.spotCount = count;
            updateShader(new C7877e(this, count));
        }
    }

    public final void setSpotEnabled(final int index, final boolean enabled) {
        updateShader(new Consumer() { // from class: com.samsung.android.sesl.visualeffect.lighteffects.radialgrad.f
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                RadialGradRenderEffect.setSpotEnabled$lambda$8(this.f5357a, index, enabled, (RuntimeShader) obj);
            }
        });
    }

    public final void setSpotPosition(final int index, @NotNull final PointF position) {
        Intrinsics.checkNotNullParameter(position, "position");
        updateShader(new Consumer() { // from class: com.samsung.android.sesl.visualeffect.lighteffects.radialgrad.g
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                RadialGradRenderEffect.setSpotPosition$lambda$11(this.f5360a, index, position, (RuntimeShader) obj);
            }
        });
    }

    public final void setSpotScale(final int index, final float scale) {
        updateShader(new Consumer() { // from class: com.samsung.android.sesl.visualeffect.lighteffects.radialgrad.h
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                RadialGradRenderEffect.setSpotScale$lambda$12(this.f5363a, index, scale, (RuntimeShader) obj);
            }
        });
    }
}
