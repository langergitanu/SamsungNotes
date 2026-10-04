package com.samsung.android.sdk.pen.view.gesture.detector;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.RectF;
import android.os.Handler;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p066P2.RunnableC0202d;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 -2\u00020\u0001:\u0002,-B\u001d\b\u0000\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010 \u001a\u00020!J\u000e\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020$J\b\u0010%\u001a\u00020!H\u0002J\u0018\u0010&\u001a\u00020!2\u0006\u0010'\u001a\u00020\n2\u0006\u0010(\u001a\u00020\nH\u0002J \u0010)\u001a\u00020!2\u0006\u0010#\u001a\u00020$2\u0006\u0010*\u001a\u00020\f2\u0006\u0010+\u001a\u00020\u0011H\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u000e\u0010\u0019\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006."}, m13886d2 = {"Lcom/samsung/android/sdk/pen/view/gesture/detector/SpenHoldMotionDetector;", "", "context", "Landroid/content/Context;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/sdk/pen/view/gesture/detector/SpenHoldMotionDetector$OnHoldingMotionListener;", "<init>", "(Landroid/content/Context;Lcom/samsung/android/sdk/pen/view/gesture/detector/SpenHoldMotionDetector$OnHoldingMotionListener;)V", "mContext", "detectionAreaLength", "", "mIsWaiting", "", "mOnHoldCalled", "mOnHoldLongPressCalled", "mOnHoldLongPressChecked", "responseTime", "", "getResponseTime", "()I", "setResponseTime", "(I)V", "holdLongPressResponseTime", "getHoldLongPressResponseTime", "setHoldLongPressResponseTime", "mEasyModeAppliedHoldLongPressResponseTime", "mListener", "mDetectionRegion", "Landroid/graphics/RectF;", "mCancelRegion", "mHandler", "Landroid/os/Handler;", "close", "", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "checkHoldLongPressTimeForEasyMode", "reset", "x", "y", "schedule", "isHoldLongPress", "timeInMillis", "OnHoldingMotionListener", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenHoldMotionDetector {
    private static final int EASY_MODE_HOLD_LONG_PRESS_TIME_MARGIN = 50;

    @NotNull
    private static final String LOG_TAG = "SpenHoldMotionDetector";
    private static final float LONG_PRESS_SIZE_THRESHOLD = 8.0f;
    private final float detectionAreaLength;

    @Nullable
    private RectF mCancelRegion;

    @Nullable
    private Context mContext;

    @Nullable
    private RectF mDetectionRegion;

    @Nullable
    private Handler mHandler;
    private boolean mIsWaiting;

    @Nullable
    private OnHoldingMotionListener mListener;
    private boolean mOnHoldCalled;
    private boolean mOnHoldLongPressCalled;
    private boolean mOnHoldLongPressChecked;
    private int responseTime = 500;
    private int holdLongPressResponseTime = 1000;
    private int mEasyModeAppliedHoldLongPressResponseTime = 1000;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/view/gesture/detector/SpenHoldMotionDetector$OnHoldingMotionListener;", "", "onHoldLongPress", "", "event", "Landroid/view/MotionEvent;", "onHoldEvent", "onHoldCanceled", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnHoldingMotionListener {
        void onHoldCanceled();

        boolean onHoldEvent(@Nullable MotionEvent event);

        boolean onHoldLongPress(@Nullable MotionEvent event);
    }

    public SpenHoldMotionDetector(@Nullable Context context, @Nullable OnHoldingMotionListener onHoldingMotionListener) {
        Resources resources;
        DisplayMetrics displayMetrics;
        this.mContext = context;
        this.mListener = onHoldingMotionListener;
        Float fValueOf = (context == null || (resources = context.getResources()) == null || (displayMetrics = resources.getDisplayMetrics()) == null) ? null : Float.valueOf(displayMetrics.density);
        Intrinsics.checkNotNull(fValueOf);
        this.detectionAreaLength = fValueOf.floatValue() * 8.0f;
        this.mHandler = new Handler();
    }

    private final void checkHoldLongPressTimeForEasyMode() {
        Context context = this.mContext;
        int i = Settings.Secure.getInt(context != null ? context.getContentResolver() : null, "long_press_timeout", this.holdLongPressResponseTime);
        int i2 = this.holdLongPressResponseTime;
        if (i >= i2) {
            i2 = i + 50;
        }
        this.mEasyModeAppliedHoldLongPressResponseTime = i2;
    }

    private final void reset(float x, float y2) {
        OnHoldingMotionListener onHoldingMotionListener;
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        float f = this.detectionAreaLength;
        this.mDetectionRegion = new RectF(x - f, y2 - f, x + f, f + y2);
        float f4 = this.detectionAreaLength;
        float f5 = 2;
        this.mCancelRegion = new RectF(x - (f4 * f5), y2 - (f4 * f5), (f4 * f5) + x, (f4 * f5) + y2);
        if (this.mOnHoldCalled && (onHoldingMotionListener = this.mListener) != null) {
            onHoldingMotionListener.onHoldCanceled();
        }
        this.mOnHoldCalled = false;
        this.mIsWaiting = false;
    }

    private final void schedule(MotionEvent event, boolean isHoldLongPress, int timeInMillis) {
        RunnableC0202d runnableC0202d = new RunnableC0202d(isHoldLongPress, this, event, 12);
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        Handler handler2 = this.mHandler;
        if (handler2 != null) {
            handler2.postDelayed(runnableC0202d, timeInMillis);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void schedule$lambda$0(boolean z, SpenHoldMotionDetector spenHoldMotionDetector, MotionEvent motionEvent) {
        if (z) {
            spenHoldMotionDetector.mOnHoldLongPressCalled = true;
            OnHoldingMotionListener onHoldingMotionListener = spenHoldMotionDetector.mListener;
            if (onHoldingMotionListener != null) {
                onHoldingMotionListener.onHoldLongPress(motionEvent);
                return;
            }
            return;
        }
        spenHoldMotionDetector.mOnHoldCalled = true;
        OnHoldingMotionListener onHoldingMotionListener2 = spenHoldMotionDetector.mListener;
        if (onHoldingMotionListener2 != null) {
            onHoldingMotionListener2.onHoldEvent(motionEvent);
        }
    }

    public final void close() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.mHandler = null;
        this.mListener = null;
        this.mContext = null;
    }

    public final int getHoldLongPressResponseTime() {
        return this.holdLongPressResponseTime;
    }

    public final int getResponseTime() {
        return this.responseTime;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onTouchEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        float x = event.getX();
        float y2 = event.getY();
        if (event.getAction() == 1 || event.getAction() == 3) {
            this.mOnHoldCalled = false;
            this.mOnHoldLongPressCalled = false;
            this.mOnHoldLongPressChecked = false;
            reset(x, y2);
            return;
        }
        if (this.mOnHoldLongPressCalled) {
            return;
        }
        if (event.getAction() == 0) {
            checkHoldLongPressTimeForEasyMode();
            reset(x, y2);
            this.mOnHoldLongPressCalled = false;
            this.mOnHoldLongPressChecked = false;
        }
        RectF rectF = this.mDetectionRegion;
        if (rectF == null || this.mCancelRegion == null) {
            this.mOnHoldLongPressChecked = true;
            reset(x, y2);
        } else if (!this.mOnHoldCalled) {
            Intrinsics.checkNotNull(rectF);
            if (rectF.contains(x, y2)) {
                if (this.mOnHoldCalled) {
                    RectF rectF2 = this.mCancelRegion;
                    Intrinsics.checkNotNull(rectF2);
                    if (!rectF2.contains(x, y2)) {
                    }
                }
            }
        }
        if (this.mIsWaiting) {
            return;
        }
        if (this.mOnHoldLongPressChecked) {
            schedule(event, false, this.responseTime);
        } else {
            schedule(event, true, this.mEasyModeAppliedHoldLongPressResponseTime);
        }
        this.mIsWaiting = true;
    }

    public final void setHoldLongPressResponseTime(int i) {
        this.holdLongPressResponseTime = i;
    }

    public final void setResponseTime(int i) {
        this.responseTime = i;
    }
}
