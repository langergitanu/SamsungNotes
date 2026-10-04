package androidx.appcompat.widget;

import android.R;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.AbsSeekBar;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.C0419R;
import androidx.appcompat.animation.SeslAnimationUtils;
import androidx.appcompat.graphics.drawable.DrawableWrapperCompat;
import androidx.appcompat.util.SeslMisc;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.reflect.view.SeslHapticFeedbackConstantsReflector;
import androidx.reflect.view.SeslViewReflector;
import androidx.reflect.widget.SeslHoverPopupWindowReflector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(24)
public abstract class SeslAbsSeekBar extends SeslProgressBar {
    private static final int HOVER_DETECT_TIME = 200;
    private static final int HOVER_POPUP_WINDOW_GRAVITY_CENTER_HORIZONTAL_ON_POINT = 513;
    private static final int HOVER_POPUP_WINDOW_GRAVITY_TOP_ABOVE = 12336;
    private static final int MUTE_VIB_DISTANCE_LVL = 400;
    private static final int MUTE_VIB_DURATION = 500;
    private static final int MUTE_VIB_TOTAL = 4;
    private static final int NO_ALPHA = 255;
    static final float SCALE_FACTOR = 1000.0f;
    private static final String TAG = "SeslAbsSeekBar";
    private boolean mAllowedSeekBarAnimation;
    private int mCurrentProgressLevel;
    private ColorStateList mDefaultActivatedProgressColor;
    private ColorStateList mDefaultActivatedThumbColor;
    private ColorStateList mDefaultNormalProgressColor;
    private ColorStateList mDefaultSecondaryProgressColor;
    private float mDisabledAlpha;
    private Drawable mDivider;
    private final List<Rect> mGestureExclusionRects;
    private boolean mHasThumbTint;
    private boolean mHasThumbTintMode;
    private boolean mHasTickMarkTint;
    private boolean mHasTickMarkTintMode;
    private int mHoveringLevel;
    private boolean mIsDragging;
    private boolean mIsDraggingForSliding;
    private boolean mIsFirstSetProgress;
    private boolean mIsHapticEnabled;
    private boolean mIsLightTheme;
    boolean mIsSeamless;
    private boolean mIsSetModeCalled;
    private boolean mIsTouchDisabled;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    boolean mIsUserSeekable;
    private int mKeyProgressIncrement;
    private boolean mLargeFont;
    private Drawable mLevelBarThumbDrawable;
    private float mLevelDrawPadding;
    private int mModeExpandThumbRadius;
    private int mModeExpandTrackMaxWidth;
    private int mModeExpandTrackMinWidth;
    private AnimatorSet mMuteAnimationSet;
    private ColorStateList mOverlapActivatedProgressColor;
    private Drawable mOverlapBackground;
    private ColorStateList mOverlapNormalProgressColor;
    private int mOverlapPoint;
    private int mPreviousHoverPopupType;
    private int mScaledTouchSlop;
    private boolean mSetDualColorMode;
    private Drawable mSplitProgress;
    private boolean mSplitTrack;
    private final Rect mTempRect;
    private Drawable mThumb;
    private int mThumbOffset;
    private int mThumbPosX;
    private int mThumbRadius;
    private final Rect mThumbRect;
    private ColorStateList mThumbTintList;
    private PorterDuff.Mode mThumbTintMode;
    private Drawable mTickMark;
    private ColorStateList mTickMarkTintList;
    private PorterDuff.Mode mTickMarkTintMode;
    private float mTouchDownX;
    private float mTouchDownY;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    float mTouchProgressOffset;
    private int mTrackMaxWidth;
    private int mTrackMinWidth;
    private boolean mUseMuteAnimation;
    private List<Rect> mUserGestureExclusionRects;
    private ValueAnimator mValueAnimator;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class SliderDrawable extends Drawable {
        private static final int ANIMATION_DURATION = 250;
        int mAlpha;

        @ColorInt
        int mColor;
        ColorStateList mColorStateList;
        private boolean mIsStateChanged;
        private boolean mIsVertical;
        private final Paint mPaint;
        ValueAnimator mPressedAnimator;
        private float mRadius;
        ValueAnimator mReleasedAnimator;
        private final float mSliderMaxWidth;
        private final float mSliderMinWidth;
        private final SliderState mState;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public class SliderState extends Drawable.ConstantState {
            private SliderState() {
            }

            @Override // android.graphics.drawable.Drawable.ConstantState
            public int getChangingConfigurations() {
                return 0;
            }

            @Override // android.graphics.drawable.Drawable.ConstantState
            @NonNull
            public Drawable newDrawable() {
                return SliderDrawable.this;
            }
        }

        public SliderDrawable(SeslAbsSeekBar seslAbsSeekBar, float f, float f4, ColorStateList colorStateList) {
            this(f, f4, colorStateList, false);
        }

        private void initAnimator() {
            float f = this.mSliderMinWidth;
            float f4 = this.mSliderMaxWidth;
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f, f4);
            this.mPressedAnimator = valueAnimatorOfFloat;
            valueAnimatorOfFloat.setDuration(250L);
            ValueAnimator valueAnimator = this.mPressedAnimator;
            Interpolator interpolator = SeslAnimationUtils.SINE_IN_OUT_80;
            valueAnimator.setInterpolator(interpolator);
            this.mPressedAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: androidx.appcompat.widget.SeslAbsSeekBar.SliderDrawable.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    SliderDrawable.this.invalidateTrack(((Float) valueAnimator2.getAnimatedValue()).floatValue());
                }
            });
            ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(f4, f);
            this.mReleasedAnimator = valueAnimatorOfFloat2;
            valueAnimatorOfFloat2.setDuration(250L);
            this.mReleasedAnimator.setInterpolator(interpolator);
            this.mReleasedAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: androidx.appcompat.widget.SeslAbsSeekBar.SliderDrawable.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    SliderDrawable.this.invalidateTrack(((Float) valueAnimator2.getAnimatedValue()).floatValue());
                }
            });
        }

        private int modulateAlpha(int i, int i2) {
            return ((i2 + (i2 >>> 7)) * i) >>> 8;
        }

        private void startPressedAnimation() {
            if (this.mPressedAnimator.isRunning()) {
                return;
            }
            if (this.mReleasedAnimator.isRunning()) {
                this.mReleasedAnimator.cancel();
            }
            this.mPressedAnimator.setFloatValues(this.mSliderMinWidth, this.mSliderMaxWidth);
            this.mPressedAnimator.start();
        }

        private void startReleasedAnimation() {
            if (this.mReleasedAnimator.isRunning()) {
                return;
            }
            if (this.mPressedAnimator.isRunning()) {
                this.mPressedAnimator.cancel();
            }
            this.mReleasedAnimator.setFloatValues(this.mSliderMaxWidth, this.mSliderMinWidth);
            this.mReleasedAnimator.start();
        }

        private void startSliderAnimation(boolean z) {
            if (this.mIsStateChanged != z) {
                if (z) {
                    startPressedAnimation();
                } else {
                    startReleasedAnimation();
                }
                this.mIsStateChanged = z;
            }
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            int alpha = this.mPaint.getAlpha();
            this.mPaint.setAlpha(modulateAlpha(alpha, this.mAlpha));
            canvas.save();
            if (this.mIsVertical) {
                float width = (SeslAbsSeekBar.this.getWidth() - SeslAbsSeekBar.this.getPaddingLeft()) - SeslAbsSeekBar.this.getPaddingRight();
                float height = (SeslAbsSeekBar.this.getHeight() - SeslAbsSeekBar.this.getPaddingTop()) - SeslAbsSeekBar.this.getPaddingBottom();
                float f = this.mRadius;
                float f4 = width / 2.0f;
                canvas.drawLine(f4, height - f, f4, f, this.mPaint);
            } else {
                float width2 = (SeslAbsSeekBar.this.getWidth() - SeslAbsSeekBar.this.getPaddingLeft()) - SeslAbsSeekBar.this.getPaddingRight();
                float f5 = this.mRadius;
                canvas.drawLine(f5, SeslAbsSeekBar.this.getHeight() / 2.0f, width2 - f5, SeslAbsSeekBar.this.getHeight() / 2.0f, this.mPaint);
            }
            canvas.restore();
            this.mPaint.setAlpha(alpha);
        }

        @Override // android.graphics.drawable.Drawable
        @Nullable
        public Drawable.ConstantState getConstantState() {
            return this.mState;
        }

        @Override // android.graphics.drawable.Drawable
        public int getIntrinsicHeight() {
            return (int) this.mSliderMaxWidth;
        }

        @Override // android.graphics.drawable.Drawable
        public int getIntrinsicWidth() {
            return (int) this.mSliderMaxWidth;
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            Paint paint = this.mPaint;
            if (paint.getXfermode() != null) {
                return -3;
            }
            int alpha = paint.getAlpha();
            if (alpha == 0) {
                return -2;
            }
            return alpha == 255 ? -1 : -3;
        }

        public void invalidateTrack(float f) {
            setStrokeWidth(f);
            invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable
        public boolean isStateful() {
            return true;
        }

        @Override // android.graphics.drawable.Drawable
        public boolean onStateChange(int[] iArr) {
            boolean zOnStateChange = super.onStateChange(iArr);
            int colorForState = this.mColorStateList.getColorForState(iArr, this.mColor);
            if (this.mColor != colorForState) {
                this.mColor = colorForState;
                this.mPaint.setColor(colorForState);
                invalidateSelf();
            }
            boolean z = false;
            boolean z2 = false;
            boolean z3 = false;
            for (int i : iArr) {
                if (i == 16842910) {
                    z2 = true;
                } else if (i == 16842919) {
                    z3 = true;
                }
            }
            if (z2 && z3) {
                z = true;
            }
            startSliderAnimation(z);
            return zOnStateChange;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i) {
            this.mAlpha = i;
            invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(@Nullable ColorFilter colorFilter) {
            this.mPaint.setColorFilter(colorFilter);
            invalidateSelf();
        }

        public void setStrokeWidth(float f) {
            this.mPaint.setStrokeWidth(f);
            this.mRadius = f / 2.0f;
        }

        @Override // android.graphics.drawable.Drawable
        public void setTintList(@Nullable ColorStateList colorStateList) {
            super.setTintList(colorStateList);
            if (colorStateList != null) {
                this.mColorStateList = colorStateList;
                int defaultColor = colorStateList.getDefaultColor();
                this.mColor = defaultColor;
                this.mPaint.setColor(defaultColor);
                invalidateSelf();
            }
        }

        public SliderDrawable(float f, float f4, ColorStateList colorStateList, boolean z) {
            Paint paint = new Paint();
            this.mPaint = paint;
            this.mIsStateChanged = false;
            this.mAlpha = 255;
            this.mState = new SliderState();
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeCap(Paint.Cap.ROUND);
            this.mColorStateList = colorStateList;
            int defaultColor = colorStateList.getDefaultColor();
            this.mColor = defaultColor;
            paint.setColor(defaultColor);
            paint.setStrokeWidth(f);
            this.mSliderMinWidth = f;
            this.mSliderMaxWidth = f4;
            this.mRadius = f / 2.0f;
            this.mIsVertical = z;
            initAnimator();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class ThumbDrawable extends Drawable {
        private static final int PRESSED_DURATION = 100;
        private static final int RELEASED_DURATION = 300;
        private int mAlpha;

        @ColorInt
        int mColor;
        private ColorStateList mColorStateList;
        private boolean mIsStateChanged;
        private boolean mIsVertical;
        private final Paint mPaint;
        private final Paint mPaintInner;
        private final int mRadius;
        private int mRadiusForAni;
        private final int mStrokeWidth;
        private ValueAnimator mThumbPressed;
        private ValueAnimator mThumbReleased;

        public ThumbDrawable(int i, ColorStateList colorStateList, boolean z) {
            Paint paint = new Paint(1);
            this.mPaint = paint;
            Paint paint2 = new Paint(1);
            this.mPaintInner = paint2;
            this.mIsStateChanged = false;
            this.mAlpha = 255;
            this.mIsVertical = false;
            this.mStrokeWidth = SeslAbsSeekBar.this.getContext().getResources().getDimensionPixelSize(C0419R.dimen.sesl_seekbar_thumb_stroke);
            this.mRadiusForAni = i;
            this.mRadius = i;
            this.mColorStateList = colorStateList;
            this.mColor = colorStateList.getDefaultColor();
            Paint.Style style = Paint.Style.FILL;
            paint.setStyle(style);
            paint2.setStyle(style);
            paint.setColor(this.mColor);
            paint2.setColor(SeslAbsSeekBar.this.getContext().getResources().getColor(C0419R.color.sesl_thumb_control_fill_color_activated));
            this.mIsVertical = z;
            initAnimation();
        }

        private int modulateAlpha(int i, int i2) {
            return ((i2 + (i2 >>> 7)) * i) >>> 8;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRadius(int i) {
            this.mRadiusForAni = i;
        }

        private void startPressedAnimation() {
            if (this.mThumbPressed.isRunning()) {
                return;
            }
            if (this.mThumbReleased.isRunning()) {
                this.mThumbReleased.cancel();
            }
            this.mThumbPressed.start();
        }

        private void startReleasedAnimation() {
            if (this.mThumbReleased.isRunning()) {
                return;
            }
            if (this.mThumbPressed.isRunning()) {
                this.mThumbPressed.cancel();
            }
            this.mThumbReleased.start();
        }

        private void startThumbAnimation(boolean z) {
            if (this.mIsStateChanged != z) {
                if (z) {
                    startPressedAnimation();
                } else {
                    startReleasedAnimation();
                }
                this.mIsStateChanged = z;
            }
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(@NonNull Canvas canvas) {
            int alpha = this.mPaint.getAlpha();
            this.mPaint.setAlpha(modulateAlpha(alpha, this.mAlpha));
            this.mPaintInner.setAlpha(modulateAlpha(alpha, this.mAlpha));
            canvas.save();
            if (this.mIsVertical) {
                float width = ((SeslAbsSeekBar.this.getWidth() - SeslAbsSeekBar.this.getPaddingLeft()) - SeslAbsSeekBar.this.getPaddingRight()) / 2.0f;
                canvas.drawCircle(width, SeslAbsSeekBar.this.mThumbPosX - SeslAbsSeekBar.this.getPaddingLeft(), this.mRadiusForAni, this.mPaint);
                canvas.drawCircle(width, SeslAbsSeekBar.this.mThumbPosX - SeslAbsSeekBar.this.getPaddingLeft(), this.mRadiusForAni - this.mStrokeWidth, this.mPaintInner);
            } else {
                canvas.drawCircle(SeslAbsSeekBar.this.mThumbPosX, SeslAbsSeekBar.this.getHeight() / 2.0f, this.mRadiusForAni, this.mPaint);
                canvas.drawCircle(SeslAbsSeekBar.this.mThumbPosX, SeslAbsSeekBar.this.getHeight() / 2.0f, this.mRadiusForAni - this.mStrokeWidth, this.mPaintInner);
            }
            canvas.restore();
            this.mPaint.setAlpha(alpha);
            this.mPaintInner.setAlpha(alpha);
        }

        @Override // android.graphics.drawable.Drawable
        public int getIntrinsicHeight() {
            return this.mRadius * 2;
        }

        @Override // android.graphics.drawable.Drawable
        public int getIntrinsicWidth() {
            return this.mRadius * 2;
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            Paint paint = this.mPaint;
            if (paint.getXfermode() != null) {
                return -3;
            }
            int alpha = paint.getAlpha();
            if (alpha == 0) {
                return -2;
            }
            return alpha == 255 ? -1 : -3;
        }

        public void initAnimation() {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.mRadius, 0.0f);
            this.mThumbPressed = valueAnimatorOfFloat;
            valueAnimatorOfFloat.setDuration(100L);
            this.mThumbPressed.setInterpolator(new LinearInterpolator());
            this.mThumbPressed.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: androidx.appcompat.widget.SeslAbsSeekBar.ThumbDrawable.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    ThumbDrawable.this.setRadius((int) ((Float) valueAnimator.getAnimatedValue()).floatValue());
                    ThumbDrawable.this.invalidateSelf();
                }
            });
            ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(0.0f, this.mRadius);
            this.mThumbReleased = valueAnimatorOfFloat2;
            valueAnimatorOfFloat2.setDuration(300L);
            this.mThumbReleased.setInterpolator(SeslAnimationUtils.SINE_IN_OUT_90);
            this.mThumbReleased.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: androidx.appcompat.widget.SeslAbsSeekBar.ThumbDrawable.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    ThumbDrawable.this.setRadius((int) ((Float) valueAnimator.getAnimatedValue()).floatValue());
                    ThumbDrawable.this.invalidateSelf();
                }
            });
        }

        @Override // android.graphics.drawable.Drawable
        public boolean isStateful() {
            return true;
        }

        @Override // android.graphics.drawable.Drawable
        public boolean onStateChange(int[] iArr) {
            boolean zOnStateChange = super.onStateChange(iArr);
            int colorForState = this.mColorStateList.getColorForState(iArr, this.mColor);
            if (this.mColor != colorForState) {
                this.mColor = colorForState;
                this.mPaint.setColor(colorForState);
                invalidateSelf();
            }
            boolean z = false;
            boolean z2 = false;
            boolean z3 = false;
            for (int i : iArr) {
                if (i == 16842910) {
                    z2 = true;
                } else if (i == 16842919) {
                    z3 = true;
                }
            }
            if (z2 && z3) {
                z = true;
            }
            startThumbAnimation(z);
            return zOnStateChange;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i) {
            this.mAlpha = i;
            invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(@Nullable ColorFilter colorFilter) {
            this.mPaint.setColorFilter(colorFilter);
            invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable
        public void setTintList(@Nullable ColorStateList colorStateList) {
            super.setTintList(colorStateList);
            if (colorStateList != null) {
                this.mColorStateList = colorStateList;
                int colorForState = colorStateList.getColorForState(SeslAbsSeekBar.this.getDrawableState(), this.mColor);
                this.mColor = colorForState;
                this.mPaint.setColor(colorForState);
                invalidateSelf();
            }
        }
    }

    public SeslAbsSeekBar(Context context) {
        super(context);
        this.mTempRect = new Rect();
        this.mThumbTintList = null;
        this.mThumbTintMode = null;
        this.mHasThumbTint = false;
        this.mHasThumbTintMode = false;
        this.mTickMarkTintList = null;
        this.mTickMarkTintMode = null;
        this.mHasTickMarkTint = false;
        this.mHasTickMarkTintMode = false;
        this.mIsUserSeekable = true;
        this.mKeyProgressIncrement = 1;
        this.mUserGestureExclusionRects = Collections.EMPTY_LIST;
        this.mGestureExclusionRects = new ArrayList();
        this.mThumbRect = new Rect();
        this.mHoveringLevel = 0;
        this.mOverlapPoint = -1;
        this.mAllowedSeekBarAnimation = false;
        this.mUseMuteAnimation = false;
        this.mIsFirstSetProgress = false;
        this.mIsDraggingForSliding = false;
        this.mLargeFont = false;
        this.mIsTouchDisabled = false;
        this.mSetDualColorMode = false;
        this.mPreviousHoverPopupType = 0;
        this.mIsSetModeCalled = false;
        this.mIsSeamless = false;
        this.mLevelDrawPadding = 0.0f;
    }

    private void applyThumbTint() {
        Drawable drawable = this.mThumb;
        if (drawable != null) {
            if (this.mHasThumbTint || this.mHasThumbTintMode) {
                Drawable drawableMutate = drawable.mutate();
                this.mThumb = drawableMutate;
                if (this.mHasThumbTint) {
                    DrawableCompat.setTintList(drawableMutate, this.mThumbTintList);
                }
                if (this.mHasThumbTintMode) {
                    DrawableCompat.setTintMode(this.mThumb, this.mThumbTintMode);
                }
                if (this.mThumb.isStateful()) {
                    this.mThumb.setState(getDrawableState());
                }
            }
        }
    }

    private void applyTickMarkTint() {
        Drawable drawable = this.mTickMark;
        if (drawable != null) {
            if (this.mHasTickMarkTint || this.mHasTickMarkTintMode) {
                Drawable drawableMutate = drawable.mutate();
                this.mTickMark = drawableMutate;
                if (this.mHasTickMarkTint) {
                    DrawableCompat.setTintList(drawableMutate, this.mTickMarkTintList);
                }
                if (this.mHasTickMarkTintMode) {
                    DrawableCompat.setTintMode(this.mTickMark, this.mTickMarkTintMode);
                }
                if (this.mTickMark.isStateful()) {
                    this.mTickMark.setState(getDrawableState());
                }
            }
        }
    }

    private void attemptClaimDrag() {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callSuperSetProgress(int i) {
        super.setProgress(i);
    }

    private void cancelMuteAnimation() {
        AnimatorSet animatorSet = this.mMuteAnimationSet;
        if (animatorSet == null || !animatorSet.isRunning()) {
            return;
        }
        this.mMuteAnimationSet.cancel();
    }

    private boolean checkInvalidatedDualColorMode() {
        return this.mOverlapPoint == -1 || this.mOverlapBackground == null;
    }

    private ColorStateList colorToColorStateList(int i) {
        return new ColorStateList(new int[][]{new int[0]}, new int[]{i});
    }

    private int getHoverPopupType() {
        return SeslViewReflector.semGetHoverPopupType(this);
    }

    private float getScale() {
        int max = getMax() - getMin();
        if (max > 0) {
            return (getProgress() - r0) / max;
        }
        return 0.0f;
    }

    private void initDualOverlapDrawable() {
        int i = this.mCurrentMode;
        if (i == 5) {
            this.mOverlapBackground = new SliderDrawable(this, this.mModeExpandTrackMinWidth, this.mModeExpandTrackMaxWidth, this.mOverlapNormalProgressColor);
            return;
        }
        if (i == 6) {
            this.mOverlapBackground = new SliderDrawable(this.mTrackMinWidth, this.mTrackMaxWidth, this.mOverlapNormalProgressColor, true);
            return;
        }
        if (i == 0) {
            this.mOverlapBackground = new SliderDrawable(this.mTrackMinWidth, this.mTrackMaxWidth, this.mOverlapNormalProgressColor, false);
        } else {
            if (getProgressDrawable() == null || getProgressDrawable().getConstantState() == null) {
                return;
            }
            this.mOverlapBackground = getProgressDrawable().getConstantState().newDrawable().mutate();
        }
    }

    private void initMuteAnimation() {
        this.mMuteAnimationSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        int i = 400;
        for (int i2 = 0; i2 < 8; i2++) {
            boolean z = i2 % 2 == 0;
            ValueAnimator valueAnimatorOfInt = z ? ValueAnimator.ofInt(0, i) : ValueAnimator.ofInt(i, 0);
            valueAnimatorOfInt.setDuration(62);
            valueAnimatorOfInt.setInterpolator(new LinearInterpolator());
            valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: androidx.appcompat.widget.SeslAbsSeekBar.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    SeslAbsSeekBar.this.mCurrentProgressLevel = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    SeslAbsSeekBar seslAbsSeekBar = SeslAbsSeekBar.this;
                    seslAbsSeekBar.onSlidingRefresh(seslAbsSeekBar.mCurrentProgressLevel);
                }
            });
            arrayList.add(valueAnimatorOfInt);
            if (z) {
                i = (int) (((double) i) * 0.6d);
            }
        }
        this.mMuteAnimationSet.playSequentially(arrayList);
    }

    private void initializeExpandMode() {
        SliderDrawable sliderDrawable = new SliderDrawable(this, this.mTrackMinWidth, this.mTrackMaxWidth, this.mDefaultNormalProgressColor);
        SliderDrawable sliderDrawable2 = new SliderDrawable(this, this.mTrackMinWidth, this.mTrackMaxWidth, this.mDefaultSecondaryProgressColor);
        SliderDrawable sliderDrawable3 = new SliderDrawable(this, this.mTrackMinWidth, this.mTrackMaxWidth, this.mDefaultActivatedProgressColor);
        Drawable drawableWrapperCompat = new DrawableWrapperCompat(new ThumbDrawable(this.mThumbRadius, this.mDefaultActivatedThumbColor, false));
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{sliderDrawable, new ClipDrawable(sliderDrawable2, 19, 1), new ClipDrawable(sliderDrawable3, 19, 1)});
        layerDrawable.setPaddingMode(1);
        layerDrawable.setId(0, R.id.background);
        layerDrawable.setId(1, R.id.secondaryProgress);
        layerDrawable.setId(2, R.id.progress);
        setProgressDrawable(layerDrawable);
        setThumb(drawableWrapperCompat);
        setBackgroundResource(C0419R.drawable.sesl_seekbar_background_borderless_expand);
        int maxHeight = getMaxHeight();
        int i = this.mTrackMaxWidth;
        if (maxHeight > i) {
            setMaxHeight(i);
        }
    }

    private void initializeExpandModeForModeExpand() {
        SliderDrawable sliderDrawable = new SliderDrawable(this, this.mModeExpandTrackMinWidth, this.mModeExpandTrackMaxWidth, this.mDefaultNormalProgressColor);
        SliderDrawable sliderDrawable2 = new SliderDrawable(this, this.mModeExpandTrackMinWidth, this.mModeExpandTrackMaxWidth, this.mDefaultSecondaryProgressColor);
        SliderDrawable sliderDrawable3 = new SliderDrawable(this, this.mModeExpandTrackMinWidth, this.mModeExpandTrackMaxWidth, this.mDefaultActivatedProgressColor);
        Drawable drawableWrapperCompat = new DrawableWrapperCompat(new ThumbDrawable(this.mModeExpandThumbRadius, this.mDefaultActivatedThumbColor, false));
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{sliderDrawable, new ClipDrawable(sliderDrawable2, 19, 1), new ClipDrawable(sliderDrawable3, 19, 1)});
        layerDrawable.setPaddingMode(1);
        layerDrawable.setId(0, R.id.background);
        layerDrawable.setId(1, R.id.secondaryProgress);
        layerDrawable.setId(2, R.id.progress);
        setProgressDrawable(layerDrawable);
        setThumb(drawableWrapperCompat);
        setBackgroundResource(C0419R.drawable.sesl_seekbar_background_borderless_expand);
        int maxHeight = getMaxHeight();
        int i = this.mModeExpandTrackMaxWidth;
        if (maxHeight > i) {
            setMaxHeight(i);
        }
    }

    private void initializeExpandVerticalMode() {
        SliderDrawable sliderDrawable = new SliderDrawable(this.mTrackMinWidth, this.mTrackMaxWidth, this.mDefaultNormalProgressColor, true);
        SliderDrawable sliderDrawable2 = new SliderDrawable(this.mTrackMinWidth, this.mTrackMaxWidth, this.mDefaultSecondaryProgressColor, true);
        SliderDrawable sliderDrawable3 = new SliderDrawable(this.mTrackMinWidth, this.mTrackMaxWidth, this.mDefaultActivatedProgressColor, true);
        Drawable drawableWrapperCompat = new DrawableWrapperCompat(new ThumbDrawable(this.mThumbRadius, this.mDefaultActivatedThumbColor, true));
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{sliderDrawable, new ClipDrawable(sliderDrawable2, 81, 2), new ClipDrawable(sliderDrawable3, 81, 2)});
        layerDrawable.setPaddingMode(1);
        layerDrawable.setId(0, R.id.background);
        layerDrawable.setId(1, R.id.secondaryProgress);
        layerDrawable.setId(2, R.id.progress);
        setProgressDrawable(layerDrawable);
        setThumb(drawableWrapperCompat);
        setBackgroundResource(C0419R.drawable.sesl_seekbar_background_borderless_expand);
        int maxWidth = getMaxWidth();
        int i = this.mTrackMaxWidth;
        if (maxWidth > i) {
            setMaxWidth(i);
        }
    }

    private boolean isHoverPopupTypeUserCustom(int i) {
        return i == SeslHoverPopupWindowReflector.getField_TYPE_USER_CUSTOM();
    }

    private void setHotspot(float f, float f4) {
        Drawable background = getBackground();
        if (background != null) {
            DrawableCompat.setHotspot(background, f, f4);
        }
    }

    private void setHoverPopupDetectTime() {
        SeslHoverPopupWindowReflector.setHoverDetectTime(SeslViewReflector.semGetHoverPopup(this, true), 200);
    }

    private void setHoverPopupGravity(int i) {
        SeslHoverPopupWindowReflector.setGravity(SeslViewReflector.semGetHoverPopup(this, true), i);
    }

    private void setHoverPopupOffset(int i, int i2) {
        SeslHoverPopupWindowReflector.setOffset(SeslViewReflector.semGetHoverPopup(this, true), i, i2);
    }

    private void setHoveringPoint(int i, int i2) {
        SeslHoverPopupWindowReflector.setHoveringPoint(SeslViewReflector.semGetHoverPopup(this, true), i, i2);
    }

    private void setProgressOverlapTintList(@Nullable ColorStateList colorStateList) {
        super.setProgressTintList(colorStateList);
    }

    private void setThumbOverlapTintList(@Nullable ColorStateList colorStateList) {
        this.mThumbTintList = colorStateList;
        this.mHasThumbTint = true;
        applyThumbTint();
    }

    private void setThumbPos(int i, Drawable drawable, float f, int i2) {
        int i4;
        int i5 = this.mCurrentMode;
        if (i5 == 3 || i5 == 6) {
            setThumbPosInVertical(getHeight(), drawable, f, i2);
            return;
        }
        int paddingLeft = ((i - getPaddingLeft()) - getPaddingRight()) - ((int) (this.mLevelDrawPadding * 2.0f));
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        int i6 = (this.mThumbOffset * 2) + (paddingLeft - intrinsicWidth);
        int i7 = (int) ((f * i6) + 0.5f);
        if (i2 == Integer.MIN_VALUE) {
            Rect bounds = drawable.getBounds();
            i2 = bounds.top;
            i4 = bounds.bottom;
        } else {
            i4 = i2 + intrinsicHeight;
        }
        int i8 = (int) this.mLevelDrawPadding;
        if (ViewUtils.isLayoutRtl(this) && this.mMirrorForRtl) {
            i7 = i6 - i7;
        }
        int i9 = i8 + i7;
        int i10 = i9 + intrinsicWidth;
        Drawable background = getBackground();
        if (background != null) {
            int paddingLeft2 = getPaddingLeft() - this.mThumbOffset;
            int paddingTop = getPaddingTop();
            DrawableCompat.setHotspotBounds(background, i9 + paddingLeft2, i2 + paddingTop, paddingLeft2 + i10, paddingTop + i4);
        }
        drawable.setBounds(i9, i2, i10, i4);
        updateGestureExclusionRects();
        this.mThumbPosX = (getPaddingLeft() + i9) - (getPaddingLeft() - (intrinsicWidth / 2));
        updateSplitProgress();
    }

    private void setThumbPosInVertical(int i, Drawable drawable, float f, int i2) {
        int i4;
        int paddingTop = (i - getPaddingTop()) - getPaddingBottom();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        int i5 = (this.mThumbOffset * 2) + (paddingTop - intrinsicHeight);
        int i6 = (int) ((f * i5) + 0.5f);
        if (i2 == Integer.MIN_VALUE) {
            Rect bounds = drawable.getBounds();
            i2 = bounds.left;
            i4 = bounds.right;
        } else {
            i4 = i2 + intrinsicWidth;
        }
        int i7 = i5 - i6;
        int i8 = intrinsicHeight + i7;
        Drawable background = getBackground();
        if (background != null) {
            int paddingLeft = getPaddingLeft();
            int paddingTop2 = getPaddingTop() - this.mThumbOffset;
            DrawableCompat.setHotspotBounds(background, i2 + paddingLeft, i7 + paddingTop2, paddingLeft + i4, paddingTop2 + i8);
        }
        drawable.setBounds(i2, i7, i4, i8);
        this.mThumbPosX = getPaddingLeft() + (intrinsicWidth / 2) + i7;
    }

    private void startDrag(MotionEvent motionEvent) {
        setPressed(true);
        Drawable drawable = this.mThumb;
        if (drawable != null) {
            invalidate(drawable.getBounds());
        }
        onStartTrackingTouch();
        trackTouchEvent(motionEvent);
        attemptClaimDrag();
    }

    private void startMuteAnimation() {
        cancelMuteAnimation();
        AnimatorSet animatorSet = this.mMuteAnimationSet;
        if (animatorSet != null) {
            animatorSet.start();
        }
    }

    private boolean supportIsHoveringUIEnabled() {
        return SeslViewReflector.isHoveringUIEnabled(this);
    }

    private boolean supportIsInScrollingContainer() {
        return SeslViewReflector.isInScrollingContainer(this);
    }

    private void trackHoverEvent(int i) {
        float paddingLeft;
        int width = getWidth();
        int paddingLeft2 = (width - getPaddingLeft()) - getPaddingRight();
        float f = 0.0f;
        if (i < getPaddingLeft()) {
            paddingLeft = 0.0f;
        } else if (i > width - getPaddingRight()) {
            paddingLeft = 1.0f;
        } else {
            f = this.mTouchProgressOffset;
            paddingLeft = (i - getPaddingLeft()) / paddingLeft2;
        }
        this.mHoveringLevel = (int) ((paddingLeft * getMax()) + f);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void trackTouchEvent(MotionEvent motionEvent) {
        float paddingLeft;
        float f;
        float f4;
        int min;
        int i = this.mCurrentMode;
        if (i == 3 || i == 6) {
            trackTouchEventInVertical(motionEvent);
            return;
        }
        int iRound = Math.round(motionEvent.getX());
        int iRound2 = Math.round(motionEvent.getY());
        int width = getWidth();
        int paddingLeft2 = (width - getPaddingLeft()) - getPaddingRight();
        if (ViewUtils.isLayoutRtl(this) && this.mMirrorForRtl) {
            if (iRound <= width - getPaddingRight()) {
                if (iRound >= getPaddingLeft()) {
                    paddingLeft = (getPaddingLeft() + (paddingLeft2 - iRound)) / paddingLeft2;
                    f = this.mTouchProgressOffset;
                }
            }
        } else if (iRound < getPaddingLeft()) {
            paddingLeft = 0.0f;
            f = 0.0f;
        } else if (iRound > width - getPaddingRight()) {
            f = 0.0f;
            paddingLeft = 1.0f;
        } else {
            paddingLeft = (iRound - getPaddingLeft()) / paddingLeft2;
            f = this.mTouchProgressOffset;
        }
        if (this.mIsSeamless) {
            float max = super.getMax() - super.getMin();
            float f5 = 1.0f / max;
            if (paddingLeft > 0.0f && paddingLeft < 1.0f) {
                float f6 = paddingLeft % f5;
                if (f6 > f5 / 2.0f) {
                    paddingLeft += f5 - f6;
                }
            }
            f4 = paddingLeft * max;
            min = super.getMin();
        } else {
            float max2 = getMax() - getMin();
            float f7 = 1.0f / max2;
            if (paddingLeft > 0.0f && paddingLeft < 1.0f) {
                float f8 = paddingLeft % f7;
                if (f8 > f7 / 2.0f) {
                    paddingLeft += f7 - f8;
                }
            }
            f4 = paddingLeft * max2;
            min = getMin();
        }
        float f9 = f4 + min + f;
        setHotspot(iRound, iRound2);
        setProgressInternal(Math.round(f9), true, false);
    }

    private void trackTouchEventInVertical(MotionEvent motionEvent) {
        float paddingBottom;
        float f;
        float f4;
        int min;
        int height = getHeight();
        int paddingTop = (height - getPaddingTop()) - getPaddingBottom();
        int iRound = Math.round(motionEvent.getX());
        int iRound2 = height - Math.round(motionEvent.getY());
        if (iRound2 < getPaddingBottom()) {
            paddingBottom = 0.0f;
            f = 0.0f;
        } else if (iRound2 > height - getPaddingTop()) {
            paddingBottom = 1.0f;
            f = 0.0f;
        } else {
            paddingBottom = (iRound2 - getPaddingBottom()) / paddingTop;
            f = this.mTouchProgressOffset;
        }
        if (this.mIsSeamless) {
            float max = super.getMax() - super.getMin();
            float f5 = 1.0f / max;
            if (paddingBottom > 0.0f && paddingBottom < 1.0f) {
                float f6 = paddingBottom % f5;
                if (f6 > f5 / 2.0f) {
                    paddingBottom += f5 - f6;
                }
            }
            f4 = paddingBottom * max;
            min = super.getMin();
        } else {
            float max2 = getMax() - getMin();
            float f7 = 1.0f / max2;
            if (paddingBottom > 0.0f && paddingBottom < 1.0f) {
                float f8 = paddingBottom % f7;
                if (f8 > f7 / 2.0f) {
                    paddingBottom += f7 - f8;
                }
            }
            f4 = paddingBottom * max2;
            min = getMin();
        }
        float f9 = f4 + min + f;
        setHotspot(iRound, iRound2);
        setProgressInternal(Math.round(f9), true, false);
    }

    private void updateBoundsForDualColor() {
        if (getCurrentDrawable() == null || checkInvalidatedDualColorMode()) {
            return;
        }
        this.mOverlapBackground.setBounds(getCurrentDrawable().getBounds());
    }

    private void updateDualColorMode() {
        if (checkInvalidatedDualColorMode()) {
            return;
        }
        DrawableCompat.setTintList(this.mOverlapBackground, this.mOverlapNormalProgressColor);
        if (!this.mLargeFont) {
            if ((!this.mIsSeamless || super.getProgress() <= this.mOverlapPoint * SCALE_FACTOR) && getProgress() <= this.mOverlapPoint) {
                setProgressTintList(this.mDefaultActivatedProgressColor);
                setThumbTintList(this.mDefaultActivatedThumbColor);
            } else {
                setProgressOverlapTintList(this.mOverlapActivatedProgressColor);
                setThumbOverlapTintList(this.mOverlapActivatedProgressColor);
            }
        }
        updateBoundsForDualColor();
    }

    private void updateGestureExclusionRects() {
        if (Build.VERSION.SDK_INT >= 29) {
            Drawable drawable = this.mThumb;
            if (drawable == null) {
                super.setSystemGestureExclusionRects(this.mUserGestureExclusionRects);
                return;
            }
            this.mGestureExclusionRects.clear();
            drawable.copyBounds(this.mThumbRect);
            this.mGestureExclusionRects.add(this.mThumbRect);
            this.mGestureExclusionRects.addAll(this.mUserGestureExclusionRects);
            super.setSystemGestureExclusionRects(this.mGestureExclusionRects);
        }
    }

    private void updateSplitProgress() {
        if (this.mCurrentMode != 4) {
            return;
        }
        Drawable drawable = this.mSplitProgress;
        Rect bounds = getCurrentDrawable().getBounds();
        if (drawable != null) {
            if (this.mMirrorForRtl && ViewUtils.isLayoutRtl(this)) {
                drawable.setBounds(this.mThumbPosX, bounds.top, getWidth() - getPaddingRight(), bounds.bottom);
            } else {
                drawable.setBounds(getPaddingLeft(), bounds.top, this.mThumbPosX, bounds.bottom);
            }
        }
        int width = getWidth();
        int height = getHeight();
        Drawable drawable2 = this.mDivider;
        if (drawable2 != null) {
            float f = width / 2.0f;
            float f4 = this.mDensity;
            float f5 = height / 2.0f;
            drawable2.setBounds((int) (f - ((f4 * 4.0f) / 2.0f)), (int) (f5 - ((f4 * 22.0f) / 2.0f)), (int) (((4.0f * f4) / 2.0f) + f), (int) (((f4 * 22.0f) / 2.0f) + f5));
        }
    }

    private void updateThumbAndTrackPos(int i, int i2) {
        int iM7d;
        int i4;
        int i5 = this.mCurrentMode;
        if (i5 == 3 || i5 == 6) {
            updateThumbAndTrackPosInVertical(i, i2);
            return;
        }
        int paddingTop = (i2 - getPaddingTop()) - getPaddingBottom();
        Drawable currentDrawable = getCurrentDrawable();
        Drawable drawable = this.mThumb;
        int iMin = Math.min(this.mMaxHeight, paddingTop);
        int intrinsicHeight = drawable == null ? 0 : drawable.getIntrinsicHeight();
        if (intrinsicHeight > iMin) {
            i4 = (paddingTop - intrinsicHeight) / 2;
            iM7d = AbstractC0000a.m7d(intrinsicHeight, iMin, 2, i4);
        } else {
            int i6 = (paddingTop - iMin) / 2;
            int iM7d2 = AbstractC0000a.m7d(iMin, intrinsicHeight, 2, i6);
            iM7d = i6;
            i4 = iM7d2;
        }
        if (currentDrawable != null) {
            currentDrawable.setBounds(0, iM7d, (i - getPaddingRight()) - getPaddingLeft(), iMin + iM7d);
        }
        if (drawable != null) {
            setThumbPos(i, drawable, getScale(), i4);
        }
        updateSplitProgress();
    }

    private void updateThumbAndTrackPosInVertical(int i, int i2) {
        int iM7d;
        int iM7d2;
        int paddingLeft = (i - getPaddingLeft()) - getPaddingRight();
        Drawable currentDrawable = getCurrentDrawable();
        Drawable drawable = this.mThumb;
        int iMin = Math.min(this.mMaxWidth, paddingLeft);
        int intrinsicWidth = drawable == null ? 0 : drawable.getIntrinsicWidth();
        if (intrinsicWidth > iMin) {
            iM7d = (paddingLeft - intrinsicWidth) / 2;
            iM7d2 = AbstractC0000a.m7d(intrinsicWidth, iMin, 2, iM7d);
        } else {
            int i4 = (paddingLeft - iMin) / 2;
            iM7d = AbstractC0000a.m7d(iMin, intrinsicWidth, 2, i4);
            iM7d2 = i4;
        }
        if (currentDrawable != null) {
            currentDrawable.setBounds(iM7d2, 0, paddingLeft - iM7d2, (i2 - getPaddingBottom()) - getPaddingTop());
        }
        if (drawable != null) {
            setThumbPosInVertical(i2, drawable, getScale(), iM7d);
        }
    }

    private void updateWarningMode(int i) {
        if (this.mCurrentMode == 1) {
            if (i == getMax()) {
                setProgressOverlapTintList(this.mOverlapActivatedProgressColor);
                setThumbOverlapTintList(this.mOverlapActivatedProgressColor);
            } else {
                setProgressTintList(this.mDefaultActivatedProgressColor);
                setThumbTintList(this.mDefaultActivatedThumbColor);
            }
        }
    }

    public boolean canUserSetProgress() {
        return !isIndeterminate() && isEnabled();
    }

    public void drawThumb(Canvas canvas) {
        if (this.mThumb != null) {
            int iSave = canvas.save();
            int i = this.mCurrentMode;
            if (i == 3 || i == 6) {
                canvas.translate(getPaddingLeft(), getPaddingTop() - this.mThumbOffset);
            } else {
                canvas.translate(getPaddingLeft() - this.mThumbOffset, getPaddingTop());
            }
            this.mThumb.draw(canvas);
            canvas.restoreToCount(iSave);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void drawTickMarks(Canvas canvas) {
        if (this.mTickMark != null) {
            int max = getMax() - getMin();
            if (max > 1) {
                int intrinsicWidth = this.mTickMark.getIntrinsicWidth();
                int intrinsicHeight = this.mTickMark.getIntrinsicHeight();
                int i = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                int i2 = intrinsicHeight >= 0 ? intrinsicHeight / 2 : 1;
                this.mTickMark.setBounds(-i, -i2, i, i2);
                float width = (((getWidth() - getPaddingLeft()) - getPaddingRight()) - (this.mLevelDrawPadding * 2.0f)) / max;
                int iSave = canvas.save();
                canvas.translate(this.mLevelDrawPadding + getPaddingLeft(), getHeight() / 2.0f);
                for (int i4 = 0; i4 <= max; i4++) {
                    this.mTickMark.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(iSave);
            }
        }
    }

    @Override // androidx.appcompat.widget.SeslProgressBar
    public void drawTrack(Canvas canvas) {
        int iMax;
        int max;
        Drawable drawable = this.mThumb;
        if (drawable == null || !this.mSplitTrack) {
            super.drawTrack(canvas);
            drawTickMarks(canvas);
        } else {
            Rect opticalBounds = DrawableUtils.getOpticalBounds(drawable);
            Rect rect = this.mTempRect;
            drawable.copyBounds(rect);
            rect.offset(getPaddingLeft() - this.mThumbOffset, getPaddingTop());
            rect.left += opticalBounds.left;
            rect.right -= opticalBounds.right;
            int iSave = canvas.save();
            canvas.clipRect(rect, Region.Op.DIFFERENCE);
            super.drawTrack(canvas);
            drawTickMarks(canvas);
            canvas.restoreToCount(iSave);
        }
        if (checkInvalidatedDualColorMode()) {
            return;
        }
        canvas.save();
        if (this.mMirrorForRtl && ViewUtils.isLayoutRtl(this)) {
            canvas.translate(getWidth() - getPaddingRight(), getPaddingTop());
            canvas.scale(-1.0f, 1.0f);
        } else {
            canvas.translate(getPaddingLeft(), getPaddingTop());
        }
        Rect bounds = this.mOverlapBackground.getBounds();
        Rect rect2 = this.mTempRect;
        this.mOverlapBackground.copyBounds(rect2);
        if (this.mIsSeamless) {
            iMax = Math.max(super.getProgress(), (int) (this.mOverlapPoint * SCALE_FACTOR));
            max = super.getMax();
        } else {
            iMax = Math.max(getProgress(), this.mOverlapPoint);
            max = getMax();
        }
        int min = getMin();
        float f = (iMax - min) / (max - min);
        int i = this.mCurrentMode;
        if (i == 3 || i == 6) {
            rect2.bottom = (int) (bounds.bottom - (bounds.height() * f));
        } else {
            rect2.left = (int) ((bounds.width() * f) + bounds.left);
        }
        canvas.clipRect(rect2);
        if (this.mDefaultNormalProgressColor.getDefaultColor() != this.mOverlapNormalProgressColor.getDefaultColor()) {
            this.mOverlapBackground.draw(canvas);
        }
        canvas.restore();
    }

    @Override // androidx.appcompat.widget.SeslProgressBar, android.view.View
    public void drawableHotspotChanged(float f, float f4) {
        super.drawableHotspotChanged(f, f4);
        Drawable drawable = this.mThumb;
        if (drawable != null) {
            DrawableCompat.setHotspot(drawable, f, f4);
        }
    }

    @Override // androidx.appcompat.widget.SeslProgressBar, android.view.View
    public void drawableStateChanged() {
        Drawable drawable;
        super.drawableStateChanged();
        Drawable progressDrawable = getProgressDrawable();
        if (progressDrawable != null && this.mDisabledAlpha < 1.0f) {
            int i = isEnabled() ? 255 : (int) (this.mDisabledAlpha * 255.0f);
            progressDrawable.setAlpha(i);
            Drawable drawable2 = this.mOverlapBackground;
            if (drawable2 != null) {
                drawable2.setAlpha(i);
            }
        }
        if (this.mThumb != null && this.mHasThumbTint) {
            if (isEnabled()) {
                DrawableCompat.setTintList(this.mThumb, this.mDefaultActivatedThumbColor);
                updateDualColorMode();
            } else {
                DrawableCompat.setTintList(this.mThumb, null);
            }
        }
        if (this.mSetDualColorMode && progressDrawable != null && progressDrawable.isStateful() && (drawable = this.mOverlapBackground) != null) {
            drawable.setState(getDrawableState());
        }
        Drawable drawable3 = this.mThumb;
        if (drawable3 != null && drawable3.isStateful() && drawable3.setState(getDrawableState())) {
            invalidateDrawable(drawable3);
        }
        Drawable drawable4 = this.mTickMark;
        if (drawable4 != null && drawable4.isStateful() && drawable4.setState(getDrawableState())) {
            invalidateDrawable(drawable4);
        }
    }

    @Override // androidx.appcompat.widget.SeslProgressBar, android.view.View
    public CharSequence getAccessibilityClassName() {
        Log.d(TAG, "Stack:", new Throwable("stack dump"));
        return AbsSeekBar.class.getName();
    }

    public int getKeyProgressIncrement() {
        return this.mKeyProgressIncrement;
    }

    @Override // androidx.appcompat.widget.SeslProgressBar
    public synchronized int getMax() {
        try {
        } catch (Throwable th) {
            throw th;
        }
        return this.mIsSeamless ? Math.round(super.getMax() / SCALE_FACTOR) : super.getMax();
    }

    @Override // androidx.appcompat.widget.SeslProgressBar
    public synchronized int getMin() {
        try {
        } catch (Throwable th) {
            throw th;
        }
        return this.mIsSeamless ? Math.round(super.getMin() / SCALE_FACTOR) : super.getMin();
    }

    @Override // androidx.appcompat.widget.SeslProgressBar
    public synchronized int getProgress() {
        try {
        } catch (Throwable th) {
            throw th;
        }
        return this.mIsSeamless ? Math.round(super.getProgress() / SCALE_FACTOR) : super.getProgress();
    }

    public boolean getSplitTrack() {
        return this.mSplitTrack;
    }

    public Drawable getThumb() {
        return this.mThumb;
    }

    public Rect getThumbBounds() {
        Drawable drawable = this.mThumb;
        if (drawable != null) {
            return drawable.getBounds();
        }
        return null;
    }

    public int getThumbHeight() {
        return this.mThumb.getIntrinsicHeight();
    }

    public int getThumbOffset() {
        return this.mThumbOffset;
    }

    @Nullable
    public ColorStateList getThumbTintList() {
        return this.mThumbTintList;
    }

    @Nullable
    public PorterDuff.Mode getThumbTintMode() {
        return this.mThumbTintMode;
    }

    public Drawable getTickMark() {
        return this.mTickMark;
    }

    @Nullable
    public ColorStateList getTickMarkTintList() {
        return this.mTickMarkTintList;
    }

    @Nullable
    public PorterDuff.Mode getTickMarkTintMode() {
        return this.mTickMarkTintMode;
    }

    @Override // androidx.appcompat.widget.SeslProgressBar, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.mThumb;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.mTickMark;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
    }

    @Override // androidx.appcompat.widget.SeslProgressBar, android.view.View
    public synchronized void onDraw(Canvas canvas) {
        try {
            super.onDraw(canvas);
            if (supportIsHoveringUIEnabled()) {
                int hoverPopupType = getHoverPopupType();
                if (isHoverPopupTypeUserCustom(hoverPopupType) && this.mPreviousHoverPopupType != hoverPopupType) {
                    this.mPreviousHoverPopupType = hoverPopupType;
                    setHoverPopupGravity(12849);
                    setHoverPopupOffset(0, getMeasuredHeight() / 2);
                    setHoverPopupDetectTime();
                }
            }
            if (this.mCurrentMode == 4) {
                this.mSplitProgress.draw(canvas);
                this.mDivider.draw(canvas);
            }
            if (!this.mIsTouchDisabled) {
                drawThumb(canvas);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.view.View
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean onHoverEvent(MotionEvent motionEvent) {
        if (supportIsHoveringUIEnabled()) {
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y2 = (int) motionEvent.getY();
            if (action == 7) {
                trackHoverEvent(x);
                onHoverChanged(this.mHoveringLevel, x, y2);
                if (isHoverPopupTypeUserCustom(getHoverPopupType())) {
                    setHoveringPoint((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
                    updateHoverPopup();
                }
            } else if (action == 9) {
                trackHoverEvent(x);
                onStartTrackingHover(this.mHoveringLevel, x, y2);
            } else if (action == 10) {
                onStopTrackingHover();
            }
        }
        return super.onHoverEvent(motionEvent);
    }

    @Override // androidx.appcompat.widget.SeslProgressBar, android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (isEnabled()) {
            int progress = getProgress();
            if (progress > getMin()) {
                accessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_BACKWARD);
            }
            if (progress < getMax()) {
                accessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_FORWARD);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0082  */
    @Override // android.view.View, android.view.KeyEvent.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (isEnabled()) {
            int i2 = this.mKeyProgressIncrement;
            int i4 = this.mCurrentMode;
            if (i4 == 3 || i4 == 6) {
                if (i == 19) {
                    if (ViewUtils.isLayoutRtl(this)) {
                        i2 = -i2;
                    }
                    if (setProgressInternal(!this.mIsSeamless ? Math.round((getProgress() + i2) * SCALE_FACTOR) : i2 + getProgress(), true, true)) {
                        onKeyChange();
                        return true;
                    }
                } else {
                    if (i == 20 || i == 69) {
                        i2 = -i2;
                    } else if (i == 70 || i == 81) {
                    }
                    if (ViewUtils.isLayoutRtl(this)) {
                    }
                    if (setProgressInternal(!this.mIsSeamless ? Math.round((getProgress() + i2) * SCALE_FACTOR) : i2 + getProgress(), true, true)) {
                    }
                }
            } else if (i == 21) {
                i2 = -i2;
                if (ViewUtils.isLayoutRtl(this)) {
                    i2 = -i2;
                }
                if (setProgressInternal(this.mIsSeamless ? Math.round((getProgress() + i2) * SCALE_FACTOR) : i2 + getProgress(), true, true)) {
                    onKeyChange();
                    return true;
                }
            } else if (i == 22) {
                if (ViewUtils.isLayoutRtl(this)) {
                }
                if (setProgressInternal(this.mIsSeamless ? Math.round((getProgress() + i2) * SCALE_FACTOR) : i2 + getProgress(), true, true)) {
                }
            } else {
                if (i != 69) {
                    if (i == 70 || i == 81) {
                    }
                }
                if (ViewUtils.isLayoutRtl(this)) {
                }
                if (setProgressInternal(this.mIsSeamless ? Math.round((getProgress() + i2) * SCALE_FACTOR) : i2 + getProgress(), true, true)) {
                }
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // androidx.appcompat.widget.SeslProgressBar, android.view.View
    public synchronized void onMeasure(int i, int i2) {
        int iMax;
        int iMax2;
        try {
            Drawable currentDrawable = getCurrentDrawable();
            if (currentDrawable != null) {
                int i4 = this.mCurrentMode;
                if (i4 == 3 || i4 == 6) {
                    Drawable drawable = this.mThumb;
                    int intrinsicHeight = drawable == null ? 0 : drawable.getIntrinsicHeight();
                    int iMax3 = Math.max(this.mMinWidth, Math.min(this.mMaxWidth, currentDrawable.getIntrinsicHeight()));
                    iMax = Math.max(this.mMinHeight, Math.min(this.mMaxHeight, currentDrawable.getIntrinsicWidth()));
                    iMax2 = Math.max(intrinsicHeight, iMax3);
                } else {
                    Drawable drawable2 = this.mThumb;
                    int intrinsicHeight2 = drawable2 == null ? 0 : drawable2.getIntrinsicHeight();
                    iMax2 = Math.max(this.mMinWidth, Math.min(this.mMaxWidth, currentDrawable.getIntrinsicWidth()));
                    iMax = Math.max(intrinsicHeight2, Math.max(this.mMinHeight, Math.min(this.mMaxHeight, currentDrawable.getIntrinsicHeight())));
                }
            } else {
                iMax = 0;
                iMax2 = 0;
            }
            setMeasuredDimension(View.resolveSizeAndState(getPaddingLeft() + getPaddingRight() + iMax2, i, 0), View.resolveSizeAndState(getPaddingTop() + getPaddingBottom() + iMax, i2, 0));
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // androidx.appcompat.widget.SeslProgressBar
    public void onProgressRefresh(float f, boolean z, int i) throws Throwable {
        int i2 = (int) (10000.0f * f);
        if (!this.mUseMuteAnimation || this.mIsFirstSetProgress || this.mIsDraggingForSliding || this.mCurrentProgressLevel == 0 || i2 != 0) {
            cancelMuteAnimation();
            this.mIsFirstSetProgress = false;
            this.mCurrentProgressLevel = i2;
            super.onProgressRefresh(f, z, i);
            Drawable drawable = this.mThumb;
            if (drawable != null) {
                setThumbPos(getWidth(), drawable, f, Integer.MIN_VALUE);
                invalidate();
            }
        } else {
            startMuteAnimation();
        }
        if (z && this.mCurrentMode == 8) {
            performHapticFeedback(SeslHapticFeedbackConstantsReflector.semGetVibrationIndex(41));
            return;
        }
        if (z && this.mIsHapticEnabled) {
            int i4 = this.mCurrentMode;
            if (i4 == 5 || i4 == 0 || i4 == 6 || i4 == 3) {
                if (i == getMin() || i == getMax()) {
                    performHapticFeedback(SeslHapticFeedbackConstantsReflector.semGetVibrationIndex(41));
                }
            }
        }
    }

    @Override // androidx.appcompat.widget.SeslProgressBar
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void onResolveDrawables(int i) {
        super.onResolveDrawables(i);
        Drawable drawable = this.mThumb;
        if (drawable != null) {
            DrawableCompat.setLayoutDirection(drawable, i);
        }
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        super.onRtlPropertiesChanged(i);
        Drawable drawable = this.mThumb;
        if (drawable != null) {
            setThumbPos(getWidth(), drawable, getScale(), Integer.MIN_VALUE);
            invalidate();
        }
    }

    @Override // androidx.appcompat.widget.SeslProgressBar, android.view.View
    public void onSizeChanged(int i, int i2, int i4, int i5) {
        super.onSizeChanged(i, i2, i4, i5);
        updateThumbAndTrackPos(i, i2);
    }

    @Override // androidx.appcompat.widget.SeslProgressBar
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void onSlidingRefresh(int i) {
        super.onSlidingRefresh(i);
        float f = i / 10000.0f;
        Drawable drawable = this.mThumb;
        if (drawable != null) {
            setThumbPos(getWidth(), drawable, f, Integer.MIN_VALUE);
            invalidate();
        }
    }

    public void onStartTrackingTouch() {
        this.mIsDragging = true;
        ValueAnimator valueAnimator = this.mValueAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    public void onStopTrackingTouch() {
        this.mIsDragging = false;
        if (!this.mIsSeamless || !isPressed()) {
            if (this.mIsSeamless) {
                setProgress(Math.round(super.getProgress() / SCALE_FACTOR));
                return;
            }
            return;
        }
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(super.getProgress(), (int) (Math.round(super.getProgress() / SCALE_FACTOR) * SCALE_FACTOR));
        this.mValueAnimator = valueAnimatorOfInt;
        valueAnimatorOfInt.setDuration(300L);
        this.mValueAnimator.setInterpolator(SeslAnimationUtils.SINE_IN_OUT_90);
        this.mValueAnimator.start();
        this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: androidx.appcompat.widget.SeslAbsSeekBar.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SeslAbsSeekBar.this.callSuperSetProgress(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i;
        if (!this.mIsUserSeekable || this.mIsTouchDisabled || !isEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.mIsDraggingForSliding = false;
            int i2 = this.mCurrentMode;
            if (i2 == 5 || i2 == 6 || i2 == 0 || supportIsInScrollingContainer()) {
                this.mTouchDownX = motionEvent.getX();
                this.mTouchDownY = motionEvent.getY();
            } else {
                startDrag(motionEvent);
            }
        } else if (action == 1) {
            if (this.mIsDraggingForSliding) {
                this.mIsDraggingForSliding = false;
            }
            if (this.mIsDragging) {
                trackTouchEvent(motionEvent);
                onStopTrackingTouch();
                setPressed(false);
            } else {
                onStartTrackingTouch();
                trackTouchEvent(motionEvent);
                onStopTrackingTouch();
            }
            invalidate();
        } else if (action == 2) {
            this.mIsDraggingForSliding = true;
            if (this.mIsDragging) {
                trackTouchEvent(motionEvent);
            } else {
                float x = motionEvent.getX();
                float y2 = motionEvent.getY();
                int i4 = this.mCurrentMode;
                if ((i4 != 3 && i4 != 6 && Math.abs(x - this.mTouchDownX) > this.mScaledTouchSlop) || (((i = this.mCurrentMode) == 3 || i == 6) && Math.abs(y2 - this.mTouchDownY) > this.mScaledTouchSlop)) {
                    startDrag(motionEvent);
                }
            }
        } else if (action == 3) {
            this.mIsDraggingForSliding = false;
            if (this.mIsDragging) {
                onStopTrackingTouch();
                setPressed(false);
            }
            invalidate();
        }
        return true;
    }

    @Override // androidx.appcompat.widget.SeslProgressBar
    public void onVisualProgressChanged(int i, float f) {
        Drawable drawable;
        super.onVisualProgressChanged(i, f);
        if (i != 16908301 || (drawable = this.mThumb) == null) {
            return;
        }
        setThumbPos(getWidth(), drawable, f, Integer.MIN_VALUE);
        invalidate();
    }

    @Override // android.view.View
    public boolean performAccessibilityAction(int i, Bundle bundle) {
        if (super.performAccessibilityAction(i, bundle)) {
            return true;
        }
        if (!isEnabled()) {
            return false;
        }
        if (i != 4096 && i != 8192) {
            if (i != 16908349 || !canUserSetProgress() || bundle == null || !bundle.containsKey(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_PROGRESS_VALUE)) {
                return false;
            }
            float f = bundle.getFloat(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_PROGRESS_VALUE);
            return setProgressInternal(this.mIsSeamless ? Math.round(f * SCALE_FACTOR) : (int) f, true, true);
        }
        if (!canUserSetProgress()) {
            return false;
        }
        int iMax = Math.max(1, Math.round((getMax() - getMin()) / 20.0f));
        if (i == 8192) {
            iMax = -iMax;
        }
        if (!setProgressInternal(this.mIsSeamless ? Math.round((getProgress() + iMax) * SCALE_FACTOR) : getProgress() + iMax, true, true)) {
            return false;
        }
        onKeyChange();
        return true;
    }

    public void seslSetLevelBarThumbStrokeColor(@ColorInt int i) {
        Drawable.ConstantState constantState;
        GradientDrawable gradientDrawable;
        Drawable drawable = this.mLevelBarThumbDrawable;
        if (drawable == null || (constantState = drawable.getConstantState()) == null) {
            return;
        }
        Drawable drawable2 = ((DrawableContainer.DrawableContainerState) constantState).getChildren()[1];
        if (!(drawable2 instanceof LayerDrawable) || (gradientDrawable = (GradientDrawable) ((LayerDrawable) drawable2).findDrawableByLayerId(C0419R.id.sesl_level_seekbar_thumb_enabled)) == null) {
            return;
        }
        gradientDrawable.setStroke(getResources().getDimensionPixelSize(C0419R.dimen.sesl_seekbar_thumb_stroke), i);
    }

    public void setDualModeOverlapColor(int i, int i2) {
        ColorStateList colorStateListColorToColorStateList = colorToColorStateList(i);
        ColorStateList colorStateListColorToColorStateList2 = colorToColorStateList(i2);
        if (!colorStateListColorToColorStateList.equals(this.mOverlapNormalProgressColor)) {
            this.mOverlapNormalProgressColor = colorStateListColorToColorStateList;
        }
        if (!colorStateListColorToColorStateList2.equals(this.mOverlapActivatedProgressColor)) {
            this.mOverlapActivatedProgressColor = colorStateListColorToColorStateList2;
        }
        updateDualColorMode();
        invalidate();
    }

    public void setKeyProgressIncrement(int i) {
        if (i < 0) {
            i = -i;
        }
        this.mKeyProgressIncrement = i;
    }

    @Override // androidx.appcompat.widget.SeslProgressBar
    public synchronized void setMax(int i) {
        try {
            if (this.mIsSeamless) {
                i = Math.round(i * SCALE_FACTOR);
            }
            super.setMax(i);
            this.mIsFirstSetProgress = true;
            int max = getMax() - getMin();
            int i2 = this.mKeyProgressIncrement;
            if (i2 == 0 || max / i2 > 20) {
                setKeyProgressIncrement(Math.max(1, Math.round(max / 20.0f)));
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // androidx.appcompat.widget.SeslProgressBar
    public synchronized void setMin(int i) {
        try {
            if (this.mIsSeamless) {
                i = Math.round(i * SCALE_FACTOR);
            }
            super.setMin(i);
            int max = getMax() - getMin();
            int i2 = this.mKeyProgressIncrement;
            if (i2 == 0 || max / i2 > 20) {
                setKeyProgressIncrement(Math.max(1, Math.round(max / 20.0f)));
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // androidx.appcompat.widget.SeslProgressBar
    public void setMode(int i) {
        if (this.mCurrentMode == i && this.mIsSetModeCalled) {
            Log.w(TAG, "Seekbar mode is already set. Do not call this method redundant");
            return;
        }
        super.setMode(i);
        this.mLevelDrawPadding = 0.0f;
        if (i == 0) {
            setProgressTintList(this.mDefaultActivatedProgressColor);
            setThumbTintList(this.mDefaultActivatedThumbColor);
        } else if (i == 1) {
            updateWarningMode(getProgress());
        } else if (i == 3) {
            setThumb(getContext().getResources().getDrawable(this.mIsLightTheme ? C0419R.drawable.sesl_scrubber_control_anim_light : C0419R.drawable.sesl_scrubber_control_anim_dark));
            setBackgroundResource(C0419R.drawable.sesl_seek_bar_background_borderless);
        } else if (i == 4) {
            this.mSplitProgress = getContext().getResources().getDrawable(C0419R.drawable.sesl_split_seekbar_primary_progress);
            this.mDivider = getContext().getResources().getDrawable(C0419R.drawable.sesl_split_seekbar_vertical_bar);
            updateSplitProgress();
        } else if (i == 5) {
            initializeExpandModeForModeExpand();
            this.mLevelDrawPadding = getContext().getResources().getDimension(C0419R.dimen.sesl_seekbar_level_progress_padding_start_end);
        } else if (i == 6) {
            initializeExpandVerticalMode();
        } else if (i == 8) {
            this.mLevelDrawPadding = getContext().getResources().getDimension(C0419R.dimen.sesl_seekbar_level_progress_padding_start_end);
            setProgressDrawable(getContext().getResources().getDrawable(C0419R.drawable.sesl_level_seekbar_progress));
            setTickMark(getContext().getResources().getDrawable(C0419R.drawable.sesl_level_seekbar_tick_mark));
            Drawable drawable = getContext().getResources().getDrawable(C0419R.drawable.sesl_level_seekbar_thumb);
            this.mLevelBarThumbDrawable = drawable;
            setThumb(drawable);
            setBackgroundResource(C0419R.drawable.sesl_seek_bar_background_borderless);
        }
        invalidate();
        this.mIsSetModeCalled = true;
    }

    @Deprecated
    public void setOverlapBackgroundForDualColor(int i) {
        ColorStateList colorStateListColorToColorStateList = colorToColorStateList(i);
        if (!colorStateListColorToColorStateList.equals(this.mOverlapNormalProgressColor)) {
            this.mOverlapNormalProgressColor = colorStateListColorToColorStateList;
        }
        this.mOverlapActivatedProgressColor = this.mOverlapNormalProgressColor;
        this.mLargeFont = true;
    }

    public void setOverlapPointForDualColor(int i) {
        if (i >= getMax()) {
            return;
        }
        this.mSetDualColorMode = true;
        this.mOverlapPoint = i;
        if (i == -1) {
            setProgressTintList(this.mDefaultActivatedProgressColor);
            setThumbTintList(this.mDefaultActivatedThumbColor);
        } else {
            if (this.mOverlapBackground == null) {
                initDualOverlapDrawable();
            }
            updateDualColorMode();
        }
        invalidate();
    }

    @Override // androidx.appcompat.widget.SeslProgressBar
    public synchronized void setProgress(int i) {
        try {
            if (this.mIsSeamless) {
                i = Math.round(i * SCALE_FACTOR);
            }
            super.setProgress(i);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // androidx.appcompat.widget.SeslProgressBar
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setProgressDrawable(Drawable drawable) {
        super.setProgressDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.SeslProgressBar
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean setProgressInternal(int i, boolean z, boolean z2) {
        boolean progressInternal = super.setProgressInternal(i, z, z2);
        updateWarningMode(i);
        updateDualColorMode();
        return progressInternal;
    }

    @Override // androidx.appcompat.widget.SeslProgressBar
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setProgressTintList(@Nullable ColorStateList colorStateList) {
        super.setProgressTintList(colorStateList);
        this.mDefaultActivatedProgressColor = colorStateList;
    }

    public void setSeamless(boolean z) {
        if (this.mIsSeamless != z) {
            this.mIsSeamless = z;
            if (z) {
                super.setMax(Math.round(super.getMax() * SCALE_FACTOR));
                super.setMin(Math.round(super.getMin() * SCALE_FACTOR));
                super.setProgress(Math.round(super.getProgress() * SCALE_FACTOR));
                super.setSecondaryProgress(Math.round(super.getSecondaryProgress() * SCALE_FACTOR));
                return;
            }
            super.setProgress(Math.round(super.getProgress() / SCALE_FACTOR));
            super.setSecondaryProgress(Math.round(super.getSecondaryProgress() / SCALE_FACTOR));
            super.setMax(Math.round(super.getMax() / SCALE_FACTOR));
            super.setMin(Math.round(super.getMin() / SCALE_FACTOR));
        }
    }

    @Override // androidx.appcompat.widget.SeslProgressBar
    public synchronized void setSecondaryProgress(int i) {
        try {
            if (this.mIsSeamless) {
                i = Math.round(i * SCALE_FACTOR);
            }
            super.setSecondaryProgress(i);
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setSplitTrack(boolean z) {
        this.mSplitTrack = z;
        invalidate();
    }

    @Override // android.view.View
    public void setSystemGestureExclusionRects(@NonNull List<Rect> list) {
        Preconditions.checkNotNull(list, "rects must not be null");
        this.mUserGestureExclusionRects = list;
        updateGestureExclusionRects();
    }

    public void setThumb(Drawable drawable) {
        boolean z;
        Drawable drawable2 = this.mThumb;
        if (drawable2 == null || drawable == drawable2) {
            z = false;
        } else {
            drawable2.setCallback(null);
            z = true;
        }
        if (drawable != null) {
            drawable.setCallback(this);
            if (canResolveLayoutDirection()) {
                DrawableCompat.setLayoutDirection(drawable, ViewCompat.getLayoutDirection(this));
            }
            int i = this.mCurrentMode;
            if (i == 3 || i == 6) {
                this.mThumbOffset = drawable.getIntrinsicHeight() / 2;
            } else {
                this.mThumbOffset = drawable.getIntrinsicWidth() / 2;
            }
            if (z && (drawable.getIntrinsicWidth() != this.mThumb.getIntrinsicWidth() || drawable.getIntrinsicHeight() != this.mThumb.getIntrinsicHeight())) {
                requestLayout();
            }
        }
        this.mThumb = drawable;
        applyThumbTint();
        invalidate();
        if (z) {
            updateThumbAndTrackPos(getWidth(), getHeight());
            if (drawable == null || !drawable.isStateful()) {
                return;
            }
            drawable.setState(getDrawableState());
        }
    }

    public void setThumbOffset(int i) {
        this.mThumbOffset = i;
        invalidate();
    }

    public void setThumbTintColor(int i) {
        ColorStateList colorStateListColorToColorStateList = colorToColorStateList(i);
        if (colorStateListColorToColorStateList.equals(this.mDefaultActivatedThumbColor)) {
            return;
        }
        this.mDefaultActivatedThumbColor = colorStateListColorToColorStateList;
    }

    public void setThumbTintList(@Nullable ColorStateList colorStateList) {
        this.mThumbTintList = colorStateList;
        this.mHasThumbTint = true;
        applyThumbTint();
        this.mDefaultActivatedThumbColor = colorStateList;
    }

    public void setThumbTintMode(@Nullable PorterDuff.Mode mode) {
        this.mThumbTintMode = mode;
        this.mHasThumbTintMode = true;
        applyThumbTint();
    }

    public void setTickMark(Drawable drawable) {
        Drawable drawable2 = this.mTickMark;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.mTickMark = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            DrawableCompat.setLayoutDirection(drawable, ViewCompat.getLayoutDirection(this));
            if (drawable.isStateful()) {
                drawable.setState(getDrawableState());
            }
            applyTickMarkTint();
        }
        invalidate();
    }

    public void setTickMarkTintList(@Nullable ColorStateList colorStateList) {
        this.mTickMarkTintList = colorStateList;
        this.mHasTickMarkTint = true;
        applyTickMarkTint();
    }

    public void setTickMarkTintMode(@Nullable PorterDuff.Mode mode) {
        this.mTickMarkTintMode = mode;
        this.mHasTickMarkTintMode = true;
        applyTickMarkTint();
    }

    @Override // androidx.appcompat.widget.SeslProgressBar
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void updateDrawableBounds(int i, int i2) {
        super.updateDrawableBounds(i, i2);
        updateThumbAndTrackPos(i, i2);
        updateBoundsForDualColor();
    }

    public void updateHoverPopup() {
        SeslHoverPopupWindowReflector.update(SeslViewReflector.semGetHoverPopup(this, true));
    }

    @Override // androidx.appcompat.widget.SeslProgressBar, android.view.View
    public boolean verifyDrawable(@NonNull Drawable drawable) {
        return drawable == this.mThumb || drawable == this.mTickMark || super.verifyDrawable(drawable);
    }

    public void onKeyChange() {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void onStopTrackingHover() {
    }

    public SeslAbsSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTempRect = new Rect();
        this.mThumbTintList = null;
        this.mThumbTintMode = null;
        this.mHasThumbTint = false;
        this.mHasThumbTintMode = false;
        this.mTickMarkTintList = null;
        this.mTickMarkTintMode = null;
        this.mHasTickMarkTint = false;
        this.mHasTickMarkTintMode = false;
        this.mIsUserSeekable = true;
        this.mKeyProgressIncrement = 1;
        this.mUserGestureExclusionRects = Collections.EMPTY_LIST;
        this.mGestureExclusionRects = new ArrayList();
        this.mThumbRect = new Rect();
        this.mHoveringLevel = 0;
        this.mOverlapPoint = -1;
        this.mAllowedSeekBarAnimation = false;
        this.mUseMuteAnimation = false;
        this.mIsFirstSetProgress = false;
        this.mIsDraggingForSliding = false;
        this.mLargeFont = false;
        this.mIsTouchDisabled = false;
        this.mSetDualColorMode = false;
        this.mPreviousHoverPopupType = 0;
        this.mIsSetModeCalled = false;
        this.mIsSeamless = false;
        this.mLevelDrawPadding = 0.0f;
    }

    public SeslAbsSeekBar(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public SeslAbsSeekBar(Context context, AttributeSet attributeSet, int i, int i2) throws Throwable {
        SeslAbsSeekBar seslAbsSeekBar;
        Context context2;
        AttributeSet attributeSet2;
        int i4;
        int i5;
        int i6;
        int i7;
        super(context, attributeSet, i, i2);
        this.mTempRect = new Rect();
        this.mThumbTintList = null;
        this.mThumbTintMode = null;
        this.mHasThumbTint = false;
        this.mHasThumbTintMode = false;
        this.mTickMarkTintList = null;
        this.mTickMarkTintMode = null;
        this.mHasTickMarkTint = false;
        this.mHasTickMarkTintMode = false;
        this.mIsUserSeekable = true;
        this.mKeyProgressIncrement = 1;
        this.mUserGestureExclusionRects = Collections.EMPTY_LIST;
        this.mGestureExclusionRects = new ArrayList();
        this.mThumbRect = new Rect();
        this.mHoveringLevel = 0;
        this.mOverlapPoint = -1;
        this.mAllowedSeekBarAnimation = false;
        this.mUseMuteAnimation = false;
        this.mIsFirstSetProgress = false;
        this.mIsDraggingForSliding = false;
        this.mLargeFont = false;
        this.mIsTouchDisabled = false;
        this.mSetDualColorMode = false;
        this.mPreviousHoverPopupType = 0;
        this.mIsSetModeCalled = false;
        this.mIsSeamless = false;
        this.mLevelDrawPadding = 0.0f;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0419R.styleable.AppCompatSeekBar, i, i2);
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                seslAbsSeekBar = this;
                context2 = context;
                attributeSet2 = attributeSet;
                try {
                    seslAbsSeekBar.saveAttributeDataForStyleable(context2, C0419R.styleable.AppCompatSeekBar, attributeSet2, typedArrayObtainStyledAttributes, i, i2);
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } else {
                seslAbsSeekBar = this;
                context2 = context;
                attributeSet2 = attributeSet;
            }
            Resources resources = context2.getResources();
            setThumb(typedArrayObtainStyledAttributes.getDrawable(C0419R.styleable.AppCompatSeekBar_android_thumb));
            if (typedArrayObtainStyledAttributes.hasValue(C0419R.styleable.AppCompatSeekBar_android_thumbTintMode)) {
                seslAbsSeekBar.mThumbTintMode = DrawableUtils.parseTintMode(typedArrayObtainStyledAttributes.getInt(C0419R.styleable.AppCompatSeekBar_android_thumbTintMode, -1), seslAbsSeekBar.mThumbTintMode);
                seslAbsSeekBar.mHasThumbTintMode = true;
            }
            if (typedArrayObtainStyledAttributes.hasValue(C0419R.styleable.AppCompatSeekBar_android_thumbTint)) {
                seslAbsSeekBar.mThumbTintList = typedArrayObtainStyledAttributes.getColorStateList(C0419R.styleable.AppCompatSeekBar_android_thumbTint);
                seslAbsSeekBar.mHasThumbTint = true;
            }
            setTickMark(typedArrayObtainStyledAttributes.getDrawable(C0419R.styleable.AppCompatSeekBar_tickMark));
            if (typedArrayObtainStyledAttributes.hasValue(C0419R.styleable.AppCompatSeekBar_tickMarkTintMode)) {
                seslAbsSeekBar.mTickMarkTintMode = DrawableUtils.parseTintMode(typedArrayObtainStyledAttributes.getInt(C0419R.styleable.AppCompatSeekBar_tickMarkTintMode, -1), seslAbsSeekBar.mTickMarkTintMode);
                seslAbsSeekBar.mHasTickMarkTintMode = true;
            }
            if (typedArrayObtainStyledAttributes.hasValue(C0419R.styleable.AppCompatSeekBar_tickMarkTint)) {
                seslAbsSeekBar.mTickMarkTintList = typedArrayObtainStyledAttributes.getColorStateList(C0419R.styleable.AppCompatSeekBar_tickMarkTint);
                seslAbsSeekBar.mHasTickMarkTint = true;
            }
            seslAbsSeekBar.mSplitTrack = typedArrayObtainStyledAttributes.getBoolean(C0419R.styleable.AppCompatSeekBar_android_splitTrack, false);
            seslAbsSeekBar.mIsHapticEnabled = typedArrayObtainStyledAttributes.getBoolean(C0419R.styleable.AppCompatSeekBar_seslHapticEnabled, true);
            seslAbsSeekBar.mTrackMinWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(C0419R.styleable.AppCompatSeekBar_seslTrackMinWidth, Math.round(resources.getDimension(C0419R.dimen.sesl_seekbar_track_height)));
            seslAbsSeekBar.mTrackMaxWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(C0419R.styleable.AppCompatSeekBar_seslTrackMaxWidth, Math.round(resources.getDimension(C0419R.dimen.sesl_seekbar_track_height_expand)));
            seslAbsSeekBar.mModeExpandTrackMinWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(C0419R.styleable.AppCompatSeekBar_seslTrackMinWidth, Math.round(resources.getDimension(C0419R.dimen.sesl_seekbar_mode_expand_track_height)));
            seslAbsSeekBar.mModeExpandTrackMaxWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(C0419R.styleable.AppCompatSeekBar_seslTrackMaxWidth, Math.round(resources.getDimension(C0419R.dimen.sesl_seekbar_mode_expand_track_height_expand)));
            seslAbsSeekBar.mThumbRadius = typedArrayObtainStyledAttributes.getDimensionPixelSize(C0419R.styleable.AppCompatSeekBar_seslThumbRadius, Math.round(resources.getDimension(C0419R.dimen.sesl_seekbar_thumb_radius)));
            seslAbsSeekBar.mModeExpandThumbRadius = typedArrayObtainStyledAttributes.getDimensionPixelSize(C0419R.styleable.AppCompatSeekBar_seslThumbRadius, Math.round(resources.getDimension(C0419R.dimen.sesl_seekbar_mode_expand_thumb_radius)));
            setThumbOffset(typedArrayObtainStyledAttributes.getDimensionPixelOffset(C0419R.styleable.AppCompatSeekBar_android_thumbOffset, getThumbOffset()));
            if (typedArrayObtainStyledAttributes.hasValue(C0419R.styleable.AppCompatSeekBar_seslSeekBarMode)) {
                seslAbsSeekBar.mCurrentMode = typedArrayObtainStyledAttributes.getInt(C0419R.styleable.AppCompatSeekBar_seslSeekBarMode, 0);
            }
            if (typedArrayObtainStyledAttributes.getBoolean(C0419R.styleable.AppCompatSeekBar_useDisabledAlpha, true)) {
                typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet2, C0419R.styleable.AppCompatTheme, 0, 0);
                try {
                    seslAbsSeekBar.mDisabledAlpha = typedArrayObtainStyledAttributes.getFloat(C0419R.styleable.AppCompatTheme_android_disabledAlpha, 0.5f);
                    typedArrayObtainStyledAttributes.recycle();
                } finally {
                    typedArrayObtainStyledAttributes.recycle();
                }
            } else {
                seslAbsSeekBar.mDisabledAlpha = 1.0f;
            }
            applyThumbTint();
            applyTickMarkTint();
            seslAbsSeekBar.mScaledTouchSlop = ViewConfiguration.get(context2).getScaledTouchSlop();
            boolean zIsLightTheme = SeslMisc.isLightTheme(context2);
            seslAbsSeekBar.mIsLightTheme = zIsLightTheme;
            if (zIsLightTheme) {
                i4 = C0419R.color.sesl_seekbar_control_color_default;
            } else {
                i4 = C0419R.color.sesl_seekbar_control_color_default_dark;
            }
            seslAbsSeekBar.mDefaultNormalProgressColor = colorToColorStateList(resources.getColor(i4));
            seslAbsSeekBar.mDefaultSecondaryProgressColor = colorToColorStateList(resources.getColor(C0419R.color.sesl_seekbar_control_color_secondary));
            seslAbsSeekBar.mDefaultActivatedProgressColor = colorToColorStateList(resources.getColor(C0419R.color.sesl_seekbar_control_color_activated));
            if (seslAbsSeekBar.mIsLightTheme) {
                i5 = C0419R.color.sesl_seekbar_overlap_color_default_light;
            } else {
                i5 = C0419R.color.sesl_seekbar_overlap_color_default_dark;
            }
            seslAbsSeekBar.mOverlapNormalProgressColor = colorToColorStateList(resources.getColor(i5));
            if (seslAbsSeekBar.mIsLightTheme) {
                i6 = C0419R.color.sesl_seekbar_overlap_color_activated_light;
            } else {
                i6 = C0419R.color.sesl_seekbar_overlap_color_activated_dark;
            }
            seslAbsSeekBar.mOverlapActivatedProgressColor = colorToColorStateList(resources.getColor(i6));
            ColorStateList thumbTintList = getThumbTintList();
            seslAbsSeekBar.mDefaultActivatedThumbColor = thumbTintList;
            if (thumbTintList == null) {
                int[][] iArr = {new int[]{R.attr.state_enabled}, new int[]{-16842910}};
                int color = resources.getColor(C0419R.color.sesl_thumb_control_color_activated);
                if (seslAbsSeekBar.mIsLightTheme) {
                    i7 = C0419R.color.sesl_seekbar_disable_color_activated_light;
                } else {
                    i7 = C0419R.color.sesl_seekbar_disable_color_activated_dark;
                }
                seslAbsSeekBar.mDefaultActivatedThumbColor = new ColorStateList(iArr, new int[]{color, resources.getColor(i7)});
            }
            boolean z = resources.getBoolean(C0419R.bool.sesl_seekbar_sliding_animation);
            seslAbsSeekBar.mAllowedSeekBarAnimation = z;
            if (z) {
                initMuteAnimation();
            }
            int i8 = seslAbsSeekBar.mCurrentMode;
            if (i8 != 0) {
                setMode(i8);
            } else {
                initializeExpandMode();
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void onHoverChanged(int i, int i2, int i4) {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void onStartTrackingHover(int i, int i2, int i4) {
    }
}
