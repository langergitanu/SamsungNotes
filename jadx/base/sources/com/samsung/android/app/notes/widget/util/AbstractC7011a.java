package com.samsung.android.app.notes.widget.util;

import android.app.LocaleManager;
import android.content.pm.Capability;
import android.content.pm.CapabilityParams;
import android.graphics.RuntimeShader;

/* JADX INFO: renamed from: com.samsung.android.app.notes.widget.util.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract /* synthetic */ class AbstractC7011a {
    /* JADX INFO: renamed from: a */
    public static /* bridge */ /* synthetic */ LocaleManager m5271a(Object obj) {
        return (LocaleManager) obj;
    }

    /* JADX INFO: renamed from: b */
    public static /* bridge */ /* synthetic */ Capability m5272b(Object obj) {
        return (Capability) obj;
    }

    /* JADX INFO: renamed from: c */
    public static /* bridge */ /* synthetic */ CapabilityParams m5273c(Object obj) {
        return (CapabilityParams) obj;
    }

    /* JADX INFO: renamed from: d */
    public static /* synthetic */ RuntimeShader m5274d() {
        return new RuntimeShader("uniform shader originalShader;\nuniform int iDitheringLevel;\nuniform int direction;\n\nfloat hash(vec2 p) {\n    vec3 p3 = fract(vec3(p.xyx) * 0.1031);\n    p3 += dot(p3, p3.yzx + 33.33);\n    return fract((p3.x + p3.y) * p3.z);\n}\n\nfloat noise(vec2 p) {\n    vec2 i = floor(p);\n    vec2 f = fract(p);\n    f = f * f * (3.0 - 2.0 * f);\n    float a = hash(i);\n    float b = hash(i + vec2(1.0, 0.0));\n    float c = hash(i + vec2(0.0, 1.0));\n    float d = hash(i + vec2(1.0, 1.0));\n    return mix(mix(a, b, f.x), mix(c, d, f.x), f.y);\n}\n\nfloat fbm(vec2 p) {\n    float value = 0.0;\n    float amplitude = 0.5;\n    for (int i = 0; i < 3; i++) {\n        value += amplitude * noise(p);\n        p *= 2.0;\n        amplitude *= 0.5;\n    }\n    return value;\n}\n\nfloat triangularNoise(vec2 p) {\n    float n1 = hash(p);\n    float n2 = hash(p + vec2(0.754877669, 0.569840296));\n    return (n1 + n2 - 1.0) * 0.5;\n}\n\nhalf4 main(vec2 fragCoord) {\n    half4 finalColor = originalShader.eval(fragCoord);\n    if (iDitheringLevel == 0) {\n        return finalColor;\n    }\n    float ditherStrength;\n    vec2 noiseCoord = fragCoord * 0.5;\n    float noiseValue;\n    if (iDitheringLevel == 1) {\n        ditherStrength = 0.003;\n        noiseValue = triangularNoise(noiseCoord);\n    } else if (iDitheringLevel == 2) {\n        ditherStrength = 0.006;\n        noiseValue = fbm(noiseCoord * 0.5);\n    } else {\n        ditherStrength = 0.010;\n        noiseValue = fbm(noiseCoord * 0.3);\n    }\n    noiseValue = (noiseValue - 0.5) * ditherStrength;\n    float3 ditheredColor = finalColor.rgb + vec3(noiseValue);\n    ditheredColor = clamp(ditheredColor, 0.0, 1.0);\n    return float4(ditheredColor, finalColor.a);\n}\n");
    }

    /* JADX INFO: renamed from: e */
    public static /* synthetic */ RuntimeShader m5275e(String str) {
        return new RuntimeShader(str);
    }

    /* JADX INFO: renamed from: i */
    public static /* bridge */ /* synthetic */ Class m5279i() {
        return LocaleManager.class;
    }

    /* JADX INFO: renamed from: q */
    public static /* synthetic */ void m5287q() {
    }
}
