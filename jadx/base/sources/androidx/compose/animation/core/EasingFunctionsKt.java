package androidx.compose.animation.core;

import androidx.collection.AbstractC0622a;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\bE\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0011\u0010\u0004\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0003\"\u0011\u0010\u0006\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0003\"\u0011\u0010\b\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0003\"\u0011\u0010\n\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0003\"\u0011\u0010\f\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0003\"\u0011\u0010\u000e\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0003\"\u0011\u0010\u0010\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0003\"\u0011\u0010\u0012\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0003\"\u0011\u0010\u0014\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0003\"\u0011\u0010\u0016\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0003\"\u0011\u0010\u0018\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0003\"\u0011\u0010\u001a\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0003\"\u0011\u0010\u001c\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0003\"\u0011\u0010\u001e\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0003\"\u0011\u0010 \u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0003\"\u0011\u0010\"\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0003\"\u0011\u0010$\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0003\"\u0011\u0010&\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0003\"\u0011\u0010(\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0003\"\u0011\u0010*\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0003\"\u0011\u0010,\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u0003\"\u0011\u0010.\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u0003\"\u0011\u00100\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u0003\"\u0011\u00102\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u0003\"\u0011\u00104\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\u0003\"\u0011\u00106\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b7\u0010\u0003\"\u0011\u00108\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b9\u0010\u0003\"\u0011\u0010:\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b;\u0010\u0003\"\u0011\u0010<\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b=\u0010\u0003\"\u0011\u0010>\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b?\u0010\u0003\"\u0011\u0010@\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\bA\u0010\u0003\"\u0011\u0010B\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\bC\u0010\u0003\"\u0011\u0010D\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\bE\u0010\u0003¨\u0006F"}, m13886d2 = {"Ease", "Landroidx/compose/animation/core/Easing;", "getEase", "()Landroidx/compose/animation/core/Easing;", "EaseIn", "getEaseIn", "EaseInBack", "getEaseInBack", "EaseInBounce", "getEaseInBounce", "EaseInCirc", "getEaseInCirc", "EaseInCubic", "getEaseInCubic", "EaseInElastic", "getEaseInElastic", "EaseInExpo", "getEaseInExpo", "EaseInOut", "getEaseInOut", "EaseInOutBack", "getEaseInOutBack", "EaseInOutBounce", "getEaseInOutBounce", "EaseInOutCirc", "getEaseInOutCirc", "EaseInOutCubic", "getEaseInOutCubic", "EaseInOutElastic", "getEaseInOutElastic", "EaseInOutExpo", "getEaseInOutExpo", "EaseInOutQuad", "getEaseInOutQuad", "EaseInOutQuart", "getEaseInOutQuart", "EaseInOutQuint", "getEaseInOutQuint", "EaseInOutSine", "getEaseInOutSine", "EaseInQuad", "getEaseInQuad", "EaseInQuart", "getEaseInQuart", "EaseInQuint", "getEaseInQuint", "EaseInSine", "getEaseInSine", "EaseOut", "getEaseOut", "EaseOutBack", "getEaseOutBack", "EaseOutBounce", "getEaseOutBounce", "EaseOutCirc", "getEaseOutCirc", "EaseOutCubic", "getEaseOutCubic", "EaseOutElastic", "getEaseOutElastic", "EaseOutExpo", "getEaseOutExpo", "EaseOutQuad", "getEaseOutQuad", "EaseOutQuart", "getEaseOutQuart", "EaseOutQuint", "getEaseOutQuint", "EaseOutSine", "getEaseOutSine", "animation-core_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class EasingFunctionsKt {

    @NotNull
    private static final Easing Ease = new CubicBezierEasing(0.25f, 0.1f, 0.25f, 1.0f);

    @NotNull
    private static final Easing EaseOut = new CubicBezierEasing(0.0f, 0.0f, 0.58f, 1.0f);

    @NotNull
    private static final Easing EaseIn = new CubicBezierEasing(0.42f, 0.0f, 1.0f, 1.0f);

    @NotNull
    private static final Easing EaseInOut = new CubicBezierEasing(0.42f, 0.0f, 0.58f, 1.0f);

    @NotNull
    private static final Easing EaseInSine = new CubicBezierEasing(0.12f, 0.0f, 0.39f, 0.0f);

    @NotNull
    private static final Easing EaseOutSine = new CubicBezierEasing(0.61f, 1.0f, 0.88f, 1.0f);

    @NotNull
    private static final Easing EaseInOutSine = new CubicBezierEasing(0.37f, 0.0f, 0.63f, 1.0f);

    @NotNull
    private static final Easing EaseInCubic = new CubicBezierEasing(0.32f, 0.0f, 0.67f, 0.0f);

    @NotNull
    private static final Easing EaseOutCubic = new CubicBezierEasing(0.33f, 1.0f, 0.68f, 1.0f);

    @NotNull
    private static final Easing EaseInOutCubic = new CubicBezierEasing(0.65f, 0.0f, 0.35f, 1.0f);

    @NotNull
    private static final Easing EaseInQuint = new CubicBezierEasing(0.64f, 0.0f, 0.78f, 0.0f);

    @NotNull
    private static final Easing EaseOutQuint = new CubicBezierEasing(0.22f, 1.0f, 0.36f, 1.0f);

    @NotNull
    private static final Easing EaseInOutQuint = new CubicBezierEasing(0.83f, 0.0f, 0.17f, 1.0f);

    @NotNull
    private static final Easing EaseInCirc = new CubicBezierEasing(0.55f, 0.0f, 1.0f, 0.45f);

    @NotNull
    private static final Easing EaseOutCirc = new CubicBezierEasing(0.0f, 0.55f, 0.45f, 1.0f);

    @NotNull
    private static final Easing EaseInOutCirc = new CubicBezierEasing(0.85f, 0.0f, 0.15f, 1.0f);

    @NotNull
    private static final Easing EaseInQuad = new CubicBezierEasing(0.11f, 0.0f, 0.5f, 0.0f);

    @NotNull
    private static final Easing EaseOutQuad = new CubicBezierEasing(0.5f, 1.0f, 0.89f, 1.0f);

    @NotNull
    private static final Easing EaseInOutQuad = new CubicBezierEasing(0.45f, 0.0f, 0.55f, 1.0f);

    @NotNull
    private static final Easing EaseInQuart = new CubicBezierEasing(0.5f, 0.0f, 0.75f, 0.0f);

    @NotNull
    private static final Easing EaseOutQuart = new CubicBezierEasing(0.25f, 1.0f, 0.5f, 1.0f);

    @NotNull
    private static final Easing EaseInOutQuart = new CubicBezierEasing(0.76f, 0.0f, 0.24f, 1.0f);

    @NotNull
    private static final Easing EaseInExpo = new CubicBezierEasing(0.7f, 0.0f, 0.84f, 0.0f);

    @NotNull
    private static final Easing EaseOutExpo = new CubicBezierEasing(0.16f, 1.0f, 0.3f, 1.0f);

    @NotNull
    private static final Easing EaseInOutExpo = new CubicBezierEasing(0.87f, 0.0f, 0.13f, 1.0f);

    @NotNull
    private static final Easing EaseInBack = new CubicBezierEasing(0.36f, 0.0f, 0.66f, -0.56f);

    @NotNull
    private static final Easing EaseOutBack = new CubicBezierEasing(0.34f, 1.56f, 0.64f, 1.0f);

    @NotNull
    private static final Easing EaseInOutBack = new CubicBezierEasing(0.68f, -0.6f, 0.32f, 1.6f);

    @NotNull
    private static final Easing EaseInElastic = new C0759a(0);

    @NotNull
    private static final Easing EaseOutElastic = new C0759a(1);

    @NotNull
    private static final Easing EaseInOutElastic = new C0759a(2);

    @NotNull
    private static final Easing EaseOutBounce = new C0759a(3);

    @NotNull
    private static final Easing EaseInBounce = new C0759a(4);

    @NotNull
    private static final Easing EaseInOutBounce = new C0759a(5);

    /* JADX INFO: Access modifiers changed from: private */
    public static final float EaseInBounce$lambda$4(float f) {
        return 1 - EaseOutBounce.transform(1.0f - f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float EaseInElastic$lambda$0(float f) {
        if (f == 0.0f) {
            return 0.0f;
        }
        if (f == 1.0f) {
            return 1.0f;
        }
        return (float) (Math.sin(((double) ((f * 10.0f) - 10.75f)) * 2.0943951023931953d) * ((double) (-((float) Math.pow(2.0f, r6 - 10.0f)))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float EaseInOutBounce$lambda$5(float f) {
        if (f < 0.5d) {
            return (1 - EaseOutBounce.transform(1.0f - (f * 2.0f))) / 2.0f;
        }
        return (EaseOutBounce.transform((f * 2.0f) - 1.0f) + 1) / 2.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float EaseInOutElastic$lambda$2(float f) {
        if (f == 0.0f) {
            return 0.0f;
        }
        if (f == 1.0f) {
            return 1.0f;
        }
        if (0.0f > f || f > 0.5f) {
            double d = 2.0f;
            return ((float) ((Math.sin(((double) ((f * 20.0f) - 11.125f)) * 1.3962634015954636d) * ((double) ((float) Math.pow(d, ((-20.0f) * f) + 10.0f)))) / d)) + 1.0f;
        }
        double d2 = 2.0f;
        return (float) ((-(Math.sin(((double) ((f * 20.0f) - 11.125f)) * 1.3962634015954636d) * ((double) ((float) Math.pow(d2, r12 - 10.0f))))) / d2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float EaseOutBounce$lambda$3(float f) {
        if (f < 0.36363637f) {
            return 7.5625f * f * f;
        }
        if (f < 0.72727275f) {
            float f4 = f - 0.54545456f;
            return AbstractC0622a.m1154D(f4, 7.5625f, f4, 0.75f);
        }
        if (f < 0.90909094f) {
            float f5 = f - 0.8181818f;
            return AbstractC0622a.m1154D(f5, 7.5625f, f5, 0.9375f);
        }
        float f6 = f - 0.95454544f;
        return AbstractC0622a.m1154D(f6, 7.5625f, f6, 0.984375f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float EaseOutElastic$lambda$1(float f) {
        if (f == 0.0f) {
            return 0.0f;
        }
        if (f == 1.0f) {
            return 1.0f;
        }
        return (float) ((Math.sin(((double) ((f * 10.0f) - 0.75f)) * 2.0943951023931953d) * ((double) ((float) Math.pow(2.0f, (-10.0f) * f)))) + ((double) 1.0f));
    }

    @NotNull
    public static final Easing getEase() {
        return Ease;
    }

    @NotNull
    public static final Easing getEaseIn() {
        return EaseIn;
    }

    @NotNull
    public static final Easing getEaseInBack() {
        return EaseInBack;
    }

    @NotNull
    public static final Easing getEaseInBounce() {
        return EaseInBounce;
    }

    @NotNull
    public static final Easing getEaseInCirc() {
        return EaseInCirc;
    }

    @NotNull
    public static final Easing getEaseInCubic() {
        return EaseInCubic;
    }

    @NotNull
    public static final Easing getEaseInElastic() {
        return EaseInElastic;
    }

    @NotNull
    public static final Easing getEaseInExpo() {
        return EaseInExpo;
    }

    @NotNull
    public static final Easing getEaseInOut() {
        return EaseInOut;
    }

    @NotNull
    public static final Easing getEaseInOutBack() {
        return EaseInOutBack;
    }

    @NotNull
    public static final Easing getEaseInOutBounce() {
        return EaseInOutBounce;
    }

    @NotNull
    public static final Easing getEaseInOutCirc() {
        return EaseInOutCirc;
    }

    @NotNull
    public static final Easing getEaseInOutCubic() {
        return EaseInOutCubic;
    }

    @NotNull
    public static final Easing getEaseInOutElastic() {
        return EaseInOutElastic;
    }

    @NotNull
    public static final Easing getEaseInOutExpo() {
        return EaseInOutExpo;
    }

    @NotNull
    public static final Easing getEaseInOutQuad() {
        return EaseInOutQuad;
    }

    @NotNull
    public static final Easing getEaseInOutQuart() {
        return EaseInOutQuart;
    }

    @NotNull
    public static final Easing getEaseInOutQuint() {
        return EaseInOutQuint;
    }

    @NotNull
    public static final Easing getEaseInOutSine() {
        return EaseInOutSine;
    }

    @NotNull
    public static final Easing getEaseInQuad() {
        return EaseInQuad;
    }

    @NotNull
    public static final Easing getEaseInQuart() {
        return EaseInQuart;
    }

    @NotNull
    public static final Easing getEaseInQuint() {
        return EaseInQuint;
    }

    @NotNull
    public static final Easing getEaseInSine() {
        return EaseInSine;
    }

    @NotNull
    public static final Easing getEaseOut() {
        return EaseOut;
    }

    @NotNull
    public static final Easing getEaseOutBack() {
        return EaseOutBack;
    }

    @NotNull
    public static final Easing getEaseOutBounce() {
        return EaseOutBounce;
    }

    @NotNull
    public static final Easing getEaseOutCirc() {
        return EaseOutCirc;
    }

    @NotNull
    public static final Easing getEaseOutCubic() {
        return EaseOutCubic;
    }

    @NotNull
    public static final Easing getEaseOutElastic() {
        return EaseOutElastic;
    }

    @NotNull
    public static final Easing getEaseOutExpo() {
        return EaseOutExpo;
    }

    @NotNull
    public static final Easing getEaseOutQuad() {
        return EaseOutQuad;
    }

    @NotNull
    public static final Easing getEaseOutQuart() {
        return EaseOutQuart;
    }

    @NotNull
    public static final Easing getEaseOutQuint() {
        return EaseOutQuint;
    }

    @NotNull
    public static final Easing getEaseOutSine() {
        return EaseOutSine;
    }
}
