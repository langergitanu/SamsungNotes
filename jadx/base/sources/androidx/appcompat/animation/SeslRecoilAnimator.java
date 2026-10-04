package androidx.appcompat.animation;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.C0419R;
import java.util.ArrayList;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(api = 29)
public class SeslRecoilAnimator {
    private static final int PRESS_INTERPOLATR = C0419R.anim.sesl_recoil_pressed;
    private static final int RELEASE_INTERPOLATR = C0419R.anim.sesl_recoil_released;
    private static TimeInterpolator sPressInterpolator;
    private static TimeInterpolator sReleaseInterpolator;
    private final ValueAnimator mAnimator;
    private Context mContext;
    private float mScaleRatio;
    private View mTarget;
    private final long mPressDuration = 100;
    private final long mReleaseDuration = 350;
    private final int mScaleSizeDp = 3;
    private boolean mIsScaleOnlyChildren = false;
    private boolean mIsPressed = false;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Holder {
        ArrayList<SeslRecoilAnimator> mAnimators = new ArrayList<>();
        private final Context mContext;

        public Holder(Context context) {
            this.mContext = context;
        }

        @NonNull
        private SeslRecoilAnimator createOrReuseAnimator(View view) {
            for (SeslRecoilAnimator seslRecoilAnimator : this.mAnimators) {
                if (seslRecoilAnimator.mTarget == view) {
                    return seslRecoilAnimator;
                }
            }
            for (SeslRecoilAnimator seslRecoilAnimator2 : this.mAnimators) {
                if (!seslRecoilAnimator2.isActive()) {
                    seslRecoilAnimator2.mTarget = view;
                    return seslRecoilAnimator2;
                }
            }
            SeslRecoilAnimator seslRecoilAnimator3 = new SeslRecoilAnimator(view, this.mContext);
            this.mAnimators.add(seslRecoilAnimator3);
            return seslRecoilAnimator3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$setRelease$0(SeslRecoilAnimator seslRecoilAnimator) {
            if (seslRecoilAnimator.isActive()) {
                seslRecoilAnimator.setRelease();
            }
        }

        public void removeAllUpdateListeners() {
            for (SeslRecoilAnimator seslRecoilAnimator : this.mAnimators) {
                if (seslRecoilAnimator.isActive()) {
                    seslRecoilAnimator.mAnimator.end();
                }
                seslRecoilAnimator.mAnimator.removeAllUpdateListeners();
            }
            this.mAnimators.clear();
        }

        public void setPress(@NonNull View view) {
            if (view.isClickable()) {
                SeslRecoilAnimator seslRecoilAnimatorCreateOrReuseAnimator = createOrReuseAnimator(view);
                seslRecoilAnimatorCreateOrReuseAnimator.setScaleOnlyChildren(true);
                seslRecoilAnimatorCreateOrReuseAnimator.setPress();
            }
        }

        public void setRelease() {
            this.mAnimators.forEach(new C0422b(0));
        }
    }

    public SeslRecoilAnimator(View view, Context context) {
        int i = 0;
        this.mTarget = view;
        this.mContext = context;
        setScaleOnlyChildren(true);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f);
        this.mAnimator = valueAnimatorOfFloat;
        if (sPressInterpolator == null) {
            sPressInterpolator = AnimationUtils.loadInterpolator(this.mContext, PRESS_INTERPOLATR);
        }
        if (sReleaseInterpolator == null) {
            sReleaseInterpolator = AnimationUtils.loadInterpolator(this.mContext, RELEASE_INTERPOLATR);
        }
        valueAnimatorOfFloat.addUpdateListener(new C0421a(this, i));
        valueAnimatorOfFloat.addListener(new Animator.AnimatorListener() { // from class: androidx.appcompat.animation.SeslRecoilAnimator.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(@NonNull Animator animator) {
                SeslRecoilAnimator.this.animateValue(((Float) ((ValueAnimator) animator).getAnimatedValue()).floatValue());
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(@NonNull Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(@NonNull Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(@NonNull Animator animator) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void animateValue(float f) {
        if (this.mIsScaleOnlyChildren && (this.mTarget instanceof ViewGroup)) {
            setScaleChildren(f);
        } else {
            setScale(f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(ValueAnimator valueAnimator) {
        animateValue(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    private void setScale(float f) {
        this.mTarget.setScaleX(f);
        this.mTarget.setScaleY(f);
    }

    private void setScaleChildren(float f) {
        ViewGroup viewGroup = (ViewGroup) this.mTarget;
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            Matrix matrix = new Matrix();
            float width = (this.mTarget.getWidth() / 2.0f) - childAt.getLeft();
            float height = (this.mTarget.getHeight() / 2.0f) - childAt.getTop();
            matrix.setTranslate(-width, -height);
            matrix.postScale(f, f);
            matrix.postTranslate(width, height);
            childAt.setAnimationMatrix(matrix);
        }
    }

    private void setScaleRatioBySize() {
        float width = this.mTarget.getWidth();
        this.mScaleRatio = AbstractC0000a.m6c(this.mContext.getResources().getDisplayMetrics().density, 3.0f, width, width);
    }

    public boolean isActive() {
        return this.mIsPressed || this.mAnimator.isRunning();
    }

    public void setPress() {
        setScaleRatioBySize();
        if (this.mIsPressed) {
            return;
        }
        this.mIsPressed = true;
        if (this.mAnimator.isRunning()) {
            this.mAnimator.cancel();
        }
        float fFloatValue = ((Float) this.mAnimator.getAnimatedValue()).floatValue();
        ValueAnimator valueAnimator = this.mAnimator;
        if (fFloatValue == 0.0f) {
            fFloatValue = 1.0f;
        }
        valueAnimator.setFloatValues(fFloatValue, this.mScaleRatio);
        this.mAnimator.setDuration(100L);
        this.mAnimator.setInterpolator(sPressInterpolator);
        this.mAnimator.start();
    }

    public void setRelease() {
        if (this.mIsPressed) {
            this.mIsPressed = false;
            if (this.mAnimator.isRunning()) {
                this.mAnimator.cancel();
            }
            ValueAnimator valueAnimator = this.mAnimator;
            valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f);
            this.mAnimator.setDuration(350L);
            this.mAnimator.setInterpolator(sReleaseInterpolator);
            this.mAnimator.start();
        }
    }

    public void setScaleOnlyChildren(boolean z) {
        if (this.mTarget instanceof ViewGroup) {
            this.mIsScaleOnlyChildren = z;
        } else {
            this.mIsScaleOnlyChildren = false;
        }
    }
}
