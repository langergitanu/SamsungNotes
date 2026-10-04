package androidx.core.text.util;

import android.graphics.RuntimeShader;

/* JADX INFO: renamed from: androidx.core.text.util.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public abstract /* synthetic */ class AbstractC2402b {
    /* JADX INFO: renamed from: c */
    public static /* synthetic */ RuntimeShader m1738c() {
        return new RuntimeShader("uniform float2 resolution;uniform vec4 color;uniform float startAlpha;uniform vec4 easing;float cubicBezier(float t, float x1, float y1, float x2, float y2) {    if (t <= 0.0) return 0.0;    if (t >= 1.0) return 1.0;    float s = t;    float u2, s2, s3;    for (int i = 0; i < 6; i++) {        float u = 1.0 - s;        u2 = u * u;        s2 = s * s;        float x_current = 3.0 * u2 * s * x1 + 3.0 * u * s2 * x2 + s2 * s;        float dx_ds = 3.0 * u2 * x1 + 6.0 * u * s * (x2 - x1) + 3.0 * s2 * (1.0 - x2);        if (abs(dx_ds) < 0.0001) break;        s = s - (x_current - t) / dx_ds;        s = clamp(s, 0.0, 1.0);        if (abs(x_current - t) < 0.0001) break;    }    float u = 1.0 - s;    u2 = u * u;    s2 = s * s;    s3 = s2 * s;    return 3.0 * u2 * s * y1 + 3.0 * u * s2 * y2 + s3;}vec4 main(vec2 fragCoord) {    float t = clamp(fragCoord.y / resolution.y, 0.0, 1.0);    t = clamp(t * (1.0 - startAlpha) + startAlpha, 0.0, 1.0);    float eased;    eased = 1.0 - cubicBezier(t, easing.x, easing.y, easing.z, easing.w);    return vec4(color.rgb * eased, eased);}");
    }
}
