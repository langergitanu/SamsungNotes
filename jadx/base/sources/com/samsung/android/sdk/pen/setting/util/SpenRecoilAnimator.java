package com.samsung.android.sdk.pen.setting.util;

import android.animation.ValueAnimator;
import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.RequiresApi;
import androidx.appcompat.animation.C0421a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@RequiresApi(api = 34)
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0001\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\tJ\u0006\u0010\u0010\u001a\u00020\u000eJ\u0006\u0010\u0011\u001a\u00020\u000eJ\b\u0010\u0014\u001a\u00020\u000eH\u0002J\u0010\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0007H\u0002J\u0010\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0007H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0012\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0019"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/util/SpenRecoilAnimator;", "", "mTarget", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "mScaleRatio", "", "mIsScaleOnlyChildren", "", "mIsPressed", "mAnimator", "Landroid/animation/ValueAnimator;", "setScaleOnlyChildren", "", "isSet", "setPress", "setRelease", "isActive", "()Z", "setScaleRatioBySize", "setScale", "scaleRatio", "setScaleChildren", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenRecoilAnimator {
    private static final long PRESS_ANIMATION_DURATION = 100;
    private static final long RELEASE_ANIMATION_DURATION = 350;
    private static final long SCALE_SIZE_DP = 3;

    @NotNull
    private static final String TAG = "SpenRecoilAnimator";

    @NotNull
    private final ValueAnimator mAnimator;
    private boolean mIsPressed;
    private boolean mIsScaleOnlyChildren;
    private float mScaleRatio;

    @NotNull
    private final View mTarget;

    public SpenRecoilAnimator(@NotNull View mTarget) {
        Intrinsics.checkNotNullParameter(mTarget, "mTarget");
        this.mTarget = mTarget;
        setScaleOnlyChildren(true);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f);
        this.mAnimator = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setCurrentFraction(1.0f);
        valueAnimatorOfFloat.addUpdateListener(new C0421a(this, 12));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(SpenRecoilAnimator spenRecoilAnimator, ValueAnimator anim) {
        Intrinsics.checkNotNullParameter(anim, "anim");
        if (spenRecoilAnimator.mIsScaleOnlyChildren) {
            Object animatedValue = anim.getAnimatedValue();
            Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
            spenRecoilAnimator.setScaleChildren(((Float) animatedValue).floatValue());
        } else {
            Object animatedValue2 = anim.getAnimatedValue();
            Intrinsics.checkNotNull(animatedValue2, "null cannot be cast to non-null type kotlin.Float");
            spenRecoilAnimator.setScale(((Float) animatedValue2).floatValue());
        }
    }

    private final void setScale(float scaleRatio) {
        this.mTarget.setScaleX(scaleRatio);
        this.mTarget.setScaleY(scaleRatio);
    }

    private final void setScaleChildren(float scaleRatio) {
        View view = this.mTarget;
        if (!(view instanceof ViewGroup)) {
            setScale(scaleRatio);
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            Matrix matrix = new Matrix();
            float f = 2;
            float width = (this.mTarget.getWidth() / f) - childAt.getLeft();
            float height = (this.mTarget.getHeight() / f) - childAt.getTop();
            matrix.setTranslate(-width, -height);
            matrix.postScale(scaleRatio, scaleRatio);
            matrix.postTranslate(width, height);
            childAt.setAnimationMatrix(matrix);
        }
    }

    private final void setScaleRatioBySize() {
        float width = this.mTarget.getWidth();
        this.mScaleRatio = AbstractC0000a.m6c(SCALE_SIZE_DP, this.mTarget.getContext().getResources().getDisplayMetrics().density, width, width);
    }

    public final boolean isActive() {
        return this.mIsPressed || this.mAnimator.isRunning();
    }

    public final void setPress() {
        setScaleRatioBySize();
        if (this.mIsPressed) {
            return;
        }
        this.mIsPressed = true;
        if (this.mAnimator.isRunning()) {
            this.mAnimator.cancel();
        }
        ValueAnimator valueAnimator = this.mAnimator;
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        valueAnimator.setFloatValues(((Float) animatedValue).floatValue(), this.mScaleRatio);
        this.mAnimator.setDuration(100L);
        this.mAnimator.setInterpolator(SpenSettingUtilAnimation.getInterpolator(15));
        this.mAnimator.start();
    }

    public final void setRelease() {
        if (this.mIsPressed) {
            this.mIsPressed = false;
            if (this.mAnimator.isRunning()) {
                this.mAnimator.cancel();
            }
            ValueAnimator valueAnimator = this.mAnimator;
            Object animatedValue = valueAnimator.getAnimatedValue();
            Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
            valueAnimator.setFloatValues(((Float) animatedValue).floatValue(), 1.0f);
            this.mAnimator.setDuration(350L);
            this.mAnimator.setInterpolator(SpenSettingUtilAnimation.getInterpolator(19));
            this.mAnimator.start();
        }
    }

    public final void setScaleOnlyChildren(boolean isSet) {
        if (!(this.mTarget instanceof ViewGroup)) {
            isSet = false;
        }
        this.mIsScaleOnlyChildren = isSet;
    }
}
