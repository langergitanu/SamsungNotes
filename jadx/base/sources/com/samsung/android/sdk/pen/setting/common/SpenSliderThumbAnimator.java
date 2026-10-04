package com.samsung.android.sdk.pen.setting.common;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.animation.C0421a;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilAnimation;
import com.samsung.android.spen.C7932R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\b\u0001\u0018\u0000 \"2\u00020\u0001:\u0001\"B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0018J\b\u0010\u0019\u001a\u00020\u0015H\u0002J\b\u0010\u001a\u001a\u00020\u0015H\u0002J\b\u0010\u001b\u001a\u00020\u0015H\u0002J\b\u0010\u001c\u001a\u00020\u0015H\u0002J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020!H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/common/SpenSliderThumbAnimator;", "", "mContext", "Landroid/content/Context;", "mLabelTextView", "Landroid/widget/TextView;", "mStrokeSizeView", "Landroid/widget/RelativeLayout;", "mBackgroundView", "Landroid/view/View;", "<init>", "(Landroid/content/Context;Landroid/widget/TextView;Landroid/widget/RelativeLayout;Landroid/view/View;)V", "mExpandThumbAnimator", "Landroid/animation/AnimatorSet;", "mShrinkThumbAnimator", "mTranslateDeltaY", "", "mBackgroundHeightDefault", "", "mBackgroundHeightExpand", "close", "", "setOnTouchEvent", "event", "Landroid/view/MotionEvent;", "initAnimator", "startExpandThumbAnimator", "startShrinkThumbAnimator", "cancelAnimator", "createBackgroundValueAnimator", "Landroid/animation/ValueAnimator;", "newHeight", XmlErrorCodes.DURATION, "", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SuppressLint({"LongLogTag"})
public final class SpenSliderThumbAnimator {
    private static final int ALPHA_HIDE_DURATION = 100;
    private static final int ALPHA_SHOW_DURATION = 200;

    @NotNull
    private static final String TAG = "SpenSliderThumbAnimation";
    private static final int TRANSLATE_HIDE_DURATION = 300;
    private static final int TRANSLATE_SHOW_DURATION = 400;
    private final int mBackgroundHeightDefault;
    private final int mBackgroundHeightExpand;

    @NotNull
    private final View mBackgroundView;
    private AnimatorSet mExpandThumbAnimator;

    @NotNull
    private final TextView mLabelTextView;
    private AnimatorSet mShrinkThumbAnimator;

    @NotNull
    private final RelativeLayout mStrokeSizeView;
    private final float mTranslateDeltaY;

    public SpenSliderThumbAnimator(@NotNull Context mContext, @NotNull TextView mLabelTextView, @NotNull RelativeLayout mStrokeSizeView, @NotNull View mBackgroundView) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        Intrinsics.checkNotNullParameter(mLabelTextView, "mLabelTextView");
        Intrinsics.checkNotNullParameter(mStrokeSizeView, "mStrokeSizeView");
        Intrinsics.checkNotNullParameter(mBackgroundView, "mBackgroundView");
        this.mLabelTextView = mLabelTextView;
        this.mStrokeSizeView = mStrokeSizeView;
        this.mBackgroundView = mBackgroundView;
        this.mTranslateDeltaY = mContext.getResources().getDimensionPixelSize(C7932R.dimen.setting_seek_bar_translateY);
        this.mBackgroundHeightDefault = mContext.getResources().getDimensionPixelSize(C7932R.dimen.floating_thumb_height);
        this.mBackgroundHeightExpand = mContext.getResources().getDimensionPixelSize(C7932R.dimen.floating_thumb_height_move);
        initAnimator();
    }

    private final void cancelAnimator() {
        AnimatorSet animatorSet = this.mExpandThumbAnimator;
        AnimatorSet animatorSet2 = null;
        if (animatorSet == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mExpandThumbAnimator");
            animatorSet = null;
        }
        if (animatorSet.isRunning()) {
            AnimatorSet animatorSet3 = this.mExpandThumbAnimator;
            if (animatorSet3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mExpandThumbAnimator");
                animatorSet3 = null;
            }
            animatorSet3.cancel();
        }
        AnimatorSet animatorSet4 = this.mShrinkThumbAnimator;
        if (animatorSet4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mShrinkThumbAnimator");
            animatorSet4 = null;
        }
        if (animatorSet4.isRunning()) {
            AnimatorSet animatorSet5 = this.mShrinkThumbAnimator;
            if (animatorSet5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mShrinkThumbAnimator");
            } else {
                animatorSet2 = animatorSet5;
            }
            animatorSet2.cancel();
        }
    }

    private final ValueAnimator createBackgroundValueAnimator(float newHeight, long duration) {
        Intrinsics.checkNotNull(this.mBackgroundView.getLayoutParams(), "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(((RelativeLayout.LayoutParams) r0).height, newHeight);
        valueAnimatorOfFloat.setInterpolator(SpenSettingUtilAnimation.getInterpolator(11));
        valueAnimatorOfFloat.setDuration(duration);
        valueAnimatorOfFloat.addUpdateListener(new C0421a(this, 6));
        Intrinsics.checkNotNull(valueAnimatorOfFloat);
        return valueAnimatorOfFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createBackgroundValueAnimator$lambda$0(SpenSliderThumbAnimator spenSliderThumbAnimator, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        ViewGroup.LayoutParams layoutParams = spenSliderThumbAnimator.mBackgroundView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        Object animatedValue = animation.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        layoutParams2.height = (int) ((Float) animatedValue).floatValue();
        spenSliderThumbAnimator.mBackgroundView.setLayoutParams(layoutParams2);
    }

    private final void initAnimator() {
        AnimatorSet animatorSet = new AnimatorSet();
        this.mExpandThumbAnimator = animatorSet;
        animatorSet.setInterpolator(SpenSettingUtilAnimation.getInterpolator(11));
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.mShrinkThumbAnimator = animatorSet2;
        animatorSet2.setInterpolator(SpenSettingUtilAnimation.getInterpolator(11));
    }

    private final void startExpandThumbAnimator() {
        cancelAnimator();
        RelativeLayout relativeLayout = this.mStrokeSizeView;
        ObjectAnimator duration = ObjectAnimator.ofFloat(relativeLayout, "alpha", relativeLayout.getAlpha(), 1.0f).setDuration(200L);
        Intrinsics.checkNotNullExpressionValue(duration, "setDuration(...)");
        RelativeLayout relativeLayout2 = this.mStrokeSizeView;
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(relativeLayout2, "translationY", relativeLayout2.getTranslationY(), -this.mTranslateDeltaY).setDuration(400L);
        Intrinsics.checkNotNullExpressionValue(duration2, "setDuration(...)");
        TextView textView = this.mLabelTextView;
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(textView, "translationY", textView.getTranslationY(), -this.mTranslateDeltaY).setDuration(400L);
        Intrinsics.checkNotNullExpressionValue(duration3, "setDuration(...)");
        ValueAnimator valueAnimatorCreateBackgroundValueAnimator = createBackgroundValueAnimator(this.mBackgroundHeightExpand, 400L);
        AnimatorSet animatorSet = this.mExpandThumbAnimator;
        AnimatorSet animatorSet2 = null;
        if (animatorSet == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mExpandThumbAnimator");
            animatorSet = null;
        }
        animatorSet.playTogether(duration, duration2, duration3, valueAnimatorCreateBackgroundValueAnimator);
        AnimatorSet animatorSet3 = this.mExpandThumbAnimator;
        if (animatorSet3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mExpandThumbAnimator");
        } else {
            animatorSet2 = animatorSet3;
        }
        animatorSet2.start();
    }

    private final void startShrinkThumbAnimator() {
        cancelAnimator();
        RelativeLayout relativeLayout = this.mStrokeSizeView;
        ObjectAnimator duration = ObjectAnimator.ofFloat(relativeLayout, "alpha", relativeLayout.getAlpha(), 0.0f).setDuration(100L);
        Intrinsics.checkNotNullExpressionValue(duration, "setDuration(...)");
        RelativeLayout relativeLayout2 = this.mStrokeSizeView;
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(relativeLayout2, "translationY", relativeLayout2.getTranslationY(), 0.0f).setDuration(300L);
        Intrinsics.checkNotNullExpressionValue(duration2, "setDuration(...)");
        TextView textView = this.mLabelTextView;
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(textView, "translationY", textView.getTranslationY(), 0.0f).setDuration(300L);
        Intrinsics.checkNotNullExpressionValue(duration3, "setDuration(...)");
        ValueAnimator valueAnimatorCreateBackgroundValueAnimator = createBackgroundValueAnimator(this.mBackgroundHeightDefault, 300L);
        AnimatorSet animatorSet = this.mShrinkThumbAnimator;
        AnimatorSet animatorSet2 = null;
        if (animatorSet == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mShrinkThumbAnimator");
            animatorSet = null;
        }
        animatorSet.playTogether(duration, duration2, duration3, valueAnimatorCreateBackgroundValueAnimator);
        AnimatorSet animatorSet3 = this.mShrinkThumbAnimator;
        if (animatorSet3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mShrinkThumbAnimator");
        } else {
            animatorSet2 = animatorSet3;
        }
        animatorSet2.start();
    }

    public final void close() {
        cancelAnimator();
    }

    public final void setOnTouchEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Log.i(TAG, "setOnTouchEvent() event= " + event.getAction());
        int action = event.getAction();
        if (action == 0) {
            startExpandThumbAnimator();
        } else if (action == 1 || action == 3) {
            startShrinkThumbAnimator();
        }
    }
}
