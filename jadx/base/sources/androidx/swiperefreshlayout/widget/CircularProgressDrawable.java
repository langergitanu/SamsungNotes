package androidx.swiperefreshlayout.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Animatable2;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.swiperefreshlayout.C3870R;
import com.microsoft.identity.common.java.WarningType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(23)
public class CircularProgressDrawable extends Drawable implements Animatable {
    private static final int ANIMATION_DURATION = 200;
    private static final float CENTER_RADIUS = 14.5f;
    private static final float CENTER_RADIUS_LARGE = 20.0f;
    public static final int DEFAULT = 1;
    public static final int LARGE = 0;
    private static final Interpolator LINEAR_INTERPOLATOR = new LinearInterpolator();
    private static final Interpolator MATERIAL_INTERPOLATOR = new FastOutSlowInInterpolator();

    @SuppressLint({WarningType.NewApi})
    private static final Interpolator SINE_OUT_60 = new PathInterpolator(0.17f, 0.17f, 0.4f, 1.0f);
    private OnAnimationEndCallback mAnimationEndCallback = null;
    private Animator mAnimator;
    private Drawable mDotAnimation;
    private final FourDot mFourDot;
    private Resources mResources;
    private Animator mRotateAnimtior;
    private float mRotation;
    float mRotationCount;
    private final float mScreenDensity;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class FourDot {
        int mAlpha;
        float mArrowScale;
        float mCenterRadius;
        int mColorIndex;
        int[] mColors;
        Drawable mDotAnimation;
        final Paint mDotPaint;
        float mDotRadius;
        boolean mIsRunning;
        final Paint mPaint;
        float mPosition;
        float mRotation;
        float mScale;

        public FourDot() {
            Paint paint = new Paint();
            this.mPaint = paint;
            Paint paint2 = new Paint();
            this.mDotPaint = paint2;
            this.mRotation = 0.0f;
            this.mPosition = 0.0f;
            this.mArrowScale = 1.0f;
            this.mScale = 1.0f;
            this.mAlpha = 255;
            Paint.Cap cap = Paint.Cap.SQUARE;
            paint.setStrokeCap(cap);
            paint.setAntiAlias(true);
            Paint.Style style = Paint.Style.FILL;
            paint.setStyle(style);
            paint2.setStrokeCap(cap);
            paint2.setAntiAlias(true);
            paint2.setStyle(style);
        }

        public void draw(Canvas canvas, Rect rect) {
            RectF rectF = new RectF();
            float f = this.mCenterRadius;
            rectF.set(rect.centerX() - f, rect.centerY() - f, rect.centerX() + f, rect.centerY() + f);
            this.mPaint.setColor(this.mColors[0]);
            this.mDotPaint.setColor(this.mColors[1]);
            this.mPaint.setAlpha(this.mAlpha);
            this.mDotPaint.setAlpha(this.mAlpha);
            float f4 = f - this.mScale;
            canvas.rotate(this.mRotation, rectF.centerX(), rectF.centerY());
            if (this.mScale != 0.0f) {
                canvas.drawCircle(rectF.centerX(), rectF.centerY() + this.mPosition, this.mDotRadius, this.mDotPaint);
                canvas.drawCircle(rectF.centerX() - this.mPosition, rectF.centerY(), this.mDotRadius, this.mDotPaint);
                canvas.drawCircle(rectF.centerX() + this.mPosition, rectF.centerY(), this.mDotRadius, this.mDotPaint);
            }
            canvas.drawCircle(rectF.centerX(), rectF.centerY() - this.mPosition, f4, this.mPaint);
            if (this.mIsRunning) {
                this.mDotAnimation.setBounds((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
                this.mDotAnimation.draw(canvas);
            }
        }

        public int getAlpha() {
            return this.mAlpha;
        }

        public float getArrowScale() {
            return this.mArrowScale;
        }

        public float getCenterRadius() {
            return this.mCenterRadius;
        }

        public int[] getColors() {
            return this.mColors;
        }

        public float getRotation() {
            return this.mRotation;
        }

        public int getStartingColor() {
            return this.mColors[this.mColorIndex];
        }

        public void setAlpha(int i) {
            this.mAlpha = i;
        }

        public void setCenterRadius(float f) {
            this.mCenterRadius = f;
        }

        public void setColorFilter(ColorFilter colorFilter) {
            this.mPaint.setColorFilter(colorFilter);
        }

        public void setColors(@NonNull int[] iArr) {
            this.mColors = iArr;
        }

        public void setDotAnimtion(Drawable drawable) {
            this.mDotAnimation = drawable;
        }

        public void setDotRadius(float f) {
            this.mDotRadius = f;
        }

        public void setIsRunning(boolean z) {
            this.mIsRunning = z;
        }

        public void setPosition(float f) {
            this.mPosition = f;
        }

        public void setRotation(float f) {
            this.mRotation = f;
        }

        public void setScale(float f) {
            if (f != this.mScale) {
                this.mScale = f;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public interface OnAnimationEndCallback {
        void OnAnimationEnd();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface ProgressDrawableSize {
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Ring {
        int mAlpha;
        Path mArrow;
        int mArrowHeight;
        final Paint mArrowPaint;
        float mArrowScale;
        int mArrowWidth;
        final Paint mCirclePaint;
        int mColorIndex;
        int[] mColors;
        int mCurrentColor;
        float mEndTrim;
        final Paint mPaint;
        float mRingCenterRadius;
        float mRotation;
        boolean mShowArrow;
        float mStartTrim;
        float mStartingEndTrim;
        float mStartingRotation;
        float mStartingStartTrim;
        float mStrokeWidth;
        final RectF mTempBounds = new RectF();

        public Ring() {
            Paint paint = new Paint();
            this.mPaint = paint;
            Paint paint2 = new Paint();
            this.mArrowPaint = paint2;
            Paint paint3 = new Paint();
            this.mCirclePaint = paint3;
            this.mStartTrim = 0.0f;
            this.mEndTrim = 0.0f;
            this.mRotation = 0.0f;
            this.mStrokeWidth = 5.0f;
            this.mArrowScale = 1.0f;
            this.mAlpha = 255;
            paint.setStrokeCap(Paint.Cap.SQUARE);
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.STROKE);
            paint2.setStyle(Paint.Style.FILL);
            paint2.setAntiAlias(true);
            paint3.setColor(0);
        }

        public void draw(Canvas canvas, Rect rect) {
            RectF rectF = this.mTempBounds;
            float f = this.mRingCenterRadius;
            float fMin = (this.mStrokeWidth / 2.0f) + f;
            if (f <= 0.0f) {
                fMin = (Math.min(rect.width(), rect.height()) / 2.0f) - Math.max((this.mArrowWidth * this.mArrowScale) / 2.0f, this.mStrokeWidth / 2.0f);
            }
            rectF.set(rect.centerX() - fMin, rect.centerY() - fMin, rect.centerX() + fMin, rect.centerY() + fMin);
            float f4 = this.mStartTrim;
            float f5 = this.mRotation;
            float f6 = (f4 + f5) * 360.0f;
            float f7 = ((this.mEndTrim + f5) * 360.0f) - f6;
            this.mPaint.setColor(this.mCurrentColor);
            this.mPaint.setAlpha(this.mAlpha);
            float f8 = this.mStrokeWidth / 2.0f;
            rectF.inset(f8, f8);
            canvas.drawCircle(rectF.centerX(), rectF.centerY(), rectF.width() / 2.0f, this.mCirclePaint);
            float f9 = -f8;
            rectF.inset(f9, f9);
            canvas.drawArc(rectF, f6, f7, false, this.mPaint);
            drawTriangle(canvas, f6, f7, rectF);
        }

        public void drawTriangle(Canvas canvas, float f, float f4, RectF rectF) {
            if (this.mShowArrow) {
                Path path = this.mArrow;
                if (path == null) {
                    Path path2 = new Path();
                    this.mArrow = path2;
                    path2.setFillType(Path.FillType.EVEN_ODD);
                } else {
                    path.reset();
                }
                float fMin = Math.min(rectF.width(), rectF.height()) / 2.0f;
                float f5 = (this.mArrowWidth * this.mArrowScale) / 2.0f;
                this.mArrow.moveTo(0.0f, 0.0f);
                this.mArrow.lineTo(this.mArrowWidth * this.mArrowScale, 0.0f);
                Path path3 = this.mArrow;
                float f6 = this.mArrowWidth;
                float f7 = this.mArrowScale;
                path3.lineTo((f6 * f7) / 2.0f, this.mArrowHeight * f7);
                this.mArrow.offset((rectF.centerX() + fMin) - f5, (this.mStrokeWidth / 2.0f) + rectF.centerY());
                this.mArrow.close();
                this.mArrowPaint.setColor(this.mCurrentColor);
                this.mArrowPaint.setAlpha(this.mAlpha);
                canvas.save();
                canvas.rotate(f + f4, rectF.centerX(), rectF.centerY());
                canvas.drawPath(this.mArrow, this.mArrowPaint);
                canvas.restore();
            }
        }

        public int getAlpha() {
            return this.mAlpha;
        }

        public float getArrowHeight() {
            return this.mArrowHeight;
        }

        public float getArrowScale() {
            return this.mArrowScale;
        }

        public float getArrowWidth() {
            return this.mArrowWidth;
        }

        public int getBackgroundColor() {
            return this.mCirclePaint.getColor();
        }

        public float getCenterRadius() {
            return this.mRingCenterRadius;
        }

        public int[] getColors() {
            return this.mColors;
        }

        public float getEndTrim() {
            return this.mEndTrim;
        }

        public int getNextColor() {
            return this.mColors[getNextColorIndex()];
        }

        public int getNextColorIndex() {
            return (this.mColorIndex + 1) % this.mColors.length;
        }

        public float getRotation() {
            return this.mRotation;
        }

        public boolean getShowArrow() {
            return this.mShowArrow;
        }

        public float getStartTrim() {
            return this.mStartTrim;
        }

        public int getStartingColor() {
            return this.mColors[this.mColorIndex];
        }

        public float getStartingEndTrim() {
            return this.mStartingEndTrim;
        }

        public float getStartingRotation() {
            return this.mStartingRotation;
        }

        public float getStartingStartTrim() {
            return this.mStartingStartTrim;
        }

        public Paint.Cap getStrokeCap() {
            return this.mPaint.getStrokeCap();
        }

        public float getStrokeWidth() {
            return this.mStrokeWidth;
        }

        public void goToNextColor() {
            setColorIndex(getNextColorIndex());
        }

        public void resetOriginals() {
            this.mStartingStartTrim = 0.0f;
            this.mStartingEndTrim = 0.0f;
            this.mStartingRotation = 0.0f;
            setStartTrim(0.0f);
            setEndTrim(0.0f);
            setRotation(0.0f);
        }

        public void setAlpha(int i) {
            this.mAlpha = i;
        }

        public void setArrowDimensions(float f, float f4) {
            this.mArrowWidth = (int) f;
            this.mArrowHeight = (int) f4;
        }

        public void setArrowScale(float f) {
            if (f != this.mArrowScale) {
                this.mArrowScale = f;
            }
        }

        public void setBackgroundColor(int i) {
            this.mCirclePaint.setColor(i);
        }

        public void setCenterRadius(float f) {
            this.mRingCenterRadius = f;
        }

        public void setColor(int i) {
            this.mCurrentColor = i;
        }

        public void setColorFilter(ColorFilter colorFilter) {
            this.mPaint.setColorFilter(colorFilter);
        }

        public void setColorIndex(int i) {
            this.mColorIndex = i;
            this.mCurrentColor = this.mColors[i];
        }

        public void setColors(@NonNull int[] iArr) {
            this.mColors = iArr;
            setColorIndex(0);
        }

        public void setEndTrim(float f) {
            this.mEndTrim = f;
        }

        public void setRotation(float f) {
            this.mRotation = f;
        }

        public void setShowArrow(boolean z) {
            if (this.mShowArrow != z) {
                this.mShowArrow = z;
            }
        }

        public void setStartTrim(float f) {
            this.mStartTrim = f;
        }

        public void setStrokeCap(Paint.Cap cap) {
            this.mPaint.setStrokeCap(cap);
        }

        public void setStrokeWidth(float f) {
            this.mStrokeWidth = f;
            this.mPaint.setStrokeWidth(f);
        }

        public void storeOriginals() {
            this.mStartingStartTrim = this.mStartTrim;
            this.mStartingEndTrim = this.mEndTrim;
            this.mStartingRotation = this.mRotation;
        }
    }

    public CircularProgressDrawable(@NonNull Context context) {
        this.mResources = ((Context) Preconditions.checkNotNull(context)).getResources();
        FourDot fourDot = new FourDot();
        this.mFourDot = fourDot;
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(C3870R.attr.swipeRefreshLayoutTheme, typedValue, true);
        int i = typedValue.resourceId;
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i == 0 ? C3870R.style.SwipeRefreshLayoutThemeOverlay : i);
        TypedArray typedArrayObtainStyledAttributes = contextThemeWrapper.obtainStyledAttributes((AttributeSet) null, C3870R.styleable.SwipeRefreshLayoutProgress);
        fourDot.setColors(new int[]{typedArrayObtainStyledAttributes.getColor(C3870R.styleable.SwipeRefreshLayoutProgress_swipeRefreshCircleDotColor1, context.getResources().getColor(C3870R.color.sesl_swipe_refresh_color1)), typedArrayObtainStyledAttributes.getColor(C3870R.styleable.SwipeRefreshLayoutProgress_swipeRefreshCircleDotColor2, context.getResources().getColor(C3870R.color.sesl_swipe_refresh_color2))});
        typedArrayObtainStyledAttributes.recycle();
        this.mDotAnimation = contextThemeWrapper.getResources().getDrawable(C3870R.drawable.sesl_swipe_refresh_animated, contextThemeWrapper.getTheme());
        this.mScreenDensity = this.mResources.getDisplayMetrics().density;
        this.mDotAnimation.setAlpha(0);
        fourDot.setDotAnimtion(this.mDotAnimation);
        setupAnimators();
    }

    private void setRotation(float f) {
        this.mRotation = f;
    }

    private void setSizeParameters(float f) {
        this.mFourDot.setDotRadius(this.mScreenDensity * 2.5f);
        this.mFourDot.setCenterRadius(f * this.mScreenDensity);
    }

    private void setupAnimators() {
        final FourDot fourDot = this.mFourDot;
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, 90);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 10.0f);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: androidx.swiperefreshlayout.widget.CircularProgressDrawable.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                fourDot.setPosition(CircularProgressDrawable.this.mScreenDensity * fFloatValue);
                fourDot.setScale(((CircularProgressDrawable.this.mScreenDensity * (fFloatValue * 0.75f)) / 10.0f) + (CircularProgressDrawable.this.mScreenDensity * 11.0f));
                CircularProgressDrawable.this.invalidateSelf();
            }
        });
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: androidx.swiperefreshlayout.widget.CircularProgressDrawable.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                fourDot.setRotation(((Integer) valueAnimator.getAnimatedValue()).intValue());
                CircularProgressDrawable.this.invalidateSelf();
            }
        });
        valueAnimatorOfInt.addListener(new Animator.AnimatorListener() { // from class: androidx.swiperefreshlayout.widget.CircularProgressDrawable.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                fourDot.setRotation(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        valueAnimatorOfFloat.setInterpolator(SINE_OUT_60);
        valueAnimatorOfFloat.setDuration(200L);
        valueAnimatorOfInt.setInterpolator(LINEAR_INTERPOLATOR);
        valueAnimatorOfInt.setDuration(200L);
        valueAnimatorOfFloat.addListener(new Animator.AnimatorListener() { // from class: androidx.swiperefreshlayout.widget.CircularProgressDrawable.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                fourDot.setRotation(0.0f);
                fourDot.setIsRunning(true);
                CircularProgressDrawable.this.mDotAnimation.setAlpha(255);
                fourDot.setAlpha(0);
                CircularProgressDrawable.this.startDotAnimation();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                CircularProgressDrawable.this.mRotationCount = 0.0f;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.mAnimator = valueAnimatorOfFloat;
        this.mRotateAnimtior = valueAnimatorOfInt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startDotAnimation() {
        ((AnimatedVectorDrawable) this.mDotAnimation).start();
        ((AnimatedVectorDrawable) this.mDotAnimation).registerAnimationCallback(new Animatable2.AnimationCallback() { // from class: androidx.swiperefreshlayout.widget.CircularProgressDrawable.5
            @Override // android.graphics.drawable.Animatable2.AnimationCallback
            public void onAnimationEnd(Drawable drawable) {
                if (CircularProgressDrawable.this.mAnimationEndCallback != null) {
                    CircularProgressDrawable.this.mAnimationEndCallback.OnAnimationEnd();
                }
                ((AnimatedVectorDrawable) CircularProgressDrawable.this.mDotAnimation).start();
                CircularProgressDrawable.this.invalidateSelf();
            }
        });
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        canvas.save();
        canvas.rotate(this.mRotation, bounds.exactCenterX(), bounds.exactCenterY());
        this.mFourDot.draw(canvas, bounds);
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.mFourDot.getAlpha();
    }

    public float getCenterRadius() {
        return this.mFourDot.getCenterRadius();
    }

    @NonNull
    public int[] getColorSchemeColors() {
        return this.mFourDot.getColors();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public float getProgressRotation() {
        return this.mFourDot.getRotation();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.mAnimator.isRunning() || ((AnimatedVectorDrawable) this.mDotAnimation).isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.mFourDot.setAlpha(i);
        invalidateSelf();
    }

    public void setCenterRadius(float f) {
        this.mFourDot.setCenterRadius(f);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.mFourDot.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public void setColorSchemeColors(@NonNull int... iArr) {
        this.mFourDot.setColors(iArr);
        invalidateSelf();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setOnAnimationEndCallback(@Nullable OnAnimationEndCallback onAnimationEndCallback) {
        this.mAnimationEndCallback = onAnimationEndCallback;
    }

    public void setProgressRotation(float f) {
        this.mFourDot.setRotation(f);
        invalidateSelf();
    }

    public void setScale(float f) {
        if (f == 0.0f) {
            this.mFourDot.setScale(0.0f);
        } else {
            FourDot fourDot = this.mFourDot;
            float f4 = this.mScreenDensity;
            fourDot.setScale(Math.min(f * 11.0f * f4, f4 * 11.0f));
        }
        invalidateSelf();
    }

    public void setStrokeWidth(float f) {
        new Ring().setStrokeWidth(f);
        invalidateSelf();
    }

    public void setStyle(int i) {
        if (i == 0) {
            setSizeParameters(20.0f);
        } else {
            setSizeParameters(CENTER_RADIUS);
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.mAnimator.cancel();
        this.mRotateAnimtior.cancel();
        this.mAnimator.start();
        this.mRotateAnimtior.start();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        ((AnimatedVectorDrawable) this.mDotAnimation).stop();
        ((AnimatedVectorDrawable) this.mDotAnimation).clearAnimationCallbacks();
        this.mDotAnimation.setAlpha(0);
        this.mFourDot.setPosition(0.0f);
        this.mFourDot.setIsRunning(false);
        this.mAnimator.cancel();
        this.mRotateAnimtior.cancel();
        setRotation(0.0f);
        invalidateSelf();
    }
}
