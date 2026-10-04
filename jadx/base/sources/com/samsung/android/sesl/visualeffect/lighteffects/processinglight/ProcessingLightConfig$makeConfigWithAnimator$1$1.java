package com.samsung.android.sesl.visualeffect.lighteffects.processinglight;

import android.animation.Animator;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.compose.runtime.AbstractC1974b;
import com.samsung.android.sdk.pen.setting.handwriting.RunnableC7599e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\t"}, m13886d2 = {"com/samsung/android/sesl/visualeffect/lighteffects/processinglight/ProcessingLightConfig$makeConfigWithAnimator$1$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationStart", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class ProcessingLightConfig$makeConfigWithAnimator$1$1 implements Animator.AnimatorListener {
    final /* synthetic */ ProcessingLightConfig $this_apply;

    public ProcessingLightConfig$makeConfigWithAnimator$1$1(ProcessingLightConfig processingLightConfig) {
        this.$this_apply = processingLightConfig;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        Log.i(ProcessingLightConfig.TAG, "Processing - onAnimationEnd");
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        if (this.$this_apply.getRepeatDelay() > 0) {
            animation.pause();
            new Handler(Looper.getMainLooper()).postDelayed(new RunnableC7599e(animation, 5), this.$this_apply.getRepeatDelay());
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        long durationInMillis = this.$this_apply.getDurationInMillis();
        long repeatDelay = this.$this_apply.getRepeatDelay();
        StringBuilder sbM1323p = AbstractC1974b.m1323p(durationInMillis, "Processing - onAnimationStart duration:", "L repeatDelay:");
        sbM1323p.append(repeatDelay);
        sbM1323p.append("L");
        Log.i(ProcessingLightConfig.TAG, sbM1323p.toString());
    }
}
