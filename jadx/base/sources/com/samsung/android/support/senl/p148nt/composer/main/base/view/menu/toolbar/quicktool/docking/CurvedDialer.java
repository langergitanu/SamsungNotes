package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.animation.C0421a;
import androidx.collection.AbstractC0622a;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTUtil;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilAnimation;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.winset.app.popover.PopOverActivityWrapper;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.CurvedDialer;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.CurvedDialerBackgroundDrawable;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.QTCircularRoundLayout;
import com.samsung.android.support.senl.p148nt.model.securefolder.common.SecureFolderConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0018\u0018\u0000 M2\u00020\u0001:\u0005MNOPQB\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010)\u001a\u00020*J\u0010\u0010+\u001a\u00020*2\b\u0010,\u001a\u0004\u0018\u00010\tJ\u0010\u0010-\u001a\u00020*2\b\u0010,\u001a\u0004\u0018\u00010(J\u0016\u0010.\u001a\u00020*2\u0006\u0010/\u001a\u00020\u00132\u0006\u00100\u001a\u00020\u0013J\u000e\u00101\u001a\u00020*2\u0006\u00102\u001a\u00020\u0018J\u0018\u00103\u001a\u00020*2\u0006\u00102\u001a\u00020\u00182\b\b\u0002\u00104\u001a\u00020\u0013J\u000e\u00105\u001a\u00020*2\u0006\u00106\u001a\u00020\u0018J\b\u00107\u001a\u00020*H\u0014J\u0010\u00108\u001a\u00020 2\u0006\u00109\u001a\u00020:H\u0016J\u0010\u0010;\u001a\u00020 2\u0006\u00109\u001a\u00020:H\u0017J\u000e\u0010<\u001a\u00020*2\u0006\u0010=\u001a\u00020 J\u0016\u0010>\u001a\u00020 2\u0006\u0010?\u001a\u00020\u00132\u0006\u0010@\u001a\u00020\u0013J\u0010\u0010A\u001a\u00020*2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\b\u0010B\u001a\u00020*H\u0002J\u001a\u0010C\u001a\u00020*2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010D\u001a\u00020*2\u0006\u00102\u001a\u00020\u0018H\u0002J\u0018\u0010E\u001a\u00020\u00132\u0006\u0010F\u001a\u00020\u00132\u0006\u0010G\u001a\u00020\u0013H\u0002J\u0010\u0010H\u001a\u00020\u00132\u0006\u00102\u001a\u00020\u0018H\u0002J\u0010\u0010I\u001a\u00020\u00182\u0006\u00104\u001a\u00020\u0013H\u0002J\u0018\u0010J\u001a\u00020 2\u0006\u0010K\u001a\u00020\u00132\u0006\u0010L\u001a\u00020\u0013H\u0002J\u0018\u0010!\u001a\u00020 2\u0006\u0010K\u001a\u00020\u00132\u0006\u0010L\u001a\u00020\u0013H\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001b\u001a\u00060\u001cR\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006R"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/CurvedDialer;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mChangedListener", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/CurvedDialer$OnChangedListener;", "mCircularRoundLayout", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTCircularRoundLayout;", "mHandler", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/CurvedDialHandler;", "mCircularDotDrawable", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/CurvedDialerBackgroundDrawable;", "mCenter", "Landroid/graphics/PointF;", "mStrokeWidth", "", "mRadius", "mAngleStart", "mAngleEnd", "mColor", "", "mValue", "mThicknessExtendedAngle", "mAngleTracker", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/CurvedDialer$AngleTracker;", "mGestureDetector", "Landroid/view/GestureDetector;", "isScrolling", "", "isDialTouched", "isHandlerTouched", "mDotSizeAnimator", "Landroid/animation/ValueAnimator;", "mCurrentDotSizeScale", "mIsAnimationCancelled", "mAnimationListener", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/CurvedDialer$OnAnimationListener;", "close", "", "setOnChangedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnAnimationListener", "setAngleRange", "startAngle", "endAngle", "setMaxDotsVisible", "value", "setValue", "angle", "setColor", "color", "onFinishInflate", "onInterceptTouchEvent", "event", "Landroid/view/MotionEvent;", "onTouchEvent", "startVisibilityAnimation", "isShow", "isRawPointInView", "rawX", "rawY", "initView", "updateAngle", "setAttributes", "setPositionByValue", "getAngleByTouch", "touchX", "touchY", "getAngleFromValue", "getValueFromAngle", "isHandlerTouch", "x", "y", "Companion", "OnChangedListener", "OnAnimationListener", "AngleTracker", "GestureListener", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nCurvedDialer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CurvedDialer.kt\ncom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/CurvedDialer\n+ 2 FloatExtension.kt\ncom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/extension/FloatExtensionKt\n+ 3 View.kt\nandroidx/core/view/ViewKt\n+ 4 Context.kt\nandroidx/core/content/ContextKt\n*L\n1#1,404:1\n15#2:405\n19#2:408\n15#2:413\n10#2,2:414\n15#2:416\n10#2,2:417\n10#2,2:419\n10#2,2:421\n23#2,4:423\n10#2,2:427\n327#3,2:406\n329#3,2:409\n58#4,2:411\n*S KotlinDebug\n*F\n+ 1 CurvedDialer.kt\ncom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/CurvedDialer\n*L\n200#1:405\n219#1:408\n248#1:413\n248#1:414,2\n282#1:416\n282#1:417,2\n284#1:419,2\n285#1:421,2\n283#1:423,4\n42#1:427,2\n218#1:406,2\n218#1:409,2\n233#1:411,2\n*E\n"})
public final class CurvedDialer extends ConstraintLayout {
    private static final float ANGLE_STEP = 1.4040405f;
    private static final float ANGULAR_DECELERATION = 200.0f;
    private static final long DOT_HIDE_ANIMATION_DURATION = 350;
    private static final long DOT_SHOW_ANIMATION_DURATION = 400;
    private static final float HANDLER_ANGLE;
    private static final int MAX_VALUE = 100;
    private static final int MIN_VALUE = 1;

    @NotNull
    private static final String TAG = "CurvedDialer";
    private boolean isDialTouched;
    private boolean isHandlerTouched;
    private boolean isScrolling;
    private float mAngleEnd;
    private float mAngleStart;

    @NotNull
    private AngleTracker mAngleTracker;

    @Nullable
    private OnAnimationListener mAnimationListener;
    private PointF mCenter;

    @Nullable
    private OnChangedListener mChangedListener;

    @Nullable
    private CurvedDialerBackgroundDrawable mCircularDotDrawable;

    @Nullable
    private QTCircularRoundLayout mCircularRoundLayout;
    private int mColor;
    private float mCurrentDotSizeScale;

    @Nullable
    private ValueAnimator mDotSizeAnimator;

    @NotNull
    private GestureDetector mGestureDetector;

    @Nullable
    private CurvedDialHandler mHandler;
    private boolean mIsAnimationCancelled;
    private float mRadius;
    private float mStrokeWidth;
    private float mThicknessExtendedAngle;
    private int mValue;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000bJ\u0016\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/CurvedDialer$AngleTracker;", "", "<init>", "(Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/CurvedDialer;)V", "currentValue", "", "getCurrentValue", "()I", "setCurrentValue", "(I)V", "currentAngle", "", "accumulatedRotation", "getAccumulatedRotation", "()F", "setAccumulatedRotation", "(F)V", "start", "", "x", "y", SecureFolderConstants.TEMP_FOLDER_NAME, "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public final class AngleTracker {
        private float accumulatedRotation;
        private float currentAngle;
        private int currentValue = 1;

        public AngleTracker() {
        }

        public final float getAccumulatedRotation() {
            return this.accumulatedRotation;
        }

        public final int getCurrentValue() {
            return this.currentValue;
        }

        public final void move(float x, float y2) {
            float angleByTouch = CurvedDialer.this.getAngleByTouch(x, y2);
            float f = angleByTouch - this.currentAngle;
            this.currentAngle = angleByTouch;
            if (f > 180.0f) {
                f -= 360.0f;
            }
            if (f < -180.0f) {
                f += 360.0f;
            }
            float f4 = this.accumulatedRotation + f;
            int i = (int) (f4 / CurvedDialer.ANGLE_STEP);
            this.accumulatedRotation = f4 - (i * CurvedDialer.ANGLE_STEP);
            int iCoerceIn = RangesKt.coerceIn(this.currentValue - i, 1, 100);
            if (iCoerceIn <= 1 && f > 0.0f) {
                this.accumulatedRotation = 0.0f;
                this.currentValue = 1;
            } else if (iCoerceIn < 100 || f >= 0.0f) {
                this.currentValue = iCoerceIn;
            } else {
                this.accumulatedRotation = 0.0f;
                this.currentValue = 100;
            }
        }

        public final void setAccumulatedRotation(float f) {
            this.accumulatedRotation = f;
        }

        public final void setCurrentValue(int i) {
            this.currentValue = i;
        }

        public final void start(float x, float y2) {
            this.accumulatedRotation = 0.0f;
            this.currentAngle = CurvedDialer.this.getAngleByTouch(x, y2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J*\u0010\t\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0016J*\u0010\u000f\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\rH\u0016¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/CurvedDialer$GestureListener;", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "<init>", "(Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/CurvedDialer;)V", "onDown", "", "e", "Landroid/view/MotionEvent;", "onSingleTapUp", "onScroll", "e1", "e2", "distanceX", "", "distanceY", "onFling", "velocityX", "velocityY", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nCurvedDialer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CurvedDialer.kt\ncom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/CurvedDialer$GestureListener\n+ 2 FloatExtension.kt\ncom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/extension/FloatExtensionKt\n*L\n1#1,404:1\n10#2,2:405\n15#2:407\n*S KotlinDebug\n*F\n+ 1 CurvedDialer.kt\ncom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/CurvedDialer$GestureListener\n*L\n340#1:405,2\n386#1:407\n*E\n"})
    public final class GestureListener extends GestureDetector.SimpleOnGestureListener {
        public GestureListener() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(@NotNull MotionEvent e) {
            Intrinsics.checkNotNullParameter(e, "e");
            float x = e.getX();
            float y2 = e.getY();
            CurvedDialer curvedDialer = CurvedDialer.this;
            curvedDialer.isDialTouched = curvedDialer.isDialTouched(x, y2);
            CurvedDialer curvedDialer2 = CurvedDialer.this;
            curvedDialer2.isHandlerTouched = curvedDialer2.isHandlerTouch(x, y2);
            Logger.m10999d(CurvedDialer.TAG, "onDown() isDialTouched=" + CurvedDialer.this.isDialTouched + ", isHandlerTouched=" + CurvedDialer.this.isHandlerTouched);
            if (!CurvedDialer.this.isDialTouched && !CurvedDialer.this.isHandlerTouched) {
                return false;
            }
            CurvedDialerBackgroundDrawable curvedDialerBackgroundDrawable = CurvedDialer.this.mCircularDotDrawable;
            if (curvedDialerBackgroundDrawable != null) {
                curvedDialerBackgroundDrawable.cancelAnimation();
            }
            CurvedDialer.this.mAngleTracker.setCurrentValue(CurvedDialer.this.mValue);
            CurvedDialer.this.mAngleTracker.start(x, y2);
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(@Nullable MotionEvent e12, @NotNull MotionEvent e2, float velocityX, float velocityY) {
            SpenSettingQTUtil.ScrollDirection scrollDirection;
            Intrinsics.checkNotNullParameter(e2, "e2");
            if ((!CurvedDialer.this.isDialTouched && !CurvedDialer.this.isHandlerTouched) || (scrollDirection = SpenSettingQTUtil.getScrollDirection(CurvedDialer.this.getWidth(), CurvedDialer.this.getHeight(), e12, e2)) == SpenSettingQTUtil.ScrollDirection.DIR_NONE) {
                return false;
            }
            float fSqrt = ((float) Math.sqrt((velocityY * velocityY) + (velocityX * velocityX))) / CurvedDialer.this.mRadius;
            int i = (int) (((float) (((double) (((fSqrt * fSqrt) / 400.0f) * 180)) / 3.141592653589793d)) / CurvedDialer.ANGLE_STEP);
            if (scrollDirection != SpenSettingQTUtil.ScrollDirection.DIR_CLOCK_WISE) {
                i = -i;
            }
            CurvedDialer curvedDialer = CurvedDialer.this;
            float angleFromValue = curvedDialer.getAngleFromValue(curvedDialer.mAngleTracker.getCurrentValue() + i);
            CurvedDialerBackgroundDrawable curvedDialerBackgroundDrawable = CurvedDialer.this.mCircularDotDrawable;
            if (curvedDialerBackgroundDrawable == null) {
                return true;
            }
            final CurvedDialer curvedDialer2 = CurvedDialer.this;
            curvedDialerBackgroundDrawable.startAnimation(angleFromValue, new CurvedDialerBackgroundDrawable.AnimationListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.CurvedDialer$GestureListener$onFling$1
                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.CurvedDialerBackgroundDrawable.AnimationListener
                public void onAnimationEnd() {
                    CurvedDialer.OnChangedListener onChangedListener = curvedDialer2.mChangedListener;
                    if (onChangedListener != null) {
                        onChangedListener.onChanged(curvedDialer2.mValue, true);
                    }
                }

                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.CurvedDialerBackgroundDrawable.AnimationListener
                public void onAnimationUpdate(float value) {
                    CurvedDialer curvedDialer3 = curvedDialer2;
                    curvedDialer3.setValue(curvedDialer3.getValueFromAngle(value), value);
                }
            });
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(@Nullable MotionEvent e12, @NotNull MotionEvent e2, float distanceX, float distanceY) {
            Intrinsics.checkNotNullParameter(e2, "e2");
            if (!CurvedDialer.this.isDialTouched && !CurvedDialer.this.isHandlerTouched) {
                return false;
            }
            CurvedDialer.this.isScrolling = true;
            CurvedDialer.this.mAngleTracker.move(e2.getX(), e2.getY());
            CurvedDialer curvedDialer = CurvedDialer.this;
            float angleFromValue = curvedDialer.getAngleFromValue(curvedDialer.mAngleTracker.getCurrentValue()) + CurvedDialer.this.mAngleTracker.getAccumulatedRotation();
            CurvedDialer curvedDialer2 = CurvedDialer.this;
            curvedDialer2.setValue(curvedDialer2.mAngleTracker.getCurrentValue(), angleFromValue);
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(@NotNull MotionEvent e) {
            Intrinsics.checkNotNullParameter(e, "e");
            Logger.m10999d(CurvedDialer.TAG, "onSingleTapUp() isDialTouched=" + CurvedDialer.this.isDialTouched + ", isHandlerTouched=" + CurvedDialer.this.isHandlerTouched);
            if (CurvedDialer.this.isHandlerTouched || !CurvedDialer.this.isDialTouched) {
                return false;
            }
            float angleByTouch = CurvedDialer.this.getAngleByTouch(e.getX(), e.getY()) - CurvedDialer.HANDLER_ANGLE;
            float f = PopOverActivityWrapper.DEFAULT_WIDTH;
            float f4 = angleByTouch % f;
            if (f4 < 0.0f) {
                f4 += f;
            }
            int i = (int) (f4 / CurvedDialer.ANGLE_STEP);
            CurvedDialer curvedDialer = CurvedDialer.this;
            float angleFromValue = curvedDialer.getAngleFromValue(curvedDialer.mValue + i);
            CurvedDialerBackgroundDrawable curvedDialerBackgroundDrawable = CurvedDialer.this.mCircularDotDrawable;
            if (curvedDialerBackgroundDrawable == null) {
                return true;
            }
            final CurvedDialer curvedDialer2 = CurvedDialer.this;
            curvedDialerBackgroundDrawable.startAnimation(angleFromValue, new CurvedDialerBackgroundDrawable.AnimationListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.CurvedDialer$GestureListener$onSingleTapUp$1
                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.CurvedDialerBackgroundDrawable.AnimationListener
                public void onAnimationEnd() {
                    CurvedDialer.OnChangedListener onChangedListener = curvedDialer2.mChangedListener;
                    if (onChangedListener != null) {
                        onChangedListener.onChanged(curvedDialer2.mValue, true);
                    }
                }

                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.CurvedDialerBackgroundDrawable.AnimationListener
                public void onAnimationUpdate(float value) {
                    CurvedDialer curvedDialer3 = curvedDialer2;
                    curvedDialer3.setValue(curvedDialer3.getValueFromAngle(value), value);
                }
            });
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/CurvedDialer$OnAnimationListener;", "", "onVisibilityAnimationEnd", "", "isShowAnimation", "", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface OnAnimationListener {
        void onVisibilityAnimationEnd(boolean isShowAnimation);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/CurvedDialer$OnChangedListener;", "", "onChanged", "", "value", "", "fromUser", "", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface OnChangedListener {
        void onChanged(int value, boolean fromUser);
    }

    static {
        float f = PopOverActivityWrapper.DEFAULT_WIDTH;
        float f4 = (-79.0f) % f;
        if (f4 < 0.0f) {
            f4 += f;
        }
        HANDLER_ANGLE = f4;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CurvedDialer(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mAngleTracker = new AngleTracker();
        this.mCurrentDotSizeScale = 1.0f;
        setAttributes(context, attributeSet);
        this.mGestureDetector = new GestureDetector(context, new GestureListener());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float getAngleByTouch(float touchX, float touchY) {
        PointF pointF = this.mCenter;
        PointF pointF2 = null;
        if (pointF == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCenter");
            pointF = null;
        }
        float f = touchX - pointF.x;
        PointF pointF3 = this.mCenter;
        if (pointF3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCenter");
        } else {
            pointF2 = pointF3;
        }
        float fAtan2 = (float) (((double) (((float) Math.atan2(touchY - pointF2.y, f)) * 180)) / 3.141592653589793d);
        float f4 = PopOverActivityWrapper.DEFAULT_WIDTH;
        float f5 = fAtan2 % f4;
        return f5 < 0.0f ? f5 + f4 : f5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float getAngleFromValue(int value) {
        return (-(RangesKt.coerceIn(value, 1, 100) - 1)) * ANGLE_STEP;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getValueFromAngle(float angle) {
        return RangesKt.coerceIn((int) (((-angle) / ANGLE_STEP) + 1), 1, 100);
    }

    private final void initView(Context context) {
        PointF pointF = new PointF();
        this.mCenter = pointF;
        pointF.x = getResources().getDimension(C9086R.dimen.composer_qt_circle_default_size) * 0.5f;
        PointF pointF2 = this.mCenter;
        PointF pointF3 = null;
        if (pointF2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCenter");
            pointF2 = null;
        }
        pointF2.y = getResources().getDimension(C9086R.dimen.composer_qt_circle_default_size) * 0.5f;
        this.mStrokeWidth = getResources().getDimension(C9086R.dimen.composer_qt_dial_stroke_size);
        float dimension = getResources().getDimension(C9086R.dimen.composer_qt_dial_width);
        float f = this.mStrokeWidth;
        float f4 = (dimension - f) * 0.5f;
        this.mRadius = f4;
        this.mThicknessExtendedAngle = (float) (((double) (((f * 0.5f) / f4) * 180)) / 3.141592653589793d);
        QTCircularRoundLayout qTCircularRoundLayout = (QTCircularRoundLayout) findViewById(C9086R.id.circular_mask_layout);
        this.mCircularRoundLayout = qTCircularRoundLayout;
        if (qTCircularRoundLayout != null) {
            qTCircularRoundLayout.setAnimationFillType(QTCircularRoundLayout.AnimationFillType.START_TO_END);
        }
        updateAngle();
        PointF pointF4 = new PointF();
        pointF4.x = getResources().getDimension(C9086R.dimen.composer_qt_dial_width) * 0.5f;
        pointF4.y = getResources().getDimension(C9086R.dimen.composer_qt_dial_width) * 0.5f;
        this.mCircularDotDrawable = new CurvedDialerBackgroundDrawable(context, pointF4);
        View viewFindViewById = findViewById(C9086R.id.dialer_background);
        if (viewFindViewById != null) {
            viewFindViewById.setBackground(this.mCircularDotDrawable);
        }
        setPositionByValue(this.mValue);
        CurvedDialHandler curvedDialHandler = (CurvedDialHandler) findViewById(C9086R.id.attr_handler);
        this.mHandler = curvedDialHandler;
        if (curvedDialHandler != null) {
            curvedDialHandler.setColor(this.mColor);
        }
        CurvedDialHandler curvedDialHandler2 = this.mHandler;
        if (curvedDialHandler2 != null) {
            curvedDialHandler2.setValue(this.mValue);
        }
        CurvedDialHandler curvedDialHandler3 = this.mHandler;
        if (curvedDialHandler3 != null) {
            ViewGroup.LayoutParams layoutParams = curvedDialHandler3.getLayoutParams();
            if (layoutParams == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            float f5 = (float) ((((double) HANDLER_ANGLE) * 3.141592653589793d) / ((double) 180));
            float dimension2 = getResources().getDimension(C9086R.dimen.composer_qt_curved_dial_handler_width);
            float dimension3 = getResources().getDimension(C9086R.dimen.composer_qt_curved_dial_handler_height);
            PointF pointF5 = this.mCenter;
            if (pointF5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCenter");
                pointF5 = null;
            }
            double d = f5;
            marginLayoutParams.setMarginStart((int) (((Math.abs((float) Math.cos(d)) * this.mRadius) + pointF5.x) - (dimension2 * 0.5f)));
            PointF pointF6 = this.mCenter;
            if (pointF6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCenter");
            } else {
                pointF3 = pointF6;
            }
            marginLayoutParams.bottomMargin = (int) (((Math.abs((float) Math.sin(d)) * this.mRadius) + pointF3.y) - (dimension3 * 0.25f));
            curvedDialHandler3.setLayoutParams(marginLayoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isDialTouched(float x, float y2) {
        PointF pointF = this.mCenter;
        PointF pointF2 = null;
        if (pointF == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCenter");
            pointF = null;
        }
        float f = x - pointF.x;
        PointF pointF3 = this.mCenter;
        if (pointF3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCenter");
        } else {
            pointF2 = pointF3;
        }
        float f4 = y2 - pointF2.y;
        float f5 = (f4 * f4) + (f * f);
        float f6 = this.mRadius;
        float f7 = this.mStrokeWidth;
        float f8 = 2;
        float f9 = (f7 / f8) + f6;
        float f10 = f6 - (f7 / f8);
        if (f5 >= f10 * f10 && f5 <= f9 * f9) {
            float fAtan2 = (float) (((double) (((float) Math.atan2(f4, f)) * 180)) / 3.141592653589793d);
            float f11 = PopOverActivityWrapper.DEFAULT_WIDTH;
            float f12 = fAtan2 % f11;
            if (f12 < 0.0f) {
                f12 += f11;
            }
            float f13 = this.mAngleStart;
            float f14 = this.mThicknessExtendedAngle;
            float f15 = (f13 - f14) % f11;
            if (f15 < 0.0f) {
                f15 += f11;
            }
            float f16 = (this.mAngleEnd + f14) % f11;
            if (f16 < 0.0f) {
                f16 += f11;
            }
            if (f15 > f16) {
                return f12 >= f15 || f12 <= f16;
            }
            if (f15 <= f12 && f12 <= f16) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isHandlerTouch(float x, float y2) {
        CurvedDialHandler curvedDialHandler = this.mHandler;
        if (curvedDialHandler == null) {
            return false;
        }
        RectF rectF = new RectF(0.0f, 0.0f, curvedDialHandler.getWidth(), curvedDialHandler.getHeight());
        RectF rectF2 = new RectF();
        curvedDialHandler.getMatrix().mapRect(rectF2, rectF);
        rectF2.offset(curvedDialHandler.getLeft(), curvedDialHandler.getTop());
        boolean zContains = rectF2.contains(x, y2);
        AbstractC8014b.m7220v("isHandlerTouch: ", TAG, zContains);
        return zContains;
    }

    private final void setAttributes(Context context, AttributeSet attrs) {
        if (attrs != null) {
            int[] SpenCurvedDialer = C9086R.styleable.SpenCurvedDialer;
            Intrinsics.checkNotNullExpressionValue(SpenCurvedDialer, "SpenCurvedDialer");
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, SpenCurvedDialer, 0, 0);
            this.mAngleStart = typedArrayObtainStyledAttributes.getFloat(C9086R.styleable.SpenCurvedDialer_angleStart, 0.0f);
            this.mAngleEnd = typedArrayObtainStyledAttributes.getFloat(C9086R.styleable.SpenCurvedDialer_angleEnd, 0.0f);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    private final void setPositionByValue(int value) {
        float angleFromValue = getAngleFromValue(value);
        CurvedDialerBackgroundDrawable curvedDialerBackgroundDrawable = this.mCircularDotDrawable;
        if (curvedDialerBackgroundDrawable != null) {
            curvedDialerBackgroundDrawable.updatePosition(value, angleFromValue);
        }
    }

    public static /* synthetic */ void setValue$default(CurvedDialer curvedDialer, int i, float f, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            f = curvedDialer.getAngleFromValue(i);
        }
        curvedDialer.setValue(i, f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startVisibilityAnimation$lambda$0(CurvedDialer curvedDialer, ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) AbstractC6670b.m4742c(valueAnimator, "animation", "null cannot be cast to non-null type kotlin.Float")).floatValue();
        curvedDialer.mCurrentDotSizeScale = fFloatValue;
        CurvedDialerBackgroundDrawable curvedDialerBackgroundDrawable = curvedDialer.mCircularDotDrawable;
        if (curvedDialerBackgroundDrawable != null) {
            curvedDialerBackgroundDrawable.setItemSizeScale(fFloatValue);
        }
        CurvedDialerBackgroundDrawable curvedDialerBackgroundDrawable2 = curvedDialer.mCircularDotDrawable;
        if (curvedDialerBackgroundDrawable2 != null) {
            curvedDialerBackgroundDrawable2.invalidateSelf();
        }
    }

    private final void updateAngle() {
        QTCircularRoundLayout qTCircularRoundLayout = this.mCircularRoundLayout;
        if (qTCircularRoundLayout != null) {
            qTCircularRoundLayout.setAngle(this.mAngleStart, this.mAngleEnd);
        }
    }

    public final void close() {
        this.mChangedListener = null;
        this.mCircularRoundLayout = null;
        CurvedDialHandler curvedDialHandler = this.mHandler;
        if (curvedDialHandler != null) {
            curvedDialHandler.close();
        }
        this.mHandler = null;
        this.mDotSizeAnimator = null;
        this.mAnimationListener = null;
        CurvedDialerBackgroundDrawable curvedDialerBackgroundDrawable = this.mCircularDotDrawable;
        if (curvedDialerBackgroundDrawable != null) {
            curvedDialerBackgroundDrawable.close();
        }
        this.mCircularDotDrawable = null;
    }

    public final boolean isRawPointInView(float rawX, float rawY) {
        QTCircularRoundLayout qTCircularRoundLayout = this.mCircularRoundLayout;
        return qTCircularRoundLayout != null && qTCircularRoundLayout.isRawPointInPath(rawX, rawY);
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        initView(context);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return true;
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getAction() == 1 && this.isScrolling) {
            this.isScrolling = false;
            OnChangedListener onChangedListener = this.mChangedListener;
            if (onChangedListener != null) {
                onChangedListener.onChanged(this.mValue, true);
            }
        }
        return this.mGestureDetector.onTouchEvent(event);
    }

    public final void setAngleRange(float startAngle, float endAngle) {
        Logger.m11003i(TAG, AbstractC1038a.m1216q(AbstractC0622a.m1176v("setAngleRange() [", startAngle, " ~ ", endAngle, "] old["), this.mAngleStart, " ~ ", this.mAngleEnd, "]"));
        if (this.mAngleStart == startAngle && this.mAngleEnd == endAngle) {
            return;
        }
        this.mAngleStart = startAngle;
        this.mAngleEnd = endAngle;
        updateAngle();
    }

    public final void setColor(int color) {
        AbstractC8014b.m7217s(color, "setColor() color=", TAG);
        if (this.mColor == color) {
            return;
        }
        this.mColor = color;
        CurvedDialHandler curvedDialHandler = this.mHandler;
        if (curvedDialHandler != null) {
            curvedDialHandler.setColor(color);
        }
    }

    public final void setMaxDotsVisible(int value) {
        CurvedDialerBackgroundDrawable curvedDialerBackgroundDrawable = this.mCircularDotDrawable;
        if (curvedDialerBackgroundDrawable != null) {
            curvedDialerBackgroundDrawable.setMaxDotsVisible(value);
        }
    }

    public final void setOnAnimationListener(@Nullable OnAnimationListener listener) {
        this.mAnimationListener = listener;
    }

    public final void setOnChangedListener(@Nullable OnChangedListener listener) {
        this.mChangedListener = listener;
    }

    public final void setValue(int value, float angle) {
        this.mValue = value;
        CurvedDialHandler curvedDialHandler = this.mHandler;
        if (curvedDialHandler != null) {
            curvedDialHandler.setValue(value);
        }
        CurvedDialerBackgroundDrawable curvedDialerBackgroundDrawable = this.mCircularDotDrawable;
        if (curvedDialerBackgroundDrawable != null) {
            curvedDialerBackgroundDrawable.updatePosition(value, angle);
        }
    }

    public final void startVisibilityAnimation(boolean isShow) {
        CurvedDialHandler curvedDialHandler = this.mHandler;
        if (curvedDialHandler != null) {
            curvedDialHandler.startVisibilityAnimation(isShow);
        }
        QTCircularRoundLayout qTCircularRoundLayout = this.mCircularRoundLayout;
        if (qTCircularRoundLayout != null) {
            qTCircularRoundLayout.startAnimation(isShow);
        }
        if (this.mDotSizeAnimator == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.mDotSizeAnimator = valueAnimator;
            valueAnimator.setInterpolator(SpenSettingUtilAnimation.getInterpolator(20));
            ValueAnimator valueAnimator2 = this.mDotSizeAnimator;
            if (valueAnimator2 != null) {
                valueAnimator2.addUpdateListener(new C0421a(this, 24));
            }
            ValueAnimator valueAnimator3 = this.mDotSizeAnimator;
            if (valueAnimator3 != null) {
                valueAnimator3.addListener(new Animator.AnimatorListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.CurvedDialer.startVisibilityAnimation.2
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animation) {
                        Intrinsics.checkNotNullParameter(animation, "animation");
                        CurvedDialer.this.mIsAnimationCancelled = true;
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animation) {
                        OnAnimationListener onAnimationListener;
                        Intrinsics.checkNotNullParameter(animation, "animation");
                        if (CurvedDialer.this.mIsAnimationCancelled || (onAnimationListener = CurvedDialer.this.mAnimationListener) == null) {
                            return;
                        }
                        onAnimationListener.onVisibilityAnimationEnd(CurvedDialer.this.mCurrentDotSizeScale == 1.0f);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animation) {
                        Intrinsics.checkNotNullParameter(animation, "animation");
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animation) {
                        Intrinsics.checkNotNullParameter(animation, "animation");
                        CurvedDialer.this.mIsAnimationCancelled = false;
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
