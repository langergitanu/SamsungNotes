package com.samsung.android.support.senl.p148nt.app.main.common.view;

import android.graphics.RuntimeShader;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.main.common.view.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public abstract /* synthetic */ class AbstractC8238d {
    /* JADX INFO: renamed from: f */
    public static /* synthetic */ RuntimeShader m7570f() {
        return new RuntimeShader("uniform shader content;                      \nuniform vec2 uNoiseIntensity;                   \nuniform float uScale;                       \nuniform float uTime;                        \nuniform float uRandomSeed;                        \nuniform vec2 uViewToNormalize;              \nuniform vec2 uViewSize;                     \nuniform vec4 uFpuErrCorrection;             \nfloat rand(vec2 p, float seed) {    return fract(cos(dot(p, vec2(23.0224, 81.0618))) * (55000.1030 + seed  * 200.0));\n}\nvec4 main(vec2 fragCoord) {\n  vec2 normalizedFragCoord = fragCoord * uViewToNormalize;\n  vec2 noiseUv = vec2(rand(normalizedFragCoord + uTime, uRandomSeed), rand(normalizedFragCoord + uTime, uRandomSeed+1.0)) * 2.0 - 1.0;\n  vec2 disolvedUv = normalizedFragCoord + noiseUv.xy * uNoiseIntensity;\n  vec4 viewTexture = content.eval( clamp(disolvedUv, uFpuErrCorrection.xy, uFpuErrCorrection.zw) * uViewSize );\n  return vec4(viewTexture.rgb , 1.0);\n}");
    }
}
