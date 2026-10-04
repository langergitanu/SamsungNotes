package androidx.picker.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.PathInterpolator;
import androidx.annotation.NonNull;
import androidx.glance.AbstractC2821a;
import androidx.picker.C3623R;
import androidx.picker.util.SeslSleepTimePickerUtil;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.util.VUtilString;
import com.sun.imageio.plugins.jpeg.JPEG;
import java.util.Objects;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
class SeslCircularSeekBarView extends View {
    private static final int DEFAULT_CIRCLE_COLOR = -3355444;
    private static final int DEFAULT_CIRCLE_FILL_COLOR = 0;
    private static final float DEFAULT_CIRCLE_STROKE_WIDTH = 15.0f;
    private static final boolean DEFAULT_CS_HIDE_PROGRESS_WHEN_EMPTY = false;
    private static final float DEFAULT_END_ANGLE = 270.0f;
    private static final float DEFAULT_FIRST_POINTER_POSITION = 7.5f;
    private static final int DEFAULT_GRID_COLOR_MEDIUM = -7829368;
    private static final int DEFAULT_GRID_COLOR_SMALL = -3355444;
    private static final float DEFAULT_GRID_MEDIUM_ALPHA = 0.7f;
    private static final float DEFAULT_GRID_SMALL_ALPHA = 0.3f;
    private static final int DEFAULT_GRID_STROKE_MEDIUM = 1;
    private static final int DEFAULT_GRID_STROKE_SMALL = 1;
    private static final float DEFAULT_ICON_SIZE = 50.0f;
    private static final boolean DEFAULT_LOCK_ENABLED = true;
    private static final boolean DEFAULT_MAINTAIN_EQUAL_CIRCLE = true;
    private static final int DEFAULT_MAX = 100;
    private static final boolean DEFAULT_MOVE_OUTSIDE_CIRCLE = true;
    private static final float DEFAULT_POINTER_ANGLE = 0.0f;
    private static final float DEFAULT_POINTER_HALO_WIDTH = 15.0f;
    private static final float DEFAULT_POINTER_STROKE_WIDTH = 65.0f;
    private static final int DEFAULT_PROGRESS = 40;
    private static final float DEFAULT_SECOND_POINTER_POSITION = 225.0f;
    private static final float DEFAULT_START_ANGLE = 270.0f;
    private static final float DEGREE_BIAS = 2.5f;
    private static final int FIRST_POINTER = 1;
    private static final float MIN_TOUCH_TARGET_DP = 48.0f;
    private static final int SECOND_POINTER = 0;
    private static final int SLEEP_PICKER_VIBRATION_AT_LOCK = 49;
    private static final float SMALL_DEGREE_BIAS = 0.1f;
    private static final String TAG = "CircularSeekBar";
    private static final float TOTAL_MINUTES = 1440.0f;
    private static final int mExpandCollapseAniDuration = 300;
    private final float DPTOPX_SCALE;
    private final PathInterpolator EXPAND_COLLAPSE_PATH_INTERPOLATOR;
    private final AttributeSet mAttributeSet;
    private Drawable mBedTimeDrawable;
    private final RectF mBedTimeIconRectF;
    private int mCircleColor;
    private int mCircleFillColor;
    private Paint mCircleFillPaint;
    private Path mCircleFirstPointerPath;
    private int mCircleGridMedium;
    private int mCircleGridSmall;
    private float mCircleHeight;
    private Paint mCircleLineProgressPaint;
    private Path mCircleLineProgressPath;
    private Paint mCirclePaint;
    private Path mCirclePath;
    private Paint mCircleProgressPaint;
    private Path mCircleProgressPath;
    private final RectF mCircleRectF;
    private Path mCircleSecondPointerPath;
    private float mCircleStrokeWidth;
    private Paint.Cap mCircleStyle;
    private float mCircleWidth;
    private SeslCircularSeekBarRevealAnimation mCircularSeekBarRevealAnimation;
    private float mDashLineStrokeWidth;
    private final int mDefStyle;
    private float mEndAngle;
    private float mFirstPointerAngle;
    private int mFirstPointerColor;
    private int mFirstPointerHaloColor;
    private Paint mFirstPointerHaloPaint;
    private Paint mFirstPointerPaint;
    private float mFirstPointerPosition;
    private Paint mGridPaintMedium;
    private Paint mGridPaintSmall;
    private float mHandlerTouchPosition;
    private boolean mHideProgressWhenEmpty;
    private float mIconSize;
    private boolean mIsExpandCollapseAnimation;
    private int mLastPointerTouched;
    private boolean mLockAtEnd;
    private boolean mLockAtStart;
    private boolean mLockEnabled;
    private boolean mMaintainEqualCircle;
    private float mMax;
    private int mMiddleGradientColor;
    private boolean mMoveOutsideCircle;
    private OnCircularSeekBarChangeListener mOnCircularSeekBarChangeListener;
    private int mPaddingHorizontal;
    private float mPointerHaloWidth;
    private float mPointerStrokeWidth;
    private float mProgress;
    private float mProgressDegrees;
    private float mRadiusIn;
    private float mRadiusOut;
    private float mSecondPointerAngle;
    private int mSecondPointerColor;
    private int mSecondPointerHaloColor;
    private Paint mSecondPointerHaloPaint;
    private Paint mSecondPointerPaint;
    private float mSecondPointerPosition;
    private boolean mSleepGoalWheelEnable;
    private float mSleepGoalWheelExtendDegree;
    private float mSleepGoalWheelExtendStart;
    private Paint mSleepGoalWheelPaint;
    private Path mSleepGoalWheelPath;
    private final RectF mSleepGoalWheelRectF;
    private float mSleepGoalWheelStrokeWidth;
    private float mStartAngle;
    private SweepGradientVariable mSweepGradientVariable;
    private float mTotalCircleDegrees;
    private float mTouchDistanceFromFirstPointer;
    private float mTouchDistanceFromSecondPointer;
    private TouchEventVariable mTouchEventVariable;
    private boolean mUserIsMovingFirstPointer;
    private boolean mUserIsMovingMiddleHandler;
    private boolean mUserIsMovingSecondPointer;
    private Drawable mWakeUpDrawable;
    private final RectF mWakeUpTimeIconRectF;
    private static final int DEFAULT_CIRCLE_STYLE = Paint.Cap.ROUND.ordinal();
    private static final int DEFAULT_FIRST_POINTER_COLOR = Color.argb(255, 133, 135, JPEG.COM);
    private static final int DEFAULT_MIDDLE_COLOR = Color.argb(255, 133, 135, JPEG.COM);
    private static final int DEFAULT_FIRST_POINTER_HALO_COLOR = Color.argb(255, 133, 135, JPEG.COM);
    private static final int DEFAULT_SECOND_POINTER_COLOR = Color.argb(255, 255, 167, 0);
    private static final int DEFAULT_SECOND_POINTER_HALO_COLOR = Color.argb(255, 255, 167, 0);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnCircularSeekBarChangeListener {
        void onProgressChangedBedTime(SeslCircularSeekBarView seslCircularSeekBarView, float f, float f4, boolean z);

        void onProgressChangedWakeupTime(SeslCircularSeekBarView seslCircularSeekBarView, float f, float f4, boolean z);

        void onSelectBedTimeIcon();

        void onSelectMiddleHandler();

        void onSelectWakeUpTimeIcon();

        void onStartTrackingTouch(SeslCircularSeekBarView seslCircularSeekBarView);

        void onStopTrackingTouch(SeslCircularSeekBarView seslCircularSeekBarView);

        void onUnselectBedTimeIcon();

        void onUnselectMiddleHandler();

        void onUnselectWakeUpTimeIcon();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SweepGradientVariable {
        final int[] color = new int[5];
        final float[] pos = new float[5];
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class TouchEventVariable {
        float additionalRadius;
        float ccwDistanceFromEnd;
        float ccwDistanceFromStart;
        float cwDistanceFromEnd;
        float cwDistanceFromStart;
        float cwPointerFromStart;
        float distanceX;
        float distanceY;
        float innerRadius;
        float minimumTouchTarget;
        float outerRadius;
        boolean pointerNearEnd;
        boolean pointerNearStart;
        float smallInCircle;
        float touchAngle;
        float touchEventRadius;
        boolean touchOverEnd;
        boolean touchOverStart;

        /* JADX INFO: renamed from: x */
        float f1636x;

        /* JADX INFO: renamed from: y */
        float f1637y;
    }

    public SeslCircularSeekBarView(Context context) {
        super(context);
        this.DPTOPX_SCALE = getResources().getDisplayMetrics().density;
        this.mCircleRectF = new RectF();
        this.mBedTimeIconRectF = new RectF();
        this.mWakeUpTimeIconRectF = new RectF();
        this.mSleepGoalWheelRectF = new RectF();
        this.mPaddingHorizontal = 0;
        this.mLockEnabled = true;
        this.mLockAtStart = true;
        this.mLockAtEnd = false;
        this.mUserIsMovingFirstPointer = false;
        this.mUserIsMovingSecondPointer = false;
        this.mUserIsMovingMiddleHandler = false;
        this.mSleepGoalWheelEnable = false;
        this.mIsExpandCollapseAnimation = false;
        this.EXPAND_COLLAPSE_PATH_INTERPOLATOR = new PathInterpolator(0.22f, 0.25f, 0.0f, 1.0f);
        this.mAttributeSet = null;
        this.mDefStyle = 0;
        init();
    }

    private void addPointerTouchListener() {
        OnCircularSeekBarChangeListener onCircularSeekBarChangeListener = this.mOnCircularSeekBarChangeListener;
        if (onCircularSeekBarChangeListener != null) {
            if (this.mUserIsMovingSecondPointer) {
                onCircularSeekBarChangeListener.onProgressChangedWakeupTime(this, getProgress(), this.mSecondPointerPosition, true);
                return;
            }
            if (this.mUserIsMovingFirstPointer) {
                onCircularSeekBarChangeListener.onProgressChangedBedTime(this, getProgress(), this.mFirstPointerPosition, true);
            } else if (this.mUserIsMovingMiddleHandler) {
                onCircularSeekBarChangeListener.onProgressChangedWakeupTime(this, getProgress(), this.mSecondPointerPosition, true);
                this.mOnCircularSeekBarChangeListener.onProgressChangedBedTime(this, getProgress(), this.mFirstPointerPosition, true);
            }
        }
    }

    private void calculateHandlerPosition() {
        float f = this.mHandlerTouchPosition;
        float f4 = f - this.mTouchDistanceFromFirstPointer;
        this.mFirstPointerPosition = f4;
        if (f4 < 0.0f) {
            f4 += 360.0f;
        }
        this.mFirstPointerPosition = f4 % 360.0f;
        float f5 = f + this.mTouchDistanceFromSecondPointer;
        this.mSecondPointerPosition = f5;
        if (f5 < 0.0f) {
            f5 += 360.0f;
        }
        this.mSecondPointerPosition = f5 % 360.0f;
    }

    private void calculatePointerPosition(int i) {
        float f = (this.mProgress / this.mMax) * 360.0f;
        if (i == 1) {
            float f4 = this.mSecondPointerPosition - f;
            this.mFirstPointerPosition = f4;
            if (f4 < 0.0f) {
                f4 += 360.0f;
            }
            this.mFirstPointerPosition = f4 % 360.0f;
            return;
        }
        if (i == 0) {
            float f5 = this.mFirstPointerPosition + f;
            this.mSecondPointerPosition = f5;
            if (f5 < 0.0f) {
                f5 += 360.0f;
            }
            this.mSecondPointerPosition = f5 % 360.0f;
        }
    }

    private void calculateProgressDegrees() {
        float f = this.mSecondPointerPosition - this.mFirstPointerPosition;
        this.mProgressDegrees = f;
        if (f < 0.0f) {
            f += 360.0f;
        }
        this.mProgressDegrees = f;
    }

    private void calculateTotalDegrees() {
        float f = (360.0f - (this.mStartAngle - this.mEndAngle)) % 360.0f;
        this.mTotalCircleDegrees = f;
        if (f <= 0.0f) {
            this.mTotalCircleDegrees = 360.0f;
        }
    }

    private void drawFirstPointer(Canvas canvas) {
        RectF rectF;
        canvas.drawPath(this.mCircleFirstPointerPath, this.mFirstPointerPaint);
        if (this.mIsExpandCollapseAnimation || this.mUserIsMovingFirstPointer) {
            canvas.drawPath(this.mCircleFirstPointerPath, this.mFirstPointerHaloPaint);
        }
        Drawable drawable = this.mBedTimeDrawable;
        if (drawable == null || (rectF = this.mBedTimeIconRectF) == null) {
            return;
        }
        drawable.setBounds((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
        this.mBedTimeDrawable.draw(canvas);
    }

    private void drawSecondPointer(Canvas canvas) {
        RectF rectF;
        canvas.drawPath(this.mCircleSecondPointerPath, this.mSecondPointerPaint);
        if (this.mIsExpandCollapseAnimation || this.mUserIsMovingSecondPointer) {
            canvas.drawPath(this.mCircleSecondPointerPath, this.mSecondPointerHaloPaint);
        }
        Drawable drawable = this.mWakeUpDrawable;
        if (drawable == null || (rectF = this.mWakeUpTimeIconRectF) == null) {
            return;
        }
        drawable.setBounds((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
        this.mWakeUpDrawable.draw(canvas);
    }

    private void init() {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(this.mAttributeSet, C3623R.styleable.seslCircularSeekBar, this.mDefStyle, 0);
        if (typedArrayObtainStyledAttributes != null) {
            initAttributes(typedArrayObtainStyledAttributes);
            typedArrayObtainStyledAttributes.recycle();
        }
        initDrawableIcons();
        initPaints();
        initPaths();
        this.mTouchEventVariable = new TouchEventVariable();
        this.mSweepGradientVariable = new SweepGradientVariable();
    }

    private void initAttributes(TypedArray typedArray) {
        this.mPointerStrokeWidth = typedArray.getDimension(C3623R.styleable.seslCircularSeekBar_csPointerStrokeWidth, DEFAULT_POINTER_STROKE_WIDTH);
        this.mIconSize = typedArray.getDimension(C3623R.styleable.seslCircularSeekBar_csIconWidth, 50.0f);
        this.mPointerHaloWidth = typedArray.getDimension(C3623R.styleable.seslCircularSeekBar_csPointerHaloWidth, 15.0f);
        this.mCircleStrokeWidth = typedArray.getDimension(C3623R.styleable.seslCircularSeekBar_csCircleStrokeWidth, 15.0f);
        this.mSleepGoalWheelStrokeWidth = getResources().getDimension(C3623R.dimen.sesl_sleep_goal_wheel_width);
        this.mDashLineStrokeWidth = getResources().getDimension(C3623R.dimen.sesl_dot_line_stroke_width);
        this.mCircleStyle = Paint.Cap.values()[typedArray.getInt(C3623R.styleable.seslCircularSeekBar_CircleStyle, DEFAULT_CIRCLE_STYLE)];
        this.mMiddleGradientColor = typedArray.getColor(C3623R.styleable.seslCircularSeekBar_csMiddleColor, DEFAULT_MIDDLE_COLOR);
        this.mFirstPointerColor = typedArray.getColor(C3623R.styleable.seslCircularSeekBar_csFirstPointerColor, DEFAULT_FIRST_POINTER_COLOR);
        this.mFirstPointerHaloColor = typedArray.getColor(C3623R.styleable.seslCircularSeekBar_csFirstPointerHaloColor, DEFAULT_FIRST_POINTER_HALO_COLOR);
        this.mSecondPointerColor = typedArray.getColor(C3623R.styleable.seslCircularSeekBar_csSecondPointerColor, DEFAULT_SECOND_POINTER_COLOR);
        this.mSecondPointerHaloColor = typedArray.getColor(C3623R.styleable.seslCircularSeekBar_csSecondPointerHaloColor, DEFAULT_SECOND_POINTER_HALO_COLOR);
        this.mCircleColor = typedArray.getColor(C3623R.styleable.seslCircularSeekBar_csCircleColor, VUtilString.LTGRAY);
        this.mCircleFillColor = typedArray.getColor(C3623R.styleable.seslCircularSeekBar_csCircleFill, 0);
        this.mCircleGridSmall = typedArray.getColor(C3623R.styleable.seslCircularSeekBar_csCircleGridSmallColor, VUtilString.LTGRAY);
        this.mCircleGridMedium = typedArray.getColor(C3623R.styleable.seslCircularSeekBar_csCircleGridMediumColor, -7829368);
        this.mMax = typedArray.getInt(C3623R.styleable.seslCircularSeekBar_csMax, 100);
        this.mProgress = typedArray.getInt(C3623R.styleable.seslCircularSeekBar_csProgress, 40);
        this.mMaintainEqualCircle = typedArray.getBoolean(C3623R.styleable.seslCircularSeekBar_csMaintainEqualCircle, true);
        this.mMoveOutsideCircle = typedArray.getBoolean(C3623R.styleable.seslCircularSeekBar_csMoveOutsideCircle, true);
        this.mLockEnabled = typedArray.getBoolean(C3623R.styleable.seslCircularSeekBar_csLockEnabled, true);
        this.mHideProgressWhenEmpty = typedArray.getBoolean(C3623R.styleable.seslCircularSeekBar_csHideProgressWhenEmpty, false);
        this.mSecondPointerPosition = DEFAULT_FIRST_POINTER_POSITION;
        this.mFirstPointerPosition = DEFAULT_SECOND_POINTER_POSITION;
        this.mStartAngle = ((typedArray.getFloat(C3623R.styleable.seslCircularSeekBar_csStartAngle, 270.0f) % 360.0f) + 360.0f) % 360.0f;
        float f = ((typedArray.getFloat(C3623R.styleable.seslCircularSeekBar_csEndAngle, 270.0f) % 360.0f) + 360.0f) % 360.0f;
        this.mEndAngle = f;
        if (this.mStartAngle % 360.0f == f % 360.0f) {
            this.mEndAngle = f - 0.1f;
        }
        float f4 = ((typedArray.getFloat(C3623R.styleable.seslCircularSeekBar_csPointerAngle, 0.0f) % 360.0f) + 360.0f) % 360.0f;
        this.mSecondPointerAngle = f4;
        if (f4 == 0.0f) {
            this.mSecondPointerAngle = 0.1f;
        }
        float f5 = ((typedArray.getFloat(C3623R.styleable.seslCircularSeekBar_csPointerAngle, 0.0f) % 360.0f) + 360.0f) % 360.0f;
        this.mFirstPointerAngle = f5;
        if (f5 == 0.0f) {
            this.mFirstPointerAngle = 0.1f;
        }
        this.mCircularSeekBarRevealAnimation = new SeslCircularSeekBarRevealAnimation(this);
    }

    private void initDrawableIcons() {
        Drawable drawable;
        Drawable.ConstantState constantState = getResources().getDrawable(C3623R.drawable.sesl_bedtime, null).mutate().getConstantState();
        Objects.requireNonNull(constantState);
        this.mBedTimeDrawable = constantState.newDrawable().mutate();
        Drawable.ConstantState constantState2 = getResources().getDrawable(C3623R.drawable.sesl_wakeup, null).mutate().getConstantState();
        Objects.requireNonNull(constantState2);
        this.mWakeUpDrawable = constantState2.newDrawable().mutate();
        PorterDuffColorFilter porterDuffColorFilter = new PorterDuffColorFilter(getContext().getResources().getColor(C3623R.color.sesl_picker_thumb_icon_color), PorterDuff.Mode.SRC_ATOP);
        if (this.mBedTimeDrawable == null || (drawable = this.mWakeUpDrawable) == null) {
            return;
        }
        drawable.setColorFilter(porterDuffColorFilter);
        this.mBedTimeDrawable.setColorFilter(porterDuffColorFilter);
    }

    private void initPaints() {
        setCirclePaint();
        setCircleFillPaint();
        setCircleProgressPaint();
        setSleepGoalWheelPaint();
        setSecondPointerPaint();
        setFirstPointerPaint();
        setClockGridPaint();
        setDotLinePaint();
    }

    private void initPaths() {
        this.mCirclePath = new Path();
        this.mCircleProgressPath = new Path();
        this.mCircleLineProgressPath = new Path();
        this.mCircleSecondPointerPath = new Path();
        this.mCircleFirstPointerPath = new Path();
        this.mSleepGoalWheelPath = new Path();
    }

    private void initTouchOnFirstPointer() {
        OnCircularSeekBarChangeListener onCircularSeekBarChangeListener = this.mOnCircularSeekBarChangeListener;
        if (onCircularSeekBarChangeListener != null) {
            onCircularSeekBarChangeListener.onSelectBedTimeIcon();
            setProgressBasedOnAngle(this.mFirstPointerPosition, 1);
            setPointerExpandCollapseAnimation(true, 1);
            recalculateAll();
            invalidate();
            this.mOnCircularSeekBarChangeListener.onStartTrackingTouch(this);
            this.mUserIsMovingSecondPointer = false;
            this.mUserIsMovingFirstPointer = true;
            this.mLastPointerTouched = 0;
            this.mLockAtEnd = false;
            this.mLockAtStart = false;
        }
    }

    private void initTouchOnMiddleHandler() {
        float f = this.mHandlerTouchPosition;
        this.mTouchDistanceFromFirstPointer = f - this.mFirstPointerPosition;
        this.mTouchDistanceFromSecondPointer = this.mSecondPointerPosition - f;
        OnCircularSeekBarChangeListener onCircularSeekBarChangeListener = this.mOnCircularSeekBarChangeListener;
        if (onCircularSeekBarChangeListener != null) {
            onCircularSeekBarChangeListener.onSelectMiddleHandler();
            setProgressBasedOnAngle(this.mHandlerTouchPosition, 2);
            recalculateAll();
            invalidate();
            this.mOnCircularSeekBarChangeListener.onStartTrackingTouch(this);
            this.mUserIsMovingMiddleHandler = true;
            this.mUserIsMovingSecondPointer = false;
            this.mUserIsMovingFirstPointer = false;
            this.mLockAtEnd = false;
            this.mLockAtStart = false;
        }
    }

    private void initTouchOnSecondPointer() {
        OnCircularSeekBarChangeListener onCircularSeekBarChangeListener = this.mOnCircularSeekBarChangeListener;
        if (onCircularSeekBarChangeListener != null) {
            onCircularSeekBarChangeListener.onSelectWakeUpTimeIcon();
            setPointerExpandCollapseAnimation(true, 0);
            setProgressBasedOnAngle(this.mSecondPointerPosition, 0);
            recalculateAll();
            invalidate();
            this.mOnCircularSeekBarChangeListener.onStartTrackingTouch(this);
            this.mUserIsMovingSecondPointer = true;
            this.mUserIsMovingFirstPointer = false;
            this.mLastPointerTouched = 1;
            this.mLockAtEnd = false;
            this.mLockAtStart = false;
        }
    }

    private boolean onActionMove(float f, float f4, float f5) {
        TouchEventVariable touchEventVariable = this.mTouchEventVariable;
        float f6 = this.mTotalCircleDegrees;
        float f7 = f6 / 3.0f;
        touchEventVariable.smallInCircle = f7;
        float f8 = this.mSecondPointerPosition;
        float f9 = this.mFirstPointerPosition;
        float f10 = f8 - f9;
        touchEventVariable.cwPointerFromStart = f10;
        if (f10 < 0.0f) {
            f10 += 360.0f;
        }
        touchEventVariable.cwPointerFromStart = f10;
        boolean z = f10 < f7;
        touchEventVariable.pointerNearStart = z;
        boolean z2 = f10 > f6 - f7;
        touchEventVariable.pointerNearEnd = z2;
        if (this.mUserIsMovingSecondPointer) {
            float f11 = f5 - ((f9 + 2.5f) % 360.0f);
            touchEventVariable.cwDistanceFromStart = f11;
            if (f11 < 0.0f) {
                f11 += 360.0f;
            }
            touchEventVariable.cwDistanceFromStart = f11;
            float f12 = 360.0f - f11;
            touchEventVariable.ccwDistanceFromStart = f12;
            float f13 = f5 - (((f9 - 2.5f) + 360.0f) % 360.0f);
            touchEventVariable.cwDistanceFromEnd = f13;
            if (f13 < 0.0f) {
                f13 += 360.0f;
            }
            touchEventVariable.cwDistanceFromEnd = f13;
            touchEventVariable.touchOverStart = f12 < f7;
            touchEventVariable.touchOverEnd = f13 < f7;
            this.mLockEnabled = true;
        } else if (this.mUserIsMovingFirstPointer) {
            float f14 = f5 - (((f8 - 2.5f) + 360.0f) % 360.0f);
            touchEventVariable.cwDistanceFromStart = f14;
            if (f14 < 0.0f) {
                f14 += 360.0f;
            }
            touchEventVariable.cwDistanceFromStart = f14;
            float f15 = f5 - ((f8 + 2.5f) % 360.0f);
            touchEventVariable.cwDistanceFromEnd = f15;
            if (f15 < 0.0f) {
                f15 += 360.0f;
            }
            touchEventVariable.cwDistanceFromEnd = f15;
            float f16 = 360.0f - f15;
            touchEventVariable.ccwDistanceFromEnd = f16;
            touchEventVariable.touchOverStart = f14 < f7;
            touchEventVariable.touchOverEnd = f16 < f7;
            this.mLockEnabled = true;
        } else {
            if (!this.mUserIsMovingMiddleHandler) {
                return false;
            }
            this.mLockAtEnd = false;
            this.mLockAtStart = false;
            this.mLockEnabled = false;
        }
        if (z2) {
            this.mLockAtEnd = touchEventVariable.touchOverEnd;
        } else if (z) {
            this.mLockAtStart = touchEventVariable.touchOverStart;
        }
        if (this.mLockAtStart && this.mLockEnabled) {
            if (this.mProgress != 0.6944445f) {
                this.mProgress = 0.6944445f;
                recalculateAll();
                invalidate();
                addPointerTouchListener();
                SeslSleepTimePickerUtil.performHapticFeedback(this, 49);
            }
        } else if (this.mLockAtEnd && this.mLockEnabled) {
            float f17 = this.mProgress;
            float f18 = this.mMax;
            if (f17 != f18 - 0.6944445f) {
                this.mProgress = f18 - 0.6944445f;
                recalculateAll();
                invalidate();
                addPointerTouchListener();
                SeslSleepTimePickerUtil.performHapticFeedback(this, 49);
            }
        } else if (this.mMoveOutsideCircle || f4 <= f) {
            boolean z3 = this.mUserIsMovingFirstPointer;
            if (this.mUserIsMovingMiddleHandler) {
                setProgressBasedOnAngle(f5, 2);
            } else {
                setProgressBasedOnAngle(f5, z3 ? 1 : 0);
            }
            recalculateAll();
            invalidate();
            addPointerTouchListener();
        }
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        return true;
    }

    private boolean onActionUpCancel() {
        boolean z = this.mUserIsMovingSecondPointer;
        if (!z && !this.mUserIsMovingFirstPointer && !this.mUserIsMovingMiddleHandler) {
            return false;
        }
        if (z) {
            this.mOnCircularSeekBarChangeListener.onUnselectWakeUpTimeIcon();
            setPointerExpandCollapseAnimation(false, 0);
        } else if (this.mUserIsMovingFirstPointer) {
            this.mOnCircularSeekBarChangeListener.onUnselectBedTimeIcon();
            setPointerExpandCollapseAnimation(false, 1);
        } else if (this.mUserIsMovingMiddleHandler) {
            this.mOnCircularSeekBarChangeListener.onUnselectMiddleHandler();
        }
        this.mUserIsMovingSecondPointer = false;
        this.mUserIsMovingFirstPointer = false;
        this.mUserIsMovingMiddleHandler = false;
        this.mOnCircularSeekBarChangeListener.onStopTrackingTouch(this);
        invalidate();
        return true;
    }

    private void recalculateAll() {
        calculateTotalDegrees();
        if (this.mUserIsMovingSecondPointer) {
            calculatePointerPosition(0);
        } else if (this.mUserIsMovingFirstPointer) {
            calculatePointerPosition(1);
        } else if (this.mUserIsMovingMiddleHandler) {
            calculateHandlerPosition();
        }
        calculateProgressDegrees();
        resetRects();
        resetPaths();
        findBedTimeIconLocation();
        findWakeUpTimeIconLocation();
    }

    private void resetPaths() {
        this.mCirclePath.reset();
        this.mCirclePath.addArc(this.mCircleRectF, this.mStartAngle, this.mTotalCircleDegrees);
        float f = this.mFirstPointerPosition;
        float f4 = this.mSecondPointerAngle;
        float f5 = f - (f4 / 2.0f);
        float f6 = this.mSecondPointerPosition - (this.mFirstPointerAngle / 2.0f);
        float f7 = this.mProgressDegrees + f4;
        if (f7 >= 360.0f) {
            f7 = 359.9f;
        }
        this.mCircleProgressPath.reset();
        this.mCircleProgressPath.addArc(this.mCircleRectF, f5, f7);
        if (this.mSleepGoalWheelEnable) {
            this.mSleepGoalWheelPath.reset();
            this.mSleepGoalWheelPath.addArc(this.mSleepGoalWheelRectF, this.mSleepGoalWheelExtendStart, this.mSleepGoalWheelExtendDegree);
        }
        this.mCircleLineProgressPath.reset();
        if (this.mProgress > 6.5d) {
            if (this.mUserIsMovingSecondPointer) {
                this.mCircleLineProgressPath.addArc(this.mCircleRectF, f6, -f7);
            } else {
                this.mCircleLineProgressPath.addArc(this.mCircleRectF, f5, f7);
            }
        }
        float f8 = this.mSecondPointerPosition - (this.mSecondPointerAngle / 2.0f);
        this.mCircleSecondPointerPath.reset();
        this.mCircleSecondPointerPath.addArc(this.mCircleRectF, f8, this.mSecondPointerAngle);
        float f9 = this.mFirstPointerPosition - (this.mFirstPointerAngle / 2.0f);
        this.mCircleFirstPointerPath.reset();
        this.mCircleFirstPointerPath.addArc(this.mCircleRectF, f9, this.mFirstPointerAngle);
    }

    private void resetRects() {
        RectF rectF = this.mCircleRectF;
        float f = this.mCircleWidth;
        float f4 = this.mCircleHeight;
        rectF.set(-f, -f4, f, f4);
        this.mSleepGoalWheelRectF.left = this.mCircleRectF.centerX() - (this.mRadiusIn - 5.0f);
        this.mSleepGoalWheelRectF.top = this.mCircleRectF.centerY() - (this.mRadiusIn - 5.0f);
        this.mSleepGoalWheelRectF.right = (this.mRadiusIn - 5.0f) + this.mCircleRectF.centerY();
        this.mSleepGoalWheelRectF.bottom = (this.mRadiusIn - 5.0f) + this.mCircleRectF.centerY();
    }

    private void setCircleFillPaint() {
        Paint paint = new Paint();
        this.mCircleFillPaint = paint;
        paint.setAntiAlias(true);
        this.mCircleFillPaint.setDither(true);
        this.mCircleFillPaint.setColor(this.mCircleFillColor);
        this.mCircleFillPaint.setStyle(Paint.Style.FILL);
    }

    private void setCirclePaint() {
        Paint paint = new Paint();
        this.mCirclePaint = paint;
        paint.setAntiAlias(true);
        this.mCirclePaint.setDither(true);
        this.mCirclePaint.setColor(this.mCircleColor);
        this.mCirclePaint.setStrokeWidth(this.mCircleStrokeWidth);
        this.mCirclePaint.setStyle(Paint.Style.STROKE);
        this.mCirclePaint.setStrokeJoin(Paint.Join.ROUND);
        this.mCirclePaint.setStrokeCap(this.mCircleStyle);
    }

    private void setCircleProgressPaint() {
        Paint paint = new Paint();
        this.mCircleProgressPaint = paint;
        paint.setAntiAlias(true);
        this.mCircleProgressPaint.setDither(true);
        this.mCircleProgressPaint.setStrokeWidth(this.mCircleStrokeWidth);
        this.mCircleProgressPaint.setStyle(Paint.Style.STROKE);
        this.mCircleProgressPaint.setStrokeJoin(Paint.Join.ROUND);
        this.mCircleProgressPaint.setStrokeCap(this.mCircleStyle);
    }

    private void setClockGridPaint() {
        Paint paint = new Paint(1);
        this.mGridPaintSmall = paint;
        paint.setStrokeWidth(this.DPTOPX_SCALE * 1.0f);
        this.mGridPaintSmall.setColor(this.mCircleGridSmall);
        this.mGridPaintSmall.setAlpha(76);
        Paint paint2 = this.mGridPaintSmall;
        Paint.Style style = Paint.Style.STROKE;
        paint2.setStyle(style);
        Paint paint3 = new Paint(1);
        this.mGridPaintMedium = paint3;
        paint3.setStrokeWidth(this.DPTOPX_SCALE * 1.0f);
        this.mGridPaintMedium.setColor(this.mCircleGridMedium);
        this.mGridPaintMedium.setAlpha(178);
        this.mGridPaintMedium.setStyle(style);
    }

    private void setDotLinePaint() {
        Path path = new Path();
        float f = this.mDashLineStrokeWidth / 2.0f;
        path.addCircle(f, 0.0f, f, Path.Direction.CW);
        Paint paint = new Paint();
        this.mCircleLineProgressPaint = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.mCircleLineProgressPaint.setStrokeWidth(this.mDashLineStrokeWidth);
        this.mCircleLineProgressPaint.setColor(getResources().getColor(C3623R.color.sesl_dotted_line_color));
        this.mCircleLineProgressPaint.setAlpha(178);
        this.mCircleLineProgressPaint.setPathEffect(new PathDashPathEffect(path, getResources().getDimension(C3623R.dimen.sesl_dot_line_gap_width) + this.mDashLineStrokeWidth, 0.0f, PathDashPathEffect.Style.ROTATE));
    }

    private void setFirstPointerPaint() {
        Paint paint = new Paint();
        this.mFirstPointerPaint = paint;
        paint.set(this.mSecondPointerPaint);
        this.mFirstPointerPaint.setColor(this.mFirstPointerColor);
        Paint paint2 = new Paint();
        this.mFirstPointerHaloPaint = paint2;
        paint2.set(this.mSecondPointerHaloPaint);
        this.mFirstPointerHaloPaint.setColor(this.mFirstPointerHaloColor);
        this.mFirstPointerHaloPaint.setStrokeWidth(this.mPointerStrokeWidth);
    }

    private void setPointerExpandCollapseAnimation(boolean z, final int i) {
        this.mIsExpandCollapseAnimation = true;
        ValueAnimator valueAnimatorOfFloat = z ? ValueAnimator.ofFloat(0.0f, 1.0f) : ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat.setDuration(300L).setInterpolator(this.EXPAND_COLLAPSE_PATH_INTERPOLATOR);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: androidx.picker.widget.SeslCircularSeekBarView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (i == 1) {
                    SeslCircularSeekBarView.this.mFirstPointerHaloPaint.setStrokeWidth((SeslCircularSeekBarView.this.mPointerHaloWidth * fFloatValue) + SeslCircularSeekBarView.this.mPointerStrokeWidth);
                } else {
                    SeslCircularSeekBarView.this.mSecondPointerHaloPaint.setStrokeWidth((SeslCircularSeekBarView.this.mPointerHaloWidth * fFloatValue) + SeslCircularSeekBarView.this.mPointerStrokeWidth);
                }
                SeslCircularSeekBarView.this.requestLayout();
                SeslCircularSeekBarView.this.invalidate();
            }
        });
        valueAnimatorOfFloat.start();
    }

    private void setProgressBasedOnAngle(float f, int i) {
        if (i == 0) {
            this.mSecondPointerPosition = f;
        } else if (i == 1) {
            this.mFirstPointerPosition = f;
        } else if (i == 2) {
            this.mHandlerTouchPosition = f;
            float f4 = f - this.mTouchDistanceFromFirstPointer;
            this.mFirstPointerPosition = f4;
            if (f4 < 0.0f) {
                f4 += 360.0f;
            }
            this.mFirstPointerPosition = f4 % 360.0f;
            float f5 = f + this.mTouchDistanceFromSecondPointer;
            this.mSecondPointerPosition = f5;
            if (f5 < 0.0f) {
                f5 += 360.0f;
            }
            this.mSecondPointerPosition = f5 % 360.0f;
        }
        calculateProgressDegrees();
        this.mProgress = (this.mMax * this.mProgressDegrees) / this.mTotalCircleDegrees;
    }

    private void setSecondPointerPaint() {
        Paint paint = new Paint();
        this.mSecondPointerPaint = paint;
        paint.setAntiAlias(true);
        this.mSecondPointerPaint.setDither(true);
        this.mSecondPointerPaint.setColor(this.mSecondPointerColor);
        this.mSecondPointerPaint.setStrokeWidth(this.mPointerStrokeWidth);
        this.mSecondPointerPaint.setStyle(Paint.Style.STROKE);
        this.mSecondPointerPaint.setStrokeJoin(Paint.Join.ROUND);
        this.mSecondPointerPaint.setStrokeCap(this.mCircleStyle);
        Paint paint2 = new Paint();
        this.mSecondPointerHaloPaint = paint2;
        paint2.set(this.mSecondPointerPaint);
        this.mSecondPointerHaloPaint.setColor(this.mSecondPointerHaloColor);
        this.mSecondPointerHaloPaint.setStrokeWidth(this.mPointerStrokeWidth);
    }

    private void setSleepGoalWheelPaint() {
        Paint paint = new Paint();
        this.mSleepGoalWheelPaint = paint;
        paint.setAntiAlias(true);
        this.mSleepGoalWheelPaint.setDither(true);
        this.mSleepGoalWheelPaint.setStrokeWidth(this.mSleepGoalWheelStrokeWidth);
        this.mSleepGoalWheelPaint.setStyle(Paint.Style.STROKE);
        this.mSleepGoalWheelPaint.setStrokeJoin(Paint.Join.ROUND);
        this.mSleepGoalWheelPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mSleepGoalWheelPaint.setColor(getResources().getColor(C3623R.color.sesl_sleep_goal_wheel_color));
    }

    public void drawClockGrid(Canvas canvas) {
        for (double d = 0.0d; d <= 360.0d; d += 2.5d) {
            double d2 = ((((double) this.mStartAngle) + d) / 180.0d) * 3.141592653589793d;
            float fM2210a = (float) AbstractC2821a.m2210a(d2, this.mRadiusIn - (this.DPTOPX_SCALE * 2.5f), this.mCircleRectF.centerX());
            float fM5b = (float) AbstractC0000a.m5b(d2, this.mRadiusIn - (this.DPTOPX_SCALE * 2.5f), this.mCircleRectF.centerY());
            float fM2210a2 = (float) AbstractC2821a.m2210a(d2, (this.DPTOPX_SCALE * 2.5f) + this.mRadiusIn, this.mCircleRectF.centerX());
            float fM5b2 = (float) AbstractC0000a.m5b(d2, (this.DPTOPX_SCALE * 2.5f) + this.mRadiusIn, this.mCircleRectF.centerY());
            double d3 = d % 90.0d;
            if (d3 != 0.0d && d3 != 2.5d && d3 != 3.0d && d3 != 87.0d && d3 != 87.5d && d != 175.0d && d != 185.0d) {
                if (d % 15.0d == 0.0d) {
                    canvas.drawLine(fM2210a, fM5b, fM2210a2, fM5b2, this.mGridPaintMedium);
                } else {
                    canvas.drawLine(fM2210a, fM5b, fM2210a2, fM5b2, this.mGridPaintSmall);
                }
            }
        }
    }

    public void findBedTimeIconLocation() {
        double d = ((double) (this.mFirstPointerPosition / 180.0f)) * 3.141592653589793d;
        this.mBedTimeIconRectF.left = ((float) AbstractC2821a.m2210a(d, this.mRadiusOut, this.mCircleRectF.centerX())) - (this.mIconSize / 2.0f);
        RectF rectF = this.mBedTimeIconRectF;
        float fM5b = (float) AbstractC0000a.m5b(d, this.mRadiusOut, this.mCircleRectF.centerY());
        float f = this.mIconSize;
        rectF.top = fM5b - (f / 2.0f);
        RectF rectF2 = this.mBedTimeIconRectF;
        rectF2.right = rectF2.left + f;
        rectF2.bottom = rectF2.top + f;
    }

    public void findWakeUpTimeIconLocation() {
        double d = ((double) (this.mSecondPointerPosition / 180.0f)) * 3.141592653589793d;
        this.mWakeUpTimeIconRectF.left = ((float) AbstractC2821a.m2210a(d, this.mRadiusOut, this.mCircleRectF.centerX())) - (this.mIconSize / 2.0f);
        RectF rectF = this.mWakeUpTimeIconRectF;
        float fM5b = (float) AbstractC0000a.m5b(d, this.mRadiusOut, this.mCircleRectF.centerY());
        float f = this.mIconSize;
        rectF.top = fM5b - (f / 2.0f);
        RectF rectF2 = this.mWakeUpTimeIconRectF;
        rectF2.right = rectF2.left + f;
        rectF2.bottom = rectF2.top + f;
    }

    public float getProgress() {
        return (this.mMax * this.mProgressDegrees) / this.mTotalCircleDegrees;
    }

    public boolean onActionDown(float f, float f4, float f5, float f6) {
        float fMax = Math.max((float) (((double) (this.mPointerStrokeWidth * 180.0f)) / (((double) Math.max(this.mCircleHeight, this.mCircleWidth)) * 3.141592653589793d)), this.mSecondPointerAngle / 2.0f);
        float f7 = f - this.mSecondPointerPosition;
        if (f7 < 0.0f) {
            f7 += 360.0f;
        }
        float f8 = 360.0f - f7;
        float f9 = this.mFirstPointerPosition;
        float f10 = f - f9;
        if (f10 < 0.0f) {
            f10 += 360.0f;
        }
        float f11 = 360.0f - f10;
        boolean z = f4 >= f5 && f4 <= f6;
        boolean z2 = f7 <= fMax || f8 <= fMax;
        boolean z3 = f10 <= fMax || f11 <= fMax;
        float fConvertToTime = SeslSleepTimePickerUtil.convertToTime(f9);
        float fConvertToTime2 = SeslSleepTimePickerUtil.convertToTime(this.mSecondPointerPosition);
        float fConvertToTime3 = SeslSleepTimePickerUtil.convertToTime(f);
        boolean z4 = fConvertToTime >= fConvertToTime2 ? !(fConvertToTime <= fConvertToTime2 || ((fConvertToTime3 <= fConvertToTime || fConvertToTime3 > TOTAL_MINUTES) && (fConvertToTime3 >= fConvertToTime2 || fConvertToTime3 <= 0.0f))) : !(fConvertToTime3 <= fConvertToTime || fConvertToTime3 >= fConvertToTime2);
        if (z && z2 && z3) {
            if (this.mLastPointerTouched == 0) {
                initTouchOnFirstPointer();
            } else {
                initTouchOnSecondPointer();
            }
        } else if (z && z2) {
            initTouchOnSecondPointer();
        } else if (z && z3) {
            initTouchOnFirstPointer();
        } else {
            if (!z || !z4) {
                this.mUserIsMovingSecondPointer = false;
                this.mUserIsMovingFirstPointer = false;
                this.mUserIsMovingMiddleHandler = false;
                return false;
            }
            this.mHandlerTouchPosition = f;
            initTouchOnMiddleHandler();
        }
        return true;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        requestLayout();
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(getWidth() / 2.0f, getHeight() / 2.0f);
        if (this.mSleepGoalWheelEnable) {
            canvas.drawPath(this.mSleepGoalWheelPath, this.mSleepGoalWheelPaint);
        }
        canvas.drawPath(this.mCirclePath, this.mCircleFillPaint);
        canvas.drawPath(this.mCirclePath, this.mCirclePaint);
        drawClockGrid(canvas);
        SweepGradientVariable sweepGradientVariable = this.mSweepGradientVariable;
        int[] iArr = sweepGradientVariable.color;
        int i = this.mFirstPointerColor;
        iArr[0] = i;
        iArr[1] = i;
        iArr[2] = this.mMiddleGradientColor;
        int i2 = this.mSecondPointerColor;
        iArr[3] = i2;
        iArr[4] = i2;
        float[] fArr = sweepGradientVariable.pos;
        fArr[0] = 0.0f;
        float f = this.mProgress / this.mMax;
        fArr[1] = 0.1f * f;
        fArr[2] = 0.5f * f;
        fArr[3] = 0.9f * f;
        fArr[4] = f;
        float fCenterX = this.mCircleRectF.centerX();
        float fCenterY = this.mCircleRectF.centerY();
        SweepGradientVariable sweepGradientVariable2 = this.mSweepGradientVariable;
        SweepGradient sweepGradient = new SweepGradient(fCenterX, fCenterY, sweepGradientVariable2.color, sweepGradientVariable2.pos);
        Matrix matrix = new Matrix();
        matrix.setRotate(this.mFirstPointerPosition, this.mCircleRectF.centerX(), this.mCircleRectF.centerY());
        sweepGradient.setLocalMatrix(matrix);
        this.mCircleProgressPaint.setShader(sweepGradient);
        canvas.drawPath(this.mCircleProgressPath, this.mCircleProgressPaint);
        canvas.drawPath(this.mCircleLineProgressPath, this.mCircleLineProgressPaint);
        if (this.mLastPointerTouched == 0) {
            drawSecondPointer(canvas);
            drawFirstPointer(canvas);
        } else {
            drawFirstPointer(canvas);
            drawSecondPointer(canvas);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int defaultSize = View.getDefaultSize(getSuggestedMinimumHeight(), i2);
        int defaultSize2 = View.getDefaultSize(getSuggestedMinimumWidth(), i);
        if (defaultSize == 0) {
            defaultSize = defaultSize2;
        }
        if (defaultSize2 == 0) {
            defaultSize2 = defaultSize;
        }
        if (this.mMaintainEqualCircle) {
            int iMin = Math.min(defaultSize2, defaultSize);
            setMeasuredDimension(iMin, iMin);
        } else {
            setMeasuredDimension(defaultSize2, defaultSize);
        }
        this.mPointerStrokeWidth = getResources().getDimension(C3623R.dimen.sesl_sleep_time_pointer_size);
        float dimension = getResources().getDimension(C3623R.dimen.sesl_sleep_time_icon_touch_width);
        this.mPointerHaloWidth = dimension;
        float f = (this.mPointerStrokeWidth / 2.0f) + dimension;
        float f4 = getResources().getConfiguration().screenWidthDp * getResources().getDisplayMetrics().density;
        float f5 = getResources().getConfiguration().screenHeightDp;
        float dimension2 = getResources().getDimension(C3623R.dimen.sesl_sleep_visual_edit_outer_circle_size);
        if (SeslSleepTimePickerUtil.needBedTimePickerAdjustment(f5)) {
            dimension2 = (int) getResources().getDimension(C3623R.dimen.sesl_sleep_visual_edit_outer_circle_min_size);
        }
        float f6 = (f4 / 2.0f) - (this.mPaddingHorizontal + f);
        this.mCircleWidth = f6;
        float f7 = (dimension2 / 2.0f) - f;
        this.mCircleHeight = f7;
        if (this.mMaintainEqualCircle) {
            float fMin = Math.min(f7, f6);
            this.mCircleHeight = fMin;
            this.mCircleWidth = fMin;
        }
        this.mRadiusOut = this.mCircleHeight;
        this.mRadiusIn = ((this.mCircleHeight - (this.mPointerStrokeWidth / 2.0f)) - this.mPointerHaloWidth) - getResources().getDimension(C3623R.dimen.sesl_sleep_picker_inner_grid_offset);
        recalculateAll();
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Bundle bundle = (Bundle) parcelable;
        super.onRestoreInstanceState(bundle.getParcelable("PARENT"));
        this.mMax = bundle.getFloat("MAX");
        this.mProgress = bundle.getFloat("PROGRESS");
        this.mProgressDegrees = bundle.getFloat("mProgressDegrees");
        this.mSecondPointerPosition = bundle.getFloat("mSecondPointerPosition");
        this.mFirstPointerPosition = bundle.getFloat("mFirstPointerPosition");
        this.mSecondPointerAngle = bundle.getFloat("mSecondPointerAngle");
        this.mLockEnabled = bundle.getBoolean("mLockEnabled");
        this.mLockAtStart = bundle.getBoolean("mLockAtStart");
        this.mLockAtEnd = bundle.getBoolean("mLockAtEnd");
        this.mCircleStyle = Paint.Cap.values()[bundle.getInt("mCircleStyle")];
        this.mLastPointerTouched = bundle.getInt("mLastPointerTouched");
        this.mHideProgressWhenEmpty = bundle.getBoolean("mHideProgressWhenEmpty");
        initPaints();
        recalculateAll();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Parcelable parcelableOnSaveInstanceState = super.onSaveInstanceState();
        Bundle bundle = new Bundle();
        bundle.putParcelable("PARENT", parcelableOnSaveInstanceState);
        bundle.putFloat("MAX", this.mMax);
        bundle.putFloat("PROGRESS", this.mProgress);
        bundle.putFloat("mProgressDegrees", this.mProgressDegrees);
        bundle.putFloat("mSecondPointerPosition", this.mSecondPointerPosition);
        bundle.putFloat("mFirstPointerPosition", this.mFirstPointerPosition);
        bundle.putFloat("mSecondPointerAngle", this.mSecondPointerAngle);
        bundle.putBoolean("mLockEnabled", this.mLockEnabled);
        bundle.putBoolean("mLockAtStart", this.mLockAtStart);
        bundle.putBoolean("mLockAtEnd", this.mLockAtEnd);
        bundle.putInt("mCircleStyle", this.mCircleStyle.ordinal());
        bundle.putInt("mLastPointerTouched", this.mLastPointerTouched);
        bundle.putBoolean("mHideProgressWhenEmpty", this.mHideProgressWhenEmpty);
        return bundle;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i4, int i5) {
        super.onSizeChanged(i, i2, i4, i5);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled() || this.mCircularSeekBarRevealAnimation.isRevealAnimation()) {
            return false;
        }
        this.mTouchEventVariable.f1636x = motionEvent.getX() - (getWidth() / 2.0f);
        this.mTouchEventVariable.f1637y = motionEvent.getY() - (getHeight() / 2.0f);
        TouchEventVariable touchEventVariable = this.mTouchEventVariable;
        float fCenterX = this.mCircleRectF.centerX();
        TouchEventVariable touchEventVariable2 = this.mTouchEventVariable;
        touchEventVariable.distanceX = fCenterX - touchEventVariable2.f1636x;
        float fCenterY = this.mCircleRectF.centerY();
        TouchEventVariable touchEventVariable3 = this.mTouchEventVariable;
        touchEventVariable2.distanceY = fCenterY - touchEventVariable3.f1637y;
        touchEventVariable3.touchEventRadius = (float) Math.sqrt(Math.pow(this.mTouchEventVariable.distanceY, 2.0d) + Math.pow(touchEventVariable3.distanceX, 2.0d));
        TouchEventVariable touchEventVariable4 = this.mTouchEventVariable;
        float f = this.DPTOPX_SCALE * 48.0f;
        touchEventVariable4.minimumTouchTarget = f;
        float f4 = this.mCircleStrokeWidth;
        touchEventVariable4.additionalRadius = f4 < f ? f / 2.0f : f4 / 2.0f;
        float fMax = Math.max(this.mCircleHeight, this.mCircleWidth);
        TouchEventVariable touchEventVariable5 = this.mTouchEventVariable;
        touchEventVariable4.outerRadius = fMax + touchEventVariable5.additionalRadius;
        float fMin = Math.min(this.mCircleHeight, this.mCircleWidth);
        TouchEventVariable touchEventVariable6 = this.mTouchEventVariable;
        touchEventVariable5.innerRadius = fMin - touchEventVariable6.additionalRadius;
        touchEventVariable6.touchAngle = (float) (((Math.atan2(touchEventVariable6.f1637y, touchEventVariable6.f1636x) / 3.141592653589793d) * 180.0d) % 360.0d);
        TouchEventVariable touchEventVariable7 = this.mTouchEventVariable;
        float f5 = touchEventVariable7.touchAngle;
        if (f5 < 0.0f) {
            f5 += 360.0f;
        }
        touchEventVariable7.touchAngle = f5;
        int action = motionEvent.getAction();
        if (action == 0) {
            TouchEventVariable touchEventVariable8 = this.mTouchEventVariable;
            return onActionDown(touchEventVariable8.touchAngle, touchEventVariable8.touchEventRadius, touchEventVariable8.innerRadius, touchEventVariable8.outerRadius);
        }
        if (action == 1) {
            return onActionUpCancel();
        }
        if (action == 2) {
            TouchEventVariable touchEventVariable9 = this.mTouchEventVariable;
            return onActionMove(touchEventVariable9.outerRadius, touchEventVariable9.touchEventRadius, touchEventVariable9.touchAngle);
        }
        if (action != 3) {
            return true;
        }
        Log.d(TAG, "MotionEvent.ACTION_CANCEL");
        return onActionUpCancel();
    }

    public void setBedTimePosition(float f) {
        setProgressBasedOnAngle(((f % 360.0f) + 360.0f) % 360.0f, 1);
        recalculateAll();
        invalidate();
    }

    public void setCircularSeekBarHorizontalPadding(int i) {
        this.mPaddingHorizontal = i;
        resetRects();
        resetPaths();
        invalidate();
    }

    public void setOnSeekBarChangeListener(OnCircularSeekBarChangeListener onCircularSeekBarChangeListener) {
        this.mOnCircularSeekBarChangeListener = onCircularSeekBarChangeListener;
    }

    public void setRevealAnimationValue(float f) {
        setProgressBasedOnAngle((this.mFirstPointerPosition + (((this.mCircularSeekBarRevealAnimation.getmSweepProgress() + 360.0f) % 360.0f) * f)) % 360.0f, 0);
        recalculateAll();
    }

    public void setSleepGoalWheel(float f, float f4) {
        this.mSleepGoalWheelEnable = true;
        float f5 = this.mSecondPointerAngle;
        float f6 = f - (f5 / 2.0f);
        float f7 = f4 - f;
        if (f7 < 0.0f) {
            f7 += 360.0f;
        }
        this.mSleepGoalWheelExtendStart = f6;
        this.mSleepGoalWheelExtendDegree = f7 + f5;
        resetRects();
        resetPaths();
        invalidate();
    }

    public void setWakeUpTimePosition(float f) {
        setProgressBasedOnAngle(((f % 360.0f) + 360.0f) % 360.0f, 0);
        recalculateAll();
        invalidate();
    }

    public void startRevealAnimation() {
        calculateProgressDegrees();
        this.mCircularSeekBarRevealAnimation.setmSweepProgress(this.mProgressDegrees);
        this.mCircularSeekBarRevealAnimation.startAnimators();
    }

    public SeslCircularSeekBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.DPTOPX_SCALE = getResources().getDisplayMetrics().density;
        this.mCircleRectF = new RectF();
        this.mBedTimeIconRectF = new RectF();
        this.mWakeUpTimeIconRectF = new RectF();
        this.mSleepGoalWheelRectF = new RectF();
        this.mPaddingHorizontal = 0;
        this.mLockEnabled = true;
        this.mLockAtStart = true;
        this.mLockAtEnd = false;
        this.mUserIsMovingFirstPointer = false;
        this.mUserIsMovingSecondPointer = false;
        this.mUserIsMovingMiddleHandler = false;
        this.mSleepGoalWheelEnable = false;
        this.mIsExpandCollapseAnimation = false;
        this.EXPAND_COLLAPSE_PATH_INTERPOLATOR = new PathInterpolator(0.22f, 0.25f, 0.0f, 1.0f);
        this.mAttributeSet = attributeSet;
        this.mDefStyle = 0;
        init();
    }

    public SeslCircularSeekBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.DPTOPX_SCALE = getResources().getDisplayMetrics().density;
        this.mCircleRectF = new RectF();
        this.mBedTimeIconRectF = new RectF();
        this.mWakeUpTimeIconRectF = new RectF();
        this.mSleepGoalWheelRectF = new RectF();
        this.mPaddingHorizontal = 0;
        this.mLockEnabled = true;
        this.mLockAtStart = true;
        this.mLockAtEnd = false;
        this.mUserIsMovingFirstPointer = false;
        this.mUserIsMovingSecondPointer = false;
        this.mUserIsMovingMiddleHandler = false;
        this.mSleepGoalWheelEnable = false;
        this.mIsExpandCollapseAnimation = false;
        this.EXPAND_COLLAPSE_PATH_INTERPOLATOR = new PathInterpolator(0.22f, 0.25f, 0.0f, 1.0f);
        this.mAttributeSet = attributeSet;
        this.mDefStyle = i;
        init();
    }
}
