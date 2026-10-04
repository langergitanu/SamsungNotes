package com.samsung.android.sesl.visualeffect.surfaceeffects.ripple;

import android.graphics.Color;
import android.graphics.RuntimeShader;
import android.util.Log;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.collection.AbstractC0622a;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.glance.AbstractC2821a;
import com.samsung.android.sesl.visualeffect.surfaceeffects.ripple.RippleShader;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.visual.p167ai.sdkcommon.image.ImageConst;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@RequiresApi(33)
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u001d\b\u0007\u0018\u0000 I2\u00020\u0001:\u0004IJKLB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007J\u0016\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007J\u0010\u0010\"\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0007H\u0002J \u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u0007H\u0002J\"\u0010'\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020)2\u0006\u0010\u001b\u001a\u00020\u00072\b\b\u0002\u0010*\u001a\u00020\u0007H\u0002R\u001e\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u001a\u0010\u0010\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u0013R\u0015\u0010\u0017\u001a\u00060\u0018R\u00020\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR$\u0010\u001b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\f\"\u0004\b\u001d\u0010\u0013R\u001e\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\t\u001a\u00020\u001e@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u001e\u0010+\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b,\u0010\u0013R$\u0010-\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\f\"\u0004\b/\u0010\u0013R$\u00101\u001a\u0002002\u0006\u0010\t\u001a\u000200@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R$\u00106\u001a\u0002002\u0006\u0010\t\u001a\u000200@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00103\"\u0004\b8\u00105R$\u00109\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\f\"\u0004\b;\u0010\u0013R$\u0010<\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\f\"\u0004\b>\u0010\u0013R$\u0010?\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\f\"\u0004\bA\u0010\u0013R\u0011\u0010B\u001a\u00020)¢\u0006\b\n\u0000\u001a\u0004\bC\u0010DR\u0011\u0010E\u001a\u00020)¢\u0006\b\n\u0000\u001a\u0004\bF\u0010DR\u0011\u0010G\u001a\u00020)¢\u0006\b\n\u0000\u001a\u0004\bH\u0010D¨\u0006M"}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/surfaceeffects/ripple/RippleShader;", "Landroid/graphics/RuntimeShader;", "<init>", "()V", "setCenter", "", "x", "", "y", "value", "moveOffsetX", "getMoveOffsetX", "()F", "moveOffsetY", "getMoveOffsetY", "setMove", "blurStart", "getBlurStart", "setBlurStart", "(F)V", "blurEnd", "getBlurEnd", "setBlurEnd", "rippleSize", "Lcom/samsung/android/sesl/visualeffect/surfaceeffects/ripple/RippleShader$RippleSize;", "getRippleSize", "()Lcom/samsung/android/sesl/visualeffect/surfaceeffects/ripple/RippleShader$RippleSize;", "rawProgress", "getRawProgress", "setRawProgress", "", "sparkleDisappearedState", "getSparkleDisappearedState", "()Z", "updateSparkleState", ImageConst.PARAM_MODE_WALLPAPER_MIX, "left", "right", "ratio", "updateSparkleDisappearedState", "fadeParams", "Lcom/samsung/android/sesl/visualeffect/surfaceeffects/ripple/RippleShader$FadeParams;", "threshold", "progress", "setProgress", "time", "getTime", "setTime", "", "color", "getColor", "()I", "setColor", "(I)V", "sparkleColor", "getSparkleColor", "setSparkleColor", "sparkleStrength", "getSparkleStrength", "setSparkleStrength", "distortionStrength", "getDistortionStrength", "setDistortionStrength", "pixelDensity", "getPixelDensity", "setPixelDensity", "sparkleRingFadeParams", "getSparkleRingFadeParams", "()Lcom/samsung/android/sesl/visualeffect/surfaceeffects/ripple/RippleShader$FadeParams;", "baseRingFadeParams", "getBaseRingFadeParams", "centerFillFadeParams", "getCenterFillFadeParams", "Companion", "FadeParams", "SizeAtProgress", "RippleSize", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class RippleShader extends RuntimeShader {

    @NotNull
    public static final String CIRCLE_SDF = "\n            float sdCircle(vec2 p, float r) {\n                return (length(p)-r) / r;\n            }\n\n            float circleRing(vec2 p, float radius) {\n                float thicknessHalf = radius * 0.25;\n\n                float outerCircle = sdCircle(p, radius + thicknessHalf);\n                float innerCircle = sdCircle(p, radius);\n\n                return subtract(outerCircle, innerCircle);\n            }\n        ";

    @NotNull
    private static final String CIRCLE_SPARKLE_SHADER = "\n            uniform vec2 in_center;\n            uniform vec2 in_size;\n            uniform vec2 in_rippleMove;\n            uniform float in_cornerRadius;\n            uniform float in_thickness;\n            uniform float in_time;\n            uniform float in_distort_radial;\n            uniform float in_distort_xy;\n            uniform float in_fadeSparkle;\n            uniform float in_fadeFill;\n            uniform float in_fadeRing;\n            uniform float in_blur;\n            uniform float in_pixelDensity;\n            layout(color) uniform vec4 in_color;\n            uniform float in_sparkle_strength;\n            \n          \n        \n        float triangleNoise(vec2 n) {\n            n  = fract(n * vec2(5.3987, 5.4421));\n            n += dot(n.yx, n.xy + vec2(21.5351, 14.3137));\n            float xy = n.x * n.y;\n            // compute in [0..2[ and remap to [-1.0..1.0[\n            return fract(xy * 95.4307) + fract(xy * 75.04961) - 1.0;\n        }\n\n        const float PI = 3.1415926535897932384626;\n\n        float sparkles(vec2 uv, float t) {\n            float n = triangleNoise(uv);\n            float s = 0.0;\n            for (float i = 0; i < 4; i += 1) {\n                float l = i * 0.01;\n                float h = l + 0.1;\n                float o = smoothstep(n - l, h, n);\n                o *= abs(sin(PI * o * (t + 0.55 * i)));\n                s += o;\n            }\n            return s;\n        }\n\n        vec2 distort(vec2 p, float time, float distort_amount_radial,\n            float distort_amount_xy) {\n                float angle = atan(p.y, p.x);\n                  return p + vec2(sin(angle * 8 + time * 0.003 + 1.641),\n                            cos(angle * 5 + 2.14 + time * 0.00412)) * distort_amount_radial\n                     + vec2(sin(p.x * 0.01 + time * 0.00215 + 0.8123),\n                            cos(p.y * 0.01 + time * 0.005931)) * distort_amount_xy;\n        }\n\n        // Perceived luminosity (L��), not absolute luminosity.\n        half getLuminosity(vec3 c) {\n            return 0.3 * c.r + 0.59 * c.g + 0.11 * c.b;\n        }\n\n        // Creates a luminosity mask and clamp to the legal range.\n        vec3 maskLuminosity(vec3 dest, float lum) {\n            dest.rgb *= vec3(lum);\n            // Clip back into the legal range\n            dest = clamp(dest, vec3(0.), vec3(1.0));\n            return dest;\n        }\n\n        // Return range [-1, 1].\n        vec3 hash(vec3 p) {\n            p = fract(p * vec3(.3456, .1234, .9876));\n            p += dot(p, p.yxz + 43.21);\n            p = (p.xxy + p.yxx) * p.zyx;\n            return (fract(sin(p) * 4567.1234567) - .5) * 2.;\n        }\n\n        // Skew factors (non-uniform).\n        const half SKEW = 0.3333333;  // 1/3\n        const half UNSKEW = 0.1666667;  // 1/6\n\n        // Return range roughly [-1,1].\n        // It's because the hash function (that returns a random gradient vector) returns\n        // different magnitude of vectors. Noise doesn't have to be in the precise range thus\n        // skipped normalize.\n        half simplex3d(vec3 p) {\n            // Skew the input coordinate, so that we get squashed cubical grid\n            vec3 s = floor(p + (p.x + p.y + p.z) * SKEW);\n\n            // Unskew back\n            vec3 u = s - (s.x + s.y + s.z) * UNSKEW;\n\n            // Unskewed coordinate that is relative to p, to compute the noise contribution\n            // based on the distance.\n            vec3 c0 = p - u;\n\n            // We have six simplices (in this case tetrahedron, since we are in 3D) that we\n            // could possibly in.\n            // Here, we are finding the correct tetrahedron (simplex shape), and traverse its\n            // four vertices (c0..3) when computing noise contribution.\n            // The way we find them is by comparing c0's x,y,z values.\n            // For example in 2D, we can find the triangle (simplex shape in 2D) that we are in\n            // by comparing x and y values. i.e. x>y lower, x<y, upper triangle.\n            // Same applies in 3D.\n            //\n            // Below indicates the offsets (or offset directions) when c0=(x0,y0,z0)\n            // x0>y0>z0: (1,0,0), (1,1,0), (1,1,1)\n            // x0>z0>y0: (1,0,0), (1,0,1), (1,1,1)\n            // z0>x0>y0: (0,0,1), (1,0,1), (1,1,1)\n            // z0>y0>x0: (0,0,1), (0,1,1), (1,1,1)\n            // y0>z0>x0: (0,1,0), (0,1,1), (1,1,1)\n            // y0>x0>z0: (0,1,0), (1,1,0), (1,1,1)\n            //\n            // The rule is:\n            // * For offset1, set 1 at the max component, otherwise 0.\n            // * For offset2, set 0 at the min component, otherwise 1.\n            // * For offset3, set 1 for all.\n            //\n            // Encode x0-y0, y0-z0, z0-x0 in a vec3\n            vec3 en = c0 - c0.yzx;\n            // Each represents whether x0>y0, y0>z0, z0>x0\n            en = step(vec3(0.), en);\n            // en.zxy encodes z0>x0, x0>y0, y0>x0\n            vec3 offset1 = en * (1. - en.zxy); // find max\n            vec3 offset2 = 1. - en.zxy * (1. - en); // 1-(find min)\n            vec3 offset3 = vec3(1.);\n\n            vec3 c1 = c0 - offset1 + UNSKEW;\n            vec3 c2 = c0 - offset2 + UNSKEW * 2.;\n            vec3 c3 = c0 - offset3 + UNSKEW * 3.;\n\n            // Kernel summation: dot(max(0, r^2-d^2))^4, noise contribution)\n            //\n            // First compute d^2, squared distance to the point.\n            vec4 w; // w = max(0, r^2 - d^2))\n            w.x = dot(c0, c0);\n            w.y = dot(c1, c1);\n            w.z = dot(c2, c2);\n            w.w = dot(c3, c3);\n\n            // Noise contribution should decay to zero before they cross the simplex boundary.\n            // Usually r^2 is 0.5 or 0.6;\n            // 0.5 ensures continuity but 0.6 increases the visual quality for the application\n            // where discontinuity isn't noticeable.\n            w = max(0.6 - w, 0.);\n\n            // Noise contribution from each point.\n            vec4 nc;\n            nc.x = dot(hash(s), c0);\n            nc.y = dot(hash(s + offset1), c1);\n            nc.z = dot(hash(s + offset2), c2);\n            nc.w = dot(hash(s + offset3), c3);\n\n            nc *= w*w*w*w;\n\n            // Add all the noise contributions.\n            // Should multiply by the possible max contribution to adjust the range in [-1,1].\n            return dot(vec4(32.), nc);\n        }\n\n        // Random rotations.\n        // The way you create fractal noise is layering simplex noise with some rotation.\n        // To make random cloud looking noise, the rotations should not align. (Otherwise it\n        // creates patterned noise).\n        // Below rotations only rotate in one axis.\n        const mat3 rot1 = mat3(1.0, 0. ,0., 0., 0.15, -0.98, 0., 0.98, 0.15);\n        const mat3 rot2 = mat3(-0.95, 0. ,-0.3, 0., 1., 0., 0.3, 0., -0.95);\n        const mat3 rot3 = mat3(1.0, 0. ,0., 0., -0.44, -0.89, 0., 0.89, -0.44);\n\n        // Octave = 4\n        // Divide each coefficient by 3 to produce more grainy noise.\n        half simplex3d_fractal(vec3 p) {\n            return 0.675 * simplex3d(p * rot1) + 0.225 * simplex3d(2.0 * p * rot2)\n                    + 0.075 * simplex3d(4.0 * p * rot3) + 0.025 * simplex3d(8.0 * p);\n        }\n\n        // Screen blend\n        vec3 screen(vec3 dest, vec3 src) {\n            return dest + src - dest * src;\n        }\n    \n            float soften(float d, float blur) {\n                float blurHalf = blur * 0.5;\n                return smoothstep(-blurHalf, blurHalf, d);\n            }\n\n            float subtract(float outer, float inner) {\n                return max(outer, -inner);\n            }\n        \n            float sdCircle(vec2 p, float r) {\n                return (length(p)-r) / r;\n            }\n\n            float circleRing(vec2 p, float radius) {\n                float thicknessHalf = radius * 0.25;\n\n                float outerCircle = sdCircle(p, radius + thicknessHalf);\n                float innerCircle = sdCircle(p, radius);\n\n                return subtract(outerCircle, innerCircle);\n            }\n        \n            uniform vec4 in_sparkleColor;\n                       \n            vec4 main(vec2 p) {\n                vec2 p_distorted = distort(p, in_time, in_distort_radial, in_distort_xy);\n                float radius = in_size.x * 0.5;\n                float sparkleRing = soften(circleRing(p_distorted-(in_rippleMove), radius), in_blur);\n                \n                // WORKAROUND: Optimization for \"sparkle-only\" rendering.\n                // return outside of valid area for better performance.\n                // this may cause unintended rendering only if the user put both sparkle and ripple effect.\n                if (in_sparkle_strength > 0.0 && sparkleRing > 0.95) {\n                    return vec4(0.0, 0.0, 0.0, 0.0); // keyword discard is not allowed in AGSL.\n                }\n                \n                float inside = soften(sdCircle(p_distorted-(in_rippleMove), radius * 1.25), in_blur);\n                float sparkle = sparkles(p - mod(p, in_pixelDensity * 0.8), in_time * 0.00175)\n                    * (1.-sparkleRing) * in_fadeSparkle;\n\n                float rippleInsideAlpha = (1.-inside) * in_fadeFill;\n                float rippleRingAlpha = (1.-sparkleRing) * in_fadeRing;\n                float rippleAlpha = max(rippleInsideAlpha, rippleRingAlpha) * in_color.a;\n                vec4 ripple = vec4(in_color.rgb, 1.0) * rippleAlpha;\n\n            if (in_sparkle_strength>0.0) {\n                vec3 wSparkleColor = mix(in_sparkleColor.rgb, vec3(1.0, 1.0, 1.0), 0.3);\n                return mix(ripple, vec4(wSparkleColor.rgb, sparkle * in_sparkle_strength), sparkle * in_sparkle_strength);\n            }\n            else{\n                return ripple;\n            }\n            \n//                return vec4(in_sparkleColor.rgb, sparkle * in_sparkle_strength);\n//return mix(ripple, vec4(sparkle), sparkle * in_sparkle_strength);\n       \n\n            }\n        ";
    public static final float DEFAULT_BASE_RING_FADE_IN_END = 0.1f;
    public static final float DEFAULT_BASE_RING_FADE_OUT_START = 0.3f;
    public static final float DEFAULT_CENTER_FILL_FADE_IN_END = 0.0f;
    public static final float DEFAULT_CENTER_FILL_FADE_OUT_END = 0.6f;
    public static final float DEFAULT_CENTER_FILL_FADE_OUT_START = 0.0f;
    public static final float DEFAULT_FADE_IN_START = 0.0f;
    public static final float DEFAULT_FADE_OUT_END = 1.0f;
    public static final float DEFAULT_SPARKLE_RING_FADE_IN_END = 0.1f;
    public static final float DEFAULT_SPARKLE_RING_FADE_OUT_START = 0.4f;
    public static final int RIPPLE_DEFAULT_ALPHA = 115;
    public static final int RIPPLE_DEFAULT_COLOR = -1;
    public static final int RIPPLE_DEFAULT_SPARKLE_COLOR = -1;
    public static final float RIPPLE_SPARKLE_STRENGTH = 0.3f;

    @NotNull
    private static final String SHADER_CIRCLE_SPARKLE_MAIN = "\n            uniform vec4 in_sparkleColor;\n                       \n            vec4 main(vec2 p) {\n                vec2 p_distorted = distort(p, in_time, in_distort_radial, in_distort_xy);\n                float radius = in_size.x * 0.5;\n                float sparkleRing = soften(circleRing(p_distorted-(in_rippleMove), radius), in_blur);\n                \n                // WORKAROUND: Optimization for \"sparkle-only\" rendering.\n                // return outside of valid area for better performance.\n                // this may cause unintended rendering only if the user put both sparkle and ripple effect.\n                if (in_sparkle_strength > 0.0 && sparkleRing > 0.95) {\n                    return vec4(0.0, 0.0, 0.0, 0.0); // keyword discard is not allowed in AGSL.\n                }\n                \n                float inside = soften(sdCircle(p_distorted-(in_rippleMove), radius * 1.25), in_blur);\n                float sparkle = sparkles(p - mod(p, in_pixelDensity * 0.8), in_time * 0.00175)\n                    * (1.-sparkleRing) * in_fadeSparkle;\n\n                float rippleInsideAlpha = (1.-inside) * in_fadeFill;\n                float rippleRingAlpha = (1.-sparkleRing) * in_fadeRing;\n                float rippleAlpha = max(rippleInsideAlpha, rippleRingAlpha) * in_color.a;\n                vec4 ripple = vec4(in_color.rgb, 1.0) * rippleAlpha;\n\n            if (in_sparkle_strength>0.0) {\n                vec3 wSparkleColor = mix(in_sparkleColor.rgb, vec3(1.0, 1.0, 1.0), 0.3);\n                return mix(ripple, vec4(wSparkleColor.rgb, sparkle * in_sparkle_strength), sparkle * in_sparkle_strength);\n            }\n            else{\n                return ripple;\n            }\n            \n//                return vec4(in_sparkleColor.rgb, sparkle * in_sparkle_strength);\n//return mix(ripple, vec4(sparkle), sparkle * in_sparkle_strength);\n       \n\n            }\n        ";

    @NotNull
    public static final String SHADER_LIB = "\n        float triangleNoise(vec2 n) {\n            n  = fract(n * vec2(5.3987, 5.4421));\n            n += dot(n.yx, n.xy + vec2(21.5351, 14.3137));\n            float xy = n.x * n.y;\n            // compute in [0..2[ and remap to [-1.0..1.0[\n            return fract(xy * 95.4307) + fract(xy * 75.04961) - 1.0;\n        }\n\n        const float PI = 3.1415926535897932384626;\n\n        float sparkles(vec2 uv, float t) {\n            float n = triangleNoise(uv);\n            float s = 0.0;\n            for (float i = 0; i < 4; i += 1) {\n                float l = i * 0.01;\n                float h = l + 0.1;\n                float o = smoothstep(n - l, h, n);\n                o *= abs(sin(PI * o * (t + 0.55 * i)));\n                s += o;\n            }\n            return s;\n        }\n\n        vec2 distort(vec2 p, float time, float distort_amount_radial,\n            float distort_amount_xy) {\n                float angle = atan(p.y, p.x);\n                  return p + vec2(sin(angle * 8 + time * 0.003 + 1.641),\n                            cos(angle * 5 + 2.14 + time * 0.00412)) * distort_amount_radial\n                     + vec2(sin(p.x * 0.01 + time * 0.00215 + 0.8123),\n                            cos(p.y * 0.01 + time * 0.005931)) * distort_amount_xy;\n        }\n\n        // Perceived luminosity (L��), not absolute luminosity.\n        half getLuminosity(vec3 c) {\n            return 0.3 * c.r + 0.59 * c.g + 0.11 * c.b;\n        }\n\n        // Creates a luminosity mask and clamp to the legal range.\n        vec3 maskLuminosity(vec3 dest, float lum) {\n            dest.rgb *= vec3(lum);\n            // Clip back into the legal range\n            dest = clamp(dest, vec3(0.), vec3(1.0));\n            return dest;\n        }\n\n        // Return range [-1, 1].\n        vec3 hash(vec3 p) {\n            p = fract(p * vec3(.3456, .1234, .9876));\n            p += dot(p, p.yxz + 43.21);\n            p = (p.xxy + p.yxx) * p.zyx;\n            return (fract(sin(p) * 4567.1234567) - .5) * 2.;\n        }\n\n        // Skew factors (non-uniform).\n        const half SKEW = 0.3333333;  // 1/3\n        const half UNSKEW = 0.1666667;  // 1/6\n\n        // Return range roughly [-1,1].\n        // It's because the hash function (that returns a random gradient vector) returns\n        // different magnitude of vectors. Noise doesn't have to be in the precise range thus\n        // skipped normalize.\n        half simplex3d(vec3 p) {\n            // Skew the input coordinate, so that we get squashed cubical grid\n            vec3 s = floor(p + (p.x + p.y + p.z) * SKEW);\n\n            // Unskew back\n            vec3 u = s - (s.x + s.y + s.z) * UNSKEW;\n\n            // Unskewed coordinate that is relative to p, to compute the noise contribution\n            // based on the distance.\n            vec3 c0 = p - u;\n\n            // We have six simplices (in this case tetrahedron, since we are in 3D) that we\n            // could possibly in.\n            // Here, we are finding the correct tetrahedron (simplex shape), and traverse its\n            // four vertices (c0..3) when computing noise contribution.\n            // The way we find them is by comparing c0's x,y,z values.\n            // For example in 2D, we can find the triangle (simplex shape in 2D) that we are in\n            // by comparing x and y values. i.e. x>y lower, x<y, upper triangle.\n            // Same applies in 3D.\n            //\n            // Below indicates the offsets (or offset directions) when c0=(x0,y0,z0)\n            // x0>y0>z0: (1,0,0), (1,1,0), (1,1,1)\n            // x0>z0>y0: (1,0,0), (1,0,1), (1,1,1)\n            // z0>x0>y0: (0,0,1), (1,0,1), (1,1,1)\n            // z0>y0>x0: (0,0,1), (0,1,1), (1,1,1)\n            // y0>z0>x0: (0,1,0), (0,1,1), (1,1,1)\n            // y0>x0>z0: (0,1,0), (1,1,0), (1,1,1)\n            //\n            // The rule is:\n            // * For offset1, set 1 at the max component, otherwise 0.\n            // * For offset2, set 0 at the min component, otherwise 1.\n            // * For offset3, set 1 for all.\n            //\n            // Encode x0-y0, y0-z0, z0-x0 in a vec3\n            vec3 en = c0 - c0.yzx;\n            // Each represents whether x0>y0, y0>z0, z0>x0\n            en = step(vec3(0.), en);\n            // en.zxy encodes z0>x0, x0>y0, y0>x0\n            vec3 offset1 = en * (1. - en.zxy); // find max\n            vec3 offset2 = 1. - en.zxy * (1. - en); // 1-(find min)\n            vec3 offset3 = vec3(1.);\n\n            vec3 c1 = c0 - offset1 + UNSKEW;\n            vec3 c2 = c0 - offset2 + UNSKEW * 2.;\n            vec3 c3 = c0 - offset3 + UNSKEW * 3.;\n\n            // Kernel summation: dot(max(0, r^2-d^2))^4, noise contribution)\n            //\n            // First compute d^2, squared distance to the point.\n            vec4 w; // w = max(0, r^2 - d^2))\n            w.x = dot(c0, c0);\n            w.y = dot(c1, c1);\n            w.z = dot(c2, c2);\n            w.w = dot(c3, c3);\n\n            // Noise contribution should decay to zero before they cross the simplex boundary.\n            // Usually r^2 is 0.5 or 0.6;\n            // 0.5 ensures continuity but 0.6 increases the visual quality for the application\n            // where discontinuity isn't noticeable.\n            w = max(0.6 - w, 0.);\n\n            // Noise contribution from each point.\n            vec4 nc;\n            nc.x = dot(hash(s), c0);\n            nc.y = dot(hash(s + offset1), c1);\n            nc.z = dot(hash(s + offset2), c2);\n            nc.w = dot(hash(s + offset3), c3);\n\n            nc *= w*w*w*w;\n\n            // Add all the noise contributions.\n            // Should multiply by the possible max contribution to adjust the range in [-1,1].\n            return dot(vec4(32.), nc);\n        }\n\n        // Random rotations.\n        // The way you create fractal noise is layering simplex noise with some rotation.\n        // To make random cloud looking noise, the rotations should not align. (Otherwise it\n        // creates patterned noise).\n        // Below rotations only rotate in one axis.\n        const mat3 rot1 = mat3(1.0, 0. ,0., 0., 0.15, -0.98, 0., 0.98, 0.15);\n        const mat3 rot2 = mat3(-0.95, 0. ,-0.3, 0., 1., 0., 0.3, 0., -0.95);\n        const mat3 rot3 = mat3(1.0, 0. ,0., 0., -0.44, -0.89, 0., 0.89, -0.44);\n\n        // Octave = 4\n        // Divide each coefficient by 3 to produce more grainy noise.\n        half simplex3d_fractal(vec3 p) {\n            return 0.675 * simplex3d(p * rot1) + 0.225 * simplex3d(2.0 * p * rot2)\n                    + 0.075 * simplex3d(4.0 * p * rot3) + 0.025 * simplex3d(8.0 * p);\n        }\n\n        // Screen blend\n        vec3 screen(vec3 dest, vec3 src) {\n            return dest + src - dest * src;\n        }\n    ";

    @NotNull
    public static final String SHADER_SDF_OPERATION_LIB = "\n            float soften(float d, float blur) {\n                float blurHalf = blur * 0.5;\n                return smoothstep(-blurHalf, blurHalf, d);\n            }\n\n            float subtract(float outer, float inner) {\n                return max(outer, -inner);\n            }\n        ";

    @NotNull
    private static final String SHADER_UNIFORMS = "\n            uniform vec2 in_center;\n            uniform vec2 in_size;\n            uniform vec2 in_rippleMove;\n            uniform float in_cornerRadius;\n            uniform float in_thickness;\n            uniform float in_time;\n            uniform float in_distort_radial;\n            uniform float in_distort_xy;\n            uniform float in_fadeSparkle;\n            uniform float in_fadeFill;\n            uniform float in_fadeRing;\n            uniform float in_blur;\n            uniform float in_pixelDensity;\n            layout(color) uniform vec4 in_color;\n            uniform float in_sparkle_strength;\n            \n          \n        ";

    @NotNull
    private final FadeParams baseRingFadeParams;
    private float blurEnd;
    private float blurStart;

    @NotNull
    private final FadeParams centerFillFadeParams;
    private int color;
    private float distortionStrength;
    private float moveOffsetX;
    private float moveOffsetY;
    private float pixelDensity;
    private float progress;
    private float rawProgress;

    @NotNull
    private final RippleSize rippleSize;
    private int sparkleColor;
    private boolean sparkleDisappearedState;

    @NotNull
    private final FadeParams sparkleRingFadeParams;
    private float sparkleStrength;
    private float time;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private static final String TAG = Reflection.getOrCreateKotlinClass(RippleShader.class).getSimpleName();

    @NotNull
    private static final Interpolator STANDARD = new PathInterpolator(0.2f, 0.0f, 0.0f, 1.0f);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001b\u001a\u00020\u0005H\u0002J \u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u0007H\u0002J\u0018\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0007H\u0002J \u0010$\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u0007H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/surfaceeffects/ripple/RippleShader$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "DEFAULT_FADE_IN_START", "", "DEFAULT_FADE_OUT_END", "DEFAULT_BASE_RING_FADE_IN_END", "DEFAULT_BASE_RING_FADE_OUT_START", "DEFAULT_SPARKLE_RING_FADE_IN_END", "DEFAULT_SPARKLE_RING_FADE_OUT_START", "DEFAULT_CENTER_FILL_FADE_IN_END", "DEFAULT_CENTER_FILL_FADE_OUT_START", "DEFAULT_CENTER_FILL_FADE_OUT_END", "RIPPLE_SPARKLE_STRENGTH", "RIPPLE_DEFAULT_COLOR", "", "RIPPLE_DEFAULT_SPARKLE_COLOR", "RIPPLE_DEFAULT_ALPHA", "SHADER_UNIFORMS", "SHADER_CIRCLE_SPARKLE_MAIN", "SHADER_LIB", "CIRCLE_SDF", "SHADER_SDF_OPERATION_LIB", "CIRCLE_SPARKLE_SHADER", "buildShader", "subProgress", "start", "end", "progress", "getFade", "fadeParams", "Lcom/samsung/android/sesl/visualeffect/surfaceeffects/ripple/RippleShader$FadeParams;", "rawProgress", "lerp", "stop", "amount", "STANDARD", "Landroid/view/animation/Interpolator;", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String buildShader() {
            return RippleShader.CIRCLE_SPARKLE_SHADER;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final float getFade(FadeParams fadeParams, float rawProgress) {
            return Math.min(subProgress(fadeParams.getFadeInStart(), fadeParams.getFadeInEnd(), rawProgress), 1.0f - subProgress(fadeParams.getFadeOutStart(), fadeParams.getFadeOutEnd(), rawProgress));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final float lerp(float start, float stop, float amount) {
            return AbstractC0000a.m29z(stop, start, amount, start);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final float subProgress(float start, float end, float progress) {
            if (start == end) {
                return progress > start ? 1.0f : 0.0f;
            }
            return (Math.min(Math.max(progress, Math.min(start, end)), Math.max(start, end)) - start) / (end - start);
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020\u0019J\u001f\u0010#\u001a\u00020 2\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060$\"\u00020\u0006¢\u0006\u0002\u0010%J\u000e\u0010&\u001a\u00020 2\u0006\u0010'\u001a\u00020\u0019J\u0010\u0010(\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020\u0019H\u0002R*\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000f\u0010\b\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\b\u001a\u0004\b\u0016\u0010\u0017R\u001e\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0019@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001e\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0019@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001c¨\u0006)"}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/surfaceeffects/ripple/RippleShader$RippleSize;", "", "<init>", "(Lcom/samsung/android/sesl/visualeffect/surfaceeffects/ripple/RippleShader;)V", "sizes", "", "Lcom/samsung/android/sesl/visualeffect/surfaceeffects/ripple/RippleShader$SizeAtProgress;", "getSizes$annotations", "()V", "getSizes", "()Ljava/util/List;", "setSizes", "(Ljava/util/List;)V", "currentSizeIndex", "", "getCurrentSizeIndex$annotations", "getCurrentSizeIndex", "()I", "setCurrentSizeIndex", "(I)V", "initialSize", "getInitialSize$annotations", "getInitialSize", "()Lcom/samsung/android/sesl/visualeffect/surfaceeffects/ripple/RippleShader$SizeAtProgress;", "value", "", "currentWidth", "getCurrentWidth", "()F", "currentHeight", "getCurrentHeight", "setMaxSize", "", "width", "height", "setSizeAtProgresses", "", "([Lcom/samsung/android/sesl/visualeffect/surfaceeffects/ripple/RippleShader$SizeAtProgress;)V", Constants.ARG_UPDATE, "progress", "updateTargetIndex", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nRippleShader.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RippleShader.kt\ncom/samsung/android/sesl/visualeffect/surfaceeffects/ripple/RippleShader$RippleSize\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,671:1\n1010#2,2:672\n*S KotlinDebug\n*F\n+ 1 RippleShader.kt\ncom/samsung/android/sesl/visualeffect/surfaceeffects/ripple/RippleShader$RippleSize\n*L\n624#1:672,2\n*E\n"})
    public final class RippleSize {
        private float currentHeight;
        private int currentSizeIndex;
        private float currentWidth;

        @NotNull
        private List<SizeAtProgress> sizes = new ArrayList();

        @NotNull
        private final SizeAtProgress initialSize = new SizeAtProgress(0.0f, 0.0f, 0.0f);

        public RippleSize() {
        }

        @VisibleForTesting
        public static /* synthetic */ void getCurrentSizeIndex$annotations() {
        }

        @VisibleForTesting
        public static /* synthetic */ void getInitialSize$annotations() {
        }

        @VisibleForTesting
        public static /* synthetic */ void getSizes$annotations() {
        }

        private final int updateTargetIndex(float progress) {
            if (this.sizes.isEmpty()) {
                if (progress > 0.0f) {
                    Log.e(RippleShader.TAG, "Did you forget to set the ripple size? Use [setMaxSize] or [setSizeAtProgresses] before playing the animation.");
                }
                setSizeAtProgresses(this.initialSize);
                return this.currentSizeIndex;
            }
            SizeAtProgress sizeAtProgress = this.sizes.get(this.currentSizeIndex);
            while (progress > sizeAtProgress.getT()) {
                int iMin = Math.min(this.currentSizeIndex + 1, this.sizes.size() - 1);
                this.currentSizeIndex = iMin;
                sizeAtProgress = this.sizes.get(iMin);
            }
            return this.currentSizeIndex;
        }

        public final float getCurrentHeight() {
            return this.currentHeight;
        }

        public final int getCurrentSizeIndex() {
            return this.currentSizeIndex;
        }

        public final float getCurrentWidth() {
            return this.currentWidth;
        }

        @NotNull
        public final SizeAtProgress getInitialSize() {
            return this.initialSize;
        }

        @NotNull
        public final List<SizeAtProgress> getSizes() {
            return this.sizes;
        }

        public final void setCurrentSizeIndex(int i) {
            this.currentSizeIndex = i;
        }

        public final void setMaxSize(float width, float height) {
            setSizeAtProgresses(this.initialSize, new SizeAtProgress(1.0f, width, height));
        }

        public final void setSizeAtProgresses(@NotNull SizeAtProgress... sizes) {
            Intrinsics.checkNotNullParameter(sizes, "sizes");
            this.sizes.clear();
            this.currentSizeIndex = 0;
            CollectionsKt__MutableCollectionsKt.addAll(this.sizes, sizes);
            List<SizeAtProgress> list = this.sizes;
            if (list.size() > 1) {
                CollectionsKt.sortWith(list, new Comparator() { // from class: com.samsung.android.sesl.visualeffect.surfaceeffects.ripple.RippleShader$RippleSize$setSizeAtProgresses$$inlined$sortBy$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(Float.valueOf(((RippleShader.SizeAtProgress) t).getT()), Float.valueOf(((RippleShader.SizeAtProgress) t2).getT()));
                    }
                });
            }
        }

        public final void setSizes(@NotNull List<SizeAtProgress> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.sizes = list;
        }

        public final void update(float progress) {
            int iUpdateTargetIndex = updateTargetIndex(progress);
            int iMax = Math.max(iUpdateTargetIndex - 1, 0);
            SizeAtProgress sizeAtProgress = this.sizes.get(iUpdateTargetIndex);
            SizeAtProgress sizeAtProgress2 = this.sizes.get(iMax);
            float fSubProgress = RippleShader.INSTANCE.subProgress(sizeAtProgress2.getT(), sizeAtProgress.getT(), progress);
            this.currentWidth = sizeAtProgress2.getWidth() + (sizeAtProgress.getWidth() * fSubProgress);
            this.currentHeight = sizeAtProgress2.getHeight() + (sizeAtProgress.getHeight() * fSubProgress);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000b¨\u0006\u001b"}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/surfaceeffects/ripple/RippleShader$SizeAtProgress;", "", "t", "", "width", "height", "<init>", "(FFF)V", "getT", "()F", "setT", "(F)V", "getWidth", "setWidth", "getHeight", "setHeight", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final /* data */ class SizeAtProgress {
        private float height;
        private float t;
        private float width;

        public SizeAtProgress(float f, float f4, float f5) {
            this.t = f;
            this.width = f4;
            this.height = f5;
        }

        public static /* synthetic */ SizeAtProgress copy$default(SizeAtProgress sizeAtProgress, float f, float f4, float f5, int i, Object obj) {
            if ((i & 1) != 0) {
                f = sizeAtProgress.t;
            }
            if ((i & 2) != 0) {
                f4 = sizeAtProgress.width;
            }
            if ((i & 4) != 0) {
                f5 = sizeAtProgress.height;
            }
            return sizeAtProgress.copy(f, f4, f5);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final float getT() {
            return this.t;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final float getWidth() {
            return this.width;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final float getHeight() {
            return this.height;
        }

        @NotNull
        public final SizeAtProgress copy(float t, float width, float height) {
            return new SizeAtProgress(t, width, height);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SizeAtProgress)) {
                return false;
            }
            SizeAtProgress sizeAtProgress = (SizeAtProgress) other;
            return Float.compare(this.t, sizeAtProgress.t) == 0 && Float.compare(this.width, sizeAtProgress.width) == 0 && Float.compare(this.height, sizeAtProgress.height) == 0;
        }

        public final float getHeight() {
            return this.height;
        }

        public final float getT() {
            return this.t;
        }

        public final float getWidth() {
            return this.width;
        }

        public int hashCode() {
            return Float.hashCode(this.height) + AbstractC0622a.m1156b(this.width, Float.hashCode(this.t) * 31, 31);
        }

        public final void setHeight(float f) {
            this.height = f;
        }

        public final void setT(float f) {
            this.t = f;
        }

        public final void setWidth(float f) {
            this.width = f;
        }

        @NotNull
        public String toString() {
            float f = this.t;
            float f4 = this.width;
            return AbstractC1038a.m1217r(AbstractC0622a.m1176v("SizeAtProgress(t=", f, ", width=", f4, ", height="), ")", this.height);
        }
    }

    public RippleShader() {
        super(INSTANCE.buildShader());
        this.blurStart = 1.25f;
        this.blurEnd = 0.5f;
        this.rippleSize = new RippleSize();
        this.color = 16777215;
        this.sparkleColor = 16777215;
        this.pixelDensity = 1.0f;
        this.sparkleRingFadeParams = new FadeParams(0.0f, 0.1f, 0.4f, 1.0f);
        this.baseRingFadeParams = new FadeParams(0.0f, 0.1f, 0.3f, 1.0f);
        this.centerFillFadeParams = new FadeParams(0.0f, 0.0f, 0.0f, 0.6f);
    }

    private final float mix(float left, float right, float ratio) {
        return (right * ratio) + ((1.0f - ratio) * left);
    }

    private final void setProgress(float f) {
        this.progress = f;
        this.rippleSize.update(f);
        setFloatUniform("in_size", this.rippleSize.getCurrentWidth(), this.rippleSize.getCurrentHeight());
        setFloatUniform("in_thickness", this.rippleSize.getCurrentHeight() * 0.5f);
        setFloatUniform("in_cornerRadius", Math.min(this.rippleSize.getCurrentWidth(), this.rippleSize.getCurrentHeight()));
        setFloatUniform("in_blur", INSTANCE.lerp(1.25f, 0.5f, f));
    }

    private final boolean updateSparkleDisappearedState(FadeParams fadeParams, float rawProgress, float threshold) {
        Companion companion = INSTANCE;
        float fSubProgress = companion.subProgress(fadeParams.getFadeInStart(), fadeParams.getFadeInEnd(), rawProgress);
        float fSubProgress2 = 1.0f - companion.subProgress(fadeParams.getFadeOutStart(), fadeParams.getFadeOutEnd(), rawProgress);
        float fade = companion.getFade(fadeParams, rawProgress);
        if (fSubProgress2 >= fSubProgress) {
            return false;
        }
        float f = this.sparkleStrength;
        return mix(0.0f, fade * f, fade * f) < threshold;
    }

    public static /* synthetic */ boolean updateSparkleDisappearedState$default(RippleShader rippleShader, FadeParams fadeParams, float f, float f4, int i, Object obj) {
        if ((i & 4) != 0) {
            f4 = 0.005f;
        }
        return rippleShader.updateSparkleDisappearedState(fadeParams, f, f4);
    }

    private final void updateSparkleState(float rawProgress) {
        if (updateSparkleDisappearedState$default(this, this.sparkleRingFadeParams, rawProgress, 0.0f, 4, null)) {
            this.sparkleDisappearedState = true;
        }
    }

    @NotNull
    public final FadeParams getBaseRingFadeParams() {
        return this.baseRingFadeParams;
    }

    public final float getBlurEnd() {
        return this.blurEnd;
    }

    public final float getBlurStart() {
        return this.blurStart;
    }

    @NotNull
    public final FadeParams getCenterFillFadeParams() {
        return this.centerFillFadeParams;
    }

    public final int getColor() {
        return this.color;
    }

    public final float getDistortionStrength() {
        return this.distortionStrength;
    }

    public final float getMoveOffsetX() {
        return this.moveOffsetX;
    }

    public final float getMoveOffsetY() {
        return this.moveOffsetY;
    }

    public final float getPixelDensity() {
        return this.pixelDensity;
    }

    public final float getRawProgress() {
        return this.rawProgress;
    }

    @NotNull
    public final RippleSize getRippleSize() {
        return this.rippleSize;
    }

    public final int getSparkleColor() {
        return this.sparkleColor;
    }

    public final boolean getSparkleDisappearedState() {
        return this.sparkleDisappearedState;
    }

    @NotNull
    public final FadeParams getSparkleRingFadeParams() {
        return this.sparkleRingFadeParams;
    }

    public final float getSparkleStrength() {
        return this.sparkleStrength;
    }

    public final float getTime() {
        return this.time;
    }

    public final void setBlurEnd(float f) {
        this.blurEnd = f;
    }

    public final void setBlurStart(float f) {
        this.blurStart = f;
    }

    public final void setCenter(float x, float y2) {
        setFloatUniform("in_center", x, y2);
    }

    public final void setColor(int i) {
        this.color = i;
        Log.i("sparkleColor", "!!!!color:" + i);
        setColorUniform("in_color", i);
    }

    public final void setDistortionStrength(float f) {
        this.distortionStrength = f;
        float f4 = 75;
        setFloatUniform("in_distort_radial", this.rawProgress * f4 * f);
        setFloatUniform("in_distort_xy", f4 * f);
    }

    public final void setMove(float x, float y2) {
        this.moveOffsetX = x;
        this.moveOffsetY = y2;
        setFloatUniform("in_rippleMove", x, y2);
    }

    public final void setPixelDensity(float f) {
        this.pixelDensity = f;
        setFloatUniform("in_pixelDensity", f);
    }

    public final void setRawProgress(float f) {
        this.rawProgress = f;
        setProgress(f);
        Companion companion = INSTANCE;
        setFloatUniform("in_fadeSparkle", companion.getFade(this.sparkleRingFadeParams, f));
        setFloatUniform("in_fadeRing", companion.getFade(this.baseRingFadeParams, f));
        setFloatUniform("in_fadeFill", companion.getFade(this.centerFillFadeParams, f));
        updateSparkleState(f);
    }

    public final void setSparkleColor(int i) {
        this.sparkleColor = i;
        float fRed = Color.red(i) / 255.0f;
        float fGreen = Color.green(i) / 255.0f;
        float fBlue = Color.blue(i) / 255.0f;
        AbstractC2821a.m2234y(AbstractC0622a.m1176v("!!!!sparkleColor:", fRed, ",", fGreen, ","), fBlue, ",1.0", "sparkleColor");
        setFloatUniform("in_sparkleColor", fRed, fGreen, fBlue, 1.0f);
    }

    public final void setSparkleStrength(float f) {
        this.sparkleStrength = f;
        setFloatUniform("in_sparkle_strength", f);
    }

    public final void setTime(float f) {
        this.time = f;
        setFloatUniform("in_time", f);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J1\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\f¨\u0006\u001f"}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/surfaceeffects/ripple/RippleShader$FadeParams;", "", "fadeInStart", "", "fadeInEnd", "fadeOutStart", "fadeOutEnd", "<init>", "(FFFF)V", "getFadeInStart", "()F", "setFadeInStart", "(F)V", "getFadeInEnd", "setFadeInEnd", "getFadeOutStart", "setFadeOutStart", "getFadeOutEnd", "setFadeOutEnd", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final /* data */ class FadeParams {
        private float fadeInEnd;
        private float fadeInStart;
        private float fadeOutEnd;
        private float fadeOutStart;

        public FadeParams(float f, float f4, float f5, float f6) {
            this.fadeInStart = f;
            this.fadeInEnd = f4;
            this.fadeOutStart = f5;
            this.fadeOutEnd = f6;
        }

        public static /* synthetic */ FadeParams copy$default(FadeParams fadeParams, float f, float f4, float f5, float f6, int i, Object obj) {
            if ((i & 1) != 0) {
                f = fadeParams.fadeInStart;
            }
            if ((i & 2) != 0) {
                f4 = fadeParams.fadeInEnd;
            }
            if ((i & 4) != 0) {
                f5 = fadeParams.fadeOutStart;
            }
            if ((i & 8) != 0) {
                f6 = fadeParams.fadeOutEnd;
            }
            return fadeParams.copy(f, f4, f5, f6);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final float getFadeInStart() {
            return this.fadeInStart;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final float getFadeInEnd() {
            return this.fadeInEnd;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final float getFadeOutStart() {
            return this.fadeOutStart;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final float getFadeOutEnd() {
            return this.fadeOutEnd;
        }

        @NotNull
        public final FadeParams copy(float fadeInStart, float fadeInEnd, float fadeOutStart, float fadeOutEnd) {
            return new FadeParams(fadeInStart, fadeInEnd, fadeOutStart, fadeOutEnd);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FadeParams)) {
                return false;
            }
            FadeParams fadeParams = (FadeParams) other;
            return Float.compare(this.fadeInStart, fadeParams.fadeInStart) == 0 && Float.compare(this.fadeInEnd, fadeParams.fadeInEnd) == 0 && Float.compare(this.fadeOutStart, fadeParams.fadeOutStart) == 0 && Float.compare(this.fadeOutEnd, fadeParams.fadeOutEnd) == 0;
        }

        public final float getFadeInEnd() {
            return this.fadeInEnd;
        }

        public final float getFadeInStart() {
            return this.fadeInStart;
        }

        public final float getFadeOutEnd() {
            return this.fadeOutEnd;
        }

        public final float getFadeOutStart() {
            return this.fadeOutStart;
        }

        public int hashCode() {
            return Float.hashCode(this.fadeOutEnd) + AbstractC0622a.m1156b(this.fadeOutStart, AbstractC0622a.m1156b(this.fadeInEnd, Float.hashCode(this.fadeInStart) * 31, 31), 31);
        }

        public final void setFadeInEnd(float f) {
            this.fadeInEnd = f;
        }

        public final void setFadeInStart(float f) {
            this.fadeInStart = f;
        }

        public final void setFadeOutEnd(float f) {
            this.fadeOutEnd = f;
        }

        public final void setFadeOutStart(float f) {
            this.fadeOutStart = f;
        }

        @NotNull
        public String toString() {
            float f = this.fadeInStart;
            float f4 = this.fadeInEnd;
            return AbstractC1038a.m1216q(AbstractC0622a.m1176v("FadeParams(fadeInStart=", f, ", fadeInEnd=", f4, ", fadeOutStart="), this.fadeOutStart, ", fadeOutEnd=", this.fadeOutEnd, ")");
        }

        public /* synthetic */ FadeParams(float f, float f4, float f5, float f6, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? 0.0f : f, f4, f5, (i & 8) != 0 ? 1.0f : f6);
        }
    }
}
