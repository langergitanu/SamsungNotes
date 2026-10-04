package com.samsung.android.sesl.visualeffect.surfaceeffects.roundedrectreveal;

import android.graphics.RuntimeShader;
import androidx.annotation.RequiresApi;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@RequiresApi(33)
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0016\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007J\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/surfaceeffects/roundedrectreveal/RoundedRectRevealShader;", "Landroid/graphics/RuntimeShader;", "<init>", "()V", "setBlur", "", "value", "", "setCenter", "x", "y", "setRadius", "setCornerRadius", "setScreenRadio", "Companion", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class RoundedRectRevealShader extends RuntimeShader {

    @NotNull
    private static final String CIRCLE_SPARKLE_SHADER = "\n            uniform shader in_src;\n            uniform half in_radius;\n            uniform half in_cornerRadius;\n            uniform half in_screenRadio;\n            uniform vec2 in_maskCenter;\n            uniform half in_blur;\n        \n            float soften(float d, float blur) {\n                float blurHalf = blur * 0.5;\n                return smoothstep(-blurHalf, blurHalf, d);\n            }\n\n            float subtract(float outer, float inner) {\n                return max(outer, -inner);\n            }\n        \n            float sdCircle(vec2 p, float r) {\n                return (length(p)-r) / r;\n            }\n            \n            float sdRoundBox(vec2 p, float boxSize, float cornerRadius) {\n                float radius = min(boxSize, cornerRadius);\n                vec2 q = abs(p) - vec2(boxSize * in_screenRadio, boxSize) + radius;\n                return min(max(q.x, q.y), 0.0) + length(max(q, 0.0)) - radius;\n            }\n\n            float circleRing(vec2 p, float radius) {\n                float thicknessHalf = radius * 0.25;\n\n                float outerCircle = sdRoundBox(p, radius + thicknessHalf, in_cornerRadius);\n                float innerCircle = sdRoundBox(p, radius, in_cornerRadius);\n\n                return subtract(outerCircle, innerCircle);\n            }\n            vec4 main(vec2 p) {\n                half4 src = in_src.eval(p);\n                half mask = soften(sdRoundBox(p - in_maskCenter, in_radius, in_cornerRadius), in_blur);\n    \n                return src * mask;\n            }\n            ";

    @NotNull
    private static final String MAIN_SHADER = "\n            vec4 main(vec2 p) {\n                half4 src = in_src.eval(p);\n                half mask = soften(sdCircle(p - in_maskCenter, in_radius), in_blur);\n    \n                return src * mask;\n            }\n            ";

    @NotNull
    private static final String REVEAL_SHADER = "\n            uniform shader in_src;\n            uniform half in_radius;\n            uniform half in_cornerRadius;\n            uniform half in_screenRadio;\n            uniform vec2 in_maskCenter;\n            uniform half in_blur;\n        \n            float soften(float d, float blur) {\n                float blurHalf = blur * 0.5;\n                return smoothstep(-blurHalf, blurHalf, d);\n            }\n\n            float subtract(float outer, float inner) {\n                return max(outer, -inner);\n            }\n        \n            float sdCircle(vec2 p, float r) {\n                return (length(p)-r) / r;\n            }\n            \n            float sdRoundBox(vec2 p, float boxSize, float cornerRadius) {\n                float radius = min(boxSize, cornerRadius);\n                vec2 q = abs(p) - vec2(boxSize * in_screenRadio, boxSize) + radius;\n                return min(max(q.x, q.y), 0.0) + length(max(q, 0.0)) - radius;\n            }\n\n            float circleRing(vec2 p, float radius) {\n                float thicknessHalf = radius * 0.25;\n\n                float outerCircle = sdRoundBox(p, radius + thicknessHalf, in_cornerRadius);\n                float innerCircle = sdRoundBox(p, radius, in_cornerRadius);\n\n                return subtract(outerCircle, innerCircle);\n            }\n            vec4 main(vec2 p) {\n                half4 src = in_src.eval(p);\n                half mask = soften(sdRoundBox(p - in_maskCenter, in_radius, in_cornerRadius), in_blur);\n    \n                return src * mask;\n            }\n            ";

    @NotNull
    private static final String UNIFORMS = "\n            uniform shader in_src;\n            uniform half in_radius;\n            uniform vec2 in_maskCenter;\n            uniform half in_blur;\n            ";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private static final String TAG = Reflection.getOrCreateKotlinClass(RoundedRectRevealShader.class).getSimpleName();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u0005H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/surfaceeffects/roundedrectreveal/RoundedRectRevealShader$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "MAIN_SHADER", "REVEAL_SHADER", "UNIFORMS", "CIRCLE_SPARKLE_SHADER", "buildShader", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String buildShader() {
            return "\n            uniform shader in_src;\n            uniform half in_radius;\n            uniform half in_cornerRadius;\n            uniform half in_screenRadio;\n            uniform vec2 in_maskCenter;\n            uniform half in_blur;\n        \n            float soften(float d, float blur) {\n                float blurHalf = blur * 0.5;\n                return smoothstep(-blurHalf, blurHalf, d);\n            }\n\n            float subtract(float outer, float inner) {\n                return max(outer, -inner);\n            }\n        \n            float sdCircle(vec2 p, float r) {\n                return (length(p)-r) / r;\n            }\n            \n            float sdRoundBox(vec2 p, float boxSize, float cornerRadius) {\n                float radius = min(boxSize, cornerRadius);\n                vec2 q = abs(p) - vec2(boxSize * in_screenRadio, boxSize) + radius;\n                return min(max(q.x, q.y), 0.0) + length(max(q, 0.0)) - radius;\n            }\n\n            float circleRing(vec2 p, float radius) {\n                float thicknessHalf = radius * 0.25;\n\n                float outerCircle = sdRoundBox(p, radius + thicknessHalf, in_cornerRadius);\n                float innerCircle = sdRoundBox(p, radius, in_cornerRadius);\n\n                return subtract(outerCircle, innerCircle);\n            }\n            vec4 main(vec2 p) {\n                half4 src = in_src.eval(p);\n                half mask = soften(sdRoundBox(p - in_maskCenter, in_radius, in_cornerRadius), in_blur);\n    \n                return src * mask;\n            }\n            ";
        }

        private Companion() {
        }
    }

    public RoundedRectRevealShader() {
        super(INSTANCE.buildShader());
    }

    public final void setBlur(float value) {
        setFloatUniform("in_blur", value);
    }

    public final void setCenter(float x, float y2) {
        setFloatUniform("in_maskCenter", x, y2);
    }

    public final void setCornerRadius(float value) {
        setFloatUniform("in_cornerRadius", value);
    }

    public final void setRadius(float value) {
        setFloatUniform("in_radius", value);
    }

    public final void setScreenRadio(float value) {
        setFloatUniform("in_screenRadio", value);
    }
}
