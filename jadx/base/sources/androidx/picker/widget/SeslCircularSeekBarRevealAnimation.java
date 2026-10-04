package androidx.picker.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.util.Log;
import android.view.View;
import android.view.animation.PathInterpolator;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
class SeslCircularSeekBarRevealAnimation {
    private static final long REVEAL_ANIMATION_DURATION = 800;
    private static final String TAG = "CircularRevealAnimation";
    private final PathInterpolator mAniInterpolator = new PathInterpolator(0.22f, 0.25f, 0.0f, 1.0f);
    private boolean mIsRevealAnimation;
    private float mSweepProgress;
    private SeslCircularSeekBarView mView;

    public SeslCircularSeekBarRevealAnimation(View view) {
        if (view instanceof SeslCircularSeekBarView) {
            this.mView = (SeslCircularSeekBarView) view;
        }
    }

    public float getmSweepProgress() {
        return this.mSweepProgress;
    }

    public boolean isRevealAnimation() {
        return this.mIsRevealAnimation;
    }

    public void setRevealAnimation(boolean z) {
        this.mIsRevealAnimation = z;
    }

    public void setmSweepProgress(float f) {
        this.mSweepProgress = f;
    }

    public void startAnimators() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setDuration(800L).setInterpolator(this.mAniInterpolator);
        valueAnimatorOfFloat.addListener(new Animator.AnimatorListener() { // from class: androidx.picker.widget.SeslCircularSeekBarRevealAnimation.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(@NonNull Animator animator) {
                animator.cancel();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(@NonNull Animator animator) {
                Log.d(SeslCircularSeekBarRevealAnimation.TAG, "onAnimationEnd()");
                SeslCircularSeekBarRevealAnimation.this.mIsRevealAnimation = false;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(@NonNull Animator animator) {
                Log.d(SeslCircularSeekBarRevealAnimation.TAG, "onAnimationStart()");
                SeslCircularSeekBarRevealAnimation.this.mIsRevealAnimation = true;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(@NonNull Animator animator) {
            }
        });
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: androidx.picker.widget.SeslCircularSeekBarRevealAnimation.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                SeslCircularSeekBarRevealAnimation.this.mView.setRevealAnimationValue(((Float) valueAnimator.getAnimatedValue()).floatValue());
                SeslCircularSeekBarRevealAnimation.this.mView.invalidate();
            }
        });
        valueAnimatorOfFloat.start();
    }
}
