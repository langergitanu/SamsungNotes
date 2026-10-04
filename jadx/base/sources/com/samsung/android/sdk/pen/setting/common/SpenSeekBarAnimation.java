package com.samsung.android.sdk.pen.setting.common;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.drawable.ScaleDrawable;
import android.view.MotionEvent;
import android.widget.SeekBar;
import androidx.appcompat.animation.C0421a;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilAnimation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000b\u001a\u00020\fJ$\u0010\r\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u0007J\u000e\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0013J\u0010\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\nH\u0002J\u0010\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\nH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/common/SpenSeekBarAnimation;", "", "<init>", "()V", "mSeekBar", "Landroid/widget/SeekBar;", "mThumbColorDrawable", "Landroid/graphics/drawable/ScaleDrawable;", "mThumbStrokeDrawable", "mInitComplete", "", "close", "", "setTarget", "seekBar", "thumbDrawable", "thumbStrokeDrawable", "setOnTouchEvent", "event", "Landroid/view/MotionEvent;", "setThumbAnimation", "scaleUp", "setScale", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenSeekBarAnimation {
    private static final int SCALE_DOWN_ANIMATION_TO_LEVEL = 7700;
    private static final int SCALE_DURATION = 250;
    private static final int SCALE_UP_ANIMATION_TO_LEVEL = 10000;

    @NotNull
    private static final String TAG = "SpenSeekBarAnimation";
    private boolean mInitComplete;

    @Nullable
    private SeekBar mSeekBar;

    @Nullable
    private ScaleDrawable mThumbColorDrawable;

    @Nullable
    private ScaleDrawable mThumbStrokeDrawable;

    /* JADX INFO: Access modifiers changed from: private */
    public final void setScale(boolean scaleUp) {
        SeekBar seekBar = this.mSeekBar;
        if (seekBar != null) {
            seekBar.setSelected(scaleUp);
        }
    }

    private final void setThumbAnimation(boolean scaleUp) {
        ValueAnimator valueAnimatorOfInt;
        if (this.mInitComplete) {
            AbstractC6670b.m4759t("setThumbAnimation() scaleUp=", TAG, scaleUp);
            ScaleDrawable scaleDrawable = this.mThumbColorDrawable;
            int level = scaleDrawable != null ? scaleDrawable.getLevel() : 0;
            if (scaleUp) {
                valueAnimatorOfInt = ValueAnimator.ofInt(level, 10000);
                valueAnimatorOfInt.addListener(new AnimatorListenerAdapter() { // from class: com.samsung.android.sdk.pen.setting.common.SpenSeekBarAnimation.setThumbAnimation.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animation) {
                        Intrinsics.checkNotNullParameter(animation, "animation");
                        super.onAnimationCancel(animation);
                        SpenSeekBarAnimation.this.setScale(true);
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animation) {
                        Intrinsics.checkNotNullParameter(animation, "animation");
                        super.onAnimationEnd(animation);
                        SpenSeekBarAnimation.this.setScale(true);
                    }
                });
            } else {
                valueAnimatorOfInt = ValueAnimator.ofInt(level, SCALE_DOWN_ANIMATION_TO_LEVEL);
                valueAnimatorOfInt.addListener(new AnimatorListenerAdapter() { // from class: com.samsung.android.sdk.pen.setting.common.SpenSeekBarAnimation.setThumbAnimation.2
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animation) {
                        Intrinsics.checkNotNullParameter(animation, "animation");
                        super.onAnimationCancel(animation);
                        SpenSeekBarAnimation.this.setScale(false);
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animation) {
                        Intrinsics.checkNotNullParameter(animation, "animation");
                        super.onAnimationEnd(animation);
                        SpenSeekBarAnimation.this.setScale(false);
                    }
                });
            }
            valueAnimatorOfInt.setDuration(250L);
            valueAnimatorOfInt.setInterpolator(SpenSettingUtilAnimation.getInterpolator(4));
            valueAnimatorOfInt.addUpdateListener(new C0421a(this, 4));
            valueAnimatorOfInt.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setThumbAnimation$lambda$0(SpenSeekBarAnimation spenSeekBarAnimation, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(valueAnimator, "valueAnimator");
        ScaleDrawable scaleDrawable = spenSeekBarAnimation.mThumbColorDrawable;
        if (scaleDrawable != null) {
            Object animatedValue = valueAnimator.getAnimatedValue();
            Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
            scaleDrawable.setLevel(((Integer) animatedValue).intValue());
        }
        ScaleDrawable scaleDrawable2 = spenSeekBarAnimation.mThumbStrokeDrawable;
        if (scaleDrawable2 != null) {
            Object animatedValue2 = valueAnimator.getAnimatedValue();
            Intrinsics.checkNotNull(animatedValue2, "null cannot be cast to non-null type kotlin.Int");
            scaleDrawable2.setLevel(((Integer) animatedValue2).intValue());
        }
    }

    public final void close() {
        this.mSeekBar = null;
        this.mThumbStrokeDrawable = null;
        this.mThumbColorDrawable = null;
        this.mInitComplete = false;
    }

    public final void setOnTouchEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.mSeekBar == null) {
            return;
        }
        int action = event.getAction();
        if (action == 0) {
            setThumbAnimation(true);
        } else if (action == 1) {
            setThumbAnimation(false);
        } else {
            if (action != 3) {
                return;
            }
            setThumbAnimation(false);
        }
    }

    public final boolean setTarget(@Nullable SeekBar seekBar, @Nullable ScaleDrawable thumbDrawable, @Nullable ScaleDrawable thumbStrokeDrawable) {
        if (seekBar == null || thumbDrawable == null) {
            return false;
        }
        this.mSeekBar = seekBar;
        thumbDrawable.mutate();
        this.mThumbColorDrawable = thumbDrawable;
        this.mThumbStrokeDrawable = thumbStrokeDrawable;
        this.mInitComplete = true;
        return true;
    }
}
