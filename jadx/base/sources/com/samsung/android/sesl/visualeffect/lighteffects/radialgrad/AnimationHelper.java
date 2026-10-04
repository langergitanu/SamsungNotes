package com.samsung.android.sesl.visualeffect.lighteffects.radialgrad;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.view.animation.Interpolator;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@RequiresApi(33)
@Metadata(m13885d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JV\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00052\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011J^\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0014j\b\u0012\u0004\u0012\u00020\u0015`\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u00052\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\r2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00190\u001c¨\u0006\u001f"}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/lighteffects/radialgrad/AnimationHelper;", "", "<init>", "()V", "buildColorAnimation", "", "Landroid/animation/ValueAnimator;", "fromColors", "", "toColors", "effect", "Lcom/samsung/android/sesl/visualeffect/lighteffects/radialgrad/RadialGradRenderEffect;", XmlErrorCodes.DURATION, "", "interpolator", "Landroid/view/animation/Interpolator;", "onStateChangeComplete", "Lkotlin/Function0;", "", "buildSpotConfigs", "Ljava/util/ArrayList;", "Lcom/samsung/android/sesl/visualeffect/lighteffects/radialgrad/SpotConfig;", "Lkotlin/collections/ArrayList;", "colors", "fps", "", "wiggleInterval", "currentSpotPositions", "", "Landroid/graphics/PointF;", "currentSpotScales", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class AnimationHelper {

    @NotNull
    public static final AnimationHelper INSTANCE = new AnimationHelper();

    private AnimationHelper() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ List buildColorAnimation$default(AnimationHelper animationHelper, List list, List list2, RadialGradRenderEffect radialGradRenderEffect, long j, Interpolator interpolator, Function0 function0, int i, Object obj) {
        if ((i & 8) != 0) {
            j = 1200;
        }
        return animationHelper.buildColorAnimation(list, list2, radialGradRenderEffect, j, (i & 16) != 0 ? Constants.INSTANCE.getSTATE_CHANGE_INTERPOLATOR() : interpolator, (i & 32) != 0 ? null : function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void buildColorAnimation$lambda$1$lambda$0(RadialGradRenderEffect radialGradRenderEffect, int i, ValueAnimator valueAnimator, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        radialGradRenderEffect.setSpotColor(i, ((Integer) animatedValue).intValue());
    }

    public static /* synthetic */ ArrayList buildSpotConfigs$default(AnimationHelper animationHelper, List list, float f, long j, Map map, Map map2, int i, Object obj) {
        if ((i & 4) != 0) {
            j = Constants.WGL_INTERVAL;
        }
        return animationHelper.buildSpotConfigs(list, f, j, map, map2);
    }

    @NotNull
    public final List<ValueAnimator> buildColorAnimation(@NotNull List<Integer> fromColors, @NotNull List<Integer> toColors, @NotNull RadialGradRenderEffect effect, long duration, @NotNull Interpolator interpolator, @Nullable final Function0<Unit> onStateChangeComplete) {
        Intrinsics.checkNotNullParameter(fromColors, "fromColors");
        Intrinsics.checkNotNullParameter(toColors, "toColors");
        Intrinsics.checkNotNullParameter(effect, "effect");
        Intrinsics.checkNotNullParameter(interpolator, "interpolator");
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 4; i++) {
            ValueAnimator valueAnimatorOfArgb = ValueAnimator.ofArgb(fromColors.get(i).intValue(), toColors.get(i).intValue());
            valueAnimatorOfArgb.setDuration(duration);
            valueAnimatorOfArgb.setInterpolator(interpolator);
            valueAnimatorOfArgb.addUpdateListener(new C7873a(effect, i, valueAnimatorOfArgb, 0));
            arrayList.add(valueAnimatorOfArgb);
        }
        if (onStateChangeComplete != null) {
            ((ValueAnimator) arrayList.get(0)).addListener(new Animator.AnimatorListener() { // from class: com.samsung.android.sesl.visualeffect.lighteffects.radialgrad.AnimationHelper$buildColorAnimation$1$1
                private boolean isCancelled;

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    this.isCancelled = true;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    if (this.isCancelled) {
                        return;
                    }
                    onStateChangeComplete.invoke();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                }
            });
        }
        return arrayList;
    }

    @NotNull
    public final ArrayList<SpotConfig> buildSpotConfigs(@NotNull List<Integer> colors, float fps, long wiggleInterval, @NotNull Map<Integer, ? extends PointF> currentSpotPositions, @NotNull Map<Integer, Float> currentSpotScales) {
        Intrinsics.checkNotNullParameter(colors, "colors");
        Intrinsics.checkNotNullParameter(currentSpotPositions, "currentSpotPositions");
        Intrinsics.checkNotNullParameter(currentSpotScales, "currentSpotScales");
        ArrayList<SpotConfig> arrayList = new ArrayList<>();
        int i = 0;
        while (i < 4) {
            int iIntValue = colors.get(i).intValue();
            PointF pointF = currentSpotPositions.get(Integer.valueOf(i));
            if (pointF == null) {
                pointF = new PointF(0.0f, 0.0f);
            }
            PointF pointF2 = pointF;
            Float f = currentSpotScales.get(Integer.valueOf(i));
            arrayList.add(new SpotConfig(false, iIntValue, pointF2, f != null ? f.floatValue() : 0.0f, (i == 0 || i == 3) ? new WiggleAnimationConfig(wiggleInterval, Constants.INSTANCE.getCUBIC_BEZIER_INTERPOLATOR(), Float.valueOf(0.35f), Float.valueOf(0.5f), null, fps, 16, null) : null, 1, null));
            i++;
        }
        return arrayList;
    }
}
