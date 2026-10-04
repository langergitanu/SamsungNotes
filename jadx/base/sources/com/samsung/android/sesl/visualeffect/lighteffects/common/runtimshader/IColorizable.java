package com.samsung.android.sesl.visualeffect.lighteffects.common.runtimshader;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.PointF;
import android.graphics.RuntimeShader;
import android.graphics.Shader;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.intellij.lang.annotations.Language;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@RequiresApi(33)
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u001c\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH&J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J$\u0010\r\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\nH\u0016J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\nH\u0016¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/lighteffects/common/runtimshader/IColorizable;", "", "setTintTexture", "", "bitmap", "Landroid/graphics/Bitmap;", "setTintShader", "tintShader", "Landroid/graphics/Shader;", "tintFragSize", "Landroid/graphics/PointF;", "currentShader", "Landroid/graphics/RuntimeShader;", "setTintShaderUniforms", "tintShaderSize", "setTintFlipDirection", "flip", "Companion", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public interface IColorizable {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @Language("AGSL")
    @NotNull
    public static final String DECLARE_TINT_SHADER = "\nuniform shader tintShader;\nuniform half2 uTintShaderSize;\n// TODO possible for any transforming with mat3 for trs, but currently just for flipping since there's no requirements at least now.\nuniform half2 uTintFlipDirection; \n\nhalf useTint() {\n    return step(0.01, abs(uTintShaderSize.x * uTintShaderSize.y)); \n}\n    \nhalf4 texTint(half2 uv) {\n    uv = mix(uv, half2(1 - uv.x, uv.y), step(0.5, uTintFlipDirection.x));\n    return tintShader.eval(uv * uTintShaderSize);\n}\n\n// get tint color aligned center\nhalf3 getTintColor(half2 uv, half2 resolution) {\n    half2 guv = uv;\n    half asp = resolution.x / resolution.y;\n    if (asp > 1) {\n        guv.y /= asp;\n        guv.y += 0.5 * (1 - 1 / asp);\n    } else {\n        guv.x *= asp;\n        guv.x += 0.5 * (1 - asp);\n    }\n    return clamp(texTint(guv).rgb, half3(0), half3(1));\n}\n\n// get tint color aligned center\nhalf4 getTintColorAlpha(half2 uv, half2 resolution) {\n    half2 guv = uv;\n    half asp = resolution.x / resolution.y;\n    if (asp > 1) {\n        guv.y /= asp;\n        guv.y += 0.5 * (1 - 1 / asp);\n    } else {\n        guv.x *= asp;\n        guv.x += 0.5 * (1 - asp);\n    }\n    half4 tint = texTint(guv);\n    return clamp(tint, half4(0), half4(1));\n}\n        ";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/lighteffects/common/runtimshader/IColorizable$Companion;", "", "<init>", "()V", "DECLARE_TINT_SHADER", "", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        @Language("AGSL")
        @NotNull
        public static final String DECLARE_TINT_SHADER = "\nuniform shader tintShader;\nuniform half2 uTintShaderSize;\n// TODO possible for any transforming with mat3 for trs, but currently just for flipping since there's no requirements at least now.\nuniform half2 uTintFlipDirection; \n\nhalf useTint() {\n    return step(0.01, abs(uTintShaderSize.x * uTintShaderSize.y)); \n}\n    \nhalf4 texTint(half2 uv) {\n    uv = mix(uv, half2(1 - uv.x, uv.y), step(0.5, uTintFlipDirection.x));\n    return tintShader.eval(uv * uTintShaderSize);\n}\n\n// get tint color aligned center\nhalf3 getTintColor(half2 uv, half2 resolution) {\n    half2 guv = uv;\n    half asp = resolution.x / resolution.y;\n    if (asp > 1) {\n        guv.y /= asp;\n        guv.y += 0.5 * (1 - 1 / asp);\n    } else {\n        guv.x *= asp;\n        guv.x += 0.5 * (1 - asp);\n    }\n    return clamp(texTint(guv).rgb, half3(0), half3(1));\n}\n\n// get tint color aligned center\nhalf4 getTintColorAlpha(half2 uv, half2 resolution) {\n    half2 guv = uv;\n    half asp = resolution.x / resolution.y;\n    if (asp > 1) {\n        guv.y /= asp;\n        guv.y += 0.5 * (1 - 1 / asp);\n    } else {\n        guv.x *= asp;\n        guv.x += 0.5 * (1 - asp);\n    }\n    half4 tint = texTint(guv);\n    return clamp(tint, half4(0), half4(1));\n}\n        ";

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class DefaultImpls {
        public static void setTintFlipDirection(@NotNull IColorizable iColorizable, @NotNull RuntimeShader currentShader, @NotNull PointF flip) {
            Intrinsics.checkNotNullParameter(currentShader, "currentShader");
            Intrinsics.checkNotNullParameter(flip, "flip");
            currentShader.setFloatUniform("uTintFlipDirection", flip.x, flip.y);
        }

        public static void setTintShaderUniforms(@NotNull IColorizable iColorizable, @NotNull RuntimeShader currentShader, @Nullable Shader shader, @Nullable PointF pointF) {
            Intrinsics.checkNotNullParameter(currentShader, "currentShader");
            if (shader == null) {
                currentShader.setFloatUniform("uTintShaderSize", 0.0f, 0.0f);
            } else {
                currentShader.setInputShader("tintShader", shader);
                currentShader.setFloatUniform("uTintShaderSize", pointF != null ? pointF.x : 0.0f, pointF != null ? pointF.y : 0.0f);
            }
        }

        public static void setTintTexture(@NotNull IColorizable iColorizable, @NotNull RuntimeShader currentShader, @Nullable Bitmap bitmap) {
            Intrinsics.checkNotNullParameter(currentShader, "currentShader");
            if (bitmap == null) {
                currentShader.setFloatUniform("uTintShaderSize", 0.0f, 0.0f);
            } else {
                currentShader.setInputShader("tintShader", new BitmapShader(bitmap, Shader.TileMode.DECAL, Shader.TileMode.DECAL));
                currentShader.setFloatUniform("uTintShaderSize", bitmap.getWidth(), bitmap.getHeight());
            }
        }
    }

    void setTintFlipDirection(@NotNull RuntimeShader currentShader, @NotNull PointF flip);

    void setTintShader(@Nullable Shader tintShader, @Nullable PointF tintFragSize);

    void setTintShaderUniforms(@NotNull RuntimeShader currentShader, @Nullable Shader tintShader, @Nullable PointF tintShaderSize);

    void setTintTexture(@Nullable Bitmap bitmap);

    void setTintTexture(@NotNull RuntimeShader currentShader, @Nullable Bitmap bitmap);
}
