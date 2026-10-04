package com.samsung.android.sdk.pen.view.gesture.detector;

import android.content.Context;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Point;
import android.graphics.PointF;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.WindowManager;
import com.google.android.gms.common.data.AbstractC4539a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.scs.p140ai.sdkcommon.image.ImageConst;
import com.samsung.android.sdk.pen.view.gesture.detector.SpenHoldMotionDetector;
import com.samsung.android.sdk.pen.view.gesture.detector.SpenMultipleTapDetector;
import com.samsung.android.sdk.pen.view.gesture.detector.SpenPalmDetector;
import com.samsung.android.sdk.pen.view.gesture.detector.SpenScaleStabilizer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 q2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006:\u0002pqB\u0013\b\u0016\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010E\u001a\u00020FJ\u0010\u0010G\u001a\u00020F2\b\u0010H\u001a\u0004\u0018\u00010\u001eJ&\u0010I\u001a\u00020\u001c2\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020\u001c2\u0006\u0010M\u001a\u00020\u001c2\u0006\u0010N\u001a\u00020\u001cJ\u0010\u0010O\u001a\u00020\u001c2\u0006\u0010P\u001a\u00020KH\u0016J\u0010\u0010Q\u001a\u00020F2\u0006\u0010P\u001a\u00020KH\u0016J\u0010\u0010R\u001a\u00020\u001c2\u0006\u0010P\u001a\u00020KH\u0016J*\u0010S\u001a\u00020\u001c2\b\u0010T\u001a\u0004\u0018\u00010K2\u0006\u0010U\u001a\u00020K2\u0006\u0010V\u001a\u00020\u00102\u0006\u0010W\u001a\u00020\u0010H\u0016J\u0010\u0010X\u001a\u00020F2\u0006\u0010P\u001a\u00020KH\u0016J\u0012\u0010Y\u001a\u00020\u001c2\b\u0010J\u001a\u0004\u0018\u00010KH\u0016J\u0012\u0010Z\u001a\u00020\u001c2\b\u0010J\u001a\u0004\u0018\u00010KH\u0016J\b\u0010[\u001a\u00020FH\u0016J*\u0010\\\u001a\u00020\u001c2\b\u0010T\u001a\u0004\u0018\u00010K2\u0006\u0010U\u001a\u00020K2\u0006\u0010]\u001a\u00020\u00102\u0006\u0010^\u001a\u00020\u0010H\u0016J\u0010\u0010_\u001a\u00020\u001c2\u0006\u0010`\u001a\u00020\u0014H\u0016J\u0010\u0010a\u001a\u00020\u001c2\u0006\u0010`\u001a\u00020\u0014H\u0002J\u0010\u0010b\u001a\u00020F2\u0006\u0010c\u001a\u00020\u0010H\u0002J\u0010\u0010d\u001a\u00020\u001c2\u0006\u0010`\u001a\u00020\u0014H\u0016J\u0010\u0010e\u001a\u00020F2\u0006\u0010`\u001a\u00020\u0014H\u0016J\u0010\u0010f\u001a\u00020\u001c2\u0006\u0010P\u001a\u00020KH\u0016J\u0010\u0010g\u001a\u00020\u001c2\u0006\u0010P\u001a\u00020KH\u0016J\u001a\u0010h\u001a\u00020F2\b\u0010J\u001a\u0004\u0018\u00010K2\u0006\u0010i\u001a\u00020jH\u0016J\u0010\u0010k\u001a\u00020\u001c2\u0006\u0010P\u001a\u00020KH\u0016J\u000e\u0010l\u001a\u00020F2\u0006\u0010m\u001a\u00020\u0010J\b\u0010n\u001a\u00020FH\u0016J\b\u0010o\u001a\u00020FH\u0016R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010.\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001a\u00102\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010/\"\u0004\b3\u00101R\u001a\u00104\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010/\"\u0004\b5\u00101R\u001a\u00106\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010/\"\u0004\b7\u00101R\u001a\u00108\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010/\"\u0004\b9\u00101R\u001a\u0010:\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010/\"\u0004\b;\u00101R\u001a\u0010<\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010/\"\u0004\b=\u00101R\u001a\u0010>\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010/\"\u0004\b?\u00101R\u000e\u0010@\u001a\u00020AX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010C\u001a\u00020\u001c2\u0006\u0010B\u001a\u00020\u001c8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bC\u0010/\"\u0004\bD\u00101¨\u0006r"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/view/gesture/detector/SpenGestureDetector;", "Landroid/view/GestureDetector$OnGestureListener;", "Landroid/view/GestureDetector$OnDoubleTapListener;", "Landroid/view/ScaleGestureDetector$OnScaleGestureListener;", "Lcom/samsung/android/sdk/pen/view/gesture/detector/SpenHoldMotionDetector$OnHoldingMotionListener;", "Lcom/samsung/android/sdk/pen/view/gesture/detector/SpenMultipleTapDetector$OnMultipleTapListener;", "Lcom/samsung/android/sdk/pen/view/gesture/detector/SpenPalmDetector$Listener;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mTouchPath", "Landroid/graphics/Path;", "mTouchMeasure", "Landroid/graphics/PathMeasure;", "mDensity", "", "mGestureDetector", "Landroid/view/GestureDetector;", "mScaleGestureDetector", "Landroid/view/ScaleGestureDetector;", "mHoldMotionDetector", "Lcom/samsung/android/sdk/pen/view/gesture/detector/SpenHoldMotionDetector;", "mMultipleTapDetector", "Lcom/samsung/android/sdk/pen/view/gesture/detector/SpenMultipleTapDetector;", "mPalmDetector", "Lcom/samsung/android/sdk/pen/view/gesture/detector/SpenPalmDetector;", "mIsPalmDetected", "", "mListener", "Lcom/samsung/android/sdk/pen/view/gesture/detector/SpenGestureDetector$Listener;", "mIsGesture", "mIsStroke", "mFirstScroll", "mBlockScroll", "mIsLastTouchPointerUp", "mTouchStartPosition", "Landroid/graphics/PointF;", "mScrollLowPassFilterX", "Lcom/samsung/android/sdk/pen/view/gesture/detector/SpenGestureLowPassFilter;", "mScrollLowPassFilterY", "mPreviousSpan", "mScaleStabilizer", "Lcom/samsung/android/sdk/pen/view/gesture/detector/SpenScaleStabilizer;", "mScaleRatioForConfirmed", "mIsScaleConfirmedCalled", "isDoubleTapEnabled", "()Z", "setDoubleTapEnabled", "(Z)V", "isLongPressEnabled", "setLongPressEnabled", "isHoldLongPressEnabled", "setHoldLongPressEnabled", "isHoldMotionEnabled", "setHoldMotionEnabled", "isScrollEnabled", "setScrollEnabled", "isFlingEnabled", "setFlingEnabled", "isScaleEnabled", "setScaleEnabled", "isMultipleTapEnabled", "setMultipleTapEnabled", "mSync", "", "enabled", "isPalmRejectionEnabled", "setPalmRejectionEnabled", "close", "", "setGestureDetectorListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "onTouchEvent", "event", "Landroid/view/MotionEvent;", "isGesture", "isStroke", "isStrictDetection", "onDown", "e", "onShowPress", "onSingleTapUp", "onScroll", "e1", "e2", "distanceX", "distanceY", "onLongPress", "onHoldLongPress", "onHoldEvent", "onHoldCanceled", "onFling", "velocityX", "velocityY", "onScale", "detector", "onScaleByStabilization", "checkScaleConfirmed", ImageConst.ImageUpscaleConst.KEY_SCALE_FACTOR, "onScaleBegin", "onScaleEnd", "onSingleTapConfirmed", "onDoubleTap", "onMultipleTap", "tapCount", "", "onDoubleTapEvent", "setPalmRejectionThreshold", "threshold", "onPalmTouchBegin", "onPalmTouchEnd", "Listener", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenGestureDetector implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener, ScaleGestureDetector.OnScaleGestureListener, SpenHoldMotionDetector.OnHoldingMotionListener, SpenMultipleTapDetector.OnMultipleTapListener, SpenPalmDetector.Listener {

    @NotNull
    private static final String LOG_TAG = "SpenGestureDetector";
    private static final float LONG_PRESS_THRESHOLD = 17.0f;
    private static final float SCALE_CONFIRMED_THRESHOLD = 0.3f;
    private static final boolean SCALE_STABILIZATION = true;
    private static final float SINGLE_TAP_UP_THRESHOLD = 10.0f;
    private static final float VALID_SCROLL_LENGTH_THRESHOLD = 17.0f;
    private boolean isHoldMotionEnabled;
    private boolean isMultipleTapEnabled;
    private float mDensity;

    @Nullable
    private GestureDetector mGestureDetector;

    @Nullable
    private SpenHoldMotionDetector mHoldMotionDetector;
    private boolean mIsGesture;
    private boolean mIsLastTouchPointerUp;
    private boolean mIsPalmDetected;
    private boolean mIsScaleConfirmedCalled;
    private boolean mIsStroke;

    @Nullable
    private Listener mListener;

    @Nullable
    private SpenMultipleTapDetector mMultipleTapDetector;

    @Nullable
    private SpenPalmDetector mPalmDetector;
    private float mPreviousSpan;

    @Nullable
    private ScaleGestureDetector mScaleGestureDetector;
    private SpenScaleStabilizer mScaleStabilizer;

    @Nullable
    private Path mTouchPath = new Path();

    @Nullable
    private PathMeasure mTouchMeasure = new PathMeasure();
    private boolean mFirstScroll = true;
    private boolean mBlockScroll = true;

    @NotNull
    private PointF mTouchStartPosition = new PointF();

    @NotNull
    private final SpenGestureLowPassFilter mScrollLowPassFilterX = new SpenGestureLowPassFilter();

    @NotNull
    private final SpenGestureLowPassFilter mScrollLowPassFilterY = new SpenGestureLowPassFilter();
    private float mScaleRatioForConfirmed = 1.0f;
    private boolean isDoubleTapEnabled = true;
    private boolean isLongPressEnabled = true;
    private boolean isHoldLongPressEnabled = true;
    private boolean isScrollEnabled = true;
    private boolean isFlingEnabled = true;
    private boolean isScaleEnabled = true;

    @NotNull
    private final Object mSync = new Object();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H&J,\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH&J,\u0010\u0010\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000eH&J\u0012\u0010\u0013\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0014\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0015\u001a\u00020\tH&J \u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u000eH&J\b\u0010\u001a\u001a\u00020\tH&J\b\u0010\u001b\u001a\u00020\u0003H&J\b\u0010\u001c\u001a\u00020\tH&J\u001a\u0010\u001d\u001a\u00020\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001f\u001a\u00020 H&J\b\u0010!\u001a\u00020\tH&J\b\u0010\"\u001a\u00020\tH&¨\u0006#"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/view/gesture/detector/SpenGestureDetector$Listener;", "", "onSingleTapUp", "", "e", "Landroid/view/MotionEvent;", "onSingleTapConfirmed", "onDoubleTap", "onLongPress", "", "onScroll", "e1", "e2", "distanceX", "", "distanceY", "onFling", "velocityX", "velocityY", "onHoldLongPress", "onHoldEvent", "onHoldCanceled", "onScale", ImageConst.ImageUpscaleConst.KEY_SCALE_FACTOR, "focusX", "focusY", "onScaleConfirmed", "onScaleBegin", "onScaleEnd", "onMultipleTap", "event", "tapCount", "", "onPalmTouchBegin", "onPalmTouchEnd", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface Listener {
        boolean onDoubleTap(@NotNull MotionEvent e);

        boolean onFling(@Nullable MotionEvent e12, @Nullable MotionEvent e2, float velocityX, float velocityY);

        void onHoldCanceled();

        boolean onHoldEvent(@Nullable MotionEvent e);

        boolean onHoldLongPress(@Nullable MotionEvent e);

        void onLongPress(@NotNull MotionEvent e);

        void onMultipleTap(@Nullable MotionEvent event, int tapCount);

        void onPalmTouchBegin();

        void onPalmTouchEnd();

        boolean onScale(float scaleFactor, float focusX, float focusY);

        boolean onScaleBegin();

        void onScaleConfirmed();

        void onScaleEnd();

        boolean onScroll(@Nullable MotionEvent e12, @Nullable MotionEvent e2, float distanceX, float distanceY);

        boolean onSingleTapConfirmed(@NotNull MotionEvent e);

        boolean onSingleTapUp(@NotNull MotionEvent e);
    }

    public SpenGestureDetector(@Nullable Context context) {
        this.mDensity = 1.0f;
        Log.d(LOG_TAG, "[JavaGesture] Constructor");
        if (context == null) {
            return;
        }
        this.mGestureDetector = new GestureDetector(context, this);
        this.mDensity = context.getResources().getDisplayMetrics().density;
        ScaleGestureDetector scaleGestureDetector = new ScaleGestureDetector(context, this);
        this.mScaleGestureDetector = scaleGestureDetector;
        scaleGestureDetector.setQuickScaleEnabled(false);
        this.mHoldMotionDetector = new SpenHoldMotionDetector(context, this);
        this.mMultipleTapDetector = new SpenMultipleTapDetector(context, this);
        SpenPalmDetector spenPalmDetector = new SpenPalmDetector(context, this);
        this.mPalmDetector = spenPalmDetector;
        spenPalmDetector.construct();
        ScaleGestureDetector scaleGestureDetector2 = this.mScaleGestureDetector;
        if (scaleGestureDetector2 != null) {
            scaleGestureDetector2.setStylusScaleEnabled(false);
        }
        Object systemService = context.getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        ((WindowManager) systemService).getDefaultDisplay().getRealSize(new Point());
        this.mScaleStabilizer = new SpenScaleStabilizer(this.mDensity, (float) Math.hypot(r0.x, r0.y));
    }

    private final void checkScaleConfirmed(float scaleFactor) {
        if (this.mIsScaleConfirmedCalled || this.mListener == null) {
            return;
        }
        if (scaleFactor != 0.0f) {
            this.mScaleRatioForConfirmed *= scaleFactor;
        }
        if (Math.abs(this.mScaleRatioForConfirmed - 1.0f) > 0.30000001192092896d) {
            Listener listener = this.mListener;
            Intrinsics.checkNotNull(listener);
            listener.onScaleConfirmed();
            this.mIsScaleConfirmedCalled = true;
        }
    }

    private final boolean onScaleByStabilization(ScaleGestureDetector detector) {
        float focusX = detector.getFocusX();
        float focusY = detector.getFocusY();
        SpenScaleStabilizer.ScaleInfo scaleInfo = new SpenScaleStabilizer.ScaleInfo();
        scaleInfo.setSpan(detector.getCurrentSpan());
        scaleInfo.setPivotX(focusX);
        scaleInfo.setPivotY(focusY);
        SpenScaleStabilizer spenScaleStabilizer = this.mScaleStabilizer;
        if (spenScaleStabilizer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mScaleStabilizer");
            spenScaleStabilizer = null;
        }
        SpenScaleStabilizer.ScaleInfo scaleInfoStabilizeScaleInfo = spenScaleStabilizer.stabilizeScaleInfo(scaleInfo);
        float span = scaleInfoStabilizeScaleInfo.getSpan() / this.mPreviousSpan;
        this.mPreviousSpan = scaleInfoStabilizeScaleInfo.getSpan();
        float pivotX = scaleInfoStabilizeScaleInfo.getPivotX();
        float pivotY = scaleInfoStabilizeScaleInfo.getPivotY();
        checkScaleConfirmed(span);
        Listener listener = this.mListener;
        if (listener != null) {
            return listener.onScale(span, pivotX, pivotY);
        }
        return false;
    }

    public final void close() {
        Log.d(LOG_TAG, "[JavaGesture] Close");
        SpenPalmDetector spenPalmDetector = this.mPalmDetector;
        if (spenPalmDetector != null) {
            spenPalmDetector.close();
        }
        this.mPalmDetector = null;
        SpenMultipleTapDetector spenMultipleTapDetector = this.mMultipleTapDetector;
        if (spenMultipleTapDetector != null) {
            spenMultipleTapDetector.close();
        }
        this.mMultipleTapDetector = null;
        SpenHoldMotionDetector spenHoldMotionDetector = this.mHoldMotionDetector;
        if (spenHoldMotionDetector != null) {
            spenHoldMotionDetector.close();
        }
        this.mHoldMotionDetector = null;
        this.mScaleGestureDetector = null;
        this.mGestureDetector = null;
        this.mListener = null;
        this.mTouchMeasure = null;
        this.mTouchPath = null;
    }

    /* JADX INFO: renamed from: isDoubleTapEnabled, reason: from getter */
    public final boolean getIsDoubleTapEnabled() {
        return this.isDoubleTapEnabled;
    }

    /* JADX INFO: renamed from: isFlingEnabled, reason: from getter */
    public final boolean getIsFlingEnabled() {
        return this.isFlingEnabled;
    }

    /* JADX INFO: renamed from: isHoldLongPressEnabled, reason: from getter */
    public final boolean getIsHoldLongPressEnabled() {
        return this.isHoldLongPressEnabled;
    }

    /* JADX INFO: renamed from: isHoldMotionEnabled, reason: from getter */
    public final boolean getIsHoldMotionEnabled() {
        return this.isHoldMotionEnabled;
    }

    /* JADX INFO: renamed from: isLongPressEnabled, reason: from getter */
    public final boolean getIsLongPressEnabled() {
        return this.isLongPressEnabled;
    }

    /* JADX INFO: renamed from: isMultipleTapEnabled, reason: from getter */
    public final boolean getIsMultipleTapEnabled() {
        return this.isMultipleTapEnabled;
    }

    public final boolean isPalmRejectionEnabled() {
        SpenPalmDetector spenPalmDetector = this.mPalmDetector;
        if (spenPalmDetector != null) {
            return spenPalmDetector.getIsEnabled();
        }
        return false;
    }

    /* JADX INFO: renamed from: isScaleEnabled, reason: from getter */
    public final boolean getIsScaleEnabled() {
        return this.isScaleEnabled;
    }

    /* JADX INFO: renamed from: isScrollEnabled, reason: from getter */
    public final boolean getIsScrollEnabled() {
        return this.isScrollEnabled;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(@NotNull MotionEvent e) {
        Listener listener;
        Intrinsics.checkNotNullParameter(e, "e");
        if (!this.isDoubleTapEnabled || (listener = this.mListener) == null) {
            return false;
        }
        return listener.onDoubleTap(e);
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTapEvent(@NotNull MotionEvent e) {
        Intrinsics.checkNotNullParameter(e, "e");
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(@NotNull MotionEvent e) {
        Intrinsics.checkNotNullParameter(e, "e");
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(@Nullable MotionEvent e12, @NotNull MotionEvent e2, float velocityX, float velocityY) {
        Listener listener;
        Intrinsics.checkNotNullParameter(e2, "e2");
        if (!this.isFlingEnabled || !this.mIsGesture || this.mBlockScroll || (listener = this.mListener) == null) {
            return false;
        }
        return listener.onFling(e12, e2, velocityX, velocityY);
    }

    @Override // com.samsung.android.sdk.pen.view.gesture.detector.SpenHoldMotionDetector.OnHoldingMotionListener
    public void onHoldCanceled() {
        Listener listener;
        if (this.isHoldMotionEnabled && this.mIsStroke && (listener = this.mListener) != null) {
            listener.onHoldCanceled();
        }
    }

    @Override // com.samsung.android.sdk.pen.view.gesture.detector.SpenHoldMotionDetector.OnHoldingMotionListener
    public boolean onHoldEvent(@Nullable MotionEvent event) {
        Listener listener;
        if (event != null) {
            this.mTouchStartPosition = new PointF(event.getX(), event.getY());
            this.mBlockScroll = true;
        }
        if (this.isHoldMotionEnabled && this.mIsStroke && (listener = this.mListener) != null) {
            return listener.onHoldEvent(event);
        }
        return false;
    }

    @Override // com.samsung.android.sdk.pen.view.gesture.detector.SpenHoldMotionDetector.OnHoldingMotionListener
    public boolean onHoldLongPress(@Nullable MotionEvent event) {
        if (this.mListener != null && this.isHoldLongPressEnabled) {
            PathMeasure pathMeasure = this.mTouchMeasure;
            if (pathMeasure != null) {
                pathMeasure.setPath(this.mTouchPath, false);
            }
            float f = this.mDensity * 17.0f;
            PathMeasure pathMeasure2 = this.mTouchMeasure;
            Float fValueOf = pathMeasure2 != null ? Float.valueOf(pathMeasure2.getLength()) : null;
            Intrinsics.checkNotNull(fValueOf);
            if (fValueOf.floatValue() > f) {
                PathMeasure pathMeasure3 = this.mTouchMeasure;
                Log.d(LOG_TAG, "[JavaGesture] onHoldLongPress blocked by path length " + (pathMeasure3 != null ? Float.valueOf(pathMeasure3.getLength()) : null) + " is higher than " + f);
                return false;
            }
            PathMeasure pathMeasure4 = this.mTouchMeasure;
            Log.d(LOG_TAG, "[JavaGesture] onHoldLongPress path length " + (pathMeasure4 != null ? Float.valueOf(pathMeasure4.getLength()) : null) + " is lower than " + f);
            Listener listener = this.mListener;
            if (listener != null) {
                return listener.onHoldLongPress(event);
            }
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(@NotNull MotionEvent e) {
        Intrinsics.checkNotNullParameter(e, "e");
        if (this.mListener == null || !this.isLongPressEnabled) {
            return;
        }
        PathMeasure pathMeasure = this.mTouchMeasure;
        if (pathMeasure != null) {
            pathMeasure.setPath(this.mTouchPath, false);
        }
        float f = this.mDensity * 17.0f;
        PathMeasure pathMeasure2 = this.mTouchMeasure;
        Float fValueOf = pathMeasure2 != null ? Float.valueOf(pathMeasure2.getLength()) : null;
        Intrinsics.checkNotNull(fValueOf);
        if (fValueOf.floatValue() > f) {
            PathMeasure pathMeasure3 = this.mTouchMeasure;
            Log.d(LOG_TAG, "[JavaGesture] onLongPress blocked by path length " + (pathMeasure3 != null ? Float.valueOf(pathMeasure3.getLength()) : null) + " is higher than " + f);
            return;
        }
        PathMeasure pathMeasure4 = this.mTouchMeasure;
        Log.d(LOG_TAG, "[JavaGesture] onLongPress path length " + (pathMeasure4 != null ? Float.valueOf(pathMeasure4.getLength()) : null) + " is lower than " + f);
        Listener listener = this.mListener;
        if (listener != null) {
            listener.onLongPress(e);
        }
    }

    @Override // com.samsung.android.sdk.pen.view.gesture.detector.SpenMultipleTapDetector.OnMultipleTapListener
    public void onMultipleTap(@Nullable MotionEvent event, int tapCount) {
        Listener listener;
        if (!this.mIsGesture || (listener = this.mListener) == null) {
            return;
        }
        listener.onMultipleTap(event, tapCount);
    }

    @Override // com.samsung.android.sdk.pen.view.gesture.detector.SpenPalmDetector.Listener
    public void onPalmTouchBegin() {
        Listener listener = this.mListener;
        if (listener != null) {
            listener.onPalmTouchBegin();
        }
        this.mIsPalmDetected = true;
    }

    @Override // com.samsung.android.sdk.pen.view.gesture.detector.SpenPalmDetector.Listener
    public void onPalmTouchEnd() {
        Listener listener = this.mListener;
        if (listener != null) {
            listener.onPalmTouchEnd();
        }
        this.mIsPalmDetected = false;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScale(@NotNull ScaleGestureDetector detector) {
        Intrinsics.checkNotNullParameter(detector, "detector");
        if (this.mListener == null || !this.isScaleEnabled) {
            return false;
        }
        return onScaleByStabilization(detector);
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScaleBegin(@NotNull ScaleGestureDetector detector) {
        Intrinsics.checkNotNullParameter(detector, "detector");
        if (this.mListener == null || !this.isScaleEnabled) {
            return false;
        }
        this.mScaleRatioForConfirmed = 1.0f;
        this.mIsScaleConfirmedCalled = false;
        SpenScaleStabilizer.ScaleInfo scaleInfo = new SpenScaleStabilizer.ScaleInfo();
        scaleInfo.setSpan(detector.getCurrentSpan());
        scaleInfo.setPivotX(detector.getFocusX());
        scaleInfo.setPivotY(detector.getFocusY());
        SpenScaleStabilizer spenScaleStabilizer = this.mScaleStabilizer;
        SpenScaleStabilizer spenScaleStabilizer2 = null;
        if (spenScaleStabilizer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mScaleStabilizer");
            spenScaleStabilizer = null;
        }
        spenScaleStabilizer.reset(scaleInfo);
        SpenScaleStabilizer spenScaleStabilizer3 = this.mScaleStabilizer;
        if (spenScaleStabilizer3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mScaleStabilizer");
            spenScaleStabilizer3 = null;
        }
        spenScaleStabilizer3.stabilizeScaleInfo(scaleInfo);
        SpenScaleStabilizer spenScaleStabilizer4 = this.mScaleStabilizer;
        if (spenScaleStabilizer4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mScaleStabilizer");
        } else {
            spenScaleStabilizer2 = spenScaleStabilizer4;
        }
        this.mPreviousSpan = spenScaleStabilizer2.stabilizeScaleInfo(scaleInfo).getSpan();
        Listener listener = this.mListener;
        Intrinsics.checkNotNull(listener);
        return listener.onScaleBegin();
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public void onScaleEnd(@NotNull ScaleGestureDetector detector) {
        Listener listener;
        Intrinsics.checkNotNullParameter(detector, "detector");
        if (!this.isScaleEnabled || (listener = this.mListener) == null) {
            return;
        }
        listener.onScaleEnd();
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(@Nullable MotionEvent e12, @NotNull MotionEvent e2, float distanceX, float distanceY) {
        Intrinsics.checkNotNullParameter(e2, "e2");
        if (this.mListener != null && this.isScrollEnabled) {
            if (this.mBlockScroll && Math.hypot(e2.getX() - this.mTouchStartPosition.x, e2.getY() - this.mTouchStartPosition.y) > this.mDensity * 17.0f) {
                this.mBlockScroll = false;
            }
            if (this.mIsGesture && !this.mBlockScroll) {
                if (this.mFirstScroll) {
                    this.mScrollLowPassFilterX.reset(distanceX);
                    this.mScrollLowPassFilterY.reset(distanceY);
                    this.mFirstScroll = false;
                }
                float fCorrect = this.mScrollLowPassFilterX.correct(distanceX, 0.9f);
                float fCorrect2 = this.mScrollLowPassFilterY.correct(distanceY, 0.9f);
                Listener listener = this.mListener;
                if (listener != null) {
                    return listener.onScroll(e12, e2, fCorrect, fCorrect2);
                }
            }
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(@NotNull MotionEvent e) {
        Intrinsics.checkNotNullParameter(e, "e");
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(@NotNull MotionEvent e) {
        Intrinsics.checkNotNullParameter(e, "e");
        Listener listener = this.mListener;
        if (listener != null) {
            return listener.onSingleTapConfirmed(e);
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(@NotNull MotionEvent e) {
        Intrinsics.checkNotNullParameter(e, "e");
        if (this.mListener == null) {
            return false;
        }
        PathMeasure pathMeasure = this.mTouchMeasure;
        if (pathMeasure != null) {
            pathMeasure.setPath(this.mTouchPath, false);
        }
        float f = this.mDensity * 10.0f;
        PathMeasure pathMeasure2 = this.mTouchMeasure;
        Float fValueOf = pathMeasure2 != null ? Float.valueOf(pathMeasure2.getLength()) : null;
        Intrinsics.checkNotNull(fValueOf);
        if (fValueOf.floatValue() > f && this.mIsStroke) {
            PathMeasure pathMeasure3 = this.mTouchMeasure;
            Log.d(LOG_TAG, "[JavaGesture] onSingleTapUp blocked by mIsStroke && path length " + (pathMeasure3 != null ? Float.valueOf(pathMeasure3.getLength()) : null) + " is higher than " + f);
            return false;
        }
        PathMeasure pathMeasure4 = this.mTouchMeasure;
        Log.d(LOG_TAG, "[JavaGesture] onSingleTapUp path length " + (pathMeasure4 != null ? Float.valueOf(pathMeasure4.getLength()) : null) + " is lower than " + f + " || mIsStroke is false");
        Listener listener = this.mListener;
        if (listener != null) {
            return listener.onSingleTapUp(e);
        }
        return false;
    }

    public final boolean onTouchEvent(@NotNull MotionEvent event, boolean isGesture, boolean isStroke, boolean isStrictDetection) {
        boolean z;
        SpenMultipleTapDetector spenMultipleTapDetector;
        Path path;
        Intrinsics.checkNotNullParameter(event, "event");
        this.mIsGesture = isGesture;
        this.mIsStroke = isStroke;
        if (this.mIsLastTouchPointerUp) {
            this.mIsLastTouchPointerUp = false;
            this.mTouchStartPosition = new PointF(event.getX(), event.getY());
        }
        int action = event.getAction();
        if (action == 0) {
            Path path2 = this.mTouchPath;
            if (path2 != null) {
                path2.rewind();
            }
            Path path3 = this.mTouchPath;
            if (path3 != null) {
                path3.moveTo(event.getX(), event.getY());
            }
            this.mFirstScroll = true;
            this.mBlockScroll = true;
        } else if (action == 6) {
            this.mIsLastTouchPointerUp = true;
        }
        if (isStrictDetection && (path = this.mTouchPath) != null) {
            path.lineTo(event.getX(), event.getY());
        }
        SpenPalmDetector spenPalmDetector = this.mPalmDetector;
        if (spenPalmDetector != null) {
            spenPalmDetector.onTouchEvent(event);
        }
        boolean z2 = this.mIsPalmDetected;
        if (z2) {
            AbstractC4539a.m3208r("Palm touch detected skip other gestures. mIsPalmDetected = ", LOG_TAG, z2);
            return false;
        }
        synchronized (this.mSync) {
            try {
                GestureDetector gestureDetector = this.mGestureDetector;
                z = gestureDetector != null && gestureDetector.onTouchEvent(event);
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
        ScaleGestureDetector scaleGestureDetector = this.mScaleGestureDetector;
        boolean z3 = (scaleGestureDetector != null && scaleGestureDetector.onTouchEvent(event)) || z;
        SpenHoldMotionDetector spenHoldMotionDetector = this.mHoldMotionDetector;
        if (spenHoldMotionDetector != null) {
            spenHoldMotionDetector.onTouchEvent(event);
        }
        if (isGesture && this.isMultipleTapEnabled && event.getPointerCount() == 1 && (spenMultipleTapDetector = this.mMultipleTapDetector) != null) {
            spenMultipleTapDetector.onTouchEvent(event);
        }
        return z3;
    }

    public final void setDoubleTapEnabled(boolean z) {
        this.isDoubleTapEnabled = z;
    }

    public final void setFlingEnabled(boolean z) {
        this.isFlingEnabled = z;
    }

    public final void setGestureDetectorListener(@Nullable Listener listener) {
        this.mListener = listener;
    }

    public final void setHoldLongPressEnabled(boolean z) {
        this.isHoldLongPressEnabled = z;
    }

    public final void setHoldMotionEnabled(boolean z) {
        this.isHoldMotionEnabled = z;
    }

    public final void setLongPressEnabled(boolean z) {
        this.isLongPressEnabled = z;
    }

    public final void setMultipleTapEnabled(boolean z) {
        this.isMultipleTapEnabled = z;
    }

    public final void setPalmRejectionEnabled(boolean z) {
        this.mIsPalmDetected = false;
        SpenPalmDetector spenPalmDetector = this.mPalmDetector;
        if (spenPalmDetector != null) {
            spenPalmDetector.setEnabled(z);
        }
    }

    public final void setPalmRejectionThreshold(float threshold) {
        SpenPalmDetector spenPalmDetector = this.mPalmDetector;
        if (spenPalmDetector != null) {
            spenPalmDetector.setPalmThreshold(threshold);
        }
    }

    public final void setScaleEnabled(boolean z) {
        this.isScaleEnabled = z;
    }

    public final void setScrollEnabled(boolean z) {
        this.isScrollEnabled = z;
    }
}
