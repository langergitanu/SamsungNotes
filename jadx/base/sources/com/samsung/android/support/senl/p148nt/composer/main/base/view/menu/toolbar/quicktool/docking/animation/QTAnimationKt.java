package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.animation;

import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import com.samsung.android.sesl.visualeffect.lighteffects.radialgrad.WiggleAnimationConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\u001a,\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\u000b\u001a.\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\r\u001a\u00020\b2\b\b\u0001\u0010\u000e\u001a\u00020\b\u001a(\u0010\u000f\u001a\u00020\u0005*\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\f\u001a\u00020\u000b\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0010"}, m13886d2 = {"OneEasing", "Landroid/view/animation/PathInterpolator;", "getOneEasing", "()Landroid/view/animation/PathInterpolator;", WiggleAnimationConfig.KEY_SCALE, "", "Landroid/view/View;", "start", "", "end", "delay", "", XmlErrorCodes.DURATION, "dampingRatio", "stiffness", "alpha", "ntComposer_release"}, m13887k = 2, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class QTAnimationKt {

    @NotNull
    private static final PathInterpolator OneEasing = new PathInterpolator(0.22f, 0.25f, 0.0f, 1.0f);

    public static final void alpha(@NotNull View view, @FloatRange(from = 0.0d, m705to = 1.0d) float f, @FloatRange(from = 0.0d, m705to = 1.0d) float f4, @IntRange(from = 0) long j) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setAlpha(f);
        view.animate().alpha(f4).setDuration(j).setInterpolator(new LinearInterpolator()).start();
    }

    @NotNull
    public static final PathInterpolator getOneEasing() {
        return OneEasing;
    }

    public static final void scale(@NotNull View view, float f, float f4, long j, @IntRange(from = 0) long j2) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setScaleX(f);
        view.setScaleY(f);
        view.animate().scaleX(f4).scaleY(f4).setStartDelay(j).setDuration(j2).setInterpolator(OneEasing).start();
    }

    public static final void scale(@NotNull View view, float f, float f4, @FloatRange(from = 0.0d) float f5, @FloatRange(from = 0.0d, fromInclusive = false) float f6) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setScaleX(f);
        view.setScaleY(f);
        SpringForce stiffness = new SpringForce(f4).setDampingRatio(f5).setStiffness(f6);
        new SpringAnimation(view, DynamicAnimation.SCALE_X).setSpring(stiffness).start();
        new SpringAnimation(view, DynamicAnimation.SCALE_Y).setSpring(stiffness).start();
    }
}
