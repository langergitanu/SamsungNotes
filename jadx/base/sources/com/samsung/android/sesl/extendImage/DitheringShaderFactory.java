package com.samsung.android.sesl.extendImage;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RuntimeShader;
import android.graphics.Shader;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import com.samsung.android.app.notes.widget.util.AbstractC7011a;
import org.intellij.lang.annotations.Language;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
class DitheringShaderFactory {

    @Language("AGSL")
    private static final String DITHERING_SHADER_CODE = "uniform shader originalShader;\nuniform int iDitheringLevel;\nuniform int direction;\n\nfloat hash(vec2 p) {\n    vec3 p3 = fract(vec3(p.xyx) * 0.1031);\n    p3 += dot(p3, p3.yzx + 33.33);\n    return fract((p3.x + p3.y) * p3.z);\n}\n\nfloat noise(vec2 p) {\n    vec2 i = floor(p);\n    vec2 f = fract(p);\n    f = f * f * (3.0 - 2.0 * f);\n    float a = hash(i);\n    float b = hash(i + vec2(1.0, 0.0));\n    float c = hash(i + vec2(0.0, 1.0));\n    float d = hash(i + vec2(1.0, 1.0));\n    return mix(mix(a, b, f.x), mix(c, d, f.x), f.y);\n}\n\nfloat fbm(vec2 p) {\n    float value = 0.0;\n    float amplitude = 0.5;\n    for (int i = 0; i < 3; i++) {\n        value += amplitude * noise(p);\n        p *= 2.0;\n        amplitude *= 0.5;\n    }\n    return value;\n}\n\nfloat triangularNoise(vec2 p) {\n    float n1 = hash(p);\n    float n2 = hash(p + vec2(0.754877669, 0.569840296));\n    return (n1 + n2 - 1.0) * 0.5;\n}\n\nhalf4 main(vec2 fragCoord) {\n    half4 finalColor = originalShader.eval(fragCoord);\n    if (iDitheringLevel == 0) {\n        return finalColor;\n    }\n    float ditherStrength;\n    vec2 noiseCoord = fragCoord * 0.5;\n    float noiseValue;\n    if (iDitheringLevel == 1) {\n        ditherStrength = 0.003;\n        noiseValue = triangularNoise(noiseCoord);\n    } else if (iDitheringLevel == 2) {\n        ditherStrength = 0.006;\n        noiseValue = fbm(noiseCoord * 0.5);\n    } else {\n        ditherStrength = 0.010;\n        noiseValue = fbm(noiseCoord * 0.3);\n    }\n    noiseValue = (noiseValue - 0.5) * ditherStrength;\n    float3 ditheredColor = finalColor.rgb + vec3(noiseValue);\n    ditheredColor = clamp(ditheredColor, 0.0, 1.0);\n    return float4(ditheredColor, finalColor.a);\n}\n";
    private static volatile boolean sInitializationFailed;
    private volatile RuntimeShader mDitherShader = null;

    public void applyDithering(@NonNull Canvas canvas, @NonNull Paint paint, @NonNull Shader shader, int i, int i2) {
        if (!canvas.isHardwareAccelerated() || sInitializationFailed || Build.VERSION.SDK_INT < 33) {
            paint.setShader(shader);
            paint.setDither(true);
            return;
        }
        if (this.mDitherShader == null && !sInitializationFailed) {
            try {
                AbstractC7011a.m5287q();
                this.mDitherShader = AbstractC7011a.m5274d();
            } catch (Throwable th) {
                Log.e("DitheringShaderFactory", "Lazy init of RuntimeShader failed.", th);
                sInitializationFailed = true;
            }
        }
        if (this.mDitherShader == null) {
            paint.setShader(shader);
            paint.setDither(true);
            return;
        }
        try {
            this.mDitherShader.setInputShader("originalShader", shader);
            this.mDitherShader.setIntUniform("iDitheringLevel", Math.max(0, Math.min(3, i2)));
            this.mDitherShader.setIntUniform("direction", i);
            paint.setShader(this.mDitherShader);
            paint.setColorFilter(null);
        } catch (Throwable th2) {
            Log.e("DitheringShaderFactory", "Failed to apply RuntimeShader.", th2);
            paint.setShader(shader);
            paint.setDither(true);
        }
    }
}
