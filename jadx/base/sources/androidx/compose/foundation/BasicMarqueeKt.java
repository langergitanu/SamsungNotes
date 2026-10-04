package androidx.compose.foundation;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.StartOffset;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.unit.Density;
import androidx.compose.runtime.Stable;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001aH\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a&\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u00142\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\nH\u0002\u001aR\u0010\u0015\u001a\u00020\u0016*\u00020\u00162\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u000e\u001a\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001c"}, m13886d2 = {"MarqueeSpacing", "Landroidx/compose/foundation/MarqueeSpacing;", "spacing", "Landroidx/compose/ui/unit/Dp;", "MarqueeSpacing-0680j_4", "(F)Landroidx/compose/foundation/MarqueeSpacing;", "createMarqueeAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "iterations", "", "targetValue", "initialDelayMillis", "delayMillis", "velocity", "density", "Landroidx/compose/ui/unit/Density;", "createMarqueeAnimationSpec-Z4HSEVQ", "(IFIIFLandroidx/compose/ui/unit/Density;)Landroidx/compose/animation/core/AnimationSpec;", "velocityBasedTween", "Landroidx/compose/animation/core/TweenSpec;", "basicMarquee", "Landroidx/compose/ui/Modifier;", "animationMode", "Landroidx/compose/foundation/MarqueeAnimationMode;", "repeatDelayMillis", "basicMarquee-1Mj1MLw", "(Landroidx/compose/ui/Modifier;IIIILandroidx/compose/foundation/MarqueeSpacing;F)Landroidx/compose/ui/Modifier;", "foundation_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nBasicMarquee.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BasicMarquee.kt\nandroidx/compose/foundation/BasicMarqueeKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,508:1\n1#2:509\n*E\n"})
public final class BasicMarqueeKt {
    @NotNull
    /* JADX INFO: renamed from: MarqueeSpacing-0680j_4, reason: not valid java name */
    public static final MarqueeSpacing m15412MarqueeSpacing0680j_4(float f) {
        return new C0827a(f, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int MarqueeSpacing_0680j_4$lambda$1(float f, Density density, int i, int i2) {
        return density.mo15540roundToPx0680j_4(f);
    }

    @Stable
    @NotNull
    /* JADX INFO: renamed from: basicMarquee-1Mj1MLw, reason: not valid java name */
    public static final Modifier m15414basicMarquee1Mj1MLw(@NotNull Modifier modifier, int i, int i2, int i4, int i5, @NotNull MarqueeSpacing marqueeSpacing, float f) {
        return modifier.then(new MarqueeModifierElement(i, i2, i4, i5, marqueeSpacing, f, null));
    }

    /* JADX INFO: renamed from: basicMarquee-1Mj1MLw$default, reason: not valid java name */
    public static /* synthetic */ Modifier m15415basicMarquee1Mj1MLw$default(Modifier modifier, int i, int i2, int i4, int i5, MarqueeSpacing marqueeSpacing, float f, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = MarqueeDefaults.INSTANCE.getIterations();
        }
        if ((i6 & 2) != 0) {
            i2 = MarqueeAnimationMode.INSTANCE.m15487getImmediatelyZbEOnfQ();
        }
        if ((i6 & 4) != 0) {
            i4 = MarqueeDefaults.INSTANCE.getRepeatDelayMillis();
        }
        if ((i6 & 8) != 0) {
            i5 = MarqueeAnimationMode.m15483equalsimpl0(i2, MarqueeAnimationMode.INSTANCE.m15487getImmediatelyZbEOnfQ()) ? i4 : 0;
        }
        if ((i6 & 16) != 0) {
            marqueeSpacing = MarqueeDefaults.INSTANCE.getSpacing();
        }
        if ((i6 & 32) != 0) {
            f = MarqueeDefaults.INSTANCE.m15489getVelocityD9Ej5fM();
        }
        return m15414basicMarquee1Mj1MLw(modifier, i, i2, i4, i5, marqueeSpacing, f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: createMarqueeAnimationSpec-Z4HSEVQ, reason: not valid java name */
    public static final AnimationSpec<Float> m15416createMarqueeAnimationSpecZ4HSEVQ(int i, float f, int i2, int i4, float f4, Density density) {
        TweenSpec<Float> tweenSpecVelocityBasedTween = velocityBasedTween(Math.abs(density.mo15546toPx0680j_4(f4)), f, i4);
        long jM15347constructorimpl$default = StartOffset.m15347constructorimpl$default((-i4) + i2, 0, 2, null);
        return i == Integer.MAX_VALUE ? AnimationSpecKt.m15313infiniteRepeatable9IiC70o$default(tweenSpecVelocityBasedTween, null, jM15347constructorimpl$default, 2, null) : AnimationSpecKt.m15315repeatable91I0pcU$default(i, tweenSpecVelocityBasedTween, null, jM15347constructorimpl$default, 4, null);
    }

    private static final TweenSpec<Float> velocityBasedTween(float f, float f4, int i) {
        return AnimationSpecKt.tween((int) Math.ceil(f4 / (f / 1000.0f)), i, EasingKt.getLinearEasing());
    }
}
