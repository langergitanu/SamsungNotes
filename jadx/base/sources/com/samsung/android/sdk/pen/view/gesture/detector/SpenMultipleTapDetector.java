package com.samsung.android.sdk.pen.view.gesture.detector;

import android.content.Context;
import android.os.Handler;
import android.view.MotionEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p188i3.RunnableC12034a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000  2\u00020\u0001:\u0002\u001f B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001cJ\u0012\u0010\u001d\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J\b\u0010\u001e\u001a\u00020\u0019H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/view/gesture/detector/SpenMultipleTapDetector;", "", "context", "Landroid/content/Context;", "mListener", "Lcom/samsung/android/sdk/pen/view/gesture/detector/SpenMultipleTapDetector$OnMultipleTapListener;", "<init>", "(Landroid/content/Context;Lcom/samsung/android/sdk/pen/view/gesture/detector/SpenMultipleTapDetector$OnMultipleTapListener;)V", "detectionAreaLength", "", "responseTime", "", "getResponseTime", "()I", "setResponseTime", "(I)V", "maxTap", "getMaxTap", "setMaxTap", "mHandler", "Landroid/os/Handler;", "mTapCount", "mPrevX", "mPrevY", "close", "", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "onMultipleTap", "cancel", "OnMultipleTapListener", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenMultipleTapDetector {
    private static final int DEFAULT_MAX_TAP = 5;
    private static final float MULTIPLE_TAP_SIZE_THRESHOLD = 30.0f;
    private float detectionAreaLength;

    @Nullable
    private OnMultipleTapListener mListener;
    private float mPrevX;
    private float mPrevY;
    private int mTapCount;
    private int responseTime = 300;
    private int maxTap = 5;

    @Nullable
    private Handler mHandler = new Handler();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/view/gesture/detector/SpenMultipleTapDetector$OnMultipleTapListener;", "", "onMultipleTap", "", "event", "Landroid/view/MotionEvent;", "tapCount", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnMultipleTapListener {
        void onMultipleTap(@Nullable MotionEvent event, int tapCount);
    }

    public SpenMultipleTapDetector(@Nullable Context context, @Nullable OnMultipleTapListener onMultipleTapListener) {
        this.mListener = onMultipleTapListener;
        if (context != null) {
            this.detectionAreaLength = context.getResources().getDisplayMetrics().density * MULTIPLE_TAP_SIZE_THRESHOLD;
        }
    }

    private final void cancel() {
        RunnableC12034a runnableC12034a = new RunnableC12034a(this, 2);
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        Handler handler2 = this.mHandler;
        if (handler2 != null) {
            handler2.postDelayed(runnableC12034a, this.responseTime);
        }
    }

    private final void onMultipleTap(MotionEvent event) {
        OnMultipleTapListener onMultipleTapListener;
        int i = this.mTapCount + 1;
        this.mTapCount = i;
        int i2 = this.maxTap;
        if (2 <= i && i <= i2 && (onMultipleTapListener = this.mListener) != null) {
            onMultipleTapListener.onMultipleTap(event, i);
        }
        cancel();
    }

    public final void close() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.mHandler = null;
        this.mListener = null;
    }

    public final int getMaxTap() {
        return this.maxTap;
    }

    public final int getResponseTime() {
        return this.responseTime;
    }

    public final void onTouchEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        float x = event.getX();
        float y2 = event.getY();
        int action = event.getAction();
        if (action != 0) {
            if (action != 1) {
                return;
            }
            this.mPrevX = x;
            this.mPrevY = y2;
            return;
        }
        if (this.mTapCount == 0) {
            this.mPrevX = x;
            this.mPrevY = y2;
        }
        if (((float) Math.hypot(this.mPrevX - x, this.mPrevY - y2)) < this.detectionAreaLength) {
            onMultipleTap(event);
        } else {
            this.mTapCount = 0;
        }
    }

    public final void setMaxTap(int i) {
        this.maxTap = i;
    }

    public final void setResponseTime(int i) {
        this.responseTime = i;
    }
}
