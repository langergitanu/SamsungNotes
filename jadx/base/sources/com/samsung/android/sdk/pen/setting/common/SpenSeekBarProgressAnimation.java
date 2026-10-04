package com.samsung.android.sdk.pen.setting.common;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.os.Build;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.animation.PathInterpolator;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.animation.C0421a;
import androidx.glance.AbstractC2821a;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u001e\u001a\u00020\u001fJ\u000e\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\"J\u000e\u0010#\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\u000bJ&\u0010%\u001a\u00020\u00162\u0006\u0010&\u001a\u00020\u00162\u0006\u0010'\u001a\u00020\u00162\u0006\u0010(\u001a\u00020\u00162\u0006\u0010)\u001a\u00020\u000bJ\u0016\u0010*\u001a\u00020\u00162\u0006\u0010+\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020\u000bJ\b\u0010/\u001a\u00020\u001fH\u0002J \u00100\u001a\u00020\u001f2\u0006\u00101\u001a\u00020\u000b2\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000203H\u0002J\b\u00105\u001a\u00020\u001fH\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010-\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b-\u0010.¨\u00066"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/common/SpenSeekBarProgressAnimation;", "", "seekBar", "Landroid/widget/SeekBar;", "labelTextView", "Landroid/widget/TextView;", "<init>", "(Landroid/widget/SeekBar;Landroid/widget/TextView;)V", SearchConstants.TargetContents.TAG, "", "SEEK_BAR_ANIMATION_SHORT_DURATION", "", "SEEK_BAR_ANIMATION_LONG_DURATION", "LABEL_ANIMATION_DURATION", "VALUE_THRESHOLD", "mSeekBar", "mLabelText", "mLabelAnimator", "Landroid/animation/ValueAnimator;", "mAnimator", "Landroid/animation/ObjectAnimator;", "mLabelAnimatorCancelled", "", "mStartProgress", "mAnimatingEndValue", "mTouchDownX", "mScaledTouchSlop", "mIsDragging", "mInnerAnimationListener", "Landroid/animation/Animator$AnimatorListener;", "close", "", "setOnTouchEvent", "event", "Landroid/view/MotionEvent;", "setStartProgress", "value", "setTarget", "fromUser", "isTracking", "isButtonEvent", "targetProgress", "startAnimation", "startProgress", "endProgress", "isAnimationRunning", "()Z", "cancelAnimation", "startLabelAnimator", XmlErrorCodes.DURATION, "startValue", "", "endValue", "setLabelAnimator", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SuppressLint({"LongLogTag"})
public final class SpenSeekBarProgressAnimation {
    private int mAnimatingEndValue;

    @Nullable
    private ObjectAnimator mAnimator;
    private boolean mIsDragging;

    @Nullable
    private ValueAnimator mLabelAnimator;
    private boolean mLabelAnimatorCancelled;

    @Nullable
    private TextView mLabelText;
    private int mScaledTouchSlop;

    @Nullable
    private SeekBar mSeekBar;
    private int mStartProgress;
    private int mTouchDownX;

    @NotNull
    private final String TAG = "SpenSeekBarProgressAnimation";
    private final int SEEK_BAR_ANIMATION_SHORT_DURATION = 100;
    private final int SEEK_BAR_ANIMATION_LONG_DURATION = 400;
    private final int LABEL_ANIMATION_DURATION = 150;
    private final int VALUE_THRESHOLD = 10;

    @NotNull
    private final Animator.AnimatorListener mInnerAnimationListener = new Animator.AnimatorListener() { // from class: com.samsung.android.sdk.pen.setting.common.SpenSeekBarProgressAnimation$mInnerAnimationListener$1
        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            this.this$0.mLabelAnimatorCancelled = true;
            this.this$0.startLabelAnimator(0, 0.0f, 1.0f);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            SeekBar seekBar = this.this$0.mSeekBar;
            if (seekBar != null) {
                this.this$0.mStartProgress = seekBar.getProgress();
            }
            if (!this.this$0.mLabelAnimatorCancelled) {
                SpenSeekBarProgressAnimation spenSeekBarProgressAnimation = this.this$0;
                spenSeekBarProgressAnimation.startLabelAnimator(spenSeekBarProgressAnimation.LABEL_ANIMATION_DURATION, 0.0f, 1.0f);
            }
            this.this$0.mIsDragging = false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            this.this$0.mLabelAnimatorCancelled = false;
            this.this$0.startLabelAnimator(0, 1.0f, 0.0f);
        }
    };

    public SpenSeekBarProgressAnimation(@Nullable SeekBar seekBar, @Nullable TextView textView) {
        if (seekBar != null) {
            this.mSeekBar = seekBar;
            this.mLabelText = textView;
            this.mScaledTouchSlop = ViewConfiguration.get(seekBar.getContext()).getScaledTouchSlop();
            setLabelAnimator();
        }
    }

    private final void cancelAnimation() {
        Log.i(this.TAG, "cancelAnimation: ");
        ObjectAnimator objectAnimator = this.mAnimator;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        ObjectAnimator objectAnimator2 = this.mAnimator;
        if (objectAnimator2 != null) {
            objectAnimator2.addListener(null);
        }
    }

    private final void setLabelAnimator() {
        ValueAnimator valueAnimator = new ValueAnimator();
        this.mLabelAnimator = valueAnimator;
        valueAnimator.setDuration(this.LABEL_ANIMATION_DURATION);
        valueAnimator.setInterpolator(new PathInterpolator(0.76f, 0.06f, 0.93f, 0.63f));
        valueAnimator.addUpdateListener(new C0421a(this, 5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setLabelAnimator$lambda$6$lambda$5(SpenSeekBarProgressAnimation spenSeekBarProgressAnimation, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        TextView textView = spenSeekBarProgressAnimation.mLabelText;
        if (textView != null) {
            Object animatedValue = animation.getAnimatedValue();
            Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
            float fFloatValue = ((Float) animatedValue).floatValue();
            textView.setScaleX(fFloatValue);
            textView.setScaleY(fFloatValue);
            textView.setAlpha(fFloatValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startLabelAnimator(int duration, float startValue, float endValue) {
        ValueAnimator valueAnimator = this.mLabelAnimator;
        if (valueAnimator == null || this.mLabelText == null) {
            return;
        }
        valueAnimator.setDuration(duration);
        valueAnimator.setFloatValues(startValue, endValue);
        valueAnimator.start();
    }

    public final void close() {
        cancelAnimation();
        this.mAnimator = null;
        this.mSeekBar = null;
        ValueAnimator valueAnimator = this.mLabelAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.mLabelAnimator;
        if (valueAnimator2 != null) {
            valueAnimator2.addUpdateListener(null);
        }
        this.mLabelAnimator = null;
        this.mLabelText = null;
    }

    public final boolean isAnimationRunning() {
        ObjectAnimator objectAnimator = this.mAnimator;
        if (objectAnimator != null) {
            return objectAnimator.isRunning();
        }
        return false;
    }

    public final void setOnTouchEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        SeekBar seekBar = this.mSeekBar;
        if (seekBar != null) {
            int x = (int) event.getX();
            int action = event.getAction();
            if (action != 0) {
                if (action == 2 && Math.abs(x - this.mTouchDownX) > this.mScaledTouchSlop) {
                    this.mIsDragging = true;
                    return;
                }
                return;
            }
            int pointerCount = event.getPointerCount();
            this.mScaledTouchSlop = (pointerCount <= 0 || event.getToolType(pointerCount - 1) == 1) ? ViewConfiguration.get(seekBar.getContext()).getScaledTouchSlop() : Build.VERSION.SDK_INT >= 28 ? ViewConfiguration.get(seekBar.getContext()).getScaledHoverSlop() : ViewConfiguration.get(seekBar.getContext()).getScaledTouchSlop() / 2;
            this.mStartProgress = seekBar.getProgress();
            this.mTouchDownX = x;
            this.mIsDragging = false;
        }
    }

    public final void setStartProgress(int value) {
        this.mStartProgress = value;
    }

    public final boolean setTarget(boolean fromUser, boolean isTracking, boolean isButtonEvent, int targetProgress) {
        String str = this.TAG;
        boolean z = this.mIsDragging;
        StringBuilder sbM2230u = AbstractC2821a.m2230u("setTarget: fromUSer= ", " isTracking= ", " isButtonEvent= ", fromUser, isTracking);
        sbM2230u.append(isButtonEvent);
        sbM2230u.append(" mIsDragging= ");
        sbM2230u.append(z);
        Log.i(str, sbM2230u.toString());
        if (fromUser && ((isTracking && !this.mIsDragging) || (isButtonEvent && Math.abs(this.mStartProgress - targetProgress) > 1))) {
            return startAnimation(this.mStartProgress, targetProgress);
        }
        if (!fromUser || !isAnimationRunning()) {
            return false;
        }
        if (this.mIsDragging) {
            cancelAnimation();
            return false;
        }
        if (isTracking || isButtonEvent) {
            return false;
        }
        return startAnimation(this.mStartProgress, targetProgress);
    }

    public final boolean startAnimation(int startProgress, int endProgress) {
        SeekBar seekBar = this.mSeekBar;
        if (seekBar == null) {
            return false;
        }
        if (!seekBar.isShown()) {
            seekBar.setProgress(endProgress);
            return false;
        }
        if (startProgress == endProgress) {
            return false;
        }
        if (isAnimationRunning()) {
            if (endProgress == this.mAnimatingEndValue) {
                return false;
            }
            ObjectAnimator objectAnimator = this.mAnimator;
            Object animatedValue = objectAnimator != null ? objectAnimator.getAnimatedValue() : null;
            Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
            startProgress = ((Integer) animatedValue).intValue();
            cancelAnimation();
        }
        this.mAnimatingEndValue = endProgress;
        AbstractC6670b.m4744e(startProgress, endProgress, "startAnimation: ", " -> ", this.TAG);
        ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(seekBar, "Progress", startProgress, endProgress);
        this.mAnimator = objectAnimatorOfInt;
        if (objectAnimatorOfInt == null) {
            return true;
        }
        objectAnimatorOfInt.addListener(this.mInnerAnimationListener);
        objectAnimatorOfInt.setInterpolator(new PathInterpolator(0.22f, 0.25f, 0.0f, 1.0f));
        objectAnimatorOfInt.setDuration(Math.abs(startProgress - endProgress) <= this.VALUE_THRESHOLD ? this.SEEK_BAR_ANIMATION_SHORT_DURATION : this.SEEK_BAR_ANIMATION_LONG_DURATION);
        objectAnimatorOfInt.start();
        return true;
    }
}
