package com.samsung.android.sdk.pen.setting.quicktool;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.animation.C0421a;
import androidx.collection.AbstractC0622a;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.setting.quicktool.SpenCurvedDialer;
import com.samsung.android.sdk.pen.setting.quicktool.SpenCurvedDialerBackgroundDrawable;
import com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTUtil;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtil;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilAnimation;
import com.samsung.android.spen.C7932R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0019\b\u0000\u0018\u0000 R2\u00020\u0001:\u0005RSTUVB\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010+\u001a\u00020,J\u0010\u0010-\u001a\u00020,2\b\u0010.\u001a\u0004\u0018\u00010\tJ\u0010\u0010/\u001a\u00020,2\b\u0010.\u001a\u0004\u0018\u00010*J\u0010\u00100\u001a\u00020,2\b\u0010.\u001a\u0004\u0018\u00010\u000bJ\u0010\u00101\u001a\u00020,2\b\u0010.\u001a\u0004\u0018\u00010\rJ\u0016\u00102\u001a\u00020,2\u0006\u00103\u001a\u00020\u00172\u0006\u00104\u001a\u00020\u0017J\u000e\u00105\u001a\u00020,2\u0006\u00106\u001a\u00020\u001bJ\u0018\u00107\u001a\u00020,2\u0006\u00106\u001a\u00020\u001b2\b\b\u0002\u00108\u001a\u00020\"J\u000e\u00109\u001a\u00020,2\u0006\u0010:\u001a\u00020\u001bJ\b\u0010;\u001a\u00020,H\u0014J\u0010\u0010<\u001a\u00020\"2\u0006\u0010=\u001a\u00020>H\u0016J\u000e\u0010?\u001a\u00020,2\u0006\u0010@\u001a\u00020\"J\u0016\u0010A\u001a\u00020\"2\u0006\u0010B\u001a\u00020\u00172\u0006\u0010C\u001a\u00020\u0017J\u0010\u0010D\u001a\u00020,2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\b\u0010E\u001a\u00020,H\u0002J\u001a\u0010F\u001a\u00020,2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010G\u001a\u00020,2\u0006\u00106\u001a\u00020\u001bH\u0002J\u0018\u0010H\u001a\u00020,2\u0006\u0010I\u001a\u00020\u001b2\u0006\u0010J\u001a\u00020\u001bH\u0002J\u0010\u0010K\u001a\u00020\u00172\u0006\u00106\u001a\u00020\u001bH\u0002J\u0010\u0010L\u001a\u00020\u001b2\u0006\u0010M\u001a\u00020\u0017H\u0002J\u0010\u0010N\u001a\u00020\"2\u0006\u0010O\u001a\u00020>H\u0002J\b\u0010P\u001a\u00020,H\u0002J\b\u0010Q\u001a\u00020,H\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006W"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenCurvedDialer;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mChangedListener", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenCurvedDialer$OnChangedListener;", "mActionListener", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenCurvedDialer$OnActionListener;", "mCurvedDialerTrackListener", "Lcom/samsung/android/sdk/pen/setting/quicktool/OnCurvedDialerTrackListener;", "mCircularRoundLayout", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenCircularRoundLayout;", "mHandler", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenCurvedDialHandler;", "mCircularDotDrawable", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenCurvedDialerBackgroundDrawable;", "mCenter", "Landroid/graphics/PointF;", "mRadius", "", "mAngleStart", "mAngleEnd", "mColor", "", "mValue", "mAngleTracker", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenCircularAngleTracker;", "mGestureDetector", "Landroid/view/GestureDetector;", "isScrolling", "", "isHandlerTouched", "isDialTouched", "mDotSizeAnimator", "Landroid/animation/ValueAnimator;", "mCurrentDotSizeScale", "mIsAnimationCancelled", "mAnimationListener", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenCurvedDialer$OnAnimationListener;", "close", "", "setOnChangedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnAnimationListener", "setOnActionListener", "setCurvedDialerTrackListener", "setAngleRange", "startAngle", "endAngle", "setMaxDotsVisible", "value", "setValue", "fromUser", "setColor", "color", "onFinishInflate", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "startVisibilityAnimation", "isShow", "isRawPointInView", "rawX", "rawY", "initView", "updateAngle", "setAttributes", "setPositionByValue", "notifyHapticFeedback", "oldValue", "newValue", "getAngleFromValue", "getValueFromAngle", "angle", "isHandlerTouch", "e", "notifyStartTrackingTouchListener", "notifyStopTrackingTouchListener", "Companion", "OnChangedListener", "OnAnimationListener", "OnActionListener", "GestureListener", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenCurvedDialer extends ConstraintLayout {
    private static final float ANGLE_STEP = 2.7f;
    private static final float ANGULAR_DECELERATION = 200.0f;
    private static final long DOT_HIDE_ANIMATION_DURATION = 350;
    private static final long DOT_SHOW_ANIMATION_DURATION = 400;
    private static final float HANDLER_ANGLE = 180.0f;
    private static final int HAPTIC_INDEX_EFFECT_TICK = 41;
    private static final int MAX_VALUE = 100;
    private static final int MID_VALUE = 50;
    private static final int MIN_VALUE = 1;

    @NotNull
    private static final String TAG = "SpenCurvedDialer";
    private boolean isDialTouched;
    private boolean isHandlerTouched;
    private boolean isScrolling;

    @Nullable
    private OnActionListener mActionListener;
    private float mAngleEnd;
    private float mAngleStart;
    private SpenCircularAngleTracker mAngleTracker;

    @Nullable
    private OnAnimationListener mAnimationListener;
    private PointF mCenter;

    @Nullable
    private OnChangedListener mChangedListener;

    @Nullable
    private SpenCurvedDialerBackgroundDrawable mCircularDotDrawable;

    @Nullable
    private SpenCircularRoundLayout mCircularRoundLayout;
    private int mColor;
    private float mCurrentDotSizeScale;

    @Nullable
    private OnCurvedDialerTrackListener mCurvedDialerTrackListener;

    @Nullable
    private ValueAnimator mDotSizeAnimator;

    @NotNull
    private GestureDetector mGestureDetector;

    @Nullable
    private SpenCurvedDialHandler mHandler;
    private boolean mIsAnimationCancelled;
    private float mRadius;
    private int mValue;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J*\u0010\t\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0016J*\u0010\u000f\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\rH\u0016¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenCurvedDialer$GestureListener;", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "<init>", "(Lcom/samsung/android/sdk/pen/setting/quicktool/SpenCurvedDialer;)V", "onDown", "", "e", "Landroid/view/MotionEvent;", "onSingleTapUp", "onScroll", "e1", "e2", "distanceX", "", "distanceY", "onFling", "velocityX", "velocityY", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public final class GestureListener extends GestureDetector.SimpleOnGestureListener {
        public GestureListener() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(@NotNull MotionEvent e) {
            Intrinsics.checkNotNullParameter(e, "e");
            SpenCurvedDialer.this.isScrolling = false;
            SpenCurvedDialer spenCurvedDialer = SpenCurvedDialer.this;
            spenCurvedDialer.isHandlerTouched = spenCurvedDialer.isHandlerTouch(e);
            SpenCurvedDialer spenCurvedDialer2 = SpenCurvedDialer.this;
            spenCurvedDialer2.isDialTouched = spenCurvedDialer2.isRawPointInView(e.getRawX(), e.getRawY());
            if (!SpenCurvedDialer.this.isDialTouched && !SpenCurvedDialer.this.isHandlerTouched) {
                return super.onDown(e);
            }
            SpenCircularAngleTracker spenCircularAngleTracker = SpenCurvedDialer.this.mAngleTracker;
            PointF pointF = null;
            if (spenCircularAngleTracker == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAngleTracker");
                spenCircularAngleTracker = null;
            }
            spenCircularAngleTracker.setCurrentValue(SpenCurvedDialer.this.mValue);
            SpenCircularAngleTracker spenCircularAngleTracker2 = SpenCurvedDialer.this.mAngleTracker;
            if (spenCircularAngleTracker2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAngleTracker");
                spenCircularAngleTracker2 = null;
            }
            PointF pointF2 = SpenCurvedDialer.this.mCenter;
            if (pointF2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCenter");
            } else {
                pointF = pointF2;
            }
            spenCircularAngleTracker2.start(SpenSettingQTUtil.getAngleByTouch(e, pointF));
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(@Nullable MotionEvent e12, @NotNull MotionEvent e2, float velocityX, float velocityY) {
            Intrinsics.checkNotNullParameter(e2, "e2");
            SpenCircularAngleTracker spenCircularAngleTracker = SpenCurvedDialer.this.mAngleTracker;
            SpenCircularAngleTracker spenCircularAngleTracker2 = null;
            if (spenCircularAngleTracker == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAngleTracker");
                spenCircularAngleTracker = null;
            }
            SpenSettingQTUtil.ScrollDirection scrollDirection = spenCircularAngleTracker.getScrollDirection();
            if (scrollDirection == SpenSettingQTUtil.ScrollDirection.DIR_NONE) {
                return false;
            }
            SpenCurvedDialer.this.isScrolling = false;
            float fSqrt = ((float) Math.sqrt((velocityY * velocityY) + (velocityX * velocityX))) / SpenCurvedDialer.this.mRadius;
            double degrees = Math.toDegrees((fSqrt * fSqrt) / 400.0f);
            SpenCurvedDialer spenCurvedDialer = SpenCurvedDialer.this;
            SpenCircularAngleTracker spenCircularAngleTracker3 = spenCurvedDialer.mAngleTracker;
            if (spenCircularAngleTracker3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAngleTracker");
            } else {
                spenCircularAngleTracker2 = spenCircularAngleTracker3;
            }
            double angleFromValue = spenCurvedDialer.getAngleFromValue(spenCircularAngleTracker2.getCurrentValue());
            if (scrollDirection == SpenSettingQTUtil.ScrollDirection.DIR_CLOCK_WISE) {
                degrees = -degrees;
            }
            double d = angleFromValue + degrees;
            SpenCurvedDialerBackgroundDrawable spenCurvedDialerBackgroundDrawable = SpenCurvedDialer.this.mCircularDotDrawable;
            if (spenCurvedDialerBackgroundDrawable == null) {
                return true;
            }
            final SpenCurvedDialer spenCurvedDialer2 = SpenCurvedDialer.this;
            spenCurvedDialerBackgroundDrawable.startAnimation((float) d, new SpenCurvedDialerBackgroundDrawable.AnimationListener() { // from class: com.samsung.android.sdk.pen.setting.quicktool.SpenCurvedDialer$GestureListener$onFling$1
                @Override // com.samsung.android.sdk.pen.setting.quicktool.SpenCurvedDialerBackgroundDrawable.AnimationListener
                public void onAnimationEnd() {
                    SpenCurvedDialer.OnChangedListener onChangedListener = spenCurvedDialer2.mChangedListener;
                    if (onChangedListener != null) {
                        onChangedListener.onChanged(spenCurvedDialer2.mValue, true);
                    }
                    spenCurvedDialer2.notifyStopTrackingTouchListener();
                }

                @Override // com.samsung.android.sdk.pen.setting.quicktool.SpenCurvedDialerBackgroundDrawable.AnimationListener
                public void onAnimationUpdate(float value) {
                    spenCurvedDialer2.setValue(spenCurvedDialer2.getValueFromAngle(value), true);
                }

                @Override // com.samsung.android.sdk.pen.setting.quicktool.SpenCurvedDialerBackgroundDrawable.AnimationListener
                public void onAnimationStart() {
                }
            });
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(@Nullable MotionEvent e12, @NotNull MotionEvent e2, float distanceX, float distanceY) {
            Intrinsics.checkNotNullParameter(e2, "e2");
            if (!SpenCurvedDialer.this.isScrolling) {
                SpenCurvedDialer.this.notifyStartTrackingTouchListener();
            }
            SpenCurvedDialer.this.isScrolling = true;
            SpenCircularAngleTracker spenCircularAngleTracker = SpenCurvedDialer.this.mAngleTracker;
            SpenCircularAngleTracker spenCircularAngleTracker2 = null;
            if (spenCircularAngleTracker == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAngleTracker");
                spenCircularAngleTracker = null;
            }
            PointF pointF = SpenCurvedDialer.this.mCenter;
            if (pointF == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCenter");
                pointF = null;
            }
            spenCircularAngleTracker.move(SpenSettingQTUtil.getAngleByTouch(e2, pointF));
            SpenCurvedDialer spenCurvedDialer = SpenCurvedDialer.this;
            SpenCircularAngleTracker spenCircularAngleTracker3 = spenCurvedDialer.mAngleTracker;
            if (spenCircularAngleTracker3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAngleTracker");
            } else {
                spenCircularAngleTracker2 = spenCircularAngleTracker3;
            }
            spenCurvedDialer.setValue(spenCircularAngleTracker2.getCurrentValue(), true);
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(@NotNull MotionEvent e) {
            Intrinsics.checkNotNullParameter(e, "e");
            if (SpenCurvedDialer.this.isHandlerTouched) {
                OnActionListener onActionListener = SpenCurvedDialer.this.mActionListener;
                if (onActionListener != null) {
                    onActionListener.onDialerHandlerClicked();
                }
                return true;
            }
            PointF pointF = SpenCurvedDialer.this.mCenter;
            if (pointF == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCenter");
                pointF = null;
            }
            int angleByTouch = (int) ((SpenCurvedDialer.HANDLER_ANGLE - SpenSettingQTUtil.getAngleByTouch(e, pointF)) / SpenCurvedDialer.ANGLE_STEP);
            if (angleByTouch == 0) {
                return false;
            }
            if (angleByTouch > 0 && SpenCurvedDialer.this.mValue == 100) {
                return false;
            }
            if (angleByTouch < 0 && SpenCurvedDialer.this.mValue == 1) {
                return false;
            }
            SpenCurvedDialer spenCurvedDialer = SpenCurvedDialer.this;
            float angleFromValue = spenCurvedDialer.getAngleFromValue(spenCurvedDialer.mValue + angleByTouch);
            SpenCurvedDialerBackgroundDrawable spenCurvedDialerBackgroundDrawable = SpenCurvedDialer.this.mCircularDotDrawable;
            if (spenCurvedDialerBackgroundDrawable != null) {
                final SpenCurvedDialer spenCurvedDialer2 = SpenCurvedDialer.this;
                spenCurvedDialerBackgroundDrawable.startAnimation(angleFromValue, new SpenCurvedDialerBackgroundDrawable.AnimationListener() { // from class: com.samsung.android.sdk.pen.setting.quicktool.SpenCurvedDialer$GestureListener$onSingleTapUp$1
                    @Override // com.samsung.android.sdk.pen.setting.quicktool.SpenCurvedDialerBackgroundDrawable.AnimationListener
                    public void onAnimationEnd() {
                        SpenCurvedDialer.OnChangedListener onChangedListener = spenCurvedDialer2.mChangedListener;
                        if (onChangedListener != null) {
                            onChangedListener.onChanged(spenCurvedDialer2.mValue, true);
                        }
                        spenCurvedDialer2.notifyStopTrackingTouchListener();
                    }

                    @Override // com.samsung.android.sdk.pen.setting.quicktool.SpenCurvedDialerBackgroundDrawable.AnimationListener
                    public void onAnimationStart() {
                        spenCurvedDialer2.notifyStartTrackingTouchListener();
                    }

                    @Override // com.samsung.android.sdk.pen.setting.quicktool.SpenCurvedDialerBackgroundDrawable.AnimationListener
                    public void onAnimationUpdate(float value) {
                        spenCurvedDialer2.setValue(spenCurvedDialer2.getValueFromAngle(value), true);
                    }
                });
            }
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenCurvedDialer$OnActionListener;", "", "onDialerHandlerClicked", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnActionListener {
        void onDialerHandlerClicked();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenCurvedDialer$OnAnimationListener;", "", "onVisibilityAnimationEnd", "", "isShowAnimation", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnAnimationListener {
        void onVisibilityAnimationEnd(boolean isShowAnimation);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenCurvedDialer$OnChangedListener;", "", "onChanged", "", "value", "", "fromUser", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnChangedListener {
        void onChanged(int value, boolean fromUser);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenCurvedDialer(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mCurrentDotSizeScale = 1.0f;
        setAttributes(context, attributeSet);
        this.mGestureDetector = new GestureDetector(context, new GestureListener());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float getAngleFromValue(int value) {
        return (value * ANGLE_STEP) - 135.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getValueFromAngle(float angle) {
        return RangesKt.coerceIn((int) ((angle + 135.0f) / ANGLE_STEP), 1, 100);
    }

    private final void initView(Context context) {
        PointF pointF = new PointF();
        this.mCenter = pointF;
        pointF.x = context.getResources().getDimensionPixelSize(C7932R.dimen.qt_circle_default_size) / 2;
        PointF pointF2 = this.mCenter;
        if (pointF2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCenter");
            pointF2 = null;
        }
        pointF2.y = context.getResources().getDimensionPixelSize(C7932R.dimen.qt_circle_default_size) / 2;
        this.mRadius = (context.getResources().getDimensionPixelSize(C7932R.dimen.qt_dial_width) - context.getResources().getDimensionPixelSize(C7932R.dimen.qt_dial_stroke_size)) / 2.0f;
        this.mAngleTracker = new SpenCircularAngleTracker(ANGLE_STEP);
        this.mCircularRoundLayout = (SpenCircularRoundLayout) findViewById(C7932R.id.circular_mask_layout);
        updateAngle();
        PointF pointF3 = new PointF();
        pointF3.x = context.getResources().getDimensionPixelSize(C7932R.dimen.qt_dial_width) / 2;
        pointF3.y = context.getResources().getDimensionPixelSize(C7932R.dimen.qt_dial_width) / 2;
        this.mCircularDotDrawable = new SpenCurvedDialerBackgroundDrawable(context, pointF3);
        View viewFindViewById = findViewById(C7932R.id.dialer_background);
        if (viewFindViewById != null) {
            viewFindViewById.setBackground(this.mCircularDotDrawable);
        }
        setPositionByValue(this.mValue);
        SpenCurvedDialHandler spenCurvedDialHandler = (SpenCurvedDialHandler) findViewById(C7932R.id.attr_handler);
        this.mHandler = spenCurvedDialHandler;
        if (spenCurvedDialHandler != null) {
            spenCurvedDialHandler.setColor(this.mColor);
        }
        SpenCurvedDialHandler spenCurvedDialHandler2 = this.mHandler;
        if (spenCurvedDialHandler2 != null) {
            spenCurvedDialHandler2.setValue(this.mValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isHandlerTouch(MotionEvent e) {
        SpenCurvedDialHandler spenCurvedDialHandler = this.mHandler;
        if (spenCurvedDialHandler == null) {
            return false;
        }
        int[] iArr = new int[2];
        spenCurvedDialHandler.getLocationOnScreen(iArr);
        int i = iArr[0];
        return new Rect(i, iArr[1], spenCurvedDialHandler.getWidth() + i, spenCurvedDialHandler.getHeight() + iArr[1]).contains((int) e.getRawX(), (int) e.getRawY());
    }

    private final void notifyHapticFeedback(int oldValue, int newValue) {
        int i = newValue < oldValue ? -1 : 0;
        int i2 = (newValue + i) / 10;
        int i4 = (oldValue + i) / 10;
        if (newValue == 1 || i2 != i4) {
            View rootView = getRootView();
            Intrinsics.checkNotNullExpressionValue(rootView, "getRootView(...)");
            SpenSettingUtil.performHapticFeedback(rootView, 41);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyStartTrackingTouchListener() {
        OnCurvedDialerTrackListener onCurvedDialerTrackListener = this.mCurvedDialerTrackListener;
        if (onCurvedDialerTrackListener != null) {
            onCurvedDialerTrackListener.onStartTrackingTouch();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyStopTrackingTouchListener() {
        OnCurvedDialerTrackListener onCurvedDialerTrackListener = this.mCurvedDialerTrackListener;
        if (onCurvedDialerTrackListener != null) {
            onCurvedDialerTrackListener.onStopTrackingTouch();
        }
    }

    private final void setAttributes(Context context, AttributeSet attrs) {
        if (attrs != null) {
            Intrinsics.checkNotNullExpressionValue(context.getTheme().obtainStyledAttributes(attrs, C7932R.styleable.SpenCurvedDialer, 0, 0), "obtainStyledAttributes(...)");
            this.mAngleStart = r3.getInteger(C7932R.styleable.SpenCurvedDialer_angleStart, 0);
            this.mAngleEnd = r3.getInteger(C7932R.styleable.SpenCurvedDialer_angleEnd, 0);
        }
    }

    private final void setPositionByValue(int value) {
        float angleFromValue = getAngleFromValue(value);
        SpenCurvedDialerBackgroundDrawable spenCurvedDialerBackgroundDrawable = this.mCircularDotDrawable;
        if (spenCurvedDialerBackgroundDrawable != null) {
            spenCurvedDialerBackgroundDrawable.updatePosition(value, angleFromValue);
        }
    }

    public static /* synthetic */ void setValue$default(SpenCurvedDialer spenCurvedDialer, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        spenCurvedDialer.setValue(i, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startVisibilityAnimation$lambda$0(SpenCurvedDialer spenCurvedDialer, ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) AbstractC6670b.m4742c(valueAnimator, "animation", "null cannot be cast to non-null type kotlin.Float")).floatValue();
        spenCurvedDialer.mCurrentDotSizeScale = fFloatValue;
        SpenCurvedDialerBackgroundDrawable spenCurvedDialerBackgroundDrawable = spenCurvedDialer.mCircularDotDrawable;
        if (spenCurvedDialerBackgroundDrawable != null) {
            spenCurvedDialerBackgroundDrawable.setItemSizeScale(fFloatValue);
        }
        SpenCurvedDialerBackgroundDrawable spenCurvedDialerBackgroundDrawable2 = spenCurvedDialer.mCircularDotDrawable;
        if (spenCurvedDialerBackgroundDrawable2 != null) {
            spenCurvedDialerBackgroundDrawable2.invalidateSelf();
        }
    }

    private final void updateAngle() {
        SpenCircularRoundLayout spenCircularRoundLayout = this.mCircularRoundLayout;
        if (spenCircularRoundLayout != null) {
            spenCircularRoundLayout.setAngle(this.mAngleEnd, this.mAngleStart);
        }
    }

    public final void close() {
        this.mChangedListener = null;
        this.mActionListener = null;
        this.mCurvedDialerTrackListener = null;
        this.mCircularRoundLayout = null;
        SpenCurvedDialHandler spenCurvedDialHandler = this.mHandler;
        if (spenCurvedDialHandler != null) {
            spenCurvedDialHandler.close();
        }
        this.mHandler = null;
        this.mDotSizeAnimator = null;
        this.mAnimationListener = null;
        SpenCurvedDialerBackgroundDrawable spenCurvedDialerBackgroundDrawable = this.mCircularDotDrawable;
        if (spenCurvedDialerBackgroundDrawable != null) {
            spenCurvedDialerBackgroundDrawable.close();
        }
        this.mCircularDotDrawable = null;
    }

    public final boolean isRawPointInView(float rawX, float rawY) {
        SpenCircularRoundLayout spenCircularRoundLayout = this.mCircularRoundLayout;
        return spenCircularRoundLayout != null && spenCircularRoundLayout.isRawPointInPath(rawX, rawY);
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        initView(context);
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        boolean zOnTouchEvent = this.mGestureDetector.onTouchEvent(event);
        if (event.getAction() == 1 && this.isScrolling) {
            OnChangedListener onChangedListener = this.mChangedListener;
            if (onChangedListener != null) {
                onChangedListener.onChanged(this.mValue, true);
            }
            notifyStopTrackingTouchListener();
            this.isScrolling = false;
        }
        return zOnTouchEvent || super.onTouchEvent(event);
    }

    public final void setAngleRange(float startAngle, float endAngle) {
        Log.i(TAG, AbstractC1038a.m1216q(AbstractC0622a.m1176v("setAngleRange() [", startAngle, " ~ ", endAngle, "] old["), this.mAngleStart, " ~ ", this.mAngleEnd, "]"));
        if (this.mAngleStart == startAngle && this.mAngleEnd == endAngle) {
            return;
        }
        this.mAngleStart = startAngle;
        this.mAngleEnd = endAngle;
        updateAngle();
    }

    public final void setColor(int color) {
        AbstractC2322a.m1631u(color, "setColor() color=", TAG);
        if (this.mColor == color) {
            return;
        }
        this.mColor = color;
        SpenCurvedDialHandler spenCurvedDialHandler = this.mHandler;
        if (spenCurvedDialHandler != null) {
            spenCurvedDialHandler.setColor(color);
        }
    }

    public final void setCurvedDialerTrackListener(@Nullable OnCurvedDialerTrackListener listener) {
        this.mCurvedDialerTrackListener = listener;
    }

    public final void setMaxDotsVisible(int value) {
        SpenCurvedDialerBackgroundDrawable spenCurvedDialerBackgroundDrawable = this.mCircularDotDrawable;
        if (spenCurvedDialerBackgroundDrawable != null) {
            spenCurvedDialerBackgroundDrawable.setMaxDotsVisible(value);
        }
    }

    public final void setOnActionListener(@Nullable OnActionListener listener) {
        this.mActionListener = listener;
    }

    public final void setOnAnimationListener(@Nullable OnAnimationListener listener) {
        this.mAnimationListener = listener;
    }

    public final void setOnChangedListener(@Nullable OnChangedListener listener) {
        this.mChangedListener = listener;
    }

    public final void setValue(int value, boolean fromUser) {
        OnCurvedDialerTrackListener onCurvedDialerTrackListener;
        int i = this.mValue;
        if (i == value) {
            return;
        }
        if (i != 0) {
            notifyHapticFeedback(i, value);
        }
        this.mValue = value;
        SpenCurvedDialHandler spenCurvedDialHandler = this.mHandler;
        if (spenCurvedDialHandler != null) {
            spenCurvedDialHandler.setValue(value);
        }
        setPositionByValue(this.mValue);
        if (!fromUser || (onCurvedDialerTrackListener = this.mCurvedDialerTrackListener) == null) {
            return;
        }
        onCurvedDialerTrackListener.onProgressChanged(this.mValue);
    }

    public final void startVisibilityAnimation(boolean isShow) {
        SpenCurvedDialHandler spenCurvedDialHandler = this.mHandler;
        if (spenCurvedDialHandler != null) {
            spenCurvedDialHandler.startVisibilityAnimation(isShow);
        }
        SpenCircularRoundLayout spenCircularRoundLayout = this.mCircularRoundLayout;
        if (spenCircularRoundLayout != null) {
            spenCircularRoundLayout.startAnimation(isShow);
        }
        if (this.mDotSizeAnimator == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.mDotSizeAnimator = valueAnimator;
            valueAnimator.setInterpolator(SpenSettingUtilAnimation.getInterpolator(20));
            ValueAnimator valueAnimator2 = this.mDotSizeAnimator;
            if (valueAnimator2 != null) {
                valueAnimator2.addUpdateListener(new C0421a(this, 8));
            }
            ValueAnimator valueAnimator3 = this.mDotSizeAnimator;
            if (valueAnimator3 != null) {
                valueAnimator3.addListener(new Animator.AnimatorListener() { // from class: com.samsung.android.sdk.pen.setting.quicktool.SpenCurvedDialer.startVisibilityAnimation.2
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animation) {
                        Intrinsics.checkNotNullParameter(animation, "animation");
                        SpenCurvedDialer.this.mIsAnimationCancelled = true;
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animation) {
                        OnAnimationListener onAnimationListener;
                        Intrinsics.checkNotNullParameter(animation, "animation");
                        if (SpenCurvedDialer.this.mIsAnimationCancelled || (onAnimationListener = SpenCurvedDialer.this.mAnimationListener) == null) {
                            return;
                        }
                        onAnimationListener.onVisibilityAnimationEnd(SpenCurvedDialer.this.mCurrentDotSizeScale == 1.0f);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animation) {
                        Intrinsics.checkNotNullParameter(animation, "animation");
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animation) {
                        Intrinsics.checkNotNullParameter(animation, "animation");
                        SpenCurvedDialer.this.mIsAnimationCancelled = false;
                    }
                });
            }
        }
        ValueAnimator valueAnimator4 = this.mDotSizeAnimator;
        if (valueAnimator4 != null) {
            if (isShow) {
                valueAnimator4.setFloatValues(0.0f, 1.0f);
                valueAnimator4.setDuration(400L);
            } else {
                valueAnimator4.setFloatValues(1.0f, 0.0f);
                valueAnimator4.setDuration(350L);
            }
            valueAnimator4.start();
        }
    }
}
