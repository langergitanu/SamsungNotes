package com.samsung.android.sesl.widget.filters;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/sesl/widget/filters/Shaders;", "", "()V", "Companion", "graphic-solution_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class Shaders {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String n31Code = "float n31(vec3 p) {\n    vec3 i = floor(p);\n    vec3 f = fract(p);\n    f = f * f * (3.0 - 2.0 * f);\n    float n = i.x + i.y * 57.0 + 113.0 * i.z;\n    return mix(\n        mix(mix(fract(sin(n) * 43758.5453),\n               fract(sin(n + 1.0) * 43758.5453), f.x),\n           mix(fract(sin(n + 57.0) * 43758.5453),\n               fract(sin(n + 58.0) * 43758.5453), f.x), f.y),\n        mix(mix(fract(sin(n + 113.0) * 43758.5453),\n               fract(sin(n + 114.0) * 43758.5453), f.x),\n           mix(fract(sin(n + 170.0) * 43758.5453),\n               fract(sin(n + 171.0) * 43758.5453), f.x), f.y),\n        f.z);\n}";

    @NotNull
    private static final String warpingCode = "vec2 warp(vec2 p, float amount) {\n    float time_offset1 = 0.0;\n    float time_offset2 = 1.23;\n    float time_offset3 = 2.47;\n    float flow1 = n31(vec3(p * 1.2, uTime * 0.4 + time_offset1));\n    float flow2 = n31(vec3(p * 1.5 + vec2(50.0, 30.0), uTime * 0.35 + time_offset2));\n    float flow3 = n31(vec3(p * 2.0 + vec2(100.0, 60.0), uTime * 0.3 + time_offset3));\n    float angle = atan(p.y, p.x);\n    float radius = length(p);\n    float wave1 = sin(angle * 4.0 + uTime * 0.7 + flow1 * 1.57) * 0.1;\n    float wave2 = cos(angle * 6.0 - uTime * 0.5 + flow2 * 1.57) * 0.06;\n    float ripple1 = sin(radius * 6.0 - uTime * 1.2) * 0.04;\n    float ripple2 = cos(radius * 9.0 + uTime * 0.8) * 0.03;\n    vec2 offset = vec2(\n        (flow1 - 0.5) * 0.15 + wave1 + ripple1,\n        (flow2 - 0.5) * 0.15 + wave2 + ripple2\n    ) * amount;\n    offset += vec2(\n        (flow3 - 0.5) * 0.08,\n        (n31(vec3(p * 3.0 + 150.0, uTime * 0.45)) - 0.5) * 0.08\n    ) * amount;\n    return p + offset;\n}";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/sesl/widget/filters/Shaders$Companion;", "", "()V", "n31Code", "", "warpingCode", "getN31Code", "getWarpingCode", "graphic-solution_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String getN31Code() {
            return Shaders.n31Code;
        }

        @NotNull
        public final String getWarpingCode() {
            return Shaders.warpingCode;
        }

        private Companion() {
        }
    }
}
