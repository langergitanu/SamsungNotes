package com.samsung.android.support.senl.p148nt.composer.main.cover.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p148nt.composer.C9086R;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class VIResultView extends View {
    private float mAlpha;
    private AnimContract mAnimContract;
    private int mDuration;

    @ColorInt
    private int mEndColor;
    private Shader mGradient;
    private Matrix mGradientMatrix;
    private Paint mPaint;
    private float mRadius;
    private final RectF mRect;
    private int mRepeatCount;
    private float mRotateAngle;

    @ColorInt
    private int mStartColor;
    private float mStrokeWidth;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface AnimContract {
        void onEnd();

        void onStart();
    }

    public VIResultView(Context context) {
        super(context);
        this.mRect = new RectF();
        this.mRotateAngle = 0.0f;
        this.mAlpha = 0.0f;
        this.mRadius = 0.0f;
        this.mStrokeWidth = 10.0f;
        this.mDuration = 100;
        this.mRepeatCount = 1;
        this.mStartColor = 0;
        this.mEndColor = 0;
        init(context, null, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void endAnimation() {
        animate().alpha(0.0f).setDuration(200L).setInterpolator(new LinearInterpolator()).withEndAction(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.cover.view.VIResultView.4
            @Override // java.lang.Runnable
            public void run() {
                if (VIResultView.this.mAnimContract != null) {
                    VIResultView.this.mAnimContract.onEnd();
                }
            }
        }).start();
    }

    private void init(Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C9086R.styleable.VIResultViewStyle, i, i2);
        try {
            this.mStartColor = typedArrayObtainStyledAttributes.getColor(C9086R.styleable.VIResultViewStyle_vi_startColor, 0);
            this.mEndColor = typedArrayObtainStyledAttributes.getColor(C9086R.styleable.VIResultViewStyle_vi_endColor, 0);
            this.mDuration = typedArrayObtainStyledAttributes.getInt(C9086R.styleable.VIResultViewStyle_vi_duration, this.mDuration);
            this.mRepeatCount = typedArrayObtainStyledAttributes.getInt(C9086R.styleable.VIResultViewStyle_vi_repeatCount, this.mRepeatCount);
            this.mStrokeWidth = typedArrayObtainStyledAttributes.getDimension(C9086R.styleable.VIResultViewStyle_vi_strokeWidth, this.mStrokeWidth);
            this.mRadius = typedArrayObtainStyledAttributes.getDimension(C9086R.styleable.VIResultViewStyle_vi_radius, this.mRadius);
            typedArrayObtainStyledAttributes.recycle();
            Paint paint = new Paint();
            this.mPaint = paint;
            paint.setAntiAlias(true);
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeWidth(TypedValue.applyDimension(1, this.mStrokeWidth, getResources().getDisplayMetrics()));
            this.mGradientMatrix = new Matrix();
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mGradientMatrix.setRotate(this.mRotateAngle, getWidth() >> 1, getHeight() >> 1);
        this.mGradient.setLocalMatrix(this.mGradientMatrix);
        this.mPaint.setShader(this.mGradient);
        setAlpha(this.mAlpha);
        RectF rectF = this.mRect;
        float f = this.mRadius;
        canvas.drawRoundRect(rectF, f, f, this.mPaint);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i4, int i5) {
        super.onSizeChanged(i, i2, i4, i5);
        float f = i;
        float f4 = i2;
        this.mGradient = new LinearGradient(0.0f, 0.0f, f, f4, this.mStartColor, this.mEndColor, Shader.TileMode.CLAMP);
        this.mRect.set(0.0f, 0.0f, f, f4);
    }

    public void setAnimContract(AnimContract animContract) {
        this.mAnimContract = animContract;
    }

    public void startAnimation() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 360.0f);
        valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        valueAnimatorOfFloat.setDuration(this.mDuration);
        valueAnimatorOfFloat.setRepeatCount(this.mRepeatCount);
        valueAnimatorOfFloat.setRepeatMode(1);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.samsung.android.support.senl.nt.composer.main.cover.view.VIResultView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                VIResultView.this.mRotateAngle = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                VIResultView.this.invalidate();
            }
        });
        valueAnimatorOfFloat.addListener(new Animator.AnimatorListener() { // from class: com.samsung.android.support.senl.nt.composer.main.cover.view.VIResultView.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(@NonNull Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(@NonNull Animator animator) {
                VIResultView.this.endAnimation();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(@NonNull Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(@NonNull Animator animator) {
                if (VIResultView.this.mAnimContract != null) {
                    VIResultView.this.mAnimContract.onStart();
                }
            }
        });
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat2.setDuration(1000L);
        valueAnimatorOfFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.samsung.android.support.senl.nt.composer.main.cover.view.VIResultView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                VIResultView.this.mAlpha = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(valueAnimatorOfFloat, valueAnimatorOfFloat2);
        animatorSet.start();
    }

    public VIResultView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRect = new RectF();
        this.mRotateAngle = 0.0f;
        this.mAlpha = 0.0f;
        this.mRadius = 0.0f;
        this.mStrokeWidth = 10.0f;
        this.mDuration = 100;
        this.mRepeatCount = 1;
        this.mStartColor = 0;
        this.mEndColor = 0;
        init(context, attributeSet, 0, 0);
    }

    public VIResultView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRect = new RectF();
        this.mRotateAngle = 0.0f;
        this.mAlpha = 0.0f;
        this.mRadius = 0.0f;
        this.mStrokeWidth = 10.0f;
        this.mDuration = 100;
        this.mRepeatCount = 1;
        this.mStartColor = 0;
        this.mEndColor = 0;
        init(context, attributeSet, i, 0);
    }

    public VIResultView(Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mRect = new RectF();
        this.mRotateAngle = 0.0f;
        this.mAlpha = 0.0f;
        this.mRadius = 0.0f;
        this.mStrokeWidth = 10.0f;
        this.mDuration = 100;
        this.mRepeatCount = 1;
        this.mStartColor = 0;
        this.mEndColor = 0;
        init(context, attributeSet, i, i2);
    }
}
