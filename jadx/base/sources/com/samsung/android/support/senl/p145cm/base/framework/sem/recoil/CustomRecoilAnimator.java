package com.samsung.android.support.senl.p145cm.base.framework.sem.recoil;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Matrix;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import androidx.appcompat.animation.C0421a;
import androidx.appcompat.animation.C0422b;
import com.samsung.android.support.senl.p145cm.base.C7968R;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\u0018\u0000  2\u00020\u0001:\u0002\u001f B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0010J\u0006\u0010\u0017\u001a\u00020\u0015J\u0006\u0010\u0018\u001a\u00020\u0015J\b\u0010\u001b\u001a\u00020\u0015H\u0002J\u0010\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u000eH\u0002J\u0010\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u000eH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0019\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006!"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/recoil/CustomRecoilAnimator;", "", "mTarget", "Landroid/view/View;", "mContext", "Landroid/content/Context;", "<init>", "(Landroid/view/View;Landroid/content/Context;)V", "mPressDuration", "", "mReleaseDuration", "mScaleSizeDp", "", "mScaleRatio", "", "mIsScaleOnlyChildren", "", "mAnimator", "Landroid/animation/ValueAnimator;", "mIsPressed", "setScaleOnlyChildren", "", "isSet", "setPress", "setRelease", "isActive", "()Z", "setScaleRatioBySize", "setScale", "scaleRatio", "setScaleChildren", "Holder", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class CustomRecoilAnimator {
    private static final int PRESS_INTERPOLATR = C7968R.anim.custom_recoil_pressed;
    private static final int RELEASE_INTERPOLATR = C7968R.anim.custom_recoil_released;

    @Nullable
    private static TimeInterpolator sPressInterpolator;

    @Nullable
    private static TimeInterpolator sReleaseInterpolator;

    @NotNull
    private final ValueAnimator mAnimator;

    @NotNull
    private final Context mContext;
    private boolean mIsPressed;
    private boolean mIsScaleOnlyChildren;
    private final long mPressDuration;
    private final long mReleaseDuration;
    private float mScaleRatio;
    private final int mScaleSizeDp;

    @NotNull
    private View mTarget;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u000fJ\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0006\u0010\u0014\u001a\u00020\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/recoil/CustomRecoilAnimator$Holder;", "", "mContext", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mAnimators", "Ljava/util/ArrayList;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/recoil/CustomRecoilAnimator;", "Lkotlin/collections/ArrayList;", "getMAnimators", "()Ljava/util/ArrayList;", "setMAnimators", "(Ljava/util/ArrayList;)V", "setPress", "", "view", "Landroid/view/View;", "setRelease", "createOrReuseAnimator", "removeAllUpdateListeners", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Holder {

        @NotNull
        private ArrayList<CustomRecoilAnimator> mAnimators;

        @NotNull
        private final Context mContext;

        public Holder(@NotNull Context mContext) {
            Intrinsics.checkNotNullParameter(mContext, "mContext");
            this.mContext = mContext;
            this.mAnimators = new ArrayList<>();
        }

        private final CustomRecoilAnimator createOrReuseAnimator(View view) {
            Iterator<CustomRecoilAnimator> it = this.mAnimators.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                CustomRecoilAnimator next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                CustomRecoilAnimator customRecoilAnimator = next;
                if (customRecoilAnimator.mTarget == view) {
                    return customRecoilAnimator;
                }
            }
            Iterator<CustomRecoilAnimator> it2 = this.mAnimators.iterator();
            Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
            while (it2.hasNext()) {
                CustomRecoilAnimator next2 = it2.next();
                Intrinsics.checkNotNullExpressionValue(next2, "next(...)");
                CustomRecoilAnimator customRecoilAnimator2 = next2;
                if (!customRecoilAnimator2.isActive()) {
                    customRecoilAnimator2.mTarget = view;
                    return customRecoilAnimator2;
                }
            }
            CustomRecoilAnimator customRecoilAnimator3 = new CustomRecoilAnimator(view, this.mContext);
            this.mAnimators.add(customRecoilAnimator3);
            return customRecoilAnimator3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setRelease$lambda$0(CustomRecoilAnimator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
            if (animator.isActive()) {
                animator.setRelease();
            }
        }

        @NotNull
        public final ArrayList<CustomRecoilAnimator> getMAnimators() {
            return this.mAnimators;
        }

        public final void removeAllUpdateListeners() {
            Iterator<CustomRecoilAnimator> it = this.mAnimators.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                CustomRecoilAnimator next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                next.mAnimator.removeAllUpdateListeners();
            }
        }

        public final void setMAnimators(@NotNull ArrayList<CustomRecoilAnimator> arrayList) {
            Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
            this.mAnimators = arrayList;
        }

        public final void setPress(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            if (view.isClickable()) {
                CustomRecoilAnimator customRecoilAnimatorCreateOrReuseAnimator = createOrReuseAnimator(view);
                customRecoilAnimatorCreateOrReuseAnimator.setScaleOnlyChildren(true);
                customRecoilAnimatorCreateOrReuseAnimator.setPress();
            }
        }

        public final void setRelease() {
            this.mAnimators.forEach(new C0422b(3));
        }
    }

    public CustomRecoilAnimator(@NotNull View mTarget, @NotNull Context mContext) {
        Intrinsics.checkNotNullParameter(mTarget, "mTarget");
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        this.mTarget = mTarget;
        this.mContext = mContext;
        this.mPressDuration = 100L;
        this.mReleaseDuration = 350L;
        this.mScaleSizeDp = 3;
        setScaleOnlyChildren(true);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f);
        Intrinsics.checkNotNullExpressionValue(valueAnimatorOfFloat, "ofFloat(...)");
        this.mAnimator = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setCurrentFraction(1.0f);
        if (sPressInterpolator == null) {
            Interpolator interpolatorLoadInterpolator = AnimationUtils.loadInterpolator(mContext, PRESS_INTERPOLATR);
            Intrinsics.checkNotNull(interpolatorLoadInterpolator, "null cannot be cast to non-null type android.animation.TimeInterpolator");
            sPressInterpolator = interpolatorLoadInterpolator;
        }
        if (sReleaseInterpolator == null) {
            Interpolator interpolatorLoadInterpolator2 = AnimationUtils.loadInterpolator(mContext, RELEASE_INTERPOLATR);
            Intrinsics.checkNotNull(interpolatorLoadInterpolator2, "null cannot be cast to non-null type android.animation.TimeInterpolator");
            sReleaseInterpolator = interpolatorLoadInterpolator2;
        }
        valueAnimatorOfFloat.addUpdateListener(new C0421a(this, 15));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(CustomRecoilAnimator customRecoilAnimator, ValueAnimator anim) {
        Intrinsics.checkNotNullParameter(anim, "anim");
        if (customRecoilAnimator.mIsScaleOnlyChildren && (customRecoilAnimator.mTarget instanceof ViewGroup)) {
            Object animatedValue = anim.getAnimatedValue();
            Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
            customRecoilAnimator.setScaleChildren(((Float) animatedValue).floatValue());
        } else {
            Object animatedValue2 = anim.getAnimatedValue();
            Intrinsics.checkNotNull(animatedValue2, "null cannot be cast to non-null type kotlin.Float");
            customRecoilAnimator.setScale(((Float) animatedValue2).floatValue());
        }
    }

    private final void setScale(float scaleRatio) {
        this.mTarget.setScaleX(scaleRatio);
        this.mTarget.setScaleY(scaleRatio);
    }

    private final void setScaleChildren(float scaleRatio) {
        View view = this.mTarget;
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.view.ViewGroup");
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
            if (Build.VERSION.SDK_INT >= 29) {
                childAt.setAnimationMatrix(matrix);
            }
        }
    }

    private final void setScaleRatioBySize() {
        float width = this.mTarget.getWidth();
        this.mScaleRatio = AbstractC0000a.m6c(this.mScaleSizeDp, this.mContext.getResources().getDisplayMetrics().density, width, width);
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
        this.mAnimator.setDuration(this.mPressDuration);
        this.mAnimator.setInterpolator(sPressInterpolator);
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
            this.mAnimator.setDuration(this.mReleaseDuration);
            this.mAnimator.setInterpolator(sReleaseInterpolator);
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
