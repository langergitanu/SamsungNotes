package com.samsung.android.sesl.visualeffect.lighteffects.guidinglight;

import android.animation.Animator;
import android.os.Handler;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\t"}, m13886d2 = {"com/samsung/android/sesl/visualeffect/lighteffects/guidinglight/AnimationFactory$Companion$createAnimation$1$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationStart", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class AnimationFactory$Companion$createAnimation$1$1 implements Animator.AnimatorListener {
    final /* synthetic */ Handler $handler;
    final /* synthetic */ Runnable $onCancel;
    final /* synthetic */ Runnable $onEnd;
    final /* synthetic */ Runnable $onStart;

    public AnimationFactory$Companion$createAnimation$1$1(Handler handler, Runnable runnable, Runnable runnable2, Runnable runnable3) {
        this.$handler = handler;
        this.$onStart = runnable;
        this.$onEnd = runnable2;
        this.$onCancel = runnable3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onAnimationCancel$lambda$2(Runnable runnable) {
        if (runnable != null) {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onAnimationEnd$lambda$1(Runnable runnable) {
        if (runnable != null) {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onAnimationStart$lambda$0(Runnable runnable) {
        if (runnable != null) {
            runnable.run();
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        this.$handler.post(new RunnableC7849a(this.$onCancel, 2));
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        this.$handler.post(new RunnableC7849a(this.$onEnd, 1));
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        this.$handler.post(new RunnableC7849a(this.$onStart, 0));
    }
}
